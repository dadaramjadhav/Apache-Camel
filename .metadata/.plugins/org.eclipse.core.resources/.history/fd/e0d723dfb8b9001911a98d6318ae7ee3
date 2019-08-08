package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		//using try ... catch ... finally
		
		from("file:input?noop=true")
		.doTry()
		.process(new MyProcessor())
		.to("file:output")
		.doCatch(CamelCustomException.class)
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
		})
		.doFinally()
		.log("received body");

	}
}