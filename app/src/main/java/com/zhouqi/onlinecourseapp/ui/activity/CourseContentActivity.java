package com.zhouqi.onlinecourseapp.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.ui.fragment.AssessmentFragment;
import com.zhouqi.onlinecourseapp.adapter.CourseContentAdapter;
import com.zhouqi.onlinecourseapp.ui.fragment.CoursewareFragment;
import com.zhouqi.onlinecourseapp.ui.fragment.PraticeFragment;

import java.util.ArrayList;
import java.util.List;

public class CourseContentActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    String[]titles = {"课件","考核","实践"};
    private List<Fragment> fragmentList;// 页面
    private CourseContentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        initViews();
        initPager();

    }
    private void initViews() {
        tabLayout = findViewById(R.id.coursecontent_tab);
        viewPager = findViewById(R.id.coursecontent_viewpager);
    }

    private void initPager() {


        fragmentList = new ArrayList<>();
//        创建收入和支出页面，放置在Fragment当中
        CoursewareFragment cwFrag=new CoursewareFragment();//课件
        AssessmentFragment asFrag=new AssessmentFragment();//考核
        PraticeFragment prFrag=new PraticeFragment();//实践

        // OutcomeFragment outFrag = new OutcomeFragment(); //支出
        //IncomeFragment inFrag = new IncomeFragment(); //收入
        fragmentList.add(cwFrag);
        fragmentList.add(asFrag);
        fragmentList.add(prFrag);


//        创建适配器
        CourseContentAdapter adapter = new CourseContentAdapter(getSupportFragmentManager(),fragmentList,titles);
//        设置适配器
        viewPager.setAdapter(adapter);
        //将TabLayout和ViwePager进行关联
        tabLayout.setupWithViewPager(viewPager);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coursecontent_back:
                finish();
                break;
        }
    }
}