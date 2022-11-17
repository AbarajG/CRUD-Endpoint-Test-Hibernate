
package com.andygomez.main.errors;

public class DepartamentosNotFoundException extends Exception{

    public DepartamentosNotFoundException() {
    }

    public DepartamentosNotFoundException(String message) {
        super(message);
    }

    public DepartamentosNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartamentosNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartamentosNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
}
