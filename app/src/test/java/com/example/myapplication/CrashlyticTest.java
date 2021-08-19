package com.example.myapplication;

import com.crashlytics.android.Crashlytics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Crashlytics.class})
public class CrashlyticTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Test
    public void test_static_method() throws Exception {
        mockStatic(Crashlytics.class);
        mockStatic(Date.class);
        mockStatic(System.class);
        mockStatic(Date.class);
        when(System.currentTimeMillis()).thenReturn(1L);
        System.out.println(System.currentTimeMillis());
        //Date NOW = sdf.parse("2015-05-23 00:00:00");
        // everytime we call new Date() inside a method of any class
        // declared in @PrepareForTest we will get the NOW instance
        //PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(new Date());
        /*PowerMockito.when(System.currentTimeMillis()).thenReturn(10000L);
        System.out.println(new Date().toString());

        //doNothing().when(Crashlytics.class);
        TestClass testClass = new TestClass();
        testClass.testLog();*/
    }
}