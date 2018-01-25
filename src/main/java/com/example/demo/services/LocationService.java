package com.example.demo.services;

import org.springframework.stereotype.Component;

import com.example.demo.model.MockUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

@Component
public class LocationService {

	  public String resolveLocation(MockUser u){
		 /*
		  GeoApiContext context = new GeoApiContext();
		  context.setApiKey("AIzaSyDT9LFTvIEcj1GhGxjZkp8_CO2gFjkyBPY");
				GeocodingResult[] results;
				try {
					results = GeocodingApi.geocode(context,
					    "Kikinda").await();
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					System.out.println(gson.toJson(results[0].geometry.location));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
		  
	    System.out.println("ei opsasa");
	    return "sadsa";
	  }
}
