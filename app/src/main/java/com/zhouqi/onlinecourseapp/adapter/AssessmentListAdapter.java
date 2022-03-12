package com.zhouqi.onlinecourseapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.zhouqi.onlinecourseapp.R;

import java.util.List;
import java.util.Map;

public class AssessmentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;

    public AssessmentListAdapter(Context mContext, List<Map<String,Object>>mDataList)
    {
        this.mContext=mContext;
        this.mDataList=mDataList;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=mLayoutInflater.from(viewGroup.getContext()).inflate(R.layout.assessment_card,viewGroup,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Map<String,Object> entity=mDataList.get(position);
        if(entity==null)
            return;

        ViewHolder viewHolder=(ViewHolder) holder;

        viewHolder.assess_name.setText(entity.get("assess_name").toString());
        viewHolder.assess_time.setText(entity.get("assess_time").toString());
        viewHolder.assess_totalscore.setText(entity.get("assess_totalscore").toString());

    }
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView assess_name;
        TextView assess_time;
        TextView assess_totalscore;

        public ViewHolder(View itemView) {
            super(itemView);

            assess_name=(TextView)itemView.findViewById(R.id.assess_name);
            assess_time=(TextView)itemView.findViewById(R.id.assess_time);
            assess_totalscore=(TextView)itemView.findViewById(R.id.assess_totalscore);

            itemView.findViewById(R.id.assess_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Clicked!", Toast.LENGTH_SHORT).show();
                    //给按钮添加监听事件
                }
            });
        }
    }
}
