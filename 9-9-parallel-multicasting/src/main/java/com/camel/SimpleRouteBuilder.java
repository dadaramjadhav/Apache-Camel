package com.camel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		ExecutorService es = Executors.newFixedThreadPool(2);
		from("file:input?noop=true")
		.multicast()
		.parallelProcessing()
		.executorService(es)
		.to("file:output", "file:output1");
		
		es.awaitTermination(2, TimeUnit.SECONDS);
		
		
		
	}
}
