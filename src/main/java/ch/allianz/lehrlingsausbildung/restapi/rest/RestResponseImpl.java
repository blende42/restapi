package ch.allianz.lehrlingsausbildung.restapi.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestResponseImpl<T> implements RestResponse<T> {
	
	private ResponseStatus responseStatus;
	private T response;
	
	@JsonIgnore
	private int httpStatusCode;
	
	@Override
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	@Override
	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	@Override
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}

