package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    String title[];
    String sub_title[];
    int postr[];

    public MyAdapter(Context ctx, String[] title, String[] sub_title, int[] postr) {
        this.ctx = ctx;
        this.title = title;
        this.sub_title = sub_title;
        this.postr = postr;
    }

    /*what is the use of constructors*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.t.setText(title[position]);
    holder.st.setText(sub_title[position]);
    holder.img.setImageResource(postr[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t,st;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t=itemView.findViewById(R.id.tv_title);
            st=itemView.findViewById(R.id.tv_subtitle);
            img=itemView.findViewById(R.id.iv);

        }
    }
}
