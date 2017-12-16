package com.houseman.housemanbe.helper;

import lombok.Data;

@Data

public class ResponseMessage {

    private String text;
    private String type;

    public ResponseMessage(String text, String type) {
        this.text = text;
        this.type = type;
    }
}
