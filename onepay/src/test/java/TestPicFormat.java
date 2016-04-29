
import java.util.Arrays;

import javax.imageio.ImageIO;

public class TestPicFormat {
	public static void main(String[] arg) {
		String[] rf = ImageIO.getReaderFormatNames();
		String[] wf = ImageIO.getWriterFormatNames();

		System.out.println("ImageIO.getReaderFormatNames():" + Arrays.toString(rf));
		System.out.println("ImageIO.getWriterFormatNames():" + Arrays.toString(wf));
	}
}