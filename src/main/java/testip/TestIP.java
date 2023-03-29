package testip;

import java.io.*;
import java.net.*;

import org.openqa.selenium.By;

import com.hibu.test.PreRequisites;
import com.hibu.test.SalesforceTasks;

public class TestIP extends PreRequisites{

	public void main() throws Throwable {
		// TODO Auto-generated method stub

		//WebDriverManager.chromedriver().version("100.0.4896.60").setup();
		
		
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
		                whatismyip.openStream()));

		String ip = in.readLine(); //you get the IP as a String
		System.out.println(ip);
		/*SalesforceTasks sf = new SalesforceTasks();
		driver = sf.linuxSettings();
		driver.get("http://checkip.amazonaws.com");
		String Ip = driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")).getText();
		System.out.println("this is the global ip address " + Ip);*/
	}
	

}
