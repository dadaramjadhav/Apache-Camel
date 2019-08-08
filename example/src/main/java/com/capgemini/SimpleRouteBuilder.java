package com.capgemini;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:c:/input?noop=true")
		.bean(Example.class, "hello")
		.to("file:c:/output")
 		.log("file copy finished");
		
	}
}

