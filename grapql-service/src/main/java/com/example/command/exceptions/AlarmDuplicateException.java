package com.example.command.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlarmDuplicateException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 3932249269639465576L;
    private final String message;
    private final Throwable throwable;

    public AlarmDuplicateException(String message) {
        this.message = message;
        this.throwable = new Throwable();

    }
    public AlarmDuplicateException(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    

}
