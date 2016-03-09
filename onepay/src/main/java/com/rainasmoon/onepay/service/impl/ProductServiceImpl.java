package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.model.Picture;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.PictureRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.vo.AdVo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private PictureRepository pictureRepository;

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
			adVo.setPicPath(getCoverPicture(p.getId()).getPicPath());
			result.add(adVo);
		}
		return result;
	}

	@Override
	public Picture addPicture(Long productId, String picPath) {
		Picture picture = new Picture();
		picture.setProductId(productId);
		picture.setPicPath(picPath);
		picture.setCreateDate(new Date());

		return pictureRepository.save(picture);
	}

	private Picture getCoverPicture(Long productId) {
		List<Picture> pics = pictureRepository.findPictures(productId);

		return pics.get(0);
	}

}
