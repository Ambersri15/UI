package com.hibu.testscript.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hibu.test.PreRequisites;
import com.hibu.testscript.main.Main_DomainProvisioning;
import com.hibu.testscript.main.Main_DomainProvisioningAndPublishing;
import com.hibu.testscript.main.Main_LeadConvert;
import com.hibu.testscript.main.Main_QuoteSubmission;
import com.hibu.testscript.main.Main_SAMIFF;

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
		Main_LeadConvert lead = new Main_LeadConvert();
		//lead.main(4546);
		
		Main_QuoteSubmission quote = new Main_QuoteSubmission();
		//quote.main(4546);
		
		Main_DomainProvisioning domainProvision = new Main_DomainProvisioning();
		//domainProvision.main(0);
		
		Main_DomainProvisioningAndPublishing publishing = new Main_DomainProvisioningAndPublishing();
		//publishing.main(0);
		
		Main_SAMIFF ff = new Main_SAMIFF();
		ff.main(0);
		
		
		
	}

}
