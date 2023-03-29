package com.hibu.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class ScreenshotPrinter extends PreRequisites {
	//public static Logger LOGS = Logger.getLogger(ScreenshotPrinter.class.getName());
	public static Logger LOGS = LogManager.getLogger(ScreenshotPrinter.class.getName());
	//PreRequisites pr = new PreRequisites();
	
	public String screenShot(String ImageName, WebDriver driver, String Resultsfolderpath) throws IOException
			{	
		{	
			
			LOGS.info(Thread.currentThread() +"Taking Screen shot"); 
			
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			ImageName=ImageName+timeStamp+".png";
			 String ImagePath=Resultsfolderpath+"/"+ImageName;
			 LOGS.info(Thread.currentThread() +"Screenshot path :" +ImagePath);

			      
			try {
				
				// now copy the  screenshot to desired location using copyFile method
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
					FileUtils.copyFile(src, new File(ImagePath));  
					LOGS.info(Thread.currentThread() +"Src path :" +src.getAbsolutePath()     + "------"+src.getPath());
					System.out.println(Thread.currentThread() +"Src path :" +src.getAbsolutePath()     + "------"+src.getPath());

					System.out.println(ImagePath);
					LOGS.info(Thread.currentThread() +"Screen shot Taken");
				    return ImageName;
				}
			catch(Exception e)
			{
				LOGS.error("error : " +e);
								e.printStackTrace();
			}
			return ImageName;
	
		}
			}
	

	
	public String screenShotPrint(String ImageName) throws IOException {
		{

			LOGS.info(Thread.currentThread() +"Taking Screen shot");

			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			ImageName = ImageName.replace(" + ", "Plus");
			ImageName = ImageName.replace("/", "");
			ImageName = ImageName.replace(" ", "");
			ImageName = ImageName + timeStamp + ".png";
			
			String ImagePath = Resultsfolderpath + "/" + ImageName;
			 LOGS.info(Thread.currentThread() +"screenShotPrint :" +ImagePath);
			// String ImagePath=System.getProperty("user.dir")+"\\Images\\"+ImageName;
			try {
				// now copy the screenshot to desired location using copyFile method
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File(ImagePath));
				System.out.println(ImagePath);
				LOGS.info(Thread.currentThread() +"Screen shot Taken");
				return ImageName;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ImageName;

		}
	}
}
