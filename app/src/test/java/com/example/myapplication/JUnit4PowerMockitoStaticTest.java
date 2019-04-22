package com.example.myapplication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class JUnit4PowerMockitoStaticTest{

	@Test
	public void test_static_mock_methods() {
		PowerMockito.mockStatic(Utils.class);
		when(Utils.print("Hello")).thenReturn(true);
		when(Utils.print("Wrong Message")).thenReturn(false);

		Utils.print("Hello");
		Utils.print("Hello");
		PowerMockito.verifyStatic(Utils.class, atLeast(2));
		Utils.print("Hello");
		PowerMockito.verifyStatic(Utils.class);
		Utils.print("Hello");
	}
}