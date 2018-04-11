package com.abc.edu.cn.community.util.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 9:11
 */
public class ClientResponseJSONBean {
    /**
     * 返回状态码
     */
    private String message;

    /**
     * 错误消息
     */
    private String msg;
    /**
     * 返回数据集合
     */
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public static ClientResponseJSONBean getSuccessClientResponseJSONBean() {
        ClientResponseJSONBean clientResponseJSONBean = new ClientResponseJSONBean();
        clientResponseJSONBean.setMessage(ClientResponseStatusEnum.CLIENT_RESPONSE_SUCCESS.getMessage());
        clientResponseJSONBean.setMsg("");
        clientResponseJSONBean.setData("");
        return clientResponseJSONBean;
    }

    public static ClientResponseJSONBean getFailedClientResponseJSONBean() {
        ClientResponseJSONBean clientResponseJSONBean = new ClientResponseJSONBean();
        clientResponseJSONBean.setMessage(ClientResponseStatusEnum.CLIENT_RESPONSE_FAILED.getMessage());
        clientResponseJSONBean.setMsg(ClientResponseStatusEnum.CLIENT_RESPONSE_FAILED.getMsg());
        clientResponseJSONBean.setData("");
        return clientResponseJSONBean;
    }
    public void setCodeAndMessage(ClientResponseStatusEnum enums) {
        setMessage(enums.getMessage());
        setMsg(enums.getMsg());
    }

    public final String toJSONString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
    }
}


