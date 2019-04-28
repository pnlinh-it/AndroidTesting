package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "onCreate: ");
        System.out.println("onCreate");

        getData();
    }
    private int id;

    private void getData() {
        System.out.println("getData");
        ClientService clientService = Injector.getClientService();
        clientService.getList().enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                id = response.body().getId();
                System.out.println("onResponse " + Thread.currentThread().getName());
                updateUI();
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                System.out.println("onResponse " + Thread.currentThread().getName());
                updateUI();
            }
        });

    }

    private void updateUI() {
        System.out.println("updateUI " + Thread.currentThread().getName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }
}
