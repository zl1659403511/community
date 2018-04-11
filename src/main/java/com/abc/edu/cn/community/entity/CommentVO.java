package com.abc.edu.cn.community.entity;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-11 0:14
 */
public class CommentVO {
    private String id;
    private String activityComment;
    private Boolean isOver;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityComment() {
        return activityComment;
    }

    public void setActivityComment(String activityComment) {
        this.activityComment = activityComment;
    }

    public Boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(Boolean isOver) {
        this.isOver = isOver;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "id='" + id + '\'' +
                ", activityComment='" + activityComment + '\'' +
                ", isOver='" + isOver + '\'' +
                '}';
    }
}
