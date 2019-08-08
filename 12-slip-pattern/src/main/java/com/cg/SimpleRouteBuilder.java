package com.cg;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input?noop=true").split().tokenize("\n").process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				String body = exchange.getIn().getBody().toString();
				String res;
				if(body.contains("sequence1")) {
					res = "direct:r1, direct:r2, direct:r3";
				}
				else {
					res = "direct:r3, direct:r2, direct:r1";
				}
				exchange.getIn().setHeader("mySlipHeader", res);
			}
		}).routingSlip(header("mySlipHeader"));
	
		from("direct:r1")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String body = exchange.getIn().getBody().toString();
				body = body + "processing in route1";
				System.out.println(body);
				exchange.getOut().setBody(body);
			}
		});
		
		from("direct:r2")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String body = exchange.getIn().getBody().toString();
				body = body + "processing in route2";
				System.out.println(body);
				exchange.getOut().setBody(body);
			}
		});
		
		from("direct:r3")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String body = exchange.getIn().getBody().toString();
				body = body + "processing in route3";
				System.out.println(body);
				exchange.getOut().setBody(body);
			}
		});
	}
}