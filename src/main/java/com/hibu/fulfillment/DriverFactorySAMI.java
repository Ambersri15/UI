package com.hibu.fulfillment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public class DriverFactorySAMI
{
	 ThreadLocal<WebDriver> driver;
   public DriverFactorySAMI()
   {
	  driver = new ThreadLocal<WebDriver>(); // thread local driver object for webdriver
   }
   
   public  DriverFactorySAMI getInstance()
   {
      return new DriverFactorySAMI();
   }

  
  
   
   public void setDriver(WebDriver firstDriverInit) {
		
		driver.set(firstDriverInit); 
	}

   public WebDriver getDriver() // call this method to get the driver object and launch the browser
   {
      return driver.get();
   }

   public void removeDriver() // Quits the driver and closes the browser
   {
      driver.get().quit();
      driver.remove();
   }
}












