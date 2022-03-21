package com.mycompany.teamsranker.publisher.exceptions;

/**
 * Exception used to enclose rank table output exceptions.
 *
 * @author Alex
 */
public class OutputRankerException extends RankerException {

    public OutputRankerException(String msg) {
        super(msg);
    }

    public OutputRankerException(String message, Throwable cause) {
        super(message, cause);
    }
}
