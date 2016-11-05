package com.rainasmoon.onepay.rest;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.service.dto.TransferResult;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.EncodeUtils;
import com.rainasmoon.onepay.util.MessageUtils;
import com.rainasmoon.onepay.util.VerifyCodeUtils;
import com.rainasmoon.onepay.web.BaseController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class FreezeCodeRestful extends BaseController {

	@Autowired
	private YunOrderService yunOrderService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@RequestMapping("restful/verifyFreezeCode")
	public String verifyFreezeCode(@RequestParam(value = "freezeCode") String freezeCode) {
		if (getLoginUserId() == null) {
			return CommonConstants.NO_LOGIN_MSG;
		}

		if (StringUtils.isBlank(freezeCode) || freezeCode.length() > 100) {
			return "验证码为空或太长";
		}

		Map<String, String> result = EncodeUtils.decryptToMap(freezeCode);
		if (result == null) {
			return "请核实验证码";
		}

		if (result.get("function").equalsIgnoreCase("O")) {
			Long yunOrderId = Long.parseLong(result.get("value"));
			YunOrder yunOrder = yunOrderService.findYunOrder(yunOrderId);
			if (yunOrder.isBuy() && getLoginUserId().equals(yunOrder.getUserId())) {
				return yunOrderService.unfreezeYunOrder(getLoginUserId(), yunOrderId);
			} else if (yunOrder.isSell() && getLoginUserId().equals(yunOrder.getDealerId())) {
				return yunOrderService.unfreezeYunOrder(getLoginUserId(), yunOrderId);
			} else {
				return "此验证码无法使用";
			}

		} else if (result.get("function").equalsIgnoreCase("N")) {
			TransferResult transferResult = accountService.addAccount(getLoginUserId(), Integer.parseInt(result.get("value")));
			return transferResult.getMessage();
		} else {
			return "此验证码无法使用";
		}
	}

	@RequestMapping("restful/sendVerifyPhone")
	public String sendVerifyPhone() {
		User user = userService.findUser(getLoginUserId());
		if (user != null && StringUtils.isNotBlank(user.getPhone())) {

			String code = VerifyCodeUtils.generateVerifyCode(user.getPhone());
			boolean result = new MessageUtils().sendVerifyCode(user.getPhone(), user.getShowName(), code);
			if (result) {
				VerifyCodeUtils.put(user.getPhone(), code);
			} else {
				return "发送失败";
			}
		}
		return "发送成功";
	}

	@RequestMapping("restful/verifyPhoneCode")
	public String verifyPhoneCode(@RequestParam(value = "phoneCode") String phoneCode) {

		if (StringUtils.isBlank(phoneCode)) {
			return "验证码不能为空";
		}

		User user = userService.findUser(getLoginUserId());
		if (VerifyCodeUtils.verify(user.getPhone(), phoneCode)) {
			String message = userService.verifyPhone(getLoginUserId());
			return message;
		} else {
			return "验证失败";
		}

	}
}
