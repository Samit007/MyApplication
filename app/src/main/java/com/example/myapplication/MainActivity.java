package com.example.myapplication;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import channel.CreateChannel;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    NotificationManagerCompat notificationManagerCompact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        notificationManagerCompact=NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplayfirstnotification();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplaysecondnotification();
            }
        });

    }


    private void diplayfirstnotification() {
        Notification notification= new NotificationCompat.Builder(MainActivity.this, CreateChannel.CHANNEL_1)

                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("First Notification")
                .setContentText("This is a first message through notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompact.notify(1,notification);
    }
    private void diplaysecondnotification() {
        Notification notification= new NotificationCompat.Builder(MainActivity.this, CreateChannel.CHANNEL_2)                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Second Notification")
                .setContentText("This is a second message through notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompact.notify(2,notification);
    }
}
