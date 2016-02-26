package com.rainasmoon.onepay.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Report {

	@Temporal(TemporalType.TIMESTAMP)
	protected Date date;
	protected Integer newUsers;
	protected Integer activeUsers;
	protected Integer activation;
	protected Double activationIncome;
	protected Double taskIncome;

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public void addReport(Report report) {
		if (report.newUsers != null) {
			if (this.newUsers == null) {
				this.newUsers = report.newUsers;
			} else {
				this.newUsers += report.newUsers;
			}
		}

		if (report.activeUsers != null) {
			if (this.activeUsers == null) {
				this.activeUsers = report.activeUsers;
			} else {
				this.activeUsers += report.activeUsers;
			}
		}

		if (report.activation != null) {
			if (this.activation == null) {
				this.activation = report.activation;
			} else {
				this.activation += report.activation;
			}
		}

		if (report.activationIncome != null) {
			if (this.activationIncome == null) {
				this.activationIncome = report.activationIncome;
			} else {
				this.activationIncome += report.activationIncome;
			}
		}

		if (report.taskIncome != null) {
			if (this.taskIncome == null) {
				this.taskIncome = report.taskIncome;
			} else {
				this.taskIncome += report.taskIncome;
			}
		}

	}

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

	public Integer getActivation() {
		return activation;
	}

	public void setActivation(Integer activation) {
		this.activation = activation;
	}

	public Double getTaskIncome() {
		return taskIncome;
	}

	public void setTaskIncome(Double taskIncome) {
		this.taskIncome = taskIncome;
	}

	public Double getPromoteIncome() {
		if (activationIncome == null && taskIncome == null) {
			return null;
		}
		return (activationIncome == null ? 0.0 : activationIncome)
				+ (taskIncome == null ? 0.0 : taskIncome);
	}

	public Double getActivationIncome() {
		return activationIncome;
	}

	public void setActivationIncome(Double activationIncome) {
		this.activationIncome = activationIncome;
	}

}
