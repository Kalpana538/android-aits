package com.example.currentlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements LocationListener {
static double lat,lon;
TextView tv;
LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.text);
        lm=(LocationManager)getSystemService(LOCATION_SERVICE);

    }

    @Override
    public void onLocationChanged(Location location) {
        lat=location.getLatitude();
        lon=location.getLongitude();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void next(View view) {
        Intent i =new Intent( this,Maps.class);
        startActivity(i);
    }
}
