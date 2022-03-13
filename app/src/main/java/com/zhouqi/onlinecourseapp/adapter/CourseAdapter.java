package com.zhouqi.onlinecourseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhouqi.onlinecourseapp.entity.Course;
import com.zhouqi.onlinecourseapp.R;
import com.zhouqi.onlinecourseapp.ui.activity.EndCourseActivity;
import com.zhouqi.onlinecourseapp.ui.activity.PublishUnitActivity;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    private List<Course> list;
    private Context context;
    public CourseAdapter(Context context, List<Course> list){
        this.context = context;
        this.list=list;
    }
    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_course_teacher,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.courseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = viewHolder.getAbsoluteAdapterPosition();
                Course course = list.get(p);
                Intent intent;
                switch (course.status){
                    case "正在开课中":
                        intent = new Intent(context, PublishUnitActivity.class);
                        context.startActivity(intent);
                        break;
                    case "正在选课中":

                        break;
                    case "等待开课中":
                        break;
                    case "等待选课中":
                        break;
                    case "课程已结束":
                        intent = new Intent(context, EndCourseActivity.class);
                        context.startActivity(intent);
                        break;
                }


            }
        });
        /*iewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        Course c = list.get(position);
        holder.name.setText(c.name);
        holder.organization.setText(c.organization);
        holder.status.setText(c.status);
        holder.image.setImageResource(c.imageId);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View courseView;
        TextView name;
        TextView organization;
        TextView status;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.courseView =itemView;
            this.name = itemView.findViewById(R.id.course_name);
            this.organization = itemView.findViewById(R.id.course_organization);
            this.status = itemView.findViewById(R.id.course_status);
            this.image = itemView.findViewById(R.id.image_button_course);
        }
    }

    public void addItem(Course s){
        list.add(s);
    }
}
