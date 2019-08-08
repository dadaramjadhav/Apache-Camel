package com.camel;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input").split().tokenize("\n").to("jms:queue:myqueue");
	}
}
