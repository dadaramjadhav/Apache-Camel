package com.cg;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouteBean {
	public String route(String body, @Header(Exchange.SLIP_ENDPOINT) String previousRoute) {
		if (previousRoute == null) {
			return "direct:r3";

		} else if (body.toString().equals("sequence2processing in route3")) {
			return "direct:r2";
		} else if (body.toString().equals("sequence2processing in route3processing in route2")) {
			return "direct:r1";
		} else {
			return null;
		}
	}
}
