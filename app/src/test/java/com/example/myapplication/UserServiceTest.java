package com.example.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.UUID;
 
@RunWith(PowerMockRunner.class)
@PrepareForTest({ UserUtils.class })
public class UserServiceTest {
 
    @Test
    public void verifyCalledStaticMethodTest() throws Exception {
        // Object under test
        UserService userService = new UserService();
 
        // Mock
        PowerMockito.mockStatic(UserUtils.class);
        PowerMockito.doNothing().when(UserUtils.class, "validate", Mockito.anyString());
        PowerMockito.when(UserUtils.class, "generateUniqueId").thenReturn(UUID.randomUUID().toString());
 
        // Execute method under test
        final String username = "gpcoder.com";
        UserUtils.validate(username);
        String uuid = UserUtils.generateUniqueId();
        UserUtils.validate(uuid);
 
        // Test
        //We want to verify class call 2 times
        PowerMockito.verifyStatic(UserUtils.class, Mockito.times(2));
        //What method call 2 times?
        UserUtils.validate(Mockito.anyString());

        //We want to verify class call 2 times
        PowerMockito.verifyStatic(UserUtils.class);
        //What method call 1 times?
        UserUtils.generateUniqueId();
    }
}