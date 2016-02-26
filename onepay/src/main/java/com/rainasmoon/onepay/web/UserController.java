package com.rainasmoon.onepay.web;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.rainasmoon.onepay.service.DictionaryService;
import com.rainasmoon.onepay.service.UserService;
import com.rainasmoon.onepay.model.Dictionary;
import com.rainasmoon.onepay.model.User;

@Controller
@SessionAttributes(types = User.class)
@PropertySource("classpath:/spring/data-access.properties")
public class UserController extends BaseController {

	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	@Autowired
	private Mapper dozerBeanMapper;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	Environment env;

	private String SYS_PIC_PATH;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("contactTypes")
	public List<String> populateContactTypes() {
		return Arrays.asList("个人", "公司");
	}

	@ModelAttribute("provinceTypes")
	public List<Dictionary> populateProvinceTypes() {
		return dictionaryService.getProvinces();
	}

	@ModelAttribute("cityTypes")
	public List<Dictionary> populateCityTypes(HttpSession session) {
		String userEmail = (String) session.getAttribute("userEmail");
		User user = userService.findUserByEmail(userEmail);
		return dictionaryService.getAllCitys();
	}

	@RequestMapping(value = "/changePersonalInformation.html", method = RequestMethod.GET)
	public String initPersonalInformationForm(HttpSession session,
			Map<String, Object> model) {
		String userEmail = (String) session.getAttribute("userEmail");
		User user = userService.findUserByEmail(userEmail);
		model.put("user", user);
		return "user/changePersonalInformation";
	}

	@RequestMapping(value = "/changePersonalInformation.html", method = RequestMethod.POST)
	public String processPersonalInformationForm(@Valid User user,
			@RequestParam(required = false) MultipartFile fileIdCardFront,
			@RequestParam(required = false) MultipartFile fileIdCardBack,
			BindingResult result) throws IOException {

		if (result.hasErrors()) {
			LOGGER.debug("field error. when changing personal information");
			LOGGER.debug(result.toString());
			return "user/changePersonalInformation";
		} else {
			SYS_PIC_PATH = env.getProperty("idcard.pic.location");

			LOGGER.debug("the SYS_PIC_PATH is :" + SYS_PIC_PATH);
			if (fileIdCardFront != null && !fileIdCardFront.isEmpty()) {
				if (fileIdCardFront.getSize() > 500000) {
					result.rejectValue("error", "error.file.too.large");
				} else {
					Files.write(fileIdCardFront.getBytes(), new File(
							SYS_PIC_PATH + File.separator + user.getId()
									+ "_id_card_front"));
					LOGGER.debug("POST request for file upload {}",
							fileIdCardFront.getOriginalFilename());
				}
			}

			if (fileIdCardBack != null && !fileIdCardBack.isEmpty()) {
				if (fileIdCardBack.getSize() > 500000) {
					result.rejectValue("error", "error.file.too.large");
				} else {
					Files.write(fileIdCardBack.getBytes(), new File(
							SYS_PIC_PATH + File.separator + user.getId()
									+ "_id_card_back"));
					LOGGER.debug("POST request for file upload {}",
							fileIdCardBack.getOriginalFilename());
				}
			}

			this.userService.saveUser(user);
			return "redirect:/viewMe.html";
		}
	}

}
