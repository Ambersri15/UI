package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.AstNewReview;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.ZephyrTestCase;

public class Main_AstNewReview extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(Main_AstNewReview.class.getName());
	
	public OrderPlacementObj main(String BusinessId, String RepName) throws Exception {
		
		AstNewReview astNR = new AstNewReview();
		
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_AstNewReview_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("Business id: " + BusinessId);
		
		
		astNR.Assistant_NewReview(BusinessId, RepName, Resultsfolderpath);
		
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from QS: "+ excelPath);
		
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : Assistant - Triggering New Reivew Using Rest Call";
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : Assistant - Triggering New Reivew Using Rest Call was Successful";
				
				if(astNR.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					//TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Business id Logs : "+astNR.businessID);
		        
				obj.setBusinessId(astNR.businessID);
				obj.setExceptionMsg(astNR.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				
				astNR.SFLogout();
				
				
				return obj;
	}
	
	

	
	
}
