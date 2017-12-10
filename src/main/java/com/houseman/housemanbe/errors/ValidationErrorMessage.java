package com.houseman.housemanbe.errors;

import lombok.Data;

@Data
public class ValidationErrorMessage {

    private String message;
    private Object invalidValue;

    public ValidationErrorMessage(String message, Object invalidValue) {
        this.message = message;
        this.invalidValue = invalidValue;
    }
}
