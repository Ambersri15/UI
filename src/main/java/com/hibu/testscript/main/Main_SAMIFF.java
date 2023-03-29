package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;

import com.hibu.test.PreRequisites;
import com.hibu.test.SalesforceTasks;
import com.hibu.test.SamiFulfillment;

public class Main_SAMIFF extends PreRequisites{

	public void main(int PortNo) throws Throwable{
		// TODO Auto-generated method stub
		SamiFulfillment SF = new SamiFulfillment();
		PreRequisites pr = new PreRequisites();
		DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		st = new SalesforceTasks();
		LOGS.info(curDate);
		TestCaseName="UI_SAMIFF_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		//SalesRepType = "TSales";
		st.portNO = PortNo;
		
		LOGS.info("SAMI Result folder: "+Resultsfolderpath);
		SF.samiFlow("8046831881", Resultsfolderpath);
		SF.SAMILogout();
	}

}
