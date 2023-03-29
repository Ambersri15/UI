package com.hibu.testscripts.FF;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.fulfillment.SamiFulfillment;
import com.hibu.fulfillment.SamiPreRequisites;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.ZephyrTestCase;

public class NonSAMI_FF extends SamiPreRequisites{
	public static Logger LOGS = LogManager.getLogger(NonSAMI_FF.class.getName());
	
	static String TestCaseNum="";
	static String GhostWindow="",ValidateQ;
	static String ValidateOpptStatus, domainName,ProdNameVal,CreateQ;
	static int PayableNow;
	static String ActRes="",ExpRes="",Status="",ImagePath="",ImageName="",ImgName="";
	public static String ProdName;
	
	public OrderPlacementObj main(String BusinessId, int portno) throws Throwable {
		
		
		SamiFulfillment SF = new SamiFulfillment();
		SamiPreRequisites SP = new SamiPreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//EndUserEmailNotification mail = new EndUserEmailNotification();
		//DOMConfigurator.configure("log4j.xml");
		SF.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = SP.createFolder(TestCaseName);
		SP.preparingOutputSheets();
	   
		LOGS.info("SalesforceTask Result Folder: "+Resultsfolderpath);
		
		LOGS.info("----"+SP.Resultsfolderpath);
		SP.Resultsfolderpath = Resultsfolderpath;
		LOGS.info("SAMI Result folder: "+SP.Resultsfolderpath);
			
		
		
	try {


						/*SalesRep="Admin";
						st.SalesforceLogin("sfAdminUserName", "sfAdminPswd");
					    LOGS.info("SF Login Successful");
					    
					    LOGS.info("Business ID: "+BusinessId);
					    
					    ProdName = st.getPendingSubscriptions(BusinessId);
					   LOGS.info("Products with Pending Status: "+ProdName);
					   
					   if(ProdName.equalsIgnoreCase("Fail")) {
						   st.SFLogout();
					   }
					   else if(ProdName.equalsIgnoreCase("None"))
						 {
						   LOGS.info("Either all Subscriptions are in Active status or account has no SAMI.");
						  //ExceptionMsg= "The Business Id provided does not have any pending subscriptions, Nothing to Fulfill.";
							
						 }	
					   
                 if(ProdName.equalsIgnoreCase("Search (a la carte)")||ProdName.equalsIgnoreCase("Display (a la carte)")
				 ||ProdName.equalsIgnoreCase("Social (a la carte)")||ProdName.equalsIgnoreCase("Search - Guaranteed Clicks")
				||ProdName.equalsIgnoreCase("Managed Search")
				 ||ProdName.equalsIgnoreCase("Social")||ProdName.equalsIgnoreCase("Display")) {
	    	     st.SFLogout();	   
				 LOGS.info("NON-SAMI is not present hence Calling SAMI Fulfillment System...");
				*/
				 try{
					 LOGS.info("SAMI Result folder: "+SP.Resultsfolderpath);
					 SF.samiFlow(BusinessId,SP.Resultsfolderpath);
				 
				 LOGS.info("Exception Message: "+ SF.ExceptionMsg );
				 ExceptionMsg = SF.ExceptionMsg;
				 obj.setExceptionMsg(SF.ExceptionMsg);
				 LOGS.info("Exception Message: "+ SF.ExceptionMsg );
				 
				 LOGS.info("SAMI LOGOUT Method.");
				 SF.SAMILogout();
				

				 }catch(Exception e) {
					 ExceptionMsg = SF.ExceptionMsg;
					 obj.setExceptionMsg(SF.ExceptionMsg);
					 LOGS.info("Exception Message: "+ SF.ExceptionMsg );
					 LOGS.info("SAMI LOGOUT Method.");
					 SF.SAMILogout();
					 
					 

				 }
						   
			    /* }	
                 else {
     				LOGS.info("No SAMI Product is available to be fulfilled!!");
                 }*/
				 String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
				 LOGS.info("excelpath at Samiff: "+ excelPath);
					   ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
		  
					   // MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",SP.Resultsfolderpath+"/ZephyrTestResult.xlsx");						
						String Summary="UI: Fulfillment :  - Day2 SAMI "+BusinessId;
					  	String Description="Fulfillment completed for "+BusinessId;
					  	if(SF.ExceptionMsg.trim().equalsIgnoreCase("True")) {
							TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
					  		//TestCaseNum = "NA";
						LOGS.info("Zephyr creation after method : "+ TestCaseNum );
						System.out.println("Zephyr Card No = "+TestCaseNum);
						LOGS.info("Zephyr Card No = "+TestCaseNum);
						}else {
							LOGS.info("Request is failed : TCM will not be created with failed results: Exception Message is: "+SF.ExceptionMsg);
							Description="Fulfillment Failed for "+BusinessId+ " Due to : "+SF.ExceptionMsg;
							TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
					  		//TestCaseNum = "NA";
							LOGS.info("Zephyr creation after method : "+ TestCaseNum );
							System.out.println("Zephyr Card No = "+TestCaseNum);
							LOGS.info("Zephyr Card No = "+TestCaseNum);
						}
					  	LOGS.info("Business id Logs : "+BusinessId);
						LOGS.info("Zephyr Card No = "+TestCaseNum);
				        
						obj.setBusinessId(BusinessId);
						obj.setExceptionMsg(SF.ExceptionMsg);
						obj.setTcmNumber(TestCaseNum);
						obj.setfolderPath(Resultsfolderpath+"/"+SF.ImgName);
						SF.SAMILogout();
						
						obj.setActionItem("SAMI Fulfillment");
						LOGS.info("This is my action " + obj.getActionItem());
						//mail.main(obj,"sabarishrahul.b22@wipro.com");

						return obj; 
						
						
								
			
	}
	catch(Exception e) {
		
		LOGS.info("Final Catch on Sami Test case.");
		//LOGS.info("SAMI LOGOUT Method.");
		SF.SAMILogout();
		//SalesforceTasks.SFLogout();
		obj.setfolderPath(Resultsfolderpath+"/"+SF.ImgName);
		obj.setActionItem("SAMI Fulfillment");
		LOGS.info("This is my action " + obj.getActionItem());
		//mail.main(obj,"sabarishrahul.b22@wipro.com");
		return obj; 
	}
		
	}
	
}	


