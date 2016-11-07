package com.rainasmoon.weixin.api;

public class Click  extends SubButton{
	 
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Click(String name,String key) {
		super("click",name);
		this.key = key;
	}
	 
 
}
