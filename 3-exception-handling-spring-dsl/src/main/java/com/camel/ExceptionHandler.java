package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExceptionHandler implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("------------------exception handled------------------");
	}

}
