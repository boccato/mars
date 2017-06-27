package com.example.mars;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadCommandException extends Exception {
	public BadCommandException(String cmd) {
		super("Cannot run this command : " + cmd + ".");
	}
}
