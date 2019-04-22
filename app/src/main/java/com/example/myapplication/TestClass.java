package com.example.myapplication;

import com.crashlytics.android.Crashlytics;

import java.util.Date;

public class TestClass {

    private void log(){
        Crashlytics.logException(new NullPointerException("just testing"));
    }

    public void testLog(){
        System.out.println(new Date(System.currentTimeMillis()).toString());
        log();
    }

}
