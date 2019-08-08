package com.cg;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:input?noop=true").doTry().setHeader("subject", simple("email from apache camel"))
				.setHeader("to", simple("dadaramjadhav@gmail.com, dadaram.jadhav@capgemini.com"))
				.to("smtps://smtp.gmail.com:465?username=dmjadhav795@gmail.com&password=Admin@123");
	}
}