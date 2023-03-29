package com.hibu.tests;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.zeroturnaround.zip.ZipUtil;

import com.hibu.tests.*;


public class PreRequisites{

	//public static Logger LOGS = Logger.getLogger(PreRequisites.class.getName());
	public static Logger LOGS = LogManager.getLogger(PreRequisites.class.getName());
	
public SalesforceTasks st;
//
	//public WebDriver driver = null;
	public ExportResults xportResults;
	public MoveOrCopyFile moveOrCopyFile;
	public ScreenshotPrinter screenshotPrinter;
	public JavascriptExecutor excutor;
  
	//DriverFactory DF = new DriverFactory();
	
	//Exception Messages 
			public String ExceptionMsg="true";
	
	

	//***************************Solutions********************************************
			public static String VersionID="-1"; //Adhoc
			public static String cycleID="-1"; //Adhoc
			//public static String VersionID="16941"; //Release regression 72
    		//public static String cycleID="a8858a4b-5f60-46a8-941b-b52f32449f16"; //quotesubmission
    		//public static String cycleID="54e6df4f-8436-42c2-adff-028b5349969b"; //fulfillment
    		
    
	 
	//public static String prods[];
	 //public static String Plans[];
    public  String UiNewProductPlan = "",LRSelection = "",Day1="True",currentPlan="",AssistantSelection="";
	 
	 public  String TcmNo="",OrderStatus="";
    //Day2 Non-SAMI
    public static String futureGoLiveDate="false";
    public static String getSubProdName,liveSubProdStatus,liveSubGoLiveDate,liveSubEndDate,activeSublink;
    
	//Day3 Validations:
	    public  double BudgetToEnter=0;
	    public  String DupBusinessName="-",DupStreetAddress="-",DupCity="-",DupState="-",DupZipCode="-",DupBusinessPhone="-",DupListingsCategory="-";
	    public  String YextLeadAddress;	 	
	 	public  String ExistingProduct_1 = null, processtoProceedwith_1 = null, changeInProduct_1 = null,New_or_Modifying_ProductName_1 = null;
	 	public  String ListingsManagementAssetNumberfromproductHistoryAfterDay3,IncludedDomainWebsiteAssetNumberfromproductHistoryAfterDay3,PhotomotionVideoAssetNumberfromproductHistoryAfterDay3;
	 	public  String ListingsManagementAssetNumberfromliveproductAfterDay3,IncludedDomainWebsiteAssetNumberfromliveproductAfterDay3,PhotomotionVideoAssetNumberfromliveproductAfterDay3;
	 	public  String GoLiveDateforValidation,ProductHistoryEndDateforvalidation,Day3Amend,GoLiveDateforValidationDisplay,GoLiveDateforValidationSocial;
	 	public  String BudgetToEnterDay3,GoLiveDateforValidationSearch,monthlyInvestment_LiveproductsSearch,monthlyInvestment_productsHistoySearch;
	 	public  String monthlyInvestment_LiveproductsDisplay,monthlyInvestment_LiveproductsSocial,monthlyInvestment_productsHistoyDisplay,monthlyInvestment_productsHistoySocial;
	 	public  String DowngradeSamiValidations,GoLiveDateforValidationSearchDowngraded,GoLiveDateforValidationDisplayDowngraded,GoLiveDateforValidationSocialDowngraded;
	 	public  String GoLiveDateforValidationSearchDowngradedold,GoLiveDateforValidationDisplayDowngradedold,GoLiveDateforValidationSocialDowngradedold;
	 	public  String monthlyInvestment_LiveproductsSearchActiveDWN,monthlyInvestment_LiveproductsDisplayActiveDWN,monthlyInvestment_LiveproductsSocialActiveDWN;
	 	public  String day3ProductName=null,userDefinedBudget="False",Day3_Downgrade="False",Day3downgradepending,Day3downgradeActive;
	 	public  String Day3guaranteedclickvalidationliveproducts="False",Day3guaranteedclickvalidationproductsHistory="False";
	 	public  String GoLiveDateforValidationSearchclicks,monthlyInvestment_LiveproductsSearchclicks,enddateforvalidationSearchupsami,enddateforvalidationDisplayupsami,enddateforvalidationSocialupsami,endDateforValidationSearchclicks;
		
	 	public  String cancelDetails = "";
	 	
 	//Day 3 package validations
	 	
	 	public  String newProducttobeadded=null,Day3exectingPackageproductmovedtoproducthistory="False",Day3newproductPackageproductmovedtoliveproduct="False",Day3oldPackageproductstillinliveproduct="False",Day3exectingPackageproductEnddate="";
	 	public  String New_websiteproduct="",newwebsiteproductavaliableunderliveproducts="",oldwebsiteproductavaliableunderliveproducts="";
	 	//Day2Validations 	
		
		public  ArrayList<String> Productsavailableunderliveproducts=new ArrayList<String>();
		public ArrayList<String> ProductNameLiveproducts = new ArrayList<String>();
		public ArrayList<String> ProductNameProductHistory = new ArrayList<String>();
		
//Day2Validations 	
		
	 	public  ArrayList<String> productNameandproductsavailablewithActivestatus=new ArrayList<String>();
		public  ArrayList<String> productNametotalproductsavailableinlifeproductdetails=new ArrayList<String>();
	
	public String domainName="Not Applicable";
	public String ExpectedAlert="",CancelAndReplace="False",Day3="";
	public String testResults="",jiraCard="",BdgetAmount = "";
	public String DIGName="DIG-5859",TestCaseId,TestCaseSpecificView="",updateDuplicate="No",BillFulfill="",Others="",ExcelPath="";
	public String pdfDownload="No",contractDownload="No",signatureDownload="No",RepName="",QuoteDocumentDownload="";
	public String ActRes,ExpRes,Status,ImagePath,ImageName,ImgName,ActivitiExplorerLoginResult,CancelReason="Domain Issue",CancelType="Credit",CancelLineItemFlag="",CancelOutcome="None", cancelProcessType="";
	public String orderId="",TestCaseName="",DaywiseFolderpath,Consolidatedpath,whichDay="",Opportunity="None", TaxExempt="NO",StateName="",viewName="None",SviewName="",Budgetvalue="25",AssetNum,AlertMsg;
	public String opptyID, opptyName,businessName="", BusinessNAME,BusinessName="",BusinessID="",oldDomainName="",TotalMonUnitAmt,TotalMonDiscountAmt,ImageName1,ImgName1;
	public String TotalMonthlyAmt, OneTimeAmt,TestCaseNum;


	public String businessID="-";


	public String ProdsAdded="";


	public String defectNum;
	public String TaskName="DIG-5789",Jiracounter="",JiraStatus="",JiraDescription="",FSDValidation="",Taxvalidation="",State,AlertExists="",addOnValidate="";
	public String SFstatus="-",OHStatus="-",UpsertBeforeStatus="-",UpsertAfterStatus="-",SAPStatus="-",SiebelStatus="-",YextStatus="-",DUDAStatus="-";
	public Boolean isWebsite=false;
	public float budgetAmt;
	public String ghostWindow,OppurtunityWindow;
	public String CompanyPhoneNo="", DIADAcctNo="",GhostAcctNo="";
	public String VerifyCalculateAlert="",CancelAll="True",TSalesVerification, RepContactPhoneNo="",QuoteNumber="None",QuoteStatus="-",AddedProd="",TaxableStatus="", buisnessID="",contractNumber="", RemainingActions="",productName="none";
    public String DestinationPath = "",FinalPath="",DestinationPath2="",FinalPath2="",QuoteDocumentPath="";
	public int CaptureOrder=0;
	public ArrayList<String> QuoteLineItemNames=new ArrayList<String>();
	public WebDriver driver=null;
	public FileInputStream fs;
	public String[] lines ,Products,PlanNames;
	public String SelectOpptType="None",QuoteCreation="",Productcancellation="",ConfNoValidation="",ToggleDisc="",PhoneNumValidation="",PhoneNumEdit="",TZVerification="",NoApptError="";
	public String AuthorizationMethodFlag="",CreateOppertunity="",POSOnlyValidation="",ConfNumbDiffPhoneNo="",ConfNumbIncorrectAmt="",PDFChangesValidation="",BundlePriceOutputDoc="",ConfNumbforlessAmt="";
	public String system="",uniqueIssueId="",jiraNo="",ProductName,PlanName="",productPlan,OwnedProd="",IncBudget="",DecBudget="",BudgetLTMinBudget="",ROICalc="", ProductNameString="";
	public String  AddingSecondProd="",ContractDetailsValidtion="",cancelORGprod="";


	public String AccURL;


	public String opptyURL;


	public String ProductIdentifierName="";


	public String OpportunitysResults="";
	public String plansLabel="";
	public Properties Amounts;
	public String[] ProdName, Prods,plans;
	public String bugentOfDisplayProductasperHGCP,CreateQ,goLiveDateSubscriptions="", subscriptionsNumb="",prodNameSubscriptions="",statusSubscriptions="", OptionalType="OptionalSKU";
	public String ProductsName="",ProductsCode="",OptionalSKU="",ProductOptionName="",quoteUrl;
	public boolean FeatureCodeValidFlag=false, featureCodeVerificationSPE=false;
	public String PriceBooksCategory="", Product="",SalesRep = "",SelectOption="",FinalStatus="Pass";
	public String BillCheckBoxValue = "", FulfillCheckBoxValue = "", FeatureFieldValue = "",FeatureCodesValue = "";
	public int OptCount=0, count = 0 ;
	public String expectedFeatureCode = "", expBillChkBxStatus = "", expFulfillChkBxStatus = "",FeatureCodeRslt = "";
	public String subScriptionVerificationFlag="false", allProdName="", allProdInfo="", ghostId="";
	public String ConsultationOptionVerificationflag="", planNameConsultation="", MigrationStatus="";
	public List<String> quoteURLS;
	public String Summary="",Description="", productsCaptureHomePage="", subScriptionIDCapture="", activeProdDetails="", productHistoryDetails="";
	public String liveSubScriptionDetails="", goLiveDateDetails="", cancel100PercentStsfnGoLiveD="", liveSubEndDetails="";
	//**************************************************Validations**************************************************************************************
	
	public String ExpectedSubscriptionTerms,SearchProdFamilyRes,CloneLine="";
	
	//***************************************************************************************************************************************************
	public String VerifyLineItem="",VerifyQuickSaveAlert="";
	public String ObsoleteQuote="",ObsoleteQuoteValidation="False";
	public String User="",SalesRepType="",casestatusverification="", SelectConsultation="",AdditionalCondition="",SecondLoginRep="",SecondndQuoteCreation="",Orderstages="", Stage="", AccountType="",OpertunityType="Digital", OpportunityType="SingleOpportunity",OpportunityStage="",SelectProduct, SelectPlan;
	public String GenerateDocument="Contract", ValidateQuoteFlag="", ConsultationValidation="",AuthorizationMethodVerification="",NewQBtnQPageValidation="",CloneRelatedQPageValidation="",NewQBtnOppPageValidation="",NewQBtnAccPageValidation="";
	public String  OpportunityValidation="",MultipleOpportunity="",Productplanverification="",QuoteHeader="",CaptureSignatureValidation="",LoginAsRepName;
	public String OrderStageQuoteDetls="", OpptyNameQuoteDetls="",Cancellproduct="";
	public String TotalFinalOTFPrice="", TotalFinalMITPrice="", TotalFinalTaxPrice="",BundlePriceValidation="",BundlePriceValidationStatus="Failed",SearchProductFamily="",SearchProductFamilyResult="", captureMinBudget="";
	public String CaptureQuoteValue_VV="", CaptureOTFValue_VV="", CaptureMITValue_VV="", ProductPriceValidate="",SFInspectorPlugin="",SFPIParam="";
	public String DefaultOptionSignature="";
	
     public int ObsoleteQuoteCount=0, billingAnnDayInt;
     public int contractIteration=0,signatureIteration=0;
     public int pageLoadTime=40;
	
     public int rowCount;
     public int plansCount;
     public int  prodHistoryBeforeCancel=0, prodHistoryAfterCancel=0, activeProdCountBeforeCancel=0, ActiveProductsCount=0, productHistoryCount=0, prodHistoryCountBeforeCancel=0,
 			ActiveSubScrptCount = 0, liveSubscriptionCountBeforeCancel=0,activeProdCountAfterCancel=0, prodHistoryCountAfterCancel=0,
 					liveSubscriptionCountAfterCancel=0;
 	public String liveProductAllCount="", productHistoryAllCount="";
     
 	public String Capture_MITotal_Quoteline="",CaptureMITax_Quoteline="",CaptureOTFValue_Quteline="",CaptureOTFTax_Quteline="",OTFtotalPLUSOTFtaxcomp="",mitotalPLUSmitaxcomp="";


	public String PlaceOrderValidation="None",OrderPlacementResult="",EntrBdgtSave="",PackageProd="";
	
	//DIG-246
	
	//DIG 620
    
    public String goLivechange="",cancelExistingProduct="",cancelUpdatesfieldvaluesvalidation="",giveCancellationReason="",giveCancellationType="",giveCancellationOutcome="";

	
	//DIG 4269
		public String  budgetOfDisplayProductasperHGCP="",Display$149_248="",Display$249_498="",Userdefiedvalue="";
		public float userdefinepricefordisplay=0;
		
	//variable to add Second product
		
		public static ArrayList<String> Addproduct2=new ArrayList<String>();
		public ArrayList<String> Addplans2=new ArrayList<String>();
		
	//DIG 841
		public String cancelExisting_ADDnewProduct="";
	
		//DIG-243
		public String packageMonthlyAmtUnder="",checkproductsaredisplayedundergivenpricerange="";
		
		//DIG-2196
		public String ValidateTermFlag="", Term="", Term1="";
		
	public String contactnumber,emailID,companyname1,location1;
	public String allreadyUsedConfnumber="",PaymentWorkaround="False",PremiseRepVoiceVerify="";
	public String bugentOfSearchProductasperHGCP="",search$399_$898="",search$899_$2998="",search$2999_$9999="",searchabove$9999="",clicks_45="",clicks_60="",clicks_90="";
	public String Resultsfolderpath="";
	public String Cardnum="",fulfilmentExceptSami="",productNameforfullfilment="";
	public String SignType = "",LeadState="";
	
	
	  //public static String regardingfilesPath ="/usr/share/tomcat/bin/";
	   public String regardingfilesPath = "C://Automation//readingfiles//";//
		//public static String ZephyrPath=regardingfilesPath+"/OutputFiles/ZephyrResults";
		public  Properties loadPropertiesFiles(String propFile) {
			Properties p = new Properties();
		
			try {
					fs = new FileInputStream(regardingfilesPath+"InputFiles/"+ propFile +".properties");
					p.load(fs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			return p;
			
		}
		public  String createFolder(String folderpath)throws Exception{
			
			//DOMConfigurator.configure("log4j.xml");
			Properties Obj=loadPropertiesFiles("Object");
			Obj.load(fs);
			String foldertimeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			TestCaseName=folderpath+"_"+foldertimeStamp;
			Resultsfolderpath=regardingfilesPath+"OutputFiles/TestResults/"+TestCaseName;
			//Resultsfolderpath="C:\\Automation\\readingfiles\\OutputFiles\\TestResults\\"+folderpath+foldertimeStamp;
			File dir = new File(Resultsfolderpath);
		  	dir.mkdir();
			return Resultsfolderpath;
		}
	
		public String checkRowNumber() throws IOException, InterruptedException {
			
			LOGS.info("Executing checkRowNumber method");
			try{
					Properties RowNumber;
					RowNumber= new Properties();
					FileInputStream input = new FileInputStream(regardingfilesPath+"InputFiles/RowNumber.properties");
					RowNumber.load(input);		
					FileInputStream inputExcel = new FileInputStream(new File(regardingfilesPath+"InputFiles/GhostInputData.xlsx"));
					//Create Workbook instance holding reference to .xlsx file
			        XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
			      //Get first/desired sheet from the workbook
			        XSSFSheet inputsheet = workbook.getSheetAt(0);
			        int rowcount=inputsheet.getLastRowNum();
			        LOGS.info("Rows available in the Ghost Input Sheet : "+rowcount);
			        rowcount=rowcount+1;
			        int currentRow= Integer.parseInt(RowNumber.getProperty("currentRow"));
			        LOGS.info("Current Row value in RowNumber file : "+currentRow);
			        if(currentRow >=(rowcount))
					{
						LOGS.info("All the data is used, please feed in New Data" );
						return "Fail";
					}
			        else
			        {
			        	LOGS.info("Tests can be proceeded");
			        }
				
				}catch (Exception e) {
				
				LOGS.info("Some problem with the input sheet, Ps re-execute" );
				return "Fail";
			
				}
			return "Pass";
		}	
			
		
		public WebElement JLocator(String locator)
		{
		String obj = loadPropertiesFiles("JObject").getProperty(locator);
		WebElement element=null;
		excutor = (JavascriptExecutor)driver;
		element = (WebElement) excutor.executeScript("return "+obj);
		return element ;
		}
		
	
	/*public static void preparingOutputSheets() throws IOException, InterruptedException 
	{
		LOGS.info("Executing preparingOutputSheets method");
	try{
		Properties Daywise= new Properties();
		Date date=new Date();
		DateFormat DF=new SimpleDateFormat("MMMdd");
		String DaywiseDay1=DF.format(date);
		LOGS.info("Day1 date: "+DaywiseDay1);
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 2);
        String DaywiseDay3=DF.format(c.getTime());
        LOGS.info("Day3 date: "+DaywiseDay3);
        OutputStream fs = new FileOutputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
        Daywise.setProperty("Day1", DaywiseDay1);
		Daywise.setProperty("Day3", DaywiseDay3);
		//Daywise.setProperty("Taxable", "No" );
		Daywise.store(fs, null);
		fs.close();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
		Daywise.load(input);
		String Day1=Daywise.getProperty("Day1");
		 String Day2=Daywise.getProperty("Day2");
		 String Day3=Daywise.getProperty("Day3");
		LOGS.info("Copying Files to Ensure that the Report files are blank");
		//MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"\\Templates\\OHInputData.xlsx",System.getProperty("user.dir")+"//InputFiles//OHInputData.xlsx");
		//MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"/Templates/TestResult.xlsx","C:\\Automation\\OutputFiles\\TestResult.xlsx");
		//MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"/Templates/ZephyrTestResult.xlsx","C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx");
		MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"/Templates/TestResult.xlsx",Resultsfolderpath+"\\TestResult.xlsx");
		MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"/Templates/ZephyrTestResult.xlsx",Resultsfolderpath+"\\ZephyrTestResult.xlsx");
		File D1=new File(System.getProperty("user.dir")+"/OutputFiles/"+Day1+"ConsolidatedReport.xlsx");
	//	File D3=new File("C:\\Automation\\OutputFiles\\"+Day3+"ConsolidatedReport.xlsx");
		//if(D1.exists() && D3.exists())
		if(D1.exists())
		{
			LOGS.info("File already exists");
		}
		else
		{
			LOGS.info("Copying files from Templates to Output files");
			MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"/Templates/Day1ConsolidatedReport.xlsx",System.getProperty("user.dir")+"/OutputFiles/"+Day1+"ConsolidatedReport.xlsx");
			LOGS.info("Created Day1!!!");
			//MoveOrCopyFile.copyFunction(System.getProperty("user.dir")+"\\Templates\\Day3ConsolidatedReport.xlsx",System.getProperty("user.dir")+"\\OutputFiles\\"+Day3+"ConsolidatedReport.xlsx");
		}
			
			LOGS.info("Files copied successfully");
	}catch (Exception e) 
	{
		LOGS.info("There is some error while copying" );
	
	}
	File pdfFolder=new File("C:\\Automation\\CPQ\\pdf");
	File contractsFolder=new File("C:\\Automation\\CPQ\\pdf\\Contracts");
	File capturesignatureFolder=new File("C:\\Automation\\CPQ\\pdf\\CaptureSignature");
	File QuoteDocumentFolder=new File("C:\\Automation\\CPQ\\pdf\\QuoteDocument");
	
	if(pdfFolder.exists())
	{
		LOGS.info("pdf folder exists");
	}
	else
	{
		pdfFolder.mkdir();
	}
	if(contractsFolder.exists())
	{
		LOGS.info("contractsFolder folder exists");
	}
	else
	{
		contractsFolder.mkdir();
	}
	if(capturesignatureFolder.exists())
	{
		LOGS.info("capturesignatureFolder folder exists");
	}
	else
	{
		capturesignatureFolder.mkdir();
	}
	if(QuoteDocumentFolder.exists())
	{
		LOGS.info("QuoteDocument Folder exists");
	}
	else
	{
		QuoteDocumentFolder.mkdir();
	}
	}*/
		public  void preparingOutputSheets() throws IOException, InterruptedException 
		{
			LOGS.info("Executing preparingOutputSheets method");
		try{
			/*Properties Daywise= new Properties();
			Date date=new Date();
			DateFormat DF=new SimpleDateFormat("MMMdd");
			String DaywiseDay1=DF.format(date);
			LOGS.info("Day1 date: "+DaywiseDay1);
			Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, 2);
	        String DaywiseDay3=DF.format(c.getTime());
	        LOGS.info("Day3 date: "+DaywiseDay3);
	        OutputStream fs = new FileOutputStream(regardingfilesPath)+"//InputFiles//Daywise.properties");
	        Daywise.setProperty("Day1", DaywiseDay1);
			Daywise.setProperty("Day3", DaywiseDay3);
			//Daywise.setProperty("Taxable", "No" );
			Daywise.store(fs, null);
			fs.close();
			FileInputStream input = new FileInputStream(regardingfilesPath)+"//InputFiles//Daywise.properties");
			Daywise.load(input);
			String Day1=Daywise.getProperty("Day1");
			 String Day2=Daywise.getProperty("Day2");
			 String Day3=Daywise.getProperty("Day3");*/
			LOGS.info("Copying Files to Ensure that the Report files are blank");
			//MoveOrCopyFile.copyFunction(regardingfilesPath)+"\\Templates\\OHInputData.xlsx",regardingfilesPath)+"//InputFiles//OHInputData.xlsx");
			//MoveOrCopyFile.copyFunction(regardingfilesPath)+"/Templates/TestResult.xlsx",regardingfilesPath+"OutputFiles\\TestResult.xlsx");
			//MoveOrCopyFile.copyFunction(regardingfilesPath)+"/Templates/ZephyrTestResult.xlsx",regardingfilesPath+"OutputFiles\\ZephyrTestResult.xlsx");
			//MoveOrCopyFile.copyFunction(regardingfilesPath)+"/Templates/TestResult.xlsx",Resultsfolderpath+"\\TestResult.xlsx");
			//MoveOrCopyFile.copyFunction(regardingfilesPath+"Templates/TestResult.xlsx",Resultsfolderpath+"/TestResult.xlsx");
			MoveOrCopyFile.copyFunction(regardingfilesPath+"Templates/ZephyrTestResult.xlsx",Resultsfolderpath+"/ZephyrTestResult.xlsx");
			/*File D1=new File(regardingfilesPath)+"/OutputFiles/"+Day1+"ConsolidatedReport.xlsx");
			//File D3=new File(regardingfilesPath+"OutputFiles\\"+Day3+"ConsolidatedReport.xlsx");
			//if(D1.exists() && D3.exists())
			if(D1.exists())
			{
				LOGS.info("File already exists");
			}
			else
			{
				LOGS.info("Copying files from Templates to Output files");
				MoveOrCopyFile.copyFunction(regardingfilesPath)+"/Templates/Day1ConsolidatedReport.xlsx",regardingfilesPath)+"/OutputFiles/"+Day1+"ConsolidatedReport.xlsx");
				LOGS.info("Created Day1!!!");
				//MoveOrCopyFile.copyFunction(regardingfilesPath)+"\\Templates\\Day3ConsolidatedReport.xlsx",regardingfilesPath)+"\\OutputFiles\\"+Day3+"ConsolidatedReport.xlsx");
			}*/
				
				//LOGS.info("Files copied successfully");
		}catch (Exception e) 
		{
			LOGS.info("There is some error while copying" );
			count=count+1;
		
		}
		/*File pdfFolder=new File(regardingfilesPath+"CPQ\\pdf");
		File contractsFolder=new File(regardingfilesPath+"CPQ\\pdf\\Contracts");
		File capturesignatureFolder=new File(regardingfilesPath+"CPQ\\pdf\\CaptureSignature");
		File QuoteDocumentFolder=new File(regardingfilesPath+"CPQ\\pdf\\QuoteDocument");
		
		if(pdfFolder.exists())
		{
			LOGS.info("pdf folder exists");
		}
		else
		{
			pdfFolder.mkdir();
		}
		if(contractsFolder.exists())
		{
			LOGS.info("contractsFolder folder exists");
		}
		else
		{
			contractsFolder.mkdir();
		}
		if(capturesignatureFolder.exists())
		{
			LOGS.info("capturesignatureFolder folder exists");
		}
		else
		{
			capturesignatureFolder.mkdir();
		}
		if(QuoteDocumentFolder.exists())
		{
			LOGS.info("QuoteDocument Folder exists");
		}
		else
		{
			QuoteDocumentFolder.mkdir();
		}*/
	}
	
	public  WebElement Locator(String locator){
		
		String[] locatortype=loadPropertiesFiles("Object").getProperty(locator).split(">");
		String ortype=locatortype[0];
		String obj=locatortype[1];
		WebElement element=null;
		if(ortype.equalsIgnoreCase("NAME"))
		{
			element=driver.findElement(By.name(obj));
		}
		if(ortype.equalsIgnoreCase("ID"))
		{
			element=driver.findElement(By.id(obj));
		}
		if(ortype.equalsIgnoreCase("XPATH"))
		{
			element=driver.findElement(By.xpath(obj));
		}
		if(ortype.equalsIgnoreCase("CSS"))
		{
			element=driver.findElement(By.cssSelector(obj));
		}
		if(ortype.equalsIgnoreCase("LINKTEST"))
		{
			element=driver.findElement(By.linkText(obj));
		}
				
		return element ;
		
	}
	
	public String FetchSamiProductplan(String ProductIdentifierName) throws Exception{
		LOGS.info("FetchProductplan method Started "+ProductIdentifierName);
		
			//Fetching the data from CPQProductPlanInput file based on the testcasenumber
			FileInputStream inputExcel = new FileInputStream(new File(System.getProperty("user.dir")+"//InputFiles//CPQProductPlanInput.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
	        XSSFSheet inputsheet = workbook.getSheetAt(0);	
	        int rowCount=inputsheet.getLastRowNum();
	        LOGS.info("rowCount ="+ rowCount);
	      for(int i=1;i<=rowCount;i++)
	      {
		        LOGS.info("inside =");

	        Row row=inputsheet.getRow(i);
	        //.getCell(i).getStringCellValue().trim();
	        
	        Cell cell=row.getCell(0);
			String cellValue=cell.getStringCellValue();
			LOGS.info("Cell Value is: "+cellValue);
			
	        try{
	        	if(Cancellproduct.equalsIgnoreCase("True")){
	        		//if( inputRow.getCell(0).getStringCellValue().trim().equalsIgnoreCase(ProductIdentifierName)){
	        		if(cellValue.equalsIgnoreCase(ProductIdentifierName)) 	
	   	        	 ProductName=row.getCell(3).getStringCellValue().trim();
	   	        	LOGS.info("ProductName   ---->"+ ProductName);
	   	        	PlanName=row.getCell(4).getStringCellValue().trim();
	   		        	LOGS.info("PlanName   ---->"+ PlanName);
	   		        	productPlan=ProductName+"&"+PlanName;
	   		        	productPlan=ProductName+"#"+PlanName;
	   		        	LOGS.info("productPlan   ---->"+ productPlan);	        
	   	        }	        		
	        	
	        	else if(cellValue.equalsIgnoreCase(ProductIdentifierName)) {	

	        	
		        	LOGS.info("searching productname ");

	        	 ProductName=row.getCell(1).getStringCellValue().trim();
	        	LOGS.info("ProductName   ---->"+ ProductName);
	        	PlanName=row.getCell(2).getStringCellValue().trim();
		        	LOGS.info("PlanName   ---->"+ PlanName);
		        	//productPlan=ProductName+"&"+PlanName;
		        	productPlan=ProductName+"#"+PlanName;
		        	LOGS.info("productPlan   ---->"+ productPlan);
		        	jiraNo=row.getCell(6).getStringCellValue().trim();
		        	LOGS.info("Jira Id   ---->"+ jiraNo);
		        	uniqueIssueId=row.getCell(7).getStringCellValue().trim();
		        	LOGS.info("Issue Id   ---->"+ uniqueIssueId);
		        	system=row.getCell(5).getStringCellValue().trim();
		        	LOGS.info("system FF   ---->"+ system);
	        }
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	LOGS.info("testcase numbrer not matced ");
	        }
	      }
		
		
		return productPlan;
	}
	
	
	public String FetchProductplan(String ProductIdentifierName) throws Exception{
		LOGS.info("FetchProductplan method Started "+ProductIdentifierName);
		
			//Fetching the data from CPQProductPlanInput file based on the testcasenumber
			FileInputStream inputExcel = new FileInputStream(new File(System.getProperty("user.dir")+"//InputFiles//CPQProductPlanInput.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
	        XSSFSheet inputsheet = workbook.getSheetAt(0);	
	        int rowCount=inputsheet.getLastRowNum();
	        LOGS.info("rowCount ="+ rowCount);
	      for(int i=1;i<=rowCount;i++)
	      {
		        LOGS.info("inside =");

	        Row row=inputsheet.getRow(i);
	        //.getCell(i).getStringCellValue().trim();
	        
	        Cell cell=row.getCell(0);
			String cellValue=cell.getStringCellValue();
			LOGS.info("Cell Value is: "+cellValue);
			
	        try{
	        	if(Cancellproduct.equalsIgnoreCase("True")){
	        		//if( inputRow.getCell(0).getStringCellValue().trim().equalsIgnoreCase(ProductIdentifierName)){
	        		if(cellValue.equalsIgnoreCase(ProductIdentifierName)) 	
	   	        	 ProductName=row.getCell(3).getStringCellValue().trim();
	   	        	LOGS.info("ProductName   ---->"+ ProductName);
	   	        	PlanName=row.getCell(4).getStringCellValue().trim();
	   		        	LOGS.info("PlanName   ---->"+ PlanName);
	   		        	//productPlan=ProductName+"&"+PlanName;
	   		        	productPlan=ProductName+"#"+PlanName;
	   		        	LOGS.info("productPlan   ---->"+ productPlan);	        
	   	        }	        		
	        	
	        	else if(cellValue.equalsIgnoreCase(ProductIdentifierName)) {	

	        	
		        	LOGS.info("searching productname ");

	        	 ProductName=row.getCell(1).getStringCellValue().trim();
	        	LOGS.info("ProductName   ---->"+ ProductName);
	        	PlanName=row.getCell(2).getStringCellValue().trim();
		        	LOGS.info("PlanName   ---->"+ PlanName);
		        	//productPlan=ProductName+"&"+PlanName;
		        	productPlan=ProductName+"#"+PlanName;
		        	LOGS.info("productPlan   ---->"+ productPlan);
/*		        	uniqueIssueId=row.getCell(4).getStringCellValue().trim();
		        	LOGS.info("Issue Id   ---->"+ uniqueIssueId);*/
	        }
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	LOGS.info("testcase numbrer not matced ");
	        }
	      }
		
		
		return productPlan;
		
	}
	
	
	public String FetchData( ) throws Exception{
		LOGS.info("FetchProductplan method Started ");
		
			//Fetching the data from CPQProductPlanInput file based on the testcasenumber
			FileInputStream inputExcel = new FileInputStream(new File(System.getProperty("user.dir")+"//InputFiles//CPQInputSheet.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputExcel);
	        XSSFSheet inputsheet = workbook.getSheetAt(0);	
	         rowCount=inputsheet.getLastRowNum();
	        LOGS.info("rowCount ="+ rowCount);
	      //for(int i=1;i<=inputsheet.getLastRowNum();i++)
			for (int i = 1; i <rowCount; i++)
	      {
	        Row inputRow=inputsheet.getRow(i);
	        /*inputRow.getCell(i).getStringCellValue().trim();
 	        LOGS.info("SalesRepType is :"+inputRow.getCell(i).getStringCellValue().trim());*/

	        try{
	        	
	         if( inputRow.getCell(2).getStringCellValue().trim().equalsIgnoreCase("Yes")){
		       
	 	        LOGS.info("Flag setup done as yes");
	        	 SalesRepType=inputRow.getCell(3).getStringCellValue().trim();
		 	        LOGS.info("SalesRepType is :"+SalesRepType);

	        	 ProductName=inputRow.getCell(0).getStringCellValue().trim();
	        	LOGS.info("ProductName   ---->"+ ProductName);
	        	PlanName=inputRow.getCell(1).getStringCellValue().trim();
		        	LOGS.info("PlanName   ---->"+ PlanName);
		        //productPlan=ProductName+"&"+PlanName;
		        	productPlan=ProductName+"#"+PlanName;
		        	LOGS.info("productPlan   ---->"+ productPlan);
		        	rowCount= rowCount+1;		         
			      }
	         else{
	 	        LOGS.info("Flag need to set");

	         }
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	LOGS.info("SalesRepType type not found ");
	        }
	      }
		
		
		return productPlan;
		
	}
	
public  WebElement SLocator(String slocator){
		
		LOGS.info("Executing the SLocator");
			String[] locatortype=loadPropertiesFiles("SObject").getProperty(slocator).split(">");
			String ortype=locatortype[0];
			String obj=locatortype[1];
			WebElement element=null;
			if(ortype.equalsIgnoreCase("NAME"))
			{
				element=driver.findElement(By.name(obj));
			}
			if(ortype.equalsIgnoreCase("ID"))
			{
				element=driver.findElement(By.id(obj));
			}
			if(ortype.equalsIgnoreCase("XPATH"))
			{
				element=driver.findElement(By.xpath(obj));
			}
			if(ortype.equalsIgnoreCase("CSS"))
			{
				element=driver.findElement(By.cssSelector(obj));
			}
			if(ortype.equalsIgnoreCase("LINKTEST"))
			{
				element=driver.findElement(By.linkText(obj));
			}
					
			return element ;
			
		}
public  WebElement SLocatorDynamic(String dynamicObj){
	
		LOGS.info("Executing the SLocator");
		String params[]=dynamicObj.split("_");
		LOGS.info("The Dynamic Objects added are :"+params);
		String obj=loadPropertiesFiles("SObject").getProperty(params[0])+"'"+params[1]+"'"+loadPropertiesFiles("SObject").getProperty(params[2]);
		LOGS.info("Params[0] :"+loadPropertiesFiles("SObject").getProperty(params[0]));
		LOGS.info("Obj is :"+obj);
		WebElement element=null;
		
		{
			element=driver.findElement(By.xpath(obj));
		}
			
		return element ;
		
	}
	public String PublishgetInput(String folderName) throws Exception {
		String OrderID = "";
		LOGS.info("Executing getInput Keyword for fetching OrderID Started");
		try {
				return orderId;
							
			}
		 catch (Exception t) {
		    	t.printStackTrace();
		         
		}
		
		LOGS.info("Executing getInput Keyword Complete");
	 
	  return orderId;
	}
	
	public String day3FetchData(String foldername) throws Exception{
		
		try
		{
				Properties Daywise= new Properties();
				FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//InputFiles//Daywise.properties");
				Daywise.load(input);
				DaywiseFolderpath="C:\\Automation\\OutputFiles\\"+Daywise.getProperty("Day1")+"ConsolidatedReport.xlsx";	
				String excelPath=DaywiseFolderpath;
				
				LOGS.info("Excel path :" + excelPath);
				FileInputStream fileInput = new FileInputStream(excelPath);
				XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
				XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
				int rowCount=finalSheet.getLastRowNum();
				LOGS.info(rowCount);
				for (int i = 1; i <= rowCount; i++)
				{
					Row row=finalSheet.getRow(i);
								
					LOGS.info("Checking if Day1 date is set and OH Status is Pass");	
								
									
						if(((row.getCell(6).getStringCellValue()).trim()).equals(TestCaseName))
						{
							LOGS.info("Iteration started");
							{
								//oldOrderId=(row.getCell(0).getStringCellValue()).trim();
								BusinessName=(row.getCell(3).getStringCellValue()).trim();
								BusinessID=(row.getCell(1).getStringCellValue()).trim();
								oldDomainName=(row.getCell(4).getStringCellValue()).trim();
									
									LOGS.info("Account Name :"+ BusinessName);
								//	ExportResults.exportTestResult("Account Name fetching,"+"Äccount for Fullfimment should be avaiable" +","+BusinessName+" is available,"+"Pass"+","+"No Image");
									LOGS.info("Account,"+"Äccount for Fullfimment should be avaiable" +","+BusinessName+" is available,"+"Pass");
								//	ExportResults.exportTestResult("Business ID fetching,"+"Business ID for Fullfimment should be avaiable" +","+BusinessID+" is available,"+"Pass"+","+"No Image");
									LOGS.info("Business ID,"+"Business ID for Fullfimment should be avaiable" +","+BusinessID+" is available,"+"Pass");
									return "Pass";
									
							}
						}
									
					}
					
					fileInput.close();
			}
				
			 catch (Exception t) {
			    	t.printStackTrace();
			         
			}
			
			LOGS.info("Executing getInput Keyword Complete");
		 
		  return "Pass";
		 
		}
	
	
	
	public String day3FetchBusinessIdData(String foldername) throws Exception{
		//int rowcount=0;
		//String excelPath="C:\\Automation\\OutputFiles\\PlanwiseResults\\"+foldername+"\\ConsolidatedReport.xlsx";
		String excelPath = foldername;
		System.out.println("Excel path :" + excelPath);
		String businessId="No BusinessID available";
		FileInputStream fileInput = new FileInputStream(excelPath);
		Workbook finalWorkbook = new XSSFWorkbook(fileInput);
		Sheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++)
		{
			Row row=finalSheet.getRow(i);
			//Row row1=finalSheet.getRow(i);
			System.out.println("row no and value: "+finalSheet.getRow(i)+":"+row.getCell(12));
		
			//if(!((row.getCell(23).getStringCellValue()).trim()).equals("-")||(!(row.getCell(23).getStringCellValue().trim()).contains("Fail")))
			//{	
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				final Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,-1);
				String yesterday=dateFormat.format(cal.getTime()).trim();
				LOGS.info("Yesterday Date :"+yesterday);
				String yesterdayExcel = row.getCell(12).getStringCellValue().trim();
				LOGS.info("Day2's Date :"+yesterdayExcel);
				//{
					businessId=(row.getCell(1).getStringCellValue()).trim();
					System.out.println("BusinessId :"+ businessId);
					TestCaseNum=(row.getCell(14).getStringCellValue()).trim();
					System.out.println("ziracard :"+ TestCaseNum);


				//	return businessId+">"+TestCaseNum;
					
	
			
		}
		return businessId+">"+TestCaseNum;
	
	}

	
public String verifyPDFContent(String FilePath,String reqTextInPDF) throws Exception{
		
		
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
				
			File file = new File(FilePath);
			PDFParser parser = new PDFParser(new FileInputStream(file));
			
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(2);
			
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		
	        lines = parsedText.split(System.getProperty("line.separator"));
	        System.out.println(lines[getLineNumberWithFilter(reqTextInPDF)]);
	        cosDoc.close();
			
			
		} catch (Exception e2) {
			System.err.println("Data Not found in PDF "+e2.getMessage());
		}
		
		return lines[getLineNumberWithFilter(reqTextInPDF)];
		
}
	public int getLineNumberWithFilter(String filter) {
	    int n = 0;
	    for(String line : lines) {
	        if(line.indexOf(filter) != -1) {
	            return n;
	        }
	        n++;
	    }
	    return -1;
	}	

	
	public  String businessIDInputSheet(String fileName, String worksheetName) throws Exception {
		String businessIDInputSheet="", buisnessID1="";
		Status="Pass";
		
			
		try
		{
			//SFInspectorPlugin="True";
			 st = new SalesforceTasks();
			st.SalesforceLogin("sfAdminUserNameSPE", "sfAdminPswd");
			LOGS.info("SF Login Sucessfull");			
		}
		catch(Exception e)
		{
			LOGS.info("Error in SF Login");
			Status="Fail";
		}
			
		try {
			if(!Status.equalsIgnoreCase("Fail")) {
				SalesforceTasks.Xls_Reader("C:\\Automation\\CPQProdID\\CPQMainBranchProdID\\Framework\\InputFiles\\"+fileName+".xlsx"); //to set path of excel (excel file path)
				int excelRowCount=SalesforceTasks.getRowCount(worksheetName); //to get row count (sheetName)
				LOGS.info(excelRowCount);	
			
				for(int i=2;i<=excelRowCount;i++ ){
			
					businessIDInputSheet=SalesforceTasks.getCellData(worksheetName,"Business ID",i);
					LOGS.info("Cancelled order Business ID from InputSheet "+ businessIDInputSheet);
					businessID=businessIDInputSheet;
					driver.findElement(By.xpath("//input[@id='phSearchInput']")).sendKeys(businessIDInputSheet);
					driver.findElement(By.xpath("//input[@id='phSearchButton']")).click();
					buisnessID1=businessIDInputSheet;
					Thread.sleep(5000);
				 
					driver.findElement(By.xpath("//td[text()='"+buisnessID1+"']//parent::tr//th/a")).click();
					LOGS.info("Clicking on Account Link");
					Thread.sleep(3000);
				
					driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					Thread.sleep(3000);
				
				}
				
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Status="Fail";
		}
		
		return Status;
	}
	
}