package ch.allianz.lehrlingsausbildung.restapi.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.allianz.lehrlingsausbildung.restapi.rest.ResponseStatus;
import ch.allianz.lehrlingsausbildung.restapi.rest.ResponseStatusCode;
import ch.allianz.lehrlingsausbildung.restapi.rest.RestResponse;
import ch.allianz.lehrlingsausbildung.restapi.rest.RestResponseImpl;

public class RestResponseUtil {
	
	
	public static <T> ResponseEntity<RestResponse<T>> createErrorResponse(String message, int httpStatusCode, T response) {
		
		ResponseStatus responseStatus = getErrorResponseStatus(message);
		RestResponseImpl<T> restResponse = new RestResponseImpl<>();
		restResponse.setResponse(response);
		restResponse.setHttpStatusCode(httpStatusCode);
		restResponse.setResponseStatus(responseStatus);

		return createResponseEntity(restResponse); 
	}
	
	public static <T> ResponseEntity<RestResponse<T>> createSuccessfulResponse(String message, int httpStatusCode, T response) {
		
		ResponseStatus responseStatus = getSuccessResponseStatus(message);
		RestResponseImpl<T> restResponse = new RestResponseImpl<>();
		restResponse.setResponse(response);
		restResponse.setHttpStatusCode(httpStatusCode);
		restResponse.setResponseStatus(responseStatus);
		
		return createResponseEntity(restResponse);
	}
	
	private static ResponseStatus getErrorResponseStatus(String message) {

		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setMessage(message);
		responseStatus.setResponseStatusCode(ResponseStatusCode.ERROR);

		return responseStatus;	
	}
	
	private static ResponseStatus getSuccessResponseStatus(String message) {
		
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setMessage(message);
		responseStatus.setResponseStatusCode(ResponseStatusCode.OK);
		
		return responseStatus;	
	}
	
	private static <T> ResponseEntity<RestResponse<T>> createResponseEntity(RestResponse<T> response) {
		
		return ResponseEntity
				.status(HttpStatus.valueOf(response.getHttpStatusCode()))
				.body(response);
	}
}
