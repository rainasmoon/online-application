package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainasmoon.onepay.model.YunOrder;
import com.rainasmoon.onepay.vo.YunOrderVo;

@Controller
public class MarketController extends BaseController {

	@RequestMapping(value = { "/market.html" }, method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
		List<YunOrderVo> yunOrders = new ArrayList<YunOrderVo>();
		model.put("yunOrders", yunOrders);
		return "market";
	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.GET)
	public String showAddMarketInfo(Long orderId, Map<String, Object> model) {

		model.put("yunOrder", new YunOrder());
		return "market_add_info";
	}

	@RequestMapping(value = { "/market_add_info.html" }, method = RequestMethod.POST)
	public String addMarketInfo(YunOrderVo yunOrderVo, Map<String, Object> model) {
		model.put("message", "");
		return "market_add_info_success";
	}
}
