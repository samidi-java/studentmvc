package com.fis.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@RestController
public class SMSController {
	
	private static final String account_sid="AC4a36c136075b8a00450481e3c82dc19a";
	private static final String auth_id="a3618b58513609bc6ad9717bb420f55d";
	private static final String fromNumber="+14057844887";
	
	static 
	{
		Twilio.init(account_sid, auth_id);
	}
	
	@GetMapping("/sendsms")
	public String sendSMS()
	{
		Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+919986745720"),
                new com.twilio.type.PhoneNumber(fromNumber),
                "welcome spring demo on sep 15th 2022")
            .create();
		System.out.println(message.getSid());
		return "Message sent successfully";
	}

}
