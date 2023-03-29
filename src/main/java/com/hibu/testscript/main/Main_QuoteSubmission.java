package com.hibu.testscript.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.xml.DOMConfigurator;

import com.hibu.test.PreRequisites;
import com.hibu.test.SalesforceTasks;

public class Main_QuoteSubmission extends PreRequisites {

	public void main(int portNO) throws Throwable {
		st = new SalesforceTasks();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//readingfiles//InputFiles//RandomQuotes.properties");
        Properties property = new Properties();
        property.load(fis);
        String quote = Integer.toString(new Random().nextInt(Integer.parseInt(property.getProperty("Number"))));
        String UiProduct = property.getProperty(quote);
        System.out.println("this is the product " + UiProduct);
        PreRequisites pr = new PreRequisites();
		DOMConfigurator.configure("log4j.xml");
		
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		LOGS.info(curDate);
		TestCaseName="UI_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
        st.portNO = portNO;
        String repName = "Tsales";
        
        LOGS.info("User selected Product: "+UiProduct+" for UiProduct Submission.");
		
		//trying to run a jenkins job 
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
				
		
				st.CPQMainMethod(Prods, Plans, repName, Resultsfolderpath);
        
		
		
		
		
	}

}
