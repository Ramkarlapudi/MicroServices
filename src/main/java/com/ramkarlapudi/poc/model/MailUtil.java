package com.ramkarlapudi.poc.model;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	private String to ;
	private String cc[] ;
	private  String bcc[] ;
	private String subject;
	private String text ;
	private  Resource file ;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	public String[] getBcc() {
		return bcc;
	}
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Resource getFile() {
		return file;
	}
	public void setFile(Resource file) {
		this.file = file;
	}
	
	
	

}
