package org.example.Exception;

public class CellOccupiedException extends Exception{
    public CellOccupiedException() {
        super();
    }

    public CellOccupiedException(String message) {
        super(message);
    }

    public CellOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
