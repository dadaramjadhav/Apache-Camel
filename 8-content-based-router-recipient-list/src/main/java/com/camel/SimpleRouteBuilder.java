package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:input").split().tokenize("\n").to("direct:test");
        
		
		from("direct:test")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String recipient = exchange.getIn().getBody().toString();
				String recipientQueue="jms:queue:"+recipient;
				exchange.getIn().setHeader("queue", recipientQueue);
			}
		}).recipientList(header("queue"));


	}
}
