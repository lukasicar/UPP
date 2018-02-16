package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.TenderRequest;
import com.example.demo.model.TenderResponse;
import com.example.demo.model.User;
import com.example.demo.model.User.Type;
import com.example.demo.repositories.UserRepository;

@Component
public class EligibleFirmsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RuntimeService runtimeService;
	
	public List<User> check(TenderRequest tr,User u,String pid) {
		System.out.println("udje odje");
		List<User> firms=userRepository.findByType(Type.firm);
		ArrayList<User> ff=new ArrayList<>();
		for(User firm : firms) {
			if((firm.getCategory().getName().equals(tr.getCategory().getName()))) {
				if(firm.getUdaljenost()>distance(firm.getLatitude(),u.getLatitude(),firm.getLongitude(),u.getLongitude(),0,0))
					ff.add(firm);
			}
		}
		//ne racunanje postojecih ponuda koje su odbijene
		HashMap<String, Object> variables=(HashMap<String, Object>) runtimeService.getVariables(pid);
		@SuppressWarnings("unchecked")
		List<TenderResponse> ponude=(List<TenderResponse>) variables.get("ponude");
		for(TenderResponse tre : ponude) {
			for(User f : firms) {
				if(f.getUsername().equals(tre.getFirmId())) {
					ff.remove(f);
				}
			}
		}
		//System.out.println(ff.size())
		//Slucajan odabir firmi
		if(tr.getMaksimalniBrojPonuda()<ff.size()) {
			ArrayList<User> ff3=new ArrayList<>();
			for(int i=0;i<tr.getMaksimalniBrojPonuda();i++) {
				Random rand = new Random();
				User randomElement = ff.get(rand.nextInt(ff.size()));
				ff3.add(randomElement);
				ff.remove(randomElement);
			}
			return ff3;
		}
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
