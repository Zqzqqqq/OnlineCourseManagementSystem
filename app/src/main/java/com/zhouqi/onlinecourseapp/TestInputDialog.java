package com.zhouqi.onlinecourseapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

public class TestInputDialog extends Dialog {

    Activity context;

    private Spinner testTypeSpinner;
    private View judgeLayout;
    private View singleSelectLayout;
    private View multiSelectLayout;
    private View blankLayout;
    private View subjectiveLayout;
    private View.OnClickListener mClickListener;
    private Button save;
    public TestInputDialog(Activity context) {
        super(context);
        this.context = context;
    }

    public TestInputDialog(Activity context, int theme, View.OnClickListener clickListener) {
        super(context, theme);
        this.context = context;
        this.mClickListener = clickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 指定布局
        this.setContentView(R.layout.dialog_test_input);
        save = findViewById(R.id.btn_save);
        testTypeSpinner = findViewById(R.id.spinner_test_type);
        judgeLayout = findViewById(R.id.judge);
        singleSelectLayout = findViewById(R.id.select_single);
        multiSelectLayout = findViewById(R.id.select_multi);
        blankLayout = findViewById(R.id.blank);
        subjectiveLayout = findViewById(R.id.subjective);

        save.setOnClickListener(mClickListener);
        testTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = testTypeSpinner.getSelectedItem().toString();
                switch (selection){
                    case "判断题":
                        setVisibility(0);
                        break;
                    case "单选题":
                        setVisibility(1);
                        break;
                    case "多选题":
                        setVisibility(2);
                        break;
                    case "填空题":
                        setVisibility(3);
                        break;
                    case "主观题":
                        setVisibility(4);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Window dialogWindow = this.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);

        this.setCancelable(true);
    }

    private void setVisibility(int i){
        judgeLayout.setVisibility(View.GONE);
        singleSelectLayout.setVisibility(View.GONE);
        multiSelectLayout.setVisibility(View.GONE);
        blankLayout.setVisibility(View.GONE);
        subjectiveLayout.setVisibility(View.GONE);
        switch (i){
            case 0:
                judgeLayout.setVisibility(View.VISIBLE);
                break;
            case 1:
                singleSelectLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                multiSelectLayout.setVisibility(View.VISIBLE);
                break;
            case 3:
                blankLayout.setVisibility(View.VISIBLE);
                break;
            case 4:
                subjectiveLayout.setVisibility(View.VISIBLE);
                break;

        }
    }

}
