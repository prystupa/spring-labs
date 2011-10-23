package com.prystupa;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;

import javax.xml.namespace.QName;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DynamicCxfClient {
    private static final String WSDL_LOCATION = "http://localhost:8080/spring-cxf-server/OrderProcess?wsdl";
    
    public static void main(String[] args) throws Exception, InstantiationException, IntrospectionException, InvocationTargetException {

        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient(WSDL_LOCATION);

        Endpoint endpoint = client.getEndpoint();
        ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);

        QName bindingName = new QName("http://prystupa.com/", "OrderProcessImplServiceSoapBinding");
        BindingInfo bindingInfo = serviceInfo.getBinding(bindingName);

        QName operationName = new QName("http://prystupa.com/", "processOrder");
        BindingOperationInfo operationInfo = bindingInfo.getOperation(operationName);

        BindingMessageInfo inputMessageInfo = null;
        if(!operationInfo.isUnwrapped()) {
            inputMessageInfo = operationInfo.getWrappedOperation().getInput();
        }
        else {
            inputMessageInfo = operationInfo.getUnwrappedOperation().getInput();
        }

        List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
        MessagePartInfo orderPartInfo = parts.get(0);    // Input class is Order
        
        Class<?> orderClass = orderPartInfo.getTypeClass();
        Object order = orderClass.newInstance();

        // Populate the order bean
        PropertyDescriptor customerIdProperty = new PropertyDescriptor("customerID", orderClass);
        customerIdProperty.getWriteMethod().invoke(order, "C001");
        PropertyDescriptor itemIdProperty = new PropertyDescriptor("itemID", orderClass);
        itemIdProperty.getWriteMethod().invoke(order, "I001");
        PropertyDescriptor quantityProperty = new PropertyDescriptor("quantity", orderClass);
        quantityProperty.getWriteMethod().invoke(order, 100);
        PropertyDescriptor price = new PropertyDescriptor("price", orderClass);
        price.getWriteMethod().invoke(order, 200.0);

        Object [] result = client.invoke(operationName, order);
        System.out.println("Order ID is " + result[0].toString());
    }
}
