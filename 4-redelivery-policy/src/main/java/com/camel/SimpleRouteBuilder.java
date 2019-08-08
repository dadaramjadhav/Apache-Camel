package com.camel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
 
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
    	  onException(CamelCustomException.class).process(new Processor() {
              public void process(Exchange exchange) throws Exception {
                  System.out.println("handling ex");
              }
          }).redeliveryPolicyRef("my-policy").log("Received body ").handled(true);
    	  
    	  
//    	  onException(CamelCustomException.class).maximumRedeliveries(2).maximumRedeliveryDelay(2000);

        from("file:input?noop=true")
        .process(new MyProcessor())
        .to("file:output");
    }

}