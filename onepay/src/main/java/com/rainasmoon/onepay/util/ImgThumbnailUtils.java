package com.rainasmoon.onepay.util;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Uses the built-in JDK tooling for resizing an image.
 *
 * 
 */
class BufferedImageThumbnailer {

	private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y,
			width, height) -> true;

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final int maxLongSide;

	public BufferedImageThumbnailer(int maxLongSide) {
		this.maxLongSide = maxLongSide;
	}

	public Path createThumbnail(String path) {
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Path thumbnailPath = Files.createTempFile("thumbnail", ".jpg")
					.toAbsolutePath();
			BufferedImage imgIn = ImageIO.read(fis);

			double scale;
			if (imgIn.getWidth() >= imgIn.getHeight()) {
				// horizontal or square image
				scale = Math.min(maxLongSide, imgIn.getWidth())
						/ (double) imgIn.getWidth();
			} else {
				// vertical image
				scale = Math.min(maxLongSide, imgIn.getHeight())
						/ (double) imgIn.getHeight();
			}

			BufferedImage thumbnailOut = new BufferedImage(
					(int) (scale * imgIn.getWidth()),
					(int) (scale * imgIn.getHeight()), imgIn.getType());
			Graphics2D g = thumbnailOut.createGraphics();

			AffineTransform transform = AffineTransform.getScaleInstance(scale,
					scale);
			g.drawImage(imgIn, transform, DUMMY_OBSERVER);
			ImageIO.write(thumbnailOut, "jpeg", thumbnailPath.toFile());

			log.info("Image thumbnail now at: {}", thumbnailPath);

			return thumbnailPath;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

}