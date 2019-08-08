package com.camel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
 
public class SimpleRouteBuilder extends RouteBuilder {
 
	
    @Override
    public void configure() throws Exception {
    	System.out.println("started route");
     
    	
    	
    	from("file:input?noop=true")
    	.beanRef("helloBean", "sayHello");			//bean reference
    }

}