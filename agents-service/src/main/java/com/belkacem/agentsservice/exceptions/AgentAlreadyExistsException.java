package com.belkacem.agentsservice.exceptions;

public class AgentAlreadyExistsException extends RuntimeException{
    private String message;

    public AgentAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
