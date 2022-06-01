package com.stevanuschristian.ridermotogp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanuschristian.ridermotogp.API.APIRequestData;
import com.stevanuschristian.ridermotogp.API.RetroServer;
import com.stevanuschristian.ridermotogp.Adapter.AdapterRider;
import com.stevanuschristian.ridermotogp.Model.ModelResponse;
import com.stevanuschristian.ridermotogp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etNomor, etSponsor, etNegara;
    Button btnSimpan;
    private String nama, nomor, sponsor, negara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        initView();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                nomor = etNomor.getText().toString();
                sponsor = etSponsor.getText().toString();
                negara = etNegara.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Rider Harus Diisi!");
                }
                else if(nomor.trim().equals("")){
                    etNomor.setError("Nomor Rider Harus Diisi!");
                }
                else if(sponsor.trim().equals("")){
                    etSponsor.setError("Sponsor Rider Harus Diisi!");
                }
                else if(negara.trim().equals("")){
                    etNegara.setError("Negara Asal Rider Harus Diisi!");
                }
                else {
                    createRider();
                }
            }
        });
    }

    private void initView(){
        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        etSponsor = findViewById(R.id.et_sponsor);
        etNegara = findViewById(R.id.et_negara);

        btnSimpan = findViewById(R.id.btn_simpan);
    }

    private void createRider(){
        APIRequestData API = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = API.ardCreateData(nama, nomor, sponsor, negara);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                if(kode == 1){
                    Toast.makeText(TambahActivity.this, "Selamat! Sukses Menambah Data Rider", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(TambahActivity.this, "Perhatian! Sukses Menambah Data Rider", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal Menghubungi Server!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}