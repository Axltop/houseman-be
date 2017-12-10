package com.houseman.housemanbe.helpers;

import lombok.Data;
import com.houseman.housemanbe.helpers.Constants.MessageType;

@Data

public class ResponseMessage {

    private String text;
    private String type;

    public ResponseMessage(String text, String type) {
        this.text = text;
        this.type = type;
    }
}
