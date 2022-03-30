package com.redha.kuis_muhammad_reda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class Transaksi_1 extends AppCompatActivity {


     TextInputEditText namaPelanggan,alamatPelanggan,jumlahBarang;
     RadioButton pilihJK,pilihNB,pilihTP;
     RadioGroup radiojk,radionb,radiotp;
     Button proses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksi_1);

        namaPelanggan = (TextInputEditText)findViewById(R.id.etNamaPelanggan);
        alamatPelanggan = (TextInputEditText) findViewById(R.id.etAlamatPelanggan);
        jumlahBarang = (TextInputEditText) findViewById(R.id.etJumlahBarang);

        radiojk = (RadioGroup) findViewById(R.id.groupRadiojk);
        radionb = (RadioGroup) findViewById(R.id.groupRadioNB);
        radiotp = (RadioGroup) findViewById(R.id.groupRadioTP);
        proses = (Button) findViewById(R.id.btnProses);

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pilihanJK = radiojk.getCheckedRadioButtonId();
                pilihJK = findViewById(pilihanJK);

                int pilihanNB = radionb.getCheckedRadioButtonId();
                pilihNB = findViewById(pilihanNB);

                int pilihanTP = radiotp.getCheckedRadioButtonId();
                pilihTP =findViewById(pilihanTP);

                String jenisk = pilihJK.getText().toString().toUpperCase(Locale.ROOT);
                String namaB = pilihNB.getText().toString().toUpperCase(Locale.ROOT);
                String tipeP = pilihTP.getText().toString().toUpperCase(Locale.ROOT);
                String namap = namaPelanggan.getText().toString();
                String alamatp = alamatPelanggan.getText().toString();
                String jumlahb = jumlahBarang.getText().toString();


                    Intent kirim = new Intent(Transaksi_1.this, Transaksi_2.class);
                    kirim.putExtra("kirimnamap", namap);
                    kirim.putExtra("kirimjenisk", jenisk);
                    kirim.putExtra("kirimnamab", namaB);
                    kirim.putExtra("kirimtipep", tipeP);
                    kirim.putExtra("kirimalamatp", alamatp);
                    kirim.putExtra("kirimjumlahb", jumlahb);
                    startActivity(kirim);


            }
        });
    }

}