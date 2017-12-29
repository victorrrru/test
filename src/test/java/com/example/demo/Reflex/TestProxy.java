package com.example.demo.Reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @date 2017/12/29 14:31
 */
public class TestProxy {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Sale proxy = (Sale) Proxy.newProxyInstance(SaleService.class.getClassLoader(), SaleService.class.getInterfaces(),
                (proxy1, method, args1) -> method.invoke(proxy1));
        System.out.println(proxy.clothes(40));
        System.out.println("------------");
        Class<SaleService> aClass = SaleService.class;
//        Class<?> aClass = Class.forName("com.example.demo.Reflex.SaleService");
        Object o = aClass.newInstance();
        Method[] methods = aClass.getMethods();
        Object invoke = methods[0].invoke(o, 40);
        System.out.println(invoke);
    }
}
