package com.zhouqi.onlinecourseapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhouqi.onlinecourseapp.R;

import java.util.List;

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.ViewHolder>{
    private List<String> list;

    public TopicsAdapter(List<String> list){
        this.list=list;
    }
    @NonNull
    @Override
    public TopicsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicsAdapter.ViewHolder holder, int position) {
        String s=list.get(position);
        holder.number.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View topicView;
        TextView number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.topicView =itemView;
            this.number =(TextView) itemView.findViewById(R.id.topic_number);
        }
    }

    public void addItem(String s){
        list.add(s);
    }
}
