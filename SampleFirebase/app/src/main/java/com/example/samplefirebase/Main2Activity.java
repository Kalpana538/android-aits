
package com.example.samplefirebase;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText user,id,salary;
DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user=findViewById(R.id.ename);
        id=findViewById(R.id.eID);
        salary=findViewById(R.id.esalary);
        auth=FirebaseAuth.getInstance();
        ref= FirebaseDatabase.getInstance().getReference();


    }

    public void signoutAccount(View view) {
        //auth.signOut;
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(new Intent(this,MainActivity.class)));
    }
    public void saveData(View view)
    {
        Datamodelclass datamodel=new Datamodelclass();
        String suser=user.getText().toString();
        String sid=user.getText().toString();
        String ssalary=user.getText().toString();
        datamodel=new Datamodelclass(suser,sid,ssalary);
        ref.child("aits").child(ref.push().getKey()).setValue(datamodel)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Main2Activity.this, "success", Toast.LENGTH_SHORT).show();
                        }
                    }
                    })
                     .addOnFailureListener(this, new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {

                         }
                     });

    }

    public void ReadData(View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Datamodelclass value = dataSnapshot.getValue(Datamodelclass.class);
                List<Datamodelclass> datalist = new ArrayList<>();
                datalist.add(value);
                Toast.makeText(Main2Activity.this, "" + datalist.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}
}


