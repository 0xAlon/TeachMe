package com.android.turtleschool;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvSemester,R.id.tvStudentName,R.id.tvSubject})
    public void buttonClick(View view) {

        switch (view.getId()){
            case R.id.tvSemester:
                Toast.makeText(this, "Semester", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvStudentName:
                Toast.makeText(this, "StudentName", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvSubject:
                Toast.makeText(this, "Subject", Toast.LENGTH_SHORT).show();
                break;
        }
        /*BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        BottomSheetView bottomSheetView = new BottomSheetView(this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();*/
    }
}
