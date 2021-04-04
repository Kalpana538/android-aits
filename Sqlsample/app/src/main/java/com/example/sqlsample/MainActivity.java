package com.example.sqlsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText sname, sbranch;
    Data my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sname = findViewById(R.id.name);
        sbranch = findViewById(R.id.branch);
        my=new Data(this);
    }

    public void savedata(View view) {
String name=sname.getText().toString();
String branch=sbranch.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put(my.COL1,name);
        cv.put(Data.COL2,branch);
        my.insertData(cv);
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
    }

    public void readdata(View view) {
        Cursor c=my.readdata();
        StringBuffer sb=new StringBuffer();


        while (c.moveToNext()){
            sb.append(c.getString(0)+""+c.getString(1));
            Toast.makeText(this, sb, Toast.LENGTH_SHORT).show();

        }
    }
}

