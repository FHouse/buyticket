package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/29.
 */
public class ExecutiveStaffTypeException extends RuntimeException {

    private String message;

    public ExecutiveStaffTypeException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    public String getMessage(){
        return message;
    }
}
