package com.example.demo.collection.Queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author Administrator
 * @date 2017/12/26 10:05
 */
public class Consumer implements Runnable{
    BlockingQueue<String> queue;
    public Consumer(BlockingQueue<String> queue) {
        //使用有参构造函数的目的是我在创建这个消费者对象的时候就可以传进来一个队列
        this.queue = queue;
    }
    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(10));
            System.out.println(Thread.currentThread().getName()+ "准备消费...");
            String temp = queue.take();//从队列中取任务消费，如果队列为空，会阻塞当前线程
            System.out.println(Thread.currentThread().getName() + " 获取到工作任务==== " +temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
