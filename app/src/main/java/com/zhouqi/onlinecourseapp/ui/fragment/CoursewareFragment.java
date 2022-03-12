package com.zhouqi.onlinecourseapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.adapter.CourseWareListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CoursewareFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Map<String,Object>> mDataList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_courseware,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.courseware_list);
        // 设置LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mDataList = getData();
        recyclerView.setAdapter(new CourseWareListAdapter(this.getContext(),mDataList));
        return view;
    }

    private List<Map<String, Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("course_id","矩阵");

        map.put("item_videoicon",R.mipmap.ic_video);
        map.put("course_video","课程视频");
        map.put("item_videoplay",R.mipmap.ic_playvideo);

        map.put("item_ppt",R.mipmap.ic_ppt);
        map.put("course_ppt","课件PPT");
        map.put("item_download",R.mipmap.ic_download);

        map.put("item_test",R.mipmap.ic_test);
        map.put("course_test","课程作业");
        map.put("item_goin",R.mipmap.ic_goin);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("course_id","行列式");

        map.put("item_videoicon",R.mipmap.ic_video);
        map.put("course_video","课程视频");
        map.put("item_videoplay",R.mipmap.ic_playvideo);

        map.put("item_ppt",R.mipmap.ic_ppt);
        map.put("course_ppt","课件PPT");
        map.put("item_download",R.mipmap.ic_download);

        map.put("item_test",R.mipmap.ic_test);
        map.put("course_test","课程作业");
        map.put("item_goin",R.mipmap.ic_goin);
        list.add(map);

        return list;

    }
}