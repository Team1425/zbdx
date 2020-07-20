package com.zb.utils;

public class CyxUserNotFoundException  extends  RuntimeException{
    public CyxUserNotFoundException() {
    }

    public CyxUserNotFoundException(String message) {
        super(message);
    }

    public CyxUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
