package com.hibu.emailNotification;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OutlookTest {

	public void main(String email) {
		// TODO Auto-generated method stub


		// TODO Auto-generated method stub


		// TODO Auto-generated method stub
		System.out.println("preparing to send message");
		//System.out.println("this is the product name : " + obj.getNewProductName());
		System.out.println("email of end user is : " + email);
		String message = "outlook testing";
		String subject = "quote submit results";
		String to = email;
		String from = "UIAutomain@hibu.com";
		//String from = "radhika.madhi@hibu.com";
		//if(obj.getActionItem.equalsIgnoreCase("quotesubmit")) {
		/*if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
		 message = "New Plan Name :" + obj.getNewProductName()
				+ "\nAction : Quote Submit"
				+ "\nBusinessID :" + obj.getBusinessId() 
				+ "\nBusinessAccountName :" + obj.getAccountName()
				+ "\n\nZephyr Card No : " + obj.getTcmNumber();
		 subject = "Quote Submit Results";
		}
		else {
			 message = "exception happened : " + obj.getExceptionMsg()
			            + "\nin adding prodcut : " + obj.getNewProductName();
			 subject = "Quote Submit Results";
		}*/
		//}
		//else if(obj.action)
		
		sendEmail(message,subject,to,from);

	
	
	}
	
	private static void sendEmail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		
		//gmail host variable
		//String host = "smtp.office365.com";
		//String host = "outlook.office365.com";
		
		// fetching system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES : " +properties);
		
		//setting up host
		//properties.put("mail.smtp.host", host);
		//properties.put("mail.smtp.port", "465");
		/*properties.put("mail.smtp.ssl.enable", "true");
		 * //properties.put("mail.smtp.host", "smtp.office365.com");
		 * //properties.put("mail.smtp.host", "smtp-mail.outlook.com");//
		properties.put("mail.smtp.auth", "true");*/
		
		
	      properties.put("mail.smtp.host", "smtp-uskop.yellglobal.net");
		
		//properties.put("mail.smtp.port", "587");
	      
		properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.starttls.enable", "true");
		//properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "false");
		properties.put("mail.debug", "true");
		//properties.put("mail.user", "UITESTRESULTS@qatesting.com");
		properties.put("mail.user", "UIAutomain@hibu.com");
	    properties.put("mail.password", "Hibu@2021l$");
		// step 1 : creating session object
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//return new PasswordAuthentication("uiautomation91@gmail.com","Test1234$");
				return new PasswordAuthentication("UIAutomain@hibu.com","Hibu@2021l$");
				//return new PasswordAuthentication("UITESTRESULTS@qatesting.com","Hibu@2021l$");
			}
		});
		
		session.setDebug(true);
		
		//step 2 : compose the message
		// composing message
		MimeMessage msg = new MimeMessage(session);
		
		try {
		// from email id
		msg.setFrom(new InternetAddress(from));
		
		// adding recipient
		msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
		
		// setting subject
		msg.setSubject(subject);
		
		//setting text message
		msg.setText(message);
		
		// step 3 : send the message
		//sending using transport class
		
		Transport.send(msg);
		
		System.out.println("message has been sent successfully...........");
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
