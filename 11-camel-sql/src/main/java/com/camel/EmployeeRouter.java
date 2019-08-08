package com.camel;

import org.apache.camel.builder.RouteBuilder;

public class EmployeeRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:insert")
		.beanRef("employeeMapper","getMap")
		.to("sqlComponent:{{sql.insertEmployee}}");
	}

}
