package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input").split().tokenize("\n").to("direct:test");

		from("direct:test")
		.choice()
		.when(body().contains("file1"))
		.to("jms:queue:myqueue1")
		.when(body().contains("file2"))
		.to("jms:queue:myqueue2")
		.when(body().contains("file3"))
		.to("jms:queue:myqueue3")
		.otherwise().
		to("jms:queue:otherwise");


	}
}
