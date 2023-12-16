package org.example.Exception;

public class DuplicateSymbolFoundExcepion extends Exception{
    public DuplicateSymbolFoundExcepion() {
        super();
    }

    public DuplicateSymbolFoundExcepion(String message) {
        super(message);
    }

    public DuplicateSymbolFoundExcepion(String message, Throwable cause) {
        super(message, cause);
    }
}
