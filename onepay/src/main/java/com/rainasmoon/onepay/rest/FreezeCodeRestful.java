package com.rainasmoon.onepay.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.service.AccountService;
import com.rainasmoon.onepay.service.YunOrderService;
import com.rainasmoon.onepay.service.dto.TransferResult;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.FreezeCodeUtils;
import com.rainasmoon.onepay.web.BaseController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class FreezeCodeRestful extends BaseController {

	@Autowired
	private YunOrderService yunOrderService;

	@Autowired
	private AccountService accountService;

	@RequestMapping("restful/verifyFreezeCode")
	public String verifyFreezeCode(@RequestParam(value = "freezeCode") String freezeCode) {
		if (getLoginUserId() == null) {
			return CommonConstants.NO_LOGIN_MSG;
		}

		Map<String, String> result = FreezeCodeUtils.decryptToMap(freezeCode);
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
}
