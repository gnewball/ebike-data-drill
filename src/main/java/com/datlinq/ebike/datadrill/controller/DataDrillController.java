package com.datlinq.ebike.datadrill.controller;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datlinq.ebike.datadrill.service.DataDrillService;

@RestController
public class DataDrillController {

	@Autowired
	DataDrillService service;
	
	@GetMapping("/restaurant/ebikes")
	public ResponseEntity getRestaurantsForEBikes(@RequestParam String country,@RequestParam String city) {
		
		Exchange result = service.getRestaurantsForEBikes(country, city);
		
		return ResponseEntity
		.status(Integer.parseInt(result.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE).toString()))
		.body(result.getIn().getBody());
	}
	
	
	
}
