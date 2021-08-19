package com.example.myapplication;

import android.support.annotation.NonNull;

public class FileUtils {

    @NonNull
    public static String generateName() {
        return Long.toString(System.currentTimeMillis());
    }
}