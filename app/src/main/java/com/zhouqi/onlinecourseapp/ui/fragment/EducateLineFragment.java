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
 * Use the {@link EducateLineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducateLineFragment extends BaseFragment {
    private ListView mylistview;

    public EducateLineFragment() {
        // Required empty public constructor
    }


    public static EducateLineFragment newInstance() {
        EducateLineFragment fragment = new EducateLineFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_educate_line;
    }

    @Override
    protected void initView() {
        mylistview=mRootView.findViewById(R.id.kcdg_container);
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
        map.put("context", "目  录\n" +
                "\n" +
                "第1章  绪论\n" +
                "1.1  数据结构课程的研究内容\n" +
                "1.2  算法与算法分析\n" +
                "\t\n" +
                "第2章  线性表\n" +
                "2.1  线性表的基本概念\n" +
                "2.2  线性表的存储结构\n" +
                "2.2.1  顺序存储结构\n" +
                "2.2.2  链式存储结构\n" +
                "2.3  线性表的操作算法\n" +
                "2.3.1  顺序表的操作算法\n" +
                "2.3.2  链表的操作算法\n" +
                "2.4  线性表的应用\n" +
                "2.5  顺序表和链表的综合比较\n" +
                "本章小结\n" +
                "习题2\n" +
                "上机实验题2\t\n" +
                "第3章  栈和队列\n" +
                "3.1  栈\n" +
                "3.1.1  栈的基本概念\n" +
                "3.1.2  栈的存储结构\n" +
                "3.1.3  栈的操作算法\n" +
                "3.1.4  栈的应用\n" +
                "3.2  队列\n" +
                "3.2.1  队列的基本概念\n" +
                "3.2.2  队列的存储结构\n" +
                "3.2.3  队列的操作算法\n" +
                "3.2.4  队列的应用\n" +
                "本章小结\n" +
                "习题3\n" +
                "上机实验题3\n" +
                "第4章  串\n" +
                "4.1  串的基本概念\n" +
                "4.2  串的存储结构\n" +
                "4.2.1 串的顺序存储结构\n" +
                "4.2.2  串的链式存储结构\n" +
                "4.3  串的操作算法\n" +
                "4.3.1  串的基本操作算法\n" +
                "4.3.2  串的模式匹配\n" +
                "4.4  串的应用\n" +
                "本章小结\n" +
                "习题4\n" +
                "上机实验题4\n" +
                "第5章  数组和特殊矩阵\n" +
                "5.1  数组\n" +
                "5.1.1  数组的基本概念\n" +
                "5.1.2  数组的存储结构\n" +
                "5.2  特殊矩阵的压缩存储\n" +
                "5.2.1  对称矩阵的压缩存储\n" +
                "5.2.2  三角矩阵的压缩存储\n" +
                "5.2.3  对角矩阵的压缩存储\n" +
                "5.2.4  稀疏矩阵的压缩存储\n" +
                "本章小结\n" +
                "习题5\n" +
                "上机实验题5\t\n" +
                "第6章  广义表\n" +
                "6.1  广义表的概念\n" +
                "6.2  广义表的存储结构\n" +
                "6.2.1  广义表中结点的结构\n" +
                "6.2.2  广义表的存储结构\n" +
                "6.3  广义表的操作算法\n" +
                "6.3.1 构造算法\n" +
                "6.3.2  遍历广义表\n" +
                "6.3.3  广义表其他操作算法\n" +
                "本章小结\n" +
                "习题6\n" +
                "上机实验题6\t\n" +
                "第7章  树和二叉树\n" +
                "7.1  树的概念和性质\n" +
                "7.1.1  树的定义\n" +
                "7.1.2  树的基本术语\n" +
                "7.1.3  树的基本性质\n" +
                "7.2  二叉树的概念和性质\n" +
                "7.2.1  二叉树的定义\n" +
                "7.2.2  二叉树的基本性质\n" +
                "7.3  二叉树的存储结构\n" +
                "7.3.1  二叉树的顺序存储结构\n" +
                "7.3.2  二叉树的链式存储结构\n" +
                "7.4  二叉树的遍历\n" +
                "7.4.1  二叉树遍历的概念\n" +
                "7.4.2  二叉树遍历的算法\n" +
                "7.4.3 二叉树的构造和析构算法\n" +
                "7.5  二叉树的其他操作算法\n" +
                "7.6  线索二叉树\n" +
                "7.6.1  线索二叉树的概念\n" +
                "7.6.2  线索二叉树的存储结构\n" +
                "7.6.3  线索二叉树的操作算法\n" +
                "7.7  树的存储结构与算法\n" +
                "7.7.1  树的存储结构\n" +
                "7.7.2  树的操作算法\n" +
                "7.8  Huffman树与Huffman编码\n" +
                "7.8.1  Huffman树的定义\n" +
                "7.8.2  Huffman树的构造\n" +
                "7.8.3  Huffman编码与译码\n" +
                "7.8.4 Huffman树的其他应用\n" +
                "7.9  树与等价类\n" +
                "7.9.1  等价类问题\n" +
                "7.9.2  等价类的实现\n" +
                "7.9.3  性能分析与改进\n" +
                "本章小结\n" +
                "习题7\n" +
                "上机实验题7\t\n" +
                "第8章  图\n" +
                "8.1  图的基本概念\n" +
                "8.1.1  图的定义\n" +
                "8.1.2  图的基本术语\n" +
                "8.2  图的存储结构\n" +
                "8.2.1  邻接矩阵表示法\n" +
                "8.2.2  邻接表表示法\n" +
                "8.3  图的遍历\n" +
                "8.3.1  图遍历的概念\n" +
                "8.3.2  深度优先搜索\n" +
                "8.3.3  广度优先搜索\n" +
                "8.3.4  图遍历算法的应用\n" +
                "8.4  最小生成树\n" +
                "8.4.1  最小生成树的概念及其性质\n" +
                "8.4.2  Prim算法\n" +
                "8.4.3  Kruskal算法\n" +
                "8.5  最短路径\n" +
                "8.5.1  最短路径的概念\n" +
                "8.5.2  单源最短路径\n" +
                "8.5.3  每对顶点之间的最短路径\n" +
                "8.6  AOV网与拓扑排序\n" +
                "8.6.1  有向无环图与AOV网的概念\n" +
                "8.6.2  拓扑排序\n" +
                "8.7  AOE网与关键路径\n" +
                "    8.7.1  AOE网的概念\n" +
                "8.7.2  关键路径\n" +
                "本章小结\n" +
                "习题8\n" +
                "上机实验题8\n" +
                "第9章  查找\n" +
                "9.1  查找的基本概念\n" +
                "9.2  线性表的查找\n" +
                "9.2.1  顺序查找\n" +
                "9.2.2  折半查找\n" +
                "9.2.3  分块查找\n" +
                "9.3  树表的查找\n" +
                "9.3.1  二叉排序树\n" +
                "9.3.2  平衡二叉树\n" +
                "9.3.3  B树\n" +
                "9.3.4  B+树\n" +
                "9.4  Hash查找\n" +
                "9.4.1  Hash查找的基本概念\n" +
                "9.4.2  Hash表的构造\n" +
                "9.4.3  Hash查找算法及分析\n" +
                "本章小结\n" +
                "习题9\n" +
                "上机实验题9\n" +
                "\n" +
                "第10章  排序\n" +
                "10.1  排序的基本概念\n" +
                "10.2  冒泡排序\n" +
                "10.3  选择排序\n" +
                "10.4  插入排序\n" +
                "        10.4.1  直接插入排序\n" +
                "        10.4.2  折半插入排序\n" +
                "10.5  希尔排序\n" +
                "10.6  快速排序\n" +
                "10.7  堆排序\n" +
                "10.8  归并排序\n" +
                "10.8.1  二路归并排序的非递归实现\n" +
                "10.8.2  二路归并排序的递归实现\n" +
                "10.9  基数排序\n" +
                "10.9.1  多关键字排序\n" +
                "10.9.2  链式基数排序\n" +
                "上机实验题10\n" +
                "\n" +
                " \n");
        list.add(map);
        return list;
    }
}