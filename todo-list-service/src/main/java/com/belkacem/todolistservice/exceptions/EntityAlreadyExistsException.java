package com.belkacem.todolistservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public  EntityAlreadyExistsException(String message){
        super(message);
    }
}

