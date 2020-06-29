package com.jay.prototype.demo02;

import java.util.Date;

/**
 * 1. implements Cloneable interface
 * 2. override clone() method
 */

public class Video implements Cloneable {
    private String name;
    private Date createTime;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        // deep clone       (serialize deserialize)
        Video video = (Video) obj;
        // clone object fields
        video.createTime = (Date) this.createTime.clone();

        return obj;
    }

    public Video() {
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}
