package com.zhouqi.onlinecourseapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zhouqi.onlinecourseapp.R;

import java.util.List;
import java.util.Map;

public class CourseWareListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;

    public CourseWareListAdapter(Context mContext, List<Map<String,Object>>mDataList)
    {
        this.mContext=mContext;
        this.mDataList=mDataList;
        mLayoutInflater=LayoutInflater.from(mContext);
    }
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v=mLayoutInflater.from(viewGroup.getContext()).inflate(R.layout.courseware_card,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Map<String,Object> entity=mDataList.get(position);
        if(entity==null)
            return;
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.course_id.setText(entity.get("course_id").toString());

        viewHolder.item_videoicon.setImageResource(Integer.parseInt(entity.get("item_videoicon").toString()));
        viewHolder.course_video.setText(entity.get("course_video").toString());
        viewHolder.item_videoplay.setImageResource(Integer.parseInt(entity.get("item_videoplay").toString()));

        viewHolder.item_ppt.setImageResource(Integer.parseInt(entity.get("item_ppt").toString()));
        viewHolder.course_ppt.setText(entity.get("course_ppt").toString());
        viewHolder.item_download.setImageResource(Integer.parseInt(entity.get("item_download").toString()));

        viewHolder.item_test.setImageResource(Integer.parseInt(entity.get("item_test").toString()));
        viewHolder.course_test.setText(entity.get("course_test").toString());
        viewHolder.item_goin.setImageResource(Integer.parseInt(entity.get("item_goin").toString()));

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView course_id;

        ImageView item_videoicon;
        TextView course_video;
        ImageView item_videoplay;

        ImageView item_ppt;
        TextView course_ppt;
        ImageView item_download;

        ImageView item_test;
        TextView course_test;
        ImageView item_goin;


        public ViewHolder(View itemView) {
            super(itemView);
            course_id=(TextView)itemView.findViewById(R.id.course_id);

            item_videoicon=(ImageView)itemView.findViewById(R.id.item_videoicon);
            course_video=(TextView)itemView.findViewById(R.id.course_video);
            item_videoplay=(ImageView)itemView.findViewById(R.id.item_videoplay);

            item_ppt=(ImageView)itemView.findViewById(R.id.item_ppt);
            course_ppt=(TextView)itemView.findViewById(R.id.course_ppt);
            item_download=(ImageView)itemView.findViewById(R.id.item_download);

            item_test=(ImageView)itemView.findViewById(R.id.item_test);
            course_test=(TextView)itemView.findViewById(R.id.course_test);
            item_goin=(ImageView)itemView.findViewById(R.id.item_goin);


            itemView.findViewById(R.id.courseware_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Clicked!", Toast.LENGTH_SHORT).show();
                    //给按钮添加监听事件
                }
            });
        }
    }
}
