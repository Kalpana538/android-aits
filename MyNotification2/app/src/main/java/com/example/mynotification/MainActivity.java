package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createMyNotificationChannel();
    }

    private void createMyNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel("MYID", "MYCHANNEL",NotificationManager.IMPORTANCE_HIGH );
           nc.enableLights(true);
           nc.setLightColor(Color.BLUE);
           nc.enableVibration(true);
           nm.createNotificationChannel(nc);
        }
    }

    public void showNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MYID");
        builder.setContentTitle("My Notification");
        builder.setContentText("This is our own notification");
        builder.setSmallIcon(R.drawable.ic_do_not_disturb_alt_black_24dp);
        nm.notify(1,builder.build());
    }
}

