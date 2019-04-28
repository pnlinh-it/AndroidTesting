package com.example.myapplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {
    static ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static Dispatcher dispatcher;
    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;

    static {
        System.out.println("local init");
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        dispatcher = new Dispatcher(executorService);
        okHttpClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .addInterceptor(logging)
                .build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://test.com")
                .build();
    }

    public static ClientService getClientService() {
        return retrofit.create(ClientService.class);
    }
}

