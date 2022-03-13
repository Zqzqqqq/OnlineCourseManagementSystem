package com.zhouqi.onlinecourseapp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

//import com.example.myapp.adapter.HomeAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.adapter.HomeAdapter;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles={"推荐","国家精品","精选微课","期末不挂","好课速递"};
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        viewPager = mRootView.findViewById(R.id.fixedViewPager);
        slidingTabLayout = mRootView.findViewById(R.id.slidingTabLayout);
    }

    @Override
    protected void initData() {
        for(String title:mTitles){
            mFragments.add(ClassFragment.newInstance(title));
        }
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.setAdapter(new HomeAdapter(getFragmentManager(),mTitles,mFragments));
        slidingTabLayout.setViewPager(viewPager);

    }


}