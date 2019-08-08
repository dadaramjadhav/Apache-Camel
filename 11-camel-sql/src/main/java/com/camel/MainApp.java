package com.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) throws Exception {


		ApplicationContext springCtx = new ClassPathXmlApplicationContext("context.xml");

		CamelContext context = springCtx.getBean("employeeContext", CamelContext.class);

		context.start();

		ProducerTemplate producerTemplate = context.createProducerTemplate();

		Employee emp1 = new Employee("101", "dm101");
		String resp = producerTemplate.requestBody("direct:insert", emp1, String.class);

		Employee emp2 = new Employee("102", "dm102");
		resp = producerTemplate.requestBody("direct:insert", emp2, String.class);
		
		context.stop();
		
	}
}