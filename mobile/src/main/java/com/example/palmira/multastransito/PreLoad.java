package com.example.palmira.multastransito;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreLoad extends AppCompatActivity {

    //atributo para o tempo da pagina de preload
    private static int SPLASH_TIME_OUT=4000;//PRELOAD

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_load);
        //METODO que chama o preload
        new Handler().postDelayed(new Runnable(){
                                      @Override
                                      public void run() {
                                          Intent actividadePosterior= new Intent(PreLoad.this, paginaInicial.class);
                                          startActivity(actividadePosterior);
                                          finish();
                                      }
                                  },SPLASH_TIME_OUT
        );//PRELOAD
    }
}
