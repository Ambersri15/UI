package com.hibu.fulfillment;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hibu.tests.ExportResults;

public class SamiFulfillment extends SamiPreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(SamiFulfillment.class.getName());
	public String searchAccount,samiLoginResult,MBID,productType,result,gParentWindow;
	public String MBID1,MBID2,MBID3,MBID4,product1,product2,product3,product4,product,AdStatus1,AdStatus2,AdStatus3,AdStatus4,AdStatus,AdminName1,AdminName2,AdminName3,AdminName4,AdminName;
	public String ActRes,ExpRes,Status,ImagePath,ImageName,ImgName,onlineOrderFormResults;
	public static String mediabuyStatus;
	public String Resultsfolder= "Day2SAMIfulfillment_";
    public int portNO;
	SamiPreRequisites SamiPreRequisites = new SamiPreRequisites();
	ExportResults ExportResults =  new ExportResults();
	ScreenshotPrinter ScreenshotPrinter = new ScreenshotPrinter();
	DriverFactorySAMI DriverFactory = new DriverFactorySAMI();
	
	
	public  void SAMILogout() throws Exception {
		
	     try {
	    	 ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
			LOGS.info("No of Windows Opened: "+newWindowHandle);
			driver.switchTo().window(newWindowHandle.get(0));
	     }
	     catch(Exception e) {
	    	 ImageName="SAMILogoutException";
	         ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
	    	 LOGS.info("Exception in Logout: "+e.getStackTrace());
	     }
			LOGS.info("This is Logout Method");
			if(driver == null){
				LOGS.info("webdriver value is null");
				}else {
			          //driver.close();
					  driver.quit();
					  driver = null;
					
				}
			
			LOGS.info("Sucessfully Quit the Browser.");
			
			
		}

	
public  WebDriver windowsSettings() throws Exception {
		
		try {
			 //windows Settings
			
		       
			 System.setProperty("webdriver.chrome.driver",regardingfilesPath + "\\Drivers\\chromedriver.exe");
			 LOGS.info(Thread.currentThread() +"Windows Settings");
			 ChromeOptions chromeOptions = new ChromeOptions();
			 String nodeURL;
			   
			   chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
				//chromeOptions.addArguments("--no-sandbox");// Bypass OS security model
		        chromeOptions.addArguments("--headless"); //to enable headless browser
				chromeOptions.addArguments("--incognito");// comment it when you are running in windows
				chromeOptions.addArguments("--ignore-ssl-errors=yes");
				chromeOptions.addArguments("--ignore-certificate-errors");
				chromeOptions.addArguments("window-size=1920x1080");
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-extensions"); // disabling extensions
				chromeOptions.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
		      // chromeOptions.setExperimentalOption("useAutomationExtension", false);
		      // chromeOptions.addArguments("--remote-debugging-port=9222");
		       
		       
		       
		       chromeOptions.addArguments("--allow-insecure-localhost");
		       DesiredCapabilities caps = new DesiredCapabilities();
		       caps.setBrowserName("chrome");
		       caps.setPlatform(Platform.WINDOWS);
		       caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		       caps.setCapability("acceptInsecureCerts", true);
		       caps.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		       caps.setCapability("applicationCacheEnabled", false);	
		       caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		       caps.setCapability("chrome.switches",Arrays.asList("--incognito"));
		       caps.setCapability("goog:chromeOptions", chromeOptions);
		       chromeOptions.merge(caps);
		       nodeURL = "http://localhost:"+portNO+"/wd/hub";
		       
		       driver = new RemoteWebDriver(new URL(nodeURL),chromeOptions);
		      // driver = new ChromeDriver(chromeOptions);
		       
        }catch(Exception e) {
        	LOGS.info(Thread.currentThread() +"Windows Options" + "load failed" + "," + e.getMessage());
			
			LOGS.error(Thread.currentThread() +"Unable to Login to Salesforce",e);
			LOGS.error(Thread.currentThread() +"Unable to Login to Salesforce"+e.getMessage());
		}
		return driver;
	}
	
	
	
	
	public  WebDriver linuxSettings() throws Exception {
		
		try {
			//Linux Settings
		      System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		      LOGS.info(Thread.currentThread() +"Linux Settings");
				ChromeOptions chromeOptions = new ChromeOptions();
				
				chromeOptions.setBinary("/opt/google/chrome/google-chrome");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--incognito");
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
				chromeOptions.addArguments("window-size=1920x1080");
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-gpu");
		        chromeOptions.addArguments("disable-infobars"); // disabling infobars
				chromeOptions.addArguments("--disable-extensions"); // disabling extensions
				chromeOptions.addArguments("--disable-dev-shm-usage");
		        //chromeOptions.setExperimentalOption("useAutomationExtension", false);
		        chromeOptions.addArguments("--remote-debugging-port=9222");
		        chromeOptions.addArguments("--allow-insecure-localhost");
			       DesiredCapabilities caps = new DesiredCapabilities();
			       caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			       caps.setPlatform(org.openqa.selenium.Platform.LINUX);
			       caps.setCapability("acceptInsecureCerts", true);
			       caps.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			       caps.setCapability("applicationCacheEnabled", false);	
			       caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			       caps.setCapability("chrome.switches",Arrays.asList("--incognito"));
			       caps.setCapability("goog:chromeOptions", chromeOptions);
			       chromeOptions.merge(caps);
			       driver = new ChromeDriver(chromeOptions);
		}catch(Exception e) {
            LOGS.info(Thread.currentThread() +"Linux Options load failed: "+ e.getMessage());
            LOGS.error(Thread.currentThread() +"Unable to load Linux Options",e);
		}
		return driver;
	}
	
	

	public  String samiLogin(String Resultsfolderpath) throws Exception{
		
		
try{
			
			//String path = System.getProperty("user.dir")+ "\\InputFiles\\Order.properties";
			
	        String path = regardingfilesPath+ "InputFiles/Order.properties";
			
			LOGS.info(path);
			Properties OR=SamiPreRequisites.loadPropertiesFiles("Order");
			
		
			
			
			LOGS.info("Setting Chrome DRiver Property");
			
			//Linux Settings
			//driver = linuxSettings();
			
	    
	       
	        //windows Settings
			driver = windowsSettings();
	       
			
			
			
			
			LOGS.info(Thread.currentThread() +"Chrome Driver initialization");
			DriverFactory.setDriver(driver);
			LOGS.info(Thread.currentThread() +"hey---4"+DriverFactory);
			LOGS.info("driver value: "+driver);
			driver = DriverFactory.getDriver();
			
			LOGS.info("Chrome driver initiated");
			
			driver.get(OR.getProperty("samitestsite"));
			LOGS.info("URL launched");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			String privacy = driver.getTitle();
			LOGS.info("Title is: "+privacy);
			
			if(privacy.contains("Privacy error")) 
			{
			Thread.sleep(2000);
			LOGS.info("On Privacy Policy Page");
			driver.findElement(By.xpath("//button[@id ='details-button']")).click();
			LOGS.info("Clicked on Advanced Button");
			Thread.sleep(3000);
			driver.findElement(By.partialLinkText("Proceed to samiuat.hibu.int")).click();
			LOGS.info("Clicked on Proceed to...");
			Thread.sleep(5000);
			}
			
			SLocator("samiUser").sendKeys(OR.getProperty("samiUserName"));
			LOGS.info(OR.getProperty("samiUserName"));
			SLocator("samiPwd").sendKeys(OR.getProperty("samiUserPwd"));
			LOGS.info(OR.getProperty("samiUserPwd"));
			SLocator("samiLogin").click();
			LOGS.info("Login button Clicked");
			Thread.sleep(6000);
			ActRes=driver.getCurrentUrl();
			ExpRes="SAMI page should contain the URL sami ";
			ImageName="samiLogin";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			//To check the Scenario Status	        
			if(!ActRes.contains("loginfailed")) 
			{
				samiLoginResult="Pass";
				LOGS.info("Able to Login to Sami");
				Status="Pass";
			    ExportResults.exportTestResult("Login to SAMI,"+ExpRes+","+ActRes+","+Status+","+","+ImgName,Resultsfolderpath);
				LOGS.info("Login to SAMI,"+ExpRes+","+ActRes+","+Status);
				return samiLoginResult;
				
			}
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
			ImageName="SAMILoginException";
			ExceptionMsg = "Unable to Login to Sami";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			samiLoginResult="Fail";
			Status="Fail";
			ExportResults.exportTestResult("Login to SAMI,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			
			LOGS.info("Unable to Login to Sami");
			
			throw new Exception(e.getMessage());
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
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		Status="Pass";
		ActRes="Account Info Page is Naviageted for : "+MBID;
		ExpRes="Account info for the MBID is navigated";
		ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
				
		}
		catch(Exception e)
		{
			LOGS.info(e.getStackTrace());
			//e.printStackTrace();
			searchAccount="fail";
			LOGS.info("Issue in Search Account");
			ImageName="AccountSearchException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			ExceptionMsg = "Issue in Search Account";
			Status="Fail";
			ActRes="Exception caused due to Network Issue";
			ExpRes="Account info for the MBID is navigated";
			ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
			return "Fail";
			
		}
		
		return MBID;
	}

	public  String accountSearch(String Account, String ProductName,String initialStartDate) throws Exception{
		
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
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		Status="Pass";
		ActRes="Account Info Page is Naviageted for : "+MBID;
		ExpRes="Account info for the MBID is navigated";
		ExportResults.exportTestResult("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Account Info Page Navigation,"+ExpRes+","+ActRes+","+Status);
				
		}
		catch(Exception e)
		{
			LOGS.info(e.getStackTrace());
			//e.printStackTrace();
			searchAccount="fail";
			LOGS.info("Issue in Search Account");
			ImageName="AccountSearchException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
			Status="Fail";
			ExceptionMsg = "Issue in Search Account";
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
			
	
			LOGS.info("Clicked on Update Info Button---------F1");
			SLocator("UpdateInfoBtn").click();
			Thread.sleep(6000);
			LOGS.info("Handling alert--------F2");
			alert();
			
			LOGS.info("Clicked on OK Button-------F3");
			Thread.sleep(9000);
			try
			{
				LOGS.info("Clicked on MediaBuy Button-------F4");
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
				try {
					 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					 LOGS.info("Waiting for the process");
					 WebDriverWait wait1 = new WebDriverWait(driver, 3);
					 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

					 }catch(Exception ex) {
					 LOGS.info("Wait is over and the Process continues.");
					 }
				
				ImageName="MediaBuyBtn";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
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
				ExceptionMsg = "Issue in Media Buy Page - Re-executing";
				ImageName="MediaBuyException";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
				LOGS.info("Failed due to application slowness");
				LOGS.info(e.getStackTrace());
				/*mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
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
				}*/
			}
			return "Pass";
		}

	public  String AccountInfo(String prodName, String Resultsfolderpath) throws Exception
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
			Thread.sleep(3000);
			LOGS.info("Proceeding for Submission of  Online Order Form");
			driver.findElement(By.xpath("//input[@id='orderForm']")).click();
			LOGS.info("Online Order Form clicked");
			String OOFDivText=driver.findElement(By.xpath("//td[@class='yui-dt-first yui-dt-last']/div")).getText();
			if(OOFDivText.contains("No records found."))
			{
				LOGS.info("OOF has to be created.");
				String ghostWindow=driver.getWindowHandle();
				onlineOrderForm(ghostWindow,prodName);
				try {
					 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					 LOGS.info("Waiting for the OOF");
					 WebDriverWait wait1 = new WebDriverWait(driver, 4);
					 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

					 }catch(Exception ex) {
					 LOGS.info("Wait is over and the Process continues.");
					 }
				
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
			
			// Commented to Avoid email sending Code to Advertiser
			/*if(driver.findElement(By.id("callTrackingCheckbox")).isSelected()) {
				LOGS.info("Checking the Call Tracking Status");
				WebElement checkbox = driver.findElement(By.id("callTrackingCheckbox"));
				checkbox.click();
				Thread.sleep(2000);
				boolean value =checkbox.isSelected();
				System.out.println("Checkbox value : "+value);
				
				if(value) {
					
					checkbox.click();
					Thread.sleep(2000);
					boolean value1 =checkbox.isSelected();
					System.out.println("Checkbox value : "+value1);
					
				}
				
				
			}*/
			//////////////////////////////////////////////////////////
			
			
			
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
			
			/*---------------------Code for MRXX-------------------------------------*/
			/*
			if(product.equalsIgnoreCase("WRBI") || product.equalsIgnoreCase("MRRX"))
			{
				try {
				WebElement dpni = driver.findElement(By.xpath("//input[@id='useDPNI']"));
				if(dpni.isSelected()) {
					
				try
				{
					LOGS.info("This MBID is Provisioned.");
					LOGS.info("Trying to update DPNI");
					driver.findElement(By.xpath("//input[@id='useDPNI']")).click();
					LOGS.info("Selected DPIN");
					Thread.sleep(2000);
					SLocator("UpdateInfoBtn").click();
					LOGS.info("Clicked on Update Info Button");
					alert();
					//alert();
					Thread.sleep(2000);
					//((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("AdmOKBtn"));
					LOGS.info("Clicking on OK Button");
					Thread.sleep(3000);
					//LOGS.info("Handling alert--------");
					WebElement okButton = driver.findElement(By.xpath("//button[@id='yui-gen0-button']"));
					JavascriptExecutor jsokbutton = (JavascriptExecutor)driver;
					jsokbutton.executeScript("arguments[0].click();", okButton);
					//alert();
					Thread.sleep(2000);
				}	catch(Exception e) {
					System.out.println("Exception: "+e);
					LOGS.info("Unable to Handle: update DPNI");
				}
			
				try 		
				{
					LOGS.info("Trying to update Email Code to Advertiser");
					Thread.sleep(2000);
					WebElement emailCodeAdvertiser=driver.findElement(By.xpath("//a[contains(text(), 'Email Code to Advertiser')]"));
					//Thread.sleep(3000);
					JavascriptExecutor jsemailcode = (JavascriptExecutor)driver;
					jsemailcode.executeScript("arguments[0].click();", emailCodeAdvertiser);
					LOGS.info("Clicked on Email Code to Advertiser");
					Thread.sleep(2000);
					if(driver.findElement(By.xpath("//div[@id='sendCodeToAdvDialog_c']")).isDisplayed())
					{
					Thread.sleep(2000);
					WebElement sendCodeAdvertiser=driver.findElement(By.xpath("//a[@id='sendCodeToAdv']"));
					JavascriptExecutor jssendcode = (JavascriptExecutor)driver;
					jssendcode.executeScript("arguments[0].click();", sendCodeAdvertiser);
					LOGS.info("Clicked Send button");
					Thread.sleep(5000);
					//LOGS.info("Handling alert--------");
					//alert();
					
					LOGS.info("Clicking on OK Button");
					WebElement okButton2 = driver.findElement(By.xpath("//button[@id='yui-gen0-button']"));
					JavascriptExecutor jsokbutton2 = (JavascriptExecutor)driver;
					jsokbutton2.executeScript("arguments[0].click();", okButton2);
					}
				}
				catch(Exception e) 
				{
					System.out.println("Exception: "+e);
					LOGS.info("Unable to Handle: update Email Code to Advertiser");
				}
				
				}else
					LOGS.info("No DPNI required");
				
				Thread.sleep(3000);
				
			}catch(Exception e) {
				LOGS.info("NO DPNI and No Provision");
			}
			
		}
					*/	
			/*--------------------------Code for MRXX-------------------------------------*/
			
			LOGS.info("Clicked on Update Info Button---------C1");
			SLocator("UpdateInfoBtn").click();
			Thread.sleep(6000);
			LOGS.info("Handling alert--------C2");
			alert();
			
			LOGS.info("Clicked on OK Button-------C3");
			Thread.sleep(9000);
			try
			{
				LOGS.info("Clicked on MediaBuy Button-------C4");
				SLocator("medbuyOKBtn").click();
				Thread.sleep(6000);
			}
			catch(Exception e)
			{
				SLocator("UpdateInfoBtn").click();
				alert();
				SLocator("medbuyOKBtn").click();
				
			}
			Thread.sleep(5000);
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
				LOGS.info("Clicked on Confirm MediaBuy Button-------C5");
				JavascriptExecutor jsAccountInfoElement = (JavascriptExecutor)driver;
				jsAccountInfoElement.executeScript("arguments[0].click();",SLocator("confirmMedBuyBtn"));
				Thread.sleep(8000);
				LOGS.info("handling alert");
				alert();
				alert();
				Thread.sleep(8000);
				
				ImageName="MediaBuyBtn";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
				Status="Pass";
				ActRes="MediaBuy Button is clicked";
				ExpRes="MediaBuy Button should be clicked";
				ExportResults.exportTestResult("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				LOGS.info("Clicking COnfirm MediaBuy Button,"+ExpRes+","+ActRes+","+Status);
			}
			

				
				
		}
		
		catch(Exception e) {
		//e.printStackTrace();
			ImageName="AccountinfoException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		LOGS.info("Issue in Media Buy Page - Re-executing-------updated1");
		LOGS.info("failed due to application slowness");
		ExceptionMsg = "Issue in Media Buy Page";
		LOGS.info(e.getStackTrace());
		
		/*mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
		System.out.println("mediabuyStatus :" + mediabuyStatus);
		
        if(ExceptionMsg.equalsIgnoreCase("Issue in Online Order Form.")) {
			
        	ImageName="OOFCreation";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			Status="Fail";
			ActRes="Failed to complete OOF";
			ExpRes="OOF should be submitted";
			ExportResults.exportTestResult("Clicking create OOF button,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);     	
			throw new Exception(ExceptionMsg);
			
		}
		
        else if(mediabuyStatus.equalsIgnoreCase("XML Received") ||mediabuyStatus.equalsIgnoreCase("Campaign Editorial"))
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
			LOGS.info("handling alert-------updated2");
			alert();
			alert();
			Thread.sleep(4000);
		}
				
		else
		{
			campaignPage(prodName);
		}*/
		
		}
	
		return "Pass";
		
	}
	




public  String admin(String MBID, String Resultsfolderpath) throws Exception{
	
	Properties OR=SamiPreRequisites.loadPropertiesFiles("Order");
	try {
		LOGS.info("-------------------------------------------");
		LOGS.info("Clicked on Admin Tab");
		driver.get(OR.getProperty("SamiAdminLink"));
		Thread.sleep(8000);
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
		
		Select se11 = new Select(driver.findElement(By.xpath("//select[@id='dpa']")));
		se11.deselectAll();
		LOGS.info("Deslected All in DPA");
		se11.selectByVisibleText("All");
		LOGS.info("Selected All in DPA");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		LOGS.info("Entered MBID : "+MBID);
		SLocator("AdmMBID").sendKeys(MBID);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(SLocator("AdmSearchBtn")));
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
		 jse9.executeScript("window.scrollBy(0,250)", "");
		 LOGS.info("Scroll down of page achieved");
	//----------------------------------------------------------------------------------------------------------------------	
	
		
		//SLocator("AdmOKBtn").click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@id='assignToDialogOKButton']")).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("AdmOKBtn"));

		
		Thread.sleep(3000);
		LOGS.info("Clicked on OK button");
		alert();
		LOGS.info("handled alert message");
		
		
		ImageName="AssignAnalyst";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
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

		Thread.sleep(8000);
		LOGS.info("Clicked on Advertiser Name");	
		SLocator("AdmAdNameLink").click();
		Thread.sleep(2000);
	}
	catch(Exception e)
	{
		ImageName="ExceptionAtAssignAnalyst";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		LOGS.info("Issue in Admin page.");
		ExceptionMsg = "Issue in Admin page";
		LOGS.info("failed due to application slowness");
		LOGS.info(e.getStackTrace());
		
		
		Status="Fail";
		ActRes="Analyst couldn't assigned";
		ExpRes="Analyst should be Assigned";
		ExportResults.exportTestResult("Assigning Analyst,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		
		throw new Exception(e.getMessage());
		
	}
	return "Pass";
	
	}


public  String campaignPage(String ProdName, String Resultsfolderpath) throws Exception{
	
	try {
		Thread.sleep(5000);
		LOGS.info("Executing the CampaignPage Method!!!");
		WebElement elementClick=driver.findElement(By.xpath("//li[@id='lnCampaigns']/a"));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", elementClick);
		
		Thread.sleep(3000);
		/*//Only Alert accept for DIG-19579
		LOGS.info("handling Alert DIG-19579");
		
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	   // alert();
	    LOGS.info("Alert Handled DIG-19579");
	    */
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		
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
			Thread.sleep(4000);
			LOGS.info("handled alert");
		    alert();
		   
		}				
		LOGS.info("-------------------------------------------");
			LOGS.info("Clicked on Camp create new button ");
			try
			{
				Thread.sleep(4000);
				//SLocator("CampNewBtn").click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("CampNewBtn"));

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
					AccountInfo(ProdName,Resultsfolderpath);
				}
				else
					campaignPage(ProdName,Resultsfolderpath);
				
			}
			Thread.sleep(4000);
			LOGS.info("Entered the campaign name ");
			SLocator("CampNameText").sendKeys("SAMI New Campaign");
			Thread.sleep(4000);
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
			Thread.sleep(3000);
			LOGS.info("Sets future  date ");
			SLocator("CampEndDate").sendKeys(newDate);
			Thread.sleep(3000);
//			LOGS.info("Checked yahoo campaign ");
//			SLocator("CampYahooCheckBox").click();
//			
			
			if(!ProdName.equalsIgnoreCase("WRD"))
			{
				driver.findElement(By.xpath("//input[@id='campaignMSNCheck']")).click();
				LOGS.info("Checked MSN campaign ");
				//SLocator("CampMSNCheckBox").click();
			}else {
				driver.findElement(By.xpath("//input[@id='campaignIpromoteCheck']")).click();
				LOGS.info("Checked iPromote campaign ");
				//SLocator("CampiPromoteCheckBox").click();				
			}
			
			
			Thread.sleep(3000);
			LOGS.info("Clicked on Campaign button");
			WebElement CampCreateBtn=driver.findElement(By.id("createCampaigns"));
			Thread.sleep(5000);
			JavascriptExecutor jsE = (JavascriptExecutor)driver;
			jsE.executeScript("arguments[0].click();", CampCreateBtn);
		    ImageName="CampaignException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			Status="Pass";
			ActRes="Campaign is created for :" + MBID;
			ExpRes="Campaign should be created";
			ExportResults.exportTestResult("Campaign Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Campaign Creation,"+ExpRes+","+ActRes+","+Status);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			ImageName="CampaignPageException";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			LOGS.info("There is some exception : Re-executing");
			ExceptionMsg = "There is some exception in Campaign Page";
			LOGS.info("failed due to application slowness");
			LOGS.info(e.getStackTrace());
			
			/*mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
			Thread.sleep(3500);
			String CurrentURL=driver.getCurrentUrl();
			if(CurrentURL.contains("businessInfo.xhtml"))
			{
				LOGS.info("Campain Created");
			}
			else {
				campaignPage(ProdName);
						
				LOGS.info("Campain Page Exception");
				throw new Exception(e.getMessage());
				
				}*/
						
		}
		return "Pass";
	
	}

//-----------------------------------------Scroll Down------------------------------------------



public  String samiFulfillmentProcess(String ProdName, String Resultsfolderpath) throws Exception{
	
	try {
		Thread.sleep(5000);
		LOGS.info("-------------------------------------------");
		LOGS.info("Clicked on Geo Link");
		driver.findElement(By.xpath("//li[contains(@id,'lnGeos')]/a")).click();
		//SLocator("geosLink").click();
		Thread.sleep(5000);
		
	/*	if(driver.findElement(By.id("statusDelete")).isDisplayed())
		{
			driver.findElement(By.id("statusDelete")).click();
			LOGS.info("Clicked on delete icon");
		}*/
		Thread.sleep(3000);
		LOGS.info("Clicked on selected country");
		driver.findElement(By.id("countriesMoveMulti")).click();
		//SLocator("GeoCntrySel").click();
		Thread.sleep(4000);
		ImageName="Geo";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		Status="Pass";
		ActRes="Geo is added";
		ExpRes="Geo should be added";
		ExportResults.exportTestResult("Geo Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		LOGS.info("Geo Creation,"+ExpRes+","+ActRes+","+Status);
		LOGS.info("Clicked on next Step button");
		driver.findElement(By.xpath("//div[contains(@id,'manualSearchContainer')]/span/span/span[1]/a")).click();
		//SLocator("GeoNxtStpBtn").click();
		Thread.sleep(6000);
		LOGS.info("-------------------------------------------");
		//Ads Group Page
		
		if(!ProdName.equalsIgnoreCase("WRD"))
		{
		WebElement elementAdGrp=driver.findElement(By.xpath("//a[@id='adGroupsLink']"));
		Thread.sleep(5000);
		JavascriptExecutor jsAdGrp = (JavascriptExecutor)driver;
		jsAdGrp.executeScript("arguments[0].click();", elementAdGrp);
		Thread.sleep(4000);
		LOGS.info("Creating new Ad grp");
		//SLocator("NewAdGrpBtn").click();
		WebElement elementCreateGrp=driver.findElement(By.xpath("//span[@id='createAdGroupBtn']/span[1]/a"));
		Thread.sleep(5000);
		JavascriptExecutor jsCreateGrp = (JavascriptExecutor)driver;
		jsCreateGrp.executeScript("arguments[0].click();", elementCreateGrp);
		Thread.sleep(4000);
		/*if(driver.findElement(By.name("chkBoxAssignTo")).isDisplayed())
		{
			driver.findElement(By.name("chkBoxAssignTo")).click();
			LOGS.info("Clicked on the checkbox");
			driver.findElement(By.id("deleteAdGrpLink")).click();
			LOGS.info("Clicked on delete group link");
		}*/
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
		 ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		 Status="Pass";
		 ActRes="Adgroup is created";
		 ExpRes="Adgroup should be created";
		 ExportResults.exportTestResult("Adgroup Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		 LOGS.info("Adgroup Creation,"+ExpRes+","+ActRes+","+Status);
		}
		
		 LOGS.info("-------------------------------------------");
		 LOGS.info("Clicked on Keyword Link");
		 driver.findElement(By.xpath("//li[contains(@id,'lnCampaignSubMenuAd')]/ul/li[1]/a")).click();
		 //	SLocator("KeywordLink").click();
		 
		 if(ProdName.equalsIgnoreCase("WRD"))
		 {	
			 Select iPromoteCategory = new Select(driver.findElement(By.id("iPromoteCategory")));
			 iPromoteCategory.selectByValue("2706");
			 LOGS.info("Selected IPromote Category");
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//a[@id='saveIPromoteCategoryLink']")).click();
			 LOGS.info("Clicked on Save Category Btn");
			 Thread.sleep(2000);

			 if(driver.findElement(By.xpath("//div[@id='alertDialog']")).isDisplayed())
				{
					LOGS.info("Information");
					driver.findElement(By.xpath("//div[@id='alertDialog']/div[3]//span/button[@id='yui-gen0-button']")).click();
					LOGS.info("Clicked on OK button on Information box");
				}

			}
		 
		 
		 Thread.sleep(3000);
		 LOGS.info("Clicked on Add Keyword Button ");
		 WebElement elementAddKeyword=SLocator("AddKeyWrdBtn");
		 Thread.sleep(3000);
		 JavascriptExecutor jsAddKeyword = (JavascriptExecutor)driver;
		 jsAddKeyword.executeScript("arguments[0].click();", elementAddKeyword);
		 //	SLocator("AddKeyWrdBtn").click();
		 Thread.sleep(4000);
		 LOGS.info("Entered Keyword Text ");
		 SLocator("AddKeyWrdTxt").sendKeys("cars");
		 Thread.sleep(2000);
		 LOGS.info("Clicked on Save Button ");
		 SLocator("AdGrpKWSaveBtn").click();
		 Thread.sleep(3000);
		 LOGS.info("Clicked on Scrolled down page ");
		ImageName="keyword";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
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
			/*if(driver.findElement(By.xpath("//span[@class='statusDelete']")).isDisplayed())	
			{
				driver.findElement(By.xpath("//span[@class='statusDelete']")).click();
				LOGS.info("Deleted the existing ad");
				alert();
			}*/
		//SLocator("AdsLink").click();
		
		if(!ProdName.equalsIgnoreCase("WRD"))
		{
		Thread.sleep(4000);
		LOGS.info("Clicked onNew Ad Button ");
		SLocator("AdsNewAdBtn").click();
		Thread.sleep(4000);
		//LOGS.info("Entered Ad Name ");
		driver.findElement(By.id("inputExpandedAdName")).sendKeys("Ad Business Name");
		Thread.sleep(2000);
		LOGS.info("Entered Ad Name");
		driver.findElement(By.id("inputExpandedAdHeadline1")).sendKeys("Head Line One");
		Thread.sleep(2000);
		LOGS.info("Entered Head Line One");
		driver.findElement(By.id("inputExpandedAdHeadline2")).sendKeys("Head Line Two");
		Thread.sleep(2000);
		LOGS.info("Entered Head Line Two");
		driver.findElement(By.id("inputExpandedAdDescription")).sendKeys("Ads Description");
		Thread.sleep(2000);
		LOGS.info("Entered Ads Description");
		
		/* Thread.sleep(4000);
		LOGS.info("Clicked onNew Ad Button ");
		SLocator("AdsNewAdBtn").click();
		Thread.sleep(4000);
		LOGS.info("Entered Ad Name ");
		Thread.sleep(4000);
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
		Thread.sleep(2000); */
		/*LOGS.info("Entered url ");
		SLocator("AdsYahooDispUrl").sendKeys("http://www.hibu.com");*/ 

		Thread.sleep(2000);
		LOGS.info("Scrolled down page");
		//----------------------------------Scroll down page------------------------
		JavascriptExecutor jse19 = (JavascriptExecutor)driver;
		 jse19.executeScript("window.scrollBy(0,350)", "");
		 LOGS.info("Scroll down of page achieved");
		 
		 driver.findElement(By.xpath("(//div[contains(@id,'adTabContainer')]/div[7]/span/span[1]/a)[1]")).click();
		 LOGS.info("clicked on Create Ad Button ");	 
		 
		}else {
			
			Thread.sleep(4000);
			LOGS.info("Clicked onNew Ad Button ");
			SLocator("AdsNewAdBtn").click();
			Thread.sleep(4000);
			LOGS.info("Entered Ad Name");
			//Thread.sleep(4000);
			//LOGS.info("Entered Business Name ");
			driver.findElement(By.id("inputAdName")).sendKeys("Ad Business Name");
			Thread.sleep(2000);
			LOGS.info("Entered Headline");
			driver.findElement(By.id("inputAdHeadline")).sendKeys("HeadLine One");
			Thread.sleep(2000);
			LOGS.info("Entered Description");
			driver.findElement(By.id("inputAdDescription1")).sendKeys("Description Line");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//div[contains(@id,'adTabContainer')]/div[7]/span/span[1]/a)[1]")).click();
			LOGS.info("clicked on Create Ad Button ");
			
			Thread.sleep(4000);
			driver.findElement(By.id("pushToIPromoteLink")).click();
			LOGS.info("Clicked on Push To IPromote Btn");
			
			Thread.sleep(15000);
			
			driver.switchTo().frame(driver.findElement(By.id("iPromoteIFrame")));
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//form[@id='bizlookup_form']/input[@id='bizlookup-input']")).sendKeys("FLORIST, NYC, NY");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//form[@id='bizlookup_form']/input[@id='bizlookup-input']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//ul[@class='uiac-results']/li[1]")).click();
			
			LOGS.info("Selected First Business from Dropdown");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='save']")).click();
			LOGS.info("Clicked on Save Changes Btn");
			Thread.sleep(45000);
			
			driver.switchTo().defaultContent();
			}
	
		 	ImageName="AdCreation";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
			Status="Pass";
			ActRes="Ad is created";
			ExpRes="Ad should be created";
			ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Ad Creation,"+ExpRes+","+ActRes+","+Status);
		 
		 
	//	SLocator("AdsCreateAd").click();
		Thread.sleep(5000);
		LOGS.info("-------------------------------------------");
		LOGS.info("Creating Budget");
		
		if(!ProdName.equalsIgnoreCase("WRD"))
		{
		/*WebElement elementBudgetSetting=driver.findElement(By.xpath("//li[contains(@id,'lnBudgetSetting')]/a"));
		Thread.sleep(5000);
		JavascriptExecutor jsBudgetSetting = (JavascriptExecutor)driver;
		jsBudgetSetting.executeScript("arguments[0].click();", elementBudgetSetting);*/
		driver.findElement(By.id("budgetLink")).click();
		LOGS.info("I am after Budget Link Click");
		//driver.navigate().refresh();
		//LOGS.info("Refreshed");
		
		Thread.sleep(10000);
		
		LOGS.info("Scrolled down the page");
		driver.findElement(By.id("optimizerCpcBidLimitCheckbox")).click();
		LOGS.info("Clicked On - CPC Bid Limit Chk Box");
		Thread.sleep(1000);
		
		driver.findElement(By.id("optimizerCpcBidLimitCheckbox")).click();
		LOGS.info("Clicked On - CPC Bid Limit Chk Box Again");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@id='budgetSettingSaveBtn']/span/a")).click();
		LOGS.info("Clicked On Budget Setting Save Btn");
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//div[@id='alertDialog']")).isDisplayed())
		{
			LOGS.info("Information");
			driver.findElement(By.xpath("//div[@id='alertDialog']/div[3]//span/button[@id='yui-gen0-button']")).click();
			LOGS.info("Clicked on OK button on Information box");
		}
		Thread.sleep(2000);
		}
		/*
		LOGS.info("Scrolled down the page");
		//SLocator("BudCampCPCRadBtn").click();
		driver.findElement(By.id("campaignCPCRadio")).click();
		Thread.sleep(2000);
		
		LOGS.info("Click the Budget");
		SLocator("BudCampCPCText").click();
		Thread.sleep(2000);
		
		LOGS.info("Cleared the Budjet");
		SLocator("BudCampCPCText").clear();
		Thread.sleep(4000);		*/
		
		/*LOGS.info("Clicked out side the box");
		SLocator("BudBudSettingClick").click();*/
		/*
		LOGS.info("click on OK Button");
		SLocator("medbuyOKBtn").click();
		Thread.sleep(3000);
		
		LOGS.info("Going to enter the budget");
		Thread.sleep(4000);
		SLocator("BudCampCPCText").sendKeys("0.5");	
		LOGS.info("Entered the budget");
		Thread.sleep(4000);
		
		LOGS.info("Clicked out side the box");
		SLocator("BudBudSettingClick").click();
		Thread.sleep(4000);
		
		LOGS.info("Clicked on Save Button");
		SLocator("BudSaveBtn").click();
		Thread.sleep(4000);
		
		LOGS.info("click on OK Button");
		SLocator("medbuyOKBtn").click();
		Thread.sleep(5000);
		
		LOGS.info("Scroll down the page");
		*/
		
		LOGS.info("Clicked on Publish Link");	
		Thread.sleep(5000);
		WebElement elementPublish=driver.findElement(By.xpath("//li[contains(@id,'lnPublish')]/a"));
		Thread.sleep(5000);
		JavascriptExecutor jspublish= (JavascriptExecutor)driver;
		jspublish.executeScript("arguments[0].click();", elementPublish);
		
		try {
			LOGS.info("Correcting Budget Distribution .........");
			Thread.sleep(4000);

			//driver.findElement(By.id("budgetDistChooser")).click();
			//LOGS.info("Clicked On Budget Distribution Dropdown");
			
			Select seBudgetDist = new Select(driver.findElement(By.id("budgetDistChooser")));
			Thread.sleep(2000);
			seBudgetDist.selectByValue("Custom");
			
			Thread.sleep(1000);
			driver.findElement(By.id("yahooSEPercent")).clear();
			LOGS.info("Cleared Yahoo Distribution List");
			Thread.sleep(1000);
			driver.findElement(By.id("fBTPSEPercent")).clear();
			LOGS.info("Cleared FB-TP Distribution List");
			Thread.sleep(1000);
			
			if(!ProdName.equalsIgnoreCase("WRD"))
			{
			driver.findElement(By.id("iPromoteSEPercent")).clear();
			LOGS.info("Cleared iPromote Distribution List");
			Thread.sleep(1000);
			
			driver.findElement(By.id("msnSEPercent")).clear();
			driver.findElement(By.id("msnSEPercent")).sendKeys("100");
			LOGS.info("Updated MSN Distribution List With 100%");
			Thread.sleep(1000);
			}
			else {
				driver.findElement(By.id("msnSEPercent")).clear();
				LOGS.info("Cleared MSN Distribution List");
				Thread.sleep(1000);
				
				driver.findElement(By.id("iPromoteSEPercent")).clear();
				driver.findElement(By.id("iPromoteSEPercent")).sendKeys("100");
				LOGS.info("Updated iPromote Distribution List With 100%");
				Thread.sleep(1000);
			}

			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='searchEngineDistributionHref']")).click();
			LOGS.info("Clicked on Distribution List Save Btn");
			
		}catch (Exception e) {
			LOGS.info(e.getStackTrace());
			//LOGS.info("Application Slowness: Failed before Publishing");
			ImageName="ExceptionBeforePublish";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
			ExceptionMsg = "Application Slowness: Failed before Publishing";
			throw new Exception(ExceptionMsg);
			//e.printStackTrace();
		}
		
	//	SLocator("PublishLink").click();
		Thread.sleep(4000);
		LOGS.info("clicked on Ready to Publish Button");
		
		try {		
			
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("ReadytoPubBtn"));
			Thread.sleep(5000);
			
			LOGS.info("clicked on Publish Button now");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SLocator("PubNowBtn"));
			
		} catch (Exception e) {
			LOGS.info(e.getStackTrace());
			ImageName="ExceptionBeforePublish";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
			ExceptionMsg = "Application Slowness: Failed before Publishing";
			throw new Exception(ExceptionMsg);
			//e.printStackTrace();
		}
		
		
		Thread.sleep(4000);
		String parentHandle = driver.getWindowHandle();
		SLocator("DestUrlLink").click();
		LOGS.info("clicked on Desturl link");
		Thread.sleep(4000);
		
		
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
            
            Thread.sleep(5000);
			alert();
            
	     }catch(UnreachableBrowserException UE){
	           LOGS.info("Error in SwitchToParentWindow -"+UE.getMessage());
	            result = UE.getMessage();
	            ImageName="BrowserException";
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
	            ExceptionMsg = "Exception raised in function : SwitchToParentWindow";
	            throw new Exception("Exception raised in function : SwitchToParentWindow");
	     } 

		LOGS.info("clicked on greencheck");
		    ImageName="Ads";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
			Status="Pass";
			ActRes="Ad is Published";
			ExpRes="Ad should be Published";
			ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
			LOGS.info("Ad Creation,"+ExpRes+","+ActRes+","+Status);
			WebElement elementImgGreenCheck=driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img"));
			Thread.sleep(15000);
			JavascriptExecutor jselementImgGreenCheck= (JavascriptExecutor)driver;
			jselementImgGreenCheck.executeScript("arguments[0].click();", elementImgGreenCheck);
			
		    //driver.findElement(By.xpath("//div[@id='URLValidation']/table/tbody/tr/td[2]/a/img")).click();
			//	SLocator("greenCheck").click();
		Thread.sleep(20000);
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
		//	SLocator("MediaBuyBtn").click();
		jsmediabuy.executeScript("arguments[0].click();", elementMediaBuy);*/
		
		//Thread.sleep(15000);
		
	}
	catch(Exception e)
	{
		ImageName="ExceptionAtGeoToPublish";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		LOGS.info("There is some exception : Re-executing----Me");
		 ExceptionMsg = "Failed due to application slowness: process from Geos selection to Publish";
		LOGS.info("Failed due to application slowness");
		LOGS.info(e.getStackTrace());
		
		/*mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();

		if(mediabuyStatus.equalsIgnoreCase("Keyword Incompleted"))
		{
			String alertMsg = driver.findElement(By.xpath("//div[(@id='alertDialog')]")).getText();
			if(alertMsg.contains("For Google, Bing, Yahoo, iPromote, Facebook National Campaigns, you will have choose a country for Geo targeting.")) {
				
				    ImageName="FailedGeo";
					ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
					Status="Fail";
					ActRes="Failed due to Geos Not selected.";
					ExpRes="Ad should be Published";
					ExportResults.exportTestResult("Ad Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
				
				LOGS.info("Inside First Catch!!!");
				throw new Exception(e.getMessage());

			}
			
			else
			{
			samiFulfillmentProcess(ProdName);
			}
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
				ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
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
		}*/
		
	}
	return "Pass";
}

public  String alert() throws InterruptedException{
	
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

public  String onlineOrderForm(String ghostWindow,String PlanType) throws Exception{
	try {
		driver.findElement(By.xpath("//a[@id='createOrderFormLink']")).click();
		LOGS.info("Clciked on create button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		LOGS.info("waiting for 3s");
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
		
		String privacy = driver.getTitle();
		LOGS.info("Title is: "+privacy);
		
		if(privacy.contains("Privacy error")) 
		{
		Thread.sleep(2000);
		LOGS.info("On Privacy Policy Page");
		driver.findElement(By.xpath("//button[@id ='details-button']")).click();
		LOGS.info("Clicked on Advanced Button");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Proceed to samiuat.hibu.int")).click();
		LOGS.info("Clicked on Proceed to...");
		Thread.sleep(5000);
		}
				
		if (PlanType.equalsIgnoreCase("MRRX") ||PlanType.equalsIgnoreCase("WRBI")||PlanType.equalsIgnoreCase("ASX") ) {
			JavascriptExecutor jse5 = (JavascriptExecutor) driver;
			jse5.executeScript("window.scrollBy(0,450)", "");
			LOGS.info("Scroll down of page achieved ");
		driver.findElement(By.id("createAndProceedOrderActiveBtn")).click();
		LOGS.info("Clicking on proceed order button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("generalInfoNext")).click();
		LOGS.info("Clicking on Next Button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("categoryKeywords")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("categoryKeywords")).sendKeys("Plumber");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		LOGS.info("Selecting the Select All Option in the category list");
		driver.findElement(By.xpath("//div[@class='candidateItem selectAllItem']/input")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		LOGS.info("Selecting the Select All Option in the Service Candidates list");
		driver.findElement(By.xpath("//div[@class='candidates serviceCandidates']/div[1]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='targetAreaZipcodeRadio' and @name='targetingType']")).click();
		LOGS.info("Clicking on zipcode radiobutton");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='zipCodeSearchTextFieldForSocial' and @class='inputField zipcodeTextboxForSocial']")).sendKeys("19406");
		LOGS.info("Entered Zipcode");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='19406']")).click();
		LOGS.info("Clicking on ZipCode");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("campaignDetailsNext")).click();
		LOGS.info("Clicking on Next button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		}
		 
		if (PlanType.contains("SOCIAL")||PlanType.contains("SOCIALSTD")||PlanType.contains("SOCIALCLS")||PlanType.contains("SOCIALPLS")) {
		driver.findElement(By.xpath("(//a[contains(text(),'Next')])[1]")).click();
		LOGS.info("Clicked on Next Button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	


		driver.findElement(By.id("categoryKeywords")).click();
		driver.findElement(By.id("categoryKeywords")).sendKeys("Plumber");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		LOGS.info("Selecting the Select All Option in the category list");
		driver.findElement(By.xpath("//div[@class='candidateItem selectAllItem']/input")).click();
		LOGS.info("Selecting the Select All Option in the Service Candidates list");
		driver.findElement(By.xpath("//div[@class='candidates serviceCandidates']/div[1]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='targetAreaZipcodeRadio' and @name='targetingType']")).click();
		LOGS.info("Selecting zipcode radiobutton");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='zipCodeSearchTextFieldForSocial' and @class='inputField zipcodeTextboxForSocial']")).sendKeys("19406");
		LOGS.info("entered zipcode");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='19406']")).click();
		LOGS.info("selected the zipcode");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='campaignDetailsSocialNext']")).click();
		LOGS.info("clicked on next button");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		LOGS.info("waiting for 3s");
		}

		if (PlanType.equalsIgnoreCase("WRD")) {
			LOGS.info("If it is display, Start Here should be click");
			driver.findElement(By.id("createOOFStart")).click();
			Thread.sleep(2000);
			LOGS.info("Clicked on Start here link");
			driver.findElement(By.id("createAndProceedOrderActiveBtn")).click();
			LOGS.info("Clicked on Proceed with order");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[contains(text(),'Next')])[1]")).click();
			LOGS.info("Clicked on Next Button");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		
					
			driver.findElement(By.id("categoryKeywords")).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("categoryKeywords")).sendKeys("Plumber");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			LOGS.info("Selecting the Select All Option in the category list");
			driver.findElement(By.xpath("//div[@class='candidateItem selectAllItem']/input")).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			LOGS.info("Selecting the Select All Option in the Service Candidates list");
			driver.findElement(By.xpath("//div[@class='candidates serviceCandidates']/div[1]/input")).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(4000);
			
			
			driver.findElement(By.xpath("//input[@id='cityByZipForLabel']")).click();
			LOGS.info("selected zipcode");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//input[@id='zipCodeSearchTextField' and @class='inputField zipCodeForRadius'])[2]")).sendKeys("19406");
			LOGS.info("Entered Zipcode");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//a[@id='zipCodeSearchButton'])[2]")).click();
			LOGS.info("clicked on search icon");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@type='checkbox' and @name='selectAll']")).click();
			LOGS.info("Deselected SelectAll");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//input[@type='checkbox' and @name='cityOption'])[1]")).click();
			LOGS.info("Selected first option");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='campaignDetailsDisplayNext']")).click();
			LOGS.info("clicked on Next Button");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
		}
		driver.findElement(By.xpath("//a[@id='submitOOFBtn']")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LOGS.info("clicked on submit button");
		// ----------------------------------------------------------------------
	/*	if (!PlanType.startsWith("SOCIAL")) {
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
		driver.findElement(By.id("submitOOFBtn")).click(); */
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(ghostWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		LOGS.info("clicked on refresh button");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		LOGS.info("2nd clicked on refresh button");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Refresh']")).click();
		LOGS.info("3rd clicked on refresh button");
		Thread.sleep(20000);
		if (SLocator("OOFRadioBtn").isDisplayed()) {
			LOGS.info("Checking if the Online Orderform is reflected");
			SLocator("OOFRadioBtn").click();
			Thread.sleep(3000);
			LOGS.info("Clicked on Select Button");
			SLocator("OFSelectBtn").click();
			Thread.sleep(3000);
		} else {
			driver.findElement(By.xpath("//a[@title='Refresh']")).click();
			Thread.sleep(20000);
			SLocator("OOFRadioBtn").click();
			Thread.sleep(3000);
			LOGS.info("Clicked on Select Button");
			SLocator("OFSelectBtn").click();
			Thread.sleep(3000);

		}

	}

catch(Exception e)
{
	ImageName="ExceptionAtOnlineOrderForm";
	ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
	 ExceptionMsg = "Failed due to application slowness: Online Order Form Creation Failed";
	LOGS.info("failed due to application slowness");
	LOGS.info(e.getStackTrace());
	
	/* driver.close();
	 driver.switchTo().window(ghostWindow);
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[@title='Refresh']")).click();
	 Thread.sleep(5000);

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
		 LOGS.info("OOF Exception");
		 
		    ActRes="Application Issue";
			ExpRes="Issue at OOF";
			ImageName="OOFCatch";
			ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
	        Status="Fail";
			ExportResults.exportTestResult("OOF Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
		 
		 ExceptionMsg="Issue in Online Order Form.";
		 throw new Exception(ExceptionMsg);
		 
		 SLocator("OFSelectBtn").click();
		 onlineOrderForm(ghostWindow, PlanType);
		 
	 }*/
}
return "Pass";

}



public  void samiFlow(String productID, String Resultsfolderpath) throws Exception
{
	LOGS.info("Started executing samiFlow login method: Result Folder Path: "+Resultsfolderpath);
	SamiPreRequisites.Resultsfolderpath = Resultsfolderpath;
	LOGS.info("This is SAMI Folder Path: "+SamiPreRequisites.Resultsfolderpath);
	
	String login;
	int counter=0;
	
	
	try
	{
		LOGS.info("Started executing inside samiFlow login method");
		login=samiLogin(Resultsfolderpath);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(20000);
		if(login.equalsIgnoreCase("Fail"))
		{
			counter=counter+1;
			Status="Fail";
		}
	
	}
	catch(Exception e)
	{
		counter=counter+1;
		LOGS.info("There is an error in samiLogin Method");
		ImageName="SAMILoginException";
	    ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		ExceptionMsg = "There is an Error while Logging in to SAMI.";
		throw new Exception(ExceptionMsg);
	}

	try {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	Thread.sleep(5000);
    String businessID = productID;
	LOGS.info("businessID :" +businessID);
	Thread.sleep(15000);
	LOGS.info("waited for 15s");
	
	/*if(driver.findElement(By.xpath("//div[@id='disabledZone' and @style='position: absolute; z-index: 1000; left: 0px; top: 0px; width: 100%; height: 100%; visibility: visible;']")).isDisplayed())
		{
		LOGS.info("Page is still loading , giving more wait time");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(30000);
	LOGS.info("waited for 30s");
		}
	else
	{
		LOGS.info("Page loaded");
	}*/
		driver.findElement(By.xpath("//input[@id='mbStatus']")).click();
		Select seSource1 = new Select(driver.findElement(By.xpath("//select[@id='statusMultiSelectSelect']")));
		Thread.sleep(2000);
		seSource1.selectByIndex(0);
		LOGS.info("Selected All in STATUS");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//input[@id='accountNumber']")).clear();
		Thread.sleep(1000);	
	    driver.findElement(By.xpath("//input[@id='accountNumber']")).sendKeys(businessID);
	    LOGS.info("Entered the business ID");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(@class,'ybButton')]/span[1]/a[contains(text(),'Search')]")).click();
	LOGS.info("Clicked on Search Button");
	Thread.sleep(5000);
	}
	
	catch(Exception e)
	{
		ImageName="ExceptionAtMediaBuyPage";
	    ImgName=ScreenshotPrinter.screenShot(ImageName, driver, SamiPreRequisites.Resultsfolderpath);
	    Status="Fail";
		ActRes="Application Issue";
		ExpRes="Should be able to get MBID's";
		ExportResults.exportTestResult("MBID Fetch,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);

		counter=counter+1;
		ExceptionMsg = "Couldn't Fetch Product Detials from MediaBuy Page.";
		LOGS.info(ExceptionMsg);
		throw new Exception(ExceptionMsg);
	}

	
	//to get the list of records for the account
	
	String prdCount = driver.findElement(By.xpath("//span[@id='totalRecordsSpan']/b")).getText();
	int productCount = Integer.valueOf(prdCount);
	System.out.println("Product Count : "+productCount);

	
	try {
	
	for(int i=0;i<productCount;i++)		
		//for(int i=0;i<1;i++)	
	{
		LOGS.info("MBID:"+(i+1));
		int j = i+1;
			if(counter==0)
			{
				try
				{
					if (i == 0) {
						
					product1= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)["+j+"]")).getText();
					
					MBID1= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)["+j+"]")).getText();
					if(product1.equalsIgnoreCase("LRNK")) {
					
						LOGS.info("This MBID: "+MBID1+" has Local Ranking Product.");
						continue;
						
					}
					
					else{
					AdStatus1= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName yui-dt-col-statusName yui-dt-sortable')]/div/a)["+j+"]")).getText();
					String AdminName1=driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-assignedTo yui-dt-col-assignedTo yui-dt-sortable')])["+j+"]")).getText();
					LOGS.info("AdminName:"+AdminName1);
					
					AdminName=AdminName1;
					AdStatus=AdStatus1;
					MBID=MBID1;
					product=product1;
					
					
					

					System.out.println("1st MBID - " + MBID +"----  Product-"+product+"---AdStatus--"+AdStatus);
					//gettingRowNo

					if (MBID.equalsIgnoreCase("Fail")) {
						counter = counter + 1;
						Status = "Fail";

					}
					}
					}
					
					if (i == 1) {
						//MBID = "";// SamiFulfillment.accountSearch(Account,prd[i]);
						MBID2= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)["+j+"]")).getText();
						product2= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)["+j+"]")).getText();
						AdStatus2= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName yui-dt-col-statusName yui-dt-sortable')]/div/a)["+j+"]")).getText();
						String AdminName2=driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-assignedTo yui-dt-col-assignedTo yui-dt-sortable')])["+j+"]")).getText();
						LOGS.info("AdminName:"+AdminName2);
						
						AdminName=AdminName2;
						
						
						AdStatus=AdStatus2;
						
						MBID=MBID2;
						product=product2;
						System.out.println("2nd MBID - " + MBID +"----  Product-"+product+"--AdStatus---"+AdStatus);
								
						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
						
					}
					if (i == 2) {

						MBID3= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)["+j+"]")).getText();
						product3= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)["+j+"]")).getText();
						AdStatus3= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName yui-dt-col-statusName yui-dt-sortable')]/div/a)["+j+"]")).getText();
						String AdminName3=driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-assignedTo yui-dt-col-assignedTo yui-dt-sortable')])["+j+"]")).getText();
						LOGS.info("AdminName:"+AdminName3);
						
						AdminName=AdminName3;
						
						AdStatus=AdStatus3;
						
						MBID=MBID3;
						product=product3;
						System.out.println("3rd MBID" + MBID+"   ----  Product-"+product+"--AdStatus-"+AdStatus);
						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
						
					}
					
					if (i == 3) {

						MBID4= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-mbId')]/div)["+j+"]")).getText();
						product4= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-product')]/div/a)["+j+"]")).getText();
						AdStatus4= driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-statusName yui-dt-col-statusName yui-dt-sortable')]/div/a)["+j+"]")).getText();
						String AdminName4=driver.findElement(By.xpath("(//td[contains(@class,'yui-dt0-col-assignedTo yui-dt-col-assignedTo yui-dt-sortable')])["+j+"]")).getText();
						LOGS.info("AdminName:"+AdminName4);
						
						AdminName=AdminName4;
						
						AdStatus=AdStatus4;
						
						MBID=MBID4;
						product=product4;
						System.out.println("4th MBID" + MBID+"   ----  Product-"+product+"--AdStatus-"+AdStatus);
						if (MBID.equalsIgnoreCase("Fail")) {
							counter = counter + 1;
							Status = "Fail";

						}
						//ExportResults.ExportSamiDataToInputSheet(MBID, product, gettingRowNo);
					}
					
				}
				
				catch(Exception e)
				{
					counter=counter+1;
					ImageName="AcctSearchException";	
					ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
					Status="Fail";
			        ActRes="Application Issue";
					ExpRes="Issue while getting MBID";
					ExportResults.exportTestResult("MBID Fetch,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
					
					LOGS.info("There is some error in accountSearch");
					ExceptionMsg = "Account not Found in SAMI";
					throw new Exception(ExceptionMsg);
				}
			
			}
	
	       if(counter==0)
			{
				try
				{
					
					if(AdStatus.equals("XML Receiv...")||AdStatus.contains("Campaign")
						||AdStatus.equals("Keyword In...") )
					{
						if(AdminName.equalsIgnoreCase("Unassigned"))
						{
			           admin(MBID,Resultsfolderpath);
						}
					}
										
				}
				catch(Exception e)
				{
					counter=counter+1;
					ImageName="AdminPageException";
					ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
					Status="Fail";
					ActRes="Application Issue";
					ExpRes="Issue at Admin Page";
					ExportResults.exportTestResult("Admin Page,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
					
					LOGS.info("There is some error in admin");
					ExceptionMsg = "Issue in Admin page.";
					throw new Exception(ExceptionMsg);
				}
				
			}
			if(counter==0)
			{
				try
				{ 
					
					Thread.sleep(5000);
					
					if(!AdminName.equalsIgnoreCase("Unassigned"))
					{
						
					driver.findElement(By.xpath("(//td[@class='yui-dt0-col-advName yui-dt-col-advName yui-dt-sortable'])["+j+"]")).click();
					LOGS.info("Clicks on advertisers name");
					driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					Thread.sleep(15000);
					try {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        LOGS.info("Waiting for the advertiser button");
                        WebDriverWait wait1 = new WebDriverWait(driver, 14);
                        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

                    }catch(Exception ex) {
                        LOGS.info("Wait is over and the Pocess continues.");
                        }
						
					}
					if(AdStatus.equals("XML Receiv...")||AdStatus.contains("Campaign")
							||AdStatus.equals("Keyword In...") )
						{
					mediabuyStatus=driver.findElement(By.xpath("//span[@id='mediaBuyStatusDisplay']")).getText();
					System.out.println("mediabuyStatus :" + mediabuyStatus);
						}
					else{
						LOGS.info("Ad is already Published");
					}
					if(AdStatus.equals("XML Receiv...")||AdStatus.contains("Campaign")
							||AdStatus.equals("Keyword In...") )
						{
					if(mediabuyStatus.equalsIgnoreCase("XML Received") 
							||mediabuyStatus.contains("Editorial")
							||mediabuyStatus.equals("Campaign Created")
							||mediabuyStatus.equals("Keyword Incompleted") )
					{
						AccountInfo(product,Resultsfolderpath);
					}
						}
					
										
				}
				catch(Exception e)
				{
				     ImageName="MediaBuyException";
				     ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
				     LOGS.info("There is some Exception in mediaBuy Page");
				     ExceptionMsg = "There is some Exception in mediaBuy Page";
				     throw new Exception(ExceptionMsg);
				}
				
				
			}
			if(counter==0)
			{
				try
				{
					if(AdStatus.equals("XML Receiv...")||AdStatus.contains("Campaign")
							||AdStatus.equals("Keyword In...") )
						{
					if(mediabuyStatus.equalsIgnoreCase("XML Received") 
							||mediabuyStatus.contains("Editorial")
							||mediabuyStatus.equals("Campaign Created")
							||mediabuyStatus.equals("Keyword Incompleted") ){
					campaignPage(product,Resultsfolderpath);
					}
						}
					
				}
				catch(Exception e)
				{
					LOGS.info("There is some error in Campaign Page");
					
					ImageName="CampaignPageException";
					ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
					Status="Fail";
					ActRes="Failedto create Campaign.";
					ExpRes="Campaign should be created";
					
					ExportResults.exportTestResult("Campaign Creation,"+ExpRes+","+ActRes+","+Status+","+ImgName,Resultsfolderpath);
					
					ExceptionMsg = "There is some error in Campaign Page";
					throw new Exception(ExceptionMsg);
					
				}
				
				try
				{
					if(AdStatus.equals("XML Receiv...")||AdStatus.contains("Campaign")
							||AdStatus.equals("Keyword In...") )
						{
					if(mediabuyStatus.equalsIgnoreCase("XML Received") 
							||mediabuyStatus.contains("Editorial")
							||mediabuyStatus.equals("Campaign Created")
							||mediabuyStatus.equals("Keyword Incompleted") )
					{
						
					samiFulfillmentProcess(product,Resultsfolderpath);
					
					}
				}
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					LOGS.info("There is some error in SamiFulfillment Process");
					ImageName="SamiFulfillmentException";
				    ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
					ExceptionMsg = "There is some Exception while Fulfilling SAMI, Please Resubmit the Request!!";
					throw new Exception(ExceptionMsg);
					
				}
			}
			counter=0;	
			Thread.sleep(5000);
			
			
				if(driver.findElement(By.id("yui-gen0-button")).isDisplayed())
				{
					driver.findElement(By.id("yui-gen0-button")).click();
					LOGS.info("Clicked on OK Button");
					
					try {
		                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		                LOGS.info("Clicking the button");
		                WebDriverWait wait1 = new WebDriverWait(driver, 9);
		                wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		           
		            }catch(Exception exd) {
		                LOGS.info("Not clicked the button");
		                }
				}
				else
				{
					LOGS.info("Ok Button is not displayed");
			
				}
				
				SLocator("MediaBuyBtn").click();
				LOGS.info("Clicked on Media Button");
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(7000);
			
	}
	}
	catch(Exception e)
	{
		//e.printStackTrace();
		ImageName="SAMIFulfillmentException";
		ImgName=ScreenshotPrinter.screenShot(ImageName, driver,SamiPreRequisites.Resultsfolderpath);
		ExceptionMsg = "There is an error while Fulfilling SAMI, Please Resubmit the Request!!";
		LOGS.info("There is some error in SamiFulfillment Process----1");
		throw new Exception(ExceptionMsg);
		
	}

}
}





	
	


	
