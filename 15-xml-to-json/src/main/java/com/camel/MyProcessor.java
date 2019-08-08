package com.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		Employee emp = exchange.getIn().getBody(Employee.class);
		Employee newEmp = new Employee();
		newEmp.setId(emp.getId() + 101);
		newEmp.setName(emp.getName().toUpperCase());
		
		exchange.getOut().setBody(newEmp);
	}

}
