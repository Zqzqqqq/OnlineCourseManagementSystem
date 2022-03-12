package com.zhouqi.onlinecourseapp.ui.fragment;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;

import com.zhouqi.onlinecourseapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassIntroductionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassIntroductionFragment extends BaseFragment {
    private ListView mylistview;

    public ClassIntroductionFragment() {
        // Required empty public constructor
    }


    public static ClassIntroductionFragment newInstance() {
        ClassIntroductionFragment fragment = new ClassIntroductionFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_class_introduction;
    }

    @Override
    protected void initView() {
        mylistview=mRootView.findViewById(R.id.kcjj_container);
    }

    @Override
    protected void initData() {
        mylistview.setAdapter(new SimpleAdapter(getContext(),
                                                getData(),
                                                R.layout.item_describe_layout,
                                                new String[]{"title","context"},
                                                new int[]{R.id.title,R.id.context}));
    }

    private List<Map<String,Object>> getData(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "课程简介");
        map.put("context", "\t数据结构是计算机类专业核心基础课，也是计算机类考研必考课程，IT行业求职时通常会考查数据结构相关的知识和技能。通过本课程学习，要求学生掌握数据结构和算法的基本概念和技术，并设计相应的操作算法。掌握线性表、栈和队列、串、广义表、树和二叉树、图等典型数据结构及相关算法，以及排序、查找等重要技术。\n" +
                "\t该课程的学习目的是：提高学生的算法设计能力，使学生能够对于给定问题选择合适的数据结构，设计高质量算法，能够编写解决复杂问题的程序。\n" +
                "\t该课程为一些后续的计算机专业课程，例如操作系统、编译原理以及数据库应用系统开发等打下扎实深厚的基础，提供知识准备\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "课程特色");
        map.put("context", "\t数据结构是计算机类专业核心基础课，也是计算机类考研必考课程，IT行业求职时通常会考查数据结构相关的知识和技能。通过本课程学习，要求学生掌握数据结构和算法的基本概念和技术，并设计相应的操作算法。掌握线性表、栈和队列、串、广义表、树和二叉树、图等典型数据结构及相关算法，以及排序、查找等重要技术。\n" +
                "\t该课程的学习目的是：提高学生的算法设计能力，使学生能够对于给定问题选择合适的数据结构，设计高质量算法，能够编写解决复杂问题的程序。\n" +
                "\t该课程为一些后续的计算机专业课程，例如操作系统、编译原理以及数据库应用系统开发等打下扎实深厚的基础，提供知识准备\n");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "教学团队");
        map.put("context", "南京师范大学\n陈波教授");
        list.add(map);
        return list;
    }
}