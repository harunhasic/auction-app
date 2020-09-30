package com.atlantbh.auction.exceptions;

public class ServiceException extends Exception {

    public ServiceException(String errorMessage) {
        super(errorMessage);
    }

    public ServiceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

