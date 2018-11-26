package com.example.administrator.imageload;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.imageload.API.ApiClient;
import com.example.administrator.imageload.API.ApiInterface;
import com.example.administrator.imageload.API.FilePOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_cashback_offer);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<List<FilePOJO>> call=apiInterface.offerpojo();
        call.enqueue(new Callback<List<FilePOJO>>() {
            @Override
            public void onResponse(Call<List<FilePOJO>> call, Response<List<FilePOJO>> response) {
                List<FilePOJO> list=response.body();
                progressDialog.dismiss();
                RecyclerClass recyclerCashbackOfferFragment=new RecyclerClass(MainActivity.this,list);
                recyclerView.setAdapter(recyclerCashbackOfferFragment);


            }

            @Override
            public void onFailure(Call<List<FilePOJO>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "id:"+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
