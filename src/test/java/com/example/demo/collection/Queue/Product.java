package com.example.demo.collection.Queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author Administrator
 * @date 2017/12/26 10:03
 */
public class Product implements Runnable{
    BlockingQueue<String> queue;
    public Product(BlockingQueue<String> queue) {
        //创建对象时就传入一个阻塞队列
        this.queue = queue;
    }
    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+"开始生产");
            String temp =  Thread.currentThread().getName()+"：生产线程";
            queue.put(temp);//向队列中放数据，如果队列是满的话，会阻塞当前线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
