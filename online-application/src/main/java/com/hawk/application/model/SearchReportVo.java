package com.hawk.application.model;

import java.util.Date;

public class SearchReportVo {

	private Application application;
	private Date dateFrom;
	private Date dateTo;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public static class Builder {
		private Application application;
		private Date dateFrom;
		private Date dateTo;

		public Builder application(Application application) {
			this.application = application;
			return this;
		}

		public Builder dateFrom(Date dateFrom) {
			this.dateFrom = dateFrom;
			return this;
		}

		public Builder dateTo(Date dateTo) {
			this.dateTo = dateTo;
			return this;
		}

		public SearchReportVo build() {
			return new SearchReportVo(this);
		}
	}

	private SearchReportVo(Builder builder) {
		this.application = builder.application;
		this.dateFrom = builder.dateFrom;
		this.dateTo = builder.dateTo;
	}
}