package com.splitemailaddress.emailidspliter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.splitemailaddress.emailidgenrator.EmailIdGenerator;

/**
 * @author Jerin.Constant
 *
 */
public class SplitEmailIdsExtra {
	
	public static void sendMailForDownTime(String emailDistributionList, String toAddress, int noOfEmailIds, String env, int splitSize)
	{
		List<String> to = new ArrayList<String>();
		if(emailDistributionList != null && emailDistributionList.length() > 0)
			to.addAll(Arrays.asList(emailDistributionList.split(",")));
		try {
				List<String> emailIds = EmailIdGenerator.toEmailList(toAddress, noOfEmailIds);
				if(emailIds != null && emailIds.size() > 0)
				{
					to.addAll(emailIds);
					/*System.out.println("Inside first if: "+to.toString());*/
				}
				
				if(to.isEmpty() || (to.size() == 1 && to.contains("ifx.marlabs@gmail.com")))
				{
					to.clear();
					to.add("gp4_support@marlabs.com");					
				}
				if(env.equals("QA")){
					to.clear();
					to.add("gp4_support@marlabs.com");
					if(emailDistributionList != null && emailDistributionList.length() > 0)
						to.addAll(Arrays.asList(emailDistributionList.split(",")));
				}
				else if(env.equals("UAT"))
				{
					to.clear();
					to.add("gp4_support@marlabs.com");
					to.add("gpsupport@gategourmet.com");
					if(emailDistributionList != null && emailDistributionList.length() > 0)
						to.addAll(Arrays.asList(emailDistributionList.split(",")));
				}
				else if(env.equals("PROD"))
				{
//					nothing to be done with to list
				}
				
			
				SplitEmailListString.splitEmailsList(to, splitSize);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
