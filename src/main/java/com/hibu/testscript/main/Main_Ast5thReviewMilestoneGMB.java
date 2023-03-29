package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.Ast5thReviewMilestoneGMB;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.ZephyrTestCase;

public class Main_Ast5thReviewMilestoneGMB extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(Main_Ast5thReviewMilestoneGMB.class.getName());
	
	public OrderPlacementObj main(String BusinessId, String RepName) throws Exception {
		
		Ast5thReviewMilestoneGMB ast5RM = new Ast5thReviewMilestoneGMB();
		
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_Ast5thReviewMilestoneGMB_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("Business id: " + BusinessId);
		
		
		ast5RM.Assistant_Ast5thReviewMilestoneGMB(BusinessId, RepName, Resultsfolderpath);
		
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from QS: "+ excelPath);
		
		
		
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : Assistant - Triggering 5th Review Milestone Using Rest Call";
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : Assistant - Triggering 5th Review Milestone Using Rest Call was Successful";
				
				if(ast5RM.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					//TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Business id Logs : "+ast5RM.businessID);
		        
				obj.setBusinessId(ast5RM.businessID);
				obj.setExceptionMsg(ast5RM.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				
				ast5RM.SFLogout();
				
				
				return obj;
	}
	
	

	
	
}
