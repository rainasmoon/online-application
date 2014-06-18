package com.hawk.application.util;

import java.util.Date;

public class DayBuilder {

	private Date today;
	private Date yesterday;

	private long aday = 24 * 3600 * 1000;

	public DayBuilder() {
		this.today = new Date();
		this.yesterday = new Date(today.getTime() - aday);
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Date getYesterday() {
		return yesterday;
	}

	public void setYesterday(Date yesterday) {
		this.yesterday = yesterday;
	}

}
