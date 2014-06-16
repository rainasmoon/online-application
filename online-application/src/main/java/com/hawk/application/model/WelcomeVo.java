package com.hawk.application.model;

public class WelcomeVo {

	protected double todayIncome;
	protected int todayPromotedUsers;
	protected int todayUsers;
	protected double yesterdayIncome;
	protected int yesterdayPromotedUsers;
	protected int yesterdayUsers;
	protected double totalBanlance;

	protected String promotedUsersTrendArrayString;
	protected String promotedIncomeTrendArrayString;

	public double getTodayIncome() {
		return todayIncome;
	}

	public void setTodayIncome(double todayIncome) {
		this.todayIncome = todayIncome;
	}

	public int getTodayPromotedUsers() {
		return todayPromotedUsers;
	}

	public void setTodayPromotedUsers(int todayPromotedUsers) {
		this.todayPromotedUsers = todayPromotedUsers;
	}

	public int getTodayUsers() {
		return todayUsers;
	}

	public void setTodayUsers(int todayUsers) {
		this.todayUsers = todayUsers;
	}

	public double getYesterdayIncome() {
		return yesterdayIncome;
	}

	public void setYesterdayIncome(double yesterdayIncome) {
		this.yesterdayIncome = yesterdayIncome;
	}

	public int getYesterdayPromotedUsers() {
		return yesterdayPromotedUsers;
	}

	public void setYesterdayPromotedUsers(int yesterdayPromotedUsers) {
		this.yesterdayPromotedUsers = yesterdayPromotedUsers;
	}

	public int getYesterdayUsers() {
		return yesterdayUsers;
	}

	public void setYesterdayUsers(int yesterdayUsers) {
		this.yesterdayUsers = yesterdayUsers;
	}

	public double getTotalBanlance() {
		return totalBanlance;
	}

	public void setTotalBanlance(double totalBanlance) {
		this.totalBanlance = totalBanlance;
	}

	public String getPromotedUsersTrendArrayString() {
		return promotedUsersTrendArrayString;
	}

	public void setPromotedUsersTrendArrayString(
			String promotedUsersTrendArrayString) {
		this.promotedUsersTrendArrayString = promotedUsersTrendArrayString;
	}

	public String getPromotedIncomeTrendArrayString() {
		return promotedIncomeTrendArrayString;
	}

	public void setPromotedIncomeTrendArrayString(
			String promotedIncomeTrendArrayString) {
		this.promotedIncomeTrendArrayString = promotedIncomeTrendArrayString;
	}

}
