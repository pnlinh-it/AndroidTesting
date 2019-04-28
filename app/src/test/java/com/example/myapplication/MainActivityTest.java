package com.example.myapplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.powermock.reflect.Whitebox;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;


@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
@PrepareForTest(Injector.class)
@PowerMockIgnore({"org.powermock.*", "org.mockito.*", "org.robolectric.*",
        "android.*", "java.net.ssl", "java.net.ssl", "javax.security.auth.x500.X500Principal",
        "javax.net.ssl.*", "java.security.*", "java.security.cert.X509Certificate"})
public class MainActivityTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    MainActivity mainActivity;

    @Before
    public void setup() {
        /*PowerMockito.mockStatic(Injector.class);
        PowerMockito.when(Injector.getClientService()).thenReturn(null);*/
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void testMain() {
        while (Injector.dispatcher.runningCallsCount() != 0) {

        }
        //ShadowApplication.runBackgroundTasks();
        //Robolectric.flushBackgroundThreadScheduler();
        //ShadowLooper.runUiThreadTasks();
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();
        Assert.assertNotNull(mainActivity);
        int id = Whitebox.getInternalState(mainActivity, "id");
        Assert.assertEquals(id, 12341);
    }
}
