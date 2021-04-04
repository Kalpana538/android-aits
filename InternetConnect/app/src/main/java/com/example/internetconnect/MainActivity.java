package com.example.internetconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkInt(null);


    }
    public  void checkInt(View view){
        ConnectivityManager cm=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        if(cm.getActiveNetworkInfo()!=null &&cm.getActiveNetworkInfo().isConnected()) {
            setContentView(R.layout.activity_main);
            ImageView check=findViewById(R.id.imageView);
            check.setVisibility(View.GONE);

        }
        else{
            setContentView(R.layout.activity_main);
            ImageView img=findViewById(R.id.image);
            img.setImageResource(R.drawable.internetconnect);

        }


    }

}
