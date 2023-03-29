package com.hibu.fulfillment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hibu.tests.MoveOrCopyFile;


public class SamiPreRequisites {

	//public static Logger LOGS = Logger.getLogger(PreRequisites.class.getName());
	public static Logger LOGS = LogManager.getLogger(SamiPreRequisites.class.getName());
	public  String Resultsfolderpath="",MBIDCons="",MBIDStatusCons="";
	static FileInputStream fs;
	public  WebDriver driver=null;
	public  String orderId="",AccountName,BusinessID,TestCaseName,DaywiseFolderpath,whichDay="";
	public  String websiteBasic="No";
	public  int rowCount,gettingRowNo;
	public  String day1BusinessId="";
	public  String quoteNo="";
	public  String productName="";
	public  String uiBusinessID="";

	//SamiPreRequisites SamiPreRequisites = new SamiPreRequisites();	
	//Exception Message
	public String ExceptionMsg="true";
	
		
	public  Properties SAMIConfig=loadPropertiesFiles("SAMIConfig");
	
	  public static String regardingfilesPath = "C://Automation//readingfiles//";
	  //public  String regardingfilesPath ="/usr/share/tomcat/bin/";
	
	public  Properties loadPropertiesFiles(String propFile) {
		Properties p = new Properties();
		
	
		try {
			LOGS.info(regardingfilesPath+"*********************&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		    LOGS.info(regardingfilesPath+"InputFiles/"+ propFile +".properties");
			fs = new FileInputStream(regardingfilesPath +"InputFiles/"+ propFile +".properties");
			
				p.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return p;
		
	}
	//**********************************************Creates test results*************************************
	public  String createFolder(String folderpath)throws Exception{
		
		//DOMConfigurator.configure("log4j.xml");
		Properties Obj=loadPropertiesFiles("Object");
		Obj.load(fs);
		String foldertimeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
		
		TestCaseName=folderpath+"_"+foldertimeStamp;
		Resultsfolderpath=regardingfilesPath+"OutputFiles/TestResults/"+TestCaseName;
		
		//Resultsfolderpath="C:\\Automation\\readingfiles\\OutputFiles\\TestResults\\"+folderpath+foldertimeStamp;
		
		File dir = new File(Resultsfolderpath);
	  	dir.mkdir();
		return Resultsfolderpath;
		
	}
	
	//*******************************************OutputSheet***********************************************************
	public void preparingOutputSheets() throws IOException, InterruptedException 
	{	
		LOGS.info("Executing preparingOutputSheets method");
		try{
			LOGS.info("Copying Files to Ensure that the Report files are blank");
			
			
			MoveOrCopyFile.copyFunction(regardingfilesPath+"Templates/TestResult.xlsx",Resultsfolderpath+"/TestResult.xlsx");
			MoveOrCopyFile.copyFunction(regardingfilesPath+"Templates/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
			//MoveOrCopyFile.copyFunction(regardingfilesPath+"Templates/ZephyrTestResult.xlsx",regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx");
				LOGS.info("Files copied successfully");
		}catch (Exception e) 
		{
			LOGS.info("There is some error while copying" );
		
		}
		
	}
	
public  WebElement SLocator(String slocator){
		
		String[] locatortype=loadPropertiesFiles("SamiObject").getProperty(slocator).split(">");
		String ortype=locatortype[0];
		String obj=locatortype[1];
		WebElement element=null;
		if(ortype.equalsIgnoreCase("NAME"))
		{
			element=driver.findElement(By.name(obj));
		}
		if(ortype.equalsIgnoreCase("ID"))
		{
			element=driver.findElement(By.id(obj));
		}
		if(ortype.equalsIgnoreCase("XPATH"))
		{
			element=driver.findElement(By.xpath(obj));
		}
		if(ortype.equalsIgnoreCase("CSS"))
		{
			element=driver.findElement(By.cssSelector(obj));
		}
		if(ortype.equalsIgnoreCase("LINKTEST"))
		{
			element=driver.findElement(By.linkText(obj));
		}
				
		return element ;
		
	}

public  String getInput() throws Exception {
	String Account = "";
	LOGS.info("Executing getInput Keyword Started");
	try {
		
		
		Properties Daywise= new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\InputFiles\\Daywise.properties");
		Daywise.load(input);
		DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty("Day1")+"ConsolidatedReport.xlsx";	
		String excelPath=DaywiseFolderpath;
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		for (int i = 1; i <= rowCount; i++)
		{
			Row row=finalSheet.getRow(i);
						
			LOGS.info("Checking if Day1 date is set and OH Status is Pass");	
						
							
				if(((row.getCell(6).getStringCellValue()).trim()).equals(TestCaseName))
				{
					LOGS.info("Iteration started");
					{
						orderId=(row.getCell(0).getStringCellValue()).trim();
						//orderId=orderId;
						AccountName=(row.getCell(3).getStringCellValue()).trim();
						BusinessID=(row.getCell(3).getStringCellValue()).trim();
							
							LOGS.info("Account Name :"+ AccountName);
							//ExportResults.exportTestResult("Account Name fetching,"+"Äccount for Fullfimment should be avaiable" +","+AccountName+" is available,"+"Pass"+","+"No Image");
							ExportResults.exportHighlevelResult("Account,"+"Äccount for Fullfimment should be avaiable" +","+AccountName+" is available,"+"Pass");
							return AccountName;
							
					}
				}
							
			}
			
			fileInput.close();
	}
		
	 catch (Exception t) {
	    	t.printStackTrace();
	         
	}
	
	LOGS.info("Executing getInput Keyword Complete");
 
  return Account;
}

public  String getInputDataToProcessDay2Day3(String prodId) throws Exception{
	LOGS.info("getInputDataToProcessDay2Day3 method Started ");

		FileInputStream inputExcel = new FileInputStream(new File(System.getProperty("user.dir")+"//OutputFiles//InputDataforDay2Day3Demo.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
        XSSFSheet inputsheet = workbook.getSheetAt(0);	
         rowCount=inputsheet.getLastRowNum();
        LOGS.info("rowCount ="+ rowCount);
      //for(int i=1;i<=inputsheet.getLastRowNum();i++)
		for (int i = 1; i <=rowCount; i++)
      {
        Row inputRow=inputsheet.getRow(i);


        try{      	
       	
         if( inputRow.getCell(13).getStringCellValue().trim().equalsIgnoreCase("Pending") && inputRow.getCell(0).getStringCellValue().equalsIgnoreCase(prodId)){	       
 	        LOGS.info("Product yet to fulfilled and getting 'i' value :"+i);
 	        gettingRowNo =i;
  	     // Cell cell3=inputRow.getCell(3);
 	     // day1BusinessId=NumberToTextConverter.toText(cell3.getNumericCellValue());
 	     // day1BusinessId=NumberToTextConverter.toText(inputRow.getCell(4).getNumericCellValue());
        	day1BusinessId=inputRow.getCell(4).getStringCellValue().trim();
	 	        LOGS.info("BusinessId :"+day1BusinessId);
	 	       break;
		      }
         else{
 	        LOGS.info("product is already fulfilled");
         }
        }
        catch(Exception e){
        	e.printStackTrace();
        	LOGS.info("Issue in getting business Id");
        }
      }
	
	
	return day1BusinessId;
	
}



 public static String getJiraTicket(String searchText, String folderName) throws Exception {
            
            
		String JiraTicket="";

		String excelPath=folderName;
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = finalWorkbook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		LOGS.info(rowCount);
            //Iterate rows
            System.out.println("Executing the Search Sheet Method to find the row based on the Search Text");
	        
		        for (int j = 1; j <= sheet.getLastRowNum(); j++)
		        {
		            XSSFRow row = sheet.getRow(j);
		            //Iterate columns
		            XSSFCell cell3 = row.getCell(3);
		           
		            //Search value based on cell type
			        if(searchText.equals(cell3.getStringCellValue())) {
						 XSSFCell cell14 = row.getCell(14);
			            JiraTicket=cell14.getStringCellValue();
			           break;
			        }
		        }
		        fileInput.close();
        return JiraTicket;
        }
 
 

	
	

}
