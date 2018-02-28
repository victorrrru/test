package com.example.demo.collection.ActiveMQ;

import javax.jms.JMSException;

/**
 * @author Administrator
 * @date 2017/12/26 17:34
 */
public class TestConsumer implements Runnable{
    static Thread thread = null;
    BankMapper bankMapper;

    public TestConsumer(BankMapper bankMapper) throws InterruptedException, JMSException {
        this.bankMapper = bankMapper;
        Consumer consumer = new Consumer();
        consumer.consumerMessage(bankMapper);
        //thread = new Thread(new TestConsumer(bankMapper));
        //thread.start();
        while (true){
            //时刻监听消息队列，如果线程死了，则新建一个线程
            boolean alive = thread.isAlive();
            System.out.println("当前线程状态："+alive);
            if(!alive){
                thread = new Thread(new TestConsumer(bankMapper));
                thread.start();
                System.out.println("线程重启完成");
            }
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        try {
            Consumer consumer = new Consumer();
            consumer.consumerMessage(bankMapper);
            while (Consumer.isconnection) {
                //System.out.println(123);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
