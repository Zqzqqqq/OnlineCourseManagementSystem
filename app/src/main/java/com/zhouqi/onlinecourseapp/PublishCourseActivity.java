package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PublishCourseActivity extends AppCompatActivity implements View.OnClickListener{

    TextView chooseStartTime;
    TextView chooseEndTime;
    TextView courseStartTime;
    TextView courseEndTime;
    DateFormat format= DateFormat.getDateTimeInstance();
    Calendar calendar= Calendar.getInstance(Locale.CHINA);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_publish);
        chooseStartTime = findViewById(R.id.course_time_choose_start);
        chooseEndTime = findViewById(R.id.course_time_choose_end);
        courseStartTime = findViewById(R.id.course_time_start);
        courseEndTime = findViewById(R.id.course_time_end);
        chooseStartTime.setOnClickListener(this);
        chooseEndTime.setOnClickListener(this);
        courseStartTime.setOnClickListener(this);
        courseEndTime.setOnClickListener(this);
    }

    /**
     * 日期选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                tv.setText("您选择了：" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.course_time_choose_start:
                showDatePickerDialog(this,  0, chooseStartTime, calendar);;
                break;
            case R.id.course_time_choose_end:
                showDatePickerDialog(this,  0, chooseStartTime, calendar);;
                break;
            case R.id.course_time_start:
                showDatePickerDialog(this,  0, chooseStartTime, calendar);;
                break;
            case R.id.course_time_end:
                showDatePickerDialog(this,  0, chooseStartTime, calendar);;
                break;
            default:
                break;
        }

    }
}