package com.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        ctx.start();
        System.out.println("Application context started");

        //getting bean information through bean-registry
        CamelContext camelCt = ctx.getBean("employeeContext", DefaultCamelContext.class);
        HelloBean hb = camelCt.getRegistry().lookup("helloBean", HelloBean.class);
        System.out.println(hb.hashCode());
        
        try {
            Thread.sleep(5   * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.stop();
        ctx.close();
    }
}