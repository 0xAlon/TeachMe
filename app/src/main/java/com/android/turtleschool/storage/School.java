package com.android.turtleschool.storage;

import java.util.HashMap;

public class School {

    private HashMap<String, Profession> professionHashMap;
    private HashMap<String, Person> teacherList;
    private HashMap<String, Student> studentList;

    public HashMap<String, Profession> getProfessionHashMap() {
        return professionHashMap;
    }

    public HashMap<String, Person> getTeacherList() {
        return teacherList;
    }

    public HashMap<String, Student> getStudentList() {
        return studentList;
    }
}
