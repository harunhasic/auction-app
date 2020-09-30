package com.atlantbh.auction.exceptions;

public class RepositoryException extends Exception {

    public RepositoryException(String errorMessage) {
        super(errorMessage);
    }

    public RepositoryException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}