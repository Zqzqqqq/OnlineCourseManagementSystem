package com.zhouqi.onlinecourseapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zhouqi.onlinecourseapp.R;

import java.util.ArrayList;
import java.util.List;

public class StuMainActivity extends AppCompatActivity {
    public ViewPager viewPager;
    public List<Fragment> mFragment;
    public FragmentAdapter adapter;

    public ImageButton ibtn_reminder;

    public TextView tv_course;
    public TextView tv_mycourse;
    public TextView tv_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_main);
        initViews();
        initDatas();
        ibtn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StuMainActivity.this,ReminderActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initViews(){
        viewPager=findViewById(R.id.stu_viewpager);
        ibtn_reminder=findViewById(R.id.ibtn_reminder);
        tv_course=findViewById(R.id.course_main);
        tv_mycourse=findViewById(R.id.my_course);
        tv_grade=findViewById(R.id.grade_search);
    }
    public void initDatas(){
        mFragment=new ArrayList<>();
        mFragment.add(new StuCourseFragment());
        mFragment.add(new MyCourseFragment());
        mFragment.add(new GradeFragment());
        adapter=new FragmentAdapter(getSupportFragmentManager(),mFragment);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                viewPager.setCurrentItem(position);
                setStyle();
                setSelected(position);


                }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    public void setStyle(){
        setDeafultTvStyle(tv_mycourse);
        setDeafultTvStyle(tv_course);
        setDeafultTvStyle(tv_grade);
    }
    public void setDeafultTvStyle(TextView tv){
        tv.setTextColor(Color.GRAY);
        tv.setTextSize(20);
        tv.setTypeface(Typeface.DEFAULT);
    }
    public void setSelected(int position){
        switch(position) {
            case 0:
                setSelectedTvStyle(tv_course);
                break;
            case 1:
                setSelectedTvStyle(tv_mycourse);
                break;
            case 2:
                setSelectedTvStyle(tv_grade);
                break;

        }

    }
    public void setSelectedTvStyle(TextView tv){
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(25);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
    }
}