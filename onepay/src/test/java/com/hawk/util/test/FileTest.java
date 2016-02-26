package com.hawk.util.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTest {

	Logger LOGGER = LoggerFactory.getLogger(FileTest.class);

	@Test
	public void test() throws IOException {
		File f = new File("C:\\temp\\Test_Only.file");
		f.createNewFile();
		LOGGER.debug("file exist? " + f.exists());

		FileInputStream fis = new FileInputStream(f);
		LOGGER.debug(fis.toString());
	}
}
