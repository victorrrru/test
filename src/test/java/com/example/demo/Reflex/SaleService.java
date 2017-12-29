package com.example.demo.Reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @date 2017/12/29 14:20
 */
public class SaleService implements Sale{
    public int clothes(int size) {
        System.out.println("衣服大小" + size);
        return 50;
    }
}
