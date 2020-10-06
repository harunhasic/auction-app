package com.atlantbh.auction.exceptions;

/**
 * Exception that is thrown when there are errors within the database interaction layer of the application.
 * Define the exception message within the class that is using the exception.
 *
 * @author Harun Hasic
 */
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