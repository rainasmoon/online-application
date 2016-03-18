package com.rainasmoon.onepay.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rainasmoon.onepay.enums.SaleModels;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.TagService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.CommonUtils;
import com.rainasmoon.onepay.vo.AdVo;
import com.rainasmoon.onepay.vo.BidProductVo;
import com.rainasmoon.onepay.vo.ProductListPageVo;
import com.rainasmoon.onepay.vo.ProductVo;

@Controller
@PropertySource("classpath:/spring/data-access.properties")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private TagService tagService;

	@Autowired
	private Environment env;

	@RequestMapping(value = { "/listproducts.html" }, method = RequestMethod.GET)
	public String listProducts(Map<String, Object> model) {
		ProductListPageVo vo = new ProductListPageVo();

		vo.setTotalAmount(1000000000);
		vo.setTodayAmount(1000000);

		vo.setActiveTop5Users(userService.listActiveTop5Users());

		vo.setProducts(productService.listAllProductsPage());

		model.put("vo", vo);

		return "listproducts";
	}

	@RequestMapping(value = { "/myfavorites.html" }, method = RequestMethod.GET)
	public String listMyFavorites(Map<String, Object> model) {

		if (!isLogin()) {
			return "redirect:login.html";
		}

		List<AdVo> products = new ArrayList<AdVo>();
		for (int i = 0; i < 50; i++) {
			AdVo p = new AdVo();
			p.setAdTitle("Good" + i);
			products.add(p);
		}

		model.put("products", products);

		return "myfavorites";
	}

	@RequestMapping(value = { "/mysales.html" }, method = RequestMethod.GET)
	public String listMySales(Map<String, Object> model) {
		if (!isLogin()) {
			return "redirect:login.html";
		}

		model.put("products", productService.listMySalesProductsPage(getLoginUserId()));

		return "mysales";
	}

	@RequestMapping(value = { "/addproduct.html" }, method = RequestMethod.GET)
	public String addProduct(Map<String, Object> model) {

		if (!isLogin()) {
			return "redirect:login.html";
		}

		ProductVo product = new ProductVo();

		model.put("product", product);
		return "addproduct";
	}

	@RequestMapping(value = "/addproduct.html", method = RequestMethod.POST)
	public String saveProduct(@Valid ProductVo productVo, @RequestParam(required = false) MultipartFile inputPicFile, BindingResult result, Map<String, Object> model) {

		if (!isLogin()) {
			return "redirect:login.html";
		}

		if (result.hasErrors()) {
			LOGGER.warn("field error. when changing personal information");
			LOGGER.debug(result.toString());
			return "addproduct";
		} else {
			LOGGER.debug("www:" + productVo);
			Product product = new Product();
			product.setName(productVo.getProductName());
			product.setOwnerId(getLoginUserId());
			if (productVo.getSaleModel() != null) {
				product.setSaleModel(SaleModels.valueOfStr(productVo.getSaleModel()).getCode());
			}
			product.setAging(productVo.getAging());
			product.setDescription(productVo.getDescription());
			if (SaleModels.GUESSPRICE == SaleModels.valueOfStr(productVo.getSaleModel())) {
				product.setPrice(productVo.getPrice());
			} else {
				product.setPrice(1);
			}

			product = productService.addProduct(product);

			if (productVo.getTags() != null) {
				for (String tag : productVo.getTags()) {
					tagService.addProductTag(product.getId(), tag);
				}
			}

			SYS_PIC_PATH = env.getProperty(CommonConstants.PRODUCT_PIC_PATH_ID);

			LOGGER.debug("the SYS_PIC_PATH is :" + SYS_PIC_PATH);
			if (inputPicFile != null && !inputPicFile.isEmpty()) {
				if (inputPicFile.getSize() > CommonConstants.PIC_MAX_ALLOW_SIZE) {
					model.put("product", productVo);
					model.put("message", "pic is too large...");
					return "addproduct";
				} else {
					String picPath = CommonUtils.saveFile(product.getId(), inputPicFile, SYS_PIC_PATH);

					productService.addPicture(product.getId(), picPath);
				}
			} else {
				LOGGER.debug("Upload File is empty...");
			}

			model.put("message", "add product success.");
			model.put("product", new ProductVo());
			return "addproduct";
		}
	}

	@RequestMapping(value = { "/view_product.html" })
	public String viewProduct(Long productId, Map<String, Object> model) {
		model.put("product", productService.findProduct(productId));
		model.put("productTags", tagService.findProductTags(productId));
		model.put("productPics", productService.findProductPics(productId));
		return "view_product";
	}

	@RequestMapping(value = "/add_product_pic.html", method = RequestMethod.GET)
	public String addProductPic(Long productId, Map<String, Object> model) {
		model.put("productId", productId);
		return "add_product_pic";
	}

	@RequestMapping(value = "/saveProductPic.html", method = RequestMethod.POST)
	public String saveProductPic(Long productId, @RequestParam(required = false) MultipartFile inputPicFile, Map<String, Object> model) {

		LOGGER.debug("WWW:pic:" + productId + inputPicFile);

		SYS_PIC_PATH = env.getProperty(CommonConstants.PRODUCT_PIC_PATH_ID);

		LOGGER.debug("the SYS_PIC_PATH is :" + SYS_PIC_PATH);
		if (inputPicFile != null && !inputPicFile.isEmpty()) {
			if (inputPicFile.getSize() > CommonConstants.PIC_MAX_ALLOW_SIZE) {
				model.put("productId", productId);
				model.put("message", "pic is too large...");
				return "add_product_pic";
			} else {
				String picPath = CommonUtils.saveFile(productId, inputPicFile, SYS_PIC_PATH);

				productService.addPicture(productId, picPath);
			}
		} else {
			LOGGER.debug("Upload File is empty...");
		}

		return "redirect:view_product.html?productId=" + productId;

	}

	@RequestMapping(value = { "/bid.html" }, method = RequestMethod.GET)
	public String bid(Long productId, Map<String, Object> model) {
		BidProductVo productVo = productService.findBidProductVo(productId);
		model.put("productTags", tagService.findProductTags(productId));
		model.put("productVo", productVo);
		return "bid_fixed_time";
	}

	@RequestMapping(value = { "/guessprice.html" }, method = RequestMethod.GET)
	public String guessPrice(Map<String, Object> model) {

		return "guessprice";
	}
}
