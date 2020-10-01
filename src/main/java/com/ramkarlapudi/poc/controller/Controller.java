package com.ramkarlapudi.poc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ramkarlapudi.poc.entity.UserProfileEntity;
import com.ramkarlapudi.poc.model.LoginDTO;
import com.ramkarlapudi.poc.model.MailUtil;
import com.ramkarlapudi.poc.model.VerifyOTP;
import com.ramkarlapudi.poc.service.MailingServiceImpl;
import com.ramkarlapudi.poc.service.UserProfileServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/poc")
public class Controller {
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);
	@Autowired
	private UserProfileServiceImpl userProfileServiceImpl;

	@Autowired
	private MailingServiceImpl mailingServiceImpl;

	@Autowired
	private MailUtil mailUtil;
	

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String sendData(@ModelAttribute("Registration") UserProfileEntity userProfileEntity, Model model) {
		userProfileEntity.setVerified("NO");
		Boolean flag = userProfileServiceImpl.uploadProfile(userProfileEntity);
		if (flag) {
			mailUtil.setTo(userProfileEntity.getEmail());
			mailUtil.setText(userProfileEntity.getUsername());
			mailingServiceImpl.sendMail();
			model.addAttribute("successmesage", userProfileEntity.getEmail());
			LOGGER.info(" Profile Uploaded --> OTP SENT -->User Email :-"+ userProfileEntity.getEmail() +"User id "+userProfileEntity.getUserid() );
			return "otppage";
		}
		LOGGER.error("Error while uploading profile to DB -> Flag :" +flag );
		return "index";
	}
	
	@RequestMapping(value = "/otp", method = RequestMethod.POST)
	public String VerifyOtpFromUI(@ModelAttribute("otpemail")VerifyOTP  verifyOTP   , Model model) {
		LOGGER.info("OTP API called------");
		String response = mailingServiceImpl.verifyOtpCheck(verifyOTP);
		model.addAttribute("otpkey" ,response);
		if("Success".equals(response)) {
			userProfileServiceImpl.profileupdate();
			return "LoginPage";
		}
		LOGGER.warn("Invalid OTP");
		return "otppage";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginAuth(@ModelAttribute("loginpage")LoginDTO loginData , Model model  ) {
		LOGGER.info("Login APi Called -----");
	String message =	userProfileServiceImpl.Login(loginData);
	model.addAttribute("loginkey" ,message);
	if(message == "Success") {
		return "HomePage";
	}
		return "LoginPage";
		
	}
	

}
