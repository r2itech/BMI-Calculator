package com.fkomuniku.bmicalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TextView;

public class HitungActivity extends AppCompatActivity {
    ImageButton btnBack, btnHitung;
    EditText tinggi, berat;
    double tinggi2, berat2, tinggiM, bmi;
    String t, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        btnBack = findViewById(R.id.btnback);
        btnHitung = findViewById(R.id.btnhitung);
        tinggi = findViewById(R.id.tinggi);
        berat = findViewById(R.id.berat);

        btnBack();
        btnHitung();
    }

    private void btnBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void btnHitung() {
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("".equals(tinggi.getText().toString())){
                    tinggi.setError("Isikan Tinggi Anda!");
                }
                else if("".equals(berat.getText().toString())){
                    berat.setError("Isikan BB Anda!");
                }
                else{
                    hitung();
                }
            }
        });

        tinggi.setFocusableInTouchMode(true);
        tinggi.setFocusable(true);
        tinggi.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    private void hitung() {
        //Mengambil Data dari EditText
        String t = tinggi.getText().toString();
        String b = berat.getText().toString();

        //Konversi Data dari String ke Double
        tinggi2 = Double.parseDouble(t);
        berat2 = Double.parseDouble(b);

        //Konversi CM ke M
        tinggiM = tinggi2 / 100;
        //Rumus Menghitung BMI
        bmi = berat2 / (tinggiM * tinggiM);

        Intent i = new Intent(HitungActivity.this, HasilActivity.class);
        i.putExtra("data", bmi); //Passing data
        startActivity(i);
        finish();
    }

}
