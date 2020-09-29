package com.ramkarlapudi.poc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.poc.controller.Controller;
import com.ramkarlapudi.poc.entity.UserProfileEntity;
import com.ramkarlapudi.poc.repository.UserProfile;

@Component
public class UserProfileServiceImpl implements UserProfileService {
	private static final Logger LOGGER = LogManager.getLogger(UserProfileServiceImpl.class);
	@Autowired
	private UserProfile userProfile;

	@Autowired
	private UserProfileEntity userProfileEntitys;
	private static String userid ;

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
		LOGGER.info("updateprofile query executed  Userid:- "+userProfileEntitys.getUserid() );
	}
}
