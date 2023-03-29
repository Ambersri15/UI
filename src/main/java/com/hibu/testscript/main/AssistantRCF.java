package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.RCFProvisioning;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class AssistantRCF extends PreRequisites {

	public static Logger LOGS = LogManager.getLogger(AssistantRCF.class.getName());
	public OrderPlacementObj main(String CaseNum, int portno) throws Exception {
		// TODO Auto-generated method stub
		
		
		SalesforceTasks st = new SalesforceTasks();
        PreRequisites pr = new PreRequisites();
        RCFProvisioning rcf = new RCFProvisioning();
        OrderPlacementObj obj = new OrderPlacementObj();
        EndUserEmailNotification mail = new EndUserEmailNotification();
       // DOMConfigurator.configure("log4j.xml");
        rcf.portNO = portno;
        pr.loadPropertiesFiles("Object");
        String curDate = new SimpleDateFormat("ddMMM").format(new Date());
        LOGS.info(curDate);
        TestCaseName="UI_"+curDate;   
        Resultsfolderpath = pr.createFolder(TestCaseName);
        pr.preparingOutputSheets();
        SalesRepType = "OpsWizard";
        
        
        rcf.RCFProvisionAssistant(Resultsfolderpath, SalesRepType, CaseNum); 
        
        String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from RCF provisioning: "+ excelPath);
        
        ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
		String Summary = "AUT : CPQ : Assistant RCF provision on case : "+ CaseNum;
		LOGS.info("Zephyr creation method");
			String Description = "AUT : CPQ : Assistant RCF provision on case : "+ CaseNum + " was successful";
			
			if(rcf.ExceptionMsg.trim().equalsIgnoreCase("True")) {
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			}else {
				Description = "AUT : CPQ : Assistant RCF provision on case : "+ CaseNum + " was failed due to "+ rcf.ExceptionMsg;
				LOGS.info("Request is failed : TCM will not be created : Exception Message is: "+rcf.ExceptionMsg);
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Case No = "+CaseNum);
			
			}
			
			obj.setCaseNo(CaseNum);
			obj.setExceptionMsg(rcf.ExceptionMsg);
			obj.setTcmNumber(TestCaseNum);
			obj.setfolderPath(Resultsfolderpath+"/"+rcf.ImgName);
			
			rcf.SFLogout();
			obj.setActionItem("Assistant RCF Provisioning");
			System.out.println("Case No = "+CaseNum);
			LOGS.info("This is my action " + obj.getActionItem() + " in Assistant RCF method");
		   //mail.main(obj,"sabarishrahul.b22@wipro.com");
			return obj;
	}

}
