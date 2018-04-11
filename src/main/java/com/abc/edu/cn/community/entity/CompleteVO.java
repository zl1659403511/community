package com.abc.edu.cn.community.entity;

import java.util.Date;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 15:17
 */
public class CompleteVO {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    private String activityTopic;
    private String activityImage1;
    private String activityImage2;
    private String activityImage3;
    private String activityText1;
    private String activityText2;
    private String activityText3;
    private Date finishTime;
    private boolean isFinished;

    public String getActivityTopic() {
        return activityTopic;
    }

    public void setActivityTopic(String activityTopic) {
        this.activityTopic = activityTopic;
    }

    public String getActivityImage1() {
        return activityImage1;
    }

    public void setActivityImage1(String activityImage1) {
        this.activityImage1 = activityImage1;
    }

    public String getActivityImage2() {
        return activityImage2;
    }

    public void setActivityImage2(String activityImage2) {
        this.activityImage2 = activityImage2;
    }

    public String getActivityImage3() {
        return activityImage3;
    }

    public void setActivityImage3(String activityImage3) {
        this.activityImage3 = activityImage3;
    }

    public String getActivityText1() {
        return activityText1;
    }

    public void setActivityText1(String activityText1) {
        this.activityText1 = activityText1;
    }

    public String getActivityText2() {
        return activityText2;
    }

    public void setActivityText2(String activityText2) {
        this.activityText2 = activityText2;
    }

    public String getActivityText3() {
        return activityText3;
    }

    public void setActivityText3(String activityText3) {
        this.activityText3 = activityText3;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return "CompleteVO{" +
                "id='" + id + '\'' +
                ", activityTopic='" + activityTopic + '\'' +
                ", activityImage1='" + activityImage1 + '\'' +
                ", activityImage2='" + activityImage2 + '\'' +
                ", activityImage3='" + activityImage3 + '\'' +
                ", activityText1='" + activityText1 + '\'' +
                ", activityText2='" + activityText2 + '\'' +
                ", activityText3='" + activityText3 + '\'' +
                ", finishTime=" + finishTime +
                ", isFinished=" + isFinished +
                '}';
    }
}
