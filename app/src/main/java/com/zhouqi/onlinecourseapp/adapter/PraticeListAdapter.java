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

public class PraticeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;

    public PraticeListAdapter(Context mContext, List<Map<String,Object>>mDataList)
    {
        this.mContext=mContext;
        this.mDataList=mDataList;
        mLayoutInflater=LayoutInflater.from(mContext);
    }
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=mLayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pratice_card,viewGroup,false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Map<String,Object> entity=mDataList.get(position);
        if(entity==null)
            return;

        ViewHolder viewHolder=(ViewHolder) holder;

        viewHolder.pratice_word.setText(entity.get("pratice_word").toString());

    }
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView pratice_word;


        public ViewHolder(View itemView) {
            super(itemView);

            pratice_word=(TextView)itemView.findViewById(R.id.pratice_word);


            itemView.findViewById(R.id.pratice_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Clicked!", Toast.LENGTH_SHORT).show();
                    //给按钮添加监听事件
                }
            });
        }
    }
}
