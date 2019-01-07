package com.panda.framework.domain;

import java.io.Serializable;

/**
 * @author jamie
 * @ClassName: JsonReturn
 * @Description:
 * @data 2019-01-07 12:03
 **/
public class JsonReturn implements Serializable {
    private static final long serialVersionUID = 6037176820363504311L;
    public static final int CODE_NO_LOGIN = -1;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_ERROR = 0;
    public static final int CODE_NO_AUTH_ERROR = -2;
    public static final Integer CODE_NO_DEVELOPER_AUTH_ERROR = -3;
    private Integer code = 1;
    private Integer serviceCode;
    private Object data = null;
    private String msg = "";
    private String field;

    public JsonReturn(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonReturn(Integer code, String field, String msg) {
        this.code = code;
        this.msg = msg;
        this.field = field;
    }

    public JsonReturn(Integer code, Integer serviceCode, String field, String msg) {
        this.code = code;
        this.serviceCode = serviceCode;
        this.msg = msg;
        this.field = field;
    }

    public JsonReturn() {
    }

    public JsonReturn(Object data) {
        this.data = data;
    }

    public JsonReturn(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        this.serviceCode = serviceCode;
    }
}
