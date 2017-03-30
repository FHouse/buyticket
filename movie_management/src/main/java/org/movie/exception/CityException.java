package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class CityException extends RuntimeException {
    private String message;

    public CityException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    public String getMessage() {
        return message;
    }
}
