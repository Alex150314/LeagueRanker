package com.mycompany.teamsranker.publisher.exceptions;

/**
 * Exception used to enclose all exception related to the data access.
 *
 * @author Alex
 */
public class UnableToAccessDataException extends RankerException {

    public UnableToAccessDataException(String msg) {
        super(msg);
    }

    public UnableToAccessDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
