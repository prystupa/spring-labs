package com.prystupa;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.util.Scanner;

public class HostJdk {
    
    public static void main(String [] args) throws IOException {
        
        System.out.println("Starting JDK host...");
        OrderProcessImpl orderProcess = new OrderProcessImpl();

        Endpoint.publish("http://localhost:8080/OrderProcess", orderProcess);

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.exit(0);
    }
}
