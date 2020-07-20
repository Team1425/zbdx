package com.zb.pojo.Yzzpojo;

public class YzzJsonResult {
    Integer code;
    String message;
    Integer count;
    Object data;

    public YzzJsonResult(Integer code, String message, Integer count, Object data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }
}
