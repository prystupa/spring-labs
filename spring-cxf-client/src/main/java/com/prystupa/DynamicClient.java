package com.prystupa;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.lang.reflect.Method;

public class DynamicClient {
    private static final String WSDL_LOCATION = "http://localhost:8080/spring-cxf-server/OrderProcess?wsdl";

    public static void main(String[] args) throws Exception {

        JaxWsDynamicClientFactory dynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = dynamicClientFactory.createClient(WSDL_LOCATION);
        
        Class<?> orderClass = Thread.currentThread().getContextClassLoader().loadClass("com.prystupa.Order");
        Method setCustomerID = orderClass.getMethod("setCustomerID", String.class);
        Method setItemID = orderClass.getMethod("setItemID", String.class);
        Method setQuantity = orderClass.getMethod("setQuantity", int.class);
        Method setPrice = orderClass.getMethod("setPrice", double.class);

        Object order = orderClass.newInstance();
        setCustomerID.invoke(order, "C001");
        setItemID.invoke(order, "I001");
        setQuantity.invoke(order, 100);
        setPrice.invoke(order, 200.0);
        
        Object[] response = client.invoke("processOrder", order);
        System.out.println("Response is " + response[0]);
    }
}
