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
 * Use the {@link OtherInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherInfoFragment extends BaseFragment {
    private ListView mylistview;

    public OtherInfoFragment() {
        // Required empty public constructor
    }


    public static OtherInfoFragment newInstance() {
        OtherInfoFragment fragment = new OtherInfoFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_otherinfo;
    }

    @Override
    protected void initView() {
        mylistview=mRootView.findViewById(R.id.qt_container);
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
        map.put("title", "考评方式");
        map.put("context", "完成课程教学内容学习和考核，成绩达到课程考核标准的学生（每门课程的考核标准不同，详见课程内的评分标准），具备申请认证证书资格，可在证书申请开放期间（以申请页面显示的时间为准），完成在线付费申请。");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "参考书目");
        map.put("context", "[1]\t王红梅，胡明，王涛. 数据结构（C++版）. 北京：清华大学出版社，2005.\n" +
                "[2]\t李根强. 数据结构（C++版）（第2版）. 北京：中国水利水电出版社，2009.\n" +
                "[3]\t殷人昆. 数据结构——用面向对象方法与C++语言描述. 北京：清华大学出版社，2007.\n" +
                "[4]\t殷人昆. 数据结构习题解析——用面向对象方法与C++语言描述. 北京：清华大学出版社，2007.\n" +
                "[5]\t金远平. 数据结构（C++描述）. 北京：清华大学出版社，2005.\n" +
                "[6]\t王红梅，胡明，王涛. 数据结构（C++版）学习辅导与实验指导. 北京：清华大学出版社，2005.\n" +
                "[7]\t张乃孝，陈光，孙猛. 算法与数据结构——C语言描述（第3版）. 北京：高等教育出版社，2011.\n" +
                "[8]\t陈越. 数据结构. 北京：高等教育出版社，2012.\n" +
                "[9]\t耿国华. 数据结构——C语言描述. 北京：高等教育出版社，2011.\n" +
                "[10]\t严蔚敏，吴伟民. 数据结构（C语言版）. 北京：清华大学出版社，2002.\n" +
                "[11]\t徐绪松. 数据结构与算法. 北京：高等教育出版社，2004.\n" +
                "[12]\t王晓东. 数据结构与算法设计. 北京：电子工业出版社，2002.\n" +
                "[13]\t许卓群. 数据结构与算法. 北京：高等教育出版社，2005.\n" +
                "[14]\t许卓群. 张乃孝，杨冬青，唐世渭，数据结构. 北京：高等教育出版社，2006.\n" +
                "[15]\t李春葆. 数据结构教程（第2版）. 北京：清华大学出版社，2007.\n" +
                "[16]\tClifford A. Shaffer. 数据结构与算法分析（C++版）（第3版）（英文版）. 北京：电子工业出版社，2013.\n" +
                "[17]\tThomas H.Cormen,Charles E.Leiserson,Ronald L.Rivest,Clifford Stein. 算法导论（第3版）. 殷建平，徐云，王刚 等译. 北京：机械工业出版社，2013.\n");
        list.add(map);
        return list;
    }
}