package com.cg;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	public static final String START_ROUTE = "direct:start";
	public static final String SEDA_END_ROUTE = "seda:end";

	@Override
	public void configure() throws Exception {
		from(START_ROUTE).routeId("SedaStartRouteId").setBody().simple("Seda Message").to(SEDA_END_ROUTE)
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						log.info("Message at Parent route completion");
					}
				});

		from(SEDA_END_ROUTE).routeId("EndRouteId").setBody().simple("End Message").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				log.info("message after seda end route completion");
			}
		});
	}
}