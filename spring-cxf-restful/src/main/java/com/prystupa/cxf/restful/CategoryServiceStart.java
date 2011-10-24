package com.prystupa.cxf.restful;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CategoryServiceStart {
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("self-hosting-beans.xml");
        CategoryService service = context.getBean("categoryService", CategoryService.class);

        JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
        restServer.setServiceBeanObjects(service);
        restServer.setAddress("http://localhost:8080/");
        restServer.create();
    }
}
