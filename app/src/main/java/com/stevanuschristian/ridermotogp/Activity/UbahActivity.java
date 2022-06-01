package com.stevanuschristian.ridermotogp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanuschristian.ridermotogp.API.APIRequestData;
import com.stevanuschristian.ridermotogp.API.RetroServer;
import com.stevanuschristian.ridermotogp.Model.ModelResponse;
import com.stevanuschristian.ridermotogp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UbahActivity extends AppCompatActivity {
    private EditText etNama, etNomor, etSponsor, etNegara;
    private Button btnUbah;
    private String xID, yNama, yNomor, yNegara, ySponsor, xNama, xNomor, xNegara, xSponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        initView();

        Intent terimaData = getIntent();
        xID = terimaData.getStringExtra("xID");
        xNama = terimaData.getStringExtra("xNama");
        xNomor = terimaData.getStringExtra("xNomor");
        xSponsor = terimaData.getStringExtra("xSponsor");
        xNegara = terimaData.getStringExtra("xNegara");

        etNama.setText(xNama);
        etNomor.setText(xNomor);
        etSponsor.setText(xSponsor);
        etNegara.setText(xNegara);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yNama = etNama.getText().toString();
                yNomor = etNomor.getText().toString();
                ySponsor = etSponsor.getText().toString();
                yNegara = etNegara.getText().toString();

                if (yNama.trim().equals("")){
                    etNama.setError("Nama Rider Harus Diisi!");
                }
                else if(yNomor.trim().equals("")){
                    etNomor.setError("Nomor Rider Harus Diisi!");
                }
                else if(ySponsor.trim().equals("")){
                    etSponsor.setError("Sponsor Rider Harus Diisi!");
                }
                else if(yNegara.trim().equals("")){
                    etNegara.setError("Negara Asal Rider Harus Diisi!");
                }
                else {
                    updateRider();
                }
            }
        });
    }

    private void initView(){
        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        etSponsor = findViewById(R.id.et_sponsor);
        etNegara = findViewById(R.id.et_negara);

        btnUbah = findViewById(R.id.btn_ubah);
    }

    private void updateRider(){
        APIRequestData API = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = API.ardUpdateData(xID, yNama, yNomor, ySponsor, yNegara);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if(kode == 1){
                    Toast.makeText(UbahActivity.this, "Selamat! Sukses Mengubah Data Rider", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(UbahActivity.this, "Perhatian! Gagal Mengubah Data Rider", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(UbahActivity.this, "Gagal Menghubungi Server!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}