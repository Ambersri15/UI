package com.hibu.tests;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hibu.tests.SamiPreRequisites;
import com.hibu.tests.ScreenshotPrinter;
import java.util.*;


public class SamiFulfillment extends SamiPreRequisites{
	public String searchAccount,samiLoginResult,MBID,productType,result,gParentWindow;
	public String MBID1,MBID2,MBID3,product1,product2,product3,product,status;
	public String ActRes,ExpRes,Status,ImagePath,ImageName,ImgName,onlineOrderFormResults;
	public String mediabuyStatus;
	
	SamiPreRequisites SamiPreRequisites = new SamiPreRequisites();
	ExportResults ExportResults =  new ExportResults();
	ScreenshotPrinter ScreenshotPrinter = new ScreenshotPrinter();
	
	public  String samiLogin() throws Exception{
		
		
try{
			
			String path = System.getProperty("user.dir")+ "\\InputFiles\\Order.properties";
			LOGS.info(path);
			Properties OR=SamiPreRequisites.loadPropertiesFiles("Order");
			
			LOGS.info(OR.getProperty("sfUserName"));
			
			LOGS.info("Creating the Properties file to store the current row from the inputfile");
			LOGS.info("Creating the Excel Input file");
			       
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(OR.getProperty("samitestsite"));
			LOGS.info("URL launched");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			SLocator("samiUser").sendKeys(OR.getProperty("samiUserName"));
			SLocator("samiPwd").sendKeys(OR.getProperty("samiUserPwd"));
			SLocator("samiLogin").click();
			LOGS.info("Login button Clicked");
			Thread.sleep(6000);
			ActRes=driver.getCurrentUrl();
			ExpRes="SAMI page should contain the URL sami ";
			ImageName="samiLogin";
			//ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
			//To check the Scenario Status	        
			if(ActRes.contains("sami")) 
			{
				samiLoginResult="Pass";
				LOGS.info("Able to Login to Sami");
				Status="Pass";
/*				ExportResults.exportTestResult("Login to SAMI,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				LOGS.info("Login to SAMI,"+ExpRes+","+ActRes+","+Status);*/
				return samiLoginResult;
				
			}
			else
			{
				samiLoginResult="Fail";
				Status="Fail";
				ExportResults.exportTestResult("Login to SAMI,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				LOGS.info("Login to SAMI,"+ExpRes+","+ActRes+","+Status);
				return samiLoginResult;
			}
						
		}
		catch(Exception e)
		{	
			samiLoginResult="False";
			LOGS.info("Unable to Login to Sami");
			
			return samiLoginResult;
			
		}
			
	}
	
//*****************************************************SAMI Account search******************************************	
		
	public  String accountSearch(String Account, String ProductName) throws Exception{
		
		try {
			LOGS.info("Keyword to Fetch MBID by selecting the Product for the combo Orders");
		LOGS.info("searching the account in SAMI"+Account);
		String Loading=driver.findElement(By.xpath("//div[@id='disabledZone']")).getAttribute("style");
		if(Loading.contains("visibility: visible;"))
		{
			Thread.sleep(60000);
			Loading=driver.findElement(By.xpath("//div[@id='disabledZone']")).getAttribute("style");
			if(Loading.contains("visibility: visible;"))
			{
				Thread.sleep(60000);
				Loading=driver.findElement(By.xpath("//div[@id='disabledZone']")).getAttribute("style");
				if(Loading.contains("visibility: visible;"))
				{
					Thread.sleep(4000);
					if(Loading.contains("visibility: visible;"))
					{
						Thread.sleep(4000);
					}
				}
				
			}
		}
		
		LOGS.info("Entered the Advertiser Name");
		SLocator("MedBuyAdvName").clear();
		SLocator("MedBuyAdvName").sendKeys(Account);
		/*driver.findElement(By.xpath("//input[@id='mbToStatusDate']")).clear();
		driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/span")).click();*/
		WebElement ProductSelect=driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/select"));
		LOGS.info("Clicking on the Advertiser Label, to avoid failures when Business Name is huge");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//input[@id='mbProduct']")).click();
		Thread.sleep(30000);
		Select multiProdSel=new Select(ProductSelect);
		multiProdSel.deselectAll();
		Thread.sleep(30000);
		multiProdSel.selectByVisibleText(ProductName);
		Thread.sleep(30000);
		driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/span")).click();
		Thread.sleep(8000);
		LOGS.info("Clicked on Search Button");
		SLocator("mbSearchBtn").click();
		Thread.sleep(20000);
		if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
		{
			LOGS.info("Account found");
		}
		else
		{
			LOGS.info("Waiting for one minute");
			Thread.sleep(60000);
			
			SLocator("mbSearchBtn").click();
			LOGS.info("Clicked on Search Button");
			Thread.sleep(20000);
			if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
			{
				LOGS.info("Account found");
			}
			else
			{
				LOGS.info("Waiting for Six minutes");
				Thread.sleep(36000);
				
				SLocator("mbSearchBtn").click();
				LOGS.info("Clicked on Search Button");
				Thread.sleep(20000);
				if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
				{
					LOGS.info("Account found");
				}
				else
				{
					LOGS.info("Waiting for 4 minutes");
					Thread.sleep(240000);
					
					SLocator("mbSearchBtn").click();
					LOGS.info("Clicked on Search Button");
					Thread.sleep(20000);
					if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
					{
						LOGS.info("Account found");
					}
					else
					{
						LOGS.info("Waiting for 4 minutes");
						Thread.sleep(240000);
						
						SLocator("mbSearchBtn").click();
						LOGS.info("Clicked on Search Button");
						Thread.sleep(20000);
						if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
						{
							LOGS.info("Account found");
						}
						else
						{	
							LOGS.info("Waiting for 4 minutes");
							Thread.sleep(240000);
							
							SLocator("mbSearchBtn").click();
							LOGS.info("Clicked on Search Button");
							Thread.sleep(20000);
							if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
							{
								LOGS.info("Account found");
							}
							else
							{
								LOGS.info("Waited Long, Account did not reach SAMI, hence quitting the Test Case!");
							
								return "Fail";
							}
						}
					}
				}
				
			}
		}

		
		 MBID=SLocator("mbIDR").getText();
		 LOGS.info("MBID is :"+MBID);
		Thread.sleep(2000);
		LOGS.info("ProductType is :"+productType);
		 productType=SLocator("ProductType").getText();
			Thread.sleep(2000);		
		//	WebDriverWait wait=new WebDriverWait(driver, 20);
			// wait.until(ExpectedConditions.elementToBeClickable(SLocator("AdvrName")));
			 LOGS.info("Clicked on Advertiser Name Link");
		SLocator("AdvrName").click();
		Thread.sleep(4000);
		ImageName="Account";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		Status="Pass";
		ActRes="Account Info Page is Naviageted for : "+MBID;
		ExpRes="Account info for the MBID is navigated";
		ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			searchAccount="fail";
			LOGS.info("Issue in Search Account");
			Status="Fail";
			ActRes="Exception caused due to Network Issue";
			ExpRes="Account info for the MBID is navigated";
			ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
			return "Fail";
			
		}
		
		return MBID;
	}

	public String accountSearch(String Account, String ProductName,String initialStartDate) throws Exception{
		
		try {
			LOGS.info("Keyword to Fetch MBID by selecting the Product for the combo Orders");
		LOGS.info("searching the account in SAMI"+Account);
		LOGS.info("Entered the Advertiser Name");
		SLocator("MedBuyAdvName").clear();
		SLocator("MedBuyAdvName").sendKeys(Account);
		/*driver.findElement(By.xpath("//input[@id='mbFromStatusDate']")).clear();
		driver.findElement(By.xpath("//input[@id='mbFromStatusDate']")).sendKeys(initialStartDate);*/
		driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/span")).click();
		WebElement ProductSelect=driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[1]/select"));
		Select multiProdSel=new Select(ProductSelect);
		multiProdSel.deselectAll();
		Thread.sleep(2000);
		multiProdSel.selectByVisibleText(ProductName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='mbSearch']/div[2]/div[1]/div/div[1]/div[2]/span")).click();
		Thread.sleep(2000);
		LOGS.info("Clicked on Search Button");
		SLocator("mbSearchBtn").click();
		Thread.sleep(20000);
		if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
		{
			LOGS.info("Account found");
		}
		else
		{
			Thread.sleep(10000);
			LOGS.info("Clicked on Search Button");
			SLocator("mbSearchBtn").click();
			Thread.sleep(20000);
			if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
			{
				LOGS.info("Account found");
			}
			else
			{
				Thread.sleep(20000);
				LOGS.info("Clicked on Search Button");
				SLocator("mbSearchBtn").click();
				Thread.sleep(20000);
				if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
				{
					LOGS.info("Account found");
				}
				else
				{
					Thread.sleep(30000);
					LOGS.info("Clicked on Search Button");
					SLocator("mbSearchBtn").click();
					Thread.sleep(20000);
					if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
					{
						LOGS.info("Account found");
					}
					else
					{
						Thread.sleep(40000);
						LOGS.info("Clicked on Search Button");
						SLocator("mbSearchBtn").click();
						Thread.sleep(20000);
						if((driver.findElement(By.xpath("//div[text()='No records found.']//ancestor::tbody")).getAttribute("style")).equals("display: none;"))
						{
							LOGS.info("Account found");
						}
						else
						{
							LOGS.info("Waited Long, Account did not reach SAMI, hence quitting the Test Case!");
							return "Fail";
						}
					}
					
				}
			}
			
		}
		LOGS.info("MBID is :"+MBID);
		 MBID=SLocator("mbIDR").getText();
		Thread.sleep(2000);
		LOGS.info("ProductType is :"+productType);
		 productType=SLocator("ProductType").getText();
			Thread.sleep(2000);		
		//	WebDriverWait wait=new WebDriverWait(driver, 20);
			// wait.until(ExpectedConditions.elementToBeClickable(SLocator("AdvrName")));
			 LOGS.info("Clicked on Advertiser Name Link");
		SLocator("AdvrName").click();
		Thread.sleep(4000);
		ImageName="Account";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		Status="Pass";
		ActRes="Account Info Page is Naviageted for : "+MBID;
		ExpRes="Account info for the MBID is navigated";
		ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			searchAccount="fail";
			LOGS.info("Issue in Search Account");
			Status="Fail";
			ActRes="Exception caused due to Network Issue";
			ExpRes="Account info for the MBID is navigated";
			ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
			return "Fail";
			
		}
		
		return MBID;
	}
	
public  String mediaBuy(String prodName) throws Exception{
	
	try {
		LOGS.info("-------------------------------------------");
		LOGS.info("Clicked on Primary Category edit link");
		SLocator("primarkEditLink").click();
		Thread.sleep(2000);
		LOGS.info("Clicked on Manual override Checkbox");
		
		if(SLocator("MedVertiName").getAttribute("value").isEmpty())
		{
			SLocator("ManualOverrideCheckBox").click();
			Thread.sleep(3000);
			LOGS.info("Selected Vertical");
			SLocator("verticalSel").click();
			Thread.sleep(2000);
			LOGS.info("Selected Category");
			SLocator("categorySel").click();
			Thread.sleep(2000);
			LOGS.info("Clicked on OK button");
			SLocator("AccInfoBtn").click();
			Thread.sleep(2000);
		}
		
	
		
		else{
		
		//------------------------------------------Scroll Down------------------------------------------
		
		JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
		jsAccountInfoElement.executeScript("arguments[0].click();", SLocator("AccInfoBtn"));
		Thread.sleep(2000);
		}
		LOGS.info("Handled Alert");
		alert();
		//------------------------------------------Scroll Down------------------------------------------	
		
		JavascriptExecutor jse6 = (JavascriptExecutor)driver;
		 jse6.executeScript("window.scrollBy(0,150)", "");
		 LOGS.info("Scroll down of page achieved");
		 Thread.sleep(2000);
		 LOGS.info("Cleared account info url");
		SLocator("AccInfoUrl").clear();
		Thread.sleep(2000);
		 LOGS.info("entered account info url");
		SLocator("AccInfoUrl").sendKeys("http://www.google.com");
		Thread.sleep(2000);
		//------------------------------------------Scroll Down------------------------------------------
		
		JavascriptExecutor jse7 = (JavascriptExecutor)driver;
		 jse7.executeScript("window.scrollBy(0,300)", "");
		 LOGS.info("Scroll down of page achieved");
		 LOGS.info("Clicked on Order Form");
		 
		 /*if(SLocator("AccInfoOOF").isDisplayed())
				 {
			 LOGS.info("Executing If1");
		SLocator("AccInfoOOF").click();
		Thread.sleep(2000);
				 }
		 try {
		if (SLocator("OOFRadioBtn").isDisplayed())
		{
			LOGS.info("Executing If2");
			SLocator("OOFRadioBtn").click();
			Thread.sleep(2000);
			LOGS.info("Clicked on Select Button");
			SLocator("OFSelectBtn").click();
			Thread.sleep(2000);
		}
		else
		{
			LOGS.info("else creating  new Online Order Form");
			
			String ghostWindow=driver.getWindowHandle();
			onlineOrderForm(ghostWindow,prodName);
		}
		 }
		catch(Exception e)
		{
			LOGS.info("creating  new Online Order Form");
			
			String ghostWindow=driver.getWindowHandle();
			onlineOrderForm(ghostWindow,prodName);
		}*/
		//------------------------------------------Scroll Down------------------------------------------
		
		 JavascriptExecutor jse9 = (JavascriptExecutor)driver;
		 jse9.executeScript("window.scrollBy(0,150)", "");
		 LOGS.info("Scroll down of page achieved");
	//----------------------------------------------------------------------------------------------------------------------	
		
			
		//	if (SLocator("MedBuyDPNIRadBtn").isDisplayed())
	//	 	if(websiteBasic.equalsIgnoreCase("no"))
			{/*
				LOGS.info("Use DPNI radio Button is clicked");
				SLocator("MedBuyDPNIRadBtn").click();
				Thread.sleep(2000);
				
				LOGS.info("Clicked on Update Info Button");
				SLocator("UpdateInfoBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Update Info Button");
				alert();
				alert();
				try{
				SLocator("medbuyOKBtn").click();
				}
				catch(Exception e){
					SLocator("UpdateInfoBtn").click();
					Thread.sleep(2000);
					SLocator("medbuyOKBtn").click();
				}
				Thread.sleep(2000);
				LOGS.info("Clicked on Add Button");
				SLocator("MedBuyProvNumAddBtn").click();
				Thread.sleep(2000);
				
				LOGS.info("Entered Target Number");
				SLocator("MedBuyTarNumTxt").sendKeys("2035435482");
				Thread.sleep(2000);
				LOGS.info("Clicked on Find Numbers Button");
				SLocator("MedBuyFindNumBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on available Provising Numbers");
				SLocator("MedBuyAvailPhnNum").click();
				Thread.sleep(5000);
				LOGS.info("Clicked on Provision Number OK button" );
				SLocator("MedBuyTarPhnOkBtn").click();
				Thread.sleep(4000);
				LOGS.info("Clicked on EmailCode Button ");
				JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
				jsAccountInfoElement.executeScript("arguments[0].click();", SLocator("MedBuyEmailCodeBtn"));
				Thread.sleep(4000);
				 LOGS.info("Clicked on send Button ");
				 SLocator("MedBuySendBtn").click();
				 Thread.sleep(38000);
				 LOGS.info("Clicked on OK Button");
				 SLocator("medbuyOKBtn").click();
				 Thread.sleep(2000);
				 try
				 {
					 SLocator("medbuyOKBtn").click(); 
				 }
				 catch(Exception e)
				 {
					 LOGS.info("OK Alert not displayed");
				 }
	   
	   

			*/}
			/*if (SLocator("MedBuySndCdToWebBtn").isDisplayed())
			{
				LOGS.info("-------------------------------------------");
			LOGS.info("Clicked on send code to website Button");
			SLocator("MedBuySndCdToWebBtn").click();
			Thread.sleep(12000);
			LOGS.info("Clicked on OK Button");
			SLocator("medbuyOKBtn").click();
			Thread.sleep(2000);
			}*/
			
	
			LOGS.info("Clicked on Update Info Button");
			SLocator("UpdateInfoBtn").click();
			Thread.sleep(6000);
			LOGS.info("Handling alert");
			alert();
			
			LOGS.info("Clicked on OK Button");
			Thread.sleep(9000);
			try
			{
				SLocator("medbuyOKBtn").click();
				Thread.sleep(9000);
			}
			catch(Exception e)
			{
				SLocator("UpdateInfoBtn").click();
				alert();
				SLocator("medbuyOKBtn").click();
				
			}
			Thread.sleep(6000);
			LOGS.info("Handling alert");
			
			try{
				alert();
			}
			catch(Exception e)
			{
				LOGS.info("No Alerts Present");
			}
			Thread.sleep(9000);
			mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
			if(mediabuyStatus.equalsIgnoreCase("Campaign Editorial"))
			{
				LOGS.info("Clicked on Confirm MediaBuy Button");
				JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
				jsAccountInfoElement.executeScript("arguments[0].click();",SLocator("confirmMedBuyBtn"));
				Thread.sleep(8000);
				LOGS.info("handling alert");
				alert();
				alert();
				Thread.sleep(4000);
				
				ImageName="MediaBuyBtn";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
				Status="Pass";
				ActRes="MediaBuy Button is clicked";
				ExpRes="MediaBuy Button should be clicked";
				ExportResults.exportTestResult("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				LOGS.info("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status);
			}
		}
			catch(Exception e)
			{
				//e.printStackTrace();
				LOGS.info("Issue in Media Buy Page - Re-executing");
				mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
				System.out.println("mediabuyStatus :" + mediabuyStatus);
				if(mediabuyStatus.equalsIgnoreCase("XML Received") ||mediabuyStatus.equalsIgnoreCase("Campaign Editorial"))
				{
					WebElement AccountsLink=driver.findElement(By.xpath("//li[@id='lnAccount']/a"));
					JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
					jsAccountInfoElement.executeScript("arguments[0].click();", AccountsLink);
					mediaBuy(prodName);
				}
				else if(mediabuyStatus.equalsIgnoreCase("Campaign Editorial"))
				{
					JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
					jsAccountInfoElement.executeScript("arguments[0].click();",SLocator("confirmMedBuyBtn"));
					Thread.sleep(2000);
					LOGS.info("handling alert");
					alert();
					alert();
					Thread.sleep(4000);
				}
				else
				{
					campaignPage(prodName);
				}
			}
			return "Pass";
		}
	public  String AccountInfo(String prodName) throws Exception
	{
		LOGS.info("Executing AccountInfo");
		LOGS.info("This method is used to Add URL, Launch OOF, Check Call Tracking, Clicking COnfirm Mediabuy");
		LOGS.info("Cleared account info url");
		try
		{
			SLocator("AccInfoUrl").clear();
			Thread.sleep(2000);
			 LOGS.info("entered account info url");
			SLocator("AccInfoUrl").sendKeys("http://www.google.com");
			Thread.sleep(2000);
			LOGS.info("Proceeding for Submission of  Online Order Form");
			driver.findElement(By.xpath("//input[@id='orderForm']")).click();
			LOGS.info("Online Order Form clicked");
			String OOFDivText=driver.findElement(By.xpath("//td[@class='yui-dt-first yui-dt-last']/div")).getText();
			if(OOFDivText.contains("No records found."))
			{
				LOGS.info("OOF has to be created.");
				String ghostWindow=driver.getWindowHandle();
				onlineOrderForm(ghostWindow,prodName);
				
			}
			else
			{
				LOGS.info("OOF Exists");
				SLocator("OOFRadioBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Select Button");
				SLocator("OFSelectBtn").click();
				Thread.sleep(2000);
			}
			
			if(driver.findElement(By.id("callTrackingCheckbox")).isSelected()) {
				WebElement checkbox = driver.findElement(By.id("callTrackingCheckbox"));
				checkbox.click();
				boolean value =checkbox.isSelected();
				System.out.println("Checkbox value : "+value);
				checkbox.click();
				boolean value1 =checkbox.isSelected();
				System.out.println("Checkbox value : "+value1);
				
				WebElement callTrackCheckbox=driver.findElement(By.id("callTrackingCheckbox"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", callTrackCheckbox);
			
			}
			
/*			LOGS.info("Checking the Call Tracking Status");
			LOGS.info("Checking whether DPNI is checked");
			String dpniStyle=driver.findElement(By.xpath("//div[@id='trackingOptionSection']")).getAttribute("style");
			if(dpniStyle.contains("none"))
			{
				LOGS.info("Call Tracking not selected");
			}*/
/*			else
			{
				LOGS.info("Call Tracking not selected");
				LOGS.info("Use DPNI radio Button is clicked");
				WebElement usedpni=driver.findElement(By.xpath("//input[@id='useDPNI']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usedpni);
				SLocator("MedBuyDPNIRadBtn").click();
				Thread.sleep(2000);
				
				LOGS.info("Clicked on Update Info Button");
				SLocator("UpdateInfoBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Update Info Button");
				alert();
				try{
					SLocator("medbuyOKBtn").click();
					}
					catch(Exception e){
						SLocator("UpdateInfoBtn").click();
						Thread.sleep(2000);
						SLocator("medbuyOKBtn").click();
					}
					Thread.sleep(2000);
					List<WebElement> provisionElements=driver.findElements(By.xpath("//div[@id='provisionNumberTable']//td"));
					if(provisionElements.size()==1)
					{
						LOGS.info("No Provision NUmber available, Clicking on Add to create one");
						SLocator("MedBuyProvNumAddBtn").click();
						Thread.sleep(2000);
						
						LOGS.info("Entered Target Number");
						SLocator("MedBuyTarNumTxt").sendKeys("2035435482");
						Thread.sleep(2000);
						LOGS.info("Clicked on Find Numbers Button");
						SLocator("MedBuyFindNumBtn").click();
						Thread.sleep(2000);
						LOGS.info("Clicked on available Provising Numbers");
						SLocator("MedBuyAvailPhnNum").click();
						Thread.sleep(5000);
						LOGS.info("Clicked on Provision Number OK button" );
						SLocator("MedBuyTarPhnOkBtn").click();
						Thread.sleep(2000);
					}
					else
					{
						LOGS.info("Provision Number already exists");
					}
					Thread.sleep(2000);
					LOGS.info("Clicked on EmailCode Button ");
					JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
					jsAccountInfoElement.executeScript("arguments[0].click();", SLocator("MedBuyEmailCodeBtn"));
					Thread.sleep(4000);
					 LOGS.info("Clicked on send Button ");
					 SLocator("MedBuySendBtn").click();
					 
					 Thread.sleep(2000);
					 LOGS.info("Send Email Dialog is closed");
					 Thread.sleep(38000);
					 driver.navigate().refresh();
					 LOGS.info("Clicked on OK Button");
					 SLocator("medbuyOKBtn").click();
					 Thread.sleep(2000);
			} */  
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", SLocator("UpdateInfoBtn")); 
			//SLocator("UpdateInfoBtn").click();
			Thread.sleep(2000);
			SLocator("medbuyOKBtn").click();
					 mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
					 LOGS.info("Media Buy status after update user info is :"+mediabuyStatus);
						if(mediabuyStatus.equalsIgnoreCase("Campaign Editorial"))
						{
							LOGS.info("Clicked on Confirm MediaBuy Button");
							((JavascriptExecutor)driver).executeScript("arguments[0].click();",SLocator("confirmMedBuyBtn"));
							Thread.sleep(2000);
							LOGS.info("handling alert");
							alert();
							alert();
							Thread.sleep(4000);
							
							ImageName="MediaBuyBtn";
							ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
							Status="Pass";
							ActRes="MediaBuy Button is clicked";
							ExpRes="MediaBuy Button should be clicked";
							ExportResults.exportTestResult("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
							LOGS.info("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status);
						}
				
				
		}
		catch(Exception e)
		{
			alert();
			e.printStackTrace();
		}
		
		
		return prodName;
		
	}
	




public String admin(String MBID) throws Exception{
	Properties OR=SamiPreRequisites.loadPropertiesFiles("Order");
	try {
		
		LOGS.info("-------------------------------------------");
		LOGS.info("Clicked on Admin Tab");
		driver.get(OR.getProperty("SamiAdminLink"));
		Thread.sleep(5000);
		MBIDStatusCons=MBIDStatusCons+"  "+MBID;
		LOGS.info("Assign Status to the MBID");
		Select se = new Select(driver.findElement(By.xpath("//select[@id='mbStatus']"))); 
		se.deselectAll();
		LOGS.info("Deslected All in Status");
		se.selectByVisibleText("All");
		LOGS.info("Selected All in status");
		Thread.sleep(2000);
		
		
		LOGS.info("Assign analyst to the MBID");
		Select se1 = new Select(driver.findElement(By.xpath("//select[@id='mbAnalyst']")));
		se1.deselectAll();
		LOGS.info("Deslected All in Analyst");
		se1.selectByVisibleText("All");
		LOGS.info("Selected All in analyst");
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		LOGS.info("Entered MBID : "+MBID);
		SLocator("AdmMBID").sendKeys(MBID);
		Thread.sleep(2000);
		SLocator("AdmSearchBtn").click();
		Thread.sleep(2000);
		LOGS.info("Clicked on seacrh button");
		String Assignee=driver.findElement(By.xpath("//td[@headers='yui-dt0-th-assignedTo ']//span")).getAttribute("title");
		if(Assignee.equals("Unassigned"))
		{
		SLocator("AdmAnaAssignBtn").click();
		Thread.sleep(2000);
		LOGS.info("Cleared Analyst");
		SLocator("AdmAnalystAssign").clear();
		Thread.sleep(2000);
		LOGS.info("Clicked on Analyst Assign button");
		//SLocator("AdmAnalystAssign").sendKeys("Benjamin Betzalel");
		SLocator("AdmAnalystAssign").sendKeys("gina zazo");
		Thread.sleep(2000);
		LOGS.info("Entered the Analyst");
		//-----------------------------------------Scroll Down------------------------------------------
		
		 JavascriptExecutor jse9 = (JavascriptExecutor)driver;
		 jse9.executeScript("window.scrollBy(0,350)", "");
		 LOGS.info("Scroll down of page achieved");
	//----------------------------------------------------------------------------------------------------------------------	
	
		
		SLocator("AdmOKBtn").click();
		Thread.sleep(3000);
		LOGS.info("Clicked on OK button");
		alert();
		LOGS.info("handled alert message");
		
		
		ImageName="AssignAnalyst";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		Status="Pass";
		ActRes="Analyst Assigned";
		ExpRes="Analyst should be Assigned";
		ExportResults.exportTestResult("Assigning Analyst,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Assigning Analyst,"+ExpRes+","+ActRes+","+Status);
		}
		
		else
		{
			LOGS.info("Admin already Assigned");
		}

		Thread.sleep(3000);
		LOGS.info("Clicked on Advertiser Name");	
		SLocator("AdmAdNameLink").click();
		Thread.sleep(2000);
	}
	catch(Exception e)
	{
		LOGS.info("Issue in Admin page : Re-executing");
		admin(MBID);
		
	}
	return "Pass";
	
	}


public String campaignPage(String ProdName) throws Exception{
	
	try {
		LOGS.info("Executing the CampaignPage Method!!!");
		WebElement elementClick=driver.findElement(By.xpath("//li[@id='lnCampaigns']/a"));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", elementClick);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//div[@id='mainCampaignTable']/div[3]/table/tbody[1]/tr/td/div"));
		System.out.println(element.getText());
		if(!(element.getText()).equalsIgnoreCase("No records found."))
		{	
			WebElement SelectAllEle=driver.findElement(By.xpath("//div[@id='activeActionButtons']/div/span[1]/span[1]/a"));
			JavascriptExecutor jsSelectAllEle = (JavascriptExecutor)driver;
		    jsSelectAllEle.executeScript("arguments[0].click();", SelectAllEle);
			LOGS.info("Clicked on Select All");
			WebElement DeleteAll=driver.findElement(By.xpath("//div[@id='activeActionButtons']/div/span[5]/span[1]/a"));
			JavascriptExecutor jsDeleteAll = (JavascriptExecutor)driver;
		    jsSelectAllEle.executeScript("arguments[0].click();", DeleteAll);
			LOGS.info("Clicked on Delete Campaigns");
			Thread.sleep(2000);
			LOGS.info("handled alert");
		    alert();
		   

		}				
		LOGS.info("-------------------------------------------");
			LOGS.info("Clicked on Camp create new button ");
			try
			{
				SLocator("CampNewBtn").click();
			}
			catch(Exception e)
			{
				
				mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
				System.out.println("mediabuyStatus :" + mediabuyStatus);
				if(mediabuyStatus.equalsIgnoreCase("XML Received") ||mediabuyStatus.contains("Editorial") )
				{
					WebElement AccountsLink=driver.findElement(By.xpath("//li[@id='lnAccount']/a"));
					JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
					jsAccountInfoElement.executeScript("arguments[0].click();", AccountsLink);
					LOGS.info("Navigated to Accounts Page to click on the" );
					AccountInfo(ProdName);
				}
				else
					campaignPage(ProdName);
				
			}
			Thread.sleep(2000);
			LOGS.info("Entered the campaign name ");
			SLocator("CampNameText").sendKeys("SAMI New Campaign");
			Thread.sleep(2000);
			//sets todays date
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String date1= dateFormat.format(date);
			//sets 2days ahead from current date
			Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());
		    cal.add(Calendar.DATE,2);
		    String newDate = dateFormat.format(cal.getTime());
		    LOGS.info("Sets todays date ");
			SLocator("CampStrtDate").sendKeys(date1);
			Thread.sleep(2000);
			LOGS.info("Sets future  date ");
			SLocator("CampEndDate").sendKeys(newDate);
			Thread.sleep(2000);
			LOGS.info("Checked yahoo campaign ");
			SLocator("CampYahooCheckBox").click();
			Thread.sleep(2000);
			LOGS.info("Clicked on Campaign button");
			WebElement CampCreateBtn=driver.findElement(By.id("createCampaigns"));
			Thread.sleep(3000);
			JavascriptExecutor jsE = (JavascriptExecutor)driver;
			jsE.executeScript("arguments[0].click();", CampCreateBtn);
		    ImageName="CampaignException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
			Status="Pass";
			ActRes="Campaign is created for :" + MBID;
			ExpRes="Campaign should be created";
			ExportResults.exportTestResult("Campaign Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Campaign Creation,"+ExpRes+","+ActRes+","+Status);
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			LOGS.info("There is some exception : Re-executing");
			mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
			Thread.sleep(3500);
			String CurrentURL=driver.getCurrentUrl();
			if(CurrentURL.contains("businessInfo.xhtml"))
			{
				LOGS.info("Campain Created");
			}
			else campaignPage(ProdName);
						
		}
		return "Pass";
	
	}

//-----------------------------------------Scroll Down------------------------------------------



public String samiFulfillmentProcess(String ProdName) throws Exception{
	
	try {
		LOGS.info("-------------------------------------------");
		LOGS.info("Clicked on Geo Link");
		driver.findElement(By.xpath("//li[contains(@id,'lnGeos')]/a")).click();
		//SLocator("geosLink").click();
		Thread.sleep(3000);
		LOGS.info("Clicked on selected country");
		driver.findElement(By.id("countriesMoveMulti")).click();
		//SLocator("GeoCntrySel").click();
		Thread.sleep(2000);
		ImageName="Geo";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		Status="Pass";
		ActRes="Geo is added";
		ExpRes="Geo should be added";
		ExportResults.exportTestResult("Geo Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Geo Creation,"+ExpRes+","+ActRes+","+Status);
		LOGS.info("Clicked on next Step button");
		driver.findElement(By.xpath("//div[contains(@id,'manualSearchContainer')]/span/span/span[1]/a")).click();
		//SLocator("GeoNxtStpBtn").click();
		Thread.sleep(4000);
		LOGS.info("-------------------------------------------");
		//Ads Group Page
		
		WebElement elementAdGrp=driver.findElement(By.xpath("//a[@id='adGroupsLink']"));
		Thread.sleep(3000);
		JavascriptExecutor jsAdGrp = (JavascriptExecutor)driver;
		jsAdGrp.executeScript("arguments[0].click();", elementAdGrp);
		Thread.sleep(2000);
		LOGS.info("Creating new Ad grp");
		//SLocator("NewAdGrpBtn").click();
		WebElement elementCreateGrp=driver.findElement(By.xpath("//span[@id='createAdGroupBtn']/span[1]/a"));
		Thread.sleep(3000);
		JavascriptExecutor jsCreateGrp = (JavascriptExecutor)driver;
		jsCreateGrp.executeScript("arguments[0].click();", elementCreateGrp);
		Thread.sleep(2000);
		LOGS.info("Entered Ads Grp");
		SLocator("AdGrpNameTxt").sendKeys("Ad Group Name");
		SLocator("AdGroupURLTxt").click();
		Thread.sleep(2000);
		 SLocator("AdGroupURLTxt").clear();
		 Thread.sleep(2000);
		 SLocator("AdGroupURLTxt").sendKeys("http://www.google.com");
		 Thread.sleep(2000);
		 LOGS.info("Scroll Up of page achieved");
		LOGS.info("Clicked on Create Ad grp Button ");
		SLocator("AdGrpCreateBtn").click();		
		Thread.sleep(3000);
	//	SLocator("AdGrpKWSaveBtn").click();
		//Thread.sleep(2000);
		 ImageName="Adgroup";
		 ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		 Status="Pass";
		 ActRes="Adgroup is created";
		 ExpRes="Adgroup should be created";
		 ExportResults.exportTestResult("Adgroup Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		 LOGS.info("Adgroup Creation,"+ExpRes+","+ActRes+","+Status);
		 LOGS.info("-------------------------------------------");
		 LOGS.info("Clicked on Keyword Link");
		 driver.findElement(By.xpath("//li[contains(@id,'lnCampaignSubMenuAd')]/ul/li[1]/a")).click();
		 //	SLocator("KeywordLink").click();
		 Thread.sleep(3000);
		 LOGS.info("Clicked on Add Keyword Button ");
		 WebElement elementAddKeyword=SLocator("AddKeyWrdBtn");
		 Thread.sleep(3000);
		 JavascriptExecutor jsAddKeyword = (JavascriptExecutor)driver;
		 jsAddKeyword.executeScript("arguments[0].click();", elementAddKeyword);
		 //	SLocator("AddKeyWrdBtn").click();
		 Thread.sleep(2000);
		 LOGS.info("Entered Keyword Text ");
		 SLocator("AddKeyWrdTxt").sendKeys("cars");
		 Thread.sleep(2000);
		 LOGS.info("Clicked on Save Button ");
		 SLocator("AdGrpKWSaveBtn").click();
		 Thread.sleep(3000);
		 LOGS.info("Clicked on Scrolled down page ");
		ImageName="keyword";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
		Status="Pass";
		ActRes="keyword is created";
		ExpRes="keyword should be created";
		ExportResults.exportTestResult("keyword Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("keyword Creation,"+ExpRes+","+ActRes+","+Status);
		// Ads Link page
		LOGS.info("Clicked on Ads Link");
		Thread.sleep(3000);
		WebElement elementAdLink=driver.findElement(By.xpath("//li[contains(@id,'lnCampaignSubMenuAd')]/ul/li[2]/a"));
		Thread.sleep(3000);
		JavascriptExecutor jsAdLink = (JavascriptExecutor)driver;
		jsAdLink.executeScript("arguments[0].click();", elementAdLink);
				
		//SLocator("AdsLink").click();
		Thread.sleep(2000);
		LOGS.info("Clicked onNew Ad Button ");
		SLocator("AdsNewAdBtn").click();
		Thread.sleep(2000);
		LOGS.info("Entered Ad Name ");
		Thread.sleep(2000);
		LOGS.info("Entered Business Name ");
		SLocator("AdsYahooBusNameText").sendKeys("Ad Business Name");
		Thread.sleep(2000);
		LOGS.info("Entered Headline one ");
		SLocator("AdsYahooHeadLineOne").sendKeys("HeadLine One");
		Thread.sleep(2000);
		LOGS.info("Entered HeadLine Two ");
		SLocator("AdsYahooHeadLineTwo").sendKeys("Head Line Two");
		Thread.sleep(2000);
		LOGS.info("Entered Description ");
		SLocator("AdsYahooDescText").sendKeys("Ads Description");
		Thread.sleep(2000);
		/*LOGS.info("Entered url ");
		SLocator("AdsYahooDispUrl").sendKeys("http://www.hibu.com");*/
		Thread.sleep(2000);
		LOGS.info("Scrolled down page");
		//----------------------------------Scroll down page------------------------
		JavascriptExecutor jse19 = (JavascriptExecutor)driver;
		 jse19.executeScript("window.scrollBy(0,350)", "");
		 LOGS.info("Scroll down of page achieved");

		 LOGS.info("clicked on Create Ad Button ");
		 ImageName="Ads";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
			Status="Pass";
			ActRes="Ad is created";
			ExpRes="Ad should be created";
			ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Ad Creation,"+ExpRes+","+ActRes+","+Status);
		 
		 driver.findElement(By.xpath("(//div[contains(@id,'adTabContainer')]/div[7]/span/span[1]/a)[1]")).click();
	//	SLocator("AdsCreateAd").click();
		Thread.sleep(3000);
		LOGS.info("-------------------------------------------");
		LOGS.info("Creating Budget");
		WebElement elementBudgetSetting=driver.findElement(By.xpath("//li[contains(@id,'lnBudgetSetting')]/a"));
		Thread.sleep(3000);
		JavascriptExecutor jsBudgetSetting = (JavascriptExecutor)driver;
		jsBudgetSetting.executeScript("arguments[0].click();", elementBudgetSetting);
		
	//	SLocator("BudgetSettingLink").click();
		Thread.sleep(2000);
		LOGS.info("Scrolled down the page");
		//SLocator("BudCampCPCRadBtn").click();
		//Thread.sleep(2000);
		 LOGS.info("Cleared the Budjet");
		SLocator("BudCampCPCText").clear();
		Thread.sleep(2000);
		LOGS.info("Entered the budget");
		SLocator("BudCampCPCText").sendKeys("0.5");	
		Thread.sleep(2000);
		LOGS.info("Clicked out side the box");
		SLocator("BudBudSettingClick").click();
		Thread.sleep(2000);
		LOGS.info("Clicked on Save Button");
		SLocator("BudSaveBtn").click();
		Thread.sleep(2000);
		LOGS.info("clicke on OK Button");
		SLocator("medbuyOKBtn").click();
		Thread.sleep(3000);
		LOGS.info("Scroll down the page");
		LOGS.info("Clicked on Publish Link");		 
		WebElement elementPublish=driver.findElement(By.xpath("//li[contains(@id,'lnPublish')]/a"));
		Thread.sleep(3000);
		JavascriptExecutor jspublish= (JavascriptExecutor)driver;
		jspublish.executeScript("arguments[0].click();", elementPublish);
		
	//	SLocator("PublishLink").click();
		Thread.sleep(4000);
		LOGS.info("clicked on Ready to Publish Button");
		SLocator("ReadytoPubBtn").click();
		Thread.sleep(3000);
		LOGS.info("clicked on Publish now Button");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("PubNowBtn"));
		//SLocator("PubNowBtn").click();
		Thread.sleep(2000);
		String parentHandle = driver.getWindowHandle();
		SLocator("DestUrlLink").click();
		LOGS.info("clicked on Desturl link");
		Thread.sleep(2000);
		try{
            Set<String> handles =  driver.getWindowHandles();
            
          for(String windowHandle  : handles)
            {
                 if(!windowHandle.equals(parentHandle))
            	LOGS.info("window handle: "+windowHandle);
                         driver.switchTo().window(windowHandle);
                         driver.manage().window().maximize();
                  
            }
            driver.close();

            driver.switchTo().window(parentHandle);
            
	     }catch(UnreachableBrowserException UE){
	           LOGS.info("Error in SwitchToParentWindow -"+UE.getMessage());
	            result = UE.getMessage();
	            throw new Exception("Exception raised in function : SwitchToParentWindow");
	     } 

		LOGS.info("clicked on greencheck");
		 ImageName="Ads";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
			Status="Pass";
			ActRes="Ad is Published";
			ExpRes="Ad should be Published";
			ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Ad Creation,"+ExpRes+","+ActRes+","+Status);
			WebElement elementImgGreenCheck=driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img"));
			Thread.sleep(3000);
			JavascriptExecutor jselementImgGreenCheck= (JavascriptExecutor)driver;
			jselementImgGreenCheck.executeScript("arguments[0].click();", elementImgGreenCheck);
		//driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img")).click();
			//	SLocator("greenCheck").click();
		Thread.sleep(10000);
		LOGS.info("-------------------------------------------");
		
		String mbidStatus = driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
		System.out.println("MBID Status : "+mbidStatus);
		
		
		 JavascriptExecutor pageUp = (JavascriptExecutor)driver;
		 pageUp.executeScript("window.scrollBy(0,-750)", "");

		
		//ExportResults.ExportSamiStatusToInputSheet(mbidStatus,gettingRowNo);
		
		
/*		WebElement elementMediaBuy=driver.findElement(By.xpath("(//li[contains(@id,'MODULE')]/a)[2]"));
		Thread.sleep(3000);
		JavascriptExecutor jsmediabuy= (JavascriptExecutor)driver;
		jsmediabuy.executeScript("arguments[0].click();", elementMediaBuy);
		
	//	SLocator("MediaBuyBtn").click();
		Thread.sleep(15000);
		MBIDStatusCons=MBIDStatusCons+ "  "+driver.findElement(By.xpath("//td[@headers='yui-dt0-th-statusName ']//child::a")).getText();*/
		/*LOGS.info("clicked on MediaBuy Button");
		
		WebElement elementMediaBuy=driver.findElement(By.xpath("(//li[contains(@id,'MODULE')]/a)[2]"));
		Thread.sleep(3000);
		JavascriptExecutor jsmediabuy= (JavascriptExecutor)driver;
		jsmediabuy.executeScript("arguments[0].click();", elementMediaBuy);*/
		
	//	SLocator("MediaBuyBtn").click();
		//Thread.sleep(15000);
		
	}
	catch(Exception e)
	{
		LOGS.info("There is some exception : Re-executing");
		mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
		if(mediabuyStatus.equalsIgnoreCase("Keyword Incompleted"))
		{
			samiFulfillmentProcess(ProdName);
		}
		if(mediabuyStatus.equalsIgnoreCase("Pending Sync"))
		{
			LOGS.info("clicked on MediaBuy Button");
			WebElement elementMediaBuy=driver.findElement(By.xpath("(//li[contains(@id,'MODULE')]/a)[2]"));
			Thread.sleep(3000);
			JavascriptExecutor jsmediabuy= (JavascriptExecutor)driver;
			jsmediabuy.executeScript("arguments[0].click();", elementMediaBuy);
		}
		if(mediabuyStatus.contains("Ready To Publish"))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("PubNowBtn"));
			Thread.sleep(2000);
			String parentHandle = driver.getWindowHandle();
			SLocator("DestUrlLink").click();
			LOGS.info("clicked on Desturl link");
			Thread.sleep(2000);
			try{
	            Set<String> handles =  driver.getWindowHandles();
	            
	          for(String windowHandle  : handles)
	            {
	                 if(!windowHandle.equals(parentHandle))
	            	LOGS.info("window handle: "+windowHandle);
	                         driver.switchTo().window(windowHandle);
	                         driver.manage().window().maximize();
	                  
	            }
	            driver.close();

	            driver.switchTo().window(parentHandle);
	            
		     }catch(UnreachableBrowserException UE){
		           LOGS.info("Error in SwitchToParentWindow -"+UE.getMessage());
		            result = UE.getMessage();
		            throw new Exception("Exception raised in function : SwitchToParentWindow");
		     } 

			LOGS.info("clicked on greencheck");
			 ImageName="Ads";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,Resultsfolderpath);
				Status="Pass";
				ActRes="Ad is Published";
				ExpRes="Ad should be Published";
				ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				LOGS.info("Ad Creation Ready for Publish,"+ExpRes+","+ActRes+","+Status);
				WebElement elementImgGreenCheck=driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img"));
				Thread.sleep(3000);
				JavascriptExecutor jselementImgGreenCheck= (JavascriptExecutor)driver;
				jselementImgGreenCheck.executeScript("arguments[0].click();", elementImgGreenCheck);
			//driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img")).click();
				//	SLocator("greenCheck").click();
			Thread.sleep(3000);
			LOGS.info("-------------------------------------------");
			LOGS.info("clicked on MediaBuy Button");
			
			WebElement elementMediaBuy=driver.findElement(By.xpath("(//li[contains(@id,'MODULE')]/a)[2]"));
			Thread.sleep(3000);
			JavascriptExecutor jsmediabuy= (JavascriptExecutor)driver;
			jsmediabuy.executeScript("arguments[0].click();", elementMediaBuy);
			
		//	SLocator("MediaBuyBtn").click();
			Thread.sleep(15000);
			MBIDStatusCons=MBIDStatusCons+ "  "+driver.findElement(By.xpath("//td[@headers='yui-dt0-th-statusName ']//child::a")).getText();
		}
		
	}
	return "Pass";
}

public String alert() throws InterruptedException{
	
	try {
	Thread.sleep(6000);
	LOGS.info("test");
	Alert a = driver.switchTo().alert();
	if (!a.getText().equals("")) {

		a.accept();
		
	}else{
		
		LOGS.info("Executing AcceptAlert Keyword Complete");
		return "Fail";
	}
	
	}
	catch(Exception e){
		
		
		LOGS.info("Alert not  displayed ");
		
	}
	return ActRes;
}
public String onlineOrderForm(String ghostWindow,String PlanType) throws Exception{
		try {
			driver.findElement(By.xpath("//a[@id='createOrderFormLink']")).click();
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB);
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			LOGS.info("Browsers opened are :" + tabs.size());
			// driver.switchTo().window(tabs.get(0));
			
			Set<String> handles = driver.getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(ghostWindow)) {
					driver.switchTo().window(windowHandle);
					driver.manage().window().maximize();
					LOGS.info("Driver is switched");
				}
			}
			
			if (PlanType.equalsIgnoreCase("WRD")) {
				LOGS.info("If it is display, Start Here should be click");
				driver.findElement(By.id("createOOFStart")).click();
				driver.findElement(By.id("createOOFStart")).click();
			}
			
			LOGS.info("Clicking the Proceed with Order");
			if (!PlanType.startsWith("SOCIAL")) {
				driver.findElement(By.id("createAndProceedOrderActiveBtn")).click();
			}
			Thread.sleep(5000);
			driver.findElement((By.id("cellPhoneNum"))).clear();
			driver.findElement((By.id("cellPhoneNum"))).sendKeys("4085074535");
			LOGS.info("Clicking on Campaign Details to enter further info");

			Thread.sleep(3000);
			if (PlanType.startsWith("SOCIAL") || PlanType.equalsIgnoreCase("WRD")) {
				LOGS.info(" Clicking on Next Button");
				try {
					alert();
				} catch (Exception e) {
					LOGS.info("No Such ALert found");
				}
				driver.findElement(By.xpath("//div[@id='generalInfoExpandArea']/div/div[13]/a[2]")).click();
			} else {
				LOGS.info(" Clicking on Next Button");
				try {
					alert();
				} catch (Exception e) {
					LOGS.info("No Such ALert found");
				}
				// driver.findElement(By.xpath("//div[contains(@class,'sectionItem
				// searchButtonContainer')]/a[4]")).click();
				driver.findElement(By.xpath("//a[@id='generalInfoNext']")).click();
			}
			Thread.sleep(3000);

			driver.findElement(By.id("categoryKeywords")).click();
			driver.findElement(By.id("categoryKeywords")).sendKeys("Plumber");
			Thread.sleep(3000);
			LOGS.info("Selecting the Select All Option in the category list");
			driver.findElement(By.xpath("//div[@class='candidateItem selectAllItem']/input")).click();
			LOGS.info("Selecting the Select All Option in the Service Candidates list");
			driver.findElement(By.xpath("//div[@class='candidates serviceCandidates']/div[1]/input")).click();
			Thread.sleep(6000);

			// ----------------------------------------------------------------------
			if (!PlanType.startsWith("SOCIAL")) {
				// if(SLocator("Country_Radiobutton").isDisplayed())
				{
					SLocator("Country_Radiobutton").click();
					Thread.sleep(2000);
					LOGS.info("clicking on Country Radio Button");
					// WebDriverWait wait = new WebDriverWait(driver, 6);
					// wait.until(ExpectedConditions.elementToBeClickable(SLocator("Country_US_Checkbox")));

					String textCountryOption = SLocator("CountryText").getText();
					if (textCountryOption.equalsIgnoreCase(
							"Confirm that you would like to target your campaign nationally in the ?")) {
						driver.findElement(By.id("countryForUS")).click();
						Thread.sleep(3000);
						LOGS.info("US checkbox checked");
					}
				}
			} else {

				driver.findElement(By.cssSelector("#stateForLabel")).click();
				// SLocator("Country_Radiobutton").click();
				LOGS.info("clicking on state Button");

				driver.findElement(By.xpath("//*[@id='campaignDetailGeo']/div/div[8]/div[3]/div[12]/a[1]/input"))
						.click();
				LOGS.info("Us checkbox checked");
			}

			JavascriptExecutor jse5 = (JavascriptExecutor) driver;
			jse5.executeScript("window.scrollBy(0,300)", "");
			LOGS.info("Scroll down of page achieved ");
			LOGS.info("clicking Submit Button");
			driver.findElement(By.id("submitOOFBtn")).click();
			Thread.sleep(4000);
			driver.close();
			driver.switchTo().window(ghostWindow);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='Refresh']")).click();
			Thread.sleep(3000);
			if (SLocator("OOFRadioBtn").isDisplayed()) {
				LOGS.info("Checking if the Online Orderform is reflected");
				SLocator("OOFRadioBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Select Button");
				SLocator("OFSelectBtn").click();
				Thread.sleep(2000);
			} else {
				driver.findElement(By.xpath("//a[@title='Refresh']")).click();
				Thread.sleep(3000);
				SLocator("OOFRadioBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Select Button");
				SLocator("OFSelectBtn").click();
				Thread.sleep(2000);

			}

		}
	
	catch(Exception e)
	{
		 driver.close();
		 driver.switchTo().window(ghostWindow);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		 Thread.sleep(3000);
		 if (SLocator("OOFRadioBtn").isDisplayed())
			{
				LOGS.info("Checking if the Online Orderform is reflected");
				SLocator("OOFRadioBtn").click();
				Thread.sleep(2000);
				LOGS.info("Clicked on Select Button");
				SLocator("OFSelectBtn").click();
								Thread.sleep(2000);
			}
		 else
		 {
			 SLocator("OFSelectBtn").click();
			 onlineOrderForm(ghostWindow, PlanType);
			
		 }
	}
	return "Pass";

}

public  void samiFlow(String productID) throws Exception
{
	String login;
	int counter=0;
	
	
	try
	{
		login=samiLogin();
		
		Thread.sleep(5000);
		if(login.equalsIgnoreCase("Fail"))
		{
			counter=counter+1;
			Status="Fail";
		}
	
	}
	catch(Exception e)
	{
		counter=counter+1;
		LOGS.info("There is some error in samiLogin Method");
	}

/*	
	String prd[]=PRD.split("_");
	String product[]=Product.split("_");
	for(int i=0;i<prd.length;i++)
	
	//for(int i=0;i<3;i++)
	{
			if(counter==0)
			{
				try
				{
					System.out.println("prd[i]"+ prd[i]);
					if (i == 0) {
						MBID = "207408";//"207767";//"206429";//"207396";//"206449";//"207415";//"207543";//"207387";//"207258";//"206575";// SamiFulfillment.accountSearch(Account,prd[i]);	
					

						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
					}
					if (i == 1) {
						System.out.println("prd[i]" + prd[i]);
						MBID = "207767";// SamiFulfillment.accountSearch(Account,prd[i]);

						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
					}
					if (i == 2) {
						System.out.println("prd[i]" + prd[i]);
						MBID = "";// SamiFulfillment.accountSearch(Account,prd[i]);

						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
					}
					
				}
				catch(Exception e)
				{
					counter=counter+1;
					LOGS.info("There is some error in accountSearch");
				}
			
			}
*/			
	
	Thread.sleep(10000);
	//String businessID = getInputDataToProcessDay2Day3(productID);
	String businessID = "8045544347";
	System.out.println("Business ID : "+businessID);
	//driver.findElement(By.xpath("//input[@id='mbSource']")).click();
	//Select seSource = new Select(driver.findElement(By.xpath("//select[@id='sourceMultiSelectSelect']")));
	Thread.sleep(2000);
	//seSource.selectByVisibleText("Ghost");
	//	LOGS.info("Selected Ghost in source");
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='mbStatus']")).click();
		Select seSource1 = new Select(driver.findElement(By.xpath("//select[@id='statusMultiSelectSelect']")));
		Thread.sleep(2000);
		seSource1.selectByIndex(0);
		LOGS.info("Selected All in source");
		Thread.sleep(2000);	
	
	driver.findElement(By.xpath("//input[@id='accountNumber']")).sendKeys(businessID);
	
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(@class,'ybButton')]/span[1]/a[contains(text(),'Search')]")).click();
	
	Thread.sleep(15000);
	
	//to get the list of records for the account
	
	String prdCount = driver.findElement(By.xpath("//span[@id='totalRecordsSpan']/b")).getText();
	int productCount = Integer.valueOf(prdCount);
	
	System.out.println("Product Count : "+productCount);
	
	for(int i=0;i<productCount;i++)		
		//for(int i=0;i<1;i++)	
	{
		int j = i+1;
			if(counter==0)
			{
				try
				{
					if (i == 0) {
						MBID1 = driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)[" + j + "]")).getText();
						LOGS.info("MBID1 :"+MBID1);
						product1 = driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)[1]")).getText();
						LOGS.info("product1 :"+product1);
						status = driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName')]/div/a)[1]")).getText();
						LOGS.info("status :"+status);
						
						
						MBID = MBID1;
						LOGS.info("MBID :"+MBID);
						product = product1;
						LOGS.info("product :"+product);

						// MBID="208377";
						// product="SOCIACLS";
						// product="WRD";
						// product="SOCIALSTD";
						// product="WRBI";
						// product="MRRX";

						System.out.println("1st MBID - " + MBID + "----  Product-" + product);
						// gettingRowNo

						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";
						}
						//ExportResults.ExportSamiDataToInputSheet(MBID, product, gettingRowNo);
					}
					
					if (i == 1) {
						// MBID = "";// SamiFulfillment.accountSearch(Account,prd[i]);
						MBID2 = driver
								.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)[" + j + "]"))
								.getText();
						LOGS.info("MBID2 :"+MBID2);
						product2 = driver
								.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)[2]"))
								.getText();
						LOGS.info("product2 :"+product2);
						status = driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName')]/div/a)[2]")).getText();
						LOGS.info("status :"+status);
						
						MBID = MBID2;
						product = product2;
						System.out.println("2nd MBID - " + MBID + "----  Product-" + product);

						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";
						}
						//ExportResults.ExportSamiDataToInputSheet(MBID, product, gettingRowNo);
					}
					
					if (i == 2) {
						MBID3 = driver
								.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)[" + j + "]"))
								.getText();
						LOGS.info("MBID3 :"+MBID3);
						product3 = driver
								.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)[3]"))
								.getText();
						
						LOGS.info("product3 :"+product3);

						status = driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName')]/div/a)[3]")).getText();
						LOGS.info("status :"+status);
						
						MBID = MBID3;
						product = product3;
						
						System.out.println("3rd MBID" + MBID + "   ----  Product-" + product);
						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
						//ExportResults.ExportSamiDataToInputSheet(MBID, product, gettingRowNo);
					}
					
				} catch(Exception e)
				{
					counter = counter + 1;
					LOGS.info("There is some error in accountSearch");
				}
			}
	
			
			if (counter == 0) {
				try {
				//	if (status.equalsIgnoreCase("XML Receiv...")||mediabuyStatus.equalsIgnoreCase("XML Received") || mediabuyStatus.contains("Editorial"))
					
					admin(MBID);
					LOGS.info("Executing admin method");
					
				} catch (Exception e) {
					e.printStackTrace();
					counter = counter + 1;
					LOGS.info("There is some error in admin");
				}

			}
			
			if (counter == 0) {
				try {
					mediabuyStatus = driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
					System.out.println("mediabuyStatus :" + mediabuyStatus);
					if (status.equalsIgnoreCase("XML Receiv...")||mediabuyStatus.equalsIgnoreCase("XML Received") || mediabuyStatus.contains("Editorial"))
					AccountInfo(product);

				} catch (Exception e) {
					LOGS.info("There is some error in mediaBuy");
					counter = counter + 1;
				}
			}
			
			
			if (counter == 0) {
				try {
				//	if (status.equalsIgnoreCase("XML Receiv...")||mediabuyStatus.equalsIgnoreCase("XML Received") || mediabuyStatus.contains("Editorial"))
						
					campaignPage(product);
				} catch (Exception e) {
					LOGS.info("There is some error in Campaign Page");
					e.printStackTrace();
					counter = counter + 1;
				}
			}
			
			if (counter == 0) {
				try {
				//	if (status.equalsIgnoreCase("XML Receiv...")||mediabuyStatus.equalsIgnoreCase("XML Received") || mediabuyStatus.contains("Editorial"))
						
				samiFulfillmentProcess(product);

				} catch (Exception e) {
					e.printStackTrace();
					LOGS.info("There is some error in SamiFulfillment Process");

				}
			}
			
			counter=0;
	}
}
}




	
	


	
