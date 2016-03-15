package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Picture;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.BidProductVo;

public interface ProductService {

	Product addProduct(Product product);

	Picture addPicture(Long productId, String picPath);

	Product updateProduct(Product product);

	List<AdVo> listAllProductsPage();

	List<Product> listMySalesProductsPage(Long loginUserId);

	List<AdVo> listMyFavoritesProductsPage(Long loginUserId);

	BidProductVo findBidProductVo(Long productId);

	Product findProduct(Long productId);

	List<Picture> findProductPics(Long productId);
}
