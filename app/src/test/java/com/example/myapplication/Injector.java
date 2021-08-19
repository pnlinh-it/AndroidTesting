package com.example.myapplication;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.robolectric.android.util.concurrent.RoboExecutorService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Injector {
    static ExecutorService  executorService1 = new RoboExecutorService();
    static ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static Dispatcher dispatcher;
    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;

    static {
        try {
            MockServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("test init");
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        dispatcher = new Dispatcher(executorService);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .dispatcher(dispatcher)
                .build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://localhost:8080")
                .build();
    }

    public static ClientService getClientService() {
        return retrofit.create(ClientService.class);
    }
}
