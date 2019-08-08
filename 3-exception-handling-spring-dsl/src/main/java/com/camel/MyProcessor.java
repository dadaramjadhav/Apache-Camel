package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.engine.DefaultShutdownStrategy;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		
		
		System.out.println("----------Exception Thrown-------------");
		throw new CamelCustomException();
	}

}