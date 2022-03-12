package com.zhouqi.onlinecourseapp.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.zhouqi.onlinecourseapp.R;

public class SubjectiveQuestionDialog extends Dialog {
    Activity context;
    Button btnConfirmGrade;
    EditText etSubjectiveQuestionGrade;

    public SubjectiveQuestionDialog(Activity context) {
        super(context);
        this.context = context;
    }


    public SubjectiveQuestionDialog(Activity context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 指定布局
        setContentView(R.layout.subjetive_question);
        etSubjectiveQuestionGrade=findViewById(R.id.et_subjective_question_grade);
        btnConfirmGrade=findViewById(R.id.btn_confirm_grade);

        Window dialogWindow = this.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);

        this.setCancelable(true);
    }

}
