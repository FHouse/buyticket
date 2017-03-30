package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class FilmYearsException extends RuntimeException {
    private String message;

    public FilmYearsException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
