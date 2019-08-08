package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		if(exchange.getIn().getBody(String.class).contains("first"))
			throw new RuntimeException();
	}

}