package com.legiscam.restapi.error;

public class ResourseNotFoundDetails extends ErrorDetail{

	
	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private Long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public static Builder builder() {
			return new Builder();
		}	

		public Builder Title(String title) {
			this.title = title;
			return this;
		}

		public Builder Status(int status) {
			this.status = status;
			return this;
		}

		public Builder Detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder Timestamp(Long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder DeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourseNotFoundDetails build() {
			ResourseNotFoundDetails resourseNotFoundDetails = new ResourseNotFoundDetails();
			resourseNotFoundDetails.setDeveloperMessage(developerMessage);
			resourseNotFoundDetails.setTitle(title);
			resourseNotFoundDetails.setDetail(detail);
			resourseNotFoundDetails.setTimestamp(timestamp);
			resourseNotFoundDetails.setStatus(status);
			return resourseNotFoundDetails;
		}	
	}
}
