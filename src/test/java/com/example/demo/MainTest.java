package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MainTest {

    @Test
    public void test1() {
        Integer a = null;
        Integer b = 1 - a;
        if (b < 0) {
            System.out.print("通过");
        } else {
            System.out.print("Bu通过");
        }
    }

    @Test
    public void test2() {
        Integer a = 5;
        a <<= 1;
        long b = 1 << 32;
        System.out.println(a);
    }

    @Test
    public void test3() {
        /**
         * 8种基本类型是不能被泛型的，
         */
        Byte[] bytes = {1, 5, 6};
        List list = Arrays.asList( bytes);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }

    @Test
    public void test4() {
        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now());
        LocalTime time = LocalTime.now().withNano(0).withSecond(0).withMinute(0);
        System.out.println(time);
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis()));
    }

}
