package com.zhouqi.onlinecourseapp.Student;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;


import java.util.Collections;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public FragmentAdapter(FragmentManager fm,  List<Fragment> fragments) {
        super(fm);
        this.list= fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
