package com.example.myapplication;

import java.io.UnsupportedEncodingException;

public class UserManager {

    public static volatile UserManager sInstance;

    public static UserManager getInstance() {
        if (sInstance == null) {
            synchronized (UserManager.class) {
                if (sInstance == null) {
                    sInstance = new UserManager();
                }
            }
        }
        return sInstance;
    }

    public UserModel getUser() {
        return new UserModel(12, "Linh");
    }

    public void callUtils() throws UnsupportedEncodingException {
        TimeUtil.encode();
        TimeUtil.getDate();
    }
}
