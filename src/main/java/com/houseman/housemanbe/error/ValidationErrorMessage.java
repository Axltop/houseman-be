package com.houseman.housemanbe.error;

public class ValidationErrorMessage {

    private String message;
    private Object invalidValue;

    public ValidationErrorMessage(String message, Object invalidValue) {
        this.message = message;
        this.invalidValue = invalidValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }
}
