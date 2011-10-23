package com.prystupa;

import javax.jws.WebService;

@WebService
public class OrderProcessImpl implements IOrderProcess {
    @Override
    public String processOrder(Order order) {
        String orderID = validate(order);
        return orderID;
    }

    private String validate(Order order) {
        return "ORD1234";
    }
}
