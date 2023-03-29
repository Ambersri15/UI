package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.AstLocationCreation;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.ZephyrTestCase;

public class Main_AstLocationCreation extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(Main_AstLocationCreation.class.getName());
	
	public OrderPlacementObj main(String BusinessId, String RepName) throws Exception {
		
		AstLocationCreation astLC = new AstLocationCreation();
		
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_AstLocationCreation_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("Business id: " + BusinessId);
		
		
		astLC.Assistant_LocationCreation(BusinessId, RepName, Resultsfolderpath);
		
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from QS: "+ excelPath);
		
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "UI : CPQ : Assistant - Location Creation";
			LOGS.info("Zephyr creation method");
				String Description = "UI : CPQ : Assistant - Location Creation was Successful";
				
				if(astLC.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					//TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
				
				LOGS.info("Business id Logs : "+astLC.businessID);
		        
				obj.setBusinessId(astLC.businessID);
				obj.setExceptionMsg(astLC.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				
				astLC.SFLogout();
				
				
				return obj;
	}
	
	

	
	
}
