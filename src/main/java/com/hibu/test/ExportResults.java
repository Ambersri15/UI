package com.hibu.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportResults extends PreRequisites {
	public static Logger LOGS = LogManager.getLogger(ExportResults.class.getName());
	
	
	public static String ExportDay1DataForDay2InputSheet(String prodId,String prdName, String planName,String busID,String busName,String quoteNO,String quoteStatus,float budget,String ffSystem) throws Exception{
		
		  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputSheetForDay2Day3.xlsx";
		  
  try
  {
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			fileInput.close();
			
			String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			System.out.println(curDate);
			
			Row finalRow = finalSheet.createRow(rowsCount);		
			Cell cell0 = finalRow.createCell(0);
			cell0.setCellValue(prodId);
			
			Cell cell1 = finalRow.createCell(1);
			cell1.setCellValue(prdName);
	
			Cell cell2 = finalRow.createCell(2);
			cell2.setCellValue(planName);
			
			Cell cell3 = finalRow.createCell(3);
			cell3.setCellValue(busName);
			
			Cell cell4 = finalRow.createCell(4);
			cell4.setCellValue(busID);
			
			Cell cell5 = finalRow.createCell(5);
			cell5.setCellValue(budget);
			
			Cell cell6 = finalRow.createCell(6);
			cell6.setCellValue(quoteNO);
			
			if(prdName.startsWith("Website")) {			
			Cell cell7 = finalRow.createCell(7);
			cell7.setCellValue(prdName+"->"+planName);
			}else if(prdName.startsWith("Display")||prdName.startsWith("Search")||prdName.startsWith("Social")) {
				Cell cell7 = finalRow.createCell(7);
				cell7.setCellValue(prdName+"->"+budget);			
			}else {
				Cell cell7 = finalRow.createCell(7);
				cell7.setCellValue("-");
			}

			if(quoteStatus.equalsIgnoreCase("Submitted")) {			
			Cell cell13 = finalRow.createCell(13);
			cell13.setCellValue("Pending");
			}else {
				Cell cell13 = finalRow.createCell(13);
				cell13.setCellValue("Failed");				
			}

			Cell cell14 = finalRow.createCell(14);
			cell14.setCellValue(curDate);
			
			Cell cell17 = finalRow.createCell(17);
			cell17.setCellValue(ffSystem);		
	

			
			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info(Thread.currentThread() +"Exported Orders details info successfully ");
		}
  catch (Exception e) {
      LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
		}
  return "Pass";
}
	
	
	
	public void  ExportOrdersData(String FolderPath,String orderId,String TestCaseName,String businessId,String productName,String businessName, String domainName, String reportType) throws Exception{
					
				  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
				  String outputPath="";
				 
	              try
	              {
	            	  if(!orderId.contains("Issue"))
	  	            {
	  					if(reportType.equalsIgnoreCase("E2E"))
	  		  			{
	  	            		LOGS.info(Thread.currentThread() +"Exporting to Consolidated Sheet");
	  	            		outputPath = FolderPath;
	  	            		LOGS.info(Thread.currentThread() +"Path :"+outputPath);
	  	            		ExportQuote();          		
	  		  			}
	            	else
	            	{	
	            		LOGS.info(Thread.currentThread() +"Exporting to Ghost Input Sheet");
	            		outputPath = System.getProperty("user.dir")+"//InputFiles//OHInputData.xlsx";
	            	}
	            		
	  				FileInputStream fileInput = new FileInputStream(outputPath);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				fileInput.close();
					
					String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
					System.out.println(curDate);
					
					//System.out.println(java.time.LocalDate.now()); 
					LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount);
	  				Row finalRow = finalSheet.createRow(rowsCount);					
	  				Cell cell0 = finalRow.createCell(0);
	  				cell0.setCellValue(orderId);
	  				Cell cell1 = finalRow.createCell(1);
	  				cell1.setCellValue(businessId);
	  				Cell cell2 = finalRow.createCell(2);
	  				cell2.setCellValue(productName);
	  				Cell cell3 = finalRow.createCell(3);
	  				cell3.setCellValue(businessName);	
	  				Cell cell4 = finalRow.createCell(4);
	  				cell4.setCellValue(domainName);
	  				if(reportType.equalsIgnoreCase("E2E"))
	  				{
	  					Cell cell5 = finalRow.createCell(5);
		  				cell5.setCellValue("-");
		  				Cell cell6 = finalRow.createCell(6);
		  				cell6.setCellValue("-");
		  				Cell cell7 = finalRow.createCell(7);
		  				cell7.setCellValue("-");
		  				Cell cell8 = finalRow.createCell(8);
			  			cell8.setCellValue("-");
			  			Cell cell9 = finalRow.createCell(9);
			  			cell9.setCellValue("-");
			  			Cell cell10 = finalRow.createCell(10);
		  				cell10.setCellValue("-");
						Cell cell11 = finalRow.createCell(11);
		  				cell11.setCellValue(curDate);
						Cell cell12 = finalRow.createCell(12);
		  				cell12.setCellValue("-");
						Cell cell13 = finalRow.createCell(13);
		  				cell13.setCellValue("-");
		  				Cell cell14 = finalRow.createCell(14);
		  				cell14.setCellValue(TestCaseNum);
		  							  				
	  				}
	  				FileOutputStream fileOutput = new FileOutputStream(outputPath);
	  				finalWorkbook.write(fileOutput);
	  				fileOutput.close();
	  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
	  			}
			  }	
	              catch (Exception e) {
	                  LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
				}
		
	}
	
	public void  ExportQuote() throws Exception{
		
		  LOGS.info(Thread.currentThread() +"Executing ExportQuote Keyword");
		  String outputPath="";
		  
        try
        {
      	  Properties Daywise= new Properties();
      	  	FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/InputFiles/Daywise.properties");
				Daywise.load(input);
				DaywiseFolderpath=System.getProperty("user.dir")+"/OutputFiles/"+Daywise.getProperty("Day1")+"ConsolidatedReport.xlsx";			
      		LOGS.info(Thread.currentThread() +"Exporting to Consolidated Sheet");			
      		
      		outputPath = DaywiseFolderpath;
      		LOGS.info(Thread.currentThread() +"Path :"+outputPath);
      		
			
      		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			fileInput.close();
			LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount);
			Row finalRow = finalSheet.createRow(rowsCount);	
			Cell cell0 = finalRow.createCell(0);
			cell0.setCellValue(TestCaseName);
			Cell cell1 = finalRow.createCell(1);
			cell1.setCellValue(businessID);
			Cell cell2 = finalRow.createCell(2);
			cell2.setCellValue(businessName);
			Cell cell3 = finalRow.createCell(3);
			cell3.setCellValue(ProductName);
			Cell cell4 = finalRow.createCell(4);
			cell4.setCellValue(PlanName);
			Cell cell5 = finalRow.createCell(5);
			cell5.setCellValue(QuoteNumber);
			Cell cell6 = finalRow.createCell(6);
			cell6.setCellValue(QuoteStatus);
			Cell cell7 = finalRow.createCell(7);
			cell7.setCellValue(GhostAcctNo);
			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
		
	  }	
        catch (Exception e) {
            LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
		}

}
	
	public  void  CExportQuote() throws Exception{
		
		  LOGS.info(Thread.currentThread() +"Executing ExportQuote Keyword");
		  String outputPath="";
		  
      try
      {
    	  Properties Consolidated= new Properties();
    	  //	FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/InputFiles/Daywise.properties");
    	  //	Consolidated.load(input);
				//DaywiseFolderpath=System.getProperty("user.dir")+"/OutputFiles/"+Consolidated.getProperty("Day1")+"ConsolidatedReport.xlsx";	
    	  Consolidatedpath="C:\\Automation\\OutputFiles\\Day1SolutionsData.xlsx"; 
    		LOGS.info(Thread.currentThread() +"Exporting to Consolidated Sheet");			
    		
    		outputPath = Consolidatedpath;
    		LOGS.info(Thread.currentThread() +"Path :"+outputPath);
    		
			
    		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			fileInput.close();
			LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount);
			Row finalRow = finalSheet.createRow(rowsCount);	
			Cell cell0 = finalRow.createCell(0);
			cell0.setCellValue(TestCaseName);
			Cell cell1 = finalRow.createCell(1);
			cell1.setCellValue(businessID);
			Cell cell2 = finalRow.createCell(2);
			cell2.setCellValue(businessName);
			Cell cell3 = finalRow.createCell(3);
			cell3.setCellValue(ProductName);
			Cell cell4 = finalRow.createCell(4);
			cell4.setCellValue(PlanName);
			Cell cell5 = finalRow.createCell(5);
			cell5.setCellValue(QuoteNumber);
			Cell cell6 = finalRow.createCell(6);
			cell6.setCellValue(QuoteStatus);
			Cell cell7 = finalRow.createCell(7);
			cell7.setCellValue(TcmNo);
			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
		
	  }	
      catch (Exception e) {
          LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
		}

}
	public  void  ExportOrdersDaywise(String orderId,String businessId,String productName,String businessName, String domainName) throws Exception{
					
				  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
				  String outputPath="";
				  
	              try
	              {
	            	  Properties Daywise= new Properties();
	            	  	LOGS.info(Thread.currentThread() +"whichDay"+whichDay);
	  					FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
	  					Daywise.load(input);
	  					DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty(whichDay)+"ConsolidatedReport.xlsx";			
	            		LOGS.info(Thread.currentThread() +"Exporting to Consolidated Sheet");			
	            		
	            		outputPath = DaywiseFolderpath;
	            		LOGS.info(Thread.currentThread() +"Path :"+outputPath);
	            		
		  			
	            		
	  				FileInputStream fileInput = new FileInputStream(outputPath);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				fileInput.close();
					LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount);
	  				Row finalRow = finalSheet.createRow(rowsCount);					
	  				Cell cell0 = finalRow.createCell(0);
	  				cell0.setCellValue(orderId);
	  				Cell cell1 = finalRow.createCell(1);
	  				cell1.setCellValue(businessId);
	  				Cell cell2 = finalRow.createCell(2);
	  				cell2.setCellValue(productName);
	  				Cell cell3 = finalRow.createCell(3);
	  				cell3.setCellValue(businessName);	
	  				Cell cell4 = finalRow.createCell(4);
	  				cell4.setCellValue(domainName);
	  				Cell cell5 = finalRow.createCell(5);
	  				cell5.setCellValue("-");
		  			Cell cell6 = finalRow.createCell(6);
		  			cell6.setCellValue(TestCaseName);
		  			FileOutputStream fileOutput = new FileOutputStream(outputPath);
	  				finalWorkbook.write(fileOutput);
	  				fileOutput.close();
	  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
	  			
			  }	
	              catch (Exception e) {
	                  LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
				}
		
	}
	
/*
	public  void  updateTickettoReport(String TestCaseNum) throws Exception{
					
				  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
				  String outputPath1="";
				  String outputPath2="";
				  
	              try
	              {
	            	  	Properties Daywise= new Properties();
	            	  	LOGS.info(Thread.currentThread() +"whichDay"+whichDay);
	  					FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
	  					Daywise.load(input);
	  					if(whichDay.equalsIgnoreCase("Day1")||whichDay.equalsIgnoreCase("Day3"))
	  					{
	  						DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty(whichDay)+"ConsolidatedReport.xlsx";			
	  					}
	  					else
	  					{
	  						DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty("Day1")+"ConsolidatedReport.xlsx";			
	  					}
	  					LOGS.info(Thread.currentThread() +"Exporting to Consolidated Sheet");
	            		
	            		outputPath2 = DaywiseFolderpath;
	            		LOGS.info(Thread.currentThread() +"Path :"+outputPath2);
	            		outputPath1 = ConsFolderPath;
	            		LOGS.info(Thread.currentThread() +"Path :"+outputPath1);
	            	  	FileInputStream fileInput = new FileInputStream(outputPath1);
		  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
		  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
		  				int rowsCount=finalSheet.getLastRowNum();	
		  				fileInput.close();
						LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount);
		  				Row finalRow = finalSheet.createRow(rowsCount);					
		  				Cell cell5 = finalRow.createCell(5);
			  			cell5.setCellValue(TestCaseNum);
			  			FileOutputStream fileOutput1 = new FileOutputStream(outputPath1);
		  				finalWorkbook.write(fileOutput1);
		  				fileOutput1.close();
		  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
		  				FileInputStream fileInput2 = new FileInputStream(outputPath2);
		  				Workbook finalWorkbook2 = new XSSFWorkbook(fileInput2);
		  				XSSFSheet finalSheet2 = (XSSFSheet) finalWorkbook2.getSheetAt(0);
		  				int rowsCount2=finalSheet2.getLastRowNum();	
		  				fileInput2.close();
						LOGS.info(Thread.currentThread() +"Current Row COunt :"+rowsCount2);
		  				Row finalRow2 = finalSheet2.getRow(rowsCount2);		
		  				if(whichDay.equalsIgnoreCase("Day1")||whichDay.equalsIgnoreCase("Day3"))
		  				{
		  					Cell cell = finalRow2.createCell(5);
				  			cell.setCellValue(TestCaseNum);
		  				}
		  				else
		  				{
		  					//TestCaseName=SamiPreRequisites.TestCaseName;
		  					LOGS.info(Thread.currentThread() +"TestCaseName :"+ TestCaseName);
		  					rowsCount2=SearchExcel.searchSheet(TestCaseName,finalSheet2,6);
		  					finalRow2 = finalSheet2.getRow(rowsCount2);	
		  					Cell cell = finalRow2.createCell(7);
				  			cell.setCellValue(TestCaseNum);
		  				}
			  			FileOutputStream fileOutput2 = new FileOutputStream(outputPath2);
		  				finalWorkbook2.write(fileOutput2);
		  				fileOutput2.close();
		  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
	  			
			  }	
	              catch (Exception e) {
	                  LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
				}
		
	}*/
	

	public  void  exportTestResult(String testResult, String Resultsfolderpath) throws Exception{
					
				 /* LOGS.info(Thread.currentThread() +"Executing exportTestResult Keyword");
				  LOGS.info(Thread.currentThread() +testResult);
				  //String fileName= "C:\\Automation\\OutputFiles\\TestResult.xlsx"; 
				  String fileName= Resultsfolderpath+"\\TestResult.xlsx";
				  
				  String ScreenshotPath="";
	              try
	              {
	            	String[] testResultList=testResult.split(",");
	            	String Scenario=testResultList[0];
	            	String ExpectedBehaviour=testResultList[1];
	            	String ActualBehaviour=testResultList[2];
	            	String Status=testResultList[3];
	            	if(testResultList[4].equalsIgnoreCase("No Image"))
	            	{
	            		ScreenshotPath=testResultList[4];
	            	}
	            	else
	            	{
	            		ScreenshotPath=Resultsfolderpath+"\\"+testResultList[4];
	            	}
	            	
	            	LOGS.info(Thread.currentThread() +fileName);
	  				FileInputStream fileInput = new FileInputStream(fileName);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				LOGS.info(Thread.currentThread() +"Rows Present in the Test Results Sheet are :"+rowsCount);
	  				Row finalRow = finalSheet.createRow(rowsCount);		
	  				finalRow.setHeightInPoints(200);
	  				int row=finalRow.getRowNum();
	  				CellStyle cs = finalWorkbook.createCellStyle();
	  				cs.setWrapText(true);   //Wrapping text
	  				
	  				System.out.println("Current row number in test results:"+row);
	  				Cell cell0 = finalRow.createCell(0);
	  				cell0.setCellValue(Scenario);
	  				cell0.setCellStyle(cs);
	  				Cell cell1 = finalRow.createCell(1);
	  				cell1.setCellValue(ExpectedBehaviour);
	  				cell1.setCellStyle(cs);
	  				Cell cell2 = finalRow.createCell(2);
	  				cell2.setCellValue(ActualBehaviour);
	  				cell2.setCellStyle(cs);
	  				Cell cell3 = finalRow.createCell(3);
	  				cell3.setCellValue(Status);
	  				cell3.setCellStyle(cs);
	  				Cell cell4 = finalRow.createCell(4);
	  				if(!ScreenshotPath.equalsIgnoreCase("No Image"))
	  				{
	  				   InputStream inputStream = new FileInputStream(ScreenshotPath);
	  				   //Get the contents of an InputStream as a byte[].
	  				   byte[] bytes = IOUtils.toByteArray(inputStream);
	  				   //Adds a picture to the workbook
	  				   int pictureIdx = finalWorkbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
	  				   //close the input stream
	  				   inputStream.close();

	  				   //Returns an object that handles instantiating concrete classes
	  				 CreationHelper createHelper = finalWorkbook.getCreationHelper();
	  				   //Creates the top-level drawing patriarch.
	  				   Drawing drawing = finalSheet.createDrawingPatriarch();

	  				   //Create an anchor that is attached to the work sheet
	  				   ClientAnchor anchor = createHelper.createClientAnchor();
	  				   //set top-left corner for the image
	  				   anchor.setCol1(4);
	  				   anchor.setRow1(row);

	  				   //Creates a picture
	  				   Picture pict = drawing.createPicture(anchor, pictureIdx);
	  				   //Reset the image to the original size
	  				  pict.resize(0.3);
	  				
	  				}	
	  				else
	  				{
	  					cell4.setCellValue("-");
	  				}
	  				FileOutputStream fileOutput = new FileOutputStream(fileName);
	  				finalWorkbook.write(fileOutput);
	  				fileInput.close();
	  				fileOutput.close();
	  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
	  				LOGS.info(Thread.currentThread() +"Exporting Test Data for Zephyr Sheet ");
	  				ZephyrTestResult(testResult);
	  			}
	              catch (Exception e) {
	            	  e.printStackTrace();
	                  LOGS.info(Thread.currentThread() +"Error in the Result FIle Kindly Rerun : "+ e.getMessage());
				}
		*/
		/*TestCaseName =n
		Resultsfolderpath=regardingfilesPath+"OutputFiles/TestResults/"+TestCaseName;
		LOGS.info("Resultsfolderpath:bfr "+Resultsfolderpath);*/
		
		
		LOGS.info(Thread.currentThread() +"Exporting Test Data for Zephyr Sheet ");
		LOGS.info(Thread.currentThread() +"Resultsfolderpath: "+Resultsfolderpath);
			ZephyrTestResult(testResult,Resultsfolderpath);
	}
	

	public  void  ZephyrTestResult(String testResult, String Resultsfolderpath) throws Exception{
					
		  LOGS.info(Thread.currentThread() +"Executing exportTestResult Keyword_resultfolderpath Value : "+Resultsfolderpath);
		  LOGS.info(Thread.currentThread() +testResult);
		  String fileName= Resultsfolderpath+"/ZephyrTestResult.xlsx";				 
		  //String fileName= regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx"; 
				 LOGS.info(Thread.currentThread() +"zephyr path  :"+ fileName);
				 // String fileName2="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
				  String ScreenshotPath="";
	              try
	              {
	            	String[] testResultList=testResult.split(",");
	            	String Scenario=testResultList[0];
	            	String ExpectedBehaviour=testResultList[1];
	            	String ActualBehaviour=testResultList[2];
	            	String Status=testResultList[3];
	            	if(testResultList[4].equalsIgnoreCase("No Image"))
	            	{
	            		ScreenshotPath=System.getProperty("user.dir")+"\\Templates\\NA.PNG";
	            	}
	            	else
	            	{
	            		ScreenshotPath=Resultsfolderpath+"\\"+testResultList[4];
	            	}
	            	
	            	LOGS.info(Thread.currentThread() +fileName);
	  				FileInputStream fileInput = new FileInputStream(fileName);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				LOGS.info(Thread.currentThread() +"Rows Present in the Test Results Sheet are :"+rowsCount);
	  				Row finalRow = finalSheet.createRow(rowsCount);		
	  				finalRow.setHeightInPoints(200);
	  				int row=finalRow.getRowNum();
	  				CellStyle cs = finalWorkbook.createCellStyle();
	  				cs.setWrapText(true);   //Wrapping text
	  				
	  				System.out.println("Current row number in test results:"+row);
	  				Cell cell0 = finalRow.createCell(0);
	  				cell0.setCellValue(Scenario);
	  				cell0.setCellStyle(cs);
	  				Cell cell1 = finalRow.createCell(1);
	  				cell1.setCellValue(ExpectedBehaviour);
	  				cell1.setCellStyle(cs);
	  				Cell cell2 = finalRow.createCell(2);
	  				cell2.setCellValue(ActualBehaviour);
	  				cell2.setCellStyle(cs);
	  				Cell cell3 = finalRow.createCell(3);
	  				cell3.setCellValue(Status);
	  				cell3.setCellStyle(cs);
	  				Cell cell4 = finalRow.createCell(4);
	  				cell4.setCellValue(ScreenshotPath);
	  				
	  				FileOutputStream fileOutput = new FileOutputStream(fileName);
	  				finalWorkbook.write(fileOutput);
	  				fileInput.close();
	  				fileOutput.close();
	  				LOGS.info(Thread.currentThread() +"Exported Step Details Successfully");
	  			}
	              catch (Exception e) {
	            	  e.printStackTrace();
	                  LOGS.info(Thread.currentThread() +"Error in the Result FIle Kindly Rerun : "+ e.getMessage());
				}
		
	}
	
	public static void  exportHighlevelResult(String testResult) throws Exception{
					
				  LOGS.info(Thread.currentThread() +"Executing exportHighlevelResult Keyword");
				  LOGS.info(Thread.currentThread() +testResult);
				  String fileName= "C:\\Automation\\OutputFiles\\HighlevelResults.xlsx"; 
	              try
	              {
	            	String[] testResultList=testResult.split(",");
	            	String Scenario=testResultList[0];
	            	String ExpectedBehaviour=testResultList[1];
	            	String ActualBehaviour=testResultList[2];
	            	String Status=testResultList[3];
	            	         	
	            	LOGS.info(Thread.currentThread() +fileName);
	  				FileInputStream fileInput = new FileInputStream(fileName);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				LOGS.info(Thread.currentThread() +"Rows Present in the Test Results Sheet are :"+rowsCount);
	  				Row finalRow = finalSheet.createRow(rowsCount);					
	  				Cell cell0 = finalRow.createCell(0);
	  				cell0.setCellValue(Scenario);
	  				Cell cell1 = finalRow.createCell(1);
	  				cell1.setCellValue(ExpectedBehaviour);
	  				Cell cell2 = finalRow.createCell(2);
	  				cell2.setCellValue(ActualBehaviour);
	  				Cell cell3 = finalRow.createCell(3);
	  				cell3.setCellValue(Status);
	  				FileOutputStream fileOutput = new FileOutputStream(fileName);
	  				finalWorkbook.write(fileOutput);
	  				fileInput.close();
	  				fileOutput.close();
	  				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
	  			}
	              catch (Exception e) {
	            	  e.printStackTrace();
	                  LOGS.info(Thread.currentThread() +"Error in the Result FIle Kindly Rerun : "+ e.getMessage());
				}
		
	}
	
	
	public static String ExportOrdersDataDay3(String FolderPath, String category, String productNameUpdated, String reportType) throws Exception{
		
		  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
		  String outputPath=FolderPath;
		  
        try
        {
      	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum();	
			fileInput.close();
			
			String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			System.out.println(curDate);
			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(reportType.equalsIgnoreCase("E2E"))
			{

				Cell cell10 = finalRow.createCell(10);
				cell10.setCellValue(category);
				Cell cell11 = finalRow.createCell(11);
				cell11.setCellValue("-");
				Cell cell13 = finalRow.createCell(13);
				cell13.setCellValue(curDate);
			}
			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
		}
        catch (Exception e) {
            LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
		}
        return "Pass";
}
	
	
	public static void exportYextAccounts(String testResult) throws Exception	{


		
		  LOGS.info(Thread.currentThread() +"Executing exportYextAccounts Keyword");
		  LOGS.info(Thread.currentThread() +testResult);
		  String fileName= "C:\\Automation\\OutputFiles\\YextTestResult.xlsx"; 
		 // String fileName= Resultsfolderpath+"\\YextTestResult.xlsx";
		  
		  String ScreenshotPath="";
	    try
	    {
	  	String[] testResultList=testResult.split(",");
	  	String BusinessName=testResultList[0];
	  	String StreetAddress=testResultList[1];
	  	String City=testResultList[2];
	  	String YextState=testResultList[3];
	  	String ZipCode=testResultList[4];
		String BusinessPhone=testResultList[5];
		String ListingsCategory=testResultList[6];
	  	
	  	
	  	LOGS.info(Thread.currentThread() +fileName);
			FileInputStream fileInput = new FileInputStream(fileName);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			LOGS.info(Thread.currentThread() +"Rows Present in the Test Results Sheet are :"+rowsCount);
			Row finalRow = finalSheet.createRow(rowsCount);		
			finalRow.setHeightInPoints(200);
			int row=finalRow.getRowNum();
			CellStyle cs = finalWorkbook.createCellStyle();
			cs.setWrapText(true);   //Wrapping text
			
			System.out.println("Current row number in test results:"+row);
			Cell cell0 = finalRow.createCell(0);
			cell0.setCellValue(BusinessName);
			cell0.setCellStyle(cs);
			
			Cell cell1 = finalRow.createCell(1);
			cell1.setCellValue(StreetAddress);
			cell1.setCellStyle(cs);
			
			Cell cell2 = finalRow.createCell(2);
			cell2.setCellValue(City);
			cell2.setCellStyle(cs);
			
			Cell cell3 = finalRow.createCell(3);
			cell3.setCellValue(YextState);
			cell3.setCellStyle(cs);
			
			Cell cell4 = finalRow.createCell(4);
			cell4.setCellValue(ZipCode);
			cell4.setCellStyle(cs);
			
			Cell cell5 = finalRow.createCell(5);
			cell5.setCellValue(BusinessPhone);
			cell5.setCellStyle(cs);
			
			Cell cell6 = finalRow.createCell(6);
			cell6.setCellValue(ListingsCategory);
			cell6.setCellStyle(cs);
			
			
			
			
			
			FileOutputStream fileOutput = new FileOutputStream(fileName);
			finalWorkbook.write(fileOutput);
			fileInput.close();
			fileOutput.close();
			LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
			LOGS.info(Thread.currentThread() +"Exporting Test Data for Zephyr Sheet ");
			
		}
	    catch (Exception e) {
	  	  e.printStackTrace();
	        LOGS.info(Thread.currentThread() +"Error in the Result FIle Kindly Rerun : "+ e.getMessage());
		}



	}
		/*public static void  ExportOrdersDataSamiFF(String Account, String FolderName) throws Exception{
			
			  LOGS.info(Thread.currentThread() +"Executing ExportOrdersData Keyword");
			  String outputPath="";
			  try
			  {     		
				FileInputStream fileInput = new FileInputStream(FolderName);
				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
				XSSFSheet finalSheet = (XSSFSheet) finalWorkbook.getSheetAt(0);
				
				fileInput.close();
				
				String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
				System.out.println(curDate);
				
				int rowsCount = SearchExcel.searchSheet(Account,finalSheet,3);			
					Row finalRow = finalSheet.getRow(rowsCount);	
					Cell cell12 = finalRow.createCell(12);
					cell12.setCellValue(curDate);
				
				FileOutputStream fileOutput = new FileOutputStream(FolderName);
				finalWorkbook.write(fileOutput);
				fileOutput.close();
				LOGS.info(Thread.currentThread() +"Exported Orders info successfully ");
			}
            catch (Exception e) {
                LOGS.info(Thread.currentThread() +"Error : "+ e.getMessage());
			}
	
}*/
	
		
}
