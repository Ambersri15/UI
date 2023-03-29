package com.hibu.testscript.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.RCFProvisioning;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class QuestionnaireAssistantRCF extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(QuestionnaireAssistantRCF.class.getName());

	public OrderPlacementObj main(String CaseNO, int portno) throws Exception{
		// TODO Auto-generated method stub

		
		SalesforceTasks st = new SalesforceTasks();
        PreRequisites pr = new PreRequisites();
        RCFProvisioning rcf = new RCFProvisioning();
        OrderPlacementObj obj = new OrderPlacementObj();
       // DOMConfigurator.configure("log4j.xml");
        pr.loadPropertiesFiles("Object");
        rcf.portNO = portno;
        String curDate = new SimpleDateFormat("ddMMM").format(new Date());
        LOGS.info(curDate);
        TestCaseName="UI_"+curDate;   
        Resultsfolderpath = pr.createFolder(TestCaseName);
        pr.preparingOutputSheets();
        SalesRepType = "OpsWizard";
        
        rcf.QuestionnaireRCFProvision(CaseNO, Resultsfolderpath, SalesRepType);
        
        String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from RCF provisioning: "+ excelPath);
        
        ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
		String Summary = "AUT : CPQ : Assistant RCF provision from Questionnaire on case : "+ CaseNO;
		LOGS.info("Zephyr creation method");
			String Description = "AUT : CPQ : Assistant RCF provision from Questionnaire on case : "+ CaseNO + " was successful";
			
			if(rcf.ExceptionMsg.trim().equalsIgnoreCase("True")) {
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			}else {
				Description = "AUT : CPQ : Assistant RCF provision from Questionnaire on case : "+ CaseNO + " was failed due to "+ rcf.ExceptionMsg;
				LOGS.info("Request is failed : TCM will not be created : Exception Message is: "+rcf.ExceptionMsg);
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			}
			
			obj.setBusinessId(CaseNO);
			obj.setExceptionMsg(rcf.ExceptionMsg);
			obj.setTcmNumber(TestCaseNum);
			obj.setfolderPath(Resultsfolderpath+"/"+rcf.ImgName);
			obj.setActionItem("Assistant RCF Provisioning");
			
			rcf.SFLogout();
			return obj;
	}

}