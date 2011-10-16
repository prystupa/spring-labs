package com.prystupa;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.lang.String;

@WebService
public interface IOrderProcess {

    @WebMethod
    public String processOrder(Order order);
}
