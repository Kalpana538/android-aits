package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rec;
    String names[];
    String location[];
    int poster[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.recycler);
        names=getResources().getStringArray(R.array.titles);
        location=getResources().getStringArray(R.array.subtitle);
        poster=new int[]{
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_background};
        MyAdapter adapter=new MyAdapter(this,names,location,poster);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);

    }
}
