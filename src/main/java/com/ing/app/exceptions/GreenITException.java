package com.ing.app.exceptions;

import java.io.Serial;

public class GreenITException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public GreenITException(String message) {
        super(message);
    }

    public GreenITException(String message, Throwable cause) {
        super(message, cause);
    }
}
