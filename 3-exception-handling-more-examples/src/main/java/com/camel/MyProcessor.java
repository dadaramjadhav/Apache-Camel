package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws CamelCustomException {
		System.out.println("Exception Thrown");
		throw new CamelCustomException();
	}

}