package com.datlinq.ebike.datadrill.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataDrillController {

	@GetMapping("/datlinq/restaurant/ebikes")
	public ResponseEntity getRestaurantsForEBikes(@RequestParam String country,@RequestParam String city) {
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
