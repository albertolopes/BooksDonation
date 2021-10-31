package com.allo.booksdonation.exceptions;

public class IllegalStateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalStateException(String msg) {
        super(msg);
    }

    public IllegalStateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
