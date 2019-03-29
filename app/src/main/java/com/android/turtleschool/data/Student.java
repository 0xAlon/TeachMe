package com.android.turtleschool.data;

public class Student {

    private String presence_precent, first_grade, final_grade, fullname, subject, semester;

    public Student(String presence_precent, String first_grade, String final_grade, String fullname, String subject, String semester) {
        this.presence_precent = presence_precent;
        this.first_grade = first_grade;
        this.final_grade = final_grade;
        this.fullname = fullname;
        this.subject = subject;
        this.semester = semester;
    }

    public String getPresence_precent() {
        return presence_precent;
    }

    public String getFirst_grade() {
        return first_grade;
    }

    public String getFinal_grade() {
        return final_grade;
    }

    public String getFullname() {
        return fullname;
    }

    public String getSubject() {
        return subject;
    }

    public String getSemester() {
        return semester;
    }
}
