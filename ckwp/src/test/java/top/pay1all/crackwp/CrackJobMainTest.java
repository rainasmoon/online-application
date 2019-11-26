package top.pay1all.crackwp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.jd.open.api.sdk.JdException;

public class CrackJobMainTest {

	public static void main(String[] args) {
		System.out.println("Hi... again");
	}

	@Test
	public void test() throws JdException {
		CrackJobMain ckm = new CrackJobMain();
		App app = CrackJobMain.buildRainApp();
		System.out.println(ckm.fakeContent("abhttps://u.jsd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jsd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jsd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jd.com/sidfs\"c", app));
		System.out.println(ckm.fakeContent("abhttps://u.jd.com/sidfs\"c", app));
	}

	@Test
	public void testdb() {
		
	}

	@Test
	public void testweb() throws IOException {
		String shorturl = "https://u.jd.com/DkD60y";
		
		// https://union-click.jd.com/jdc?e=&p=AyIGZRNeHQIQBlcSWiUFFgVXGVoVMlZYDUUEJVtXQhRZUAscSkIBR0ROVw1VC0dFEgYQBVcaWwpbV1sIKzNNZQwOS0s9d3FoZSNDBFZAEVkjGx0ZDiIHUxhSFQsRAlYaaxUDEwdQGFocCxQ3ZRtaJVR8B1QaWhQDEAJQH2sUMhIDUR1fEAMbBF0YXRwyEg9RKxhFWk1XF0cFS10iN2UYayUyEjdVKwRRX083VxpaFwA%3D&t=W1dCFFlQCxxKQgFHRE5XDVULR0USBhAFVxpbCltXWwg%3D

		
		CrackJobMain cj = new CrackJobMain();
		CrackJobMain cj2 = new CrackJobMain();
		String longurl = cj.fakeCPS(cj.fakemurl(shorturl), CrackJobMain.buildRainApp(), true);
		String longurl2 = cj2.fakeCPS(cj2.fakemurl(shorturl), CrackJobMain.buildZhihuApp(), true);
		System.out.println(longurl);
		System.out.println(longurl2);
	}

	@Test
	public void testRex() {
		String s = "https://re.jd.com/cps/item/33836560764.html?wareId=33836560764&cu=true&utm_source=kong&utm_medium=tuiguang&utm_campaign=t_1001420887_&utm_term=0849b55274da46ee9733378743502b45\n";
		Pattern r = Pattern.compile("(https://re.jd.com/cps/item/)(\\d*)(.*)");

		// Now create matcher object.
		Matcher m = r.matcher(s);
		if (m.find()) {
			System.out.println("Found value: " + m.group(2));
		}

	}

}
