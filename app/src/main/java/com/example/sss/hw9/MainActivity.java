package com.example.sss.hw9;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 456263;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Item> items = new ArrayList<>();

        Item firstItem = new Item();
        firstItem.setTitle("First item (1)");

        Item secondItem = new Item();
        secondItem.setTitle("Second item (2)");

        Item thirdItem = new Item();
        thirdItem.setTitle("Third item (3)");

        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);

        listView = findViewById(R.id.list_view);

        ItemAdapter adapter = new ItemAdapter(getApplicationContext(), items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item clickedItem = items.get(i);

                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "default");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                notificationBuilder.setContentTitle(clickedItem.getTitle())
                        .setContentText("Notification from your program")
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher_round);

                Notification notification = notificationBuilder.build();
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, notification);
            }
        });
    }
}
