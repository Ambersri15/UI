package com.hibu.tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RCFProvisioning extends PreRequisites {

	

	//public static Logger LOGS = Logger.getLogger(RCFProvisioning.class.getName());
	public static Logger LOGS = LogManager.getLogger(RCFProvisioning.class.getName());
	// static String ActRes, ExpRes, Status, ImagePath, ImageName, ImgName;
	WebDriverWait wait;
	
	PreRequisites pr = new PreRequisites();
	ScreenshotPrinter ScreenshotPrinter= new ScreenshotPrinter();
	ExportResults ExportResults= new ExportResults();
	InflightOrderQry InflightOrderQry = new InflightOrderQry();
	DriverFactory DF = new DriverFactory();
	public  String TotSpend, consType, ConPOSPhoneNo, POSConphoneNo, RepContactPhoneNo;
	public  String SelectConsltnRslt, paymntRslt, submitRslt = "Pass", User, OneTimeFeeQuoteDetls,
			BusinessNameQuoteDetls;

	public String YextLoginResults,AELoginResult,PaymtAmtPaymentPg, PhoneNumPaymentPg, confirmationNumber, ParentWindow;
	 public String ActResOpp, ActResCase, ExpResCase, ExpResProd, ActResProd, SalesForceLoginResult,
	ValidateOrderPlacementRes, CaseType, LeadCreationResult, searchAccountResult, ValidateProductResult,
	existingCustomerResult, validateDuplicayResults, ExpResType, ActResExt, ExpOpp, ActOpp, ActResType,
	ActStatus, ExpStatus, ActResAtc, ExpResAtc, ExpResDup;
	 public String myalertvalidation, myalert2validation, ExpValMsg, FStrtVal;
	 public String ValidateOpptResult, CreateQuoteResult, ValidateQuoteRes, AddProdResult, FutStrtRes, EnterBudgetResul;
	 public String ActoppStatus, ExtoppStatus, ActProdCompName, caseType, consPhno, caseStatus, expCaseStatus,
	expCaseType, expConsType, expskillgroup;
	 ArrayList<String> ProductDescription = new ArrayList<String>();
	 ArrayList<String> ProductName = new ArrayList<String>();
	 ArrayList<String> getSubscriptionID = new ArrayList<String>();
	 String AllProductname, pname, SRep, ExistingProduct;
	 String validation, QPageQNo, oneTimeFeesTotal = "", TaxTotal = "", MonthlyInvestmentTotal = "",
			Oppwindow = "", ContractDetailsResult;
	 Properties DP = pr.loadPropertiesFiles("Daywise");
	public  String NewOppturl, OptText = "";
	public  double convertMinBudg;
	public  String ResultStatus = "Pass", CreateQ = "", CSRep = "", CancelproductRes = "";
	public String SalesRep = "";
	public  String SFLoginResult = "", OpportunityResults = "", ValidateQuoteResult = "",
			SearchActiveAccountResults = "", SubmitFinalPageRslt = "", GenerateDocumentResult = "",
			OpportunityValidationResult = "";
	public  String captSignResult = "", SelConsultResult = "", PaymentResult = "", calcelproductResult = "",
			CaseURL;
	public  int LivSubsCount, SCVal, i, j, RowsBeforeAdd, prodCount;
	
	public  Properties OR = pr.loadPropertiesFiles("Plan");
	public String reinstateFlag = "";
	public String monthly_budget[] = new String[4];
	public int portNO;
	
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
				//chromeOptions.addArguments("--incognito");// comment it when you are running in windows
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
		       caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
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
	
	

	
	
	public  String SalesforceLogin(String User, String Pwd) throws Exception {
		try {
			String path = regardingfilesPath+"InputFiles/Order.properties";
			LOGS.info(Thread.currentThread() +path);
			

			// LOGS.info(Thread.currentThread() +OR.getProperty(User));
			LOGS.info(Thread.currentThread() +"Salesforce Login Method");
		
			//Linux Settings
			//driver = linuxSettings();
			
	    
	       
	        //windows Settings
			driver = windowsSettings();
	       
			
		     
			
			
		    
	       
			if (SFInspectorPlugin.equalsIgnoreCase("True")) {
				LOGS.info(Thread.currentThread() +"Launching Chrome with SF inspector extension");
				
				String ExtensionPath = System.getProperty("user.home")
						+ "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aodjmnfhjibkcdimpodiifdjnnncaafh\\1.11_0";
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("load-extension=" + ExtensionPath);
				driver = new ChromeDriver(options);
			}
			
			else if (contractDownload.equalsIgnoreCase("Yes") || signatureDownload.equalsIgnoreCase("Yes")) {

				driver = new ChromeDriver();
				driver.get("chrome://settings/content/pdfDocuments?search=Site+Settings");
				//Thread.sleep(5000);

				WebElement downloadPrompt = driver
						.findElement(By.xpath("//input[@pref='download.prompt_for_download']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadPrompt);

				//Thread.sleep(2000);
			} else {
				//driver = new ChromeDriver(chromeOptions);
				
				//driver = new ChromeDriver();
				//DriverFactory DF = new DriverFactory();
				/*LOGS.info(Thread.currentThread() +"Heyy I am DriverFactory Class");
				driver = DriverFactory.getInstance().getDriver();*/
				
				LOGS.info(Thread.currentThread() +"Chrome Driver initialization");
				DF.setDriver(driver);
				LOGS.info(Thread.currentThread() +"hey---4"+DF);
				LOGS.info("driver value: "+driver);
				driver = DF.getDriver();
				
				
				
				
				
				
			}
			
			//driver.navigate().to("https://hibu--full01.my.salesforce.com");
			driver.navigate().to("https://test.salesforce.com");
			LOGS.info(Thread.currentThread() +"URL launched");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LOGS.info(Thread.currentThread() +"Current Page Title is :" + driver.getTitle());
			LOGS.info(Thread.currentThread() +"Current Page URL is :" + driver.getCurrentUrl());
			
				
			
			if(SalesRepType.trim().equalsIgnoreCase("TSales")) {
				LOGS.info(Thread.currentThread() +User+"*********************************"+Pwd);
				Locator("salesforceUser").sendKeys(User);
				Locator("salesforcePwd").sendKeys(Pwd);
			}
			else {
				Properties OR = pr.loadPropertiesFiles("Order");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + OR.getProperty(User));
				LOGS.info(Thread.currentThread() +OR.getProperty(User)+"*********************************"+OR.getProperty(Pwd));
			Locator("salesforceUser").sendKeys(OR.getProperty(User));
			Locator("salesforcePwd").sendKeys(OR.getProperty(Pwd));
			}
			long Seconds = 60;
			wait = new WebDriverWait(driver, Seconds);
			
			
			Locator("SalesforceLogin").click();
			LOGS.info(Thread.currentThread() +"Login button Clicked");
			//Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
			
			ActRes = driver.getCurrentUrl();
			ExpRes = "Salesforce page should contain the URL full01 ";
			LOGS.info("Salesforce Page URL: "+ActRes);
			
			
			
			try {
				LOGS.info("Results Folder Path value: "+Resultsfolderpath);
				LOGS.info("Results Folder Path value: "+pr.Resultsfolderpath);

				WebElement HomeTab = driver.findElement(By.cssSelector("#home_Tab>a"));
				
				wait.until(ExpectedConditions.elementToBeClickable(HomeTab));
				
				
				JavascriptExecutor jsHT = (JavascriptExecutor) driver;
				jsHT.executeScript("arguments[0].click();", HomeTab);
				
				SalesForceLoginResult = "Pass";
				Status = "Pass";

				
				ExportResults.exportTestResult(
						"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + "No Image",pr.Resultsfolderpath);
				
				LOGS.info(Thread.currentThread() +"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);
			}catch (Exception e) {
				
				LOGS.info("after Login Waited for Home page but needs more time to load");
				LOGS.error("Unable to Login to Salesforce at first: "+e.getMessage());
				ActRes = driver.getCurrentUrl();
				ExpRes = "Salesforce page should contain the URL full01 ";
				LOGS.info("Salesforce Page URL: "+ActRes);
				
				if (ActRes.contains("full01")) {
					
					SalesForceLoginResult = "Pass";
					Status = "Pass";

					LOGS.info("Results Folder Path value: "+Resultsfolderpath);
					LOGS.info("Results Folder Path value: "+pr.Resultsfolderpath);
					ExportResults.exportTestResult(
							"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + "No Image",pr.Resultsfolderpath);
					LOGS.info(Thread.currentThread() +"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);

					WebElement HomeTab = driver.findElement(By.cssSelector("#home_Tab>a"));
					wait.until(ExpectedConditions.elementToBeClickable(HomeTab));
					
					JavascriptExecutor jsHT = (JavascriptExecutor) driver;
					jsHT.executeScript("arguments[0].click();", HomeTab);

					return SalesForceLoginResult;

				} else {
					SalesForceLoginResult = "Fail";
					ExceptionMsg= "Exception Happened while Loggging into the Salesforce";
					Status = "Fail";
					ImageName = "LoginFailure";
					ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
					LOGS.info("Results Folder Path value: "+Resultsfolderpath);
					LOGS.info("Results Folder Path value: "+pr.Resultsfolderpath);
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Accounts_Tab>a")));
					driver.findElement(By.cssSelector("#Accounts_Tab>a")).click();
					
					ExportResults.exportTestResult(
							"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,pr.Resultsfolderpath);
					LOGS.info(Thread.currentThread() +"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);
					return SalesForceLoginResult;
				}

			}
		
			// To check the Scenario Status
			
		} catch (Exception e) {
			SalesForceLoginResult = "False";
			Status = "Fail";
			ExceptionMsg= "Exception Happened while Loggging into the Salesforce";
			ImageName = "SalesforceLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
			ExportResults.exportTestResult("Login to Salesforce," + "Login Successful" + ","
					+ "Exception found while Logging into SF" + "," + Status + "," + ImgName,pr.Resultsfolderpath);
			LOGS.info(Thread.currentThread() +
					"Login to Salesforce," + "Login Successful" + "," + e.getMessage() + "," + Status + "," + ImgName);
			
			LOGS.error("Unable to Login to Salesforce",e);
			

			return SalesForceLoginResult;

		}
		return SalesForceLoginResult;
	}
	// Edit field should be None if it is not required to update fields in the
	// Accounts
		
	public  String SalesforceLogin(String User, String Pwd, String LoginAsUsr) throws Exception {
		
		SalesforceLogin(User, Pwd);
		try {
		SRep = LoginAsUsr;
		LOGS.info(Thread.currentThread() +"Clicking on the Setup Link");
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='setupLink']")));
		driver.findElement(By.xpath("//a[@id='setupLink']")).click();
		
		//Thread.sleep(5000);
		LOGS.info(Thread.currentThread() +"Clicking on the Manage Users Link");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Users_font']")));
		driver.findElement(By.xpath("//a[@id='Users_font']")).click();
		LOGS.info(Thread.currentThread() +"Clicking on the Users Link");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ManageUsers_font']")));
		driver.findElement(By.xpath("//a[@id='ManageUsers_font']")).click();
		LOGS.info(Thread.currentThread() +"Selecting the CSView");
		//Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='noSecondHeader pageType']")));
		String hdng = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		LOGS.info(Thread.currentThread() +"Existing Rep Name- "+hdng);
		if (!hdng.equalsIgnoreCase(LoginAsUsr)) {
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fcf']")));
			WebElement UserView = driver.findElement(By.xpath("//select[@id='fcf']"));
			Select userviewdrpdwn = new Select(UserView);
			userviewdrpdwn.selectByVisibleText(LoginAsUsr);
		}

	
		LOGS.info(Thread.currentThread() +"Clicking on the Login Link - Line789");
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		//ExpRes = "Second Login Should Happen by Clicking on Login in view.";
		ImageName = "SecondLogin";
		ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//form[@id='ResetForm']/div[2]/table/tbody/tr[2]/td[1]/a[2]")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(2000);
		

		if(LoginAsUsr.contains("OpsWizard")){
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newWindowHandle.get(1));
			String TabSelected = driver.getTitle();
			LOGS.info(Thread.currentThread() +"Tab Selected: " + TabSelected);
			driver.close();
			driver.switchTo().window(newWindowHandle.get(0));
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//Thread.sleep(2000);
			LOGS.info(Thread.currentThread() +"Page Refreshed");
		}
		ImageName = "AfterSecondLogin";
		ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
		return Status;
		}catch (Exception e) {
			ImageName = "SecondLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
			ExceptionMsg= "Exception Happened while doing the second login in Salesforce";
			LOGS.error("Second Login Failed",e);
			//e.printStackTrace();
			
			return Status;
			
		}

	}

	public void SFLoginAsUser(String LoginAsUser) throws Exception {
		SFLogout();
		LOGS.info(Thread.currentThread() +"Logout From " + SalesRepType);
		Properties OR = pr.loadPropertiesFiles("Order");
		SalesRep = OR.getProperty(LoginAsUser);
		LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
		LOGS.info(Thread.currentThread() +"Clicking on the Setup Link");
		driver.findElement(By.xpath("//a[@id='setupLink']")).click();
		LOGS.info(Thread.currentThread() +"Clicking on the Manage Users Link");
		driver.findElement(By.xpath("//a[@id='Users_font']")).click();
		LOGS.info(Thread.currentThread() +"Clicking on the Users Link");
		driver.findElement(By.xpath("//a[@id='ManageUsers_font']")).click();
		LOGS.info(Thread.currentThread() +"Selecting the CSView");
		String hdng = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
		if (!hdng.equalsIgnoreCase(SalesRep)) {
			WebElement UserView = driver.findElement(By.xpath("//select[@id='fcf']"));
			Select userviewdrpdwn = new Select(UserView);
			userviewdrpdwn.selectByVisibleText(SalesRep);
		}
		String uName = "Kavya spe";
		if (LoginAsUser.equalsIgnoreCase(uName)) {
			LOGS.info(Thread.currentThread() +"Login As SPE :" + LoginAsUser);
		}

		else
			LOGS.info(Thread.currentThread() +"Login As Premise Rep :" + LoginAsUser);

		LOGS.info(Thread.currentThread() +"Clicking on the Login Link");
		driver.findElement(By.xpath("//td[@id='bodyCell']/div[5]/div/div[2]/table/tbody/tr[2]/td[1]/a[2]")).click();

	}

	
	
		
	
	
	
	
	public void SFLogout() throws Exception {
		
     try {
    	 LOGS.info("I am a Driver before Logout: "+driver);
    	LOGS.info("driver value: "+driver);
		LOGS.info("driver value: "+driver);
		LOGS.info("driver value: "+driver);
    	 ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
		LOGS.info(Thread.currentThread() +"No of Windows Opened: "+newWindowHandle);
		driver.switchTo().window(newWindowHandle.get(0));
     }
     catch(Exception e) {
    	 LOGS.info(Thread.currentThread() +"Exception in Logout: "+e.getMessage());
     }
		LOGS.info(Thread.currentThread() +"This is Logout Method");
		if(driver == null){
			LOGS.info(Thread.currentThread() +"webdriver value is null");
			}else {
		          //driver.close();
				  driver.quit();
				  driver = null;
				  LOGS.info(Thread.currentThread() +"Sucessfully Quit the Browser.");
			}
	
		
		
		
	}

	
	
	public  void SFLogin() throws Exception {
		try {
			LOGS.info(Thread.currentThread() +"Calling SFLogin method");
			Properties OR = pr.loadPropertiesFiles("Order");

			if (SalesRepType.equalsIgnoreCase("Tsales")) {
				SalesRep = OR.getProperty("TSales");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("Premise")) {
				SalesRep = OR.getProperty("Premise");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("SPE")) {
				SFLoginResult = SalesforceLogin("sfAdminUserNameSPE", "SfdcSpePwd");
			} else if (SalesRepType.equalsIgnoreCase("CSRep")) {
				SalesRep = OR.getProperty("CSRep");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("DSCRep")) {
				SalesRep = OR.getProperty("DSCRep");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("NonCpqTsale")) {
				SFLoginResult = SalesforceLogin("tSalesRepUserName", "tSalesRepPassWord");
			} else if (SalesRepType.equalsIgnoreCase("NonCpqPremiseRep")) {
				SFLoginResult = SalesforceLogin("PremiseRepUserName", "PremiseRepPassWord");
			} else if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
				SalesRep = OR.getProperty("OpsWizard");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else {
				LOGS.info(Thread.currentThread() +"Select the proper Rep name. Current Sales Rep is :" + SalesRepType);
				count = count + 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGS.info(Thread.currentThread() +"Error in SFLogin method");
			Status = "Fail";
			ImageName = "SFLoginError";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
			ExpRes = "SFLogin method should execute successfully";
			ActRes = "Error in SFLogin method";
			ExportResults
			.exportTestResult("SFLogin Validation," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,pr.Resultsfolderpath);
			count = count + 1;
		}
	}

	
	/// ________________________________________________________________________________
	// Excelreusable Methods

	public String path;
	public static FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	public static void Xls_Reader(String path) {

		String path1 = path;
		System.out.println(path);
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// returns the row count in a sheet
	public static int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	// returns the data from a cell
	public static String getCellData(String sheetName, String colName, int rowNum) {

		try {

			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);

			if (row == null)
				return "";
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";
			// System.out.println(cell.getCellType());
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	


/*	public  void callZephyr() throws Exception {

			if (uniqueIssueId.equalsIgnoreCase("")) {
				ExportResults.ExportQuote();

				LOGS.info(Thread.currentThread() +"\nSummary:" + Summary + "\nDescription:" + Description);
				//String jiraCardNo = JiraClass.createTaskinJira(Summary, Description);
				//LOGS.info(Thread.currentThread() +"Jira Card Number:"+jiraCardNo);
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description);
				testResults = "Business Id : " + businessID;
				System.out.println("Zephyr Card No = " + TestCaseNum);
				ExportResults.CExportQuote();

			} else {

				LOGS.info(Thread.currentThread() +"Issue ID for "+ plansLabel+": "+uniqueIssueId);
				String jiraCard ="";//"TCM-286";
				//ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(), jiraCard);
				//ExportResults.CExportQuote();
			}

		}*/
		
/*		public void callZephyr(String issueID) throws Exception {

			if (issueID.equalsIgnoreCase("")) {

				LOGS.info(Thread.currentThread() +"\nSummary:" + Summary + "\nDescription:" + Description);
				//String jiraCardNo = JiraClass.createTaskinJira(Summary, Description);
				//LOGS.info(Thread.currentThread() +"Jira Card Number:"+jiraCardNo);
				TestCaseNum = ZephyrTestCase.createZephyrTestCase(Summary, Description);
				System.out.println("Zephyr Card No = " + TestCaseNum);
				ExportResults.CExportQuote();

		} else {

				LOGS.info(Thread.currentThread() +"Issue ID for "+ plansLabel+": "+uniqueIssueId);
				String jiraCard ="";//"TCM-286";
				ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(), jiraCard);
				ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(), pr.jiraNo);

				//ExportResults.CExportQuote();
			}

		}*/

	
		
		
	//SalesForce login with SalesRep (Premise, TSales..) 
	public  void SFLogin(String SalesRepType) throws Throwable {
		try {
			LOGS.info(Thread.currentThread() +"SalesForce Login method Started");

			Properties OR = pr.loadPropertiesFiles("Order");

			if (SalesRepType.equalsIgnoreCase("TSales")) {
				SalesRep = OR.getProperty("TSales");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("Premise")) {
				SalesRep = OR.getProperty("Premise");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("SPE")) {
				SFLoginResult = SalesforceLogin("sfAdminUserNameSPE", "sfAdminPswdSPE");
			} else if (SalesRepType.equalsIgnoreCase("CSRep")) {
				SalesRep = OR.getProperty("CSRep");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("DSCRep")) {
				SalesRep = OR.getProperty("DSCRep");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else if (SalesRepType.equalsIgnoreCase("NonCpqTsale")) {
				SFLoginResult = SalesforceLogin("tSalesRepUserName", "tSalesRepPassWord");
			} else if (SalesRepType.equalsIgnoreCase("NonCpqPremiseRep")) {
				SFLoginResult = SalesforceLogin("PremiseRepUserName", "PremiseRepPassWord");
			} else if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
				SalesRep = OR.getProperty("OpsWizard");
				LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			} else {
				LOGS.info(Thread.currentThread() +"Select the proper Rep name. Current Sales Rep is :" + SalesRepType);
				count = count + 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGS.info(Thread.currentThread() +"Error in SFLogin method");
			Status = "Fail";
			ImageName = "SFLoginError";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver,pr.Resultsfolderpath);
			ExpRes = "SFLogin method should execute successfully";
			ActRes = "Error in SFLogin method";
			ExportResults
			.exportTestResult("SFLogin Validation," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,pr.Resultsfolderpath);
			count = count + 1;
		}
	}

				
		
				


		
		
		
		



public String RCFProvisionAssistant(String Resultsfolderpath, String SalesRepType, String Casenum) throws Exception
{
	  
		try {
			count=0;
						
			pr.Resultsfolderpath = Resultsfolderpath;
			LOGS.info("REsults Folder Path in Main: "+Resultsfolderpath);
			LOGS.info("REsults Folder Path in Main: "+pr.Resultsfolderpath);
			
			
			if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
				//SalesRep = "Becky OpsWizard";
				SalesRep = OR.getProperty("OpsWizard");
				LOGS.info(Thread.currentThread() + "Login Sales Rep -> " + SalesRep);
				SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
				if (SFLoginResult.trim().equalsIgnoreCase("Fail")) {
					LOGS.info(Thread.currentThread() + "SF Login is Failed.");
					count = count + 1;
				} else
					LOGS.info(Thread.currentThread() + "SF Login is successfully done");
			}
			

			if (count == 0) {
				try {
                        
					
					try {
						
						wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						
						
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phSearchButton']")));
						
						driver.findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(Casenum);
						  
						LOGS.info("Case number entered");
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						
				        driver.findElement(By.xpath("//input[@id='phSearchButton']")).click();
				        
				        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				         
				         
				         
				        
					    ImageName = "DSCCase";
						ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
				         
				         String clickCheck=driver.getCurrentUrl();
				               	
				         LOGS.info("Clicking on cases link");
				         
				         driver.findElement(By.xpath("//div[@id='Case_body']//following::tr[1]//th[1]/a")).click();
				         
				         LOGS.info("Clicked on cases link");
				         
				         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				         
				         
				         SLocator("Cases_Detailslink").click();
				        
				        
				        try {
				        	
				        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cas4_ileinner']//a")));
				        	
				        	driver.findElement(By.xpath("//div[@id='cas4_ileinner']//a")).click();
				        	
				        	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				        	
				        	ExpRes = "Account Verification and it should be Available";
							ImageName = "ExistingAccount";
							ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
							ActRes = "Account Found";
							
							if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Details']")));
								driver.findElement(By.xpath("//span[text()='Details']")).click();
								LOGS.info(Thread.currentThread() + "Clicking on Details Link for the " + SalesRepType
										+ " Rep ");
								driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
								driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
								LOGS.info(Thread.currentThread() + "Clicked on Details Link ");
							}
				        	
				        }catch(Exception e) {
				        	LOGS.info(Thread.currentThread() + "Account Not Found");
							ActRes = "Account Not Found";
							ExceptionMsg = "exception happened while opening the account";
							Status = "Fail";
							count = count + 1;
				        }
				         
				        ExportResults.exportTestResult(
								"Account Verification :," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
								pr.Resultsfolderpath);
				        
				        
				        
					}catch(Exception e)
					{
						LOGS.info("Case Page Error");
						 
						ExceptionMsg = "error in opening the case";
						Status = "Fail";
						count = count + 1;
						
					}
					
					
					

					if (count == 0) {

						
						String regex = "\\d+";
						wait.until(ExpectedConditions.textMatches(By.xpath("//span[text()='Live Products']/span"),
								Pattern.compile(regex)));

						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						String product_count = SLocator("LiveProductCount").getText();
						product_count = product_count.replace("[", "");
						product_count =product_count.replace("]", "");
						LOGS.info(Thread.currentThread() + "All Live Product Count taking from top row links- "
								+ product_count);

						LOGS.info(Thread.currentThread()
								+ "Clicking on Live Products link to get Live product details");
						SLocator("LiveProductLink").click();
						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						LOGS.info(Thread.currentThread() + "Clicked on Live Products link");
						String captureProdCountStr = "";
						productsCaptureHomePage = "";

						 
							
							captureProdCountStr = product_count;
							LOGS.info(Thread.currentThread() + "****" + product_count);
							int LiveProductsCount = Integer.parseInt(captureProdCountStr);

							for (int i = 1; i <= LiveProductsCount; i++) {
								String LiveProdPath = "//div[@class='listHoverLinks']//following::h3[text()='Live Products']//ancestor::div[1]//following::div[1]//tr["
										+ (i + 1) + "]/th/a";
								
								String getLiveProducts = driver.findElement(By.xpath(LiveProdPath)).getText();
															
								if(getLiveProducts.contains("Assistant"))
								{
									driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
									driver.findElement(By.xpath(LiveProdPath)).click();
									
								}
								LOGS.info(Thread.currentThread() + "Product Name is :" + getLiveProducts);
								
								ProductName.add(getLiveProducts);
								productsCaptureHomePage = productsCaptureHomePage + "-" + getLiveProducts;
							}
						
						
						ImageName = "LiveProduct";
						ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
						ExpRes = "Capture the Product Count and Live Products for the Account - ";
						prodCount = ProductName.size();
						LOGS.info(Thread.currentThread() + "Available Product: " + prodCount);

						ActRes = prodCount + "Products are \n" + productsCaptureHomePage;
						Status = "Pass";
						ExportResults.exportTestResult(
								"Live Product Details:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
								pr.Resultsfolderpath);

						
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						

						ExpRes = "rcf provision button should be clicked";
						ImageName = "Assistant product";
						ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
						try {
							    
							    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'pbHeader']//child :: table//child :: td[@class = 'pbButton']//child :: input[@value = 'Provision Assistant RCF']")));
							    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'pbHeader']//child :: table//child :: td[@class = 'pbButton']//child :: input[@value = 'Provision Assistant RCF']"))).click();
							
							    
							    ActRes = "rcf provision button is clicked";
						}catch(Exception e)
						{
							LOGS.info("in catch block for clicking assistant rcf button");
							driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							LOGS.info("waited for 50 seconds");
							LOGS.info("clicking on rcf button");
							 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'pbHeader']//child :: table//child :: td[@class = 'pbButton']//child :: input[@value = 'Provision Assistant RCF']"))).click();
							
							 }
						
						ExportResults.exportTestResult(
								"Assistant product page ," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
								pr.Resultsfolderpath);
						
						
						
						ExpRes = "able to provision rcf";
						ImageName = "RCF";
						ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
						
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						try {
							Thread.sleep(10000);
							  Alert a = driver.switchTo().alert();
							 String text = a.getText();
							   a.accept();
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							  
							  LOGS.info("text of the alert is " + text);
				
						LOGS.info(" successfully accepted the alert");
						ActRes = "rcf provisioned successfully";
						}catch(Exception e) {
							LOGS.info("inside catch block");
							ActRes = "rcf provisioned failed";
						}

						
						ExportResults.exportTestResult(
								"Assistant rcf page : ," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
								pr.Resultsfolderpath);

						
					}
				} catch (Exception e) {
					ImageName = "AssistantRCF";
					ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

					Status = "Fail";
					ExpRes = "RCF provisioning assistant Process should be verified & should be Pass";

					ActRes = "RCF provisioning assistant Process Failed - Reached to Catch Exception";
					ExportResults.exportTestResult(
							"RCF provisioning assistant:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
							pr.Resultsfolderpath);
					count = count + 1;
					LOGS.error("Error in RCF provisioning assistant" + Thread.currentThread() + " : " + e);
					ExceptionMsg = "Error in RCF provisioning assistant";
					LOGS.info(Thread.currentThread() + "," + "Error in RCF provisioning assistant- "
							+ e.getStackTrace());

					return Status;
				}
			}
			

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			try {
				
			String textmsg=driver.findElement(By.xpath("//td[@class='messageCell']")).getText();
			LOGS.info("===========================================================================================================================================================");
			LOGS.info("Message is : " + textmsg);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			LOGS.info("Successful");
			
			
			}catch(Exception e)
			{
				LOGS.info("Failed On Assistant rcf Page");
			}
			

			
			
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			try {
				LOGS.info("Case number entered");	
			  driver.findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(Casenum);
	         driver.findElement(By.xpath("//input[@id='phSearchButton']")).click();
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         Thread.sleep(6000);
	         
	         String clickCheck=driver.getCurrentUrl();
	               	
	         LOGS.info("Clicking on cases link");
	          driver.findElement(By.xpath("//div[@id='Case_body']//following::tr[1]//th[1]/a")).click();
	         LOGS.info("Clicked on cases link");
	         
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         Thread.sleep(6000);
	         
	         SLocator("Cases_Detailslink").click();
	         ExpRes = "Case Verification and it should be Available";
		     ActRes = "case is available";
	        
	         
	         }
			catch(Exception e)
			{
						LOGS.info("Case Page Error");
						ActRes = "case not found";
						Status = "Fail";
						
					}
			ExportResults.exportTestResult(
					" clicking on Case page:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					pr.Resultsfolderpath);
			
			
			String OBW = OBWGeneration();
			if(!OBW.equalsIgnoreCase("Fail"))
				LOGS.info(OBW);
			else
				LOGS.info("OBW link generation failed");
			String validate = RCFValidations();
			
			if(validate.equalsIgnoreCase("Pass"))
				LOGS.info("assistant RCF has been provisioned successfully");
			else
				LOGS.info("assistant rcf provision is not successful");

		} catch (Exception e) {
			LOGS.error("rcf provision assistant Method : " + Thread.currentThread() + " : " + e);
			ExceptionMsg = "Error in rcf provision assistant Method ";
			LOGS.info(Thread.currentThread() + "," + "Error in rcf provision assistant Method - " + e.getStackTrace());
			ImageName = "RCFProvisionAssistantResult";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

			Status = "Fail";
			ExpRes = "RCFProvisionAssistant should be verified & should be Pass";

			ActRes = "RCFProvisionAssistant Process Failed - Reached to Catch Exception";
			ExportResults.exportTestResult(
					"Day3 Process Status:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					pr.Resultsfolderpath);
			count = count + 1;
			

			return Status;
		}

		
		
		
		
		
		return Status;		
}

public String OBWGeneration() throws Exception
{
	Status = "Pass";
	String textmsg = "";
	LOGS.info("Entered into OBW Generation");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(3000);
	
	ImageName = "OBW Link";
	
	ExpRes = "OBW Link should be generated ";
	
	
	
	try{
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@id='00N7h000003i3l5_ileinner']//a")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
		 Thread.sleep(3000);
		 
		 textmsg=driver.findElement(By.xpath("//td[@class='messageCell']")).getText();
	     LOGS.info("***********************************************************************************");
		 LOGS.info("Message is : " + textmsg);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		 ActRes ="OBW Link Generated \n";
		 
	}catch(Exception e)
	{
		LOGS.info("Exception happened while generating the Link");
		ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
		ActRes ="OBW Link Not Generated \n";
		Status="Fail";
		ExceptionMsg = "exception happened while generating the OBW link";
		return Status;
	}
	
	ExportResults.exportTestResult(
			"OBW link Details:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
			pr.Resultsfolderpath);
	
	try {
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@id=\"00N7h000003i7hT_ileinner\"]/a")).click();
		
		    Thread.sleep(5000);
		    ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
			LOGS.info("========================================================================");
			LOGS.info("size :" + driver.getWindowHandles().size());
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			
			ExpRes = "Confirm Yelp - Hibu Page should open";
			ImageName = "Confirm Yelp - Hibu";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
			LOGS.info("going to switch window");
			Thread.sleep(5000);
		    driver.switchTo().window(newWindowHandle.get(1));
		    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 
		    String title=driver.getTitle();
		    
		    if(title.trim().contains("Confirm Yelp - Hibu")) 
		    {
		    	LOGS.info("Title of the current page is : " + title);
		    ActRes ="Confirm Yelp - Hibu Page gets opened";
		    
		    }
		    else
		    {
		    	
		    	LOGS.info("Page not found");
		    	ActRes ="Confirm Yelp - Hibu Page Not Persent";
		    }
		 
	}catch(Exception e)
	{
		LOGS.info("Exception happened while generating the Link");
		ActRes ="Confirm Yelp - Hibu Page Not Persent";
		Status="Fail";
		return Status;
	}
	
	driver.close();
	ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newWindowHandle.get(0));
	LOGS.info("switching back to case page");
	driver.navigate().refresh();
	LOGS.info("refreshing the case page");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(2000);
	LOGS.info("Page Refreshed");
	
	ExportResults.exportTestResult(
			"Yelp Page:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
			pr.Resultsfolderpath);
	
	
	return textmsg;	
	
	
}



public String RCFValidations() throws Exception
{
	
	LOGS.info("Entered into RCF validations");
	
	ExpRes = "assistant rcf in case page should be provisioned/requested";
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(3000);
	try{
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
		String Asststatus = "//div[@id='00N7h000003i3l1_ileinner']";
		
		String rcfstatus = driver.findElement(By.xpath(Asststatus)).getText();
		
		if(rcfstatus.contains("Provisioned")||rcfstatus.contains("Requested"))
		{
		LOGS.info(Thread.currentThread() + "Assistant Rcf Status :" + rcfstatus);
		ActRes = "assistant status in case page is : " + rcfstatus;
		}
		
		else {
			LOGS.info("Assistant RCF is not provisioned");
			ActRes = "assistant rcf is not provisioned";
			return "Fail";
			
		}
		
		
	}catch(Exception e)
	{
		LOGS.info("No Provisioned Status Found");
		ActRes = "assistant rcf is not provisioned";
		ExceptionMsg = "exception happened while validating assistant rcf";
		return "Fail";
	}
	
	ExportResults.exportTestResult(
			"rcf status," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
			pr.Resultsfolderpath);
	
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	LOGS.info("waiting for 36 seconds");
    Thread.sleep(6000);
    LOGS.info("waited for 36 seconds");
    LOGS.info("going to open rcf view");
	
   try{
		
	   	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        Thread.sleep(6000);
	        LOGS.info("waited for 72 seconds");
	        
	        driver.findElement(By.xpath("//div[@class = 'pbHeader']//child :: table//child :: td[@class = 'pbButton']//child :: input[@value = 'RCF View']")).click();
	        
	        String p = driver.getWindowHandle();
	        LOGS.info(p);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        Thread.sleep(6000);
	        
	        Set<String> s = driver.getWindowHandles();
	        Iterator<String> I1= s.iterator();
	        while(I1.hasNext()) {
	           
	            String popupHandle=I1.next().toString();
	           
	            if(!popupHandle.contains(p)) {
	               
	                LOGS.info("switched to rcf view");
	                driver.switchTo().window(popupHandle);
	            }   
	    }
	        
	        ExpRes = "assistant rcf should be present in rcf view";
	        ImageName = "RCF view";
	        ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
	        
	        try {
	        	
	        	if(driver.findElement(By.xpath("//table[@class='slds-table slds-table_cell-buffer']//tbody//td[contains(text(),'Assistant')]")) != null)
	        	{
	        		if(driver.findElement(By.xpath("//table[@class='slds-table slds-table_cell-buffer']//tbody//td[contains(text(),'Assistant')]//following-sibling::td[contains(text(),'Active')]")) != null)
	        			
	        		{
	        	LOGS.info("Assistant product has been provisioned");        			
	        		}
	        		ActRes = "assistant is present in rcf view";
	        	}
	        	
	        	else
	        	{
	        		LOGS.info("No RCF view found for Assistant");
	        		ActRes = "assistant is not present in rcf view";
	        		
	        	    
	        	}
	        	
	        	driver.close();
	        	
	        }catch(Exception e)
	        {
	        	driver.close();
	        	
	        }
	        
	        ExportResults.exportTestResult(
	    			"RCF view:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
	    			pr.Resultsfolderpath);
	        
	       
   }
	        catch(Exception e)
		{
			LOGS.info("Fail");
			ExceptionMsg = "exception happened while validating assistant rcf";
			
			return "Fail";
		}
   
return "Pass";
}


public String QuestionnaireRCFProvision(String CaseNum, String Resultsfolderpath, String SalesRepType) throws Exception
{
    Status = "Pass";
	 
	try {
		count=0;
					
		pr.Resultsfolderpath = Resultsfolderpath;
		LOGS.info("REsults Folder Path in Main: "+Resultsfolderpath);
		LOGS.info("REsults Folder Path in Main: "+pr.Resultsfolderpath);
		
		if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
			SalesRep = OR.getProperty("OpsWizard");
			//SalesRep = "Becky OpsWizard";
			LOGS.info(Thread.currentThread() + "Login Sales Rep -> " + SalesRep);
			SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
			if (SFLoginResult.trim().equalsIgnoreCase("Fail")) {
				LOGS.info(Thread.currentThread() + "SF Login is Failed.");
				count = count + 1;
			} else
				LOGS.info(Thread.currentThread() + "SF Login is successfully done");
		}
		

		if (count == 0) {
			try {

				try {

					wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
					
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='phSearchButton']")));
					driver.findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(CaseNum);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//input[@id='phSearchButton']")).click();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					

					ExpRes = "Case Verification and it should be Available";
					ImageName = "DSCCase";
					ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

					wait.until(ExpectedConditions
							.elementToBeClickable(By.linkText(CaseNum)));
					driver.findElement(By.linkText(CaseNum)).click();
					LOGS.info(Thread.currentThread() + "Clicking on Case Link");
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					ActRes = "Case Found";

					if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Details']")));
						driver.findElement(By.xpath("//span[text()='Details']")).click();
						LOGS.info(Thread.currentThread() + "Clicking on Details Link for the " + SalesRepType
								+ " Rep ");
						driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						LOGS.info(Thread.currentThread() + "Clicked on Details Link ");
					}

				} catch (Exception e) {
					LOGS.info(Thread.currentThread() + "Case Not Found");
					ActRes = "Case Not Found";
					Status = "Fail";
					ExceptionMsg = "DSC case not found";
					count = count + 1;
				}
				ExportResults.exportTestResult(
						"Case Verification :," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
						pr.Resultsfolderpath);

				if (count == 0) {
					
					
					ImageName = "casePage";
					ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
					
					
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pbHeader']//table//td[@class='pbButton']//input[@value='Questionnaire']")));
						
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pbHeader']//table//td[@class='pbButton']//input[@value='Questionnaire']"))).click();
						
						Thread.sleep(10000);
						
						ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
						LOGS.info("========================================================================");
						LOGS.info("size :" + driver.getWindowHandles().size());
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
						
						ExpRes = "assistant rcf button should be available on questionnaire";
						ImageName = "questionnaire";
						ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
						
						Thread.sleep(5000);
						LOGS.info("going to switch window");
						
					    driver.switchTo().window(newWindowHandle.get(1));
					    LOGS.info("switched the driver successfully");
						try {
							
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
						String TabSelected = driver.getTitle();
						String curURL = driver.getCurrentUrl();
						
						LOGS.info("current URL is " + curURL);
						driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
						
					      
						if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'slds-m-top_xx-small slds-m-bottom_xx-small']//button"))) != null)
						{
							LOGS.info("assistant rcf button is present and clickable on questionnaire page");
							
						    driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'slds-m-top_xx-small slds-m-bottom_xx-small']//button"))).click();
							
							LOGS.info("assistant rcf button clicked on questionnaire page");
							
							ActRes = "assistant rcf button is available on questionnaire";
							driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
							
							
						}
						else {
							LOGS.info("assistant rcf button is not visible on questionnaire page");
							ActRes = "assistant rcf button is not available on questionnaire";
						}
						
						
						
						}catch(Exception e) {
							LOGS.info("assistant rcf button not found on questionnaire page");
							ActRes = "assistant rcf button is not available on questionnaire";
						}
						
						driver.close();
						driver.switchTo().window(newWindowHandle.get(0));
						LOGS.info("switching back to case page");
						driver.navigate().refresh();
						LOGS.info("refreshing the case page");
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						Thread.sleep(2000);
						LOGS.info("Page Refreshed");
						
						
						
						
					}catch(Exception e) {
						ActRes = "Qusetionnaire button can't be clicked";
						Status = "Fail";
						count = count + 1;
						LOGS.info("questionnaire button can't be clicked");
						ExceptionMsg = "exception happened while opening the questionnaire";
						
						return Status;
					}
					
					ExportResults.exportTestResult(
							"Qusetionnaire opening " + "," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
							pr.Resultsfolderpath);
					
	
					
					String OBW = OBWGeneration();
					if(!OBW.equalsIgnoreCase("Fail"))
						LOGS.info(OBW);
					else
						LOGS.info("OBW link generation failed");
					String validate = RCFValidations();
					
					if(validate.equalsIgnoreCase("Pass"))
						LOGS.info("assistant RCF has been provisioned successfully");
					else
						LOGS.info("assistant rcf provision is not successful");
					
				}
			} catch (Exception e) {
				ImageName = "QuestionnaireRCF";
				ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

				Status = "Fail";
				ExpRes = "Questionnaire RCF Process should be verified & should be Pass";

				ActRes = "Questionnaire RCF Process Failed - Reached to Catch Exception";
				ExportResults.exportTestResult(
						"Questionnaire RCF Status:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
						pr.Resultsfolderpath);
				count = count + 1;
				LOGS.error("Error in Questionnaire RCF :: Questionnaire Page " + Thread.currentThread() + " : " + e);
				ExceptionMsg = "Error in Questionnaire RCF :: Questionnaire Page ";
				LOGS.info(Thread.currentThread() + "," + "Error in Questionnaire RCF :: Questionnaire Page - "
						+ e.getStackTrace());

				return Status;
			}
		}

		

	} catch (Exception e) {
		LOGS.error("Error in questionnaire assistant rcf method : " + Thread.currentThread() + " : " + e);
		ExceptionMsg = "Error Questionnaire RCF Method ";
		LOGS.info(Thread.currentThread() + "," + "Error Questionnaire RCF Method - " + e.getStackTrace());
		ImageName = "QuestionnaireRCF";
		ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

		Status = "Fail";
		ExpRes = "Questionnaire RCF should be verified & should be Pass";

		ActRes = "Questionnaire Process Failed - Reached to Catch Exception";
		ExportResults.exportTestResult(
				"Day3 Process Status:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
				pr.Resultsfolderpath);
		count = count + 1;

		return Status;
	}

	return Status;

	

}


}
