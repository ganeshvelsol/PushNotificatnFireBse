package gif.ganesh.pushnotififirebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFbMessaging extends FirebaseMessagingService
{
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        showNotification(remoteMessage.getNotification().getBody());
    }

    public void showNotification(String message)
    {
        //PendingIntent pi= PendingIntent.getActivities(this,0,new Intent(),0);
        Notification no=new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.star_on)
                .setContentText("hello")
                .setContentText(message)
                .setAutoCancel(true)
                .build();
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0,no);

    }
}
