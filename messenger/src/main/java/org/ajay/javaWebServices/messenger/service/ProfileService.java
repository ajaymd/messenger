package org.ajay.javaWebServices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ajay.javaWebServices.messenger.database.DatabaseClass;
import org.ajay.javaWebServices.messenger.model.Profile;

public class ProfileService {
	


	private static Map<String, Profile> profiles= DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("ajay",  new Profile(1L,"ajay","Madkaiker","Ajay"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String id) {
		return profiles.get(id);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
		return null;
		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfiles(String profileName) {
		
		return profiles.remove(profileName);
	}
}
