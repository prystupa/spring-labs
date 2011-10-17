package com.prystupa;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientJdk {

    private static final String WSDL_LOCATION = "http://localhost:8080/spring-cxf-server/OrderProcess?wsdl";
    private static final QName SERVICE_NAME = new QName("http://prystupa.com/", "OrderProcessImplService");
    private static final QName PORT_NAME = new QName("http://prystupa.com/", "OrderProcessImplPort");

    public static void main(String[] args) throws MalformedURLException {

        URL wsdlURL = new URL(WSDL_LOCATION);
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        IOrderProcess port = service.getPort(PORT_NAME, IOrderProcess.class);
        
        Order order = new Order();
        order.setCustomerID("C001");
        order.setItemID("I001");
        order.setQuantity(100);
        order.setPrice(200.0);
        String orderID = port.processOrder(order);
        
        System.out.println("The order is processed with ID: " + orderID);
    }
}
