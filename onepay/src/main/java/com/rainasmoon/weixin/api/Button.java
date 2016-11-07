package com.rainasmoon.weixin.api;

import java.util.List;

public class Button {
 private String name;
 private String url;
 private String type;
 private List<SubButton>  sub_button;
public Button() {
	 
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public List<SubButton> getSub_button() {
	return sub_button;
}
public void setSub_button(List<SubButton> sub_button) {
	this.sub_button = sub_button;
}


 

 
 
}
