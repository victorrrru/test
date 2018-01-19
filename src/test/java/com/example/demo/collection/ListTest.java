package com.example.demo.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {

    @Test
    public void linkedListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-8);
        list.add(30);
//
//        Collections.sort(list);
//        Collections.reverse(list);
        Comparator<Object> comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-8);
        list.add(30);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);

        list.toArray(new Integer[0]);
        Comparator<Object> comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(30);

        HashSet<Integer> set = new HashSet<>(list);
    }
    @Test
    public void test4() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Date date = new Date((long) (System.currentTimeMillis() + Math.random() * 1000000000));
            Student student = new Student();
            student.setBirthday(date);
            list.add(student);
            System.out.println(format.format(date));
        }
        list.sort(Comparator.comparing(Student::getBirthday));
        list.stream().map(Student::getBirthday).forEach(System.out::println);
    }

}

