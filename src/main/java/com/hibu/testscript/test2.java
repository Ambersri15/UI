package com.hibu.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test2 {
	
	@Test
	public static void test(){
		System.out.println("I am executing--1");
		System.setProperty("webdriver.chrome.driver","C:\\apache-tomcat-7.0.90\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://test.salesforce.com");
	}

}
