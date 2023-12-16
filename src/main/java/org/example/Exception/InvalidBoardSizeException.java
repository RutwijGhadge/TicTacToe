package org.example.Exception;

public class InvalidBoardSizeException extends Exception{
    public InvalidBoardSizeException() {
        super();
    }

    public InvalidBoardSizeException(String message) {
        super(message);
    }

    public InvalidBoardSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
