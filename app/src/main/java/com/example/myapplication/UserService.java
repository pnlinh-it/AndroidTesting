package com.example.myapplication;

public class UserService {
 
    public String insert() {
        final String username = "gpcoder.com";
        UserUtils.validate(username);
        String uuid = UserUtils.generateUniqueId();
        UserUtils.validate(uuid);
        return username;
    }
}