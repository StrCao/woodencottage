package com.xicheng.mockito.tutorial;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @author xichengxml
 * @date 2019/4/18 9:55
 * 使用前需要静态导入 import static org.mockito.Mockito.*;
 */
public class MockTutorialDemo01 {

    /**
     * 创建Mock对象
     */
    @Test
    public void createMockObject() {
        // 使用mock静态方法创建Mock对象
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        // mock方法不仅可以Mock接口类，还可以Mock具体的类型
        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
        Assert.assertTrue(mockedArrayList instanceof List);
    }

    /**
     * 配置Mock对象返回值
     */
    @Test
    public void configMockObject() {
        List mockedList = mock(List.class);

        // 我们定制了当调用add("one")时，返回true
        when(mockedList.add("one")).thenReturn(true);
        // 当调用size()时，返回1
        when(mockedList.size()).thenReturn(1);
        Assert.assertTrue(mockedList.add("one"));
        Assert.assertEquals(mockedList.size(), 1);

        // 因为我们没有定制add("two"),因此返回默认值，即false
        Assert.assertFalse(mockedList.add("two"));

        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = iterator.next() + " " + iterator.next();
        Assert.assertEquals("Hello, Mockito", result);
    }

    /**
     * 配置Mock对象异常
     */
    @Test(expected = NoSuchElementException.class)
    public void mockObjectForException() throws Exception {
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = iterator.next() + " " + iterator.next();
        Assert.assertEquals("Hello, Mockito", result);

        doThrow(new NoSuchElementException()).when(iterator).next();
        iterator.next();
    }

    /**
     * 校验Mock对象的方法调用
     */
    @Test
    public void mockObjectVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(), 5);

        // 校验add("one")至少被调用了一次
        verify(mockedList, atLeastOnce()).add("one");
        verify(mockedList, times(1)).add("two");
        verify(mockedList, times(3)).add("three times");
        // 校验isEmpty()从未被调用
        verify(mockedList, never()).isEmpty();
    }

    /**
     * 使用spy()部分模拟对象
     */
    @Test
    public void mockObjectSpy() {
        List list = new LinkedList();
        List spy = spy(list);

        // 对spy.size()进行定制
        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");

        // 因为我们没有对get(0)，get(1)方法定制，因此这些调用实际上调用的是真实对象的方法
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        Assert.assertEquals(spy.size(), 100);
    }

    /**
     * 参数捕获
     */
    @Test
    public void mockObjectCaptureArgument() {
        List<String> list = Arrays.asList("1", "2");
        List mockedList = mock(List.class);
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);
        verify(mockedList).addAll(argumentCaptor.capture());

        Assert.assertEquals(2, argumentCaptor.getValue().size());
        Assert.assertEquals(list, argumentCaptor.getValue());
    }
}
