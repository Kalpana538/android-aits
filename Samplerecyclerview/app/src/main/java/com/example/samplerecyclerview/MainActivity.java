package com.example.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        String names[]=new String[]{"Sam","Teju","Ammu","Janu"};
        String numbers[]=new String[]{"9333383838383","3983898989443","37467737388","6326767878"};
        MyAdapter my=new MyAdapter(this,names,numbers);
        rv.setAdapter(my);
    }

}
