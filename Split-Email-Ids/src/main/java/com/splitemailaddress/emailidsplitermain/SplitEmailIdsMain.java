package com.splitemailaddress.emailidsplitermain;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.splitemailaddress.emailidgenrator.EmailIdGenerator;
import com.splitemailaddress.emailidspliter.SplitEmailIdsExtra;
import com.splitemailaddress.emailidspliter.SplitEmailListString;

/**
 * @author Jerin.Constant
 *
 */
public class SplitEmailIdsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Long startTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		
		String EMAIL_ID1 = "scarlatkn8@gmail.com";
		String EMAIL_ID2 = "testme_101@marlabs.com";
		String EMAIL_ID3 = null;
		String EMAIL_ID4 = "ifx.marlabs@gmail.com";
		String EMAIL_IDS = "MOruganti@gategroup.com,RReinsma@gategroup.com,sean.hennessy@marlabs.com,Harikrishnan.Kurup@marlabs.com,Gp4_Support@marlabs.com,gpsupport@gategourmet.com,Jboss-Support@marlabs.com,Dba-Support@marlabs.com";
		//System.out.println(EmailIdGenerator.toEmailListStringBuilder(EMAIL_ID, 2000));
		
		String toAddressList = EmailIdGenerator.toEmailListString(EMAIL_ID2, 2);
		List<String> toList = EmailIdGenerator.toEmailList(EMAIL_ID1, 1000);
		//SplitEmailListString.splitEmailsList(toList,400);
		//String toAddressList = EmailIdGenerator.toEmailListStringBuilder(EMAIL_ID2, 0);
		//SplitEmailListString.splitEmailList(toAddressList);
		
		SplitEmailIdsExtra.sendMailForDownTime(EMAIL_ID3, EMAIL_ID2, 2000, "DEV", 400);
		System.out.println("Done");
		
		Long finishTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		
		Long durationMs = TimeUnit.NANOSECONDS.toMillis(finishTime-startTime);
		
		System.out.println("Execution Time: "+durationMs+"ms");

	}

}
