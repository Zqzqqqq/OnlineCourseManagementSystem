package com.zhouqi.onlinecourseapp.adapter;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.zhouqi.onlinecourseapp.R;
        import com.zhouqi.onlinecourseapp.StudentData;

        import java.util.List;

public class StudentDataGradeAdapter extends RecyclerView.Adapter<StudentDataGradeAdapter.ViewHolder>{
    private List<StudentData> list;

    public StudentDataGradeAdapter(List<StudentData> list){
        this.list=list;
    }
    @NonNull
    @Override
    public StudentDataGradeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_student_grade,parent,false);
        return new StudentDataGradeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentDataGradeAdapter.ViewHolder holder, int position) {
        StudentData sd=list.get(position);
        holder.grade.setText(""+sd.grade);
        holder.StudentId.setText(""+sd.StudentId);
        holder.name.setText(""+sd.name);
        if(sd.grade<60)
            holder.alert.setChecked(true);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView StudentId;
        TextView grade;
        RadioButton alert;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name=itemView.findViewById(R.id.tv_student_name);
            this.StudentId=itemView.findViewById(R.id.tv_student_id);
            this.grade=itemView.findViewById(R.id.tv_student_grade);
            this.alert=itemView.findViewById(R.id.rbtn_alert);
        }
    }


    public void addItem(StudentData sd){
        list.add(sd);
    }
}
