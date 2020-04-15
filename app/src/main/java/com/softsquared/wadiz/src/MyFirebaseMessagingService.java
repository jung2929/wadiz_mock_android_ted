package com.softsquared.wadiz.src;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.MainActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM";

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token : " + token);
    }

    @Override

    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getNotification() != null) {

            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            String messageBody = remoteMessage.getNotification().getBody();
            String messageTitle = remoteMessage.getNotification().getTitle();

            Intent intent = new Intent(this, MainActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
            String channelId = "Cahnnel Id";
            Uri defaulSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.appicon)
                    .setContentTitle(messageTitle)
                    .setContentText(messageBody)
                    .setAutoCancel(true)
                    .setSound(defaulSoundUri)
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(0, notificationBuilder.build());


        }

    }



}