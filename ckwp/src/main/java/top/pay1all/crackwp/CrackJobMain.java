package top.pay1all.crackwp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.vdurmont.emoji.EmojiParser;

import jd.union.open.promotion.common.get.request.UnionOpenPromotionCommonGetRequest;
import jd.union.open.promotion.common.get.response.UnionOpenPromotionCommonGetResponse;

public class CrackJobMain {

	private static Logger lgr;
	
	private Map<String, String> shorUrlMap = new HashMap<String, String>();
	private Map<String, String> skuMap = new HashMap<String, String>();

	static {
		System.setProperty("java.util.logging.config.file", "/home/hht/projects/ckwp/src/main/resources/logging.properties");
		lgr = Logger.getLogger("TT");
		lgr.setLevel(Level.ALL);
	}
	
	public String fakeCPS(String murl, App app) {
		return fakeCPS(murl, app, false);
	}

	public String fakeCPS(String murl, App app, boolean nocache) {
		lgr.info("murl:..." + murl);
		if (!nocache && skuMap.containsKey(murl)) {
			return skuMap.get(murl);
		}
		String SERVER_URL = "https://router.jd.com/api";

		String accessToken = "";

		JdClient client = new DefaultJdClient(SERVER_URL, accessToken, app.getAppKey(), app.getAppSecret());

		UnionOpenPromotionCommonGetRequest request = new UnionOpenPromotionCommonGetRequest();
		jd.union.open.promotion.common.get.request.PromotionCodeReq promotionCodeReq = new jd.union.open.promotion.common.get.request.PromotionCodeReq();
		promotionCodeReq.setMaterialId(murl);
		promotionCodeReq.setSiteId(app.getSiteId());

		request.setPromotionCodeReq(promotionCodeReq);
		UnionOpenPromotionCommonGetResponse response;
		try {
			response = client.execute(request);
			if (response == null || response.getData() == null || response.getData().getClickURL() == null) {
				lgr.warning("Fuck. the is somthing wrong. get clickurl == NULL. check the wtf.");
				skuMap.put(murl, murl);
				return murl;
			}
			lgr.info("R:" + response.getData().getClickURL());
			skuMap.put(murl, response.getData().getClickURL());
			return response.getData().getClickURL();
		} catch (JdException e) {
			lgr.log(Level.SEVERE, "Fuck. e:", e);
		} catch (Exception ex) {
			lgr.log(Level.SEVERE, "Fuck. e new when get fucked:", ex);
		}
		lgr.warning("Fuck.failed:" + murl);
		skuMap.put(murl, murl);
		return murl;
	}

	public String fakemurl(String shorturl) {
	 return fakemurl( shorturl, false);
	}
	
	public String fakemurl(String shorturl, boolean nocache) {
		
		if (!nocache &&shorUrlMap.containsKey(shorturl)) {
			return shorUrlMap.get(shorturl);
		}
		
		String miniurl = shorturl;

		try {
			Document doc = Jsoup.connect(miniurl).timeout(50000).followRedirects(true).get();
			lgr.info("HH:" + doc.baseUri());
			// lgr.info("CC:"+doc);
			
			if (doc.baseUri().trim().equals("https://www.jd.com/")) {
				lgr.warning("Fuck. cant get sku. https jd main page." + shorturl);
				shorUrlMap.put(shorturl, null);
				return null;
			}
			
			String url = doc.html();

			Pattern r = Pattern.compile("(.*)(https://u.jd.com/jda)([^']*)(')(.*)");

			// Now create matcher object.
			Matcher m = r.matcher(url);
			if (m.find()) {
				lgr.info("Found url: " + m.group(3));
				String url2 = m.group(3);
				Document doc2 = Jsoup.connect("https://u.jd.com/jda" + url2).timeout(50000).followRedirects(true).get();
				lgr.info("HH2:" + doc2.baseUri());
				// lgr.info("CC2:" + doc2);
				
				if (doc2.baseUri().trim().equals("https://www.jd.com/")) {
					lgr.warning("Fuck. shor url expired:" + shorturl);
					shorUrlMap.put(shorturl, null);
					return null;
				}

				Pattern r2 = Pattern.compile("(.*)(sku=)(\\d*)(.*)");

				// Now create matcher object.
				Matcher m2 = r2.matcher(doc2.baseUri());
				if (m2.find()) {
					String sku = m2.group(3);
					lgr.info("SKU:" + sku);

					String murl = "https://item.jd.com/" + sku + ".html";
					shorUrlMap.put(shorturl, murl);
					return murl;
				} else {
					Pattern r3 = Pattern.compile("(https://re.jd.com/cps/item/)(\\d*)(.*)");

					// Now create matcher object.
					Matcher m3 = r3.matcher(doc2.baseUri());
					if (m3.find()) {
						lgr.info("Found value sku: " + m3.group(2));
						String sku = m3.group(2);
						String murl = "https://item.jd.com/" + sku + ".html";
						shorUrlMap.put(shorturl, murl);
						return murl;
					}
				}

			}
		} catch (IOException e) {
			lgr.log(Level.SEVERE, "Fuck. e:", e);
		}
		lgr.warning("Fuck. cant get sku. NULL.");
		shorUrlMap.put(shorturl, null);
		return null;
	}
	public String fakeContent(String orgcontent, App app) {
		return fakeContent(orgcontent, app, false);
	}

	public String fakeContent(String orgcontent, App app, boolean nocache) {
		String REGEX = "(https://u.jd.com/)([^\"]*)";

		String INPUT = orgcontent;

		Pattern p = Pattern.compile(REGEX);

		// get a matcher object
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (m.find()) {
			i++;
			lgr.info("shorturl:" + m.group(0));
			
			String longurl = fakeCPS(fakemurl(m.group(0), nocache), app, nocache);
			if (longurl != null) {
				lgr.info("replace to long url:" + longurl);
				m.appendReplacement(sb, longurl);
			} else {
				lgr.warning("fuck. no longurl:");
			}

		}
		m.appendTail(sb);
		return sb.toString();

	}

	public void fackdb() {
		// mysql -u wp -p -h 172.31.21.200

		String url = "jdbc:mysql://172.31.21.200:3306/wordpress?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
		String user = "wp";
		String password = "bsnpb6p";

		String query = "SELECT id, post_content from wp_posts ";//where id = 1665";
		lgr.info("begin db...");
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query)) {

			while (rs.next()) {
				try {
					long tid = rs.getLong(1);
					String tcontent = rs.getString(2);

					// : here need to change all the to the right url;


					
					String tresult = fakeContent(tcontent, buildRainApp(), false);

					PreparedStatement pst = con.prepareStatement("update wp_posts set post_content = ? where id = ?");

					tresult = EmojiParser.removeAllEmojis(tresult);
					
					pst.setString(1, tresult);
					pst.setLong(2, tid);
					lgr.info("POSTID:" + tid);
					
					pst.executeUpdate();
				} catch (Exception e) {
					lgr.log(Level.SEVERE, e.getMessage(), e);
				}
			}

		} catch (SQLException ex) {

			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		lgr.info("finish db.");
	}
	
	public static App buildRainApp() {
		//rainasmoon.com
		String appKey = "d6b2d3ba859446c4bbf1c36c9e4f2a8f";
		String appSecret = "8777e8f1207841e484be71077c9ef428";
		String siteId = "1728182420";
		
		return new App(appKey, appSecret, siteId);
	}
	
	public static App buildZhihuApp() {
		//rainasmoon.com
		String appKey = "623cb6dc2e7168678b0845aba841ce9b";
		String appSecret = "718c0752ff144470aa87cfa63cb7784a";
		String siteId = "47972";
		
		return new App(appKey, appSecret, siteId);
	}

	public static void main(String[] args) {
		lgr.info("begin...");
		long btime = System.currentTimeMillis();
//		new CrackJobMain().fackdb();
		long end = System.currentTimeMillis();
		lgr.info("end:" + (end - btime));
	}

}