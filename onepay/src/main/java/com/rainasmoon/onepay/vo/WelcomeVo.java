package com.rainasmoon.onepay.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WelcomeVo {

	private List<AdVo> ads;
	private List<AdVo> top3;
	private List<AdVo> imp3;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);

	}

	public List<AdVo> getAds() {
		return ads;
	}

	public void setAds(List<AdVo> ads) {
		this.ads = ads;
	}

	public List<AdVo> getTop3() {
		return top3;
	}

	public void setTop3(List<AdVo> top3) {
		this.top3 = top3;
	}

	public List<AdVo> getImp3() {
		return imp3;
	}

	public void setImp3(List<AdVo> imp3) {
		this.imp3 = imp3;
	}
}
