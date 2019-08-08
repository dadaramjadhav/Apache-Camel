package com.camel;
import org.apache.camel.builder.RouteBuilder;
 
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:c:\\input?noop=true")
        .process(new MyProcessor())
        .to("file:c:\\output");
    }

}