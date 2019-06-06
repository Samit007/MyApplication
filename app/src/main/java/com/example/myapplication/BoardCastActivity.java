package com.example.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.BroadcastRecieverExample;

public class BoardCastActivity extends AppCompatActivity {

    BroadcastRecieverExample broadcastRecieverExample = new BroadcastRecieverExample(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_cast);
    }

    @Override
    protected void onStart(){
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastRecieverExample,intentFilter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastRecieverExample);
    }
}
