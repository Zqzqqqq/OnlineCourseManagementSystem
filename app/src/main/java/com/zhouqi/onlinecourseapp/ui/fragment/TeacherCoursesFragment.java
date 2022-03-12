package com.zhouqi.onlinecourseapp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.adapter.CourseAdapter;
import com.zhouqi.onlinecourseapp.entity.Course;
import com.zhouqi.onlinecourseapp.ui.activity.PublishCourseActivity;

import java.util.ArrayList;
import java.util.List;

public class TeacherCoursesFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView coursesRecyclerView;
    private CourseAdapter courseAdapter;
    private List<Course> courses;
    private Button publishNewCourse;


    public TeacherCoursesFragment() {

    }

    public static TeacherCoursesFragment newInstance() {
        TeacherCoursesFragment fragment = new TeacherCoursesFragment();
        return fragment;
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
                Intent intent = new Intent(getActivity(), PublishCourseActivity.class);
                startActivity(intent);
        }
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_teacher;
    }

    @Override
    protected void initView() {
        initCourses();
        courseAdapter = new CourseAdapter(courses);
        coursesRecyclerView = mRootView.findViewById(R.id.recyclerview_courses);
        publishNewCourse = mRootView.findViewById(R.id.button_publish);
        publishNewCourse.setOnClickListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        coursesRecyclerView.setLayoutManager(layoutManager);
        coursesRecyclerView.setAdapter(courseAdapter);
    }

    @Override
    protected void initData() {

    }
}