package com.hibu.tests;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
//import org.json.JSONException;


import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

public class addAttachment extends PreRequisites {

	final public static void addAttachment(String entityId,String fileWithAbsolutePath, String result) throws URISyntaxException, ParseException, IOException {
		final String API_ADD_ATTACHMENT = "{SERVER}/public/rest/api/1.0/attachment";
		

		/** Declare JIRA,Zephyr URL,access and secret Keys */

		final String zephyrBaseUrl = "https://prod-api.zephyr4jiracloud.com/connect";
		// zephyr accessKey , we can get from Addons >> zapi section
		//final String accessKey = "amlyYTpmMDJhZTJkZC1mZmE5LTQ5NWYtYTRiYy1lZTkyMzkyYjIwMzggemci5jb20gVVNFUl9ERUZBVUxUX05BTUU";
		// zephyr secretKey , we can get from Addons >> zapi section
		//String secretKey = "vv3p-KSST8-9lxPwQusqq6ds2wLsMsJr8";
/*		final String accessKey = "amlyYTplMWFkNzQ1NC0yNTA0LTQ3MGMtOTFlMi0xMTE3MzA0YzcyMzggNTU3MDU4JTNBODBhY2YzYWUtNzlkYy00NGE5LTlmNjctZGUwZjRmZjU5MjZmIFVTRVJfREVGQVVMVF9OQU1F";
		 String secretKey = "KxMv5mEuakCyq14HRRWZ3tnwB9Zv1O2qks3NYfbv57c";
*/
		
	    //final String accessKey = "amlyYTplMWFkNzQ1NC0yNTA0LTQ3MGMtOTFlMi0xMTE3MzA0YzcyMzggNTU3MDU4JTNBMDE2ZTg2NTUtMTU4OC00ZjE0LTg5MjEtYTkwMWU0OGM3MjA3IFRlc3Q";
	    //final String secretKey = "7V0exbljni8kPQ2gfd7bXAgfWI-PaLw0VU6POY2SSsY";
		//Radhika's cred
/*		 final String accessKey = "amlyYTplMWFkNzQ1NC0yNTA0LTQ3MGMtOTFlMi0xMTE3MzA0YzcyMzggbWFkaGlyMDEgVVNFUl9ERUZBVUxUX05BTUU";
		 final String secretKey = "2uCe3yTiPWpVOFOs9fSZq6utSoZH6WfGklkNIPeEzjY";*/
		 //hema
		    final String accessKey = "amlyYTplMWFkNzQ1NC0yNTA0LTQ3MGMtOTFlMi0xMTE3MzA0YzcyMzggNTU3MDU4JTNBMGY4Y2FhZjgtZGZmMC00NzA1LTg0ODAtOWYxM2ZhY2YxYjg4IFVTRVJfREVGQVVMVF9OQU1F";
		    final String secretKey = "fsQqlTUuuv3Kyp3P8HbEdghaQP1xXQjrmt_k5MxEZ18";
		/** Declare parameter values here */
		 final String userName = "radhika.madhi@hibu.com";
		final String comment = "Attachment through ZAPI CLoud";
		final String cycleId = cycleID;			// Cycle Id of the execution - "-1" for AdHoc Cycle
		final String versionId = VersionID;			//Version Id of Execution - '-1" for UNSCHEDULED version
		final String projectId = "15218";	//TCM;
		final String TestCaseId = "TestCaseId";
		//final String projectId = "10512";//TPP
		//ProjectId of the execution
					//Issue Id of the execution
		final String entityName = "stepResult"; // entityName takes execution/stepResult as parameter value
	//	final String entityId = "422afd54-56b0-4b92-a0b1-4ff93a76eeea";    //execution Id
		//final String fileWithAbsolutePath = "C:\\Automation\\CPQ\\CPQMainBranch\\Framework\\src\\main\\java\\com\\hibu\\tests\\1.PNG";   //Absolute path of the file
		int expirationInSec = 360;
		
		// Add Attachment to a testcase ********DO NOT EDIT ANYTHING BELOW**********
		
		
		final ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, userName)
				.build();
		JwtGenerator jwtGenerator = client.getJwtGenerator();

		// Initializes the URL data type with strURL created above
		String attachmentUri = API_ADD_ATTACHMENT.replace("{SERVER}", zephyrBaseUrl) + "?issueId=" + TestCaseId
				+ "&versionId=" + versionId + "&entityName=" + entityName + "&cycleId=" + cycleId + "&entityId="
				+ entityId + "&projectId=" + projectId  +"&comment="+ "comment";//URLEncoder.encode(result, "UTF-8");//"&comment="+result;
		URI uri = new URI(attachmentUri);

		String jwt = jwtGenerator.generateJWT("POST", uri, expirationInSec);
		LOGS.info(uri.toString());
		LOGS.info(jwt);

		CloseableHttpResponse response = null;
		HttpClient restClient = new DefaultHttpClient();

		File file = new File(fileWithAbsolutePath);
		MultipartEntity entity = new MultipartEntity();
		entity.addPart("attachment", new FileBody(file));
		
		//entity.addPart(name, contentBody);

		HttpPost addAttachmentReq = new HttpPost(uri);
		addAttachmentReq.setEntity(entity);
		addAttachmentReq.setHeader("Authorization", jwt);
		addAttachmentReq.setHeader("zapiAccessKey", accessKey);
		//addAttachmentReq.setHeader("content-type", "multipart/form-data");
		//addAttachmentReq.setHeader("Content-type", "application/json; charset=utf-8");
		//addAttachmentReq.se
		
		
/*	    httpPost.setHeader("Content-type", "application/json; charset=utf-8");
	    httpPost.setHeader("User-Agent", Config.USER_AGENT);
	    CloseableHttpResponse response = httpClient.execute(httpPost);
	    entity = response.getEntity();*/

		try {
			response = (CloseableHttpResponse) restClient.execute(addAttachmentReq);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity1 = response.getEntity();
		int statusCode = response.getStatusLine().getStatusCode();
		 LOGS.info(statusCode);
		 LOGS.info(response.toString());
		if (statusCode >= 200 && statusCode < 300) {
			LOGS.info("Attachment added Successfully");
		} else {
			try {
				String string = null;
				string = EntityUtils.toString(entity1);
				LOGS.info(string);
				throw new ClientProtocolException("Unexpected response status: " + statusCode);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			}
		}

	}
}
