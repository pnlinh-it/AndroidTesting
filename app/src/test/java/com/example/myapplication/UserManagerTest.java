package com.example.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class UserManagerTest {
    @Mock
    UserManager userManager;


    @Test
    @PrepareForTest(UserManager.class)
    public void test_get_user() {
        PowerMockito.mockStatic(UserManager.class);
        Mockito.when(UserManager.getInstance()).thenReturn(userManager);
        Mockito.when(userManager.getUser()).thenReturn(new UserModel(2,"Linh 2"));
        UserModel user = UserManager.getInstance().getUser();
        int a = 1;

        //PowerMockito.verifyStatic(Static.class); // 1
        //Static.firstStaticMethod(param); // 2

    }


}
