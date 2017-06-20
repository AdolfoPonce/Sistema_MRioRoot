package com.example.adolfo.sistema_m;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by adolfo on 20/06/17.
 */

public class launcher extends AppCompatActivity{
    public int DURACION_SPLASH =4000;
    @Override
            public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(launcher.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }

}
