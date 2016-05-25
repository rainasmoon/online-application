package com.rainasmoon.onepay.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.OrderStatus;
import com.rainasmoon.onepay.model.Order;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.NoticeService;
import com.rainasmoon.onepay.util.EmailUtils;
import com.rainasmoon.onepay.util.MessageUtils;

@Service
public class NoticeServiceImpl implements NoticeService {

	Logger LOGGER = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void makeOrderNotice(Order order) {
		Long buyerId = order.getBuyerId();
		Long salerId = order.getSalerId();
		Product product = productRepository.findOne(order.getProductId());
		OrderStatus enumStatus = OrderStatus.valueOf(order.getStatus());

		User buyer = userRepository.findOne(buyerId);
		if (StringUtils.isNotBlank(buyer.getEmail())) {
			String title = "【一元网】-【" + product.getName() + "】-【" + enumStatus.getName() + "】";
			String content = "【" + product.getName() + "】现状态为【" + enumStatus.getName() + "】，请访问：http://www.rainasmoon.com/";
			String to = buyer.getEmail();
			EmailUtils.sendEmail(title, content, to);
		}

		if (StringUtils.isNotBlank(buyer.getPhone())) {
			new MessageUtils().sendNotice(buyer.getPhone(), product.getName(), enumStatus.getName());
		}

		User saler = userRepository.findOne(salerId);
		if (StringUtils.isNotBlank(saler.getEmail())) {
			String title = "【一元网】-【" + product.getName() + "】-【" + enumStatus.getName() + "】";
			String content = "【" + product.getName() + "】现状态为【" + enumStatus.getName() + "】，请访问：http://www.rainasmoon.com/";
			String to = saler.getEmail();
			EmailUtils.sendEmail(title, content, to);
		}

		if (StringUtils.isNotBlank(saler.getPhone())) {
			new MessageUtils().sendNotice(saler.getPhone(), product.getName(), enumStatus.getName());
		}

	}

}
