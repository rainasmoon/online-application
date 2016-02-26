package com.rainasmoon.onepay.util;

import java.util.Calendar;
import java.util.Date;

public class DayBuilder {

	private Date today;
	private Date yesterday;
	private Date lastMonthToday;

	private long aday = 24 * 3600 * 1000;

	public DayBuilder() {
		Calendar cal = Calendar.getInstance();
		this.today = new Date(cal.getTime().getTime());
		this.yesterday = new Date(today.getTime() - aday);

		cal.add(Calendar.MONTH, -1);
		this.lastMonthToday = new Date(cal.getTime().getTime());
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

	public Date getLastMonthToday() {
		return lastMonthToday;
	}

	public void setLastMonthToday(Date lastMonthToday) {
		this.lastMonthToday = lastMonthToday;
	}

}
