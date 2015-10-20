package com.splitemailaddress.emailidsplitermain;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.splitemailaddress.emailidgenrator.EmailIdGenerator;
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
		
		String EMAIL_ID = "scarlatkn8@gmail.com";
		//System.out.println(EmailIdGenerator.toEmailListStringBuilder(EMAIL_ID, 2000));
		
		String toAddressList = EmailIdGenerator.toEmailListString(EMAIL_ID, 2000);
		List<String> toList = EmailIdGenerator.toEmailList(EMAIL_ID, 2000);
		SplitEmailListString.splitEmailsList(toList,400);
		//String toAddressList = EmailIdGenerator.toEmailListStringBuilder(EMAIL_ID, 2000);
		//SplitEmailListString.splitEmailList(toAddressList);
		System.out.println("Done");
		
		Long finishTime = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		
		Long durationMs = TimeUnit.NANOSECONDS.toMillis(finishTime-startTime);
		
		System.out.println("Execution Time: "+durationMs+"ms");

	}

}
