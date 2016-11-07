package com.rainasmoon.weixin.api;

public class View extends SubButton{
 
private String url;
  
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public View(String name,String url) {
	super("view",name);
	this.url = url;
}
 
  
}
