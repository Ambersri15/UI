package com.hibu.tests;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
//import org.codehaus.jettison.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AstNewReview extends PreRequisites {

	public static Logger LOGS = LogManager.getLogger(AstNewReview.class.getName());;
	// static String ActRes, ExpRes, Status, ImagePath, ImageName, ImgName;
	WebDriverWait wait;

	PreRequisites pr = new PreRequisites();
	ScreenshotPrinter ScreenshotPrinter = new ScreenshotPrinter();
	ExportResults ExportResults = new ExportResults();
	InflightOrderQry InflightOrderQry = new InflightOrderQry();
	DriverFactory DF = new DriverFactory();
	public String TotSpend, consType, ConPOSPhoneNo, POSConphoneNo, RepContactPhoneNo;
	public String SelectConsltnRslt, paymntRslt, submitRslt = "Pass", User, OneTimeFeeQuoteDetls,
			BusinessNameQuoteDetls;

	public String YextLoginResults, AELoginResult, PaymtAmtPaymentPg, PhoneNumPaymentPg, confirmationNumber,
			ParentWindow;
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
	String validation, QPageQNo, oneTimeFeesTotal = "", TaxTotal = "", MonthlyInvestmentTotal = "", Oppwindow = "",
			ContractDetailsResult;
	Properties DP = pr.loadPropertiesFiles("Daywise");
	public String NewOppturl, OptText = "";
	public double convertMinBudg;
	public String ResultStatus = "Pass", CreateQ = "", CSRep = "", CancelproductRes = "";
	public String SalesRep = "";
	public String SFLoginResult = "", OpportunityResults = "", ValidateQuoteResult = "",
			SearchActiveAccountResults = "", SubmitFinalPageRslt = "", GenerateDocumentResult = "",
			OpportunityValidationResult = "";
	public String captSignResult = "", SelConsultResult = "", PaymentResult = "", calcelproductResult = "", CaseURL;
	public int LivSubsCount, SCVal, i, j, RowsBeforeAdd, prodCount;
	public String assistantAssetId = "", astAssetId = "";
	

	public Properties OR = pr.loadPropertiesFiles("Order");
	//Properties OR = pr.loadPropertiesFiles("Order");
	
	

	public void Assistant_NewReview(String BusinessId, String RepName, String Resultsfolderpath) throws Exception
	{
		
		pr.Resultsfolderpath = Resultsfolderpath;
		LOGS.info("Results Folder Path value: " + Resultsfolderpath);
		LOGS.info("Results Folder Path value: " + pr.Resultsfolderpath);
		
		SalesRepType = RepName;
		
		if(SalesRepType.equalsIgnoreCase("OpsWizard"))
		{
			SalesRep = OR.getProperty("OpsWizard");
			LOGS.info(Thread.currentThread() +"Login Sales Rep -> " + SalesRep);
			SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
		}
		
		astAssetId = SearchAccount(BusinessId, Resultsfolderpath);
		
			
		//--------------- New Review Trigger for Google -----------------------------
		
		if(astAssetId != null)
		{
			TriggerRestCall_NewReviewForGoogle(astAssetId, BusinessId, Resultsfolderpath);
		}
		else
		{
			ExpRes = "Assistant AssetId Found";
			ActRes = "There is Some Issue while Fetching Assistant AssetId";
			Status = "Fail";
			ExportResults.exportTestResult(
					"SignPost Feedback:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					Resultsfolderpath);
		}
					
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
	
	public String SalesforceLogin(String User, String Pwd, String LoginAsUsr) throws Exception {

		SalesforceLogin(User, Pwd);

		try {
			//SRep = LoginAsUsr;
			LOGS.info(Thread.currentThread() + "Clicking on the Setup Link");
			// Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			// Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='setupLink']")));
			driver.findElement(By.xpath("//a[@id='setupLink']")).click();

			// Thread.sleep(5000);
			LOGS.info(Thread.currentThread() + "Clicking on the Manage Users Link");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Users_font']")));
			driver.findElement(By.xpath("//a[@id='Users_font']")).click();
			LOGS.info(Thread.currentThread() + "Clicking on the Users Link");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ManageUsers_font']")));
			driver.findElement(By.xpath("//a[@id='ManageUsers_font']")).click();
			LOGS.info(Thread.currentThread() + "Selecting the CSView");
			// Thread.sleep(5000);

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='noSecondHeader pageType']")));
			String hdng = driver.findElement(By.xpath("//h1[@class='noSecondHeader pageType']")).getText();
			LOGS.info(Thread.currentThread() + "Existing Rep Name- " + hdng);
			
			if (!hdng.equalsIgnoreCase(LoginAsUsr))
			{
				// Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fcf']")));
				WebElement UserView = driver.findElement(By.xpath("//select[@id='fcf']"));
				Select userviewdrpdwn = new Select(UserView);
				userviewdrpdwn.selectByVisibleText(LoginAsUsr);
			}

			LOGS.info(Thread.currentThread() + "Clicking on the Login Link - Line789");
			// Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			// ExpRes = "Second Login Should Happen by Clicking on Login in view.";
			ImageName = "SecondLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);

			Thread.sleep(4000);
			//driver.findElement(By.xpath("//form[@id='ResetForm']/div[2]/table/tbody/tr[2]/td[1]/a[2]")).click();
			
			driver.findElement(By.xpath("//div[@class='pbBody']//tr[2]/td/a[contains(text(), 'Login')]")).click();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(2000);

			if (LoginAsUsr.contains("OpsWizard")) {
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				ArrayList<String> newWindowHandle = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(newWindowHandle.get(1));
				String TabSelected = driver.getTitle();
				LOGS.info(Thread.currentThread() + "Tab Selected: " + TabSelected);
				driver.close();
				driver.switchTo().window(newWindowHandle.get(0));
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				// Thread.sleep(2000);
				LOGS.info(Thread.currentThread() + "Page Refreshed");
			}
			ImageName = "AfterSecondLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
			return Status;
		} catch (Exception e) {
			ImageName = "SecondLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
			ExceptionMsg = "Exception Happened while doing the second login in Salesforce";
			LOGS.error("Second Login Failed", e);
			// e.printStackTrace();

			return Status;

		}

	}

	public String SalesforceLogin(String User, String Pwd) throws Exception {
		try {
			String path = regardingfilesPath + "InputFiles/Order.properties";
			LOGS.info(Thread.currentThread() + path);

			// LOGS.info(Thread.currentThread() +OR.getProperty(User));
			LOGS.info(Thread.currentThread() + "Salesforce Login Method");

			// Linux Settings
			// driver = linuxSettings();

			// windows Settings
			driver = windowsSettings();

			if (SFInspectorPlugin.equalsIgnoreCase("True")) {
				LOGS.info(Thread.currentThread() + "Launching Chrome with SF inspector extension");

				String ExtensionPath = System.getProperty("user.home")
						+ "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aodjmnfhjibkcdimpodiifdjnnncaafh\\1.11_0";

				ChromeOptions options = new ChromeOptions();
				options.addArguments("load-extension=" + ExtensionPath);
				driver = new ChromeDriver(options);
			}

			else if (contractDownload.equalsIgnoreCase("Yes") || signatureDownload.equalsIgnoreCase("Yes")) {

				driver = new ChromeDriver();
				driver.get("chrome://settings/content/pdfDocuments?search=Site+Settings");
				// Thread.sleep(5000);

				WebElement downloadPrompt = driver
						.findElement(By.xpath("//input[@pref='download.prompt_for_download']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadPrompt);

				// Thread.sleep(2000);
			} else {
				// driver = new ChromeDriver(chromeOptions);

				// driver = new ChromeDriver();
				// DriverFactory DF = new DriverFactory();
				/*
				 * LOGS.info(Thread.currentThread() +"Heyy I am DriverFactory Class"); driver =
				 * DriverFactory.getInstance().getDriver();
				 */

				LOGS.info(Thread.currentThread() + "Chrome Driver initialization");
				DF.setDriver(driver);
				LOGS.info(Thread.currentThread() + "hey---4" + DF);
				LOGS.info("driver value: " + driver);
				driver = DF.getDriver();

			}

			// driver.navigate().to("https://hibu--full01.my.salesforce.com");
			driver.navigate().to("https://test.salesforce.com");
			LOGS.info(Thread.currentThread() + "URL launched");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			LOGS.info(Thread.currentThread() + "Current Page Title is :" + driver.getTitle());
			LOGS.info(Thread.currentThread() + "Current Page URL is :" + driver.getCurrentUrl());

			if (SalesRepType.trim().equalsIgnoreCase("TSales")) {
				LOGS.info(Thread.currentThread() + User + "*********************************" + Pwd);
				Locator("salesforceUser").sendKeys(User);
				Locator("salesforcePwd").sendKeys(Pwd);
			} else {
				Properties OR = pr.loadPropertiesFiles("Order");
				LOGS.info(Thread.currentThread() + "Login Sales Rep -> " + OR.getProperty(User));
				LOGS.info(Thread.currentThread() + OR.getProperty(User) + "*********************************"
						+ OR.getProperty(Pwd));
				Locator("salesforceUser").sendKeys(OR.getProperty(User));
				Locator("salesforcePwd").sendKeys(OR.getProperty(Pwd));
			}
			long Seconds = 60;
			wait = new WebDriverWait(driver, Seconds);

			Locator("SalesforceLogin").click();
			LOGS.info(Thread.currentThread() + "Login button Clicked");
			// Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);

			ActRes = driver.getCurrentUrl();
			ExpRes = "Salesforce page should contain the URL full01 ";
			LOGS.info("Salesforce Page URL: " + ActRes);

			try {
				LOGS.info("Results Folder Path value: " + Resultsfolderpath);
				LOGS.info("Results Folder Path value: " + pr.Resultsfolderpath);

				WebElement HomeTab = driver.findElement(By.cssSelector("#home_Tab>a"));

				wait.until(ExpectedConditions.elementToBeClickable(HomeTab));

				JavascriptExecutor jsHT = (JavascriptExecutor) driver;
				jsHT.executeScript("arguments[0].click();", HomeTab);

				SalesForceLoginResult = "Pass";
				Status = "Pass";

				ExportResults.exportTestResult(
						"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + "No Image",
						pr.Resultsfolderpath);

				LOGS.info(Thread.currentThread() + "Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);
			} catch (Exception e) {

				LOGS.info("after Login Waited for Home page but needs more time to load");
				LOGS.error("Unable to Login to Salesforce at first: " + e.getMessage());
				ActRes = driver.getCurrentUrl();
				ExpRes = "Salesforce page should contain the URL full01 ";
				LOGS.info("Salesforce Page URL: " + ActRes);

				if (ActRes.contains("full01")) {

					SalesForceLoginResult = "Pass";
					Status = "Pass";

					LOGS.info("Results Folder Path value: " + Resultsfolderpath);
					LOGS.info("Results Folder Path value: " + pr.Resultsfolderpath);
					ExportResults.exportTestResult(
							"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + "No Image",
							pr.Resultsfolderpath);
					LOGS.info(Thread.currentThread() + "Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);

					WebElement HomeTab = driver.findElement(By.cssSelector("#home_Tab>a"));
					wait.until(ExpectedConditions.elementToBeClickable(HomeTab));

					JavascriptExecutor jsHT = (JavascriptExecutor) driver;
					jsHT.executeScript("arguments[0].click();", HomeTab);

					return SalesForceLoginResult;

				} else {
					SalesForceLoginResult = "Fail";
					ExceptionMsg = "Exception Happened while Loggging into the Salesforce";
					Status = "Fail";
					ImageName = "LoginFailure";
					ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
					LOGS.info("Results Folder Path value: " + Resultsfolderpath);
					LOGS.info("Results Folder Path value: " + pr.Resultsfolderpath);
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Accounts_Tab>a")));
					driver.findElement(By.cssSelector("#Accounts_Tab>a")).click();

					ExportResults.exportTestResult(
							"Login to Salesforce," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
							pr.Resultsfolderpath);
					LOGS.info(Thread.currentThread() + "Login to Salesforce," + ExpRes + "," + ActRes + "," + Status);
					return SalesForceLoginResult;
				}

			}

			// To check the Scenario Status

		} catch (Exception e) {
			SalesForceLoginResult = "False";
			Status = "Fail";
			ExceptionMsg = "Exception Happened while Loggging into the Salesforce";
			ImageName = "SalesforceLogin";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, pr.Resultsfolderpath);
			ExportResults.exportTestResult("Login to Salesforce," + "Login Successful" + ","
					+ "Exception found while Logging into SF" + "," + Status + "," + ImgName, pr.Resultsfolderpath);
			LOGS.info(Thread.currentThread() + "Login to Salesforce," + "Login Successful" + "," + e.getMessage() + ","
					+ Status + "," + ImgName);

			LOGS.error("Unable to Login to Salesforce", e);

			return SalesForceLoginResult;

		}
		return SalesForceLoginResult;
	}

	public WebDriver windowsSettings() throws Exception {

		try {
			// windows Settings

			System.setProperty("webdriver.chrome.driver", regardingfilesPath + "\\Drivers\\chromedriver.exe");
			LOGS.info(Thread.currentThread() + "Windows Settings");
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			// chromeOptions.addArguments("--no-sandbox");// Bypass OS security model
			// chromeOptions.addArguments("--headless"); //to enable headless browser
			// chromeOptions.addArguments("--incognito");// comment it when you are running
			// in windows
			chromeOptions.addArguments("--ignore-ssl-errors=yes");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("window-size=1920x1080");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-extensions"); // disabling extensions
			chromeOptions.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
			// chromeOptions.setExperimentalOption("useAutomationExtension", false);
			// chromeOptions.addArguments("--remote-debugging-port=9222");

			chromeOptions.addArguments("--allow-insecure-localhost");
			DesiredCapabilities caps = new  DesiredCapabilities();
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			caps.setCapability("acceptInsecureCerts", true);
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			caps.setCapability("applicationCacheEnabled", false);
			caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			caps.setCapability("chrome.switches", Arrays.asList("--incognito"));
			caps.setCapability("goog:chromeOptions", chromeOptions);
			chromeOptions.merge(caps);

			driver = new ChromeDriver(chromeOptions);

		} catch (Exception e) {
			LOGS.info(Thread.currentThread() + "Windows Options" + "load failed" + "," + e.getMessage());

			LOGS.error(Thread.currentThread() + "Unable to Login to Salesforce", e);
			LOGS.error(Thread.currentThread() + "Unable to Login to Salesforce" + e.getMessage());
		}
		return driver;
	}
	
	
	public String SearchAccount(String BusinessId, String Resultsfolderpath) {

		try {
			LOGS.info(Thread.currentThread() + "Searching Account .....");
			Status = "Pass";
			LOGS.info(Thread.currentThread() + BusinessId);

			businessID = BusinessId.replace(" ", "");

			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//div[@id='searchButtonContainer']"))));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='phSearchInput']")));
			driver.findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessID);
			LOGS.info("Entered Business id in Search Field");
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//div[@id='searchButtonContainer']")))).click();

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			LOGS.info("Clicked on Search Button");

			ExpRes = "Account Verification and it should be Available";
			ImageName = "ExistingAccount";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, Resultsfolderpath);
			try {

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//td[text()='" + businessID + "']//parent::tr//th/a")));
				driver.findElement(By.xpath("//td[text()='" + businessID + "']//parent::tr//th/a")).click();

				LOGS.info(Thread.currentThread() + "Clicking on Account Link");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				ActRes = "Account Found";

				if (SalesRepType.equalsIgnoreCase("OpsWizard")) {
					driver.findElement(By.xpath("//span[text()='Details']")).click();
					LOGS.info(Thread.currentThread() + "Clicking on Details Link for the " + SalesRepType + " Rep ");
					driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

					LOGS.info(Thread.currentThread() + "Clicked on Details Link ");
				}

			} catch (Exception e) {
				LOGS.info(Thread.currentThread() + "Account Not Found");
				ActRes = "Account Not Found";
				LOGS.error("Error in SearchAccount Method: Account Not Found : " + Thread.currentThread() + " : " + e);
				ExceptionMsg = "Error in SearchAccount Method :: Account Not Found";
				LOGS.info(Thread.currentThread() + "," + "Error in SearchAccount Method :: Account Not Found - "
						+ e.getStackTrace());
				Status = "Fail";
				count = count + 1;
				return Status;
			}
			ExportResults.exportTestResult(
					"Account Verification :," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					Resultsfolderpath);

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			String regex = "\\d+";
			wait.until(ExpectedConditions.textMatches(By.xpath("//span[text()='Live Products']/span"),
					Pattern.compile(regex)));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Live Products']/span")));
			String LiveProductAllCount = SLocator("LiveProductCount").getText();
			LiveProductAllCount = LiveProductAllCount.replace("[", "");
			LiveProductAllCount = LiveProductAllCount.replace("]", "");
			LOGS.info(Thread.currentThread() + "All Live Product Count taking from top row links- "
					+ LiveProductAllCount);

			LOGS.info(Thread.currentThread() + "Clicking on Live Products link to get Active product details");
			wait.until(ExpectedConditions.elementToBeClickable(SLocator("LiveProductLink")));
			SLocator("LiveProductLink").click();

			LOGS.info(Thread.currentThread() + "Clicked on Live Products link");
			String captureProdCountStr = "";
			productsCaptureHomePage = "";

			if (LiveProductAllCount.contains("+")) {

				captureProdCountStr = SLocator("LiveProdCountStr").getText();
				LOGS.info(Thread.currentThread() + "Captured Text-" + captureProdCountStr);

				captureProdCountStr = captureProdCountStr.replaceAll("[^0-9]", "");

				SLocator("LiveProdCountStr").click();

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				int ActiveProductsCount = Integer.parseInt(captureProdCountStr);

				for (int i = 1; i <= ActiveProductsCount; i++) {
					String activeProdPath = "//tr[contains(@class,'dataRow')][" + i + "]/th/a";

					String getActiveProducts = driver.findElement(By.xpath(activeProdPath)).getText();
					LOGS.info(Thread.currentThread() + "Product Name is :" + getActiveProducts);

					ProductName.add(getActiveProducts);
					productsCaptureHomePage = productsCaptureHomePage + "-" + getActiveProducts;
				}

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='listRelatedObject customnotabBlock']//table[@class='list']//tr/th/a[contains(text(), 'Assistant')]"))).click();
				
				assistantAssetId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='labelCol'][contains(text(), 'Asset ID')]/parent::tr/td[2]"))).getText();
				assistantAssetId = assistantAssetId.replaceAll(" ", "");
				LOGS.info(Thread.currentThread() + "Captured Assistant AssetId: " + assistantAssetId);
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.navigate().back();
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Details']"))).click();
				LOGS.info(Thread.currentThread() + "Clicking on Details Link for the " + SalesRepType + " Rep ");
								
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
				//return assistantAssetId;

			} else {
				captureProdCountStr = LiveProductAllCount;
				LOGS.info(Thread.currentThread() + "****" + LiveProductAllCount);
				int ActiveProductsCount = Integer.parseInt(captureProdCountStr);

				for (int i = 1; i <= ActiveProductsCount; i++) {
					String activeProdPath = "//div[@class='listHoverLinks']//following::h3[text()='Live Products']//ancestor::div[1]//following::div[1]//tr["
							+ (i + 1) + "]/th/a";

					String getActiveProducts = driver.findElement(By.xpath(activeProdPath)).getText();
					LOGS.info(Thread.currentThread() + "Product Name is :" + getActiveProducts);

					ProductName.add(getActiveProducts);
					productsCaptureHomePage = productsCaptureHomePage + "-" + getActiveProducts;
				}
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='listRelatedObject customnotabBlock']//table[@class='list']//tr/th/a[contains(text(), 'Assistant')]"))).click();
				
				assistantAssetId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='labelCol'][contains(text(), 'Asset ID')]/parent::tr/td[2]"))).getText();
				assistantAssetId = assistantAssetId.replaceAll(" ", "");
				LOGS.info(Thread.currentThread() + "Captured Assistant Id: " + assistantAssetId);
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
				driver.navigate().back();
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Details']"))).click();
				LOGS.info(Thread.currentThread() + "Clicking on Details Link for the " + SalesRepType + " Rep ");
								
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				//return assistantAssetId;

			}

			ImageName = "LiveProduct";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, Resultsfolderpath);
			ExpRes = "Capture the Product Count and Products available for the Account - " + businessID;
			prodCount = ProductName.size();
			LOGS.info(Thread.currentThread() + "Available Active Product: " + prodCount);

			ActRes = prodCount + " Live Products Available and Products are \n" + productsCaptureHomePage;
			Status = "Pass";
			ExportResults.exportTestResult(
					"Live Product Details:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					Resultsfolderpath);
		} catch (Exception e) {
			LOGS.info(Thread.currentThread() + "Account Not Found");
			ActRes = "Account Not Found";
			LOGS.error("Error in SearchAccount Method: Account Not Found : " + Thread.currentThread() + " : " + e);
			ExceptionMsg = "Error in SearchAccount Method :: Account Not Found";
			LOGS.info(Thread.currentThread() + "," + "Error in SearchAccount Method :: Account Not Found - "
					+ e.getStackTrace());
			Status = "Fail";
			count = count + 1;
			return Status;
		}
		
		return assistantAssetId;
	}
	
	
	public void AssistantLocationCreation(String BusinessID, String Resultsfolderpath) throws Exception
	{
		
		try
		{
		LOGS.info(Thread.currentThread() + "Going to click on Assistant Dashboard");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//td[@id=\"topButtonRow\"]//input[@name='assistant_dashboard']"))).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		ArrayList<String> astWindowHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(astWindowHandle.get(1));
		String TabSelected = driver.getTitle();
		LOGS.info(Thread.currentThread() + "Tab Selected: " + TabSelected);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		ImageName = "SignPost";
		ImgName = ScreenshotPrinter.screenShot(ImageName, driver, Resultsfolderpath);
		ExpRes = "User Successfully Move Into SignPost Page";
		ActRes = "User Successfully Moved to SignPost Page. Title: "+driver.getTitle();
		Status = "Pass";
		ExportResults.exportTestResult(
				"SignPost Page:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
				Resultsfolderpath);
		
		}
		catch(Exception e)
		{
			LOGS.info(Thread.currentThread() + "There is some exception: "+e);
			
			ImageName = "SignPost";
			ImgName = ScreenshotPrinter.screenShot(ImageName, driver, Resultsfolderpath);
			ExpRes = "User Successfully Move Into SignPost Page";
			ActRes = "There is some Exception";
			Status = "Fail";
			ExportResults.exportTestResult(
					"SignPost Page:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					Resultsfolderpath);
		}
		
	}
	
	
	
	public void TriggerRestCall_NewReviewForGoogle(String assetID, String BusinessId, String Resultsfolderpath)
			throws Exception {

		LOGS.info("Asset Id: " + assetID);
		LOGS.info("Business Id: " + BusinessId);

		RestAssured.baseURI = "https://hibuapigw.testingnet.com";
		RequestSpecification request = RestAssured.given()
				.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
		//JSONObject requestParams = new JSONObject();

		Date date = new Date();
		long time = date.getTime();
		Timestamp timeNow = new Timestamp(time);

		Random rand = new Random();
		int randomNum = rand.nextInt(9000000) + 1000000;
		String randomValue = String.valueOf(randomNum);

		String jsonDataReviewGoogle = "{\"eventType\":\"Review\"," + "\"eventDetails\":{" + "\"partnerLocationId\":\""
				+ assetID + "\"," + "\"timestamp\":\"" + timeNow + "\"," + "\"contact\":{"
				+ "\"email\":\"Chethansingh@ten.com\"," + "\"firstName\":\"Harris\"," + "\"lastName\":\"William\"},"
				+ "\"reviewSiteName\":\"Google\"," + "\"rating\":4}}";

		request.header("Content-Type", "application/json");
		request.header("X-Api-Key", "GDnxPfrddh5L3DYSUbRv18C6juwHYgLdbxlryQPi");
		request.header("X-Signpost-Webhook-Event-Id", "Email" + randomValue);

		request.body(jsonDataReviewGoogle);

		Response response = null;

		response = request.post("/assistant/set-event-details");

		int statusCode = response.getStatusCode();
		LOGS.info("Status: " + statusCode);

		String responseBody = response.getBody().asString();
		LOGS.info("Output: " + responseBody);

		if ((statusCode == 200) || statusCode == 201) {
			System.out.println("Response Success with :" + statusCode);
			System.out.println("Response Body is: " + responseBody);

			ExpRes = "User Should be able to Trigger Review Notification for Google";
			ActRes = "User Successfully Triggered Review Notification for Google";
			Status = "Pass";
			ExportResults.exportTestResult(
					"Review Notification:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName, Resultsfolderpath);

			VerifyEventDetailsInDBforNewReviewNotificationGoogle(BusinessId, Resultsfolderpath);
			VerifyNotificationDetailsInDBforNewReviewNotificationGoogle(BusinessId, Resultsfolderpath);
		}
		else
	   	{
	   		ExpRes = "User Should be able to Trigger Review Notification for Google";
			ActRes = "There is Some Issue while Triggerring Review Notification for Google";
			Status = "Fail";
			ExportResults.exportTestResult(
					"SignPost Feedback:," + ExpRes + "," + ActRes + "," + Status + "," + ImgName,
					Resultsfolderpath);
	   	}

	}
	
	public void VerifyEventDetailsInDBforNewReviewNotificationGoogle(String BusinessId, String Resultsfolderpath) throws Exception
	{
		LOGS.info("Business Id: " + BusinessId);
		LOGS.info("Inside VerifyEventDetailsInDBforReviewNotificationGoogle");
		
		//******************** verify hibuAssistantEventDetails collection *****************************
		
		MongoClient client = new MongoClient("uatawse101ppdmgd02.aws01.hibu.int", 27019);
		MongoDatabase database = client.getDatabase("hbs");
		MongoCollection<Document> collection = database.getCollection("hibuAssistantEventDetails");

		int documentCounter = 0;

		Date myDate = new Date();
		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String presentdate = dateformatter.format(myDate).toString();

		List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

		for (Document document : documents) {
			if (document.containsValue(BusinessId)) {
				documentCounter = documentCounter + 1;
				
				try {
				if (document.get("timestamp").toString().contains(presentdate)) {

					if (document.get("eventType").toString().equalsIgnoreCase("Review") && 
							document.get("eventDetails").toString().contains("Google")) {
						
						System.out.println(document);
						System.out.println("Event Type :" + document.get("eventType").toString());
						System.out.println("No. of Documents present :" + documentCounter);

						ExpRes = "MongoDB: hibuAssistantEventDetails - EventType Should be Set as Review";
						ActRes = "MongoDB: hibuAssistantEventDetails - EventType is Set as Review: "
								+ document.get("eventType");

						Status = "Pass";
						ExportResults.exportTestResult("MongoDB: hibuAssistantEventDetails - EventType," + ExpRes + ","
								+ ActRes + "," + Status + "," + ImgName, Resultsfolderpath);
					} 
				}
				}
				catch (Exception e) {
					System.out.println("There is some Exception: " + e);
					ExpRes = "MongoDB: hibuAssistantEventDetails - EventType Should be Set as Review";
					ActRes = "MongoDB: hibuAssistantEventDetails - There is some Exception";
					Status = "Fail";
					ExportResults.exportTestResult("MongoDB: hibuAssistantEventDetails - EventType," + ExpRes + ","
							+ ActRes + "," + Status + "," + ImgName, Resultsfolderpath);
				}
			}
		}

		client.close();
		
	}
	
	public void VerifyNotificationDetailsInDBforNewReviewNotificationGoogle(String BusinessId, String Resultsfolderpath) throws Exception
	{
		LOGS.info("Business Id: " + BusinessId);
		LOGS.info("Inside VerifyNotificationDetailsInDBforReviewNotificationGoogle");
		
		//******************** verify hibuAssistantNotificationDetails collection *****************************
		
		MongoClient client = new MongoClient("uatawse101ppdmgd02.aws01.hibu.int", 27019);
		MongoDatabase database = client.getDatabase("hbs");
		MongoCollection<Document> collection = database.getCollection("hibuAssistantNotificationDetails");

		int documentCounter = 0;

		Date myDate = new Date();
		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String presentdate = dateformatter.format(myDate).toString();

		List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());

		for (Document document : documents) {
			if (document.containsValue(BusinessId)) {
				documentCounter = documentCounter + 1;
				
				try {

					if (document.get("dateTime").toString().contains(presentdate)) {

						if (document.get("eventType").toString().equalsIgnoreCase("Review")
								&& document.get("email").toString().contains("You have a new review")
								&& document.get("simpleAssistantDetailsRecord").toString().contains("Google")) {

							System.out.println(document);
							System.out.println("Event Type :" + document.get("eventType").toString());
							System.out.println("No. of Documents present :" + documentCounter);

							ExpRes = "MongoDB: hibuAssistantNotificationDetails - EventType Should be Set to Review";
							ActRes = "MongoDB: hibuAssistantNotificationDetails - EventType is set as Review: "
									+ document.get("eventType");

							Status = "Pass";
							ExportResults.exportTestResult("MongoDB: hibuAssistantNotificationDetails - EventType,"
									+ ExpRes + "," + ActRes + "," + Status + "," + ImgName, Resultsfolderpath);
						}
					}
				} catch (Exception e) {
					System.out.println("There is some Exception: " + e);
					
					ExpRes = "MongoDB: hibuAssistantNotificationDetails - EventType Should be Set to Review";
					ActRes = "MongoDB: hibuAssistantNotificationDetails - There is some Exception";
					Status = "Fail";
					ExportResults.exportTestResult("MongoDB: hibuAssistantNotificationDetails - EventType,"
							+ ExpRes + "," + ActRes + "," + Status + "," + ImgName, Resultsfolderpath);
					
				}
			}
		}

		client.close();
		
	}
		
}
