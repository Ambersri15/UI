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

public class Main_Quote_Submission extends PreRequisites {
	
	public static Logger LOGS = LogManager.getLogger(Main_Quote_Submission.class.getName());
	
	public OrderPlacementObj main(String UiProduct, String repName,int portno) throws Exception {
		st = new SalesforceTasks();
		EndUserEmailNotification email = new EndUserEmailNotification();
		PreRequisites pr = new PreRequisites();
		OrderPlacementObj obj = new OrderPlacementObj();
		//DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		st.portNO = portno;
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		
		LOGS.info("Results Folder Path: "+Resultsfolderpath);
		LOGS.info("User selected Product: "+UiProduct+" for Quote Submission.");
		
		
		String ProdsString = "";
		String PlansString = "";
		      
				
		
		 
		 
		 String products = UiProduct;
	 if(UiProduct.trim().contains("Smart Site"))
			{ 
		  if (UiProduct.contains("Smart Site - Standard (Spread Billing)"))
		  {
			  products = UiProduct.replace("Smart Site - Standard (Spread Billing)", "Website (a la carte)");
				 ProdsString = products;
				 PlansString = UiProduct;
		  }
		  else if(UiProduct.contains("Smart Site - Pro (Spread Billing)"))
		  {
			  products = UiProduct.replace("Smart Site - Pro (Spread Billing)", "Website (a la carte)");
			  ProdsString = products;
			  PlansString = UiProduct;
		  }
		  else if(UiProduct.contains("Smart Site - Standard"))
				  {
		 products = UiProduct.replace("Smart Site - Standard", "Website (a la carte)");
		 ProdsString = products;
		    PlansString = UiProduct;
				  }
		  else if(UiProduct.contains("Smart Site - Pro"))
		  {
			  products = UiProduct.replace("Smart Site - Pro", "Website (a la carte)");
			  ProdsString = products;
			  PlansString = UiProduct;
		  }
		  
		
			}
			
		if(UiProduct.trim().contains("(a la carte)"))
			{
				 ProdsString = products;
				 PlansString = UiProduct;
				
 			}
		 if(UiProduct.trim().contains("Listings"))
		{
			 ProdsString = products;
			 PlansString = UiProduct;
		}
		 if(UiProduct.trim().contains("Reviews"))
		{
			 ProdsString = products;
			 PlansString = UiProduct;
		}
		if(UiProduct.trim().contains("Guaranteed"))
		{
			 ProdsString = products;
			 PlansString = UiProduct;
		}
		if(UiProduct.trim().contains("Reputation"))
		{
			 ProdsString = products;
			 PlansString = UiProduct;
		}
		 if(UiProduct.trim().contains("Foundation"))
         {
      	   ProdsString =  "Online Foundation Solutions";
         }
		                      
		                       else if(UiProduct.trim().contains("Presence"))
		                       {
		                    	   ProdsString =  "Smart Presence Solutions";
		                       }
		                       else if(UiProduct.trim().contains("Smart Sync"))
		                       {
		                    	   ProdsString = "Smart Synchronized Solutions";
		                       }	
		                       else if(UiProduct.trim().contains("Synchronized Marketing"))
		                       {
		                    	   ProdsString = "Synchronized Marketing Solutions";
		                       }
		                     
						if(UiProduct.trim().contains("Foundation") || UiProduct.trim().contains("Presence")) {
							
						if(UiProduct.trim().contains("Search"))
						{
							UiProduct = UiProduct+",Managed Search"; 
						}
						
						if(UiProduct.trim().contains("Display")) {
							UiProduct = UiProduct+",Display"; 
							}
						
						if(UiProduct.trim().contains("Social")) {
							UiProduct = UiProduct+",Social"; 
						}
						
						PlansString = UiProduct;
				}
				
				if(UiProduct.trim().contains("Smart Sync") || UiProduct.trim().contains("Synchronized Marketing")) {
					PlansString = UiProduct+",Managed Search,Display,Social";
				}
				
				
				if(PlansString.trim().contains("Ad Campaign"))
				{
					if(PlansString.trim().contains("Search"))
                           PlansString  = PlansString.replace(" + Search", "");
					
					if(PlansString.trim().contains("Display"))
                        PlansString  = PlansString.replace(" + Display", "");
					
					if(PlansString.trim().contains("Social"))
                        PlansString  = PlansString.replace(" + Social", "");
				}
				
				LOGS.info("Final Product String : "+ProdsString);
				
				LOGS.info("Final Plan String : "+PlansString);
				String[] Prods = ProdsString.split(",");
			    String[] Plans = PlansString.split(",");
			
				
	
				
				LOGS.info("Parent product Name: "+Prods[0]);
				LOGS.info("Plan Name: "+Plans[0]);
				
		
				st.CPQMainMethod(Prods, Plans,repName,Resultsfolderpath);
		        
				String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
				LOGS.info("excelpath from QS: "+ excelPath);
		        
		      
		
		//MoveOrCopyFile.copyFunction("C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");

		//MoveOrCopyFile3.copyFunction(regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		//ExportResults.CExportQuote();
		//MoveOrCopyFile.copyFunction(regardingfilesPath+"OutputFiles\\ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
		ZephyrTestCase ZephyrTestCase = new ZephyrTestCase();
		String Summary = "AUTO : CPQ : Quote Submision on "+UiProduct+" - Tsales : "+st.businessID;
		LOGS.info("Zephyr creation method");
			String Description = "UI : CPQ : Quote Submision on "+UiProduct+" - Tsales was Successful";
			
			if(st.ExceptionMsg.trim().equalsIgnoreCase("True")) {
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			}else {
				Description = "UI : CPQ : Quote Submision on "+UiProduct+" - Tsales was Failed due to:"+ st.ExceptionMsg;
				LOGS.info("Request is failed : TCM will not be created : Exception Message is: "+st.ExceptionMsg);
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description, excelPath);
		  		//TestCaseNum = "NA";
			LOGS.info("Zephyr creation after method : "+ TestCaseNum );
			System.out.println("Zephyr Card No = "+TestCaseNum);
			LOGS.info("Zephyr Card No = "+TestCaseNum);
			}
			
	
			
			LOGS.info("Business id Logs : "+st.businessID);
		        
		        obj.setBusinessId(st.businessID);
				obj.setAccountUrl(st.AccURL);
				obj.setAccountName(st.BusinessNameQuoteDetls);
				obj.setExceptionMsg(st.ExceptionMsg);
				obj.setTcmNumber(TestCaseNum);
				obj.setNewProductName(UiProduct);
				obj.setSalesRepType(repName);
				obj.setfolderPath(Resultsfolderpath+"/"+st.ImgName);
				obj.setActionItem("QuoteSubmit");
				
				st.SFLogout();
				
				//email.main(obj, "amber.srivastava@wipro.com");
				return obj;
		
	}

	
}
