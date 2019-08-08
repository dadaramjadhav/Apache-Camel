package com.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		//common errorhandler across routes
		errorHandler(defaultErrorHandler()
				.maximumRedeliveries(2)
				.redeliveryDelay(1000)
				.retryAttemptedLogLevel(LoggingLevel.WARN));
		
		
		
		from("file:input?noop=true")		
		.errorHandler(deadLetterChannel("log:dead?level=ERROR").useOriginalMessage())			//errors in log
//		.errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.ERROR))		
//		.errorHandler(deadLetterChannel("file:error"))						//errors in file
		.process(new MyProcessor())
		.to("file:output");
	}
}