package com.wg.result;

import java.io.Serializable;

public class GenericResult implements Serializable{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
