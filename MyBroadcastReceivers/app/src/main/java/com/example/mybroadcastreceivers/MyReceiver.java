package com.example.mybroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action=intent.getAction();
        switch (action){
            case Intent.ACTION_POWER_CONNECTED:
               Toast.makeText(context, "Action_power_connected", Toast.LENGTH_SHORT).show();
               break;
            case Intent.ACTION_POWER_DISCONNECTED:
                 break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Action_airplane_mode_changed", Toast.LENGTH_SHORT).show();
                break;
            case MainActivity.CUSTOM_RECEIVER:
                Toast.makeText(context, "this is my custom receiver", Toast.LENGTH_SHORT).show();


        }
    }
}
