package ch.allianz.lehrlingsausbildung.restapi.rest;

public class ResponseStatus {
	private ResponseStatusCode responseStatusCode;
	private String message;
	
	public ResponseStatusCode getResponseStatusCode() {
		return responseStatusCode;
	}
	
	public void setResponseStatusCode(ResponseStatusCode responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
