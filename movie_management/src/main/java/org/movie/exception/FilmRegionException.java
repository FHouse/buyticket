package org.movie.exception;

/**
 * Describe
 * Created by Wkz on 2017/3/30.
 */
public class FilmRegionException extends RuntimeException {
    private String message;

    public FilmRegionException(String exceptionMessage){
        super(exceptionMessage);
        this.message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
