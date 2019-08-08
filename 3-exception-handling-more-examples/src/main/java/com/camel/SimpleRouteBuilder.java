package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		//getting reason for exception
		onException(CamelCustomException.class)
		.handled(true)						//false to send exception back to client
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
				System.out.println("-----------Handled exception--------------"+ exception);
			}
		});

		from("file:input?noop=true")
		.process(new MyProcessor())
		.to("file:output");
	}
}