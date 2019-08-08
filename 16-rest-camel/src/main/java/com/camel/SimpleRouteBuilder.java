package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

public class SimpleRouteBuilder extends RouteBuilder {

	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

	@Override
	public void configure() throws Exception {

		from("file:input?noop=true").setHeader(Exchange.HTTP_METHOD, simple("GET"))
		.to("http://localhost:8080/employee/105").process(new MyProcessor());

		// route for REST POST Call
		from("file:input1?noop=true").process(new MyProcessor()).marshal(jsonDataFormat)
		.setHeader(Exchange.HTTP_METHOD, simple("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).to("http://localhost:8080/employee")
		.process(new MyProcessor());
	}
}