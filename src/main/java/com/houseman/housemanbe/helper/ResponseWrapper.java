package com.houseman.housemanbe.helper;

import com.houseman.housemanbe.model.AbstractModel;

import java.util.List;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ResponseMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ResponseMessage> messages) {
        this.messages = messages;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "data=" + data +
                ", messages=" + messages +
                ", error=" + error +
                '}';
    }
}


