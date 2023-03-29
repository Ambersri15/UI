package com.hibu.fulfillment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.fulfillment.SamiPreRequisites;

public class ExportResults extends SamiPreRequisites {
	
/*
	public static void  SAPExportOrdersDaywise() throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath="";
		  
        try
        {
      	  Properties Daywise= new Properties();
      	  	LOGS.info("whichDay"+whichDay);
				FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
				Daywise.load(input);
				DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty(whichDay)+"ConsolidatedReport.xlsx";			
      		LOGS.info("Exporting to Consolidated Sheet");			
      		
      		outputPath = DaywiseFolderpath;
      		LOGS.info("Path :"+outputPath);
      		FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			fileInput.close();
			LOGS.info("Current Row COunt :"+rowsCount);
			Row finalRow = finalSheet.createRow(rowsCount);	
		
				Cell cell11 = finalRow.createCell(0);
				cell11.setCellValue(MBID);
								
				for(int i=0;i<11;i++)
				{
					int j=i*2;
					int k=i*2+1;
					//String SKUparams=SKUdata.get(i);
					LOGS.info("S"+SKUdata.get(i));
					//String params[]=SKUparams.split(">>");
					rowsCount=finalSheet.getLastRowNum()+1;	
					finalRow = finalSheet.createRow(rowsCount);	
					Cell cell6 = finalRow.createCell(6);
					 cell6.setCellValue(SKUdata.get(i));
					Cell cell7 = finalRow.createCell(7);
					cell7.setCellValue("-");
					Cell cell8= finalRow.createCell(8);
					cell8.setCellValue(PlanAmountdetail.get(j));
					Cell cell9= finalRow.createCell(9);
					cell9.setCellValue(PlanAmountdetail.get(k));
				
				}
			
			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		
	  }	
        catch (Exception e) {
            LOGS.info("Error : "+ e.getMessage());
		}

}
	
*/
	public  void  exportTestResult(String testResult) throws Exception{
					
				  LOGS.info("Executing exportTestResult Keyword");
				  LOGS.info(testResult);
				  String fileName= "C:\\Automation\\OutputFiles\\TestResult.xlsx"; 
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
	            	
	            	LOGS.info(fileName);
	  				FileInputStream fileInput = new FileInputStream(fileName);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				LOGS.info("Rows Present in the Test Results Sheet are :"+rowsCount);
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
	  					System.out.println("ScreenshotPath :"+ScreenshotPath);
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
	  				LOGS.info("Exported Orders info successfully ");
	  				LOGS.info("Exporting Test Data for Zephyr Sheet ");
	  				ZephyrTestResult(testResult);
	  			}
	              catch (Exception e) {
	            	  e.printStackTrace();
	                  LOGS.info("Error in the Result FIle Kindly Rerun : "+ e.getMessage());
				}
		
	}
	
	public  void  ZephyrTestResult(String testResult) throws Exception{

		
		  LOGS.info("Executing export ZephyrTestResult Keyword");
		  LOGS.info(testResult);
			 String fileName= regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx"; 
			 LOGS.info("zephyr path  :"+ fileName);
		 // String fileName= "C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx"; 
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
      	
      	LOGS.info(fileName);
			FileInputStream fileInput = new FileInputStream(fileName);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=finalSheet.getLastRowNum()+1;	
			LOGS.info("Rows Present in the Test Results Sheet are :"+rowsCount);
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
			LOGS.info("Exported Step Details Successfully");
		}
        catch (Exception e) {
      	  e.printStackTrace();
            LOGS.info("Error in the Result FIle Kindly Rerun : "+ e.getMessage());
		}


	}
	
	public static void  exportHighlevelResult(String testResult) throws Exception{
					
				  LOGS.info("Executing exportHighlevelResult Keyword");
				  LOGS.info(testResult);
				  String fileName= "C:\\Automation\\OutputFiles\\HighlevelResults.xlsx"; 
	              try
	              {
	            	String[] testResultList=testResult.split(",");
	            	String Scenario=testResultList[0];
	            	String ExpectedBehaviour=testResultList[1];
	            	String ActualBehaviour=testResultList[2];
	            	String Status=testResultList[3];
	            	         	
	            	LOGS.info(fileName);
	  				FileInputStream fileInput = new FileInputStream(fileName);
	  				Workbook finalWorkbook = new XSSFWorkbook(fileInput);
	  				Sheet finalSheet = finalWorkbook.getSheetAt(0);
	  				int rowsCount=finalSheet.getLastRowNum()+1;	
	  				LOGS.info("Rows Present in the Test Results Sheet are :"+rowsCount);
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
	  				LOGS.info("Exported Orders info successfully ");
	  			}
	              catch (Exception e) {
	            	  e.printStackTrace();
	                  LOGS.info("Error in the Result FIle Kindly Rerun : "+ e.getMessage());
				}
		
	}
	
	
	public static String ExportOrdersDataDay3(String FolderPath, String category, String productNameUpdated, String reportType) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
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
			LOGS.info("Exported Orders info successfully ");
		}
        catch (Exception e) {
            LOGS.info("Error : "+ e.getMessage());
		}
        return "Pass";
}
	
	public static String ExportSamiDataToInputSheet(String MBID, String product, int rowNO) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3.xlsx";
		  
      try
      {
    	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=rowNO;	
			fileInput.close();
			
			String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			System.out.println(curDate);
			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(product.startsWith("ASX"))
			{	Cell cell8 = finalRow.createCell(8);
				cell8.setCellValue(MBID);
			}else {
				Cell cell8 = finalRow.createCell(8);
				cell8.setCellValue("-");
			}
			if(product.startsWith("MRRX"))
			{	Cell cell9 = finalRow.createCell(9);
				cell9.setCellValue(MBID);
			}else {
				Cell cell9 = finalRow.createCell(9);
				cell9.setCellValue("-");
			}
			if(product.startsWith("WRBI"))
			{	Cell cell10 = finalRow.createCell(10);
			cell10.setCellValue(MBID);
			}else {
				Cell cell10 = finalRow.createCell(10);
				cell10.setCellValue("-");
			}
			if(product.startsWith("SOCIAL"))
			{	Cell cell11 = finalRow.createCell(11);
			cell11.setCellValue(MBID);
			}else {
				Cell cell11 = finalRow.createCell(11);
				cell11.setCellValue("-");
			}
			if(product.startsWith("WRD"))
			{	Cell cell12 = finalRow.createCell(12);
			cell12.setCellValue(MBID);
			}else {
				Cell cell12 = finalRow.createCell(12);
				cell12.setCellValue("-");
			}


				Cell cell15 = finalRow.createCell(15);
				cell15.setCellValue(curDate);
						FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		}
      catch (Exception e) {
          LOGS.info("Error : "+ e.getMessage());
		}
      return "Pass";
}
	
	public static String ExportSamiDataToInputSheetDemo(String MBID, String product, int rowNO) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3Demo.xlsx";
		  
    try
    {
  	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=rowNO;	
			fileInput.close();
			
			String curDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			System.out.println(curDate);
			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(product.startsWith("ASX"))
			{	Cell cell8 = finalRow.createCell(8);
				cell8.setCellValue(MBID);
			}else {
				Cell cell8 = finalRow.createCell(8);
				cell8.setCellValue("-");
			}
			if(product.startsWith("MRRX"))
			{	Cell cell9 = finalRow.createCell(9);
				cell9.setCellValue(MBID);
			}else {
				Cell cell9 = finalRow.createCell(9);
				cell9.setCellValue("-");
			}
			if(product.startsWith("WRBI"))
			{	Cell cell10 = finalRow.createCell(10);
			cell10.setCellValue(MBID);
			}else {
				Cell cell10 = finalRow.createCell(10);
				cell10.setCellValue("-");
			}
			if(product.startsWith("SOCIAL"))
			{	Cell cell11 = finalRow.createCell(11);
			cell11.setCellValue(MBID);
			}else {
				Cell cell11 = finalRow.createCell(11);
				cell11.setCellValue("-");
			}
			if(product.startsWith("WRD"))
			{	Cell cell12 = finalRow.createCell(12);
			cell12.setCellValue(MBID);
			}else {
				Cell cell12 = finalRow.createCell(12);
				cell12.setCellValue("-");
			}


				Cell cell15 = finalRow.createCell(15);
				cell15.setCellValue(curDate);
						FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		}
    catch (Exception e) {
        LOGS.info("Error : "+ e.getMessage());
		}
    return "Pass";
}
	

	
	public static String ExportDay1DataForDay2InputSheet(String prodId,String prdName, String planName,String busID,String busName,String quoteNO,String quoteStatus,float budget,String ffSystem) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3.xlsx";
		  
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
			LOGS.info("Exported Orders details info successfully ");
		}
catch (Exception e) {
    LOGS.info("Error : "+ e.getMessage());
		}
return "Pass";
}
	
	public static String ExportSamiStatusToInputSheetDemo(String status, int rowNO) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3Demo.xlsx";
		  
  try
  {
	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=rowNO;	
			fileInput.close();

			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(status.trim().equalsIgnoreCase("Keyword Incompleted,Bill Pending"))
			{	
			Cell cell13 = finalRow.createCell(13);
			cell13.setCellValue("Fulfilled");
			}else {
				Cell cell13 = finalRow.createCell(13);
				cell13.setCellValue(status);
			}
			
			

			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		}
  catch (Exception e) {
      LOGS.info("Error : "+ e.getMessage());
		}
  return "Pass";
}
	
	public static String ExportNonSamiStatusToInputSheetDemo(String status, int rowNO) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3Demo.xlsx";
		  
try
{
	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=rowNO;	
			fileInput.close();

			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(status.trim().equalsIgnoreCase("Pass"))
			{	
			Cell cell13 = finalRow.createCell(13);
			cell13.setCellValue("Fulfilled");
			}else {
				Cell cell13 = finalRow.createCell(13);
				cell13.setCellValue(status);
			}
			
			

			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		}
catch (Exception e) {
    LOGS.info("Error : "+ e.getMessage());
		}
return "Pass";
}
	
	public static String ExportSamiStatusToInputSheet(String status, int rowNO) throws Exception{
		
		  LOGS.info("Executing ExportOrdersData Keyword");
		  String outputPath=System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3.xlsx";
		  
    try
    {
  	           		
			FileInputStream fileInput = new FileInputStream(outputPath);
			Workbook finalWorkbook = new XSSFWorkbook(fileInput);
			Sheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowsCount=rowNO;	
			fileInput.close();

			
			Row finalRow = finalSheet.getRow(rowsCount);					
			if(status.trim().equalsIgnoreCase("Keyword Incompleted,Bill Pending"))
			{	
			Cell cell13 = finalRow.createCell(13);
			cell13.setCellValue("Fulfilled");
			}else {
				Cell cell13 = finalRow.createCell(13);
				cell13.setCellValue(status);
			}
			
			

			FileOutputStream fileOutput = new FileOutputStream(outputPath);
			finalWorkbook.write(fileOutput);
			fileOutput.close();
			LOGS.info("Exported Orders info successfully ");
		}
    catch (Exception e) {
        LOGS.info("Error : "+ e.getMessage());
		}
    return "Pass";
}
	
}
