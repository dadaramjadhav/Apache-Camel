package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
    	System.out.println("Exchange id: "+ exchange.getExchangeId());
    	String str = exchange.getIn().getBody(String.class);
    	str = str.toUpperCase(); 
        exchange.getOut().setBody(str);
    }
}