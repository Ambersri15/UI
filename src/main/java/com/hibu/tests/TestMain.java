/*package com.hibu.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import com.hibu.tests.SalesforceTasks;

import com.hibu.orderplacement.model.OrderPlacementObj;

public class TestMain extends PreRequisites {
	
	static String testId;
	static String sampleId;

	public static void main(String[] args) throws Exception {
	
		String id = fetchJiraData();
		System.out.println("ID : "+id);
		OrderPlacementObj obj = new OrderPlacementObj();
		TestNG runner=new TestNG();
	    // Create a list of String
	    List<String> suitefiles=new ArrayList<String>();
	    // Add xml file which you have to execute
	    //suitefiles.add("C:\\Automation\\CPQ_Regression\\Framework\\testng.xml");    
	    suitefiles.add("C:\\Automation\\UiDemo\\demo\\testng.xml"); 
	    //suitefiles.add("C:\\UiDemo\\Demofl\\demo\\testng.xml"); 
	    
	    // now set xml file for execution
	    runner.setTestSuites(suitefiles);
	    runner.run();
	    
	    String businessId = businessID;
	    String accountName = SalesforceTasks.BusinessNameQuoteDetls;
	    obj.setNewProductName(accountName);
	    obj.setProcess(businessId);
	    System.out.println("BusinessId :"+ businessId +";"+ businessID +";"+obj.getProcess());
	    System.out.println("AccountName :"+ accountName +";"+ SalesforceTasks.BusinessNameQuoteDetls +";"+obj.getNewProductName());
	   // BusinessNameQuoteDetls
	   // businessID;
	   // 

	}
	
	public static String fetchJiraData() throws Exception{
				
			//Fetching the data from JiraTestIdInput file based on the testcasenumber
			FileInputStream inputExcel = new FileInputStream(new File(System.getProperty("user.dir")+"//InputFiles//JiraTestIdInput.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
	        XSSFSheet inputsheet = workbook.getSheetAt(0);	
	        int rowCount=inputsheet.getLastRowNum();
	        //LOGS.info("rowCount ="+ rowCount);
	      for(int i=1;i<=rowCount;i++)
	      {
		       // LOGS.info("inside =");
	        Row row=inputsheet.getRow(i);
	        //.getCell(i).getStringCellValue().trim();
	        
	        Cell cell=row.getCell(0);

			//LOGS.info("Cell Value is: "+cellValue);
			//if(cellValue.equalsIgnoreCase(CurrentProd)) 
	        //LOGS.info("inside =");

	        try{

					
	   	        	testId=row.getCell(1).getStringCellValue().trim();
	   	        	
					sampleId=row.getCell(1).getStringCellValue().trim();
	        
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	//LOGS.info("testcase numbrer not matced ");
	        }
	      }
		
		
		return testId;
		
	}
	

}
*/