package com.rainasmoon.onepay.util;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uses the built-in JDK tooling for resizing an image.
 *
 * 
 */
public class ImgThumbnailUtils {

	private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y, width, height) -> true;

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final int maxLongSide;

	public ImgThumbnailUtils(int maxLongSide) {
		this.maxLongSide = maxLongSide;
	}

	public File createThumbnail(String picFileName, String type, String picPath) {
		try {
			File file = new File(picPath + File.separator + picFileName);
			if (!file.exists()) {
				log.info("file :%s, not exist.", picFileName);
				return null;
			}
			if (!file.isFile()) {
				log.info("file : %s, not a file.", file);
				return null;
			}
			FileInputStream fis = new FileInputStream(file);
			File thumbnailFile = new File(picPath + File.separator + type + File.separator + picFileName);

			BufferedImage imgIn = ImageIO.read(fis);

			double scale;
			if (imgIn.getWidth() >= imgIn.getHeight()) {
				// horizontal or square image
				scale = Math.min(maxLongSide, imgIn.getWidth()) / (double) imgIn.getWidth();
			} else {
				// vertical image
				scale = Math.min(maxLongSide, imgIn.getHeight()) / (double) imgIn.getHeight();
			}

			BufferedImage thumbnailOut = new BufferedImage((int) (scale * imgIn.getWidth()), (int) (scale * imgIn.getHeight()), imgIn.getType());
			Graphics2D g = thumbnailOut.createGraphics();

			AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
			g.drawImage(imgIn, transform, DUMMY_OBSERVER);
			ImageIO.write(thumbnailOut, "jpeg", thumbnailFile);

			log.info("Image thumbnail now at: {}", thumbnailFile.getAbsolutePath());

			return thumbnailFile;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

}