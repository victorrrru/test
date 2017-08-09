package com.example.demo.steamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created By victorrrr on 2017/8/9
 */
public class SteamTest1 {

    @Test
    public void test1() {
        Stream<Long> stream = Stream.generate(new NatureSupplier());
        stream.map((x)->{
            return Math.tan(x) * x;
                }
        ).limit(20).forEach(System.out :: println);
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
                new Transaction(xiaohong,2016,1000),
                new Transaction(xiaohong,2017,400),
                new Transaction(xiaohei,2016,710),
                new Transaction(xiaohei,2016,700),
                new Transaction(xiaobai,2016,950)
        );

        List<Transaction> stream = transactions.stream().filter(t -> t.getYear() == 2016)
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .collect(Collectors.toList());
        System.out.println(stream);

    }
}
