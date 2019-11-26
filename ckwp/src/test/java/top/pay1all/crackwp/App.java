package top.pay1all.crackwp;

public class App {

	private String appKey;
	private String appSecret; 
	private String siteId;
	
	
	
	public App(String appKey, String appSecret, String siteId) {
		super();
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.siteId = siteId;
	}
	
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
}
