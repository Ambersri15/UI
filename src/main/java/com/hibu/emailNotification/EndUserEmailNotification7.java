package com.hibu.emailNotification;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;

public class EndUserEmailNotification7 extends PreRequisites{

	public void main(OrderPlacementObj obj,String email) {
		// TODO Auto-generated method stub
		OrderPlacementObj obj1 = new OrderPlacementObj();
		obj1=obj;
		System.out.println("preparing to send message");
		System.out.println("this is the product name : " + obj.getNewProductName());
		System.out.println("email of end user is : " + email);
		String message = "";
		String subject = "";
		String to = email;
		//String from = "uiautomation91@gmail.com";
		String from = "UIAutomain@hibu.com";
String Uiaction = obj.getActionItem();
		
		System.out.println("This is my action to be performed " + Uiaction);
		if(Uiaction.trim().equalsIgnoreCase("QuoteSubmit")) {
			if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
				 message = "<p style ='color:blue'><b>New Plan Name :</b>" + obj.getNewProductName() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>Action :</b> Quote Submit" + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>BusinessID :</b>" + obj.getBusinessId() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>Business Account Name :</b> <a href = '"+obj.getAccountUrl()+"'>"+obj.getAccountName()+"</a>" + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
				 subject = "Quote Submit Results";
			}
			else {
				message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
			            + "\n\n<p style ='color:blue'><b>in adding product :</b> " + obj.getNewProductName() + "\n</p>"
			            + "\n\n<p style ='color:blue'><b>Business Account Name :</b> <a href = '"+obj.getAccountUrl()+"'>"+obj.getAccountName()+"</a>" + "\n</p>"
			            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
			 subject = "Quote Submit Results";
			}
			}
			/////Day 2
			if(Uiaction.trim().equalsIgnoreCase("Non SAMI Fulfillment")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Non SAMI Fulfillment" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Case No :</b>" + obj.getCaseNo() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Non SAMI Fulfillment Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>in Fulfilling this Case:</b>" + obj.getCaseNo() + "\n</p>"
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Non SAMI Fulfillment Results";
				}
				}
			if(Uiaction.trim().equalsIgnoreCase("SAMI Fulfillment")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> SAMI Fulfillment" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business ID :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "SAMI Fulfillment Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>in Fulfilling this Business ID:</b>" + obj.getBusinessId() + "\n</p>"
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "SAMI Fulfillment Results";
				}
				}
			if(Uiaction.trim().equalsIgnoreCase("Domain Provision and Publish")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Domain Provision and Publish" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business ID :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Domain Provision and Publish Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>in doing Domain Provision and Publish for this </b>" + obj.getBusinessId() + "\n</p>"
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Domain Provision and Publish Results";
				}
				}
			if(Uiaction.trim().equalsIgnoreCase("Assistant RCF Provisioning")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Assistant RCF Provisioning" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Case No :</b>" + obj.getCaseNo() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Assistant RCF Provisioning Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>in Provisioning RCF for this Case No: </b>" + obj.getCaseNo() + "\n</p>"
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Assistant RCF Provisioning Results";
				}
				}
			///Day 3
			
			if(Uiaction.trim().equalsIgnoreCase("Cancel and Replace")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Cancel and Replace" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Id No :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Account Name :</b>" + obj.getAccountName() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Cancel and Replace Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>while cancel and replacing the business id: </b>" + obj.getBusinessId() + "\n</p>"						
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Cancel and Replace Results";
				}
				}
			if(Uiaction.trim().equalsIgnoreCase("Amend and Add")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Amend and Add" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Id :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Account Name :</b>" + obj.getAccountName() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Amend and Add Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>while amend and add on this business id: </b>" + obj.getBusinessId() + "\n</p>"						
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Amend and Add Results";
				}
				}
			
			if(Uiaction.trim().equalsIgnoreCase("Customer") || Uiaction.trim().equalsIgnoreCase("Credit")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Cancel All" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Id :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Account Name :</b>" + obj.getAccountName() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Cancel all Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>while cancel all on this business id: </b>" + obj.getBusinessId() + "\n</p>"							
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Cancel all Results";
				}
				}
			if(Uiaction.trim().equalsIgnoreCase("BudgetChangeForSolutions")) {
				System.out.println("I am in this loop for execution " + Uiaction);
				if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
					 message = "<p style ='color:blue'><b>Action :</b> Budget Change" + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Business Id :</b>" + obj.getBusinessId() + "\n</p>"
								+ "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>"+"</p>";
					 subject = "Budget Change Results";
				}
				else {
					message = "<p style ='color:blue'><b>Exception happened : </b>" + obj.getExceptionMsg() + "\n</p>"
							+ "\n\n<p style ='color:blue'><b>while budget change on this business id: </b>" + obj.getBusinessId() + "\n</p>"						
				            + "\n\n<p style ='color:blue'><b>Jira Card No :</b> <a href ='https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber()+"'>"+obj.getTcmNumber()+"</a>" + "</p>";
				 subject = "Budget Change Results";
				}
				}
		
		sendEmail(message,subject,to,from,obj1);

	}

	public static void sendEmail(String message, String subject, String to, String from,OrderPlacementObj obj) {
		// TODO Auto-generated method stub
		
		PreRequisites pr = new PreRequisites();
		//gmail host variable
		String host = "smtp.gmail.com";
		
		// fetching system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES : " +properties);
		// ************************ gmail settings ************************
		//setting up host
		/*properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");*/
		 // ************************** outlook settings ******************
		properties.put("mail.smtp.host", "smtp-uskop.yellglobal.net");
		 properties.put("mail.smtp.port", "25");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "false");
		properties.put("mail.debug", "true");
		properties.put("mail.user", "UIAutomain@hibu.com");
	    properties.put("mail.password", "Hibu@2021l$");
		// step 1 : creating session object
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("UIAutomain@hibu.com","Hibu@2021l$");
				//return new PasswordAuthentication("uiautomation91@gmail.com","Test1234$");
			}
		});
		
		session.setDebug(true);
		
		//step 2 : compose the message
		// composing message
		MimeMessage msg = new MimeMessage(session);
		 
		try {
			if(obj.getExceptionMsg().equalsIgnoreCase("true")) {
		// from email id
		msg.setFrom(new InternetAddress(from));
		
		// adding recipient
		msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
		
		// setting subject
		msg.setSubject(subject);
		
		//setting text message
		//msg.setText(message);
		msg.setText(message, "UTF-8", "html");
		
		
		// step 3 : send the message
		//sending using transport class
		
		Transport.send(msg);
		
		System.out.println("message has been sent successfully...........");
			}
			else
			{
				
				msg.setFrom(new InternetAddress(from));
				
				// adding recipient
				msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
				
				// setting subject
				msg.setSubject(subject);
				
				//screenshot path
				//String path = pr.Resultsfolderpath+"/"+pr.ImgName;
				String path = obj.getfolderPath();
				System.out.println("this is the screenshot path" + path);
				
				//creating multipart object
				MimeMultipart mimeMutipart = new MimeMultipart();
				
				MimeBodyPart text = new MimeBodyPart();
				
				MimeBodyPart ss = new MimeBodyPart();
				
				try {
					
					//setting text message
				     text.setText(message, "UTF-8", "html");
				     
				     //creating file
				     File file = new File(path);
				     
				     //adding ss to message
				     ss.attachFile(file);
				     
				     //adding bodypart to multipart
				     
				     mimeMutipart.addBodyPart(text);
				     
				     mimeMutipart.addBodyPart(ss);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				//setting content to msg
				msg.setContent(mimeMutipart);
				
				// step 3 : send the message
				//sending using transport class
				
				Transport.send(msg);
				
				System.out.println("message has been sent successfully...........");
				
				
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}
