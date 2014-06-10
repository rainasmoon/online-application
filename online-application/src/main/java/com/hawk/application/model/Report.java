package com.hawk.application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Report {

	@Temporal(TemporalType.TIMESTAMP)
	protected Date date;
	protected Integer newUsers;
	protected Integer activeUsers;
	protected Integer actvation;
	protected Double actvationIncome;
	protected Double taskIncome;
	protected Double promoteIncome;

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public String getDateString() {
		if (getDate() == null) {
			return "总计";
		}
		String dateString = df.format(getDate());
		Date now = new Date();
		String todayString = df.format(now);
		String yesterdayString = df.format(new Date(now.getTime() - 24 * 60
				* 60 * 1000));
		if (dateString.equals(todayString)) {
			return "今天";
		}
		if (dateString.equals(yesterdayString)) {
			return "昨天";
		}
		return dateString;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNewUsers() {
		return newUsers;
	}

	public void setNewUsers(Integer newUsers) {
		this.newUsers = newUsers;
	}

	public Integer getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(Integer activeUsers) {
		this.activeUsers = activeUsers;
	}

	public Integer getActvation() {
		return actvation;
	}

	public void setActvation(Integer actvation) {
		this.actvation = actvation;
	}

	public Double getActvationIncome() {
		return actvationIncome;
	}

	public void setActvationIncome(Double actvationIncome) {
		this.actvationIncome = actvationIncome;
	}

	public Double getTaskIncome() {
		return taskIncome;
	}

	public void setTaskIncome(Double taskIncome) {
		this.taskIncome = taskIncome;
	}

	public Double getPromoteIncome() {
		return promoteIncome;
	}

	public void setPromoteIncome(Double promoteIncome) {
		this.promoteIncome = promoteIncome;
	}
}
