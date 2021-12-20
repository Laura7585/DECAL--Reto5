package com.example.reto5.Vista;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reto5.Controlador.MainActivity;
import com.example.reto5.R;

public class SplashScreen extends AppCompatActivity implements Runnable {

    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView caballo1 = (ImageView)findViewById(R.id.caballo);
        caballo1.setBackgroundResource(R.drawable.caballo);

        AnimationDrawable ejecutarAnimacion = (AnimationDrawable)caballo1.getBackground();
        ejecutarAnimacion.start();

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2495);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            finish();
        }
    }
}