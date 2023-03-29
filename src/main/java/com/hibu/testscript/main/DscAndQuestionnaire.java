package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.MoveOrCopyFile;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class DscAndQuestionnaire extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(DscAndQuestionnaire.class.getName());
	
	public OrderPlacementObj main(String CaseNo, String UiProduct) throws Exception {
		
		
		 st = new SalesforceTasks(); 
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("Given  "+CaseNo+" for Questionnaire");
		
		
		st.questionnaireCompletionForLocalRankingProducts(CaseNo,UiProduct);
		
		
		
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : Dsc Case Edit and Questionnaire for: "+UiProduct+" and Case Number: "+CaseNo;
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : Dsc Case Edit and Questionnaire for: "+UiProduct+" - was Successful";
				
				if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					//TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description);
			  		TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Business id Logs : "+st.businessID);
		        
		        
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				
				st.SFLogout();
				
				
				return obj;
	}
	
	

	
	
}
