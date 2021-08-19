package com.example.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Utils.class})
public class JUnit4PowerMockitoStaticTest {

    @Test
    public void test_static_mock_methods() {
        PowerMockito.mockStatic(Utils.class);
//   Doretu     when(Utils.print("Hello")).thenReturn(true);
//        when(Utils.print("Wrong Message")).thenReturn(false);

        //doNothing().when(Utils.class);
        TestUtils testUtils = new TestUtils();
        testUtils.callStatic();

        PowerMockito.verifyStatic(Utils.class);
        Utils.print("");
        // PowerMockito.verifyStatic(Utils.class);
    }
}