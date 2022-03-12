package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.zhouqi.onlinecourseapp.adapter.StudentDataGradeAdapter;
import com.zhouqi.onlinecourseapp.adapter.StudentUnitGradeAdapter;

import java.util.ArrayList;
import java.util.List;

public class OneUnitGradeActivity extends AppCompatActivity {
    RecyclerView OneUnitGradeRecyclerView;
    StudentUnitGradeAdapter studentUnitGradeAdapter;
    List<StudentUnitGrade> studentUnitGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_unit_grade);
        OneUnitGradeRecyclerView = findViewById(R.id.recycler_one_unit_grade);

        studentUnitGrades = new ArrayList<>();
        studentUnitGrades.add(new StudentUnitGrade("刘雨鑫", 19, 30, 30));
        studentUnitGrades.add(new StudentUnitGrade("周奇", 20, 27, 29));
        studentUnitGrades.add(new StudentUnitGrade("华嘉豪", 24, 25, 30));

        studentUnitGradeAdapter = new StudentUnitGradeAdapter(studentUnitGrades);
        studentUnitGradeAdapter.setOnItemClickListener(new StudentUnitGradeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Dialog dialog = new SubjectiveQuestionDialog(OneUnitGradeActivity.this);
                dialog.show();
            }

        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        OneUnitGradeRecyclerView.setLayoutManager(layoutManager);
        OneUnitGradeRecyclerView.setAdapter(studentUnitGradeAdapter);
    }

}