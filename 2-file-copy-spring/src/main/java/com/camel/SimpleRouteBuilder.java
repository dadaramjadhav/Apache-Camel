package com.camel;
import org.apache.camel.builder.RouteBuilder;
 
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
        .process(new MyProcessor())
        .to("file:output");
    }

}