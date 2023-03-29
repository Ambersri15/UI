package com.hibu.testscript.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;

import com.hibu.test.PreRequisites;
import com.hibu.test.SalesforceTasks;

public class Main_DomainProvisioning extends PreRequisites{

	public void main(int PortNo) throws Throwable{
		// TODO Auto-generated method stub
		PreRequisites pr = new PreRequisites();
		DOMConfigurator.configure("log4j.xml");
		pr.loadPropertiesFiles("Object");
		String curDate = new SimpleDateFormat("ddMMM").format(new Date());
		LOGS.info(curDate);
		st = new SalesforceTasks();
		LOGS.info(curDate);
		TestCaseName="UI_DomainProvisioning_"+curDate;	
		Resultsfolderpath = pr.createFolder(TestCaseName);
		pr.preparingOutputSheets();
		//SalesRepType = "TSales";
		st.portNO = PortNo;
		
		st.DomainProvisioning("8046831752", Resultsfolderpath);

	}

}
