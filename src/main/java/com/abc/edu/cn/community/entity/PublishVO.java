package com.abc.edu.cn.community.entity;

import java.util.Date;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 15:03
 */
public class PublishVO {


    private String loginName;
    private String activityPlace;
    private Date activityTime;
    private Date publishTime;
    private String activityContent;
    private boolean isFinished=false;
    private boolean isOver=false;
    private boolean isReceived=false;

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean rinished) {
        isFinished = isFinished;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(boolean over) {
        isOver = over;
    }

    public boolean getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(boolean received) {
        isReceived = received;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }
    @Override
    public String toString() {
        return "PublishVO{" +
                ", loginName='" + loginName + '\'' +
                ", activityPlace='" + activityPlace + '\'' +
                ", activityTime=" + activityTime +
                ", publishTime=" + publishTime +
                ", activityContent='" + activityContent + '\'' +
                ", isFinished=" + isFinished +
                ", isOver=" + isOver +
                ", isReceived=" + isReceived +
                '}';
    }

}
