package com.rainasmoon.onepay.util;

import java.nio.file.Path;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferedImageThumbnailerTest {

	Logger LOGGER = LoggerFactory.getLogger(BufferedImageThumbnailerTest.class);

	@Test
	public void testLog() {
		LOGGER.info("hi...");
	}

	@Test
	public void shouldThumbnailPic() {
		BufferedImageThumbnailer bit = new BufferedImageThumbnailer(200);
		Path result = bit.createThumbnail("");
		LOGGER.info("path: {}", result);
	}
}
