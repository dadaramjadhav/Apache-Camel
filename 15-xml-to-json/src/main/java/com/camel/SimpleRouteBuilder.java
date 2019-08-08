package com.camel;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.CsvDataFormat;

public class SimpleRouteBuilder extends RouteBuilder {

	int count=0;
	@Override
	public void configure() throws Exception {

		//xml data
		JaxbDataFormat xml = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Employee.class);
		xml.setContext(con);

		//json data 
		JacksonDataFormat json = new JacksonDataFormat(Employee.class);		

		from("file:input?noop=true")
		.doTry()
		.unmarshal(xml)
		.process(new MyProcessor())
		.marshal(json)
		.to("jms:queue:xmltojson")
		.doCatch(Exception.class)
		.process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
				System.out.println(cause);
			}
		});
	}
}
