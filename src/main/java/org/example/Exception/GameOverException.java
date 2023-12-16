package org.example.Exception;

public class GameOverException extends Exception{
    public GameOverException() {
        super();
    }

    public GameOverException(String message) {
        super(message);
    }

    public GameOverException(String message, Throwable cause) {
        super(message, cause);
    }
}
