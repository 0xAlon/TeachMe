package com.android.turtleschool;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvSubject)
    TextView tvSubject;
    @BindView(R.id.tvStudentName)
    TextView tvStudentName;
    @BindView(R.id.tvSemester)
    TextView tvSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        float[] hsv = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.colorGreen), hsv);
        hsv[2] *= 0.8f; // value component
        getWindow().setStatusBarColor(Color.HSVToColor(hsv));
    }

    @OnClick({R.id.tvSemester, R.id.tvStudentName, R.id.tvSubject})
    public void buttonClick(View view) {
        ArrayList<String> originalList = new ArrayList<>();
        String type = "";
        switch (view.getId()) {
            case R.id.tvSemester:
                type = "semester";
                originalList.add("סמסטר 1");
                originalList.add("סמסטר 2");
                originalList.add("סמסטר 3");
                originalList.add("סמסטר 4");
                break;
            case R.id.tvStudentName:
                type = "studentName";
                originalList.add("Alon");
                originalList.add("Alon1");
                originalList.add("Allp");
                originalList.add("Alon2");
                break;
            case R.id.tvSubject:
                type = "subject";
                originalList.add("history");
                originalList.add("math");
                originalList.add("sport");
                break;
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        BottomSheetView bottomSheetView = new BottomSheetView(this, originalList, type);
        bottomSheetView.setOnCloseListener(bottomSheetDialog::dismiss);
        bottomSheetView.setOnChoseValueListener((type1, value) -> {
            switch (type1) {
                case "subject":
                    tvSubject.setText(value);
                    break;
                case "semester":
                    tvSemester.setText(value);
                    break;
                case "studentName":
                    tvStudentName.setText(value);
                    break;
            }
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    public interface OnCloseListener {
        void onCloseClicked();
    }

    public interface OnChoseValueListener {
        void onChoseValue(String type, String value);
    }
}
