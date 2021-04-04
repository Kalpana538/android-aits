package com.example.asector;

import androidx.appcompat.app.AppCompatActivity;

import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button bt;
    ImageView iv;
    TextView Tv;
    String myurl="https://pixabay.com/api/?key=20988203-f4a66d9f348d6bc8d291693e5&q=";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.tex1);
        bt=findViewById(R.id.bt1);
        iv=findViewById(R.id.img1);
        Tv=findViewById(R.id.tex1);
        progressBar = findViewById(R.id.progress);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new imageTask().execute();

            }
        });
    }
    class imageTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(myurl);
                /*Internet checking*/
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                /*getting input*/
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("aaa");
                if(scanner.hasNext());
                return scanner.next();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            JSONObject imagedate;
            try {
                imagedate = new JSONObject(s);
                JSONArray hitsArray=imagedate.getJSONArray("hits");
                JSONObject hitsobject=hitsArray.getJSONObject(10);
                String image=hitsobject.getString("largeImageURl");
                String user=hitsobject.getString("user");
                Picasso.get().load(image).into(iv);
                Tv.setText(user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
