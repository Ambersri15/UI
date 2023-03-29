package com.hibu.testscript;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.hibu.tests.PreRequisites;
import com.hibu.tests.SalesforceTasks;
import com.hibu.tests.ZephyrTestCase;
import com.hibu.testscript.main.*;
import com.hibu.testscripts.FF.NonSAMI_FF;



public class test extends PreRequisites {

	public static void main(String[] args) throws Throwable {
		
/*		DscAndQuestionnaire questionnaire = new DscAndQuestionnaire();
		questionnaire.main("00390994", "Online Foundation Solutions");*/
		
		
		//Sami FF
		//NonSAMI_FF SamiFF = new NonSAMI_FF();
		//SamiFF.main("8046816271");
		
//		Main_AstLocationCreation astLC = new Main_AstLocationCreation();
//		astLC.main("8046824319", "OpsWizard");
//				
//		Main_AstContactCreation astCC= new Main_AstContactCreation();
//		astCC.main("8046824319", "OpsWizard");
		
//		Main_AstSignPostFeedback ast = new Main_AstSignPostFeedback();
//		ast.main("8046822216","OpsWizard");
		
//		Main_AstNewReview astNR = new Main_AstNewReview();
//		astNR.main("8046822216","OpsWizard");
//		
//		Main_AstFirstEmailMilestone astFEM= new Main_AstFirstEmailMilestone();
//		astFEM.main("8046822216","OpsWizard");
//		
//		Main_Ast5thReviewMilestoneGMB ast5RM = new Main_Ast5thReviewMilestoneGMB();
//		ast5RM.main("8046822216","OpsWizard");
		
		//Quote Submission 
		Main_Quote_Submission QS = new Main_Quote_Submission();
		QS.main("Foundation + 1 Ad Campaign,Managed Search,Display,Social\r\n", "TSales", 300);
		
		//CancellAll
		/*Main_CancelAll_CreditAndCustomer Main_CancelAll_CreditAndCustomer = new Main_CancelAll_CreditAndCustomer();
		Main_CancelAll_CreditAndCustomer.main("8046815380","Credit");
		*/
		/*Main_Quote_SubmissionCopy QS = new Main_Quote_SubmissionCopy();
		QS.main("Foundation + Display & Social + LR","Janelle");*/
		//Smart Presence + Social & Search - Large
		
		//Domain Provision and Duda Pubishing
	/*	DomainProvisionAndPublishing sf1 = new DomainProvisionAndPublishing();
		sf1.main("8046816257");*/
		/*
		Main_CancelandReplace main_CancelandReplace = new Main_CancelandReplace();
		main_CancelandReplace.main("8046822191", "Display (a la carte)", "Foundation + 1 Ad Campaign + Display");
		*/
		
		
		//Non Sami Fulfillment	
		//https://hibu--full01.my.salesforce.com/0010S00000UtSvt
		/*NonSAMIFulfillment NSF = new NonSAMIFulfillment();		
	NSF.main("00403066", "Website (a la carte)");*/
	//8045621179
	
		/*SalesRepType.equalsIgnoreCase("TSales")) {
			SalesRep = OR.getProperty("TSales");
			LOGS.info("Login Sales Rep -> " + SalesRep);
			SFLoginResult = SalesforceLogin("sfAdminUserName", "sfAdminPswd", SalesRep);
		*/
		
  	   /* String UiBusinessId = "8045625128";
  	    String UiCancelType =  "Credit";
  	    Main_CancelAll_CreditAndCustomer.main(UiBusinessId, UiCancelType);*/
  	    
		/*String UiBusinessId = "8045618654";
		 String UiExistingProduct = "Smart Presence + Social & Search - Large";
		String UiNewProduct = "Smart Sync - Small + LR";
		Main_CancelandReplace.main(UiBusinessId, UiExistingProduct, UiNewProduct);*/
		//Main_Display_a_la_carte.main();
		/*Main_Search_Guaranteed_Clicks.main();
		Main_Smart_Site_Pro.main();
		Main_Smart_Site_Standard.main();*/
		
		
		//Main_CancelAll_CreditAndCustomer.main("8045625128", "Customer");
		//Main_AmendandADD.main("8045628456","Smart Site - Pro (Spread Billing)", "Display (a la carte)");
		//Main_Quote_Submission.main("Smart Sync - Small + LR");
		
		
		//System.out.println(System.getProperty("user.dir")+"/Templates/ZephyrTestResult.xlsx");
		//Main_SynchronizedMarketing_Large.main();
		//Main_SynchronizedMarketing_Medium.main();
		//Main_SynchronizedMarketing_Small.main();
	//Main_SPS_Social_Search_Small.main();
	//Main_SPS_Social_Search_Medium.main();
	//Main_SPS_Social_Search_Large.main();
		//Main_SPS_Display_Search_Large.main();
		//Main_SPS_Display_Search_Medium.main();
		//Main_SPS_Display_Search_Small.main();
		//Main_SmartSync_Large.main();		
		//Main_SmartSync_Medium.main();
		//Main_SmartSync_Small.main();
	//Main_Online_F_Display_Social.main(); 
		//Main_Online_F_Display_Search_Large.main();
		 //Main_Online_F_Display_Search_Small.main();
		// Main_Online_F_Display_Search_Medium.main(); 
		// Main_Online_F_Social_Search_Small.main(); 
		// Main_Online_F_Social_Search_Medium.main(); 
		// Main_Online_F_Social_Search_Large.main(); 
		 
		
/*		int randomPhoneExtn = 3000000 + new Random().nextInt(90000);
		System.out.println(randomPhoneExtn);
		String businessPhone = "808" + Integer.toString(randomPhoneExtn);
		
		System.out.println("Phone number :" + businessPhone);*/
		
/*		String Summary="Quote Submission for CPQ Prospect as Premise Rep: ";
		String Description = "Successfully Submitted for Quote: ";
		String TestcaseNum1=ZephyrTestCase.createZephyrTestCase(Summary, Description);
		System.out.println(TestcaseNum1);*/
		// TODO Auto-generated method stub

		/*System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.navigate().to("https://test.salesforce.com");*/
/*		
		 TestNG runner=new TestNG();
		    // Create a list of String
		    List<String> suitefiles=new ArrayList<String>();   
		    suitefiles.add("C:\\Automation\\UiDemo\\demo\\display.xml"); 
		    //suitefiles.add("C:\\Automation\\UiDemo\\demo\\"+uiXML.trim()+".xml"); 		    
		    // now set xml file for execution
		    runner.setTestSuites(suitefiles);
		    runner.run();*/
/*		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
*/
		
		/*// Create object of TestNG Class
		TestNG runner=new TestNG();

		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add("C:/Automation/demo/testng.xml");

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		runner.run();*/
		//<option value="Smart Synchronized Solutions">Smart Synchronized Solutions + LR</option>
		  // <option value="Synchronized Marketing Solutions">Synchronized Marketing Solutions + LR</option>
	/*	
	AssistantRCF rcf = new AssistantRCF();
        rcf.main("00413784");
		*/
	/*	QuestionnaireAssistantRCF rcf = new QuestionnaireAssistantRCF();
		rcf.main("00413786"); */  // 00413485, 00413500
	}

}
