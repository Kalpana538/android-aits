package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MydataAdapter extends RecyclerView.Adapter<MydataAdapter.MyDataViewHolder>{
    Context ct;
    String[] uname,umail,uphone,uroll;
    public MydataAdapter(MainActivity mainActivity, String[] name, String[] roll, String[] email, String[] phone) {
        ct=mainActivity;
        uname=name;
        umail=email;
        uroll=roll;
        uphone=phone;
    }

    @NonNull
    @Override
    public MydataAdapter.MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(ct).inflate(R.layout.design,parent,false);
        return new MyDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MydataAdapter.MyDataViewHolder holder, int position) {
    holder.tv1.setText(uname[position]);
    holder.tv2.setText(umail[position]);
    holder.tv3.setText(uphone[position]);
    holder.tv4.setText(uroll[position]);
    }

    @Override
    public int getItemCount() {
        return uname.length;
    }

    public class MyDataViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4;
        public MyDataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.username);
            tv2 = itemView.findViewById(R.id.roll);
            tv3 = itemView.findViewById(R.id.email);
            tv4 = itemView.findViewById(R.id.phone);

        }
    }
}
