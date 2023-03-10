package com.posin.common.response.model;

import java.io.Serializable;

/**
 * @ClassName : RESTResponse
 * @Description : RESTResponse
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 17:50
 */
public class RESTResponse<R> implements Serializable {

    private static final long serialVersionUID = 2916781395918379481L;

    private Object code;

    private String message;

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }

    private R data;

    public RESTResponse() {
        this.code = "00";
    }

    public RESTResponse(Object code, String message, R data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RESTResponse(Object code, String message) {
        this.code = code;
        this.message = message;
    }

    public RESTResponse errorResponse(Object errorCode, String errorMessage) {
        return new RESTResponse(errorCode, errorMessage, null);
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
