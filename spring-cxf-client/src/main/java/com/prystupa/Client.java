package com.prystupa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Client
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        IOrderProcess client = context.getBean("orderClient", IOrderProcess.class);
        
        Order order = new Order();
        order.setCustomerID("C001");
        order.setItemID("I001");
        order.setQuantity(100);
        order.setPrice(200.0);
        String orderID = client.processOrder(order);
        String message = (orderID == null)? "Order not approved" : "Order approved; order ID is " + orderID;
        System.out.println(message);
    }
}
