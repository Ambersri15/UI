package jenkinsTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.hibu.testscript.main.Main_LeadConvert;
import com.hibu.testscript.main.Main_QuoteSubmission;

import testip.TestIP;

public class JenkinsTest {

	 private final Logger logger = LogManager.getLogger(JenkinsTest.class);
	
	 @Test
	 public void LeadTest() throws Throwable {
		// TODO Auto-generated method stub

		Main_LeadConvert lead = new Main_LeadConvert();
		//calling the main method
		lead.main(0);
		 /*Main_QuoteSubmission quote = new Main_QuoteSubmission();
			quote.main(0);*/
		
		
	}
	 
	 @Test
	 public void QuoteTest() throws Throwable{
		 Main_QuoteSubmission quote = new Main_QuoteSubmission();
			quote.main(0); // testing webhook with ngrok part 2
			} 
	 
	 /*@Test
	 public void getIp() throws Throwable {
		 TestIP tst = new TestIP();
		 tst.main();
	 }*/
	 
	

}
