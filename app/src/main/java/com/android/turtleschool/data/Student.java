package com.android.turtleschool.data;

public class Student extends Person {

    private String presence_precent, first_grade, final_grade;

    public Student(){

    }

    public Student(String fullName, String first_grade, String final_grade, String presence_precent) {
        this.presence_precent = presence_precent;
        this.first_grade = first_grade;
        this.final_grade = final_grade;
        setFullName(fullName);
    }

    public String getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(String final_grade) {
        this.final_grade = final_grade;
    }

    public String getFirst_grade() {
        return first_grade;
    }

    public void setFirst_grade(String first_grade) {
        this.first_grade = first_grade;
    }

    public String getPresence_precent() {
        return presence_precent;
    }

    public void setPresence_precent(String presence_precent) {
        this.presence_precent = presence_precent;
    }
}
