package org.example.Exception;

public class InvalidCellEntryException extends Exception{
    public InvalidCellEntryException() {
        super();
    }

    public InvalidCellEntryException(String message) {
        super(message);
    }

    public InvalidCellEntryException(String message, Throwable cause) {
        super(message, cause);
    }
}
