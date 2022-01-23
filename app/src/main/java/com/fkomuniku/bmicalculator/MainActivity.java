package com.fkomuniku.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btnHitung, btnAbout, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHitung = findViewById(R.id.btnhitung);
        btnAbout = findViewById(R.id.btnabout);
        btnExit = findViewById(R.id.btnexit);

        btnHitung();
        btnAbout();
        btnExit();
    }

    private void btnHitung(){
        btnHitung.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent b = new Intent(MainActivity.this, HitungActivity.class);
                startActivity(b);
            }
        });
    }

    private void btnAbout(){
        btnAbout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent b = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(b);
            }
        });
    }

    private void btnExit(){
        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage("Apakah Yakin Akan Keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Jika Yes
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Jika No
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
