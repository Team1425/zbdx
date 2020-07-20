package com.zb.pojo.wymteacher;

public class wymTeaJsonResult {
    private Integer code;
    private String message;
    private Integer count;
    private Object data;

    public wymTeaJsonResult(Integer code, String message, Integer count, Object data) {
        this.code = code;
        this.message = message;
        this.count = count;
        this.data = data;
    }
}
