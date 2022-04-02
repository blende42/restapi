package ch.allianz.lehrlingsausbildung.restapi.rest;


/**
 * 
 * RestResponse
 * 
 * 
 * @author pm
 *
 * @param <T>
 */
public interface RestResponse<T> {
	
	/**
	 * @return ResponseStatus
	 */
	ResponseStatus getResponseStatus();
	
	
	/**
	 * @return T the rest response
	 */
	T getResponse();
	
	/**
	 * @return the httpstatus
	 */
	int getHttpStatusCode();
	
}
