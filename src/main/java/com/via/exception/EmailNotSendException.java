package com.via.exception;

public class EmailNotSendException extends RuntimeException {
    public EmailNotSendException(String message) {
        super(message);
    }
}