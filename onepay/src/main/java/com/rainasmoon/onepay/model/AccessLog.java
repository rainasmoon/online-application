package com.rainasmoon.onepay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accesslogs")
public class AccessLog extends BaseEntity {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "ip")
	private String ip;
	@Column(name = "client")
	private String client;
	@Column(name = "url")
	private String url;
	@Column(name = "cookie_id")
	private String cookieId;
	@Column(name = "session_id")
	private String sessionId;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCookieId() {
		return cookieId;
	}
	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}	
	
}
