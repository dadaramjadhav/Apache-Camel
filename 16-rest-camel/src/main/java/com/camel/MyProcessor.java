package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.endpoint.ClientImpl.EchoContext;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println(exchange.getIn().getBody(String.class));
	}
}