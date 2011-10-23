package com.prystupa.jms.broker;

import com.prystupa.IOrderProcess;
import com.prystupa.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"client-beans.xml"});
        
        IOrderProcess orderProcess = context.getBean("orderClient", IOrderProcess.class);
        String orderId = orderProcess.processOrder(new Order());
        System.out.println("Order processed with ID: " + orderId);
        System.exit(0);
    }
}
