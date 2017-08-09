package com.example.demo.steamTest;

import org.junit.Test;

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
}
