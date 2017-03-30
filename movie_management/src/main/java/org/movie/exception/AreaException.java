package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class AreaException extends RuntimeException {

    private String message;

    public AreaException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    public String getMessage() {
        return message;
    }
}
