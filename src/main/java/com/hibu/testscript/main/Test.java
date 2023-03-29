package com.hibu.testscript.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hibu.emailNotification.EndUserEmailNotification;
import com.hibu.emailNotification.GmailTest;
import com.hibu.emailNotification.OutlookTest;
import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;
import com.hibu.testscripts.FF.NonSAMI_FF;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Test extends PreRequisites{
	
    private final Logger logger = LogManager.getLogger(Test.class);

   /* public Test(String TextName) {
        System.out.println(logger.isInfoEnabled());
        logger.entry();
        logger.info("info! {}", TextName);
        logger.error("error! {}", TextName);
        logger.debug("debug! {}", TextName);
    }
*/
	public static void main(String args[]) throws Throwable {
		/*DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.ANY);
		caps.setBrowserName("chrome");
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.google.com/");*/
		
		/*LeadTest LT = new LeadTest();
		LT.LeadConvert();*/
		
      //Test h1 = new Test("1001");
		
		/*SalesforceTasks s = new SalesforceTasks();
		s.questionnaireCompletionForLocalRankingProducts("00390243","Synchronized Marketing Solutions");*/
		//NonSAMIFulfillment nsf = new NonSAMIFulfillment();
		//nsf.main("10476131","Website (a la carte)", 4546);
		
		
		/*DscAndQuestionnaire DQ = new DscAndQuestionnaire();
		DQ.main("00391392", "Online Foundation Solutions");*/
		
		
		DomainProvisionAndPublishing DPP8 = new DomainProvisionAndPublishing();
		DPP8.main("8046833801", 0);
		
	/*Main_Quote_Submission8 QS8 = new Main_Quote_Submission8();
		QS8.main("Foundation + Social & Search - Medium","TSales");
		*/
		/*Main_Quote_SubmissionCopy QScopy = new Main_Quote_SubmissionCopy();
		QScopy.main("Foundation + Display & Search - Large","TSales");*/
		
		
	/*	Main_Quote_Submission QS = new Main_Quote_Submission();
		QS.main("Smart Presence + Display & Search - Medium","TSales", 4545); */
		/*Main_Quote_Submission3 QS3 = new Main_Quote_Submission3();
		QS3.main("Display (a la carte)","TSales"); 
	*/
		
		/*Main_Quote_Submission3 QS3 = new Main_Quot*/
      	Main_Quote_Submission QS4 = new Main_Quote_Submission();
		//QS4.main("Smart Site - Pro", "TSales",4545);
		//QS4.main("Smart Presence + Display & Search - Medium","TSales",4546);
		//QS4.main("Smart Presence + 1 Ad Campaign + Display","TSales",4547);
	   //QS4.main("Smart Sync - Medium","Premise",4555);
		//QS4.main("Smart Site - Pro","Premise",4549);
		//QS4.main("Synchronized Marketing - Large + LR","Premise",4547);
		//QS4.main("Foundation + Social & Search - Medium + LR","Premise",4546);
		//QS4.main("Display (a la carte),Social (a la carte),Search (a la carte)","TSales");
//	
		
		//NonSAMI_FF nso = new NonSAMI_FF();
		//nso.main("8046833379", 4546);
		//
	/*NonSAMI_FF3 nso3 = new NonSAMI_FF3();
		nso3.main("8046821343");*///
		
	/*	NonSAMI_FF4 nso4 = new NonSAMI_FF4();
		nso4.main("8046814147");*/
		/*Main_Quote_Submission QS = new Main_Quote_Submission();
		QS.main("Online Foundation Solution","TSales",4546);*/
	
		/*NonSAMIFulfillment NSF = new NonSAMIFulfillment();
		NSF.main("10483324", "Online Foundation Solutions",4545);*/
		
	/*Main_AmendandADD AandA = new Main_AmendandADD();
	AandA.main("8046832094", "Display (a la carte)","Synchronized Marketing - Medium",4546);*/
	
	
	//	Main_CancelAll_CreditAndCustomer Main_CancelAll_CreditAndCustomer = new Main_CancelAll_CreditAndCustomer();
		//Main_CancelAll_CreditAndCustomer.main("8046831890","Customer",4546);

			//Main_CancelandReplace Main_CancelandReplace =  new Main_CancelandReplace();
			//Main_CancelandReplace.main("8046832094", "Display (a la carte)", "Foundation + Display & Search - Large",4546);
			
		
		//EndUserEmailNotification.sendEmail("Hi", "Testing", "pritam.singh10@wipro.com", "UIAutomain@hibu.com");
		/*OutlookTest out = new OutlookTest();
	    out.main("sabarishrahul.b22@wipro.com");*/
		/*GmailTest gml = new GmailTest();
		gml.main("amber.srivastava@wipro.com");*/
		
	//BudgetChangeForSolutions pricem = new BudgetChangeForSolutions();
		//pricem.main("8046826710","Smart Sync - Small","Display,Social","500,700");
		/*
		BudgetChangeForSolutions pricem = new BudgetChangeForSolutions();
		pricem.main("8046827996","Social (a la carte)","Social","900");*/
		
	//	BudgetChangeForSolutions BCS = new BudgetChangeForSolutions();
		//BCS.main("8046816012", "Display (a la carte)", "Display", "700");8046831743///8046829835//8046831743//7044026630//7074623219
		//BCS.main("8046829835", "Synchronized Marketing - Medium", "Managed Search,Display,Social", "1300,1100,1200",4546);
		//BCS.main("8046831743", "Smart Presence + Display & Search - Small", "Display,Managed Search", "900,650");
		//BCS.main("8046829773", "Display (a la carte)", "Display", "500",4546);
		//BCS.main("8046829769", "Foundation + 1 Ad Campaign + Social", "Social", "1000");
		//BCS.main("8046829837", "Smart Presence + Social & Search - Medium", "Managed Search", "950");
		//BCS.main("7014683637", "Foundation + 1 Ad Campaign + Display", "Display", "550",4546);
		
	//	BCS.main("8046831952", "Social (a la carte)", "Social", "500",0);
		//ZephyrTestCase.getCycleIDs();
		
		
	}

}
