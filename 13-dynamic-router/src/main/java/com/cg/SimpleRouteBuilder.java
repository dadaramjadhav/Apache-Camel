package com.cg;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input?noop=true").split().tokenize("\n").dynamicRouter(method(DynamicRouteBean.class, "route"));

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