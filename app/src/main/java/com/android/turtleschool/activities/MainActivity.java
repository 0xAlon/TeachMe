package com.android.turtleschool.activities;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.turtleschool.R;
import com.android.turtleschool.adapters.StudentAdapter;
import com.android.turtleschool.custom_views.BottomSheetView;
import com.android.turtleschool.data.Student;
import com.android.turtleschool.storage.FirebaseDataBaseHelper;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tvSubject)
    TextView tvSubject;
    @BindView(R.id.tvStudentName)
    TextView tvStudentName;
    @BindView(R.id.tvSemester)
    TextView tvSemester;
    @BindView(R.id.tvStartWorking)
    TextView tvStartWorking;
    @BindView(R.id.rvList)
    RecyclerView rvList;
    private StudentAdapter studentAdapter;
    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = (int) ((float) 5 * (getResources().getDisplayMetrics().densityDpi / 160f));
            }
        });
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
                originalList.add("אלון טפליצקי");
                originalList.add("אלירז סבג");
                originalList.add("אלינור כהן");
                originalList.add("אלי דוידי");
                originalList.add("אסף צפני");
                originalList.add("אסי רווח");
                originalList.add("אסולין גנות");
                originalList.add("רפאל בקר");
                originalList.add("רפי דוידי");
                originalList.add("רפול גת");
                break;
            case R.id.tvSubject:
                type = "subject";
                originalList.add("היסטוריה");
                originalList.add("מתמטיקה");
                originalList.add("ספרות");
                originalList.add("ספורט");
                originalList.add("לשון");
                originalList.add("אנגלית");
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
            tvStartWorking.setVisibility(View.GONE);
            if (studentAdapter == null) {
                rvList.setAdapter(studentAdapter = new StudentAdapter(studentList));
            }
            FirebaseDataBaseHelper.getInstance().fillSchoolDataFromFirebase(studentAdapter, type1, value);
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
