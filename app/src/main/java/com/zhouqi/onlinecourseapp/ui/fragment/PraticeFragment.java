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
import com.zhouqi.onlinecourseapp.adapter.PraticeListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PraticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Map<String,Object>> mDataList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pratice,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.pratice_list);
        // 设置LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mDataList = getData();
        recyclerView.setAdapter(new PraticeListAdapter(this.getContext(),mDataList));
        return view;
    }

    private List<Map<String, Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pratice_word","实践报告书");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("pratice_word","实践报告上传");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("pratice_word","答辩");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("pratice_word","提问");
        list.add(map);

        return list;

    }


}