package com.ramkarlapudi.poc.service;

import java.util.Random;
import java.util.Timer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.poc.controller.Controller;
import com.ramkarlapudi.poc.model.MailUtil;
import com.ramkarlapudi.poc.model.VerifyOTP;

@Component
public class MailingServiceImpl implements MailingService {
	private static final Logger LOGGER = LogManager.getLogger(MailingServiceImpl.class);
	@Autowired
	private MailUtil mailUtil;

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * @Autowired private static VerifyOTP VerifyOTPUI;
	 */

	private static String VerifyOTP;
	

	@Override
	public Boolean sendMail() {
		LOGGER.info("MailingServiceImpl --> sendMail method called ");
		boolean flag = false;
		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, mailUtil.getFile() != null ? true : false);
			helper.setTo(mailUtil.getTo());
			helper.setSubject("OTP Verfication sent by RamKarlapudi");
			helper.setText("Dear User " + mailUtil.getText() + " your otp to validate the account is" + getRandomNumberString());
			javaMailSender.send(message);
			flag = true;
			OTPExpire();
		} catch (MessagingException e) {
			flag = false;
			LOGGER.error("Exception while eamil sent "+ mailUtil.getTo());
			e.printStackTrace();
		}
		return flag;

	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return VerifyOTP = String.format("%06d", number);
	}

	public static String verifyOtpCheck(VerifyOTP verifyOTPUI) {
		String OTP = verifyOTPUI.getOtpFromUi().trim();
		if (OTP == null || OTP == "") {
			return "Please Enter OTP";
		} else {
			if (VerifyOTP.equals(OTP)) {
				return "Success";
			} else {
				return "Invalid OTP";
			}
		}

		// return null;

	}
	@Scheduled(fixedDelay =120000 )
	public void OTPExpire() {
		VerifyOTP ="expired";
	}

}
