package com.example.myapplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FeedRepository {

    public List<String> getFeed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime >= 0) return Arrays.asList("1", "2");
        else return Collections.singletonList("");
    }
}
