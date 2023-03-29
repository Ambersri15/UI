package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.MoveOrCopyFile;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class DomainProvisionAndPublishing extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(DomainProvisionAndPublishing.class.getName());
	
	public OrderPlacementObj main(String businessId, int portno) throws Exception {
		 st = new SalesforceTasks(); 
		PreRequisites pr = new PreRequisites();
		EndUserEmailNotification mail = new EndUserEmailNotification();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		st.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("User given "+businessId+" for Domain Provision and Publish.");
		
		
		st.DomainProvisioning(businessId,Resultsfolderpath);
		LOGS.info("Exception Message: "+ st.ExceptionMsg );
		 ExceptionMsg = st.ExceptionMsg;
		
		LOGS.info("Exception Message: "+ st.ExceptionMsg );
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : Domain Provision and Publishing: "+businessId;
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : Domain Provision and Publishing: "+businessId+" - was Successful";
				
				if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}else {
					LOGS.info("Request is failed : TCM will  be created for failed exception : Exception Message is: "+st.ExceptionMsg);
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Business id Logs : "+businessId);
		        
				//obj.setBusinessId(st.businessID);
				obj.setBusinessId(businessId);
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
				
				st.SFLogout();
				obj.setActionItem("Domain Provision and Publish");
				LOGS.info("This is my action " + obj.getActionItem());
				//mail.main(obj,"sabarishrahul.b22@wipro.com");
				
				return obj;
	}
	
	

}
