package com.rainasmoon.onepay.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rainasmoon.onepay.util.CommonConstants;
import com.rainasmoon.onepay.util.ImgThumbnailUtils;

@Controller
@PropertySource("classpath:/spring/data-access.properties")
public class ImageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	Environment env;

	private static String SYS_PIC_PATH;

	public ImageController() {
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "File not found")
	@ExceptionHandler(ImageNotFoundException.class)
	public void fileNotFound(Exception e) {
		LOGGER.warn("Request raised a FileNotFoundException: {}", e.getMessage());
	}

	@RequestMapping(value = "/product_pic/{pic_path}", method = RequestMethod.GET)
	public void getFile(@PathVariable("pic_path") String picPath, HttpServletResponse response) throws DataAccessException, ImageNotFoundException {
		FileInputStream fileInputStream = null;
		try {

			SYS_PIC_PATH = env.getProperty(CommonConstants.PRODUCT_PIC_PATH_ID);

			LOGGER.debug("!!!!!the SYS_PIC_PATH is " + SYS_PIC_PATH);
			File file = new File(SYS_PIC_PATH + File.separator + picPath);
			LOGGER.debug("the file name is:" + SYS_PIC_PATH + File.separator + picPath);

			if (!file.exists()) {
				file = new File(ImageController.class.getResource("nopic").getFile());
			}
			fileInputStream = new FileInputStream(file);

			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			response.setContentType("image");
			IOUtils.copy(fileInputStream, response.getOutputStream());
			response.flushBuffer();

		} catch (IOException e) {
			LOGGER.error("Error writing file content to output stream", e);
			throw new ImageNotFoundException("IOError writing file to output stream");
		} finally {
			IOUtils.closeQuietly(fileInputStream);
		}

	}

	@RequestMapping(value = "/product_pic/thumbnail/{pic_path}", method = RequestMethod.GET)
	public void getThumbnailFile(@PathVariable("pic_path") String picPath, HttpServletResponse response) throws DataAccessException, ImageNotFoundException {

		String[] rf = ImageIO.getReaderFormatNames();
		String[] wf = ImageIO.getWriterFormatNames();

		LOGGER.debug(":www:ImageIO.getReaderFormatNames():" + rf);
		LOGGER.debug("ImageIO.getWriterFormatNames():" + wf);

		FileInputStream fileInputStream = null;
		try {

			SYS_PIC_PATH = env.getProperty(CommonConstants.PRODUCT_PIC_PATH_ID);

			LOGGER.debug("!!!!!the SYS_PIC_PATH is " + SYS_PIC_PATH);
			File file = new File(SYS_PIC_PATH + File.separator + "thumbnail" + File.separator + picPath);
			LOGGER.debug("the file name is:" + SYS_PIC_PATH + File.separator + picPath);

			if (!file.exists()) {
				ImgThumbnailUtils imgThumbnailUtils = new ImgThumbnailUtils(250);
				file = imgThumbnailUtils.createThumbnail(picPath, SYS_PIC_PATH);
			}
			fileInputStream = new FileInputStream(file);

			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
			response.setContentType("image");
			IOUtils.copy(fileInputStream, response.getOutputStream());
			response.flushBuffer();

		} catch (IOException e) {
			LOGGER.error("Error writing file content to output stream", e);
			throw new ImageNotFoundException("IOError writing file to output stream", e);
		} finally {
			IOUtils.closeQuietly(fileInputStream);
		}

	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

}
