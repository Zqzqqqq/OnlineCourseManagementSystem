package com.zhouqi.onlinecourseapp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.ui.fragment.ClassIntroductionFragment;
import com.zhouqi.onlinecourseapp.ui.fragment.EducateLineFragment;
import com.zhouqi.onlinecourseapp.adapter.MyPagerAdapter;
import com.zhouqi.onlinecourseapp.ui.fragment.OtherInfoFragment;

import java.util.ArrayList;

public class ClassActivity extends BaseActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles={"课程介绍","课程大纲","参考资料"};
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private Button mbutton;

    @Override
    protected int initLayout() {
        return R.layout.activity_class;
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.fixedViewPager);
        slidingTabLayout = findViewById(R.id.slidingTabLayout);
        mbutton=findViewById(R.id.button);
    }

    @Override
    protected void initData() {
        mFragments.add(ClassIntroductionFragment.newInstance());
        mFragments.add(EducateLineFragment.newInstance());
        mFragments.add(OtherInfoFragment.newInstance());
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
        slidingTabLayout.setViewPager(viewPager);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassActivity.this, CourseContentActivity.class);
                startActivity(intent);
            }
        });
    }
}