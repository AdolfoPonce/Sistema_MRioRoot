package com.example.adolfo.sistema_m;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by adolfo on 18/06/17.
 */

public class servicio extends Service {

    private NotificationManager nm;
    private static final int id_notificacion=1;
    long[] vibrar={0,100,200,300,400,3000};

    public void onCreate(){
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        System.out.println("Se creo el servicio.");
    }
    public void onDestroy(){
        nm.cancel(id_notificacion);
        System.out.println("Se destruyo el servicio");
    }

    public int onStartCommand(Intent i, int flag, int id){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(servicio.this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setLargeIcon((((BitmapDrawable)getResources()
                                .getDrawable(R.drawable.android)).getBitmap()))
                        .setContentTitle("Mensaje de Alerta")
                        .setContentText("Ejemplo de notificación.")
                        .setContentInfo("4")
                        .setTicker("Alerta!");
        PendingIntent pi=PendingIntent.getActivity(this,0,new Intent(this,grafica.class),0);
        mBuilder.setVibrate(vibrar);
        mBuilder.setLights(0xff00ff00,300,1000);
        mBuilder.setContentIntent(pi);

       nm.notify(id_notificacion,mBuilder.build());
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
