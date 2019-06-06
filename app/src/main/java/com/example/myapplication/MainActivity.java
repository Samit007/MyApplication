package com.example.myapplication;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Channel1")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("First Notification")
                .setContentText("This is a first message through notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompact.notify(1,builder.build());
    }
    private void diplaysecondnotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Channel2")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Second Notification")
                .setContentText("This is a second message through notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompact.notify(2,builder.build());
    }
}
