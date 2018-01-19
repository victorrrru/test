package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
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

    @Test
    public void test5() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            double aLong = 1514477810000d;
            double aLong1 = 1514482005000d;
            String format1 = format.format(aLong);
            String format2 = format.format(aLong1);
            Date parse = format.parse(format1);
            Date parse1 = format.parse(format2);
            System.out.println(parse);
            System.out.println(parse1);
            System.out.println("----------");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {

    }

}
