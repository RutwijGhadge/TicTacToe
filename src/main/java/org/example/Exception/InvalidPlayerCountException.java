package org.example.Exception;

public class InvalidPlayerCountException extends Exception{
    public InvalidPlayerCountException() {
        super();
    }

    public InvalidPlayerCountException(String message) {
        super(message);
    }

    public InvalidPlayerCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
