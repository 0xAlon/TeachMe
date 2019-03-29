package com.android.turtleschool.storage;

public class Student extends Person {

    private String firstGrade, finalGrade, presencePrecent;

    public Student(String fullname, String firstGrade, String finalGrade, String presencePrecent){
        setFullName(fullname);
        this.firstGrade = firstGrade;
        this.finalGrade = finalGrade;
        this.presencePrecent = presencePrecent;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getFirstGrade() {
        return firstGrade;
    }

    public void setFirstGrade(String firstGrade) {
        this.firstGrade = firstGrade;
    }

    public String getPresencePrecent() {
        return presencePrecent;
    }

    public void setPresencePrecent(String presencePrecent) {
        this.presencePrecent = presencePrecent;
    }

}
