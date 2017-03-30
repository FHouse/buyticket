package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class CollectionInfoException extends RuntimeException{
    private String message;

    public CollectionInfoException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
