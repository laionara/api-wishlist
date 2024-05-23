package com.wishlist.interactors.exception;

public class BusinessException extends RuntimeException{

    private String message;


    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
