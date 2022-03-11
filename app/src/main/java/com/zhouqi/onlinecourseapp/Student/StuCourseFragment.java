package com.zhouqi.onlinecourseapp.Student;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhouqi.onlinecourseapp.R;

public class StuCourseFragment extends Fragment {
    public SearchView search;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_stu_course, container, false);
      //  search=root.findViewById(R.id.search_c);
      //  search.setQueryHint("查找课程");
        return root;
    }
}