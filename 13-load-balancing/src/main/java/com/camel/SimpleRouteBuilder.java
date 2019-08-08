package com.camel;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input")
		.split()
		.tokenize("\n")
		.loadBalance()
		.roundRobin()
		.to("jms:queue:queue1")
		.to("jms:queue:queue2")
		.to("jms:queue:queue3");
	}
}
