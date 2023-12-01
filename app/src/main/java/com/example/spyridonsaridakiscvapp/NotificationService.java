package com.example.spyridonsaridakiscvapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {

    private Timer timer = new Timer();
    private static int count;

    public static final int NOTIFICATION_ID = 1;
    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendNotification();
            }
        },5000);

        return super.onStartCommand(intent, flags, startId);
    }

    public void sendNotification() {

        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel(
                    "1",
                    "channel1",
                    NotificationManager.IMPORTANCE_DEFAULT);

            //create the notification manager
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, in, PendingIntent.FLAG_IMMUTABLE);

            //create the notification
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "1")
                    .setSmallIcon(android.R.drawable.stat_sys_warning)
                    .setContentTitle("CV app is idle")
                    .setContentText("The application has been running in the background")
                    .setContentIntent(pendingIntent)
                    .addAction(android.R.drawable.button_onoff_indicator_on, "Open App", pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);


            NotificationManagerCompat notifyAdmin = NotificationManagerCompat.from(this);
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            notifyAdmin.notify(1, notification.build());
            Intent stopServiceIntent = new Intent(this, NotificationService.class);
            stopService(stopServiceIntent);

        }
    }

}