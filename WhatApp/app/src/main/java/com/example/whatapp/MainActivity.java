package com.example.whatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tb;
ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tab);
        vp=findViewById(R.id.vpage);
        TabAdapter ta=new TabAdapter(getSupportFragmentManager());
        ta.addFragment(new Calls(),"Calls");
        ta.addFragment(new Chats(),"Chats");
        ta.addFragment(new Status(),"Status");
        vp.setAdapter(ta);
        tb.setupWithViewPager(vp);




    }
}
