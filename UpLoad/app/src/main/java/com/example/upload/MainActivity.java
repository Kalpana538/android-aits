package com.example.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    private Uri imageUri;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.image);
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    public void uploadfile(View view) {
        final StorageReference storage = mStorageRef.child("images").child(SystemClock.elapsedRealtime() + ".jpeg");
        storage.putFile(imageUri)
                .continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {

                        if(task.isSuccessful()){
                            return storage.getDownloadUrl();
                        }
                        return null;
                    }
                })
.addOnCompleteListener(new OnCompleteListener<Uri>() {
    @Override
    public void onComplete(@NonNull Task<Uri> task) {
        Uri uri = task.getResult();
        DatabaseReference dr= FirebaseDatabase.getInstance().getReference();
        dr.child("urls").child("link").setValue(uri.toString());
    }
    });


        }

        public void selectfile(View view) {
    Intent i=new Intent();
    i.setType("image/*");
    i.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(i,12);

    }
    @Override

    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(data!=null){

        imageUri=data.getData();
        try{
        Bitmap bit=MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
        img.setImageBitmap(bit);
        }catch(IOException e){
        e.printStackTrace();
        }
        }

        }
        }

