package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.enums.YunOperationEnum;
import com.rainasmoon.onepay.enums.YunStatus;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.util.CommonUtils;
import com.rainasmoon.onepay.util.EncodeUtils;
import com.rainasmoon.onepay.vo.AddYunOrderVo;
import com.rainasmoon.onepay.vo.YunOrderVo;

@Controller
public class MarketController extends BaseController {

	@Autowired
	private YunOrderService yunOrderService;

	@Autowired
	private UserService userService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/market.html" }, method = RequestMethod.GET)
	public String market(Map<String, Object> model) {
		List<YunOrder> yunOrders = yunOrderService.findAll();
		List<YunOrderVo> yunOrderVos = new ArrayList<YunOrderVo>();
		for (YunOrder yunOrder : yunOrders) {
			YunOrderVo yunOrderVo = dozerBeanMapper.map(yunOrder, YunOrderVo.class);
			User user = userService.findUser(yunOrderVo.getUserId());
			yunOrderVo.setUserName(user.getShowName());
			yunOrderVo.setUserLevelName(CommonUtils.getUserLevel(user.getLevel()));
			yunOrderVo.setUserCredit(user.getCredit());
			yunOrderVo.setStatus(yunOrder.getStatus());
			yunOrderVo.setOperation(transferToOperation(yunOrder));

			if (yunOrderVo.getDealerId() != null) {
				User dealer = userService.findUser(yunOrderVo.getDealerId());
				yunOrderVo.setDealerName(dealer.getShowName());
			}

			yunOrderVos.add(yunOrderVo);
		}
		model.put("yunOrders", yunOrderVos);
		return "market";
	}

	private YunOperationEnum transferToOperation(YunOrder yunOrder) {
		if (getLoginUserId() != null) {
			if (getLoginUserId().equals(yunOrder.getUserId()) && yunOrder.isBuy()) {
				return YunStatus.getUserCallOperation(YunStatus.valueOf(yunOrder.getStatus()));
			}
			if (getLoginUserId().equals(yunOrder.getDealerId()) && yunOrder.isBuy()) {
				return YunStatus.getDealerCallOperation(YunStatus.valueOf(yunOrder.getStatus()));
			}
			if (getLoginUserId().equals(yunOrder.getUserId()) && yunOrder.isSell()) {
				return YunStatus.getUserPutOperation(YunStatus.valueOf(yunOrder.getStatus()));
			}
			if (getLoginUserId().equals(yunOrder.getDealerId()) && yunOrder.isSell()) {
				return YunStatus.getDealerPutOperation(YunStatus.valueOf(yunOrder.getStatus()));
			}
		}
		if (yunOrder.isBuy()) {
			return YunStatus.getOtherCallOperation(YunStatus.valueOf(yunOrder.getStatus()));
		}
		return YunStatus.getOtherPutOperation(YunStatus.valueOf(yunOrder.getStatus()));

	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.GET)
	public String showAddMarketInfo(Long orderId, Map<String, Object> model) {

		if (!isLogin()) {
			return "redirect:login.html";
		}

		model.put("yunOrder", new AddYunOrderVo());
		return "market_add_info";
	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.POST)
	public String addMarketInfo(AddYunOrderVo addYunOrderVo, BindingResult result, Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}

		if (addYunOrderVo.getAmount() == null || addYunOrderVo.getAmount() <= 0) {
			result.rejectValue("amount", "NotEmpty.loginVo.account");
		}
		
		if (addYunOrderVo.getPrice() == null || addYunOrderVo.getPrice() <= 0) {
			result.rejectValue("price", "NotEmpty.loginVo.account");
		}
		
		if (result.hasErrors()) {
			LOGGER.warn("Login has error.");
			return "market_add_info";
		}
		
		YunOrder yunOrder = new YunOrder();
		yunOrder.setUserId(getLoginUserId());
		yunOrder.setAmount(addYunOrderVo.getAmount());
		yunOrder.setPrice(addYunOrderVo.getPrice());
		yunOrder.setDescription(addYunOrderVo.getDescription());
		yunOrder.setModel("buy".equalsIgnoreCase(addYunOrderVo.getTradeModel()) ? 1 : 2);
		yunOrder.setStatus(YunStatus.DOWN.getCode());

		String message = yunOrderService.addYunOrder(yunOrder);
		model.put("message", message);
		return "market_add_info_success";
	}

	@RequestMapping(value = { "/market_buy.html" }, method = RequestMethod.GET)
	public String showBuyForm(Long yunOrderId, Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}
		YunOrder yunOrder = yunOrderService.findYunOrder(yunOrderId);
		model.put("yunOrderId", yunOrderId);
		model.put("amount", yunOrder.getAmount());
		model.put("price", yunOrder.getPrice());
		return "market_buy";
	}

	@RequestMapping(value = { "/market_buy.html" }, method = RequestMethod.POST)
	public String buyYunOrder(Long yunOrderId, Map<String, Object> model) {
		String message = yunOrderService.executeYunOrder(getLoginUserId(), yunOrderId);
		model.put("message", message);
		return "market_buy_success";
	}

	@RequestMapping(value = { "/market_sell.html" }, method = RequestMethod.GET)
	public String showSellForm(Long yunOrderId, Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}
		User loginUser = userService.findUser(getLoginUserId());
		YunOrder yunOrder = yunOrderService.findYunOrder(yunOrderId);
		model.put("yunOrderId", yunOrderId);
		model.put("amount", yunOrder.getAmount());
		model.put("account", loginUser.getAccount());
		model.put("price", yunOrder.getPrice());
		return "market_sell";
	}

	@RequestMapping(value = { "/market_sell.html" }, method = RequestMethod.POST)
	public String sellYunOrder(Long yunOrderId, Map<String, Object> model) {
		String message = yunOrderService.executeYunOrder(getLoginUserId(), yunOrderId);
		model.put("message", message);
		return "market_sell_success";
	}

	@RequestMapping(value = { "/market_unfreeze.html" }, method = RequestMethod.GET)
	public String showUnfreezeForm(Long yunOrderId, Map<String, Object> model) {

		model.put("yunOrderId", yunOrderId);
		return "market_unfreeze";
	}

	@RequestMapping(value = { "/market_unfreeze.html" }, method = RequestMethod.POST)
	public String unfreezeYunOrder(Long yunOrderId, String unfreezeCode, Map<String, Object> model) {
		Map<String, String> result = EncodeUtils.decryptToMap(unfreezeCode);
		if (result == null) {
			model.put("message", "请核实验证码");
			return "market_unfreeze_success";
		}
		if (result.get("function").equalsIgnoreCase("O") && Long.parseLong(result.get("value")) == yunOrderId) {
			String message = yunOrderService.unfreezeYunOrder(getLoginUserId(), yunOrderId);
			model.put("message", message);
		} else {
			model.put("message", "验证失败");
		}

		return "market_unfreeze_success";
	}

	@RequestMapping(value = { "/market_view_trade.html" }, method = RequestMethod.GET)
	public String viewTrade(Long yunOrderId, Map<String, Object> model) {
		String freezeCode = EncodeUtils.encrypt("O", yunOrderId.toString());
		model.put("yunOrderId", yunOrderId);
		model.put("freezeCode", freezeCode);
		return "market_view_trade";
	}

}
