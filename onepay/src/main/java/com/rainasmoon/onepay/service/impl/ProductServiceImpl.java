package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.ProductStatus;
import com.rainasmoon.onepay.enums.SaleModels;
import com.rainasmoon.onepay.model.Picture;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.repository.springdatajpa.PictureRepository;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.repository.springdatajpa.UserRepository;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.BidProductVo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private PictureRepository pictureRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Product addProduct(Product product) {

		return repository.save(product);
	}

	@Override
	public List<AdVo> listAllOnSaleProductsPage() {
		Iterable<Product> allProducts = repository
				.findByStatusOrderByIdDesc(ProductStatus.ONSALE.getCode());
		List<AdVo> result = new ArrayList<AdVo>();
		for (Product p : allProducts) {
			AdVo adVo = new AdVo();
			adVo.setObjId(p.getId());
			adVo.setAdTitle(p.getName());
			adVo.setAdDescription(p.getDescription());
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

		return pictureRepository.save(picture);
	}

	private Picture getCoverPicture(Long productId) {
		List<Picture> pics = pictureRepository.findPictures(productId);

		if (pics == null || pics.size() <= 0) {
			return Picture.noPicture();
		}
		return pics.get(0);
	}

	@Override
	public BidProductVo findBidProductVo(Long productId) {
		BidProductVo productVo = new BidProductVo();
		Product product = repository.findOne(productId);
		if (product == null) {
			return new BidProductVo();
		}
		productVo.setProductId(productId);
		productVo.setPicPath(getCoverPicture(productId).getPicPath());
		productVo.setProductTitle(product.getName());
		productVo.setPrice(product.getPrice());
		if (product.getCurrentBiderId() != null) {
			productVo.setCurrentOwer(userRepository.findOne(
					product.getCurrentBiderId()).getShowName());
		}
		productVo.setSaleModel(SaleModels.valueOf(product.getSaleModel()));
		productVo.setEndDate(product.getEndDate());
		return productVo;
	}

	@Override
	public Product findProduct(Long productId) {

		return repository.findOne(productId);
	}

	@Override
	public List<Product> listMySalesProductsPage(Long loginUserId) {

		return repository.findByOwnerId(loginUserId);
	}

	@Override
	public List<AdVo> listMyFavoritesProductsPage(Long loginUserId) {
		// TODO glen my favorites product
		return null;
	}

	@Override
	public Product updateProduct(Product product) {

		return repository.save(product);
	}

	@Override
	public List<Picture> findProductPics(Long productId) {

		return pictureRepository.findPictures(productId);
	}

}
