package com.cg;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:sendMail")
		.setHeader("Subject", constant("Thanks for ordering"))
		.setHeader("From", constant("dmjadhav795@gmail.com"))
		.to("velocity://rider/mail.vm")
		.to("smtps://smtp.gmail.com:465?username=dmjadhav795@gmail.com&password=Admin@123");
	}
}