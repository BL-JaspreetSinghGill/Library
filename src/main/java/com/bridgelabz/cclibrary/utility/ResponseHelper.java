package com.bridgelabz.cclibrary.utility;

import org.springframework.context.annotation.PropertySource;

import com.bridgelabz.cclibrary.models.Response;

@PropertySource("classpath:message.properties")
public class ResponseHelper {

	public static Response responseStatus(int statusCode, String message) {
		Response response = new Response();
		response.setStatusCode(statusCode);
		response.setMessage(message);

		return response;
	}
}