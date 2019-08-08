package com.camel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		from("file:input?noop=true")
		.to("xslt:transform.xsl")		
		.to("file:output");
	}
}
