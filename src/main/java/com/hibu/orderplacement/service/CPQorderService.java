package com.hibu.orderplacement.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.hibu.tests.PreRequisites;

@Service
public class CPQorderService extends PreRequisites {
	WebDriver driver =null;
	public void testImpl() {
		 driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"Drivers\\chromedriver.exe");
		
		
		
		driver.navigate().to("https://test.salesforce.com");
		
	}

}
