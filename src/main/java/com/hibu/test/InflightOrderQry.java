package com.hibu.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class InflightOrderQry extends PreRequisites {
	
	static String ActRes="",ExpRes="",Status="",ImagePath="",ImageName="",ImgName="";
	
	public static String inFlightOrder(String BusinessName) throws Exception{
		int count=0;
		
			try {
				Class.forName("org.postgresql.Driver");
				//create  the connection object  
				 String jdbcUrl = "jdbc:postgresql://" + "mediauat.cjbuv7fnwppu.us-east-1.rds.amazonaws.com" + ":" + "5432" + "/" + "mediauat" + "?user=" + "ib1426" + "&password=" + "Welcome@123";
				Connection con=DriverManager.getConnection(jdbcUrl);
				System.out.println(" DB Connected!!");
				// create the statement object  
				Statement stmt=con.createStatement();  
				
				String SOQLQRY="select inflight.INTEGRATION_ID, inflight.ORDER_NUMBER_ALPHA from sfa.MPE_SUBMITTED_ORDER inflight "
							+"left join ( select so.ORDER_NUMBER_ALPHA from sfa.MPE_SUBMITTED_ORDER so join jbpm.JBPM_TOKEN token on "
							+ "token.PROCESSINSTANCE_ = so.BPM_IDENTIFIER join jbpm.JBPM_LOG l on l.TOKEN_ = token.ID_ join "
							+ "jbpm.JBPM_ACTION a on a.ID_ = l.ACTION_ join jbpm.JBPM_DELEGATION d on d.ID_ = a.ACTIONDELEGATION_ "
							+ "and d.CLASSNAME_ in('com.pubco.mp.emarket.bpm.common.handlers.CompletionEndActionHandler')) completed on "
							+ "completed.ORDER_NUMBER_ALPHA = inflight.ORDER_NUMBER_ALPHA where completed.ORDER_NUMBER_ALPHA is null and "
							+ "INTEGRATION_ID in (select INTEGRATION_ID from SFA.MPE_ASSET_CUSTOMER where Business_ID in ('"+BusinessName+"'))";
						
				System.out.println(SOQLQRY);
				//execute query  
				ResultSet rs=stmt.executeQuery(SOQLQRY);  
				System.out.println("RS executed Successfully!!!");
				while(rs.next())  
				{	
					System.out.println("The Account is in-flight Order");
					ImageName="";
					ImgName="No Image";
					//ExportResults.exportTestResult("InFlight Order Query Results,"+"Account should be Identified as Inflight Order"+","+"Account identified as Inflight Order : "+BusinessName+","+"Pass"+","+ImgName);
					LOGS.info("InFlight Order Query Results,"+"Account should be Identified as Inflight Order"+","+"Account identified as Inflight Order : "+BusinessName+","+"Pass");
					return "Bad Account";
				}
				
				return "Good Account";
			}	
	catch(Exception e)
	{
		e.printStackTrace();
		ActRes="Contract Not available in Siebel Database";
		ExpRes="Contracts should be available in Siebel DB";
		count=0;
		ImgName="No Image";
		//ExportResults.exportTestResult("Siebel Query Results,"+ExpRes+","+ActRes+","+"Fail"+","+ImgName);
		LOGS.info("Siebel Query Results,"+ExpRes+","+ActRes+","+"Fail");
		return "Unable to execute the Query";	
	}
		 
		}

	}

