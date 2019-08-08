package com.cg;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class my implements Processor{

	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody().toString();
		body = body + "processing in route1";
		System.out.println(body);
		exchange.getOut().setBody(body);
	}

}
