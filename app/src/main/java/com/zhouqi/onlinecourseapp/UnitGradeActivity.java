package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UnitGradeActivity extends AppCompatActivity {

    TextView tvUnit4Grade;//后期用recyclerview实现
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_grade);
        tvUnit4Grade=findViewById(R.id.tv_unit4);
        tvUnit4Grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UnitGradeActivity.this,OneUnitGradeActivity.class);
                startActivity(intent);
            }
        });
    }
}