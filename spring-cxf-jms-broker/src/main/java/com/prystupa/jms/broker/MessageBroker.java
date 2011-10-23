package com.prystupa.jms.broker;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;

public class MessageBroker {
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.setPersistenceAdapter(new MemoryPersistenceAdapter());
        broker.addConnector("tcp://localhost:61616");
        broker.start();

        System.out.println("JMS broker ready...");
    }
}
