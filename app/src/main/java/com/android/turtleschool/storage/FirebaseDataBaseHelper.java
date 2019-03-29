package com.android.turtleschool.storage;

import com.android.turtleschool.adapters.StudentAdapter;
import com.android.turtleschool.data.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;

public class FirebaseDataBaseHelper {

    private static FirebaseDataBaseHelper instance;
    //private static int countID = 1;

    public static synchronized FirebaseDataBaseHelper getInstance() {
        FirebaseDataBaseHelper result = instance;
        if (result == null) {
            synchronized (FirebaseDataBaseHelper.class) {
                result = instance;
                if (result == null) {
                    instance = result = new FirebaseDataBaseHelper();
                }
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")

    public void fillSchoolDataFromFirebase(StudentAdapter studentAdapter) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("school/students");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<Student> studentList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HashMap<String, HashMap<String, String>> hashMap = (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                    for (Map.Entry entry : Objects.requireNonNull(hashMap).entrySet()) {
                        HashMap<String, String> map = (HashMap<String, String>) entry.getValue();
                        studentList.add(new Student(map.get("presence_precent"), map.get("first_grade"), map.get("final_grade"), map.get("fullname"), map.get("subject"), String.valueOf(entry.getKey().toString().charAt(entry.getKey().toString().length() -1))));
                    }
                }
                studentAdapter.setStudentList(studentList);
                studentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });
    }

    /*public void addDataStudent(String fullName, String final_grade, String first_grade, String presencePrecent) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("school/students/" + countID++);

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
    }*/
}

