package com.fkomuniku.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.Button;
import android.app.Dialog;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    ImageButton btnBack, btnAbout;
    Button dialogButton;
    TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnAbout = findViewById(R.id.btnabout);
        btnBack = findViewById(R.id.btnback);
        about = findViewById(R.id.about1);

        animButton();
        btnAbout();
        btnBack();
        naskahAbout();
    }

    private void animButton(){
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(btnAbout, "scaleY", 0.8f);
        scaleY.setDuration(300);
        ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(btnAbout, "scaleY", 1f);
        scaleYBack.setDuration(800);
        scaleYBack.setInterpolator(new BounceInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(300);
        animatorSet.playSequentially(scaleY, scaleYBack);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animatorSet.setStartDelay(1000);
                animatorSet.start();
            }
        });
        btnAbout.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();
    }
    private void btnAbout(){
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(AboutActivity.this);
                dialog.setContentView(R.layout.aboutdialog);
                dialog.show();
            }
        });
    }

    private void btnBack(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void naskahAbout(){
        about.setMovementMethod(new ScrollingMovementMethod());
        about.setText("Aplikasi ini adalah aplikasi BMI Calculator.\n" +
                "   Body Mass Index atau disingkat dengan BMI adalah salah satu cara yang dipergunakan" +
                " untuk mengukur kenormalan berat badan seseorang berdasarkan ketinggian tubuhnya." +
                " Dalam Bahasa Indonesia, Body Mass Index (BMI) disebut dengan Indeks Massa Tubuh atau disingkat dengan IMT.\n" +
                " Berat badan yang berlebihan disebut dengan Obesitas (Kegemukan). Obesitas dapat" +
                " meningkatkan risiko timbulnya berbagai penyakit seperti Diabetes (kencing manis)," +
                " Serangan Jantung, Hipertensi, Asam urat, kolesterol tinggi dan juga Sleep Apnea yaitu" +
                " kesulitan tidur nyenyak karena gangguan pernapasan. Oleh karena itu, mengetahui Indeks" +
                " BMI tubuh kita merupakan hal yang penting agar kita dapat menjaga berat badan kita selalu" +
                " pada kondisi yang normal sehingga dapat menurunkan risiko timbulnya penyakit-penyakit yang" +
                " dikarenakan oleh Obesitas ini.\n" +
                "   Aplikasi ini dibuat untuk mempermudah pengguna/user mengukur indeks masa tubuhnya." +
                " Aplikasi ini merupakan aplikasi BMICalculator versi 1.0." +
                "\n\n\n" +
                "Petunjuk Penggunaan Aplikasi:\n" +
                " - Pada halaman utama pilih menu Hitung\n" +
                " - Masukan Tinggi Tubuh kalian dalam format CM\n" +
                " - Masukan Berat Badan kalian dalam format KG\n" +
                " - Tekan tombol Hitung, maka akan keluar hasilnya\n" +
                " - Kalian akan melihat hasil BMI kalian + keterangan lainnya\n");
    }

}
