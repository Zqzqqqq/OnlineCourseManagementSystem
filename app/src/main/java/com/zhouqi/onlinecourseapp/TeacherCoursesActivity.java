package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhouqi.onlinecourseapp.adapter.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class TeacherCoursesActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView coursesRecyclerView;
    private CourseAdapter courseAdapter;
    private List<Course> courses;
    private Button publishNewCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teacher);
        initCourses();
        courseAdapter = new CourseAdapter(courses);
        coursesRecyclerView = findViewById(R.id.recyclerview_courses);
        publishNewCourse = findViewById(R.id.button_publish);
        publishNewCourse.setOnClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        coursesRecyclerView.setLayoutManager(layoutManager);
        coursesRecyclerView.setAdapter(courseAdapter);
    }



    private void initCourses() {
        courses = new ArrayList<>();
        courses.add(new Course(R.drawable.course_page,"形势与政策","南京师范大学","正在开课中"));
        courses.add(new Course(R.drawable.course_page,"形势与政策","南京师范大学","正在选课中"));
        courses.add(new Course(R.drawable.course_page,"形势与政策","南京师范大学","等待开课中"));
        courses.add(new Course(R.drawable.course_page,"形势与政策","南京师范大学","等待选课中"));
        courses.add(new Course(R.drawable.course_page,"形势与政策","南京师范大学","课程已结束"));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_publish:
                Intent intent = new Intent(TeacherCoursesActivity.this,PublishCourseActivity.class);
                startActivity(intent);
        }
    }

    public void backToMain(View view){
        finish();
    }
}