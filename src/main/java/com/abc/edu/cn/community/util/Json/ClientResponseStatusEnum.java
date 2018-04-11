package com.abc.edu.cn.community.util.Json;

public enum ClientResponseStatusEnum {
    CLIENT_RESPONSE_SUCCESS("成功", "ok"),
    CLIENT_RESPONSE_FAILED("失败", "fail");
    private String message;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    ClientResponseStatusEnum(String msg, String message) {
        this.msg = msg;
        this.message = message;
    }
}
