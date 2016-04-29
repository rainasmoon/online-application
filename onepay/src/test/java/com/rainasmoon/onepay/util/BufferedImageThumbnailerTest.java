package com.rainasmoon.onepay.util;

import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

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
	public void shouldTestAcceptedType() {
		String[] rf = ImageIO.getReaderFormatNames();
		String[] wf = ImageIO.getWriterFormatNames();

		LOGGER.debug("ImageIO.getReaderFormatNames():" + Arrays.toString(rf));
		LOGGER.debug("ImageIO.getWriterFormatNames():" + Arrays.toString(wf));
	}

	@Test
	public void shouldThumbnailPic() {
		ImgThumbnailUtils bit = new ImgThumbnailUtils(200);
		File result = bit.createThumbnail("testimage.jpg", BufferedImageThumbnailerTest.class.getResource("").getFile());
		LOGGER.info("path: {}", result);
	}
}
