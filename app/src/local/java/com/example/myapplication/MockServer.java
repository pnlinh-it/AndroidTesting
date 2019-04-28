package com.example.myapplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class MockServer {

    public static String start() throws IOException {
        MockWebServer server = new MockWebServer();
        server.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                return new MockResponse()
                        .setBodyDelay(10, TimeUnit.SECONDS)
                        .setBody("{\"id\":1234}");
            }
        });
        server.start(8080);
        return server.url("").toString();
    }
}
