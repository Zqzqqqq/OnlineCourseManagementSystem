package com.zhouqi.onlinecourseapp;

public class StudentUnitGrade {
    //记录学生的信息
    public String name;
    public double choiceGrade;
    public double judgementGrade;
    public double completionGrade;
    public double subjectiveGrade;

    //给主观题分的构造
    public StudentUnitGrade(String name, double chg,double jg,double cog,double sg) {
        this.name = name;
        this.choiceGrade = chg;
        this.judgementGrade = jg;
        this.completionGrade = cog;
        this.subjectiveGrade = sg;
    }

    //不给主观题分的构造
    public StudentUnitGrade(String name, double chg,double jg,double cog) {
        this.name = name;
        this.choiceGrade = chg;
        this.judgementGrade = jg;
        this.completionGrade = cog;
        this.subjectiveGrade = 0;
    }
}
