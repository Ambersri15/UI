package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.orderplacement.model.OrderPlacementObj;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;

public class BudgetChangeForSolutions extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(BudgetChangeForSolutions.class.getName());
	
		public  OrderPlacementObj main(String buisnessID, String Prod, String allplans, String Amounts, int portno) throws Exception {
			 st = new SalesforceTasks();
				PreRequisites pr = new PreRequisites();
				OrderPlacementObj obj = new OrderPlacementObj();
				EndUserEmailNotification mail = new EndUserEmailNotification();
				//DOMConfigurator.configure("log4j.xml");
				pr.loadPropertiesFiles("Object");
				st.portNO = portno;
				String curDate = new SimpleDateFormat("ddMMM").format(new Date());
				LOGS.info(curDate);
				TestCaseName="UI_BudgetChange"+curDate;	
				Resultsfolderpath = pr.createFolder(TestCaseName);
				pr.preparingOutputSheets();
			

			SalesRepType = "OpsWizard";
			//businessID = buisnessID;
			/*Prod = "";
			allplans = "";
			Amounts="";*/
		 LOGS.info("This is my Amounts: " +Amounts);
		 LOGS.info("This is my Business Id: " +buisnessID);
	     LOGS.info("These are my values for the method: The Logged User is:" +SalesRepType + ", my business Id -- " +buisnessID +", my products -- "+ Prod+ ", my plan -- " +allplans+", my amount --"+ Amounts);
	     st.priceChangeMul(buisnessID,Prod,allplans,Amounts,Resultsfolderpath);
		//String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("Exception Message: "+ st.ExceptionMsg );
		 ExceptionMsg = st.ExceptionMsg;
	
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		LOGS.info("excelpath from QS: "+ excelPath);
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "AUT : CPQ : Budget Change for Solutions: "+buisnessID;
			LOGS.info("Zephyr creation method");
				String Description = "AUT : CPQ : Budget Change for Solutions: "+buisnessID+" - was Successful";
				
				if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}else {
					LOGS.info("Request is failed : TCM will not be created : Exception Message is: "+st.ExceptionMsg);
				}
				
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				LOGS.info("Business id Logs : "+st.businessID);
		        obj.setBuisnessID(buisnessID);
				obj.setAccountUrl(st.AccURL);
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				//obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
				
				obj.setActionItem("BudgetChangeForSolutions");
				LOGS.info("This is my action " + obj.getActionItem() +"for BCS Method");
				st.SFLogout();
				
				
				return obj;
	}
	
	

}
