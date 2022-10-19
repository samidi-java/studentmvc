package com.fis.mvc.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/sendmail")
	public String sendMail() throws MessagingException
	{
		String from="samidi.java@gmail.com";
		String to="samidi.hcl@gmail.com";
		
		SimpleMailMessage message=new SimpleMailMessage();		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Simple text mail");
		message.setText("Hello,this simple mail");
		/*
		MimeMessage message=mailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(message, true);
		messageHelper.setFrom(from);
		messageHelper.setTo(to);
		messageHelper.setSubject("HTML Text mail");
		messageHelper.setText("<h2>Hello from spring boot mail<h2>",true);
		*/
		mailSender.send(message);
		return "Success";
	}
	

}
