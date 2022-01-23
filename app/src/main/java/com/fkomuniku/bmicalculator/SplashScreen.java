package com.fkomuniku.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;

public class SplashScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstansceState){
        super.onCreate(savedInstansceState);
        //Menghilangkan Action Bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 1000L); //3000 = 3 Detik

    }

}
