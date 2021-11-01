package com.legiscam.restapi.error;

public class ValidationErrorDetails extends ErrorDetail {
	private String field;
	private String fieldMessage;
	
	public String getField() {
		return field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}
	
	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private Long timestamp;
		private String developerMessage;
		private String field;
		private String fieldMessage;
		
		

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
		
		public Builder Field(String field) {
			this.field = field;
			return this;
		}

		public Builder FieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
			validationErrorDetails.setDeveloperMessage(developerMessage); //estes usam set pq são da classe extendida (ErroDatail)
			validationErrorDetails.setTitle(title);
			validationErrorDetails.setDetail(detail);
			validationErrorDetails.setTimestamp(timestamp);
			validationErrorDetails.setStatus(status);	
			validationErrorDetails.field = field; //esta variavel é da classe corrente
			validationErrorDetails.fieldMessage = fieldMessage;
			return validationErrorDetails;
		}
	}

}
