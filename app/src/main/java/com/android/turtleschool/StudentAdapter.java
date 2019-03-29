package com.android.turtleschool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<String> studentList;

    StudentAdapter(List<String> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(View.inflate(parent.getContext(), R.layout.row_student_detail, null));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        String student = studentList.get(position);
        holder.tvName.setText(student);
        holder.tvGrade1.setText("90");
        holder.tvGrade2.setText("100");
        holder.tvSemester.setText("א");
        holder.tvSubject.setText("אנגלית");
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void setStudentList(List<String> studentList) {
        this.studentList = studentList;
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvGrade1)
        TextView tvGrade1;
        @BindView(R.id.tvGrade2)
        TextView tvGrade2;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvSemester)
        TextView tvSemester;
        @BindView(R.id.tvSubject)
        TextView tvSubject;

        StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
