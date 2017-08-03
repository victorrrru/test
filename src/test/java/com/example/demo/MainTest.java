package cn.rain.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
