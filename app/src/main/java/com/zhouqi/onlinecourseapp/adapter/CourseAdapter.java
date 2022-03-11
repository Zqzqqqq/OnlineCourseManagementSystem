package com.zhouqi.onlinecourseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhouqi.onlinecourseapp.Course;
import com.zhouqi.onlinecourseapp.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    private List<Course> list;

    public CourseAdapter(List<Course> list){
        this.list=list;
    }
    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_course_teacher,parent,false);
        return new CourseAdapter.ViewHolder(view);
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
