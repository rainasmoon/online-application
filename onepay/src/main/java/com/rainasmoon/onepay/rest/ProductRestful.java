package com.rainasmoon.onepay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.web.BaseController;

@RestController
@RequestMapping(produces = "text/plain;charset=UTF-8")
public class ProductRestful extends BaseController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/saveProductInfo")
	public String saveProductInfo(Long productId, @RequestParam(value = "field") String field, @RequestParam(value = "value") String value) {
		Product product = productService.findProduct(productId);
		if (field.equalsIgnoreCase("description")) {
			product.setDescription(value);
		}

		productService.updateProduct(product);
		return value;
	}

}
