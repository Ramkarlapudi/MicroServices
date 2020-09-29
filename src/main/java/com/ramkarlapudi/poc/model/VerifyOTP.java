package com.ramkarlapudi.poc.model;

import org.springframework.stereotype.Component;

@Component
public class VerifyOTP {
	
	private String otpFromUi;

	public String getOtpFromUi() {
		return otpFromUi;
	}

	public void setOtpFromUi(String otpFromUi) {
		this.otpFromUi = otpFromUi;
	}
	

}
