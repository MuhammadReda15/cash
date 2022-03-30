package com.redha.kuis_muhammad_reda;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Transaksi_2 extends AppCompatActivity {

    TextView nama,alamat,jumlah,jenisKelamin,tipePelanggan,namaBarang,harga,totalHarga,discHarga,discmember,jumlahBayar;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksi_2);

        nama = findViewById(R.id.tvnamaPelanggan);
        alamat = (TextView) findViewById(R.id.tvAlamatPelanggan);
        jumlah = (TextView) findViewById(R.id.tvJumlahBarang);
        jenisKelamin = (TextView) findViewById(R.id.tvJenisKelamin);
        tipePelanggan = (TextView) findViewById(R.id.tvTipeMember);
        namaBarang = (TextView)  findViewById(R.id.tvNamaBarang);
        harga = (TextView) findViewById(R.id.tvHarga);
        totalHarga = (TextView) findViewById(R.id.tvTotalHarga);
        discHarga = (TextView) findViewById(R.id.tvDiscHarga);
        discmember = (TextView) findViewById(R.id.tvDiscMember);
        jumlahBayar = (TextView) findViewById(R.id.tvJumlahBayar);

        Intent terima = getIntent();
        String terimaNama = terima.getStringExtra("kirimnamap");
        String terimaAlamat = terima.getStringExtra("kirimalamatp");
        String terimaJumlah = terima.getStringExtra("kirimjumlahb");
        String terimaJK = terima.getStringExtra("kirimjenisk");
        String terimaTP = terima.getStringExtra("kirimtipep");
        String terimaNB = terima.getStringExtra("kirimnamab");


        DecimalFormat berkoma = new DecimalFormat("#,###,###");
        int jb = Integer.parseInt(terimaJumlah);
        int disc = 20;
        int diskonmember = 0;

        if(terimaTP.equalsIgnoreCase("gold")) {
            tipePelanggan.setText("Tipe Member : Gold");
            diskonmember = 400000;
        }else if(terimaTP.equalsIgnoreCase("silver")) {
            tipePelanggan.setText("Tipe Member : Silver");
            diskonmember = 300000;
        }else if(terimaTP.equalsIgnoreCase("biasa")) {
            tipePelanggan.setText("Tipe Member : Biasa");
            diskonmember = 200000;
        }

        int hargaAndroid = 1000000, hargaIOS = 2000000,hargaWindowsp = 2500000;
        String hargaAndroidf = berkoma.format(hargaAndroid),hargaIOSf = berkoma.format(hargaIOS),hargaWindowspf = berkoma.format(hargaWindowsp);
        String diskonmemberf = berkoma.format(diskonmember);

        int totalhargaAndroid = jb * hargaAndroid, totalHargaIphone = jb * hargaIOS,totalHargaWindowsP = jb * hargaWindowsp;
        String hargaA = berkoma.format(totalhargaAndroid), hargaI = berkoma.format(totalHargaIphone), hargaW = berkoma.format(totalHargaWindowsP);

        int diskonAndroid = totalhargaAndroid * disc / 100, diskonIphone = totalHargaIphone * disc / 100, diskonWindows = totalHargaWindowsP * disc / 100;
        String diskonA = berkoma.format(diskonAndroid), diskonI = berkoma.format(diskonIphone), diskonW = berkoma.format(diskonWindows);

        int jumlahBAndroid = totalhargaAndroid-diskonAndroid-diskonmember;
        int jumlahBIphone = totalHargaIphone-diskonIphone-diskonmember;
        int jumlahBAWindowsP = totalHargaWindowsP-diskonWindows-diskonmember;

        String jumlahBayarAndroid = berkoma.format(jumlahBAndroid);
        String jumlahBayarIphone = berkoma.format(jumlahBIphone);
        String JumlahBayarWindowsP = berkoma.format(jumlahBAWindowsP);

        switch (terimaNB) {
            case "ANDROID":
                nama.setText("Nama Pelanggan "+terimaNama);
                jenisKelamin.setText("Jenis Kelasmin : "+terimaJK);
                alamat.setText("Alamat Pelanggan : "+terimaAlamat);
                namaBarang.setText("Nama Barang : " + terimaNB);
                jumlah.setText("Jumlah Barang : "+terimaJumlah);
                harga.setText("Harga : Rp."+hargaAndroidf);
                totalHarga.setText("Total Harga : Rp."+hargaA);
                discHarga.setText("Disc. Harga : Rp."+diskonA);
                discmember.setText("Disc. Member : Rp."+diskonmemberf );
                jumlahBayar.setText("Jumlah Bayar : Rp."+jumlahBayarAndroid);
                break;

            case "IPHONE" :
                nama.setText("Nama Pelanggan "+terimaNama);
                jenisKelamin.setText("Jenis Kelasmin : "+terimaJK);
                alamat.setText("Alamat Pelanggan : "+terimaAlamat);
                namaBarang.setText("Nama Barang : " + terimaNB);
                jumlah.setText("Jumlah Barang : "+terimaJumlah);
                harga.setText("Harga : Rp."+hargaIOSf);
                totalHarga.setText("Total Harga : Rp."+hargaI);
                discHarga.setText("Disc. Harga : Rp."+diskonI);
                discmember.setText("Disc. Member : Rp."+diskonmemberf );
                jumlahBayar.setText("Jumlah Bayar : Rp."+jumlahBayarIphone);
                break;

            case "WINDOWS PHONE" :
                nama.setText("Nama Pelanggan "+terimaNama);
                jenisKelamin.setText("Jenis Kelasmin : "+terimaJK);
                alamat.setText("Alamat Pelanggan : "+terimaAlamat);
                namaBarang.setText("Nama Barang : " + terimaNB);
                jumlah.setText("Jumlah Barang : "+terimaJumlah);
                harga.setText("Harga : Rp."+hargaWindowspf);
                totalHarga.setText("Total Harga : Rp."+hargaW);
                discHarga.setText("Disc. Harga : Rp."+diskonW);
                discmember.setText("Disc. Member : Rp."+diskonmemberf );
                jumlahBayar.setText("Jumlah Bayar : Rp."+JumlahBayarWindowsP);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Kode barang tidak ditemukan! Harap periksa kembali kode barang", Toast.LENGTH_LONG).show();
        }

    }

    }
