package ch.allianz.lehrlingsausbildung.restapi.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.allianz.lehrlingsausbildung.restapi.entities.Address;
import ch.allianz.lehrlingsausbildung.restapi.entities.KeyValue;
import ch.allianz.lehrlingsausbildung.restapi.rest.RestResponse;
import ch.allianz.lehrlingsausbildung.restapi.rest.util.RestResponseUtil;

@RestController
public class DemoController {
	@PostMapping("/address")
	public ResponseEntity<RestResponse<Address>> createAddress(@RequestBody Address address) {
		return RestResponseUtil.createSuccessfulResponse("success", HttpStatus.CREATED.value(), address);
	}

	@PostMapping("/addresserror")
	public ResponseEntity<RestResponse<Address>> createAddressFail(@RequestBody Address address) {
		return RestResponseUtil.createErrorResponse("total fail", HttpStatus.BAD_REQUEST.value(), null);
	}
	
	@PostMapping("/keyvalue")
	public ResponseEntity<RestResponse<KeyValue>> createKeyValue(@RequestBody KeyValue keyValue) {
		return RestResponseUtil.createSuccessfulResponse("all done", HttpStatus.CREATED.value(), keyValue);
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<RestResponse<String>> createException(HttpMessageNotReadableException ex) {
		return RestResponseUtil.createErrorResponse("your request did not match anything in here", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}