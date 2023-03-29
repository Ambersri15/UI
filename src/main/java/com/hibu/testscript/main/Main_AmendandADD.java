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

public class Main_AmendandADD extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(Main_AmendandADD.class.getName());
	
	public OrderPlacementObj main(String UiBusinessId, String UiExistingProduct,String UiNewProduct, int portno) throws Exception {
		SalesforceTasks st = new SalesforceTasks();
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		EndUserEmailNotification mail = new EndUserEmailNotification();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		st.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_AandA"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
	
	
	
	LOGS.info("Business Id: "+UiBusinessId+"; Existing Product: "+UiExistingProduct+"; New Product: "+UiNewProduct);
	
	
	
	if(UiNewProduct.trim().contains("Foundation") || UiNewProduct.trim().contains("Presence")) {
		UiNewProduct = UiNewProduct+",";
	
	if(UiNewProduct.trim().contains("Search"))
	{
		UiNewProduct = UiNewProduct+"Managed Search,"; 
	}
	if(UiNewProduct.trim().contains("Display")) {
			UiNewProduct = UiNewProduct+"Display,"; 
		}
	if(UiNewProduct.trim().contains("Social")) {
		UiNewProduct = UiNewProduct+"Social,"; 
	}
	if(UiNewProduct.trim().contains("Smart Online Presence")) {
		UiNewProduct = UiNewProduct+"Smart Presence Solutions,"; 
	}
	}
	
	if(UiNewProduct.trim().contains("Smart Sync") || UiNewProduct.trim().contains("Synchronized Marketing")) {
		UiNewProduct = UiNewProduct+",";
		UiNewProduct = UiNewProduct+"Managed Search,Display,Social";
	}
	
	if(UiNewProduct.trim().contains("Ad Campaign"))
	{
		if(UiNewProduct.trim().contains("Search"))
			UiNewProduct  = UiNewProduct.replace(" + Search", "");
		
		if(UiNewProduct.trim().contains("Display"))
			UiNewProduct  = UiNewProduct.replace(" + Display", "");
		
		if(UiNewProduct.trim().contains("Social"))
			UiNewProduct  = UiNewProduct.replace(" + Social", "");
	}
	
	
	LOGS.info("Existing Product Parent Name: "+UiExistingProduct);
	LOGS.info("New Product Plan Name: "+UiNewProduct);
	
	st.Amend_Packages(UiBusinessId, UiExistingProduct, UiNewProduct,"AmendandAdd",Resultsfolderpath);
	
	
			//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
			String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
			TestCaseNum = "";
			//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
			//ExportResults.CExportQuote();
			ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
			String Summary = "CPQ : For Active "+UiExistingProduct+" Added with  "+UiNewProduct+" - Tsales : "+ UiBusinessId;
			LOGS.info("Zephyr creation method");
			String Description = "CPQ : For Active "+UiExistingProduct+" Added with  "+UiNewProduct+" - Tsales was Successful";
			
			if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
			}else {
				Description = "CPQ : For Active "+UiExistingProduct+" Added with  "+UiNewProduct+" Tsales was Failed due to :"+ st.ExceptionMsg;
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			LOGS.info("Zephyr creation after method with failed exception : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
				
			}
			LOGS.info("Business id Logs : "+st.businessID);
	        
	        obj.setBusinessId(st.businessID);
			obj.setAccountUrl(st.AccURL);
			obj.setAccountName(st.BusinessNameQuoteDetls);
			obj.setExceptionMsg(st.ExceptionMsg);
			obj.setTcmNumber(TestCaseNum);
			obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
			
			st.SFLogout();
			obj.setActionItem("Amend and Add");
			LOGS.info("This is my action " + obj.getActionItem());
			//mail.main(obj,"sabarishrahul.b22@wipro.com");
			
			return obj;
	}


}
