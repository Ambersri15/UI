package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class Main_CancelAll_CreditAndCustomer extends PreRequisites{
	public static Logger LOGS = LogManager.getLogger(Main_CancelAll_CreditAndCustomer.class.getName());
	public OrderPlacementObj main(String UiBusinessId, String UiCancelType, int portno) throws Exception {
		SalesforceTasks st = new SalesforceTasks();
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		EndUserEmailNotification mail = new EndUserEmailNotification();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		st.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Business Id: "+UiBusinessId+"; Cancel Reason: "+UiCancelType);
		
		
		SalesRepType = "OpsWizard";
		businessID = UiBusinessId;
		CancelType = UiCancelType;//Credit or Customer
		CancelReason = "Out of Business";
		
		LOGS.info("SalesRepType: " +SalesRepType+"Business Id: "+businessID  + "; Cancel Type: "+CancelType + "; Cancel Reason: "+ CancelReason);
		
		
		st.CancelAllPrepMethod(SalesRepType,businessID,CancelType,CancelReason,Resultsfolderpath);
		
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		TestCaseNum = "";
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
		
		//ExportResults.CExportQuote();
			String Summary = "CPQ : Cancel All with Cancel Type "+UiCancelType+" on the Account id: "+UiBusinessId+" with - Ops";
			LOGS.info("Zephyr creation method");
				String Description = "CPQ : Cancel All with Cancel Type"+UiCancelType+" on the Account id: "+UiBusinessId+" with - Ops was Successful";
				if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
					LOGS.info("Zephyr creation after method : "+ TestCaseNum );
					System.out.println("Zephyr Card No = "+TestCaseNum);
					LOGS.info("Zephyr Card No = "+TestCaseNum);
					}else {
						Description = "CPQ : Cancel All with Cancel Type"+UiCancelType+" on the Account id: "+UiBusinessId+" with - Ops was Failed due to:"+ st.ExceptionMsg;
						TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
				  		//TestCaseNum = "NA";
						LOGS.info("Zephyr creation after method for failed exception : "+ TestCaseNum );
						System.out.println("Zephyr Card No = "+TestCaseNum);
						LOGS.info("Zephyr Card No = "+TestCaseNum);
					}
				
                LOGS.info("Business id Logs : "+st.businessID);
		        
		        obj.setBusinessId(businessID);
				obj.setAccountUrl(st.AccURL);
				obj.setAccountName(st.BusinessNameQuoteDetls);
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
				
				st.SFLogout();
				obj.setActionItem(UiCancelType);
				//obj.setActionItem("Credit");
				LOGS.info("This is my cancel type " +UiCancelType);
				LOGS.info("This is my action " + obj.getActionItem());
				//mail.main(obj,email);
				
				return obj;
		}

}
