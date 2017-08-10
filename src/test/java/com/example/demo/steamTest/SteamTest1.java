package com.example.demo.steamTest;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created By victorrrr on 2017/8/9
 */
public class SteamTest1 {

    @Test
    public void test1() {
        Stream<Long> stream = Stream.generate(new Supplier<Long>() {
            long a = 0;
            @Override
            public Long get() {
                this.a = this.a + 1;
                return a;
            }
        });
        stream.map(x->Math.tan(x) * x).limit(20).forEach(System.out :: println);
         //如果想取得数列的第20~30项
//        stream.skip(20).limit(10).collect(Collectors.toSet()).forEach(System.out :: println);
    }

    @Test
    public void test2() {

        //建立对象
        Trader xiaoming=new Trader("小明","广州");
        Trader xiaohong=new Trader("小红","广州");
        Trader xiaohei=new Trader("小黑","广州");
        Trader xiaobai=new Trader("小白","肇庆");

        //新建一个交易的集合
        List<Transaction> transactions= Arrays.asList(
                new Transaction(xiaoming, 2017, 300),
                new Transaction(xiaohong, 2016,1000),
                new Transaction(xiaohong, 2017,400),
                new Transaction(xiaohei, 2016,710),
                new Transaction(xiaohei, 2016,700),
                new Transaction(xiaobai, 2016,950)
        );

        List<Transaction> stream = transactions.stream().filter(t -> t.getYear() == 2016)
                .sorted(Comparator.comparing(a -> a.getValue()))
                .collect(Collectors.toList());
        System.out.println(stream);

    }

    @Test
    public void test3() {
        Stream<String> str = Stream.of("jsfiehguihr");
        str.map(s -> s.toCharArray()).forEach(System.out :: println);
    }

    @Test
    public void test4() {
//        Stream.iterate(1,s -> s+1).limit(10).forEach(System.out :: println);
        Stream.iterate(1,s -> s+1).peek(x->Math.tan(x)).limit(10).forEach(System.out :: println);
    }

    @Test
    public void test5() {
//        List<Integer> list = Arrays.asList(1, 2, 3, 5);
//        System.out.println(list.stream().reduce(2,(sum, i) -> sum + i));
        List<String> list1 = Arrays.asList("1", "2", "3", "5");
        System.out.println(list1.stream().reduce(0, (sum, word) -> sum + word.length(),
                (sum1, sum2) -> sum1 + sum2));
    }

    @Test
    public void test6() {
        List<Integer> numList = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        List<Integer> numsWithoutNullList = numList.stream()
//                .filter(num -> num != null)
//                .collect(() -> new ArrayList<Integer>(),
//                        (list, item) -> list.add(item),
//                        (list1, list2) -> list1.addAll(list2));

//        List<Integer> l = numList.stream()
//                .filter(num -> num != null)
//                .collect(ArrayList :: new, ArrayList :: add, ArrayList :: addAll);

        List<Integer> l = numList.stream().
                filter(num -> num != null)
                .collect(Collectors.toList());
        System.out.println(l);
    }

    /**
     * 對Collectors.toMap进行剖析
     */
    @Test
    public void test7() {
        //建立对象
        Trader xiaoming=new Trader("小明","广州");
        Trader xiaohong=new Trader("小红","广州");
        Trader xiaohei=new Trader("小黑","广州");
        Trader xiaobai=new Trader("小白","肇庆");

        //新建一个交易的集合
        List<Transaction> transactions= Arrays.asList(
                new Transaction(xiaoming, 2017, 300),
                new Transaction(xiaohong, 2016,1000),
                new Transaction(xiaohong, 2017,400),
                new Transaction(xiaohei, 2016,710),
                new Transaction(xiaohei, 2016,700),
                new Transaction(xiaobai, 2016,950)
        );
//        transactions.stream().collect(Collectors.toMap(Trader :: getName, Transaction ::
//        getValue))
        Map<String, Transaction> map = transactions.stream().collect(Collectors.toMap(transaction->transaction.getTrader().getName(), transaction->transaction, (existValue, newValue)->existValue));
        for (Map.Entry<String, Transaction> entry:map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getValue());
        }

    }

    /**
     * 对skin和limit验证
     */
    @Test
    public void test8() {
        List<Integer> nums = new ArrayList();
        nums.add(1);
        nums.add(1);
        nums.add(null);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(null);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);
        System.out.println("sum is:"+nums.stream()
                .filter(num -> num != null)
                .distinct()
                .mapToInt(num -> num * 2)
                .peek(System.out::println)
                .skip(5)
                .limit(4)
                .sum());
    }
}
