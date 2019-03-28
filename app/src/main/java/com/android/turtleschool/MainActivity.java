package com.android.turtleschool;

import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> 6d7e9cb61b447ba94348440a5864eba5eeeea777

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private ArrayList<String> originalList;
=======
>>>>>>> 6d7e9cb61b447ba94348440a5864eba5eeeea777

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

<<<<<<< HEAD
        originalList = new ArrayList<>();
        originalList.add("Alon");
        originalList.add("Alon1");
        originalList.add("Allp");
        originalList.add("Alon2");

    }

    @OnClick({R.id.tvSemester, R.id.tvStudentName, R.id.tvSubject})
    public void buttonClick(View view) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        BottomSheetView bottomSheetView = new BottomSheetView(this,originalList);
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

    public interface CloseListener{
        void onCloseClicked();
=======
    }

    @OnClick(R.id.btnSheet)
    public void btnSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        BottomSheetView bottomSheetView = new BottomSheetView(this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
>>>>>>> 6d7e9cb61b447ba94348440a5864eba5eeeea777
    }
}
