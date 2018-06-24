package com.datlinq.ebike.datadrill.service;

import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.datlinq.ebike.datadrill.model.DataQuery;

@Service
public class DataDrillService {

	@Autowired
	private FluentProducerTemplate fluentProducerTemplate;

	public Exchange getRestaurantsForEBikes(String country, String city) {

		DataQuery dataQuery = new DataQuery();
		dataQuery.setQuery("SELECT * FROM cp.`employee.json` LIMIT 5");
		dataQuery.setQueryType("SQL");
		Exchange result = fluentProducerTemplate.withBody(dataQuery)
				 .withHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				 .withHeader("User-Name", "ebike-data-drill")
				.to("direct:datadrill").send();
		return result;

	}

}
