package com.example.samplefirebase;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText uname,upass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.email);
        upass=findViewById(R.id.password);

        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void InClicked(View view) {
        String em=uname.getText().toString();
        String pas= upass.getText().toString();
        mAuth.signInWithEmailAndPassword(em,pas)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent in=new Intent(getApplicationContext(),Main2Activity.class);
                            startActivity(in);
                        }else{
                            Toast.makeText(MainActivity.this, "Please Enter Correct Info", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void UpClicked(View view) {
        String em=uname.getText().toString();
        String pas= upass.getText().toString();
        mAuth.createUserWithEmailAndPassword(em,pas)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void resetpass(View view) {
        mAuth.sendPasswordResetEmail(uname.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Check Yo Mail Homie", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Stop Playing Fool", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}

