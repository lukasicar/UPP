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

	  public MockUser resolveLocation(MockUser u){
		 
		  GeoApiContext context = new GeoApiContext();
		  context.setApiKey("AIzaSyDT9LFTvIEcj1GhGxjZkp8_CO2gFjkyBPY");
				GeocodingResult[] results;
				try {
					results = GeocodingApi.geocode(context,
					    u.getMjesto()).await();
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					u.setLongitude((long) results[0].geometry.location.lng);
					u.setLatitude((long) results[0].geometry.location.lat);
					//u.setLatitude(Long.parseLong(gson.toJson(results[0].geometry.location.lat)));
					//u.setLongitude(Long.parseLong(gson.toJson(results[0].geometry.location.lng)))'
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		  
	    
	    return u;
	  }
}
