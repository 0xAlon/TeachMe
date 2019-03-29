package com.android.turtleschool.data;

public class Semester {

    private String semester;
    private Student student;

    public Semester() {
    }

    public Semester(String semester, Student student) {
        this.semester = semester;
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public Student getStudent() {
        return student;
    }
}
