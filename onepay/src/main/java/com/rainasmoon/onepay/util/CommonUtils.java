package com.rainasmoon.onepay.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

public class CommonUtils {

	public static Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	public static boolean isEmail(String loginName) {

		return loginName.contains("@");
	}

	public static String saveFile(Long id, MultipartFile inputPicFile, String systemPath) {
		long seq = new Date().getTime();
		int random = (int) (Math.random() * 9000 + 1000);
		String picPath = "p_" + id + "_" + seq + "_" + random;
		try {
			Files.write(inputPicFile.getBytes(), new File(systemPath + File.separator + picPath));
		} catch (IOException e) {
			LOGGER.error("save file exception:", e);
			throw new ApplicationException("save file exception:", e);
		}
		LOGGER.debug("POST request for file upload {}", inputPicFile.getOriginalFilename());
		return picPath;
	}

	public static String getUserLevel(Integer level) {
		// TODO Auto-generated method stub
		return "normal";
	}

	public static Integer parseFreezeCoe(String freezeCode) {
		// TODO Auto-generated method stub
		return 100;
	}
}
