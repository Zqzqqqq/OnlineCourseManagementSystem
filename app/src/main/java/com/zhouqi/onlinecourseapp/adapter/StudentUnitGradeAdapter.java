package com.zhouqi.onlinecourseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.entity.StudentUnitGrade;

import java.util.List;

public class StudentUnitGradeAdapter extends RecyclerView.Adapter<StudentUnitGradeAdapter.ViewHolder>{
    private List<StudentUnitGrade> list;

    public StudentUnitGradeAdapter(List<StudentUnitGrade> list){
        this.list=list;
    }
    @NonNull
    @Override
    public StudentUnitGradeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_student_unit_grade,parent,false);
        return new StudentUnitGradeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentUnitGradeAdapter.ViewHolder holder, int position) {
        StudentUnitGrade sug = list.get(position);
        holder.name.setText(sug.name);
        holder.chochoiceGrade.setText(""+sug.choiceGrade);
        holder.judgementGrade.setText(""+sug.judgementGrade);
        holder.completionGrade.setText(""+sug.completionGrade);
        holder.subjectiveGrade.setText(""+sug.subjectiveGrade);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            View StudentUnitGradeView;
            TextView name;
            TextView chochoiceGrade;
            TextView judgementGrade;
            TextView completionGrade;
            TextView subjectiveGrade;
            Button btnSubjectiveGrade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.StudentUnitGradeView =itemView;
            this.name=itemView.findViewById(R.id.tv_student_unit_grade_name);
            this.chochoiceGrade=itemView.findViewById(R.id.tv_student_unit_grade_choice);
            this.judgementGrade=itemView.findViewById(R.id.tv_student_judgement_grade);
            this.completionGrade=itemView.findViewById(R.id.tv_student_completion_grade);
            this.subjectiveGrade=itemView.findViewById(R.id.tv_student_subjective_grade);
            this.btnSubjectiveGrade=itemView.findViewById(R.id.btn_show_subjective_dialog);
            this.btnSubjectiveGrade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(v,1);
                }
            });
        }
    }



    private StudentUnitGradeAdapter.OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(StudentUnitGradeAdapter.OnItemClickListener l) {
        this.mItemClickListener = l;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void addItem(StudentUnitGrade s){
        list.add(s);
    }
}
