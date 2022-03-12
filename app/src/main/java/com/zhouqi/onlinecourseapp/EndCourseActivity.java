package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhouqi.onlinecourseapp.adapter.StudentDataGradeAdapter;

import java.util.ArrayList;
import java.util.List;

public class EndCourseActivity extends AppCompatActivity {

    RecyclerView studentDataGradeRecyclerView;
    StudentDataGradeAdapter studentDataGradeAdapter;
    List<StudentData> studentDatas;
    Button btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_course);
        btnSelect=findViewById(R.id.btn_alert_select);
        studentDataGradeRecyclerView=findViewById(R.id.recycler_end_course);

        studentDatas=new ArrayList<>();
        studentDatas.add(new StudentData("刘雨鑫",19190410,59));
        studentDatas.add(new StudentData("周奇",19190424,89));
        studentDatas.add(new StudentData("华嘉豪",19190406,90));

        studentDataGradeAdapter=new StudentDataGradeAdapter(studentDatas);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        studentDataGradeRecyclerView.setLayoutManager(layoutManager);
        studentDataGradeRecyclerView.setAdapter(studentDataGradeAdapter);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDataGradeAdapter=new StudentDataGradeAdapter(studentDatas);
                LinearLayoutManager layoutManager=new LinearLayoutManager(EndCourseActivity.this);
                studentDataGradeRecyclerView.setLayoutManager(layoutManager);
                studentDataGradeRecyclerView.setAdapter(studentDataGradeAdapter);
            }
        });


    }
}