package com.datlinq.ebike.datadrill.service;

import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.component.file.GenericFileOnCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.datlinq.ebike.datadrill.model.DataQuery;

@Service
public class DataDrillService {
	
	@Autowired
	private FluentProducerTemplate fluentProducerTemplate;

	
	public void getRestaurantsForEBikes(String Country, String city){
		
		DataQuery dataQuery = new DataQuery();
		dataQuery.setQuery("SELECT * FROM cp.`employee.json` LIMIT 5");
		dataQuery.setQueryType("SQL");
		Exchange result = fluentProducerTemplate
				.withBody(dataQuery)
//			    .withHeader("address", address)
			    .to("direct:datadrill").send();
		
//		return ResponseEntity
//				.status(Integer.parseInt(result.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE).toString()))
//				.body(result.getIn().getBody());
	}

}
