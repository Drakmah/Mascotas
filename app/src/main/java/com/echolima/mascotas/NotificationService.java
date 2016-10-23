package com.echolima.mascotas;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;

import android.util.Log;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.view.Gravity;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Fernando on 10/10/2016.
 */

public class NotificationService  extends FirebaseMessagingService{

    public static final String TAG = "FIREBASE";
    public static final int NOTIFICATION_ID = 001;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent(this, MainActivity.class);
       /* Intent i = new Intent();
        i.setAction("HOME");
        i.setAction("LIKE");
        i.setAction("USUARIO");*/

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);
        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Action action01 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_home2,
                        getResources().getString(R.string.accion_01_wear), pendingIntent)
                .build();
        NotificationCompat.Action action02 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_like,
                        getResources().getString(R.string.accion_02_wear), pendingIntent)
                .build();

        NotificationCompat.Action action03 =
                new NotificationCompat.Action.Builder(R.drawable.ic_full_usuario,
                        getResources().getString(R.string.accion_03_wear), pendingIntent)
                .build();

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                .setHintHideIcon(true)
                .setBackground(BitmapFactory.decodeResource(getResources(),
                        R.drawable.fractal))
                .setGravity(Gravity.CENTER_VERTICAL)
                ;

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Message incoming: ")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .extend(wearableExtender.addAction(action01))
                .extend(wearableExtender.addAction(action02))
                .extend(wearableExtender.addAction(action03))
                //.addAction(R.drawable.ic_full_home2, getResources().getString(R.string.accion_01_wear), pendingIntent)
                ;
        NotificationManagerCompat notificationManager = //(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notificacion.build());

    }
}
