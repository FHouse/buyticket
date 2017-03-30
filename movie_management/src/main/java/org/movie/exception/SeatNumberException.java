package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class SeatNumberException extends RuntimeException {
    private String message;

    public SeatNumberException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
