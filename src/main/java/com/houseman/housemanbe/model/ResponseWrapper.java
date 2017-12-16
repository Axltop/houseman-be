package com.houseman.housemanbe.model;

import com.houseman.housemanbe.helper.ResponseMessage;
import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapper extends AbstractModel {

    private static final long serialVersionUID = 1L;
    private Object data;
    private List<ResponseMessage> messages;
    private boolean error;

    public ResponseWrapper(Object data) {
        this(data, null, false);
    }

    public ResponseWrapper(Object data, List<ResponseMessage> messages, boolean error) {
        super();
        this.data = data;
        this.messages = messages;
        this.error = error;
    }
}


