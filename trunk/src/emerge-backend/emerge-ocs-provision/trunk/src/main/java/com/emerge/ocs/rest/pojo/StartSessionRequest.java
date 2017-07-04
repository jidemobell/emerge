package com.emerge.ocs.rest.pojo;

public class StartSessionRequest {

	Payphone payphone;
	Credentials credentials;
	
	public Payphone getPayphone() {
		return payphone;
	}
	public void setPayphone(Payphone payphone) {
		this.payphone = payphone;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	
}
