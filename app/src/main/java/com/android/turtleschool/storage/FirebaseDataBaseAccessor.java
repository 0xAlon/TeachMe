package com.android.turtleschool.storage;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

import androidx.annotation.NonNull;

public class FirebaseDataBaseAccessor {

    private static FirebaseDataBaseAccessor instance;
    private School school;
    static int countID = 1;

    public static synchronized FirebaseDataBaseAccessor getInstance() {
        FirebaseDataBaseAccessor result = instance;
        if (result == null) {
            synchronized (FirebaseDataBaseAccessor.class) {
                result = instance;
                if (result == null) {
                    instance = result = new FirebaseDataBaseAccessor();
                }
            }
        }
        return result;
    }
        //
       public void fillSchoolDataFromFirebase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("school/students");

        //myRef.child("students");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //School school = dataSnapshot.getValue(School.class);
                ArrayList<Student> students = new ArrayList() ;
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    Student student = snapshot.getValue(Student.class);
                    students.add(student);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });
    }

    public void addDataStudent(String fullName, String final_grade, String first_grade, String presencePrecent) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("school/students/"+countID++);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //School school = dataSnapshot.getValue(School.class);
                dataSnapshot.child("fullName").getRef().setValue(fullName);
                dataSnapshot.child("final_grade").getRef().setValue(final_grade);
                dataSnapshot.child("first_grade").getRef().setValue(first_grade);
                dataSnapshot.child("presence_precent").getRef().setValue(presencePrecent);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });

    }
    public School getSchoolData() {
        return school;
    }
}

