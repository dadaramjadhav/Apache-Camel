package com.camel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		from("file:input?noop=true")
		.bean(MyBean.class, "transform")							//transformation using bean method
//		.process(new MyProcessor())									//using custom processor
//		.transform(body().regexReplaceAll("[0-9]", "AA"))			//transformation using transform method
		.to("file:output");
	}
}