package com.zhouqi.onlinecourseapp.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.adapter.ClassAdapter;
import com.zhouqi.onlinecourseapp.entity.ClassEntity;

import java.util.ArrayList;
import java.util.List;

public class ClassFragment extends BaseFragment {

    private String title;
    private int categoryId;
    private RecyclerView recyclerView;
    private List<ClassEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    public ClassFragment() {
    }
    public static ClassFragment newInstance(String title) {
        ClassFragment fragment = new ClassFragment();
        fragment.title = title;
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView() {
        recyclerView = mRootView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        for(int i=0;i<8;i++){
            ClassEntity classEntity=new ClassEntity();
            classEntity.setClassname("数据结构");
            classEntity.setSchoolname("南京师范大学");
            classEntity.setClassState("课程已进行至第"+(i+1)+"周");
            datas.add(classEntity);
        }
        ClassAdapter classAdapter=new ClassAdapter(getActivity(),datas);
        recyclerView.setAdapter(classAdapter);
    }



}