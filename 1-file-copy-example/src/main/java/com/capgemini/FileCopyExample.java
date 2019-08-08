package com.capgemini;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyExample extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file:input?noop=true")
		.log("level:?ERROR file copy started")
		.to("file:output")
 		.log("file copy finished");
	}
}
