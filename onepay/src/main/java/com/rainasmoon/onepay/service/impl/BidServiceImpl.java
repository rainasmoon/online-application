package com.rainasmoon.onepay.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.ProductStatus;
import com.rainasmoon.onepay.enums.SaleModels;
import com.rainasmoon.onepay.model.BidLog;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.repository.springdatajpa.BidLogRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.BidService;
import com.rainasmoon.onepay.service.OrderService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.vo.BidRefreshVo;

@Service
public class BidServiceImpl implements BidService {

	Logger LOGGER = LoggerFactory.getLogger(BidServiceImpl.class);

	@Autowired
	private BidLogRepository repository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Override
	public String bidAddMoney(Long userId, Long productId, Integer addMoney) {
		Product product = productRepository.findOne(productId);

		if (!product.isOnSale()) {
			return "下架了";
		}

		product.addPrice(addMoney);
		product.setCurrentBiderId(userId);
		productRepository.save(product);

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		repository.save(bidLog);

		return product.getPrice().toString();
	}

	@Override
	public String guessMoney(Long userId, Long productId, Integer money) {
		Product product = productRepository.findOne(productId);

		if (!product.isOnSale()) {
			return "下架了";
		}

		if (hasOneBidLog(userId, productId, new Date())) {
			return "猜过了，明天再来试试？";
		}
		boolean result = false;
		if (money >= product.getOriginalPrice()) {
			product.setPrice(money);
			product.setCurrentBiderId(userId);
			product.setStatus(ProductStatus.DEAL.getCode());

			productRepository.save(product);
			orderService.createOrder(userId, productId, money);

			result = true;
		}

		BidLog bidLog = new BidLog();
		bidLog.setUserId(userId);
		bidLog.setProductId(productId);
		bidLog.setPrice(product.getPrice());
		repository.save(bidLog);

		return result ? "成交了" : "太低了，不卖";
	}

	private boolean hasOneBidLog(Long userId, Long productId, Date date) {
		DateFormat sf = new SimpleDateFormat("yyyyMMdd");
		DateFormat sfFull = new SimpleDateFormat("yyyyMMddhhmmss");

		List<BidLog> result = null;
		try {
			result = repository.findBidLogOnDate(userId, productId, sfFull.parse(sf.format(new Date()) + "000000"), sfFull.parse(sf.format(new Date()) + "235959"));
		} catch (ParseException e) {
			LOGGER.info("parase date exception. wired.", e);
		}
		return result == null ? false : (result.size() > 0 ? true : false);
	}

	@Override
	public String generateBidThreeDays() {
		// 查询onsale商品, 如果当前时间大于 enddate. then
		List<Product> products = productRepository.findEndDateAndStatusProduct(SaleModels.THREEDAYSALE.getCode(), ProductStatus.ONSALE.getCode(), new Date());

		// if exist bidlog then set product status to deal and create a order.
		for (Product product : products) {
			List<BidLog> bidLogs = repository.findByProductIdOrderByCreateDateDesc(product.getId());
			if (bidLogs != null && bidLogs.size() > 0) {
				makeDeal(product, bidLogs.get(0));
			} else {
				product.setStatus(ProductStatus.FAIL.getCode());
				productRepository.save(product);
			}
		}
		// if not exist bidlog then set product status to fail
		return "done";
	}

	@Override
	public String generateBidThreeTimes() {
		// select onsale product & salemodel is normal;
		List<Product> products = productRepository.findBySaleModelAndStatus(SaleModels.NORMALAUCTION.getCode(), ProductStatus.ONSALE.getCode());
		Date now = new Date();
		Date theDayBefore = new Date(now.getTime() - CommonConstants.THREE_DAYS);

		// 查询最近一条bidlog.如果在三天前，则成交，
		for (Product product : products) {
			List<BidLog> bidLogs = repository.findByProductIdOrderByCreateDateDesc(product.getId());
			if (bidLogs.size() > 0 && bidLogs.get(0).getCreateDate().before(theDayBefore)) {
				makeDeal(product, bidLogs.get(0));
			}
		}
		return "done";
	}

	private void makeDeal(Product product, BidLog bidLog) {
		product.setStatus(ProductStatus.DEAL.getCode());

		productRepository.save(product);
		orderService.createOrder(bidLog.getUserId(), product.getId(), bidLog.getPrice());
	}

	@Override
	public BidRefreshVo getBidRefreshVo(Long productId) {
		Product product = productRepository.findOne(productId);
		BidRefreshVo result = new BidRefreshVo();
		result.setBidersCount(0);
		User currentOwner = userService.findUser(product.getCurrentBiderId());
		result.setCurrentOwerName(currentOwner.getShowName());
		result.setPrice(product.getPrice());
		result.setStatusName(product.getStatusName());
		return result;
	}

}
