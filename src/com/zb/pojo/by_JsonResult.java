package com.zb.pojo;

public class by_JsonResult {
    Integer code;
    String message;
    Integer count;
    Object data;

    public by_JsonResult(Integer code, String message, Integer count, Object data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }
}
