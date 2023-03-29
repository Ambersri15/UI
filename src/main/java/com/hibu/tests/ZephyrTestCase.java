package com.hibu.tests;


import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

import sun.misc.BASE64Encoder;

public class ZephyrTestCase extends PreRequisites{
	
	public static Logger LOGS = LogManager.getLogger(ZephyrTestCase.class.getName());
	
	
	
		private static String API_CREATE_TEST = "{SERVER}/rest/api/2/issue/TPP-8848";
		private static String API_CREATE_TEST_STEP = "{SERVER}/public/rest/api/1.0/teststep/";
		private static String jiraBaseURL = "https://hibu-us.atlassian.net";
		static String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
		
	// Radhika's cred	
		
		 static String accessKey = "amlyYTplMWFkNzQ1NC0yNTA0LTQ3MGMtOTFlMi0xMTE3MzA0YzcyMzggNTU3MDU4JTNBMDE2ZTg2NTUtMTU4OC00ZjE0LTg5MjEtYTkwMWU0OGM3MjA3IFVTRVJfREVGQVVMVF9OQU1F";
		 static String secretKey = "67Gl5OTshyQc-do-e94RDQXXFtO0vUQ__GKTrPh5Js8";
		final static String createTestUri = API_CREATE_TEST.replace("{SERVER}", jiraBaseURL);
		final static String createTestStepUri = API_CREATE_TEST_STEP.replace("{SERVER}", zephyrBaseUrl);
		static ArrayList<String> StepId =null;
		static ArrayList<String> StepResultId =null;
		static String overallStatus="Pass";
		//static String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		//public  String excelPath=regardingfilesPath+"OutputFiles/ZephyrTestResult.xlsx";
		//public String excelpath=Resultsfolderpath+"/ZephyrTestResult.xlsx"
		public String excelPath=Resultsfolderpath+"/ZephyrTestResult.xlsx";
		
		
		
		//** Declare parameter values here *//*
		
		static String userName = "radhika.madhi@hibu.com";
		static String accountId = "557058:016e8655-1588-4f14-8921-a901e48c7207";
		static String password = "mImGN6QG8t8DvqUlcxzt7E5B";
		//static String projectId = "10512"; //Project id for TPP
		static String projectId = "15218";  //project id for TCM
		public static String ExecutionId="";//quote submission
		static String releaseID=""; //release 69
		

		static ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
				.build();
		static JwtGenerator jwtGenerator = client.getJwtGenerator();
		
	public static String generateToken(String apiType, String url) throws Exception
	{
		String jwt="";
		try
		{
			URI uri = new URI(url);
			int expirationInSec = 360;
			jwt = jwtGenerator.generateJWT(apiType, uri, expirationInSec);
			LOGS.info(uri.toString());
			LOGS.info("jwt::"+jwt);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LOGS.info("Unable to Generate the Token Number");
			
		}
		return jwt;
	}
	
	
	public static void updateFolder() throws Exception{
		LOGS.info("Executng update folder Method");
		String finalURL ="https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/folder/a0bb68d1-34dd-4b5f-9513-a5a55ec6a82d";
		String jwt = generateToken("PUT", finalURL);
		LOGS.info("jwt::"+jwt);
		Client postRestClient = Client.create();
		//
		//TestCaseId="130519";
			
			/*
			String jsonDsata="{\"projectId\":\"10512\","
	    	           + "\"versionId\":\""+VersionID+"\","+"\"schedulesList\":\"[3,4,5,6]\","
	    		        +"}";*/
			String jsonData= "{\"name\":\"Hema\","
					+"\"projectId\":\""+projectId+"\","
	    	        +" \"cycleId\":\""+cycleID+"\","
	    	        + "\"versionId\":\""+VersionID+"\""
	        +"}";
			
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
	 								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
			 }
	
	public  void createCycles() throws Exception
	{
		LOGS.info("Executng createCycles method");
		Long projectId = 10512l;
		Long versionId = -1l;
		String cycleName = "QA Regression- CPQ";
		String cycleDescription = "Created by ZAPI CLOUD API";
		
		String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/cycle";
		
	//String finalURL = createTestStepUri + testId + "?projectId=" + projectId;
		URI uri = new URI(createCycleUri);
		int expirationInSec = 360;
	//	JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		LOGS.info(uri.toString());
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
			
			String cycleData= "{\"name\":\""+cycleName+"\","
	    	        + "\"description\":\""+cycleDescription+"\","
	    	        + "\"startDate\":\""+System.currentTimeMillis()+"\","
	    	        + "\"projectId\":\""+ZephyrTestCase.projectId+"\","
	    	        + "\"versionId\":\""+VersionID+"\""
	    	        +"}";
			LOGS.info("finalURL::"+createCycleUri);
		    WebResource postWebResource = postRestClient.resource(createCycleUri);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,cycleData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
		
			String JsonString=myResponse.getEntity(String.class);
			LOGS.info(JsonString);
			String jsonSplit[]=JsonString.split("\"id\":");
			String[] jsonSplit2 =jsonSplit[1].split(",");
			LOGS.info(jsonSplit2[0].replace("\"", ""));
			cycleID=jsonSplit2[0].replace("\"", "");
			String addTestsUri = zephyrBaseUrl + "/public/rest/api/1.0/executions/add/cycle/" + cycleID;
			String issueIds = TestCaseId;
			
			String cycleTestData= "{\"issues\":\""+issueIds+"\","
	    	        + "\"method\":\""+"1"+"\","
	    	        + "\"projectId\":\""+projectId+"\","
	    	        + "\"versionId\":\""+VersionID+"\""
	    	        +"}";
			LOGS.info("finalURL::"+addTestsUri);
			URI uri2 = new URI(addTestsUri);
			String jwt2 = jwtGenerator.generateJWT("POST", uri2, expirationInSec);
			LOGS.info(uri2.toString());
			LOGS.info("jwt::"+jwt2);
			
		    WebResource postWebResource2 = postRestClient.resource(addTestsUri);
		    ClientResponse myResponse2 = postWebResource2.type("application/json")
     								   .header("Authorization", jwt2)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,cycleTestData);
			LOGS.info("status: " + myResponse2.getStatus());
			LOGS.info("headers: " + myResponse2.getHeaders());
		
			releaseID=myResponse2.getEntity(String.class);
			LOGS.info("Release ID : "+releaseID);
	

	}
	
	public static void createFolder() throws Exception
	{
		
		
		/*String cycleName = "QA";
		//String cycleDescription = "Created by ZAPI CLOUD API";
		
		String createCycleUri = zephyrBaseUrl + "/public/rest/api/1.0/folder";
		//https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/folder
		URI uri = new URI(createCycleUri);
		int expirationInSec = 360;
	//	JwtGenerator jwtGenerator = client.getJwtGenerator();
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		LOGS.info(uri.toString());
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
			
			String cycleData= "{\"name\":\""+cycleName+"\","
	    	       // + "\"description\":\""+cycleDescription+"\","
	    	       // + "\"startDate\":\""+System.currentTimeMillis()+"\","
	    	        + "\"projectId\":\""+ZephyrTestCase.projectId+"\","
	    	         + "\"versionId\":\""+VersionID+"\","
	    	        + "\"cycleId\":\""+cycleID+"\""
	    	        +"}";
			LOGS.info("finalURL::"+createCycleUri);
		    WebResource postWebResource = postRestClient.resource(createCycleUri);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,cycleData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
		
			String JsonString=myResponse.getEntity(String.class);
			LOGS.info(JsonString);*/
		
		int expirationInSec = 360;
		
		String addTestsUri = zephyrBaseUrl + "/public/rest/api/1.0/executions/add/folder/a0bb68d1-34dd-4b5f-9513-a5a55ec6a82d";
		String issueIds = "135458";
		
		String cycleTestData= "{\"issues\":\""+issueIds+"\","
    	        + "\"method\":\""+"1"+"\","
    	        + "\"projectId\":\""+projectId+"\","
    	         + "\"versionId\":\""+VersionID+"\","
    	        + "\"cycleId\":\""+cycleID+"\""
    	        +"}";
		LOGS.info("finalURL::"+addTestsUri);
		URI uri2 = new URI(addTestsUri);
		String jwt2 = jwtGenerator.generateJWT("POST", uri2, expirationInSec);
		LOGS.info(uri2.toString());
		LOGS.info("jwt::"+jwt2);
		Client postRestClient = Client.create();
		
	    WebResource postWebResource2 = postRestClient.resource(addTestsUri);
	    ClientResponse myResponse2 = postWebResource2.type("application/json")
 								   .header("Authorization", jwt2)
	  								.header("zapiAccessKey",accessKey)
	  								.post(ClientResponse.class,cycleTestData);
		LOGS.info("status: " + myResponse2.getStatus());
		LOGS.info("headers: " + myResponse2.getHeaders());
	
		releaseID=myResponse2.getEntity(String.class);
		LOGS.info("Release ID : "+releaseID);
		
		
		
		
		/*LOGS.info("Executing create Folders method");
		//Long projectId = 10512l;
		//Long versionId = -1l;
		String folderName = "CPQ";
		String folderDescription = "Create Folder";
		
		String createFolderURI = zephyrBaseUrl + "/public/rest/api/1.0/folder";

		URI uri = new URI(createFolderURI);
		int expirationInSec = 360;
		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		LOGS.info(uri.toString());
		LOGS.info("jwt::"+jwt);

		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
			
			String folderData= "{\"name\":\""+folderName+"\","
	    	        + "\"description\":\""+folderDescription+"\","
	    	        +" \"cycleId\":\""+cycleID+"\","
	    	        + "\"projectId\":\""+projectId+"\","
	    	        + "\"versionId\":\""+VersionID+"\""
	    	        +"}";
			LOGS.info("Folder finalURL::"+createFolderURI);
		    WebResource postWebResource = postRestClient.resource(createFolderURI);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,folderData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
		
			String folderResponse=myResponse.getEntity(String.class);
			LOGS.info("Output : "+folderResponse);*/
			
	

	}
	
	public static void getCycleIDs() throws Exception
	{
		
		LOGS.info("Executng get cycle method");
		String finalURL ="https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/cycles/search?versionId=16929&projectId=15218";
		String jwt = generateToken("GET", finalURL);
		LOGS.info("jwt::"+jwt);
		LOGS.info("finalURL::"+finalURL);
		
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(finalURL);
		ClientResponse myResponse =webResource.accept("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.get(ClientResponse.class);
		LOGS.info("status: " + myResponse.getStatus());
		LOGS.info("headers: " + myResponse.getHeaders());
		String StepResponse=myResponse.getEntity(String.class);
		LOGS.info("Output: "+StepResponse);
			
}
	
	public static void getListofFolderIds() throws Exception
	{
		
		LOGS.info("Executng get Folders method");
		String finalURL ="https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/folders?versionId=16852&cycleId=ba8fd363-9fb8-4595-8642-83d038b74daf&projectId=15218";
		//"https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/folders?versionId=16850&cycleId=8cb7da37-c390-40c5-9282-6f171a7bcfbc&projectId=15218"
		//"https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/folders?versionId=16851&cycleId=19f7a861-5927-4b39-8d8d-f60a5bd8d7c3&projectId=15218"
		
		
		String jwt = generateToken("GET", finalURL);
		LOGS.info("jwt::"+jwt);
		LOGS.info("finalURL::"+finalURL);
		
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(finalURL);
		ClientResponse myResponse =webResource.accept("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.get(ClientResponse.class);
		LOGS.info("status: " + myResponse.getStatus());
		LOGS.info("headers: " + myResponse.getHeaders());
		String StepResponse=myResponse.getEntity(String.class);
		LOGS.info("Output: "+StepResponse);
			
}
	

	public  void createTestStep(String testId, String excelPath) throws Exception
	{
		
		LOGS.info("Executng creatTeststep method");
		LOGS.info("ExcelPath inside createTestStep: "+excelPath);
		StepId=new ArrayList<String>();
		String finalURL = createTestStepUri + testId + "?projectId=" + projectId;
		String jwt = generateToken("POST", finalURL);
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		String Step,Data,Result;
		for (int i = 1; i <= rowCount; i++)
		{
			Row row=finalSheet.getRow(i);
			Step=(row.getCell(0).getStringCellValue()).trim();
			Data=(row.getCell(1).getStringCellValue()).trim();
			Result=(row.getCell(2).getStringCellValue()).trim();
			String jsonData= "{\"step\":\""+Step+"\","
/*	    	        + "\"data\":\""+URLEncoder.encode(Data, "UTF-8")+"\","
	    	        + "\"result\":\""+URLEncoder.encode(Result, "UTF-8")+"\""*/
	    	       + "\"data\":\""+Data+"\""
	    	        +"}";
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
			 StepResponse=StepResponse.replace("\"", "");
			 StepResponse=StepResponse.replace("{", "");
			 StepResponse=StepResponse.replace(",", ":");
		        String[] outputSplit=StepResponse.split(":");
		       String stepId=outputSplit[1].trim();
		       StepId.add(stepId);
		}

	}
	
	
	public void updateTestStep(String testId) throws Exception
	{	
		LOGS.info("Executng updateTeststeps method");
		
		/*String finalURL = createTestStepUri + testId + "?projectId=" + projectId;
		String jwt = generateToken("POST", finalURL);
		LOGS.info("jwt::"+jwt);*/
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		String Step,Data,Result;
		int j=0;
		for (int i = 0; i < StepId.size(); i++)
		{
			j=i+1;
			Row row=finalSheet.getRow(j);
			Step=(row.getCell(0).getStringCellValue()).trim();
			Data=(row.getCell(1).getStringCellValue()).trim();
			Result=(row.getCell(2).getStringCellValue()).trim();
			String jsonData= "{\"step\":\""+Step+"\","
	    	       // + "\"data\":\""+Data+"\","
	    	      // + "\"result\":\""+Result+"\""
	    	       + "\"data\":\""+Data+"\""
	    	        +"}";
			//https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/teststep/issueId/id?projectId=
			String finalURL = "https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/teststep/"+TestCaseId+"/"+StepId.get(i).trim()+"?projectId="+projectId;
			String jwt = generateToken("PUT", finalURL);
			LOGS.info("jwt::"+jwt);
			
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
/*			 StepResponse=StepResponse.replace("\"", "");
			 StepResponse=StepResponse.replace("{", "");
			 StepResponse=StepResponse.replace(",", ":");
		        String[] outputSplit=StepResponse.split(":");
		       String stepId=outputSplit[1].trim();
		       StepId.add(stepId);*/
		}

	}
	

	public void createExecution(String excelPath) throws Exception
	{
		LOGS.info("Executng createExecution method");
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution";
		String jwt = generateToken("POST", finalURL);
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		String Step,Data,Result;
		for (int i = 1; i < 2; i++)
		{
			Row row=finalSheet.getRow(i);
			Step=(row.getCell(0).getStringCellValue()).trim();
			Data=(row.getCell(1).getStringCellValue()).trim();
			//Result=(row.getCell(2).getStringCellValue()).trim();
		
			String jsonData= "{\"projectId\":\""+projectId+"\","
	    	        + "\"issueId\":\""+TestCaseId+"\","
	    	         +" \"cycleId\":\""+cycleID+"\","
	    	         + "\"versionId\":\""+VersionID+"\""
	    	     //   + "\"assigneeType\":\""+"assignee":radhika.madhi@hibu.com"+"\""
	    	        +"}";
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.post(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
			 StepResponse=StepResponse.replace("\"", "");
			 StepResponse=StepResponse.replace("{", "");
			 StepResponse=StepResponse.replace(",", ":");
			 String[] outputSplit=StepResponse.split(":");
		     ExecutionId=outputSplit[6].trim();
		     LOGS.info(ExecutionId);
		}
		
	}
	
	
	
	public void updateExecution() throws Exception
	{
		LOGS.info("Executng update Execution method");
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution/"+ExecutionId;
		String jwt = generateToken("PUT", finalURL);
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		String Step,Data,Result;
		for (int i = 1; i < 2; i++)
		{
			Row row=finalSheet.getRow(i);
			Step=(row.getCell(0).getStringCellValue()).trim();
			Data=(row.getCell(1).getStringCellValue()).trim();
			Result=(row.getCell(2).getStringCellValue()).trim();
			
			
			
		
			String jsonData= "{\"projectId\":\""+projectId+"\","
	    	        + "\"issueId\":\""+TestCaseId+"\","
	    	         +" \"cycleId\":\""+cycleID+"\"," 
	    	         +" \"comment\":\""+Result+"\","
	    	         + "\"versionId\":\""+VersionID+"\""
	    	     //   + "\"assigneeType\":\""+"assignee":radhika.madhi@hibu.com"+"\""
	    	        +"}";
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
/*			 StepResponse=StepResponse.replace("\"", "");
			 StepResponse=StepResponse.replace("{", "");
			 StepResponse=StepResponse.replace(",", ":");
			 String[] outputSplit=StepResponse.split(":");
		     ExecutionId=outputSplit[6].trim();
		     LOGS.info(ExecutionId);*/
		}
		
	}
	

	public  void overallExecution() throws Exception
	{
		LOGS.info("Executng overallExecution method");
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution/"+ExecutionId;
	
		String jwt = generateToken("PUT", finalURL);
		LOGS.info("jwt::"+jwt);
		
		 Client postRestClient = Client.create();
		
		int StatusFlag=0;
		if(overallStatus.equalsIgnoreCase("Fail")) StatusFlag=2;
		else StatusFlag=1;
		LOGS.info("Status Flag::"+StatusFlag);
		LOGS.info("overallStatus::"+overallStatus);
			String jsonData= "{\"status\":{\"id\":\""+StatusFlag+"\"},"
					+ "\"issueId\":\""+TestCaseId+"\","
	    	         +" \"projectId\":\""+projectId+"\","
	    	           +" \"cycleId\":\""+cycleID+"\","
	    	         + "\"versionId\":\""+VersionID+"\""
	    	        
	    	     //   + "\"assigneeType\":\""+"assignee":radhika.madhi@hibu.com"+"\""
	    	        +"}";
			LOGS.info("overall execution Json::"+jsonData);
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
			
				
	}
	
	
	
	public  void getStepResultID() throws Exception
	{
		LOGS.info("Executng getStepResultID method");
		StepResultId=new ArrayList<String>();
		StepId=new ArrayList<String>();
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/stepresult/search?executionId="+ExecutionId+"&issueId="+TestCaseId+"&isOrdered="+true;
		String jwt = generateToken("GET", finalURL);
		LOGS.info("jwt::"+jwt);
		LOGS.info("finalURL::"+finalURL);
		
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(finalURL);
		ClientResponse myResponse =webResource.accept("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.get(ClientResponse.class);
		LOGS.info("status: " + myResponse.getStatus());
		LOGS.info("headers: " + myResponse.getHeaders());
		String StepResponse=myResponse.getEntity(String.class);
		LOGS.info("Output: "+StepResponse);
			
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(StepResponse);
		LOGS.info("After Parsing::"+jsonObject);
		LOGS.info("No Parsing :::"+StepResponse);
	            
	    LOGS.info("ID is: "+jsonObject.get("stepResults"));
	    JSONArray StepResults = (JSONArray) jsonObject.get("stepResults");
	            
	    for (int i = 0; i < StepResults.size(); ++i) 
	    {
	                JSONObject ID = (JSONObject) StepResults.get(i);
	                String id =  (String) ID.get("id");
	              //  LOGS.info("s::"+id);
	                StepResultId.add(id);
	               
	     }
	        
		LOGS.info("StepResultId::"+StepResultId);
	
	
}

	
	/*public static void updateExecutionWithDefectID() throws Exception
	{
		LOGS.info("executing updateExecutionWithDefectID method");
		//String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution/1dfeddcc-6c1e-4cd9-8115-87b0df1dfc41";//ab33583d-4953-4c31-bf81-9b07d478f0d6
		//String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution/ab33583d-4953-4c31-bf81-9b07d478f0d6";
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/execution/261faa3d-e5bb-4683-88e4-406314493f35";
		String jwt = generateToken("PUT", finalURL);
		LOGS.info("jwt::"+jwt);
		Client postRestClient = Client.create();
		
		int StatusFlag=2;
		//if(overallStatus.equalsIgnoreCase("Fail")) StatusFlag=2;
		//else StatusFlag=1;
		//LOGS.info("Status Flag::"+StatusFlag);
		//LOGS.info("overallStatus::"+overallStatus);
			String jsonData= "{\"status\":{\"id\":\""+StatusFlag+"\"},"
					+ "\"issueId\":\""+TestCaseId+"\","
	    	         +" \"projectId\":\""+projectId+"\","
	    	           +" \"cycleId\":\""+ExecutionscycleID+"\","
	    	         + "\"versionId\":\""+-1+"\","
	    	         +"\"defects\": [\""+"TPP-11365"+"\"]"
	    	        
	    	     //   + "\"assigneeType\":\""+"assignee":radhika.madhi@hibu.com"+"\""
	    	        +"}";
		//TestCaseId="130726";
		//TestCaseId="130704";
		TestCaseId="130519";
			String jsonData="{\"status\":{\"id\":\"2\"},"
					+"\"issueId\":\""+TestCaseId+"\","
	    	         +"\"projectId\":\"10512\","
	    	           +"\"cycleId\":\"cycleID\","
	    	         + "\"versionId\":\""+VersionID+"\","
	    	      +"\"defects\":[{\"key\":\"TPP-11365\","
	    	      + "\"summary\":\"Testing\"}]"
	    		        +"}";
			LOGS.info("finalURL::"+finalURL);
		    WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			
			 LOGS.info("Output: "+StepResponse);
			
				
	}*/

	
	public  void getAllTestStepsIDs() throws Exception
		{
			LOGS.info("Executing to get all teststeps ids method");
			//StepResultId=new ArrayList<String>();
			StepId=new ArrayList<String>();
			String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/teststep/"+TestCaseId+"?projectId="+projectId;
			String jwt = generateToken("GET", finalURL);
			LOGS.info("jwt::"+jwt);
			LOGS.info("finalURL::"+finalURL);
			
			Client restClient = Client.create();
			WebResource webResource = restClient.resource(finalURL);
			ClientResponse myResponse =webResource.accept("application/json")
	     								   .header("Authorization", jwt)
			  								.header("zapiAccessKey",accessKey)
			  								.get(ClientResponse.class);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			LOGS.info("Output: "+StepResponse);
			
			JSONParser parser = new JSONParser();
			 JSONArray jsonObject = ( JSONArray) parser.parse(StepResponse);
			LOGS.info("After Parsing::"+jsonObject);
			//JSONObject jsonObject = new JSONObject(StepResponse);
			//JSONArray idValue = (JSONArray)jsonObject.get("id");
			
			
		    LOGS.info("ID is: "+jsonObject.size());
		    //JSONArray StepResults = (JSONArray) jsonObject.get("stepResults");
		            
		    for (int i = 0; i < jsonObject.size(); ++i) 
		    {
		                JSONObject ID = (JSONObject) jsonObject.get(i);
		                String id =  (String) ID.get("id");
		                LOGS.info("s::"+id);
		                StepId.add(id);
		               
		     }


		        
			LOGS.info("StepId::"+StepId);
				

		
		
	}
	

	public void stepwiseExecution(String excelPath) throws Exception
	{
		LOGS.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		LOGS.info("Executng stepwiseExecution method");
		LOGS.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		String finalURL = zephyrBaseUrl + "/public/rest/api/1.0/stepresult/";
		
		URI uri = new URI(finalURL);
		int expirationInSec = 360;
			
		 Client postRestClient = Client.create();
					
		//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
		
		LOGS.info("Excel path :" + excelPath);
		FileInputStream fileInput = new FileInputStream(excelPath);
		XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
		XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
		int rowCount=finalSheet.getLastRowNum();
		LOGS.info(rowCount);
		String Step,Data,Result;
		int stepStatus=0;
		int j=0;
		LOGS.info("StepResultId.size()"+StepResultId.size());
		for (int i = 0; i < StepResultId.size(); i++)
		{
			j=i+1;
			finalURL=zephyrBaseUrl + "/public/rest/api/1.0/stepresult/"+StepResultId.get(i);
			 String jwt = generateToken("PUT", finalURL);
			 LOGS.info("jwt::"+jwt);
			
			Row row=finalSheet.getRow(j);
			LOGS.info(row.getCell(0).getStringCellValue());
			
			Result=(row.getCell(3).getStringCellValue()).trim();
			Data=(row.getCell(2).getStringCellValue()).trim();
			LOGS.info("Stepwise Result::"+Result);
			if(Result.equalsIgnoreCase("Pass"))
			{
				stepStatus=1;
				
			}
			else 
			{
				stepStatus=2;
				overallStatus="Fail";
			}

		
			String jsonData= "{\"status\":{\"id\":\""+stepStatus+"\"},"
	    	        + "\"issueId\":\""+TestCaseId+"\","
	    	         //+ "\"result\":\""+URLEncoder.encode(Data, "UTF-8")+"\","  URLEncoder.encode(Data, "UTF-8")
	    	        		 + "\"comment\":\""+Data+"\","
	    	         + "\"executionId\":\""+ExecutionId+"\""
	    	     //   + "\"assigneeType\":\""+"assignee":radhika.madhi@hibu.com"+"\""
	    	        +"}";
			LOGS.info("finalURL::"+finalURL);
			WebResource postWebResource = postRestClient.resource(finalURL);
		    ClientResponse myResponse = postWebResource.type("application/json")
     								   .header("Authorization", jwt)
		  								.header("zapiAccessKey",accessKey)
		  								.put(ClientResponse.class,jsonData);
			LOGS.info("status: " + myResponse.getStatus());
			LOGS.info("headers: " + myResponse.getHeaders());
			String StepResponse=myResponse.getEntity(String.class);
			JSONParser parser=new JSONParser();
			JSONObject json = (JSONObject) parser.parse(StepResponse);
			System.out.print("StepResponse before parsing::"+StepResponse);
			System.out.print("********************************************");
			LOGS.info("StepResponse after Parsing:::"+parser.parse(StepResponse));
			System.out.print("********************************************");
			 LOGS.info("ID is: "+json.get("stepResults"));
			 
			 
		}
		
	}
	
	public String createZephyrTestCase(String Summary, String Description, String excelPath) throws Exception
	{
		
		try{
			
				LOGS.info("Creating Test Case in zephyr Jira");
				/*if(orderId.startsWith("YC"))
				{
				*/	String getURL = "https://hibu-us.atlassian.net/rest/api/2/issue/createmeta";
				 String name = "radhika.madhi@hibu.com";
				 String password = "B9p69qOPQBnw20LOGH7b24B2";
			        String authString = name + ":" + password;
			        //String authStringEnc = new Base64Encoder().encode(authString.getBytes());
			        String authStringEnc = new String(
			        		 org.apache.commons.codec.binary.Base64.encodeBase64   
			        		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8(authString))
			        		  );
			        LOGS.info("Base64 encoded auth string: " + authStringEnc);
					 String postURL = "https://hibu-us.atlassian.net/rest/api/2/issue";
					 LOGS.info( " Jira URL : "+ postURL);
					  //Unable to work on Issue Links due to open issue explained in https://bobswift.atlassian.net/browse/JCLI-781 FIx was provided on Nov 2015. 
					 //Fix is not available in the release we have. . SO chosen a better alternative to associate Requirement Card
					//String LabelsJira="RR57";
				     String jsonData= "{\"fields\":{"
				    		 //	+"\"project\":{\"key\":\"TPP\"},"
				    		 	+"\"project\":{\"key\":\"TCM\"},"				    		 	
				    	        +"\"issuetype\":{\"name\":\"Test\"},"
				    		 	+ "\"summary\":\""+Summary+"\","				    	       
				    	       +"\"labels\": [\""+"Sanity"+"\"],"
				    	      //  +"\"comment\":\"TPP-11365\","
				    	     //s  +"\"components\": [{\"name\":\"Solutions-Quote Submission\"}],"
				    	     //  +"\"components\": [{\"name\":\"Solutions-Billing\"}],"
				    	      // +"\"components\": [{\"name\":\"Solutions-Fulfillment\"}],"
				    	       // +"\"issuelinks\": [{\"key\":\"TPP-11365\"}],"
				    		 	//+"\"customfield_12300\":\"QuoteSubmission\","
				    		 	+ "\"description\":\""+Description+"\""	
				    		 	//+ "\"customfield_10807\":\""+testResults+"\""	
				    		+"}}"; 	
				     LOGS.info( " Json Data  : "+ jsonData);
				     ClientResponse myResponse;
					try {
						Client postRestClient = Client.create();
						 WebResource postWebResource = postRestClient.resource(postURL);
						 myResponse = postWebResource.type("application/json")
														   .header("X-Atlassian-Token", "no-check")
														   .header("Authorization", "Basic " + authStringEnc)
														   .post(ClientResponse.class,jsonData);
						   int status=myResponse.getStatus();
							//   myResponse.g
							   LOGS.info("myResponse.getStatus : " +status);
						        if(status!=201){
						            LOGS.info("Unable to connect to the server");
						        }
						       
						        String output = myResponse.getEntity(String.class);
						        LOGS.info("output:  "+output);
						        output=output.replace("\"", "");
						        
						        output=output.replace("{", "");
						        output=output.replace(",", ":");
						        String[] outputSplit=output.split(":");

						        LOGS.info("output:  "+outputSplit.length);
						        LOGS.info("postResponse: "+outputSplit[3]);
						        LOGS.info("postResponse: "+outputSplit[1]);
						        LOGS.info("postResponse: "+outputSplit[2]);
						        TestCaseNum=outputSplit[3].trim();
						        TestCaseId=outputSplit[1].trim();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						LOGS.info("Catch block : "+ e.getMessage());
						LOGS.info("Catch block : " + e.getStackTrace());
					}
				  

			    // createCycles(); 
			    // createFolder();
			   	 createTestStep(TestCaseId, excelPath);
				 createExecution(excelPath);
				// updateExecution();
				 //createFolder();
				 
				 getStepResultID();
				 stepwiseExecution(excelPath);
				 //moveExecutionstoFolder();
				 overallExecution();
				
				
				
				//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
				
				LOGS.info("Excel path :" + excelPath);
/*				FileInputStream fileInput = new FileInputStream(excelPath);
				XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
				XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
				int rowCount=finalSheet.getLastRowNum();
				LOGS.info(rowCount);
				String path;
				String result;
				int j;
				for (int i = 1; i <= rowCount; i++)
				{
					j=i-1;
					Row row=finalSheet.getRow(i);
					result=(row.getCell(2).getStringCellValue()).trim();
					path=(row.getCell(4).getStringCellValue()).trim();
					
					addAttachment.addAttachment(StepResultId.get(j),path,result);
				}*/
				
				//getAllTestStepsIDs();
				
				 
				//JiraClass.updateIssueLinkToZephyrTestCase(TestCaseNum, defectNum);
					LOGS.info("TPP::"+TestCaseNum);
					 LOGS.info(TestCaseId); 
					LOGS.info(ExecutionId);
					//LOGS.info("Defect No :"+defectNum);
					
					String tcStatus = captureTestCaseStatus(TestCaseNum);
					LOGS.info("Jira first status :"+tcStatus);
					Thread.sleep(2000);
					if (tcStatus.equalsIgnoreCase("Open")  ){
						 updateZephyrStatus("TC - AWAITING REVIEW",TestCaseNum);
						        	Thread.sleep(2000);
						        	updateZephyrStatus("ASSIGNED TO TEST",TestCaseNum);
						        	Thread.sleep(2000);
						        	if (overallStatus.equalsIgnoreCase("Pass")) {
						        	updateZephyrStatus("Passed",TestCaseNum);
						        	}else {
						        		updateZephyrStatus("Failed",TestCaseNum);
						        	}
							   }else if(tcStatus.equalsIgnoreCase("Passed")  ) {
						        	updateZephyrStatus("Rerun_From_Pass",TestCaseNum);
						        	Thread.sleep(2000);
						        	if (overallStatus.equalsIgnoreCase("Pass")) {
						        	updateZephyrStatus("Passed",TestCaseNum);
						        	}else {
						        		updateZephyrStatus("Failed",TestCaseNum);
						        	}
							   }else if(tcStatus.equalsIgnoreCase("Failed")  ) {
						        	updateZephyrStatus("Rerun_From_Fail",TestCaseNum);
						        	Thread.sleep(2000);
						        	if (overallStatus.equalsIgnoreCase("Pass")) {
						        	updateZephyrStatus("Passed",TestCaseNum);
						        	}else {
						        		updateZephyrStatus("Failed",TestCaseNum);
						        	}
							   }else if(tcStatus.equalsIgnoreCase("UNEXECUTED")  ) {
		
						        	Thread.sleep(2000);
						        	if (overallStatus.equalsIgnoreCase("Pass")) {
						        	updateZephyrStatus("Passed",TestCaseNum);
						        	}else {
						        		updateZephyrStatus("Failed",TestCaseNum);
						        	}
							   }

					
					
					
				}
			       
				//}
			/*else
			{
				LOGS.info("No Ticket created as the execution stopped due to Slownesss of the Application");
			}
		    */    
		    
			catch(Exception t)
			{
				t.printStackTrace();
				
			}
/*			LOGS.info("Executing createTestCaseinJira Keyword is Completed");
			testCaseAfterMethod(Resultsfolderpath,Resultsfolderpath,TestCaseNum);*/
			return TestCaseNum;
			}
	
	public  void multipleExecutionsOnUniqueIssueId(String issueId ,String cycleID,String jira) {
		
		
		try {
			
			TestCaseId=issueId;
			cycleID = "bb6bc991-7a4b-4cc4-9b40-373a1201d9ab";
			PreRequisites.cycleID = cycleID;
			LOGS.info(" cycleId Id : "+ PreRequisites.cycleID);
			LOGS.info(" Issue Id : "+ TestCaseId);
			
			 //createExecution();
			 getStepResultID();
			 //stepwiseExecution();
					 
			
			overallExecution();
			
			//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
			
			LOGS.info("Excel path :" + excelPath);
			FileInputStream fileInput = new FileInputStream(excelPath);
			XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
			XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowCount=finalSheet.getLastRowNum();
			LOGS.info(rowCount);
			String path;
			String result;
			int j;
			for (int i = 1; i <= rowCount; i++)
			{
				j=i-1;
				Row row=finalSheet.getRow(i);
				result=(row.getCell(2).getStringCellValue()).trim();
				path=(row.getCell(4).getStringCellValue()).trim();
				
				addAttachment.addAttachment(StepResultId.get(j),path,result);
			}
			//JiraClass.updateIssueLinkToZephyrTestCase(TestCaseNum, defectNum);
				//LOGS.info("TPP::"+TestCaseNum);
				 LOGS.info(TestCaseId); 
				LOGS.info(ExecutionId);
				//LOGS.info("Defect No :"+defectNum);
		}
	    
		catch(Exception t)
		{
			t.printStackTrace();
			
		}
		
	}
	
	
public void multipleExecutionsOnUniqueIssueId(String issueId, String jiraCard) {
		
		
		try {
			
			TestCaseId=issueId;
			LOGS.info(" Issue Id : "+ TestCaseId);
			//getAllTestStepsIDs();
			//updateTestStep(TestCaseId);
			//createTestStep(TestCaseId);
			// createExecution();
			 getStepResultID();
			// stepwiseExecution();
					 
			
			overallExecution();
			
			//String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
			
			LOGS.info("Excel path :" + excelPath);
			FileInputStream fileInput = new FileInputStream(excelPath);
			XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
			XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
			int rowCount=finalSheet.getLastRowNum();
			LOGS.info(rowCount);
			String path;
			String result;
						int j;
			for (int i = 1; i <= rowCount; i++)
			{
				j=i-1;
				Row row=finalSheet.getRow(i);
				result = (row.getCell(2).getStringCellValue()).trim();
				path=(row.getCell(4).getStringCellValue()).trim();
				
				addAttachment.addAttachment(StepResultId.get(j),path,result);
			}
			//JiraClass.updateIssueLinkToZephyrTestCase(TestCaseNum, defectNum);
				//LOGS.info("TPP::"+TestCaseNum);
				 LOGS.info(TestCaseId); 
				LOGS.info(ExecutionId);
				//LOGS.info("Defect No :"+defectNum);
				
				String tcStatus = captureTestCaseStatus(jiraCard);
				LOGS.info("Jira first status :"+tcStatus);
				Thread.sleep(2000);
				if (tcStatus.equalsIgnoreCase("Open")  ){
					 updateZephyrStatus("TC - AWAITING REVIEW",jiraCard);
					        	Thread.sleep(2000);
					        	updateZephyrStatus("ASSIGNED TO TEST",jiraCard);
					        	Thread.sleep(2000);
					        	if (overallStatus.equalsIgnoreCase("Pass")) {
					        	updateZephyrStatus("Passed",jiraCard);
					        	}else {
					        		updateZephyrStatus("Failed",jiraCard);
					        	}
						   }else if(tcStatus.equalsIgnoreCase("Passed")  ) {
					        	updateZephyrStatus("Rerun_From_Pass",jiraCard);
					        	Thread.sleep(2000);
					        	if (overallStatus.equalsIgnoreCase("Pass")) {
					        	updateZephyrStatus("Passed",jiraCard);
					        	}else {
					        		updateZephyrStatus("Failed",jiraCard);
					        	}
						   }else if(tcStatus.equalsIgnoreCase("Failed")  ) {
					        	updateZephyrStatus("Rerun_From_Fail",jiraCard);
					        	Thread.sleep(2000);
					        	if (overallStatus.equalsIgnoreCase("Pass")) {
					        	updateZephyrStatus("Passed",jiraCard);
					        	}else {
					        		updateZephyrStatus("Failed",jiraCard);
					        	}
						   }else if(tcStatus.equalsIgnoreCase("UNEXECUTED")  ) {
	
					        	Thread.sleep(2000);
					        	if (overallStatus.equalsIgnoreCase("Pass")) {
					        	updateZephyrStatus("Passed",jiraCard);
					        	}else {
					        		updateZephyrStatus("Failed",jiraCard);
					        	}
						   }

				
		}
	    
		catch(Exception t)
		{
			t.printStackTrace();
			
		}
		
	}

public static String captureTestCaseStatus(String TCNum) throws Exception
{
	String output="",JiraStatus="";
	try{
		
		String url = "https://hibu-us.atlassian.net/rest/api/latest/issue/"+TCNum+"?fields=status";
		 
			//partilaURL+issuNum;
		LOGS.info("url :"+url);
		String name ="hemalatha.bondalapati@wipro.com";
        String password ="RIGI4D8ypECI5TuwVyHi81CC";//"12345@Sahanb";
	        String authString = name + ":" + password;
	        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
	        LOGS.info("Base64 encoded auth string: " + authStringEnc);
	        Client restClient = Client.create();
	        WebResource webResource = restClient.resource(url);
	        ClientResponse getTransitionResp = webResource.accept("application/json")
	                                         .header("Authorization", "Basic " + authStringEnc)
	                                         .get(ClientResponse.class);
	        LOGS.info(getTransitionResp.getStatus());
	        if(getTransitionResp.getStatus() != 200){
	            System.err.println("Unable to connect to the server");
	        }
	        output = getTransitionResp.getEntity(String.class);
	        if(output.contains("Passed"))
	        {
	        	JiraStatus="Passed";
	        	LOGS.info("Status is Passed");
	        }
	        if(output.contains("Failed"))
	        {
	        	JiraStatus="Failed";
	        	LOGS.info("Status is Failed");
	        }
	        if(output.contains("Open"))
	        {
	        	JiraStatus="Open";
	        	LOGS.info("Status is Open");
	        }
	        LOGS.info("response: "+output);
	        if(output.contains("UNEXECUTED"))
	        {
	        	JiraStatus="UNEXECUTED";
	        	LOGS.info("Status is UNEXECUTED");
	        }
	        LOGS.info("response: "+output);
	    }

	
	catch(Exception t)
	{
		t.printStackTrace();
	
	}
	LOGS.info("Executing click Keyword Complete");
	
	return JiraStatus;	
}

public static String updateZephyrStatus(String statuschange,String jiraNO) throws Exception
{
	 LOGS.info("Executing updateZephyrStatus Keyword");
	
	
	try{
		String url="https://hibu-us.atlassian.net/rest/api/latest/issue/"+jiraNO+"/transitions?expand=transitions.fields";
		String jsonData="";
		LOGS.info("url :"+url);
		String name = "hemalatha.bondalapati@wipro.com";//"hemalatha.bondalapati@wipro.com"; //"hemalatha.bondalapati@hibu.com";
		String password ="RIGI4D8ypECI5TuwVyHi81CC";
	        String authString = name + ":" + password;
	        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
	        LOGS.info("Base64 encoded auth string: " + authStringEnc);
	        if(statuschange.equalsIgnoreCase("TC - AWAITING REVIEW")){
	        	LOGS.info("Changing the state from Open to TC - AWAITING REVIEW");
        		jsonData="{\"transition\":{\"id\":11}}";
	        }
	        if(statuschange.equalsIgnoreCase("ASSIGNED TO TEST")){
	        	LOGS.info("Changing the state from TC - AWAITING REVIEW to ASSIGNED TO TEST");
        		jsonData="{\"transition\":{\"id\":21}}";
	        }
	        if(statuschange.equalsIgnoreCase("PASSED")){
	        	LOGS.info("Changing the state from ASSIGNED TO TEST to Passed");
        		jsonData="{\"transition\":{\"id\":91}}";
	        }
	        if(statuschange.equalsIgnoreCase("FAILED")){
	        	LOGS.info("Changing the state from ASSIGNED TO TEST to Failed");
        		jsonData="{\"transition\":{\"id\":81}}";
	        }
	        if(statuschange.equalsIgnoreCase("Rerun_From_Pass")){
	        	LOGS.info("Changing the state from Rerun_From_Pass  ASSIGNED TO TEST to Failed");
        		jsonData="{\"transition\":{\"id\":131}}";
	        }
	        if(statuschange.equalsIgnoreCase("Rerun_From_Fail")){
	        	LOGS.info("Changing the state from Rerun_From_Fail ASSIGNED TO TEST to Pass");
        		jsonData="{\"transition\":{\"id\":141}}";
	        }
	        
	       
	        Client restClient = Client.create();
	        WebResource webResource = restClient.resource(url);
	       ClientResponse TransitionResp1 = webResource.type("application/json")
	        									.header("X-Atlassian-Token", "no-check")
	        									.header("Authorization", "Basic " + authStringEnc)
	        									.post(ClientResponse.class,jsonData);
	        LOGS.info(TransitionResp1);
	        LOGS.info("Changed the state to :"+statuschange);
	       
	    
	    }

	
	catch(Exception t)
	{
		t.printStackTrace();
		
	}
	
	
	return "Pass";	
}
	
	
	public static void addAttachmentToIssue(String entityId) throws Exception{}
	public static void main(String[] args) throws Exception {
		//getCycleIDs();
		
		ZephyrTestCase ztc = new ZephyrTestCase();

		
/*		String Summary="SAP Billing - Online Foundation Solutions - 8045618453";
		String Description = "Successfully Completed Billing";*/
		String Summary = "CPQ Budget Change Increase Non Paused ( reconfigure) pricechange - Display" ;
		String Description = "Successfully updatedpricechange.";
		String TestcaseNum1=ztc.createZephyrTestCase(Summary, Description, "");
		LOGS.info(TestcaseNum1);

		
		//SalesforceTasks.YextAccountCreation();

/*		uniqueIssueId= "150251";
		PreRequisites.jiraNo = "TCM-2997";
		ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(), PreRequisites.jiraNo);*/
	 
		//getAllTestStepsIDs();
		
//		uniqueIssueId = "144475";
//		ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(), PreRequisites.jiraNo);
		//ZephyrTestCase.multipleExecutionsOnUniqueIssueId(uniqueIssueId.trim(),cycleID);
		
		/*String finalURL ="https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/cycles/search?versionId=16851&projectId=15218";
		String jwt = generateToken("GET", finalURL);
		LOGS.info("jwt::"+jwt);
		LOGS.info("finalURL::"+finalURL);*/
		//createFolder();
/*		updateFolder();
		getListofFolderIds();*/
		//getCycleIDs();
	//	 MoveOrCopyFile.moveFunction("C:\\Users\\IB1426\\Downloads\\TestResult.xlsx","C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx");
		
		 
	//createCycles();
		 //TPP-9608   TPP-9627
	//TestCaseId="134633";
	//ExecutionId="0b27253d-0b12-43b6-87bc-dcb4a35eb346";*/
	// String stepResult1="9ceea08f-33f4-4a9f-b38a-404cf27b1f28";
	 //0f448de1-4fe7-4e14-8074-4ad99f37b51d
/*String TestcaseNum1=JiraClass.createZephyrTestCase(Summary, Description);
LOGS.info(TestcaseNum1);*/

	/*updateTests(TestCaseId);
	 createExecution();
	 getStepResultID();
	stepwiseExecution();
	// updateExecutionWithDefectID();
	 
	
	overallExecution(); */
	
	
		
		 //attach StepResultId::[, , , ]
	/*StepResultId=new ArrayList<String>();
	StepResultId.add("fe0f87c2-d738-41ad-8940-590d93163f53");
	StepResultId.add("73dfe2fa-787b-4e09-9f7d-473d3b4c6b95");
	StepResultId.add("b94d0cb8-3db4-49a1-9177-2eb485058969");
	StepResultId.add("cc3710ec-6413-42ba-aa86-f9e5896e1571");
	StepResultId.add("49a0b68b-a1bb-4a4b-bda6-22ee91238d35");*/
/*	String excelPath="C:\\Automation\\OutputFiles\\ZephyrTestResult.xlsx";
	
	LOGS.info("Excel path :" + excelPath);
	FileInputStream fileInput = new FileInputStream(excelPath);
	XSSFWorkbook finalWorkbook = new XSSFWorkbook(fileInput);
	XSSFSheet finalSheet = finalWorkbook.getSheetAt(0);
	int rowCount=finalSheet.getLastRowNum();
	LOGS.info(rowCount);
	String path;
	int j;
	for (int i = 1; i <= rowCount; i++)
	{
		j=i-1;
		Row row=finalSheet.getRow(i);
		
		path=(row.getCell(4).getStringCellValue()).trim();
		
		addAttachment.addAttachment(StepResultId.get(j),path);
	}
	
		//LOGS.info("TPP::"+TestcaseNum1);
		 //LOGS.info(TestCaseId); 
		LOGS.info(ExecutionId);*/
	

	}

	public static String IssueIDGenerate(String ProdId) {
		String IssueIDValue="";

		try {
			if (ProdId.equalsIgnoreCase("01")) 
				IssueIDValue="135229";
			else if (ProdId.equalsIgnoreCase("02")) 
				IssueIDValue="135450";
			else if (ProdId.equalsIgnoreCase("03")) 
				IssueIDValue="135448";
			else if (ProdId.equalsIgnoreCase("04")) 
				IssueIDValue="135449";
			else if (ProdId.equalsIgnoreCase("05")) 
				IssueIDValue="135444";
			else if (ProdId.equalsIgnoreCase("06")) 
				IssueIDValue="135446";
			else if (ProdId.equalsIgnoreCase("07")) 
				IssueIDValue="135271";
			else if (ProdId.equalsIgnoreCase("08")) 
				IssueIDValue="135472";
			else if (ProdId.equalsIgnoreCase("09")) 
				IssueIDValue="135445";
			else if (ProdId.equalsIgnoreCase("10")) 
				IssueIDValue="135262";
			else if (ProdId.equalsIgnoreCase("11")) 
				IssueIDValue="135270";
			else if (ProdId.equalsIgnoreCase("12")) 
				IssueIDValue="135434";
			else if (ProdId.equalsIgnoreCase("13")) 
				IssueIDValue="135441";
			else if (ProdId.equalsIgnoreCase("14")) 
				IssueIDValue="135437";
			else if (ProdId.equalsIgnoreCase("15")) 
				IssueIDValue="135439";
			else if (ProdId.equalsIgnoreCase("16")) 
				IssueIDValue="135468";
			else if (ProdId.equalsIgnoreCase("17")) 
				IssueIDValue="135464";
			
			else if (ProdId.equalsIgnoreCase("18")) 
				IssueIDValue="135279";
			else if (ProdId.equalsIgnoreCase("19")) 
				IssueIDValue="135293";
			else if (ProdId.equalsIgnoreCase("20")) 
				IssueIDValue="135461";
			else if (ProdId.equalsIgnoreCase("21")) 
				IssueIDValue="135458";
			else if (ProdId.equalsIgnoreCase("22")) 
				IssueIDValue="135296";
			
			else if (ProdId.equalsIgnoreCase("23")) 
				IssueIDValue="135299";
			else if (ProdId.equalsIgnoreCase("24")) 
				IssueIDValue="135299";
			else {
				IssueIDValue="Fail";
			}
		}
		catch (Exception t) {
			t.printStackTrace();

		}
		
		return IssueIDValue;

	}
}
