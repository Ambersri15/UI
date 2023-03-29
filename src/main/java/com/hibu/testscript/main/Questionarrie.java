package com.hibu.testscript.main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.hibu.tests.PreRequisites;

public class Questionarrie extends PreRequisites {
	
	public static Logger LOGS = LogManager.getLogger(Questionarrie.class.getName());
	

	public static WebDriver webdriver = null;
	

	
	public static void main(String args[]) throws Exception {
	
	//https:hibu--full01--c.cs54.visual.force.com/apex/HibuVFPageQuestionnaire?id=5000S000006AjxB
	System.setProperty("webdriver.chrome.driver","C:\\Automation\\readingfiles\\Drivers\\chromedriver.exe");
	
	 ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--ignore-ssl-errors=yes");
		chromeOptions.addArguments("--ignore-certificate-errors");
		chromeOptions.addArguments("window-size=1920x1080");
		chromeOptions.addArguments("--start-maximized");    
      
      chromeOptions.addArguments("--allow-insecure-localhost");
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
      caps.setCapability("acceptInsecureCerts", true);
      caps.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
      caps.setCapability("applicationCacheEnabled", false);	
      caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
      caps.setCapability("chrome.switches",Arrays.asList("--incognito"));
      caps.setCapability("goog:chromeOptions", chromeOptions);
      chromeOptions.merge(caps);
     
     // driver = new ChromeDriver(caps);

	webdriver = new ChromeDriver();
	

webdriver.navigate().to("https://hibu--full01--c.cs201.visual.force.com/apex/HibuVFPageQuestionnaire?id=5000S000006AjxB");
LOGS.info("URL launched");
webdriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
webdriver.manage().window().maximize();
LOGS.info("Current Page Title is :" + webdriver.getTitle());
LOGS.info("Current Page URL is :" + webdriver.getCurrentUrl());
webdriver.findElement(By.xpath("//input[@id='username']")).sendKeys("kavya.lakshmikantha@hibu.com.full01");
webdriver.findElement(By.xpath("//input[@id='password']")).sendKeys("Summer08");
webdriver.findElement(By.xpath("//input[@id='Login']")).click();
Thread.sleep(50000);

webdriver.findElement(By.xpath("//*[@id='Save']")).click();
Thread.sleep(5000);


/*//dropDown list
List<WebElement> pickList = webdriver.findElements(By.xpath("//select[@class='picklist']"));
int selectSize = pickList.size();
System.out.println("Select query list : "+ selectSize);
int count = 0;

for(WebElement slect : pickList) {
	////tr[contains(@style,'background: rgb(255, 255, 255)')]/td/table/tbody/tr/td[2]/select[@class='picklist']
	//background: rgb(255, 255, 255); display: table-row;
	
	//tr[contains(@style,'background: rgb(255, 255, 255)')]/td/table/tbody/tr/td[2]/select[@class='picklist']
	
	try {
		if(webdriver.findElement(By.xpath("//tr[contains(@style,'background: #fff')]/td/table/tbody/tr/td[2]/select[@class='picklist']")).isDisplayed()){}
	else if(webdriver.findElement(By.xpath("//tr[contains(@style,'background: rgb(255, 255, 255)')]/td/table/tbody/tr/td[2]/select[@class='picklist']")) != null) {
				Select dropdownPicklist = new Select(slect);
				dropdownPicklist.selectByIndex(2);		
		}else{		
			Select dropdownPicklist = new Select(slect);
			dropdownPicklist.selectByIndex(2);
		}
	  } catch (Exception e) {		
	}
	if(webdriver.findElement(By.xpath("//tr[contains(@style,'background: rgb(255, 255, 255)')]/td/table/tbody/tr/td[2]/select[@class='picklist']")).isDisplayed()) {
		
	}else {
		Select dropdownPicklist = new Select(slect);
		dropdownPicklist.selectByIndex(2);
	}
	count++;
	
}
System.out.println("print the Value : "+ count);
webdriver.findElement(By.xpath("//*[@id='Save']")).click();*/



/*//TextBox Answers

List<WebElement> textArea = webdriver.findElements(By.xpath("//textarea[contains(@name,'texta360S00000')]"));
int textAreaSize = textArea.size();
System.out.println("Select query list : "+ textAreaSize);
 count = 0;
webdriver.manage().timeouts().implicitlyWait(01, TimeUnit.SECONDS);
for(WebElement textbox : textArea) {
	
	try {
		
		if(webdriver.findElement(By.xpath("//tr[contains(@style,'background: #fff')]/td/table/tbody/tr/td[2]/textarea")).isDisplayed()){
			
		}
		if(textbox.isDisplayed()) {

	    	String text = textbox.getText();
	    	if(text.isEmpty() || (textbox.isDisplayed() && text.isEmpty()) ) {
	    		System.out.println("Entering the Text: Test");
	    		textbox.sendKeys("Test");
	    	}else
	    		System.out.println("Text is already Present: "+ text);
	    	
	    
		}
	    else{
	    	System.out.println("Hidden Element.");
	    }
	  } catch (Exception e) {		
	}
	
	
	System.out.println("Present Iteration number: "+ count+" Out of: "+textAreaSize);
	count++;
}

 System.out.println("TextBox count the Value : "+ count);
 webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 webdriver.findElement(By.xpath("//*[@id='Save']")).click();*/


//RadioButton Answers
List<WebElement> radioButton = webdriver.findElements(By.xpath("//div[@class='switch-field']/label[text()='Yes']"));
int radioButtonSize = radioButton.size();
System.out.println("Select query list : "+ radioButtonSize);
int count =0;

webdriver.manage().timeouts().implicitlyWait(01, TimeUnit.SECONDS);
for(WebElement radiobtn : radioButton) {
	
	try {
		
		if(radiobtn.isDisplayed()) {

	    	//if(radiobtn.isSelected() == false) {}
	    		System.out.println("Selecting the RadioButton");
	    		radiobtn.click();
		}
	    else{
	    	System.out.println("Hidden Element.");
	    }
	  } catch (Exception e) {		
	}
	
	System.out.println("Present Iteration number: "+ count+" Out of: "+radioButtonSize);
	count++;
}

 System.out.println("RadioButton count Value : "+ count);
 webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 webdriver.findElement(By.xpath("//*[@id='Save']")).click();











//webdriver.findElement(By.xpath("//tr/td/table/tbody/tr/td[2]/select[@class='picklist']"));

//    //select[@class='picklist']//not(ancestor::tr[contains(@style,'display:none')])

//  //span[@class='required-icon']

//*[@id="a340S0000005J88QAE"]/div/table/tbody/tr[5]/td[2]/div/b

//div[contains(@class,'required')]/b

}
	
	
	

}
