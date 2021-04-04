package com.example.sampletesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SampleTesting2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_testing2);
    }

    public void goto3(View view) {
        startActivity(new Intent(this,SampleTesting2));
    }
}
