package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by Administrator on 2017/7/27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapTest {

    @Test
    public void hashMapTest() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");

        /**
         * map没有iterator,但set有（collection）
         * 迭代器模式
         */
        Set<Integer> set = map.keySet();
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            String value = next.getValue();
            Integer key = next.getKey();
        }
        /**
         * foreach模式
         */
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void hashTableTest() {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            String value = next.getValue();
            Integer key = next.getKey();
            System.out.println(key + ":" + value);
        }

        /**
         * foreach模式
         */
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
