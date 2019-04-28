package com.example.myapplication;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeUtil.class})
public class ExampleUnitTest {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static int a = 1;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        a = 1;
    }

    @Test
    public void change01() {
        a = 2;
    }


    @Test
    public void change02() {
        a = 2;
    }


    @Test
    public void test_static_method() throws Exception {
        Date date = TimeUtil.getDate();
        mockStatic(TimeUtil.class);
        Date NOW = sdf.parse("2015-05-23 00:00:00");
        PowerMockito.when(TimeUtil.getDate()).thenReturn(NOW);
        Date dateMocked = TimeUtil.getDate();
        String outputFormat = "Date normal: %s, date mocked: %s";
        System.out.println(String.format(outputFormat, sdf.format(date), sdf.format(dateMocked)));

        PowerMockito.verifyStatic(TimeUtil.class);
        TimeUtil.getDate();
        TimeUtil.encode();
    }

    @Test
    public void test_system_class() throws Exception {
        mockStatic(Date.class);
        Date NOW = sdf.parse("2015-05-23 00:00:00");
        // everytime we call new Date() inside a method of any class
        // declared in @PrepareForTest we will get the NOW instance
        PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(NOW);

        mockStatic(URLEncoder.class);
        PowerMockito.when(URLEncoder.encode(any(String.class), any(String.class)))
                .thenReturn("mocked value");

        String date = URLEncoder.encode("test", "UTF-8");
        //We call TimeUtil class, so if the below not present mock doesn't not work
        //@PrepareForTest({TimeUtil.class})
        String date2 = TimeUtil.getDate().toString();

        String date3 = new Date().toString();

        Assert.assertEquals("Sat May 23 00:00:00 ICT 2015", new Date().toString());
        Assert.assertEquals("mocked value", URLEncoder.encode("test", "UTF-8"));
        Assert.assertEquals("mocked value", TimeUtil.encode());

        //ArgumentMatchers.anyLong()
        //ArgumentMatchers.*
    }

    @Test
    public void test_verify() {
        //https://www.baeldung.com/mockito-verify
        List<String> mockedList = mock(MyList.class);
        mockedList.get(1);
        Mockito.verify(mockedList).get(Mockito.anyInt());

        mockStatic(System.class);
        when(System.currentTimeMillis()).thenReturn(100L);

        long currentTime = System.currentTimeMillis();

        System.out.println(currentTime);
    }

    //https://www.baeldung.com/intro-to-powermock
    @Test
    public void test_verify_static() throws UnsupportedEncodingException {
        mockStatic(TimeUtil.class);
        Mockito.when(TimeUtil.encode()).thenReturn("awd");
        Mockito.when(TimeUtil.getDate()).thenReturn(null);

        //UserManager.getInstance().callUtils();
        TimeUtil.encode();
        TimeUtil.encode();
        TimeUtil.getDate();
        PowerMockito.verifyStatic(TimeUtil.class, times(2));
        TimeUtil.encode();
        PowerMockito.verifyStatic(TimeUtil.class, times(1));
        TimeUtil.getDate();
//        PowerMockito.verifyStatic(TimeUtil.class);
//        TimeUtil.getDate();


        //PowerMockito.verifyStatic(TimeUtil.class, Mockito.times(2));
    }
    /*    Date now = new Date();
        now.set(2018, Calendar.FEBRUARY, 15, 1, 0); // set date to 2018-02-15
        //set current time to 2018-02-15
        mockCurrentTime(now.getTimeInMillis());*/

    private void mockCurrentTime(final long currTimeUTC) throws Exception {
        // mock new dates with current time
        mockStatic(Date.class);
        PowerMockito.whenNew(Date.class).withNoArguments().thenAnswer(new Answer<Date>() {

            @Override
            public Date answer(InvocationOnMock invocation) throws Throwable {
                return new Date(currTimeUTC);
            }
        });

        //do not mock creation of specific dates
        PowerMockito.whenNew(Date.class).withArguments(anyLong()).thenAnswer(new Answer<Date>() {

            @Override
            public Date answer(InvocationOnMock invocation) throws Throwable {
                return new Date((long) invocation.getArguments()[0]);
            }
        });

        // mock new calendars created with time zone
        mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance(any(TimeZone.class))).thenAnswer(new Answer<Calendar>() {
            @Override
            public Calendar answer(InvocationOnMock invocation) throws Throwable {
                TimeZone tz = invocation.getArgument(0);
                Calendar cal = Calendar.getInstance(tz);
                cal.setTimeInMillis(currTimeUTC);
                return cal;
            }
        });
    }
}