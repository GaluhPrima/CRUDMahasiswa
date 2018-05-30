package com.example.android.mahasiswa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.mahasiswa.adapter.MahasiswaAdapter;
import com.example.android.mahasiswa.model.Mahasiswa;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //coba gambar source dinamis
        //ImageView ivCobaGambar = (ImageView) findViewById(R.id.iv_coba_gambar);

//        int SDK_INT = android.os.Build.VERSION.SDK_INT;
//        if (SDK_INT > 8) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                    .permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//
//        try {
//            URL url = new URL("https://picsum.photos/200/300?images=1");
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            lvCobaGambar.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Picasso.get().load("https://picsum.photos/200/300?images=1").into(lvCobaGambar);


        //1. data
        String[] nama = new String[]{"galuh", "prima",
                "mei", "tri"}; /*menampilkan data statis*/

        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.setNama("Galuh");
        mahasiswa1.setNim("3.34.15.1.11");
        mahasiswa1.setEmail("galuh@gmail.com");
        mahasiswa1.setFoto("https://picsum.photos/200/300?images=1");

        Mahasiswa mahasiswa2 = new Mahasiswa(
                "Prima",
                "3.34.15.1.11",
                "prima@gmail.com",
                "https://picsum.photos/200/300?images=2"
        );
        Mahasiswa mahasiswa3 = new Mahasiswa(
                "Sholawati",
                "3.34.15.1.11",
                "prima@gmail.com",
                "https://picsum.photos/200/300?images=3"
        );

        ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();
        mahasiswas.add(mahasiswa1);
        mahasiswas.add(mahasiswa2);
        mahasiswas.add(mahasiswa3);

        //load data API JSON (Retrofit library)


        //2. adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nama); //membuat array adapter

        MahasiswaAdapter mahasiswaAdapter = new MahasiswaAdapter(this,
                R.layout.item_mahasiswa,
                mahasiswas);

        //3. activity (menampilkan data)
        ListView lvDaftarNama = (ListView) findViewById(R.id.lv_daftar_nama);
        lvDaftarNama.setAdapter(mahasiswaAdapter);
    }
}