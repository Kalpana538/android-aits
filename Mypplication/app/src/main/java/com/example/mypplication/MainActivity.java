 package com.example.mypplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
  EditText  username,mobile,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.et_username);
        mobile=findViewById(R.id.et_mobilenumber);
        email=findViewById(R.id.et_email);
    }

     public void submitvalues(View view) {
        String name=username.getText().toString();
        String number=mobile.getText().toString();
        String mail=email.getText() .toString();
        StringBuilder sb=new StringBuilder();
        sb.append(name+"\n"+number+"\n"+mail);
         Toast.makeText(this,sb.toString(), Toast.LENGTH_SHORT).show();

     }
 }
