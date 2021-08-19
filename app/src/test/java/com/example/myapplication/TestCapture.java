package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCapture {

    @Mock
    ArgumentService mArgumentService;

    ArgumentCapture mArgumentCapture;

    @Captor
    ArgumentCaptor<Callback> mArgumentCaptor;

    @Captor
    ArgumentCaptor<List<String>> mListCapture;

    @Before
    public void setup() {
        mArgumentCapture = Mockito.spy(new ArgumentCapture(mArgumentService));
    }

    @Test
    public void dog() {
        mArgumentCapture.getData();
        Mockito.verify(mArgumentService).fetchData(mArgumentCaptor.capture());
        mArgumentCaptor.getValue().onResponse("dog");
        Mockito.verify(mArgumentCapture).dog();
    }

    @Test
    public void cat() {
        mArgumentCapture.getData();
        // https://medium.com/@marco_cattaneo/kotlin-unit-testing-with-mockk-91d52aea2852
        // The OtherClass is a mock, and as it is defined now the doSomething() will not actualy do anything, it simply records the object that was passed.
        // http://www.javabyexamples.com/mockito-recipe-return-given-arguments
        // http://www.javabyexamples.com/mockito-recipe-custom-return-with-answer
        // http://www.javabyexamples.com/mockito-recipe-capture-arguments-with-argumentcaptor/
        // https://www.javainuse.com/spring/spring-boot-argumentcaptor
        // https://stackoverflow.com/a/12296307
        // https://stackoverflow.com/questions/36253040/example-of-mockitos-argumentcaptor#comment94204006_36267673
        // https://blog.frankel.ch/improve-your-tests-with-mockitos-capture/
        // Khong the access dc den bien testCallBack trong mArgumentCapture
        // Do mArgumentService la mock object nen function fetchData(callback: Callback)
        // se khong duoc goi, nhung param callback se duoc luu lai
        // Khi minh verify va truyen vao captor thi param callback se duoc truyen cho captor
        Mockito.verify(mArgumentService).fetchData(mArgumentCaptor.capture());
        System.out.println("" + mArgumentCaptor.getValue());
        mArgumentCaptor.getValue().onResponse("cat");
        Mockito.verify(mArgumentCapture).cat();
    }

    @Test
    public void nothing() {
        mArgumentCapture.getData();

        Mockito.verify(mArgumentService).fetchData(mArgumentCaptor.capture());
        Mockito.verifyNoMoreInteractions(mArgumentService);

        Mockito.verify(mArgumentCapture, Mockito.times(0)).cat();
        Mockito.verify(mArgumentCapture, Mockito.times(0)).dog();
    }


    @Test
    public void testCaptureList() {
        List<String> names = Arrays.asList("A", "B", "C", "D");
        List mockList = Mockito.mock(List.class);

        mockList.addAll(names);

        Mockito.verify(mockList).addAll(mListCapture.capture());

        List listParam = mListCapture.getValue();

        int a = 1;
    }
}
