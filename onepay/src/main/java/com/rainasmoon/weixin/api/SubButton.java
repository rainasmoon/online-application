package com.rainasmoon.weixin.api;

public class SubButton {
	private String type;
	private String name;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SubButton(String type, String name) {
		 
		this.type = type;
		this.name = name;
	}
	public SubButton() {
		 
	}
	
}
