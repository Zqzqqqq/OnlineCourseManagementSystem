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
import com.zhouqi.onlinecourseapp.adapter.AssessmentListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AssessmentFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Map<String,Object>> mDataList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_assessment,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.assessment_list);
        // 设置LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mDataList = getData();
        recyclerView.setAdapter(new AssessmentListAdapter(this.getContext(),mDataList));//这块的适配器类型需要改变
        return view;
    }
    private List<Map<String, Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("assess_name","矩阵单元测验");
        map.put("assess_time","提交截止: 2022-6-12  23:30");
        map.put("assess_totalscore","总分:60");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("assess_name","行列式单元测验");
        map.put("assess_time","提交截止: 2022-6-10  12:00");
        map.put("assess_totalscore","总分:100");
        list.add(map);

        return list;

    }




}