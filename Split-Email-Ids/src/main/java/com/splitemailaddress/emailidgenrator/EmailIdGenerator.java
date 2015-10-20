package com.splitemailaddress.emailidgenrator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerin.Constant
 *
 */
public class EmailIdGenerator 
{
	@SuppressWarnings("unused")
	private String EMAIL_ID = "scarlatkn8@gmail.com";
	
	public static String toEmailListString(String toAddress, int noOfEmailIds)
	{
		List<String> emailIds = new ArrayList<String>();
		int count = 0;
		while(count<noOfEmailIds)
		{
			count++;
			emailIds.add(count+toAddress);
		}
		
		StringBuffer mailIds = new StringBuffer("");
		
		if(emailIds != null && emailIds.size() > 0)
			mailIds = new StringBuffer((emailIds.toString()).substring(1, emailIds.toString().length()-1));
		
		if(mailIds!=null && !mailIds.equals(""))
			return mailIds.toString();
		else 
			return null;
		
	}
	
	public static List<String> toEmailList(String toAddress, int noOfEmailIds)
	{
		List<String> emailIds = new ArrayList<String>();
		int count = 0;
		while(count<noOfEmailIds)
		{
			count++;
			emailIds.add((count+"--"+toAddress));
		}
		
		return emailIds;
	}
	
	public static String toEmailListStringBuilder(String toAddress, int noOfEmailIds)
	{
		List<String> emailIds = new ArrayList<String>();
		int count = 0;
		while(count<noOfEmailIds)
		{
			count++;
			emailIds.add(count+"-"+toAddress);
		}
		
		StringBuilder mailIds = new StringBuilder();
		
		if(emailIds != null && emailIds.size() > 0)
			mailIds = new StringBuilder((emailIds.toString()).substring(1, emailIds.toString().length()-1));
		
		if(mailIds!=null && !mailIds.equals(""))
			return mailIds.toString();
		else 
			return null;
	}
	
	public static List<String> toEmailStringList(String toAddress, int noOfEmailIds)
	{
		List<String> emailIds = new ArrayList<String>();
		int count = 0;
		while(count<noOfEmailIds)
		{
			count++;
			emailIds.add(toAddress);
		}
		
		if(emailIds != null && emailIds.size() > 0)
			return emailIds;
		else
			return null;
		
	}
}
