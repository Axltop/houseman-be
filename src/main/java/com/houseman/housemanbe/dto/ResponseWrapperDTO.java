package com.houseman.housemanbe.dto;

import com.houseman.housemanbe.helpers.ResponseMessage;
import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperDTO extends AbstractDTO {

    private static final long serialVersionUID = 1L;
    private Object data;
    private Integer errorcode;
    private List<ResponseMessage> messages;
    private boolean error;

    public ResponseWrapperDTO(Object data) {
        this(data, null, null, false);
    }

    public ResponseWrapperDTO(Object data, Integer errorcode, List<ResponseMessage> messages, boolean error) {
        super();
        this.data = data;
        this.errorcode = errorcode;
        this.messages = messages;
        this.error = error;
    }
}


