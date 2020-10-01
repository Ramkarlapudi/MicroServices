package com.ramkarlapudi.poc.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.poc.controller.Controller;
import com.ramkarlapudi.poc.entity.UserProfileEntity;
import com.ramkarlapudi.poc.model.LoginDTO;
import com.ramkarlapudi.poc.repository.UserProfile;

@Component
public class UserProfileServiceImpl implements UserProfileService {
	private static final Logger LOGGER = LogManager.getLogger(UserProfileServiceImpl.class);
	@Autowired
	private UserProfile userProfile;

	@Autowired
	private UserProfileEntity userProfileEntitys;
	private static String userid;

	@Override
	public Boolean uploadProfile(UserProfileEntity userProfileEntity) {
		this.userProfileEntitys = userProfileEntity;
		if (userProfileEntity != null) {
			userProfile.save(userProfileEntity);
			LOGGER.info(" userProfileServiceImpl.uploadProfile(userProfileEntity) --EXECUTED  ");
			return true;
		}

		return false;
	}

	public void profileupdate() {
		userProfile.updateprofile(userProfileEntitys.getUserid());
		LOGGER.info("updateprofile query executed  Userid:- " + userProfileEntitys.getUserid());
	}

	public String Login(LoginDTO Logindto) {
		List<String> str = userProfile.findByUserName(Logindto.getUsername());
		if (str != null && str.size() > 0) {
			for (String string : str) {
				String[] values = string.split(",");
				LOGGER.info("arr length " + values.length + " " + values[0] + " " + values[1]);
				if (values[0].equalsIgnoreCase(Logindto.getPassword()) && values[1].equals("YES")) {
					values = null;
					return "Success";
				} else if (values[0].equalsIgnoreCase(Logindto.getPassword()) && values[1].equals("NO")) {
					values = null;
					return "Profile Not Verified";
				} else {
					values = null;
					return "Invalid Username and passcode";
				}

			}

		}
		return "User Profile not Found";
	}
}
