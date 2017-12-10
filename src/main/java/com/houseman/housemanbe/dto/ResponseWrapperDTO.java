package com.houseman.housemanbe.dto;

import com.houseman.housemanbe.helpers.ResponseMessage;
import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperDTO extends AbstractDTO {

    private static final long serialVersionUID = 1L;
    private Object data;
    private List<ResponseMessage> messages;
    private boolean error;

    public ResponseWrapperDTO(Object data) {
        this(data, null, false);
    }

    public ResponseWrapperDTO(Object data,  List<ResponseMessage> messages, boolean error) {
        super();
        this.data = data;
        this.messages = messages;
        this.error = error;
    }
}


