package com.example.sistem_pakar_beanexpert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);
    }

    public void tentang(View view) {
        Intent intent = new Intent(MainActivity.this, tentang.class);
        startActivity(intent);
    }
    public void daftar_penyakit(View view) {
        Intent intent = new Intent(MainActivity.this, daftar_penyakit.class);
        startActivity(intent);
    }
    public void deteksi(View view) {
        Intent intent = new Intent(MainActivity.this, deteksi.class);
        startActivity(intent);
    }

}