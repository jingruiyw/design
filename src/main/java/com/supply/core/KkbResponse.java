package com.supply.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author kkb
 */
public class KkbResponse implements Serializable {


    private static final long serialVersionUID = -7318467237446066728L;
    private int code;
    private String msg;
    /**
     * @JsonInclude(Include.NON_NULL) 这个注解放在类头上就可以解决。 实体类与json互转的时候 属性值为null的不参与序列化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;


    public KkbResponse() {
        this(KkbStatus.SUCCESS, null);
    }

    public KkbResponse(Object data) {
        this(KkbStatus.SUCCESS, data);
    }

    public KkbResponse(KkbWebStatus kkbWebStatus) {
        this(kkbWebStatus, null);
    }

    public KkbResponse(KkbWebStatus kkbWebStatus, Object data) {
        this.code = kkbWebStatus.getCode();
        this.msg = kkbWebStatus.getMsg();
        this.data = data;
    }

    public KkbResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
