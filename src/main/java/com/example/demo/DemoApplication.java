package com.example.demo;

import com.example.demo.collection.ActiveMQ.BankMapper;
import com.example.demo.collection.ActiveMQ.TestConsumer;
import com.example.demo.collection.ActiveMQ.TestProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.jms.JMSException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) throws JMSException, InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
        BankMapper bankMapper = (BankMapper) SmartSpringUtil.getApplicationContext().getBean("bankMapper");
        new Thread(()->{
            try {
                new TestProduct();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                new TestConsumer(bankMapper);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }).start();
	}
}
