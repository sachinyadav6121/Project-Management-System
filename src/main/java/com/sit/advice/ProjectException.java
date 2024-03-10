package com.sit.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ProjectException extends Exception{

	public ProjectException(String msg){
		super(msg);
	}
}

