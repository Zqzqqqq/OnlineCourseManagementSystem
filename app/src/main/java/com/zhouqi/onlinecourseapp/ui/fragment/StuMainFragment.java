package com.zhouqi.onlinecourseapp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.adapter.FragmentAdapter;
import com.zhouqi.onlinecourseapp.ui.activity.ReminderActivity;

import java.util.ArrayList;
import java.util.List;

public class StuMainFragment extends BaseFragment {
    public ViewPager viewPager;
    public List<Fragment> mFragment;
    public FragmentAdapter adapter;

    public ImageButton ibtn_reminder;

    public TextView tv_course;
    public TextView tv_mycourse;
    public TextView tv_grade;

    public static StuMainFragment newInstance() {
        StuMainFragment fragment = new StuMainFragment();
        return fragment;
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

    @Override
    protected int initLayout() {
        return R.layout.fragment_stu_main;
    }

    @Override
    protected void initView() {
        viewPager=mRootView.findViewById(R.id.stu_viewpager);
        ibtn_reminder=mRootView.findViewById(R.id.ibtn_reminder);
        tv_course=mRootView.findViewById(R.id.course_main);
        tv_mycourse=mRootView.findViewById(R.id.my_course);
        tv_grade=mRootView.findViewById(R.id.grade_search);
        ibtn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReminderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

        mFragment=new ArrayList<>();
        mFragment.add(new StuCourseFragment());
        mFragment.add(new MyCourseFragment());
        mFragment.add(new GradeFragment());
        adapter=new FragmentAdapter(getActivity().getSupportFragmentManager(),mFragment);
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
}