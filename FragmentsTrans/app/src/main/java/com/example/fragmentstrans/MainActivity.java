package com.example.fragmentstrans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
FrameLayout f1,f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1=findViewById(R.id.frame1);
        f2=findViewById(R.id.frame2);
        Fragment fragment1=new Screen1();
        Fragment fragment2=new Screen2();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame1,fragment1);
        ft.replace(R.id.frame2,fragment2);
       // ft.replace(R.id.frame3,fragment1);
        ft.commit();

    }
}
