package com.hibu.orderplacement.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.emailNotification.EndUserEmailNotification10;
import com.hibu.emailNotification.EndUserEmailNotification11;
import com.hibu.emailNotification.EndUserEmailNotification12;
import com.hibu.emailNotification.EndUserEmailNotification2;
import com.hibu.emailNotification.EndUserEmailNotification3;
import com.hibu.emailNotification.EndUserEmailNotification4;
import com.hibu.emailNotification.EndUserEmailNotification5;
import com.hibu.emailNotification.EndUserEmailNotification6;
import com.hibu.emailNotification.EndUserEmailNotification7;
import com.hibu.emailNotification.EndUserEmailNotification8;
import com.hibu.emailNotification.EndUserEmailNotification9;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.orderplacement.service.CPQorderService;
import com.hibu.tests.PreRequisites;
import com.hibu.testscript.main.*;
import com.hibu.testscripts.FF.NonSAMI_FF;




@Controller
public class OrderPlacingController extends PreRequisites {
	public static Logger LOGS = LogManager.getLogger(OrderPlacingController.class.getName());
	
	public static String uiPlanName="";
	public static String uiXML="";
	public static int i = 0;
	public int portno=4545;
	    
	
	
	@Autowired
	CPQorderService cpqOrderService;

	String message = "Welcome to Spring MVC!";

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		LOGS.info("in controller");
		LOGS.info("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	// Home Page Mapping
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
	return new ModelAndView("home", "command", new OrderPlacementObj());
	}
	
	// Quote Submission 
	@RequestMapping(value = "/quotesubmission", method = RequestMethod.GET)
	public ModelAndView quotesubmission() {
	return new ModelAndView("quotesubmission", "QuoteSubmit", new OrderPlacementObj());
	}
	
	@RequestMapping(value = "/Response", method = RequestMethod.POST)
    public void QuoteSubmission(@ModelAttribute("SpringWeb")OrderPlacementObj obj, 
 ModelMap model) throws Throwable {
		
		 Main_Quote_Submission Main_Quote_Submission = new Main_Quote_Submission();
//		 Main_Quote_SubmissionCopy Main_Quote_SubmissionCopy = new Main_Quote_SubmissionCopy();
//		 Main_Quote_Submission3 Main_Quote_Submission3 = new Main_Quote_Submission3();
//		 Main_Quote_Submission4 Main_Quote_Submission4 = new Main_Quote_Submission4();
//		 Main_Quote_Submission5 Main_Quote_Submission5 = new Main_Quote_Submission5();
//		 Main_Quote_Submission6 Main_Quote_Submission6 = new Main_Quote_Submission6();
//		 Main_Quote_Submission7 Main_Quote_Submission7 = new Main_Quote_Submission7();
//		 Main_Quote_Submission8 Main_Quote_Submission8 = new Main_Quote_Submission8();
//		 Main_Quote_Submission9 Main_Quote_Submission9 =  new Main_Quote_Submission9();
//		 Main_Quote_Submission10 Main_Quote_Submission10 = new Main_Quote_Submission10();
//		 Main_Quote_Submission11 Main_Quote_Submission11 = new Main_Quote_Submission11();
//		 Main_Quote_Submission12 Main_Quote_Submission12 = new Main_Quote_Submission12();
		 EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
	 EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
		 EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
		 EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
		 EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
		 EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
		 EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
		 EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
		 EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
		 EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
		 EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
		 EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
		 
		    model.addAttribute("newProductName", obj.getNewProductName());
		    model.addAttribute("salesRepType", obj.getSalesRepType());
		    model.addAttribute("emailId", obj.getEmailId());
		    
		    String endUserEmailId = obj.getEmailId();
	    	String UiPlanName = obj.getNewProductName();
	    	
	    	LOGS.info(Thread.currentThread() +"This is the Email ID" + endUserEmailId);
	    	LOGS.info(Thread.currentThread() +"calling Quote Submission method");
	    	LOGS.info(Thread.currentThread() +"calling Quote Submission method");
	    	LOGS.info("Plan Name is: "+UiPlanName);
	    	//String repName = "Janelle";
	    	String repName = obj.getSalesRepType();
	       
	    	//if(i%4==0) {
	    	if(i==0) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		 emailNotification.main(obj, Email);
	    		
	    	}else if (i==1) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Second Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_SubmissionCopy.main(UiPlanName,repName);
	    		emailNotification2.main(obj, Email);
	    		 
	    	}else if (i==2) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Third Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission3.main(UiPlanName,repName);
	    		emailNotification3.main(obj, Email);
	    	}else if (i==3) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Fourth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission4.main(UiPlanName,repName);
	    		emailNotification4.main(obj, Email);
	    	}else if (i==4) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Fifth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = 4545;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission5.main(UiPlanName,repName);
	    		emailNotification5.main(obj, Email);
	    	}else if (i==5) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Sixth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission6.main(UiPlanName,repName);	
	    		emailNotification6.main(obj, Email);
	    	}else if (i==6) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Seventh Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission7.main(UiPlanName,repName);
	    		emailNotification7.main(obj, Email);
	    	}else if (i==7) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Eighth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission8.main(UiPlanName,repName);
	    		emailNotification8.main(obj, Email);
	    	}else if (i==8) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Nighth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission9.main(UiPlanName,repName);
	    		emailNotification9.main(obj, Email);
	    	}else if (i==9) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Tenth Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = 4545;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission10.main(UiPlanName,repName);
	    		emailNotification10.main(obj, Email);
	    	}else if (i==10) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		 i++;
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = portno + 1;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission11.main(UiPlanName,repName);	
	    		emailNotification11.main(obj, Email);
	    	}else if(i==11) {
	    		 LOGS.info(Thread.currentThread() +"                             ");
	    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	    		LOGS.info(Thread.currentThread() +"I am a Twelth Request");
	    		 LOGS.info(Thread.currentThread() +"                            ");
	    		 String Email = endUserEmailId;
	    		 int Port = portno;
	    		 portno = 4545;
	    		 obj = Main_Quote_Submission.main(UiPlanName,repName,Port);
	    		//obj = Main_Quote_Submission12.main(UiPlanName,repName);
	    		emailNotification12.main(obj, Email);
	    		 i=0;
	    	}
	    	
		
	        String businessId = "";
	        businessId = obj.getBusinessId();
		
	        LOGS.info("output Data :   "+  obj.getBusinessId()+";"+obj.getAccountName()+";"+obj);
		    LOGS.info("Exception Message: "+obj.getExceptionMsg());
		    
		    
			model.addAttribute("businessId", obj.getBusinessId());
		    model.addAttribute("accountName", obj.getAccountName());
		    model.addAttribute("accountURL", obj.getAccountUrl());
			model.addAttribute("tcmNumber", obj.getTcmNumber());
		    model.addAttribute("issueId", obj.getIssueID());    
			model.addAttribute("executionId", obj.getExecutionID());
			model.addAttribute("exceptionMsg", obj.getExceptionMsg());
		    
			String executionURL = "";
			  //executionURL = "https://hibu-us.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/general-search-test-executions?project.id=15218&issue.id="+obj.getIssueID()+"&execution.id="+obj.getExecutionID()+"&zql=issue%20%3D%20"+obj.getTcmNumber()+"&view=detail";
			executionURL="https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber();   
			model.addAttribute("executionURLData",executionURL);
			    LOGS.info("I am executing--2nd place");    
			  LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getTcmNumber()+";"+obj.getIssueID()+";"+obj.getExecutionID()+";"+executionURL);
			    
			    LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getAccountUrl());
		   
		
		 /*if(obj.getExceptionMsg().equalsIgnoreCase("true"))
		        return "QuoteSubmitResult";
		   else
		   	return "Exception";*/

	}
	
	// Fulfillment
	@RequestMapping(value = "/fulfillment", method = RequestMethod.GET)
	public ModelAndView fulfillment() {
	return new ModelAndView("fulfillment", "Fulfillment", new OrderPlacementObj());
	}
	
	@RequestMapping(value = "/FulfillmentResponse", method = RequestMethod.POST)
    public void Fulfillment(@ModelAttribute("SpringWeb")OrderPlacementObj obj, 
    ModelMap model) throws Throwable {
		 model.addAttribute("actionItem", obj.getActionItem());
		    
		    String Uiaction = obj.getActionItem();
		    LOGS.info("Calling "+Uiaction+" Method.");
		    String businessId = "";
		   
		   
		    if(Uiaction.trim().equalsIgnoreCase("Non SAMI Fulfillment")) {
		    	LOGS.info("Calling "+Uiaction+" Method.");
		    	
		    	 
		    	model.addAttribute("CaseNo", obj.getCaseNo());
				model.addAttribute("newProductName", obj.getNewProductName());
				 model.addAttribute("emailId", obj.getEmailId());
				 
			String endUserEmailId = obj.getEmailId();
			   String UiCaseNo = obj.getCaseNo();
			   String UiProduct = obj.getNewProductName();
			   
			   LOGS.info("Case Number : "+UiCaseNo);
			   NonSAMIFulfillment NSF = new NonSAMIFulfillment();
//			   NonSAMIFulfillment2 NSF2 = new NonSAMIFulfillment2();
//			   NonSAMIFulfillment3 NSF3 = new NonSAMIFulfillment3();
//			   NonSAMIFulfillment4 NSF4 = new NonSAMIFulfillment4();
//			   NonSAMIFulfillment5 NSF5 = new NonSAMIFulfillment5();
//			   NonSAMIFulfillment6 NSF6 = new NonSAMIFulfillment6();
//			   NonSAMIFulfillment7 NSF7 = new NonSAMIFulfillment7();
//			   NonSAMIFulfillment8 NSF8 = new NonSAMIFulfillment8();
//			   NonSAMIFulfillment9 NSF9 = new NonSAMIFulfillment9();
//			   NonSAMIFulfillment10 NSF10 = new NonSAMIFulfillment10();
//			   NonSAMIFulfillment11 NSF11 = new NonSAMIFulfillment11();
//			   NonSAMIFulfillment12 NSF12 = new NonSAMIFulfillment12();
			   EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
			   EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
			   EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
			   EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
			   EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
			   EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
			   EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
			   EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
			   EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
			   EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
			   EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
			   EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
			  
				
		
							
	 		    if(i==0) {
	 		    	LOGS.info(Thread.currentThread() +"                             ");
			   		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			   		LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
			   		LOGS.info(Thread.currentThread() +"                             ");
			   		i++;
			   		String Email = endUserEmailId;
			   		int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 emailNotification.main(obj, Email);
		    		
			   		 }
	 		    	
	 		    else if (i==1) {
	 		    	LOGS.info(Thread.currentThread() +"                             ");
	 		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	 		    	LOGS.info(Thread.currentThread() +"I am a Second Request");
	 		   		LOGS.info(Thread.currentThread() +"                             ");
	 		   		i++;
	 		   	String Email = endUserEmailId;
	 		   int Port = portno;
	    		 portno = portno + 1;
	    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
	   		 //obj = NSF2.main(UiCaseNo, UiProduct);
	   		 emailNotification2.main(obj, Email);
	 		    }
	 		    	
	 		    else if (i==2) {
	 		    	LOGS.info(Thread.currentThread() +"                             ");
	 		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	 		    	LOGS.info(Thread.currentThread() +"I am a Third Request");
	 		    	LOGS.info(Thread.currentThread() +"                             ");
	 		    	i++;
	 		    	String Email = endUserEmailId;
	 		    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF3.main(UiCaseNo, UiProduct);
		    		 emailNotification3.main(obj, Email); 
		    		 }
	 		   else if (i==3) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Fourth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF4.main(UiCaseNo, UiProduct);
		    		 emailNotification4.main(obj, Email); 
		    		 }
	 		   else if (i==4) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a fifth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF5.main(UiCaseNo, UiProduct);
		    		 emailNotification5.main(obj, Email); 
		    		 }
	 		  	else if (i==5) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Sixth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF6.main(UiCaseNo, UiProduct);
		    		 emailNotification6.main(obj, Email); 
		    		 }
	 		  	else if (i==6) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Seventh Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF7.main(UiCaseNo, UiProduct);
		    		 emailNotification7.main(obj, Email); 
		    		 }
	 		  	else if (i==7) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Eighth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF8.main(UiCaseNo, UiProduct);
		    		 emailNotification8.main(obj, Email); 
		    		 }
	 		  	else if (i==8) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Ninth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF9.main(UiCaseNo, UiProduct);
		    		 emailNotification9.main(obj, Email); 
		    		 }
	 		  	else if (i==9) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Tenth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF10.main(UiCaseNo, UiProduct);
		    		 emailNotification10.main(obj, Email); 
		    		 }
	 		  	else if (i==10) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF11.main(UiCaseNo, UiProduct);
		    		 emailNotification11.main(obj, Email); 
		    		 }
	 		    	
	 		    else if(i==11) {
	 		    	LOGS.info(Thread.currentThread() +"                             ");
	 		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	 		    	LOGS.info(Thread.currentThread() +"I am a Twelth Request");
	 		    	LOGS.info(Thread.currentThread() +"                            ");
	 		    	String Email = endUserEmailId;
	 		    	int Port = portno;
		    		 portno = 4545;
		    		 obj = NSF.main(UiCaseNo, UiProduct, Port);
		    		 //obj = NSF12.main(UiCaseNo, UiProduct);
		    		 emailNotification12.main(obj, Email);
	 		    	i=0; }		    		  
		
		    }
		    
		    if(Uiaction.trim().equalsIgnoreCase("SAMI Fulfillment")) {
		    	LOGS.info("Calling "+Uiaction+" Method.");
		    	
		    	
		    	model.addAttribute("businessId", obj.getBusinessId()); 
	            model.addAttribute("emailId", obj.getEmailId());
				 
				 String endUserEmailId = obj.getEmailId();
		    	
			     businessId = obj.getBusinessId();
			   
			    
			     LOGS.info("BusinessID from JSP: "+businessId);
				    NonSAMI_FF NonSAMI_FF = new NonSAMI_FF();
//			    	NonSAMI_FFCopy NonSAMI_FFCopy = new NonSAMI_FFCopy();
//			    	NonSAMI_FF3 NonSAMI_FF3 = new NonSAMI_FF3();
//			    	NonSAMI_FF4 NonSAMI_FF4 = new NonSAMI_FF4();
//			    	NonSAMI_FF5 NonSAMI_FF5 = new NonSAMI_FF5();
//			    	NonSAMI_FF6 NonSAMI_FF6 = new NonSAMI_FF6();
//			    	NonSAMI_FF7 NonSAMI_FF7 = new NonSAMI_FF7();
//			    	NonSAMI_FF8 NonSAMI_FF8 = new NonSAMI_FF8();
//			    	NonSAMI_FF9 NonSAMI_FF9 = new NonSAMI_FF9();
//			    	NonSAMI_FF10 NonSAMI_FF10 = new NonSAMI_FF10();
//			    	NonSAMI_FF11 NonSAMI_FF11 = new NonSAMI_FF11();
//			    	NonSAMI_FF12 NonSAMI_FF12 = new NonSAMI_FF12();
			    	EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
			    	EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
					EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
					EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
					EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
					EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
					EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
					EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
					EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
					EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
					EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
					EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();  
				   
				   if(i==0) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 emailNotification.main(obj, Email);
			    		
			    	}else if (i==1) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Second Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FFCopy.main(businessId);
			    		 emailNotification2.main(obj, Email);
			    		
			    		 
			    	}else if (i==2) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Third Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF3.main(businessId);
			    		 emailNotification3.main(obj, Email);
			    		
			    	}else if (i==3) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a fourth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		// obj = NonSAMI_FF4.main(businessId);
			    		 emailNotification4.main(obj, Email);
			    		
			    	}else if (i==4) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Fifth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = 4545;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF5.main(businessId);
			    		 emailNotification5.main(obj, Email);
			    		
			    	}else if (i==5) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Sixth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF6.main(businessId);
			    		 emailNotification6.main(obj, Email);
			    		
			    	}else if (i==6) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Seventh Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF7.main(businessId);	
			    		 emailNotification7.main(obj, Email);
			    		
			    	}else if (i==7) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Eighth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF8.main(businessId);		
			    		 emailNotification8.main(obj, Email);
			    		
			    	}else if (i==8) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Ninth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF9.main(businessId);		
			    		 emailNotification9.main(obj, Email);
			    			
			    	}else if (i==9) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Tenth Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = 4545;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		// obj = NonSAMI_FF10.main(businessId);	
			    		 emailNotification10.main(obj, Email);
			    			
			    	}else if (i==10) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		 i++;
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = portno + 1;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		// obj = NonSAMI_FF11.main(businessId);	
			    		 emailNotification11.main(obj, Email);
			    				
			    	}else if(i==11) {
			    		 LOGS.info(Thread.currentThread() +"                             ");
			    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    		LOGS.info(Thread.currentThread() +"I am a Twelth Request");
			    		 LOGS.info(Thread.currentThread() +"                            ");
			    		 String Email = endUserEmailId;
			    		 int Port = portno;
			    		 portno = 4545;
			    		 obj = NonSAMI_FF.main(businessId, Port);
			    		 //obj = NonSAMI_FF12.main(businessId);	
			    		 emailNotification12.main(obj, Email);
			    		
			    		 i=0;
			    	}
		    	 
		    }
		    
		    if(Uiaction.trim().equalsIgnoreCase("Domain Provision and Publish")) {
		    	LOGS.info("Calling "+Uiaction+" Domain Provision and Publish");
		    	
		    	DomainProvisionAndPublishing DPP = new DomainProvisionAndPublishing();
//				DomainProvisionAndPublishing2 DPP2 = new DomainProvisionAndPublishing2();
//				DomainProvisionAndPublishing3 DPP3 = new DomainProvisionAndPublishing3();
//				DomainProvisionAndPublishing4 DPP4 = new DomainProvisionAndPublishing4();
//				DomainProvisionAndPublishing5 DPP5 = new DomainProvisionAndPublishing5();
//				DomainProvisionAndPublishing6 DPP6 = new DomainProvisionAndPublishing6();
//				DomainProvisionAndPublishing7 DPP7 = new DomainProvisionAndPublishing7();
//				DomainProvisionAndPublishing8 DPP8 = new DomainProvisionAndPublishing8();
//				DomainProvisionAndPublishing9 DPP9 = new DomainProvisionAndPublishing9();
//				DomainProvisionAndPublishing10 DPP10 = new DomainProvisionAndPublishing10();
//				DomainProvisionAndPublishing11 DPP11 = new DomainProvisionAndPublishing11();
//				DomainProvisionAndPublishing12 DPP12 = new DomainProvisionAndPublishing12();
				EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
				EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
				EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
				EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
				EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
				EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
				EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
				EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
				EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
				EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
				EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
				EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
				
					model.addAttribute("businessId", obj.getBusinessId());	
					model.addAttribute("emailId", obj.getEmailId());
					 
					String endUserEmailId = obj.getEmailId();
				 	businessId = obj.getBusinessId();
		       
							
	  		    if(i==0) {
	  		    	LOGS.info(Thread.currentThread() +"                             ");
			   		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			   		LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
			   		LOGS.info(Thread.currentThread() +"                             ");
			   		i++;
			   		
			   		String Email = endUserEmailId;
			   		int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
		    		emailNotification.main(obj, Email);}
	  		    	
	  		    else if (i==1) {
	  		    	LOGS.info(Thread.currentThread() +"                             ");
	  		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	  		    	LOGS.info(Thread.currentThread() +"I am a Second Request");
	  		   		LOGS.info(Thread.currentThread() +"                             ");
	  		   		i++;
	  		   	String Email = endUserEmailId;
	  		  int Port = portno;
	    		 portno = portno + 1;
	    		 obj =  DPP.main(businessId, Port);
		   		//obj =  DPP2.main(businessId);
	    		emailNotification2.main(obj, Email);
	    		 }
	  		    	
	  		    else if (i==2) {
	  		    	LOGS.info(Thread.currentThread() +"                             ");
	  		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	  		    	LOGS.info(Thread.currentThread() +"I am a Third Request");
	  		    	LOGS.info(Thread.currentThread() +"                             ");
	  		    	i++;
	  		    	String Email = endUserEmailId;
	  		    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP3.main(businessId);
		    		emailNotification3.main(obj, Email);
		    		 }
	  		    else if (i==3) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Fourth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP4.main(businessId);
		    		emailNotification4.main(obj, Email);
			    	}
	  		    else if (i==4) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a fifth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP5.main(businessId);
		    		emailNotification5.main(obj, Email);
		    		 }
	  		    else if (i==5) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Sixth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP6.main(businessId);
		    		emailNotification6.main(obj, Email);
		    		 }
	  		    else if (i==6) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Seventh Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP7.main(businessId);
		    		emailNotification7.main(obj, Email);
		    		 } 	
	  		  else if (i==7) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Eighth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  DPP.main(businessId, Port);
			   		//obj =  DPP8.main(businessId);
		    		emailNotification8.main(obj, Email);
		    		 } 
	  		  else if (i==8) {
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    	LOGS.info(Thread.currentThread() +"I am a Ninth Request");
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	i++;
		    	String Email = endUserEmailId;
		    	int Port = portno;
	    		 portno = portno + 1;
	    		 obj =  DPP.main(businessId, Port);
		   		//obj =  DPP9.main(businessId);
	    		emailNotification9.main(obj, Email);
	    		 } 
	  		  else if (i==9) {
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    	LOGS.info(Thread.currentThread() +"I am a Tenth Request");
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	i++;
		    	String Email = endUserEmailId;
		    	int Port = portno;
	    		 portno = 4545;
	    		 obj =  DPP.main(businessId, Port);
		   		//obj =  DPP10.main(businessId);
	    		emailNotification10.main(obj, Email);
	    		 } 
	  		  else if (i==10) {
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    	LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
		    	LOGS.info(Thread.currentThread() +"                             ");
		    	i++;
		    	String Email = endUserEmailId;
		    	int Port = portno;
	    		 portno = portno + 1;
	    		 obj =  DPP.main(businessId, Port);
		    	//obj =  DPP11.main(businessId);
		   		emailNotification11.main(obj, Email);
	    		 } 
	  		    else if(i==11) {
	  		    	LOGS.info(Thread.currentThread() +"                             ");
	  		    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
	  		    	LOGS.info(Thread.currentThread() +"I am a Twelth Request");
	  		    	LOGS.info(Thread.currentThread() +"                            ");
	  		    	String Email = endUserEmailId;
	  		    	int Port = portno;
		    		 portno = 4545;
		    		 obj =  DPP.main(businessId, Port);
	  		    	//obj =  DPP12.main(businessId);
	  		   		emailNotification12.main(obj, Email);
	  		    	i=0; }		    		
		       
		  }
		    
		    if(Uiaction.trim().equalsIgnoreCase("Assistant RCF Provisioning")) {
		    	LOGS.info("Calling "+Uiaction+" Assistant RCF Provisioning");
		    	
		    	
				model.addAttribute("CaseNo", obj.getCaseNo());
				model.addAttribute("newProductName", obj.getNewProductName());
	            model.addAttribute("emailId", obj.getEmailId());
				 
				 String endUserEmailId = obj.getEmailId();
				
			   String UiCaseNo = obj.getCaseNo();
			   String UiProduct = obj.getNewProductName();
			   LOGS.info("provision type : " + UiProduct);
			   LOGS.info("Case Number : "+UiCaseNo);
			   
			   QuestionnaireAssistantRCF que = new QuestionnaireAssistantRCF();
//			   QuestionnaireAssistantRCF2 que2 = new QuestionnaireAssistantRCF2();
//			   QuestionnaireAssistantRCF3 que3 = new QuestionnaireAssistantRCF3();
//			   QuestionnaireAssistantRCF4 que4 = new QuestionnaireAssistantRCF4();
//			   QuestionnaireAssistantRCF5 que5 = new QuestionnaireAssistantRCF5();
//			   QuestionnaireAssistantRCF6 que6 = new QuestionnaireAssistantRCF6();
//			   QuestionnaireAssistantRCF7 que7 = new QuestionnaireAssistantRCF7();
//			   QuestionnaireAssistantRCF8 que8 = new QuestionnaireAssistantRCF8();
//			   QuestionnaireAssistantRCF9 que9 = new QuestionnaireAssistantRCF9();
//			   QuestionnaireAssistantRCF10 que10 = new QuestionnaireAssistantRCF10();
//			   QuestionnaireAssistantRCF11 que11 = new QuestionnaireAssistantRCF11();
//			   QuestionnaireAssistantRCF12 que12 = new QuestionnaireAssistantRCF12();
			   
			   AssistantRCF ast = new AssistantRCF();
//			   AssistantRCF2 ast2 = new AssistantRCF2();
//			   AssistantRCF3 ast3 = new AssistantRCF3();
//			   AssistantRCF4 ast4 = new AssistantRCF4();
//			   AssistantRCF5 ast5 = new AssistantRCF5();
//			   AssistantRCF6 ast6 = new AssistantRCF6();
//			   AssistantRCF7 ast7 = new AssistantRCF7();
//			   AssistantRCF8 ast8 = new AssistantRCF8();
//			   AssistantRCF9 ast9 = new AssistantRCF9();
//			   AssistantRCF10 ast10 = new AssistantRCF10();
//			   AssistantRCF11 ast11 = new AssistantRCF11();
//			   AssistantRCF12 ast12 = new AssistantRCF12();
			   EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
			   EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
			   EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
			   EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
			   EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
			   EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
			   EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
			   EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
			   EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
			   EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
			   EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
			   EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();		   
			   
			   if(i==0) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			   		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			   		LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
			   		LOGS.info(Thread.currentThread() +"                             ");
			   		i++;
			   	 String Email = endUserEmailId;
			   	int Port = portno;
	    		 portno = portno + 1;
			   
	    		
	    		//emailNotification.main(obj, Email);
			   		
			   		if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   emailNotification.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   
						   obj = que.main(UiCaseNo,Port);
						   emailNotification.main(obj, Email);
					   } 
			   		}
			   
			    else if (i==1) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Second Request");
			   		LOGS.info(Thread.currentThread() +"                             ");
			   		i++;
			   		String Email = endUserEmailId;
			   		int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification2.main(obj, Email);
			   		if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast2.main(UiCaseNo);
						   emailNotification2.main(obj,Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que2.main(UiCaseNo);
						   emailNotification2.main(obj, Email);
					   } }
			    	
			    else if (i==2) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Third Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification3.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast3.main(UiCaseNo);
						   emailNotification3.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que3.main(UiCaseNo);
						   emailNotification3.main(obj, Email);
					   } }
			   else if (i==3) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Fourth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification4.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast4.main(UiCaseNo);
						   emailNotification4.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						  // obj = que4.main(UiCaseNo);
						   emailNotification4.main(obj, Email);
					   } }
			   else if (i==4) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a fifth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		//emailNotification5.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast5.main(UiCaseNo);
						   emailNotification5.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que5.main(UiCaseNo);
						   emailNotification5.main(obj, Email);
					   } }
			  	else if (i==5) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Sixth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification6.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast6.main(UiCaseNo);
						   emailNotification6.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que6.main(UiCaseNo);
						   emailNotification6.main(obj, Email);
					   } }
			  	else if (i==6) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Seventh Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification7.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast7.main(UiCaseNo);
						   emailNotification7.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que7.main(UiCaseNo);
						   emailNotification7.main(obj, Email);
					   } }
			  	else if (i==7) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Eighth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification8.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast8.main(UiCaseNo);
						   emailNotification8.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que8.main(UiCaseNo);
						   emailNotification8.main(obj, Email);
					   } }
			  	else if (i==8) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Ninth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification9.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast9.main(UiCaseNo);
						   emailNotification9.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que9.main(UiCaseNo);
						   emailNotification9.main(obj, Email);
					   } }
			  	else if (i==9) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Tenth Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		//emailNotification10.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast10.main(UiCaseNo);
						   emailNotification10.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que10.main(UiCaseNo);
						   emailNotification10.main(obj, Email);
					   } }
			  	else if (i==10) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	i++;
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = portno + 1;
		    		//emailNotification11.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast11.main(UiCaseNo);
						   emailNotification11.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que11.main(UiCaseNo);
						   emailNotification11.main(obj, Email);
					   } }
			    	
			    else if(i==11) {
			    	LOGS.info(Thread.currentThread() +"                             ");
			    	LOGS.info(Thread.currentThread() +"I am a i value: "+i);
			    	LOGS.info(Thread.currentThread() +"I am a Twelth Request");
			    	LOGS.info(Thread.currentThread() +"                            ");
			    	String Email = endUserEmailId;
			    	int Port = portno;
		    		 portno = 4545;
		    		//emailNotification12.main(obj, Email);
			    	if(UiProduct.trim().contains("Assistant"))
					   {
						   LOGS.info("entered in if block");
						   
						   obj = ast.main(UiCaseNo,Port);
						   //obj = ast12.main(UiCaseNo);
						   emailNotification12.main(obj, Email);
					   }
					   else
					   {
						   LOGS.info("entered in else block");
						   
						   obj = que.main(UiCaseNo,Port);
						   //obj = que12.main(UiCaseNo);
						   emailNotification12.main(obj, Email);
					   }
			    	i=0; }
			   
			   /*if(UiProduct.trim().contains("Assistant"))
			   {
				   LOGS.info("entered in if block");
				   AssistantRCF rcf = new AssistantRCF();
				   
				   obj = rcf.main(UiCaseNo);
			   }
			   else
			   {
				   LOGS.info("entered in else block");
				   
				   QuestionnaireAssistantRCF rcf = new QuestionnaireAssistantRCF();
				   obj = rcf.main(UiCaseNo);
			   }*/
			   /*DscAndQuestionnaire DscQuest = new DscAndQuestionnaire();
			    
			   obj =   DscQuest.main(UiCaseNo, UiProduct);*/
		   
		    }
		    
	        businessId = obj.getBusinessId();
		
	        LOGS.info("output Data :   "+  obj.getBusinessId()+";"+obj.getTcmNumber()+";"+obj);
		    LOGS.info("Exception Message: "+obj.getExceptionMsg());
		    
		    
			model.addAttribute("businessId", obj.getBusinessId());	   
			model.addAttribute("tcmNumber", obj.getTcmNumber());
		    model.addAttribute("issueId", obj.getIssueID());    
			model.addAttribute("executionId", obj.getExecutionID());
			model.addAttribute("exceptionMsg", obj.getExceptionMsg());
		    
			String executionURL = "";
			  //executionURL = "https://hibu-us.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/general-search-test-executions?project.id=15218&issue.id="+obj.getIssueID()+"&execution.id="+obj.getExecutionID()+"&zql=issue%20%3D%20"+obj.getTcmNumber()+"&view=detail";
			executionURL="https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber();   
			model.addAttribute("executionURLData",executionURL);
			    LOGS.info("I am executing--2nd place");    		  
			    
			    LOGS.info(obj.getBusinessId()+";"+obj.getTcmNumber());
			    //obj.setExceptionMsg("true");
		
		 /*if(obj.getExceptionMsg().equalsIgnoreCase("true"))
		        return "fulfillmentResultPage";
		   else
		   	return "Exception";*/
		      
		}
	
	
	
	
	
	// Amends
	@RequestMapping(value = "/amends", method = RequestMethod.GET)
	public ModelAndView amends() {
	return new ModelAndView("amends", "Amends", new OrderPlacementObj());
	}
	
	@RequestMapping(value = "/AmendsResponse", method = RequestMethod.POST)
    public void Amends(@ModelAttribute("SpringWeb")OrderPlacementObj obj, 
    ModelMap model) throws Throwable {
		 model.addAttribute("actionItem", obj.getActionItem());
		    
		    String Uiaction = obj.getActionItem();
		    LOGS.info("Calling "+Uiaction+" Method.");
		   
		   
		   
		    if(Uiaction.trim().equalsIgnoreCase("Cancel and Replace")) {
		    	LOGS.info("Calling "+Uiaction+" Method.");
		    	
		    	 Main_CancelandReplace  Main_CancelandReplace =  new Main_CancelandReplace();
//		    	 Main_CancelandReplaceCopy Main_CancelandReplaceCopy = new Main_CancelandReplaceCopy();
//		    	 Main_CancelandReplace3 Main_CancelandReplace3 = new Main_CancelandReplace3();
//		    	 Main_CancelandReplace4 Main_CancelandReplace4 = new Main_CancelandReplace4();
//		    	 Main_CancelandReplace5 Main_CancelandReplace5 = new Main_CancelandReplace5();
//		    	 Main_CancelandReplace6 Main_CancelandReplace6 = new Main_CancelandReplace6();
//		    	 Main_CancelandReplace7 Main_CancelandReplace7 = new Main_CancelandReplace7();
//		    	 Main_CancelandReplace8 Main_CancelandReplace8 = new Main_CancelandReplace8();
//		    	 Main_CancelandReplace9 Main_CancelandReplace9 = new Main_CancelandReplace9();
//		    	 Main_CancelandReplace10 Main_CancelandReplace10 = new Main_CancelandReplace10();
//		    	 Main_CancelandReplace11 Main_CancelandReplace11 = new Main_CancelandReplace11();
//		    	 Main_CancelandReplace12 Main_CancelandReplace12 = new Main_CancelandReplace12();
		    	 EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
		    	 EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
				 EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
				 EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
				 EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
				 EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
				 EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
				 EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
				 EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
				 EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
				 EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
				 EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();	 
		    	model.addAttribute("existingProduct", obj.getExistingProduct());
				model.addAttribute("businessId", obj.getBusinessId());
			    model.addAttribute("newProductName", obj.getNewProductName());
			    model.addAttribute("accountURL", obj.getAccountUrl());
			    model.addAttribute("emailId", obj.getEmailId());
			    
			    String endUserEmailId = obj.getEmailId();
		    	String UiPlanName = obj.getNewProductName();
			    String UiexistingPlan = obj.getExistingProduct();
			    String UibusinessId = obj.getBusinessId();
			    
		      	       
		       if(i==0) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 emailNotification.main(obj, Email);
		    	}else if (i==1) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		LOGS.info(Thread.currentThread() +"I am a Second Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplaceCopy.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification2.main(obj, Email);
		    		 
		    		 
		    	}else if (i==2) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		LOGS.info(Thread.currentThread() +"I am a Third Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace3.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification3.main(obj, Email);
		    		 
		    	}else if (i==3) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		LOGS.info(Thread.currentThread() +"I am a Fourth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace4.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification4.main(obj, Email);
		    		 
		    	}else if (i==4) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a fifth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace5.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification5.main(obj, Email);
		    		 
		    	}else if (i==5) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Sixth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace6.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification6.main(obj, Email);
		    		 
		    	}else if (i==6) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Seventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace7.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification7.main(obj, Email);
		    		 
		    	}else if (i==7) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eighth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace8.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification8.main(obj, Email);
		    		 
		    	}else if (i==8) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Ninth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace9.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification9.main(obj, Email);
		    		 
		    	}else if (i==9) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Tenth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace10.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification10.main(obj, Email);
		    		 
		    	}else if (i==10) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace11.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification11.main(obj, Email);
		    		  
		    	}else if(i==11) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Twelth Request");
		    		 LOGS.info(Thread.currentThread() +"                            ");
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj = Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj = Main_CancelandReplace12.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification12.main(obj, Email);
		    
		    		 i=0;
		    	}
		       
		     }
		    
		    if(Uiaction.trim().equalsIgnoreCase("Amend and Add")) {
		    	LOGS.info("Calling "+Uiaction+" Method.");
		    	 Main_AmendandADD Main_AmendandADD = new Main_AmendandADD();
//		    	 Main_AmendandADD2 Main_AmendandADD2 = new Main_AmendandADD2();
//		    	 Main_AmendandADD3 Main_AmendandADD3 = new Main_AmendandADD3();
//		    	 Main_AmendandADD4 Main_AmendandADD4 = new Main_AmendandADD4();
//		    	 Main_AmendandADD5 Main_AmendandADD5 = new Main_AmendandADD5();
//		    	 Main_AmendandADD6 Main_AmendandADD6 = new Main_AmendandADD6();
//		    	 Main_AmendandADD7 Main_AmendandADD7 = new Main_AmendandADD7();
//		    	 Main_AmendandADD8 Main_AmendandADD8 = new Main_AmendandADD8();
//		    	 Main_AmendandADD9 Main_AmendandADD9 = new Main_AmendandADD9();
//		    	 Main_AmendandADD10 Main_AmendandADD10 = new Main_AmendandADD10();
//		    	 Main_AmendandADD11 Main_AmendandADD11 = new Main_AmendandADD11();
//		    	 Main_AmendandADD12 Main_AmendandADD12 = new Main_AmendandADD12();
		    	 EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
		    	 EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();  				                          EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
				 EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
				 EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
				 EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
				 EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
				 EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
				 EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
				 EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
				 EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
				 EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
		    	 
		    	model.addAttribute("existingProduct", obj.getExistingProduct());
				model.addAttribute("businessId", obj.getBusinessId());
			    model.addAttribute("newProductName", obj.getNewProductName());
			    model.addAttribute("accountURL", obj.getAccountUrl());
			    model.addAttribute("emailId", obj.getEmailId());
			    
			    String endUserEmailId = obj.getEmailId();
		    	String UiPlanName = obj.getNewProductName();
			    String UiexistingPlan = obj.getExistingProduct();
			    String UibusinessId = obj.getBusinessId();
			    
			    if(i==0) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 emailNotification.main(obj, Email);
		    		
		    	}else if (i==1) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Second Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD2.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification2.main(obj, Email);
		    		
		    	}else if (i==2) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Third Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD3.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification3.main(obj, Email);
		    		
		    	}else if (i==3) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fourth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD4.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification4.main(obj, Email);
		    		
		    		
		    	}else if (i==4) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fifth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD5.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification5.main(obj, Email);
		    		
		    	}else if (i==5) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Sixth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD6.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification6.main(obj, Email);
		    	}else if (i==6) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Seventh Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD7.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification7.main(obj, Email);
		    	}else if (i==7) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eight Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD8.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification8.main(obj, Email);
		    	}else if (i==8) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Ninth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD9.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification9.main(obj, Email);
		    	}else if (i==9) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Tenth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD10.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification10.main(obj, Email);
		    	}else if (i==10) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a eleventh Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD11.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification11.main(obj, Email);
		    	}else if (i==11) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Twelth Request: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");	    		 
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =   Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, Port);
		    		 //obj =   Main_AmendandADD12.main(UibusinessId, UiexistingPlan, UiPlanName);
		    		 emailNotification12.main(obj, Email);
		    		 i=0;
		    		 }
		    
		    }
		    
		    if(Uiaction.trim().equalsIgnoreCase("Customer") || Uiaction.trim().equalsIgnoreCase("Credit")) {
		    	LOGS.info("Calling "+Uiaction+" Cancel All Method.");
		    	
		    	Main_CancelAll_CreditAndCustomer Main_CancelAll_CreditAndCustomer = new Main_CancelAll_CreditAndCustomer();
//		    	Main_CancelAll_CreditAndCustomerCopy Main_CancelAll_CreditAndCustomerCopy = new Main_CancelAll_CreditAndCustomerCopy();
//		    	Main_CancelAll_CreditAndCustomer3 Main_CancelAll_CreditAndCustomer3 = new Main_CancelAll_CreditAndCustomer3();
//		    	Main_CancelAll_CreditAndCustomer4 Main_CancelAll_CreditAndCustomer4 = new Main_CancelAll_CreditAndCustomer4();
//		    	Main_CancelAll_CreditAndCustomer5 Main_CancelAll_CreditAndCustomer5 = new Main_CancelAll_CreditAndCustomer5();
//		    	Main_CancelAll_CreditAndCustomer6 Main_CancelAll_CreditAndCustomer6 = new Main_CancelAll_CreditAndCustomer6();
//		    	Main_CancelAll_CreditAndCustomer7 Main_CancelAll_CreditAndCustomer7 = new Main_CancelAll_CreditAndCustomer7();
//		    	Main_CancelAll_CreditAndCustomer8 Main_CancelAll_CreditAndCustomer8 = new Main_CancelAll_CreditAndCustomer8();
//		    	Main_CancelAll_CreditAndCustomer9 Main_CancelAll_CreditAndCustomer9 = new Main_CancelAll_CreditAndCustomer9();
//		    	Main_CancelAll_CreditAndCustomer10 Main_CancelAll_CreditAndCustomer10 = new Main_CancelAll_CreditAndCustomer10();
//		    	Main_CancelAll_CreditAndCustomer11 Main_CancelAll_CreditAndCustomer11 = new Main_CancelAll_CreditAndCustomer11();
//		    	Main_CancelAll_CreditAndCustomer12 Main_CancelAll_CreditAndCustomer12 = new Main_CancelAll_CreditAndCustomer12();
		    	 EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
		    	 EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
				 EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
				 EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
				 EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
				 EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
				 EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
				 EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();
				 EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
				 EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
				 EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
				 EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
		    	
				model.addAttribute("businessId", obj.getBusinessId());
				model.addAttribute("emailId", obj.getEmailId());
				 
				String endUserEmailId = obj.getEmailId();
		    	String UiCancelType = Uiaction;
			    String UibusinessId = obj.getBusinessId();
			    String ProductName  = "NA";
		       
			    if(i==0) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 emailNotification.main(obj, Email);
		    		
		    		
		    	}else if (i==1) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Second Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomerCopy.main(UibusinessId, UiCancelType);
		    		 emailNotification2.main(obj, Email);
		    		 
		    	}else if (i==2) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Third Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer3.main(UibusinessId, UiCancelType);
		    		 emailNotification3.main(obj, Email);
		    	}else if (i==3) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fourth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer4.main(UibusinessId, UiCancelType);
		    		 emailNotification4.main(obj, Email);
		    		 
		    	}else if (i==4) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fifth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer5.main(UibusinessId, UiCancelType);
		    		 emailNotification5.main(obj, Email);
		    	}else if (i==5) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Sixth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer6.main(UibusinessId, UiCancelType);
		    		 emailNotification6.main(obj, Email);
		    		 
		    	}else if (i==6) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a seventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer7.main(UibusinessId, UiCancelType);
		    		 emailNotification7.main(obj, Email); 
		    	}else if (i==7) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eighth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer8.main(UibusinessId, UiCancelType);
		    		 emailNotification8.main(obj, Email);
		    	}else if (i==8) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Ninth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer9.main(UibusinessId, UiCancelType);
		    		 emailNotification9.main(obj, Email);
		    	}else if (i==9) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Tenth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer10.main(UibusinessId, UiCancelType);
		    		 emailNotification10.main(obj, Email);	
		    	}else if (i==10) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer11.main(UibusinessId, UiCancelType);
		    		 emailNotification11.main(obj, Email);		 
		    	}else if(i==11) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Twelth Request");
		    		 LOGS.info(Thread.currentThread() +"                            ");	    		
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 obj =  Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, Port);
		    		 //obj =  Main_CancelAll_CreditAndCustomer12.main(UibusinessId, UiCancelType);
		    		 emailNotification12.main(obj, Email);
		    		 i=0;
		    	}
		        
		        obj.setNewProductName(ProductName);
		        model.addAttribute("newProductName", obj.getNewProductName());
		        model.addAttribute("accountURL", obj.getAccountUrl());
		    }
		    
		    ///budget change for solutions
		    
		    if(Uiaction.trim().equalsIgnoreCase("Budget Change For Solutions")) {
		    	LOGS.info("Calling "+Uiaction+" Budget Change For Solutions in the BCS Method.");
		    	
		    	   BudgetChangeForSolutions BCS = new BudgetChangeForSolutions();
//		    	   BudgetChangeForSolutionsCopy BCS2 = new BudgetChangeForSolutionsCopy();
//		    	   BudgetChangeForSolutions3 BCS3 = new BudgetChangeForSolutions3();
//		    	   BudgetChangeForSolutions4 BCS4 = new BudgetChangeForSolutions4();
//		    	   BudgetChangeForSolutions5 BCS5 = new BudgetChangeForSolutions5();
//		    	   BudgetChangeForSolutions6 BCS6 = new BudgetChangeForSolutions6();
//		    	   BudgetChangeForSolutions7 BCS7 = new BudgetChangeForSolutions7();
//		    	   BudgetChangeForSolutions8 BCS8 = new BudgetChangeForSolutions8();
//		    	   BudgetChangeForSolutions9 BCS9 = new BudgetChangeForSolutions9();
//		    	   BudgetChangeForSolutions10 BCS10 = new BudgetChangeForSolutions10();
//		    	   BudgetChangeForSolutions11 BCS11 = new BudgetChangeForSolutions11();
//		    	   BudgetChangeForSolutions12 BCS12 = new BudgetChangeForSolutions12();
		    	   
		    	   EndUserEmailNotification emailNotification =  new EndUserEmailNotification();
				   EndUserEmailNotification2 emailNotification2 =  new EndUserEmailNotification2();
				   EndUserEmailNotification3 emailNotification3 =  new EndUserEmailNotification3();
				   EndUserEmailNotification4 emailNotification4 =  new EndUserEmailNotification4();
				   EndUserEmailNotification5 emailNotification5 =  new EndUserEmailNotification5();
				   EndUserEmailNotification6 emailNotification6 =  new EndUserEmailNotification6();
				   EndUserEmailNotification7 emailNotification7 =  new EndUserEmailNotification7();
				   EndUserEmailNotification8 emailNotification8 =  new EndUserEmailNotification8();				                                      EndUserEmailNotification9 emailNotification9 =  new EndUserEmailNotification9();
				   EndUserEmailNotification10 emailNotification10 =  new EndUserEmailNotification10();
				   EndUserEmailNotification11 emailNotification11 =  new EndUserEmailNotification11();
				   EndUserEmailNotification12 emailNotification12 =  new EndUserEmailNotification12();
				   
				model.addAttribute("businessId", obj.getBusinessId());
				model.addAttribute("existingProduct", obj.getExistingProduct());
				model.addAttribute("Prod", obj.getProd());
				model.addAttribute("Amounts", obj.getAmounts());
				model.addAttribute("emailId", obj.getEmailId());
				
				
				String businessID = obj.getBusinessId();
				String existingProduct  = obj.getExistingProduct();
				String prod = obj.getProd();
				String amounts = obj.getAmounts();
				String endUserEmailId = obj.getEmailId();
				
			    
			    LOGS.info("Calling "+amounts); 	       
				
		
		      	       
		       if(i==0) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a ORIGINAL: ");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;	 
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification.main(obj, Email);
		    	}else if (i==1) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Second Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 //obj =  BCS2.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification2.main(obj, Email);
		    		 
		    	}else if (i==2) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Third Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 //obj =  BCS3.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification3.main(obj, Email);
		    		 
		    	}else if (i==3) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fourth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		// obj =  BCS4.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification4.main(obj, Email);
		    		 
		    	}else if (i==4) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Fifth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 //obj =  BCS5.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification5.main(obj, Email);
		    	}else if (i==5) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Sixth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		//obj =  BCS6.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification6.main(obj, Email);
		    		 
		    	}else if (i==6) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a seventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 //obj =  BCS7.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification7.main(obj, Email); 
		    	}else if (i==7) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eighth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		// obj =  BCS8.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification8.main(obj, Email);
		    	}else if (i==8) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Ninth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		// obj =  BCS9.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification9.main(obj, Email);
		    	}else if (i==9) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Tenth Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		// obj =  BCS10.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification10.main(obj, Email);	
		    	}else if (i==10) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Eleventh Request");
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 i++;
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = portno + 1;
		    		 //obj =  BCS11.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification11.main(obj, Email);		 
		    	}else if(i==11) {
		    		 LOGS.info(Thread.currentThread() +"                             ");
		    		 LOGS.info(Thread.currentThread() +"I am a i value: "+i);
		    		 LOGS.info(Thread.currentThread() +"I am a Twelth Request");
		    		 LOGS.info(Thread.currentThread() +"                            ");	    		
		    		 String Email = endUserEmailId;
		    		 int Port = portno;
		    		 portno = 4545;
		    		 //obj =  BCS12.main(businessID, existingProduct, prod, amounts);
		    		 obj =  BCS.main(businessID, existingProduct, prod, amounts,Port);
		    		 emailNotification12.main(obj, Email);
		    		 i=0;
		    	}
		   
		    }
		    String businessId = "";
	        businessId = obj.getBusinessId();
		
	        LOGS.info("output Data :   "+  obj.getBusinessId()+";"+obj.getAccountName()+";"+obj);
		    LOGS.info("Exception Message: "+obj.getExceptionMsg());
		    
		    
			model.addAttribute("businessId", obj.getBusinessId());
		    model.addAttribute("accountName", obj.getAccountName());
		    model.addAttribute("accountURL", obj.getAccountUrl());
			model.addAttribute("tcmNumber", obj.getTcmNumber());
		    model.addAttribute("issueId", obj.getIssueID());    
			model.addAttribute("executionId", obj.getExecutionID());
			//model.addAttribute("accountURL", obj.getAccountUrl());
			model.addAttribute("exceptionMsg", obj.getExceptionMsg());
		    
			String executionURL = "";
			  //executionURL = "https://hibu-us.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/general-search-test-executions?project.id=15218&issue.id="+obj.getIssueID()+"&execution.id="+obj.getExecutionID()+"&zql=issue%20%3D%20"+obj.getTcmNumber()+"&view=detail";
			executionURL="https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber();       
			model.addAttribute("executionURLData",executionURL);
			    LOGS.info("I am executing--2nd place");    
			  LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getTcmNumber()+";"+obj.getIssueID()+";"+obj.getExecutionID()+";"+executionURL);
			    
			    LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getAccountUrl());
		   
		
		/* if(obj.getExceptionMsg().equalsIgnoreCase("true"))
		        return "AmendsResultPage";
		   else
		   	return "Exception";*/
		    
		    
		}
	
	
	
	@RequestMapping(value = "/TestingTool", method = RequestMethod.GET)
	public ModelAndView cancelReplace() {
	return new ModelAndView("TestingTool", "command", new OrderPlacementObj());
	}
	
	@RequestMapping(value = "/ResultPage", method = RequestMethod.POST)
    public String CancelandReplace(@ModelAttribute("SpringWeb")OrderPlacementObj obj, 
 
 ModelMap model) throws Throwable {
		 model.addAttribute("actionItem", obj.getActionItem());
	    
	    String Uiaction = obj.getActionItem();
	    LOGS.info("Calling "+Uiaction+" Method.");
	   
	   
	   
	    if(Uiaction.trim().equalsIgnoreCase("Cancel and Replace")) {
	    	LOGS.info("Calling "+Uiaction+" Method.");
	    	 Main_CancelandReplace  Main_CancelandReplace =  new Main_CancelandReplace();
	    	 
	    	model.addAttribute("existingProduct", obj.getExistingProduct());
			model.addAttribute("businessId", obj.getBusinessId());
		    model.addAttribute("newProductName", obj.getNewProductName());
		    model.addAttribute("accountURL", obj.getAccountUrl());
	    	
	    	String UiPlanName = obj.getNewProductName();
		    String UiexistingPlan = obj.getExistingProduct();
		    String UibusinessId = obj.getBusinessId();
		    
	        Main_CancelandReplace.main(UibusinessId, UiexistingPlan, UiPlanName, portno);
	    
	    }
	    
	    if(Uiaction.trim().equalsIgnoreCase("Amend and Add")) {
	    	LOGS.info("Calling "+Uiaction+" Method.");
	    	 Main_AmendandADD Main_AmendandADD = new Main_AmendandADD();
	    	
	    	model.addAttribute("existingProduct", obj.getExistingProduct());
			model.addAttribute("businessId", obj.getBusinessId());
		    model.addAttribute("newProductName", obj.getNewProductName());
	    	
	    	String UiPlanName = obj.getNewProductName();
		    String UiexistingPlan = obj.getExistingProduct();
		    String UibusinessId = obj.getBusinessId();
		    
		    Main_AmendandADD.main(UibusinessId, UiexistingPlan, UiPlanName, portno);
	    
	    }
	    
	    if(Uiaction.trim().equalsIgnoreCase("Customer") || Uiaction.trim().equalsIgnoreCase("Credit")) {
	    	LOGS.info("Calling "+Uiaction+" Cancel All Method.");
	    	Main_CancelAll_CreditAndCustomer Main_CancelAll_CreditAndCustomer = new Main_CancelAll_CreditAndCustomer();
	    	
			model.addAttribute("businessId", obj.getBusinessId());
		   
	    	String UiCancelType = Uiaction;
		    String UibusinessId = obj.getBusinessId();
		    String ProductName  = "NA";
	       
	        Main_CancelAll_CreditAndCustomer.main(UibusinessId, UiCancelType, portno);
	        
	        obj.setNewProductName(ProductName);
	        model.addAttribute("newProductName", obj.getNewProductName());
	    }
	    
	    if(Uiaction.trim().equalsIgnoreCase("Quote Submission")) {
	    	LOGS.info("Calling "+Uiaction+" Method.");
	    	
	    	
	    	String repName = "Janelle";
	    	/*i = i+1;
	    	LOGS.info("I am i Value: "+i);
	    	if(i <= 1) {
	    		repName = "Janelle";
	    	}else if (i == 2) {
	    		repName = "Jenny";
	    	}
	    	*/
	    	 Main_Quote_Submission Main_Quote_Submission = new Main_Quote_Submission();
	    	
		    model.addAttribute("newProductName", obj.getNewProductName());
	    	
	    	String UiPlanName = obj.getNewProductName();
	    	LOGS.info("Plan Name is: "+UiPlanName);
	    	
	       
	        obj = Main_Quote_Submission.main(UiPlanName,repName,portno);
	       
	        
	        
	    }
	    
	    if(Uiaction.trim().equalsIgnoreCase("Fulfillment")) {
	    	LOGS.info("Calling "+Uiaction+" Method.");
	    	
	    	model.addAttribute("businessId", obj.getBusinessId()); //quoteID
	    	//model.addAttribute("quoteID", obj.getQuoteID());
	    	
		   // String UiquoteID = obj.getQuoteID();
		    String UibusinessId = obj.getBusinessId();
		    String ProductName  = "NA";
		    
		    LOGS.info("BusinessID from JSP: "+UibusinessId);
		    NonSAMI_FF NonSAMI_FF = new NonSAMI_FF();
		    NonSAMI_FF.main(UibusinessId, portno);
	       
	        
	        obj.setNewProductName(ProductName);
	        model.addAttribute("newProductName", obj.getNewProductName());
	        
	        
	    }
	    
	   String businessId = "";
	    if(Uiaction.trim().equalsIgnoreCase("Fulfillment")) {
	    	 businessId = obj.getBusinessId();
	    }
	    else
	    {  businessId = obj.getBusinessId();}
	    
	    /*  String accountName = "";//BusinessNameQuoteDetls;
	    String accountURL = AccURL;
	    LOGS.info(businessId+";"+accountName +";"+accountURL);
	    String tcmNo = TestCaseNum;
	    String issueId = TestCaseId;
	    String zephyrExecutionId = ZephyrTestCase.ExecutionId;
	    String exceptionMsg = obj.getExceptionMsg();*/
	    
	   /* obj.setTcmNumber(tcmNo);
	    obj.setIssueID(issueId);
	    obj.setExecutionID(zephyrExecutionId);    
	    obj.setAccountName(accountName);
	    obj.setBusinessId(businessId);
	    obj.setAccountUrl(accountURL);*/
	    
	    
	    LOGS.info("output Data :   "+  obj.getBusinessId()+";"+obj.getAccountName()+";"+obj);
	    LOGS.info("Exception Message: "+obj.getExceptionMsg());
	    
	    
		model.addAttribute("businessId", obj.getBusinessId());
	    model.addAttribute("accountName", obj.getAccountName());
	    model.addAttribute("accountURL", obj.getAccountUrl());
		model.addAttribute("tcmNumber", obj.getTcmNumber());
	    model.addAttribute("issueId", obj.getIssueID());    
		model.addAttribute("executionId", obj.getExecutionID());
		//model.addAttribute("accountURL", obj.getAccountUrl());
		model.addAttribute("exceptionMsg", obj.getExceptionMsg());
	    
		String executionURL = "";
		//  executionURL = "https://hibu-us.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/general-search-test-executions?project.id=15218&issue.id="+obj.getIssueID()+"&execution.id="+obj.getExecutionID()+"&zql=issue%20%3D%20"+obj.getTcmNumber()+"&view=detail";
		executionURL="https://hibu-us.atlassian.net/browse/"+obj.getTcmNumber();     
		model.addAttribute("executionURLData",executionURL);
		    LOGS.info("I am executing--2nd place");    
		  LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getTcmNumber()+";"+obj.getIssueID()+";"+obj.getExecutionID()+";"+executionURL);
		    
		    LOGS.info(obj.getBusinessId()+";"+obj.getAccountName() +";"+obj.getAccountUrl());
	    
	    
		    if(obj.getExceptionMsg().equalsIgnoreCase("true"))
		        return "ResultPage";
		   else
		   	return "Exception";
	}
	
	
	
	
	
}	
	
