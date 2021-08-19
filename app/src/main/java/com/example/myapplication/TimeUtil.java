package com.example.myapplication;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class TimeUtil {
    public static Date getDate() {
        return new Date();
    }

    public static String encode() throws UnsupportedEncodingException {
        return URLEncoder.encode("string", "IBM290");
    }
}
