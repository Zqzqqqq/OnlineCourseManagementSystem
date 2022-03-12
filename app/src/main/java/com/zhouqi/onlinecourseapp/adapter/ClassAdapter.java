package com.zhouqi.onlinecourseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.ui.activity.ClassActivity;
import com.zhouqi.onlinecourseapp.entity.ClassEntity;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ClassEntity> datas;

    public ClassAdapter(Context context, List<ClassEntity> datas)
    {
        this.context=context;
        this.datas=datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_class_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh=(ViewHolder)holder;
        ClassEntity classEntity= datas.get(position);
        vh.classTitle.setText(classEntity.getClassname());
        vh.schoolTitle.setText(classEntity.getSchoolname());
        vh.stateTitle.setText(classEntity.getClassState());
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView classTitle;
        private TextView schoolTitle;
        private TextView stateTitle;

        public ViewHolder(@NonNull View view) {
            super(view);
            classTitle=view.findViewById(R.id.classname);
            schoolTitle=view.findViewById(R.id.schoolname);
            stateTitle=view.findViewById(R.id.classState);
            view.findViewById(R.id.class_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ClassActivity.class);
                    context.startActivity(intent);

                }
            });
        }
    }


}