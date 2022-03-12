package com.zhouqi.onlinecourseapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class CourseContentAdapter extends FragmentPagerAdapter {
    List<Fragment>fragmentList;
    String[]titles;

    public CourseContentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList=fragmentList;
        this.titles=titles;
    }

    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }
}
