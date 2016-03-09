package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.vo.AdVo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public Product addProduct(Product product) {

		return repository.save(product);
	}

	@Override
	public List<AdVo> listAllProductsPage() {
		Iterable<Product> allProducts = repository.findAll();
		List<AdVo> result = new ArrayList<AdVo>();
		for (Product p : allProducts) {
			AdVo adVo = new AdVo();
			adVo.setAdTitle(p.getName());
			result.add(adVo);
		}
		return result;
	}

}
