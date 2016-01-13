package com.wanlianjin.test;

public class Test {
	public static void main(String[] arg) {
		String md5 = "1234567890abcd";
		System.out.println(String.format("%s%s", md5.substring(10), md5.substring(0, 10)));
	}
}