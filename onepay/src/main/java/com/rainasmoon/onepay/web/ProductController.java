package com.rainasmoon.onepay.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.rainasmoon.onepay.model.Product;
import com.rainasmoon.onepay.service.ProductService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.vo.AdVo;
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
	private Environment env;

	@ModelAttribute("saleTypes")
	public List<String> populateContactTypes() {
		return Arrays.asList("定时秒杀拍", "3天内拍", "猜价拍");
	}

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

		List<AdVo> products = new ArrayList<AdVo>();
		for (int i = 0; i < 50; i++) {
			AdVo p = new AdVo();
			p.setAdTitle("Good" + i);
			products.add(p);
		}

		model.put("products", products);

		return "mysales";
	}

	@RequestMapping(value = { "/addproduct.html" }, method = RequestMethod.GET)
	public String addProduct(Map<String, Object> model) {
		ProductVo product = new ProductVo();

		model.put("product", product);
		return "addproduct";
	}

	@RequestMapping(value = "/addproduct.html", method = RequestMethod.POST)
	public String saveProduct(@Valid ProductVo productVo, @RequestParam(required = false) MultipartFile inputPicFile, BindingResult result, Map<String, Object> model) throws IOException {

		if (result.hasErrors()) {
			LOGGER.debug("field error. when changing personal information");
			LOGGER.debug(result.toString());
			return "addproduct";
		} else {
			// SYS_PIC_PATH = env.getProperty("product.pic.location");
			SYS_PIC_PATH = "./files";

			LOGGER.debug("the SYS_PIC_PATH is :" + SYS_PIC_PATH);
			if (inputPicFile != null && !inputPicFile.isEmpty()) {
				if (inputPicFile.getSize() > 500000) {
					result.rejectValue("error", "error.file.too.large");
				} else {
					Files.write(inputPicFile.getBytes(), new File(SYS_PIC_PATH + File.separator + "testfilename" + "_id_card_front"));
					LOGGER.debug("POST request for file upload {}", inputPicFile.getOriginalFilename());
				}
			} else {
				LOGGER.debug("Upload File is empty...");
			}

			Product product = new Product();
			product.setName(productVo.getProductName());

			productService.addProduct(product);
			model.put("message", "add product success.");
			model.put("product", new ProductVo());
			return "addproduct";
		}
	}

	@RequestMapping(value = { "/bid.html" }, method = RequestMethod.GET)
	public String bid(Map<String, Object> model) {

		return "bid";
	}

	@RequestMapping(value = { "/guessprice.html" }, method = RequestMethod.GET)
	public String guessPrice(Map<String, Object> model) {

		return "guessprice";
	}
}
