package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.vo.AddYunOrderVo;
import com.rainasmoon.onepay.vo.YunOrderVo;

@Controller
public class MarketController extends BaseController {

	@Autowired
	private YunOrderService yunOrderService;

	@Autowired
	private Mapper dozerBeanMapper;

	@RequestMapping(value = { "/market.html" }, method = RequestMethod.GET)
	public String market(Map<String, Object> model) {
		List<YunOrder> yunOrders = yunOrderService.findAll();
		List<YunOrderVo> yunOrderVos = new ArrayList<YunOrderVo>();
		for (YunOrder yunOrder : yunOrders) {
			YunOrderVo yunOrderVo = dozerBeanMapper.map(yunOrder,
					YunOrderVo.class);
			yunOrderVos.add(yunOrderVo);
		}
		model.put("yunOrders", yunOrderVos);
		return "market";
	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.GET)
	public String showAddMarketInfo(Long orderId, Map<String, Object> model) {

		model.put("yunOrder", new AddYunOrderVo());
		return "market_add_info";
	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.POST)
	public String addMarketInfo(@Valid AddYunOrderVo addYunOrderVo,
			BindingResult result, Map<String, Object> model) {
		YunOrder yunOrder = new YunOrder();
		yunOrder.setUserId(getLoginUserId());
		yunOrder.setAmount(addYunOrderVo.getAmount());
		yunOrder.setPrice(addYunOrderVo.getPrice());
		yunOrder.setDescription(addYunOrderVo.getDescription());
		yunOrder.setModel("buy".equalsIgnoreCase(addYunOrderVo.getTradeModel()) ? 1
				: 2);
		yunOrderService.addYunOrder(yunOrder);
		model.put("message", "");
		return "market_add_info_success";
	}
}
