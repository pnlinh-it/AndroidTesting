package com.example.myapplication;

import com.crashlytics.android.Crashlytics;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Crashlytics.class, Date.class, System.class})
public class CrashlyticTest {


    @Test
    public void test_static_method() throws Exception {
        mockStatic(Crashlytics.class);
        mockStatic(Date.class);
        mockStatic(System.class);
        //PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(new Date(123456));
        PowerMockito.when(System.currentTimeMillis()).thenReturn(0L);
        System.out.println(new Date().toString());

        doNothing().when(Crashlytics.class);
        TestClass testClass = new TestClass();
        testClass.testLog();
    }
}