package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Picture;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.vo.AdVo;

public interface ProductService {

	Product addProduct(Product product);

	Picture addPicture(Long productId, String picPath);

	List<AdVo> listAllProductsPage();
}
