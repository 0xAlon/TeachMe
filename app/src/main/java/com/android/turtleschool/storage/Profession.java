package com.android.turtleschool.storage;

import java.util.List;

public class Profession {

    private List<String> teacherIdList, studentIdList;

    public List<String> getTeacherIdList() {
        return teacherIdList;
    }

    public void setTeacherIdList(List<String> teacherIdList) {
        this.teacherIdList = teacherIdList;
    }

    public List<String> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(List<String> studentIdList) {
        this.studentIdList = studentIdList;
    }
}
