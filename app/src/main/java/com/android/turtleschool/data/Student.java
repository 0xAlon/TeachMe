package com.android.turtleschool.data;

public class Student {

    private String presence_precent, first_grade, final_grade, fullName;

    public Student(){

    }

    public Student(String fullName, String first_grade, String final_grade, String presence_precent) {
        this.presence_precent = presence_precent;
        this.first_grade = first_grade;
        this.final_grade = final_grade;
        this.fullName = fullName;
    }

    public String getFinal_grade() {
        return final_grade;
    }

    public String getFirst_grade() {
        return first_grade;
    }

    public String getPresence_precent() {
        return presence_precent;
    }

    public String getFullName() {
        return fullName;
    }
}
