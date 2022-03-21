package com.mycompany.teamsranker.publisher.exceptions;

/**
 * Encompasses all exceptions managed in this application to ease hanlding
 * inside interfaces and abstract classes.
 *
 * @author Alex
 */
public class RankerException extends Exception {

    public RankerException(String msg) {
        super(msg);
    }

    public RankerException(String message, Throwable cause) {
        super(message, cause);
    }

}
