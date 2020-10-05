package com.atlantbh.auction.exceptions;

/**
 * Exception that is thrown when there are errors within the business layer of the application.
 * Define the exception message within the class that is using the exception./
 *
 * @author Harun Hasic
 */
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

