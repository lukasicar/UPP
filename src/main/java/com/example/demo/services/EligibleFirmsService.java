package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.TenderRequest;
import com.example.demo.model.User;
import com.example.demo.model.User.Type;
import com.example.demo.repositories.UserRepository;

@Component
public class EligibleFirmsService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> check(TenderRequest tr) {
		System.out.println("udje odje");
		List<User> firms=userRepository.findByType(Type.firm);
		ArrayList<User> ff=new ArrayList<>();
		//System.out.println(firms.size());
		//System.out.println(firms);
		for(User firm : firms) {
			//System.out.println(firm.getUsername());
			//System.out.println(firm.getCategory());
			//System.out.println(firm.getCategory().getName());
			//System.out.println(tr.getCategory().getName());
			if((firm.getCategory().getName().equals(tr.getCategory().getName()))) {
				ff.add(firm);
			}
		}
		//System.out.println(ff.size());
		return ff;
	}
	
	
	public String notifyThereIsNone() {
		System.out.println("nema firmi");
		return "aaa";
	}
	
	public static double distance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = el1 - el2;

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance);
	}
	
}
