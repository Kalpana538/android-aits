package com.example.samplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewInfo> {
    Context ctx;
    String names[], num[];

    public MyAdapter(MainActivity mainActivity, String[] names, String[] numbers) {


    ctx=mainActivity;
    this.names=names;
    num=numbers;
}
    @NonNull
    @Override
    public MyAdapter.ViewInfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.design, parent, false);

        return new ViewInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewInfo holder, int position) {
holder.textName.setText(names[position]+"\n"+num[position]);
holder.imgcall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int pos=holder.getAdapterPosition();

        Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num[pos]));
        ctx.startActivity(i);
    }
});
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewInfo extends RecyclerView.ViewHolder{

        ImageView imgprofile,imgcall;
        TextView textName;
        public ViewInfo(@NonNull View itemView){
            super(itemView);
        imgprofile=itemView.findViewById(R.id.profile);
        imgcall=itemView.findViewById(R.id.call);
        textName=itemView.findViewById(R.id.name);



        }
    }
}
