package com.example.mynotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String MYCHANNEL_ID = "aits.apssdc.in";
    public static final int MY_NOTIFICATION_ID = 3654467;
    private NotificationManager nm;
    PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        pi=PendingIntent.getActivity(this,MY_NOTIFICATION_ID,new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void sendMyNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_assistant_black_24dp);
        builder.setContentTitle("AITS Tpty Notification");
        builder.setContentText("hi hello ");
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setAutoCancel(true);
        builder.setPriority(2);
        nm.notify(MY_NOTIFICATION_ID, builder.build());
    }

    public void createNotificationChannel() {
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel nc=new NotificationChannel(MYCHANNEL_ID, "apssdc",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.RED);
            nc.enableVibration(true);
            nc.setDescription("Notification from sam");
            nm.createNotificationChannel(nc);
        }
    }
}
