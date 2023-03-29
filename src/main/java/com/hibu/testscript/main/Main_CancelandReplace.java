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

public class Main_CancelandReplace extends PreRequisites{
	public static Logger LOGS = LogManager.getLogger(Main_CancelandReplace.class.getName());
	public OrderPlacementObj main(String UiBusinessId, String UiExistingProduct,String UiNewProduct,int portno) throws Exception {
		 st = new SalesforceTasks();
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		EndUserEmailNotification mail = new EndUserEmailNotification();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		st.portNO = portno;
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		TestCaseName="UI_CanAndReplace"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
	
	
	
	
	LOGS.info("Business Id: "+UiBusinessId+"; Existing Product: "+UiExistingProduct+"; New Product: "+UiNewProduct);
	
	
	

	if(UiExistingProduct.trim().contains("Foundation"))
	{
		UiExistingProduct = "Online Foundation Solutions";
	}else if(UiExistingProduct.trim().contains("Presence"))
	{
		UiExistingProduct = "Smart Presence Solutions";
	}else if(UiExistingProduct.trim().contains("Smart Sync"))
	{
		UiExistingProduct = "Smart Synchronized Solutions";
	}else if(UiExistingProduct.trim().contains("Synchronized Marketing"))
	{
		UiExistingProduct = "Synchronized Marketing Solutions";
	}else if(UiExistingProduct.trim().contains("Smart Site"))
	{
		UiExistingProduct = "Website (a la carte)";
		
	}
	else
	{
		LOGS.info("Existing Product is Standalone (other than Website):"+UiExistingProduct);
	}
	
	
	
	
	
	
	
	//UiNewProduct = UiNewProduct.replace(" + LR", "");
	
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
	
	
	st.Amend_Packages(UiBusinessId, UiExistingProduct, UiNewProduct,"CancelandReplace",Resultsfolderpath);
	
	
	String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
	
	ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
	
	//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");

	//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
	//ExportResults.CExportQuote();
	     TestCaseNum = "";
		String Summary = "Ui: CPQ : Cancel "+UiExistingProduct+" and Replaced with "+UiNewProduct+" - Tsales : "+UiBusinessId;
		LOGS.info("Zephyr creation method");
			String Description = "CPQ : Cancel "+UiExistingProduct+" and Replaced with "+UiNewProduct+" - Tsales was Successful";
			
			if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
				LOGS.info("Zephyr creation after method : "+ TestCaseNum );
				System.out.println("Zephyr Card No = "+TestCaseNum);
				LOGS.info("Zephyr Card No = "+TestCaseNum);
				}else {
					Description = "CPQ : Cancel "+UiExistingProduct+" and Replaced with "+UiNewProduct+" - Tsales was failed due to:"+st.ExceptionMsg;
					TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
			  		//TestCaseNum = "NA";
					LOGS.info("Zephyr creation after method for failed exceptions : "+ TestCaseNum );
					System.out.println("Zephyr Card No = "+TestCaseNum);
					LOGS.info("Zephyr Card No = "+TestCaseNum);
				}
			
			LOGS.info("Business id Logs : "+st.businessID);
			LOGS.info("Exception Status:n"+st.ExceptionMsg);
	        
	        obj.setBusinessId(st.businessID);
			obj.setAccountUrl(st.AccURL);
			obj.setAccountName(st.BusinessNameQuoteDetls);
			obj.setExceptionMsg(st.ExceptionMsg);
			obj.setTcmNumber(TestCaseNum);
			obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
			
			st.SFLogout();
			obj.setActionItem("Cancel and Replace");
			LOGS.info("This is my action " + obj.getActionItem());
			//mail.main(obj,"sabarishrahul.b22@wipro.com");
			 
			
			
			return obj;
	}
}
