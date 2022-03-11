package com.zhouqi.onlinecourseapp;

public class Course {
    public int imageId;
    public String name;
    public String organization;
    public String status;

    public Course(int imageId, String name, String organization, String status) {
        this.imageId = imageId;
        this.name = name;
        this.organization = organization;
        this.status = status;
    }
}
