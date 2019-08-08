package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	int count=0;
	@Override
	public void configure() throws Exception {
		
		intercept()
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				count++;
				System.out.println("Interceptor called : "+ count + "  "+ exchange.getIn().getBody() );
			}
		});
		
		
		from("file:input?noop=true")
		.split()
		.tokenize("\n")
		.loadBalance()
		.roundRobin()
		.to("jms:queue:queue1")
		.to("jms:queue:queue2")
		.to("jms:queue:queue3");
	}
}
