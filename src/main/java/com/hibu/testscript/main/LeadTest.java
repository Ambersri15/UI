/*package com.hibu.testscript.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hibu.tests.DriverFactory;
import com.hibu.tests.ExportResults;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.ScreenshotPrinter;

public class LeadTest extends PreRequisites {
	PreRequisites pr = new PreRequisites();
	ScreenshotPrinter ScreenshotPrinter= new ScreenshotPrinter();
	ExportResults ExportResults= new ExportResults();
	String LeadCreationResult="";
	
	public String LeadConvert() throws Exception {
		
		DriverFactory df = DriverFactory.getInstance();
		
		//df.setDriver();
		
		
	
	df.getDriver().navigate().to("https://test.salesforce.com");
	LOGS.info("URL launched");
	df.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	df.getDriver().manage().window().maximize();
	LOGS.info("Current Page Title is :" + df.getDriver().getTitle());
	LOGS.info("Current Page URL is :" + df.getDriver().getCurrentUrl());
	
	SalesRepType = "TSales";
	
	if(SalesRepType.trim().equalsIgnoreCase("TSales")) {
		
		Locator("salesforceUser").sendKeys("jenny.jackson@hibu.com.full01");
		Locator("salesforcePwd").sendKeys("Lose2020!@");
	}
	
	
	
	

	String businessPhone = "";
	FileInputStream fis = new FileInputStream(regardingfilesPath+"InputFiles/LeadDetails.properties");
	Properties lead = new Properties();
	lead.load(fis);
	WebDriverWait wait = new WebDriverWait(driver,120);
	try {
		
		AccURL = "";
		df.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LOGS.info("Executing Lead Convert method");
		
	df.getDriver().findElement(By.cssSelector("#Account_Tab>a")).click();
		LOGS.info(Thread.currentThread() +"Navigated to Accounts page");
		
		int randomPhoneExtn = 3000000 + new Random().nextInt(90000);
		businessPhone = lead.getProperty("LeadPhone") + Integer.toString(randomPhoneExtn);
		//businessPhone = "8045621563";
		LOGS.info(Thread.currentThread() +"Phone number :" + businessPhone);

		LOGS.info(Thread.currentThread() +"fetch the Phone Number for input sheet");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phSearchInput']")));
		df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).clear();
		df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessPhone);

		LOGS.info(Thread.currentThread() +"Searching the Phone Number to check the duplicate Accounts");
		LOGS.info(Thread.currentThread() +"click ph no");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='phSearchButton']")));
		//input[@id='phSearchInput']
		
		df.getDriver().findElement(By.xpath("//*[@id='phSearchButton']")).click();
		 WebElement SearchButton = df.getDriver().findElement(By.xpath("//*[@id='phSearchButton']"));
		 JavascriptExecutor jseSearchBTN = (JavascriptExecutor) driver;
		 jseSearchBTN.executeScript("arguments[0].click()", SearchButton); 

		
		
		
		
		df.getDriver().findElement(By.xpath("//a[text()='Leads']")).click();
		LOGS.info("Lead Page is Clicked");
		LOGS.info("checking if the Phone Number already in the DB");
		df.getDriver().findElement(By.cssSelector("#Account_Tab>a")).click();
		LOGS.info("Navigated to Accounts page");
		int randomPhoneExtn = 2000000 + new Random().nextInt(90000);
		businessPhone = lead.getProperty("LeadPhone") + Integer.toString(randomPhoneExtn);
		//businessPhone = "8045620078";
		LOGS.info("Phone number :" + businessPhone);
		// int PhoneNum=Integer.parseInt(businessPhone);

		LOGS.info("fetch the Phone Number for input sheet");
		df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).clear();
		df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessPhone);
			LOGS.info("Searching the Phone Number to check the duplicate Accounts");
		df.getDriver().findElement(By.xpath("//input[@id='phSearchButton']")).click();
        try {
		if (df.getDriver().findElement(By.xpath("//img[@alt='Warning']//following::td/div")).getText()
				.equalsIgnoreCase("No matches found")) {
			LOGS.info("No Dupe account is found");
		 } 
        }
        catch(Exception e){
			List<WebElement> rows = df.getDriver().findElements(By.xpath("//div[@id='Account_body']/table/tbody/tr"));
			int rowcount = rows.size();
			LOGS.info("No. of Accounts present with the same phone number is :" + rowcount);
			for (int i = 0; i < 10; i++) {
				if (rowcount > 1) {

					LOGS.info("Multiple Accounts with the phone number existis");
					LOGS.info("Process to be checked for Next Account");
					
					int randomPin = 2000000 + new Random().nextInt(90000);;
					String num = String.valueOf(randomPin);
					LOGS.info("RANDOM NUM IS:" + num);
					//businessPhone = businessPhone.substring(0, 10) + num;
					businessPhone = lead.getProperty("LeadPhone") + Integer.toString(randomPin);
					//businessPhone = "8045620078";
					LOGS.info("Now the Phone Number is :" + businessPhone);
					df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).clear();
					df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessPhone);
					LOGS.info("Searching the Phone Number to check the duplicate Accounts-----Again");
					df.getDriver().findElement(By.xpath("//input[@id='phSearchButton']")).click();
					try {
						rows = df.getDriver().findElements(By.xpath("//div[@id='Account_body']/table/tbody/tr"));
						rowcount = rows.size();
						LOGS.info("Rows :" + rowcount);
					} catch (Exception e1) {
						LOGS.info("Only one Account with Same phone number exists");
						//e1.printStackTrace();
						break;
					}
                          // Assert.assertEquals(false, true);
				} else {
					LOGS.info("Only one Account with Same phone number exists");
					break;

				}

			}

		}
		
		try {

			df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
			df.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//Boolean dupeNoBoolean =	new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//img[@alt='Warning']//following::td/div"), "No matches found"));
		if (df.getDriver().findElement(By.xpath("//img[@alt='Warning']//following::td/div")).getText()
				.equalsIgnoreCase("No matches found")) {
			LOGS.info(Thread.currentThread() +"No Dupe account is found");
		   } 
		}catch(Exception e) {
			LOGS.info(Thread.currentThread() +" Dupe account is found");
			LOGS.error("Error : "+Thread.currentThread() +";"+ e);
			//td//h3//span[contains(text(),'Accounts ')]
			String dupeCount = df.getDriver().findElement(By.xpath("//td//h3//span[contains(text(),'Accounts ')]")).getText();
			dupeCount = dupeCount.replace("Accounts (",""); //Accounts (1) 
			dupeCount = dupeCount.replace(") Show Filters","");
			int DupeCount=Integer.parseInt(dupeCount); 
			LOGS.info("Dupe Accounts count: "+DupeCount);
			do {
				LOGS.info(Thread.currentThread() +"checking if the Phone Number already in the DB");
					df.getDriver().findElement(By.cssSelector("#Account_Tab>a")).click();
				LOGS.info(Thread.currentThread() +"Navigated to Accounts page");
				randomPhoneExtn = 3000000 + new Random().nextInt(90000);
				businessPhone = lead.getProperty("LeadPhone") + Integer.toString(randomPhoneExtn);
				LOGS.info(Thread.currentThread() +"Phone number :" + businessPhone);
				LOGS.info(Thread.currentThread() +"fetch the Phone Number for input sheet");
				df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).clear();
				df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessPhone);
				LOGS.info(Thread.currentThread() +"Searching the Phone Number to check the duplicate Accounts");
				df.getDriver().findElement(By.xpath("//input[@id='phSearchInput']")).click();
				df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
				df.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				LOGS.info(Thread.currentThread() +"click ph no");
				df.getDriver().findElement(By.xpath("//input[@id='phSearchButton']")).click();
				ImageName = "PhoneSearch";
				ImgName = ScreenshotPrinter.screenShot(ImageName,driver);
				try {
					ActRes = "PhoneSearch";
					ExpRes = "PhoneNumberSearch";
					ImageName = "SuccessfulSearch";
					Status = "PhSearch";
					ImgName = ScreenshotPrinter.screenShot(ImageName,driver);
					ExportResults.exportTestResult("Linux server," + ExpRes + "," + ActRes + "," + Status + "," + ImgName);
					df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
					df.getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					if (df.getDriver().findElement(By.xpath("//img[@alt='Warning']//following::td/div")).getText()
						.equalsIgnoreCase("No matches found")) {
					LOGS.info(Thread.currentThread() +"No Dupe account is found");
					DupeCount=0;
				   }
				} catch(Exception exp) {
					
					dupeCount = df.getDriver().findElement(By.xpath("//td//h3//span[contains(text(),'Accounts ')]")).getText();
					dupeCount = dupeCount.replace("Accounts (",""); //Accounts (1) 
					dupeCount = dupeCount.replace(") Show Filters","");
					DupeCount=Integer.parseInt(dupeCount); 
				}
				
			}while(DupeCount>=1);
		}
			
		
		
		
		
		
		df.getDriver().findElement(By.cssSelector("#Lead_Tab>a")).click();
		df.getDriver().findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		LOGS.info("Clicked on new Button");
		Thread.sleep(2000);
		if (SalesRepType.equalsIgnoreCase("SPE")) {

			df.getDriver().findElement(By.xpath("//input[@value='Continue']")).click();
			LOGS.info("Clicked on continue button ");

		}
		// df.getDriver().findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]")).click();
		String RandomExtension = new SimpleDateFormat("MMddHHmmss").format(new Date());
		BusinessNAME = lead.getProperty("LeadName")+ "_" + RandomExtension;
		
		df.getDriver().findElement(By.xpath("//label[text()='Company Name']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(BusinessNAME);
		LOGS.info("Account Name is entered");
		Select dropdown = new Select(df.getDriver().findElement(
				By.xpath("//label[text()='Salutation']//parent::td//following-sibling::td[1]//Select")));
		dropdown.selectByVisibleText("Ms.");
		LOGS.info("Salutation is updated");
		df.getDriver().findElement(By.xpath("//label[text()='First Name']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(lead.getProperty("FName"));
		LOGS.info("First Name is entered");

		if (!(SalesRepType.equalsIgnoreCase("CSRep") || SalesRepType.equalsIgnoreCase("DSCRep"))) {

			Select dropdownLeadSource = new Select(df.getDriver().findElement(
					By.xpath("//label[text()='Lead Source']//parent::td//following-sibling::td[1]//Select")));
			dropdownLeadSource.selectByVisibleText("Customer Referral");
			LOGS.info("Lead Source is selected");
		}

		df.getDriver().findElement(By.xpath("//label[text()='Last Name']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(lead.getProperty("LName"));
		LOGS.info("Last Name entered");
		String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
		String eMail = "qa" + timeStamp + "@qatesting.com";
		df.getDriver().findElement(By.xpath("//label[text()='Contact Email']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(eMail);
		df.getDriver().findElement(By.xpath("//label[text()='Company Email']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(eMail);
		df.getDriver().findElement(By.xpath("//label[text()='Company Phone']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(businessPhone);
		LOGS.info("Phone NUmber is entered");
		df.getDriver().findElement(By.xpath("//label[text()='Street']//parent::td//following-sibling::td[1]//textarea"))
		.sendKeys("# " + RandomExtension + " " + lead.getProperty("LeadStreet"));
		LOGS.info("Address is entered");
		df.getDriver().findElement(By.xpath("//label[text()='City']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(lead.getProperty("LeadCity"));
		LOGS.info("City Name entered");
		Select dropdownState = new Select(df.getDriver().findElement(
				By.xpath("//label[text()='State/Province']//parent::td//following-sibling::td[1]//Select")));
		dropdownState.selectByVisibleText(lead.getProperty("LeadState"));
		LeadState = lead.getProperty("LeadState");
		LOGS.info("State is entered is: "+LeadState);
		df.getDriver().findElement(
				By.xpath("//label[text()='Zip/Postal Code']//parent::td//following-sibling::td[1]//input"))
		.sendKeys(lead.getProperty("LeadZip"));
		LOGS.info("Zipcode entered");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-550)", "");
		df.getDriver().findElement(By.xpath("//td[@id='topButtonRow']/input[@name='save']")).click();
		FileOutputStream outfs = new FileOutputStream(
				regardingfilesPath + "//InputFiles//RowNumber.properties");
		LOGS.info("Lead is successfully Created");

		ActRes = df.getDriver().getCurrentUrl();
		ExpRes = "URL should have full01";
		ImageName = "SuccessfulLead";
		ImgName = ScreenshotPrinter.screenShot(ImageName,driver);
		if (ActRes.contains("full01")) {
			Status = "Pass";
			LeadCreationResult = "Pass";
			ExportResults
			.exportTestResult("Lead Creation Page," + ExpRes + "," + ActRes + "," + Status + "," + ImgName);
			LOGS.info("Lead Creation Page," + ExpRes + "," + ActRes + "," + Status);
		} else {
			Status = "Fail";
			Jiracounter = "Failed";
			LeadCreationResult = "Fail";
			ExportResults
			.exportTestResult("Lead Creation Page," + ExpRes + "," + ActRes + "," + Status + "," + ImgName);
			LOGS.info("Lead Creation Page," + ExpRes + "," + ActRes + "," + Status);
			return LeadCreationResult;

		}

		LOGS.info("Lead Creation is successful");
		df.getDriver().findElement(By.xpath("//input[@name='convert_lead']")).click();
		Thread.sleep(3000);
		LOGS.info("Lead COnvert is clicked");
		Select dropdownAccount = new Select(df.getDriver().findElement(By.id(
				"j_id0:theForm:pageBlock:leadComp:j_id34:pblockconvertLead:convertLeadAccountBlockSectionItem:accountList")));
		int accountdropdownsize = dropdownAccount.getOptions().size();
		LOGS.info("Size :" + accountdropdownsize);
		for (int i = 0; i < accountdropdownsize; i++) {
			LOGS.info("Value :" + dropdownAccount.getOptions().get(i));
		}
		if (dropdownAccount.getOptions().size() > 1) {
			dropdownAccount.selectByIndex(1);
			LOGS.info("Account select while converting");
		} else {
			dropdownAccount.selectByIndex(0);
			LOGS.info("Account select while converting");
		}
		// Convert into Account
		df.getDriver().findElement(By.xpath("//input[@class='btn convertbtn' and contains(@name,'bottom')]")).click();
		LOGS.info("Converted into Account");
		Thread.sleep(5000);
		//String CompName =df.getDriver().findElement(By.xpath("//div[@id=\"acc2_ileinner\"]")).getText();

		ActRes = "Lead is converted into an account ";
		// ActRes=df.getDriver().getTitle();
		ExpRes = "Lead should be converted to an Account";
		ImageName = "convertedLead";
		ImgName = ScreenshotPrinter.screenShot(ImageName,driver);
		if (ActRes.contains("Lead")) {
			LeadCreationResult = "Pass";
			Status = "Pass";
			ExportResults
			.exportTestResult("Lead Conversion," + ExpRes + "," + ActRes + "," + Status + "," + ImgName);
			LOGS.info("Lead COnversion," + ExpRes + "," + ActRes + "," + Status);
		} else {
			Status = "Fail";
			Jiracounter = "Failed";
			LeadCreationResult = "Fail";
			ExportResults.exportTestResult("Lead Conversion," + ExpRes + ","
					+ "Application Slowness - Object not found in Lead Conversion" + "," + Status + "," + ImgName);
			LOGS.info("Lead COnversion" + "Application Slowness - Object not found in Lead Conversion" + ","
					+ ActRes + "," + Status);
			return LeadCreationResult;
		}

		// Edit Account
		Thread.sleep(6000);
		//df.getDriver().navigate().refresh();
		df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		Thread.sleep(6000);
		
		String editAccountResult = "";
		if(editAccountResult.trim().equalsIgnoreCase("Fail")) {
			Status = "Fail";
			ExceptionMsg= "Exception Happened In the Process of editing the Account Information.";
			LeadCreationResult = "Fail";
			
			return LeadCreationResult;
			
		}
		
        LOGS.info("Product Name before Estimating the LR Budget: "+currentPlan);
        if( currentPlan.trim().contains("a la carte") || currentPlan.trim().equalsIgnoreCase("Reviews")
        		|| currentPlan.trim().contains("Guaranteed") || currentPlan.trim().contains("Listings")
        		|| LRSelection.trim().equalsIgnoreCase("WithoutLRBudgetEstimate")) {
        	LOGS.info("Selected Plan should go Without LR Budget Estimation. Plan name: "+currentPlan);
        }
        else {
        	
		//LRBudgetTool();
		}
		
		df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		
		AccURL = df.getDriver().getCurrentUrl();
		//AccURL = df.getDriver().getCurrentUrl();

		LOGS.info(Thread.currentThread() +"Account page url:" +AccURL);
		LOGS.info(Thread.currentThread() +"Clicking the opportunity link, to edit it");
		LOGS.info(Thread.currentThread() +"waiting for the link to be enabled");
		new WebDriverWait(driver,80).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'Opportunities')])[1]")));
		df.getDriver().findElement(By.xpath("(//span[contains(text(),'Opportunities')])[1]")).click();	
		ArrayList<String> newWindowHandle = new ArrayList<String>(df.getDriver().getWindowHandles());
		LOGS.info(Thread.currentThread() + ": Printing the no of handles after clicking on opportunity link : "+newWindowHandle.size());
		if(newWindowHandle.size() > 1) {
		df.getDriver().switchTo().window(newWindowHandle.get(1));
		df.getDriver().close();
		}
		df.getDriver().switchTo().window(newWindowHandle.get(0));
        df.getDriver().findElement(By.xpath("//td[text()='New']//parent::tr//th/a")).click();   
		df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS); 
		df.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		opptyURL = df.getDriver().getCurrentUrl();
		LOGS.info("Opportunity URL is: " + opptyURL);
		new WebDriverWait(driver,80).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='topButtonRow']/input[@name='place_order']")));
        WebElement placeOrder = df.getDriver().findElement(By.xpath("//td[@id='topButtonRow']/input[@name='place_order']"));
       // WebElement placeOrder =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='topButtonRow']/input[@name='place_order']")));
        df.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        JavascriptExecutor jseSubmitBTN = (JavascriptExecutor) driver;
        jseSubmitBTN.executeScript("arguments[0].click()", placeOrder); 
		
			df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		Thread.sleep(2000);
		AccURL = df.getDriver().getCurrentUrl();
		LOGS.info("Clicking the opportunity link, to edit it");
		LOGS.info("waiting for the link to be enabled");
		df.getDriver().findElement(By.xpath("(//span[contains(text(),'Opportunities')])[1]")).click();
		Thread.sleep(2000);
		df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		Thread.sleep(2000);

		df.getDriver().findElement(By.xpath("//input[@value='New Opportunity']")).click();
		Thread.sleep(2000);
		df.getDriver().manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		Thread.sleep(2000);
		createOpportunity("SingleOpportunity");

	} catch (Exception e) {
		ImageName = "LeadConverCatch";
		ImgName = ScreenshotPrinter.screenShot(ImageName,driver);
		LOGS.error("Error : "+Thread.currentThread() +";"+ e);
		ExceptionMsg = "Exception Happened In Lead Page";
		LOGS.info(Thread.currentThread() +"Exception Happened In Lead Page - " + e.getStackTrace());
	
		Status = "Fail";
		Jiracounter = "Exception";
		//searchAccountResult = "Fail";
		LeadCreationResult = "Fail";
		ExportResults.exportTestResult("Search Account :," + "Account Search should be successful" + ","
				+ "Application Slowness - Object not found in Searching Account" + "," + Status + "," + "No Image");
		LOGS.info("Search Account :," + "Account Search should be successful" + ","
				+ "Application Slowness - Object not found in Searching Account" + "," + Status);
		
		
		return LeadCreationResult;
	}
	return LeadCreationResult;

	
	}
}
*/