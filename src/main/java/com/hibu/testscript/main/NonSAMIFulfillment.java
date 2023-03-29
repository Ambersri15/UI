package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class NonSAMIFulfillment extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(NonSAMIFulfillment.class.getName());
	
	public OrderPlacementObj main(String CaseNo, String UiProduct, int portno) throws Exception {
		OrderPlacementObj obj = new OrderPlacementObj();
		
		if(UiProduct.trim().equalsIgnoreCase("Online Foundation Solutions + LR") ||
				UiProduct.trim().equalsIgnoreCase("Synchronized Marketing Solutions + LR")	){
			
			ExceptionMsg = "Consultation is not required for this product. Please proceed with Step:4.";
			obj.setExceptionMsg(ExceptionMsg);
			
			return obj;
		}
		
		
		
		 st = new SalesforceTasks(); 
		PreRequisites pr = new PreRequisites();
		EndUserEmailNotification mail = new EndUserEmailNotification();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		st.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("Given  "+CaseNo+" for Questionnaire");
				
		st.fulfilmentExceptSami(CaseNo,UiProduct,Resultsfolderpath);
		
		
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : NON-SAMI FF: "+UiProduct+" and Case Number: "+CaseNo;
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : NON-SAMI FF: "+UiProduct+" - was Successful";
				
				if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				
				}else {
					LOGS.info("Request is failed : Failed TCM will be created : Exception Message is: "+st.ExceptionMsg);
					Description = "UI : CPQ : NON-SAMI FF: "+UiProduct+" - was Failed with: "+st.ExceptionMsg;
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Case no : "+CaseNo);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
		        
				obj.setCaseNo(CaseNo);
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
				
				st.SFLogout();
				obj.setActionItem("Non SAMI Fulfillment");
				LOGS.info("This is my action " + obj.getActionItem());
				//mail.main(obj,email);
				return obj;
	}
	
	

	
	
}
