package com.hibu.fulfillment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotPrinter extends SamiPreRequisites {
	
	public static Logger LOGS = LogManager.getLogger(ScreenshotPrinter.class.getName());
	
	public String screenShot(String ImageName, WebDriver driver, String Resultsfolderpath) throws IOException
	{	
		
	LOGS.info("Taking Screen shot");
	
	String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
	ImageName=ImageName+timeStamp+".png";
	 String ImagePath=Resultsfolderpath+"/"+ImageName;
	 LOGS.info("Screenshot path :" +ImagePath);

	      
	try {
		
		// now copy the  screenshot to desired location using copyFile method
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
			FileUtils.copyFile(src, new File(ImagePath));  
			LOGS.info("Src path :" +src.getAbsolutePath()     + "------"+src.getPath());
			System.out.println(ImagePath);
			LOGS.info("Screen shot Taken");
		    return ImageName;
		}
	catch(Exception e)
	{
		LOGS.error("error : " +e);
		e.printStackTrace();
	}
	return ImageName;

 }


	
	
	
	/*public  String screenShot(String ImageName) throws IOException
	{	
		try {
				LOGS.info("Taking Screen shot");
				String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
				System.out.println();
				final Screenshot screenshot = new AShot().shootingStrategy(
			            new ViewportPastingStrategy(500)).takeScreenshot(driver);
			    final BufferedImage image = screenshot.getImage();
			    ImageName=ImageName+timeStamp+".png";
			    
			    String ImagePath=Resultsfolderpath+"\\"+ImageName;
			    System.out.println(ImagePath);
			    ImageIO.write(image, "PNG", new File(ImagePath));
				LOGS.info("Screen shot Taken");
			    return ImageName;
			}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGS.info("There is some exception while taking Screen shot");
			return "fail";
		}
	
	}*/
}
