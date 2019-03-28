package com.android.turtleschool;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> originalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        originalList = new ArrayList<>();
        originalList.add("Alon");
        originalList.add("Alon1");
        originalList.add("Allp");
        originalList.add("Alon2");
    }

    @OnClick({R.id.tvSemester, R.id.tvStudentName, R.id.tvSubject})
    public void buttonClick(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        BottomSheetView bottomSheetView = new BottomSheetView(this, originalList);
        bottomSheetView.setCloseListener(bottomSheetDialog::dismiss);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        switch (view.getId()) {
            case R.id.tvSemester:
                break;
            case R.id.tvStudentName:
                break;
            case R.id.tvSubject:
                break;
        }
    }

    public interface CloseListener {
        void onCloseClicked();
    }
}
