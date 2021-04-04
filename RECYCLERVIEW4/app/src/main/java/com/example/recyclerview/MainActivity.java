package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    String name[]={"indu","baby","lav","divya","swa","hari"};
    String roll[]={"2","3","5","6","9","10"};
    String email[]={"indu@gmail.com","baby@gmail.com","lav@gmail.com","divya@gmail.com","swa@gmail.com","hari@gmail.com"};
    String phone[]={"9153645672","32134134232","756783468","75637456784","788637869","67457856498"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MydataAdapter(this,name,roll,email,phone));
    }
}
