package com.datlinq.ebike.datadrill.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class DataDrillRoute extends RouteBuilder {

	@Override
	public void configure() {

		from("direct:datadrill").routeId("direct-route").tracing().log("${in.body}")
				.marshal().json(JsonLibrary.Jackson).log("${in.body}")
				.to("http4:localhost:8047/query.json").convertBodyTo(String.class).log("${body}");
	}

}
