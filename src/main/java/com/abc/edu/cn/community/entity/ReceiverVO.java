package com.abc.edu.cn.community.entity;

import java.util.Date;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 15:10
 */
public class ReceiverVO {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    private String loginName;
    private String receiverManagement;
    private boolean isReceived=true;

    public String getReceiverManagement() {
        return receiverManagement;
    }

    public void setReceiverManagement(String receiverManagement) {
        this.receiverManagement = receiverManagement;
    }

    public boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(boolean received) {
        isReceived = received;
    }
}
