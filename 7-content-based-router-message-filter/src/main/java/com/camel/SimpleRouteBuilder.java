package com.camel;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		 from("file:input?noop=true").split().tokenize("\n").to("direct:test");
	      
		 from("direct:test"). 
	        filter(body().contains("file1"))
	        .to("jms:queue:myqueue1");
	       
		
	}
}
