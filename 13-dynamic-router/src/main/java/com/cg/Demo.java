package com.cg;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Demo {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		try {
 			context.addRoutes(new SimpleRouteBuilder());
 			context.start();
 			Thread.sleep(5000);
 		} finally {
			context.stop();
		}
	}
}
