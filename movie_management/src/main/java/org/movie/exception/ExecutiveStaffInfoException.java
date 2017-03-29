package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/29.
 */
public class ExecutiveStaffInfoException extends RuntimeException {
    private String message;

    public ExecutiveStaffInfoException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    public String getMessage(){
        return message;
    }
}
