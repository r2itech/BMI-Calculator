package com.fkomuniku.bmicalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class HasilActivity extends AppCompatActivity {
    TextView hasil, ket;
    Double data;
    ProgressBar progressBar;
    ImageButton btnHome, btnUlang;
    Handler handler = new Handler();
    String k,s,b,o,o2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        progressBar = findViewById(R.id.progressBar);
        hasil = findViewById(R.id.hasil);
        ket = findViewById(R.id.ket);
        btnHome = findViewById(R.id.btnhome);
        btnUlang = findViewById(R.id.btnulang);

        hasil();
        bar();
        btnHome();
        btnUlang();
    }

    private void hasil(){
        data = getIntent().getExtras().getDouble("data");
        final DecimalFormat df = new DecimalFormat("#.#");
        hasil.setText(df.format(data));

        k = "Anda termasuk kurus atau memiliki berat badan kurang, jika angka BMI Anda berada di bawah 18,5.\n" +
                "Bagaimana cara menambah berat badan? Jika Anda ingin menaikkan berat badan, Anda perlu" +
                " mengonsumsi makanan dan minuman dengan jumlah kalori yang lebih besar dari kebutuhan kalori" +
                " harian Anda. Anda bisa menambahkan asupan kalori Anda sebanyak 300-500 kkal per hari. Misalnya," +
                " jika kebutuhan total kalori harian Anda adalah 1700 kkal, Anda perlu mengonsumsi makanan dengan" +
                " total 1700+500 = 2200 kkal per hari. ";
        s = "Berat badan Anda bisa dikatakan ideal jika angka BMI Anda berada antara angka 18,5 sampai 22,9.\n" +
                "Bagaimana cara menjaga agar berat badan tetap ideal? Anda perlu mengonsumsi makanan dan minuman" +
                " sesuai dengan kebutuhan kalori harian Anda, untuk mempertahankan berat badan ideal seperti sekarang." +
                " Misalnya, jika kebutuhan kalori harian Anda adalah 1950 kkal, maka Anda harus mengonsumsi makanan" +
                " dengan total kalori 1950 per harinya.";
        b = "Anda termasuk gemuk atau memiliki berat badan berlebih jika angka BMI Anda berada antara angka 23 sampai 24,9.\n" +
                "Bagaimana cara menurunkan berat badan? Untuk menurunkan berat badan, Anda harus mengonsumsi makanan" +
                " dan minuman dengan jumlah kalori yang lebih kecil dari kebutuhan kalori harian Anda. Kurangi sebanyak" +
                " 300-500 kalori per hari dari hasil perhitungan yang Anda dapatkan. Mengurangi jumlah asupan Anda setidaknya" +
                " 500 kkal per hari dapat membantu menurunkan berat badan Anda sebesar 0,5-1 kg per minggu. Misalnya," +
                " jika hasil dari perhitungan menunjukkan bahwa kebutuhan total kalori harian Anda adalah 2100 kkal," +
                " maka Anda hanya perlu mengonsumsi asupan kalori sebesar 1600 kkal per hari (2100-500 kkal).";
        o = "Anda termasuk obesitas level 1 atau memiliki berat badan berlebih yang berat, jika angka BMI Anda berada di antara 25 sampai 29,9.\n" +
                "Untuk menurunkan berat badan, Anda harus mengonsumsi makanan dan minuman dengan jumlah kalori yang lebih kecil" +
                " dari kebutuhan kalori harian Anda. Kurangi sebanyak 300-500 kalori per hari dari hasil perhitungan yang Anda dapatkan." +
                " Mengurangi jumlah asupan Anda setidaknya 500 kkal per hari dapat membantu menurunkan berat badan Anda sebesar" +
                " 0,5-1 kg per minggu. Misalnya, jika hasil dari perhitungan menunjukkan bahwa kebutuhan total kalori harian Anda" +
                " adalah 2100 kkal, maka Anda hanya perlu mengonsumsi asupan kalori sebesar 1600 kkal per hari (2100-500 kkal)." +
                " Setelah Anda terbiasa dengan jumlah kalori yang lebih sedikit ini, Anda bisa perlahan menguranginya lebih banyak" +
                " lagi. Yang juga perlu Anda tahu tentang mengatasi obesitas:\n" +
                "Berapa jumlah kalori minimal yang harus dipenuhi semua orang?\n" +
                "Rata-rata wanita memerlukan asupan sebanyak 2000 kalori per harinya, sedangkan pria rata-rata membutuhkan asupan" +
                " sebanyak 2500 kalori per hari. Untuk menurunkan berat badan, idealnya Anda hanya perlu mengurangi 500 kalori setiap" +
                " hari. Sehingga, wanita membutuhkan 1500 kalori dan pria membutuhkan 2000 kalori per hari untuk menurunkan berat badan." +
                " Namun, ingat. Semua orang membutuhkan minimal 1200 kkal per hari supaya tubuh bisa menjalani fungsinya. Mengonsumsi" +
                " kalori per hari lebih rendah dari 1200 kkal akan berdampak buruk bagi kesehatan Anda.";
        o2 = "Anda termasuk obesitas level 2 atau memiliki berat badan berlebih yang sangat berat, jika angka BMI Anda berada di atas 30.\n" +
                "Untuk menurunkan berat badan, Anda harus mengonsumsi makanan dan minuman dengan jumlah kalori yang lebih kecil dari" +
                " kebutuhan kalori harian Anda. Kurangi sebanyak 300-500 kalori per hari dari hasil perhitungan yang Anda dapatkan." +
                " Mengurangi jumlah asupan Anda setidaknya 500 kkal per hari dapat membantu menurunkan berat badan Anda sebesar 0,5-1 kg" +
                " per minggu. Misalnya, jika hasil dari perhitungan menunjukkan bahwa kebutuhan total kalori harian Anda adalah 2100 kkal," +
                " maka Anda hanya perlu mengonsumsi asupan kalori sebesar 1600 kkal per hari (2100-500 kkal). Setelah Anda terbiasa dengan" +
                " jumlah kalori yang lebih sedikit ini, Anda bisa perlahan menguranginya lebih banyak lagi.\n" +
                "Berapa jumlah kalori minimal yang harus dipenuhi semua orang?\\n\" +\n" +
                "ata-rata wanita memerlukan asupan sebanyak 2000 kalori per harinya, sedangkan pria rata-rata membutuhkan asupan\" +\n" +
                " sebanyak 2500 kalori per hari. Untuk menurunkan berat badan, idealnya Anda hanya perlu mengurangi 500 kalori setiap\" +\n" +
                " hari. Sehingga, wanita membutuhkan 1500 kalori dan pria membutuhkan 2000 kalori per hari untuk menurunkan berat badan.\" +\n" +
                " Namun, ingat. Semua orang membutuhkan minimal 1200 kkal per hari supaya tubuh bisa menjalani fungsinya. Mengonsumsi\" +\n" +
                " kalori per hari lebih rendah dari 1200 kkal akan berdampak buruk bagi kesehatan Anda.";
        ket.setMovementMethod(new ScrollingMovementMethod());
        if(data < 18.5 ){
            ket.setText(k);
        }
        else if(data >= 18.5 && data <= 22.9){
            ket.setText(s);
        }
        else if(data >= 23 && data <= 24.9){
            ket.setText(b);
        }
        else if(data >= 25 && data <= 29.9){
            ket.setText(o);
        }
        else {
            ket.setText(o2);
        }
    }

    private void bar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 0; i <= (int) +data; i++) {
                                progressBar.setProgress(i);
                                Thread.sleep(10);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        }).start();
    }

    private void btnHome(){
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    private void btnUlang(){
        btnUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HasilActivity.this, HitungActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

