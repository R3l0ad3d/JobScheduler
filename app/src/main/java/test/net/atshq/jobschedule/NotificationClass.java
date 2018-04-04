package test.net.atshq.jobschedule;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public  class NotificationClass {
    private  Context context;
    private NotificationManager notificationManager;
    private  Notification notification;

    private static int count=0;

    public NotificationClass(Context context) {
        this.context=context;
        notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showNotification(){
        notification = new Notification.Builder(context)
                .setContentTitle("New mail from "  )
                .setContentText("Job")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();
        notificationManager.notify(count++,notification);

    }
}
