package com.splitemailaddress.emailidspliter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jerin.Constant
 *
 */
public class SplitEmailListString {

	public static void splitEmailList(String to) {
		boolean flag = false;
		long count = to.split(",").length / 400;
		/*System.out.println("Count: "+count);*/
		int lastsize = to.split(",").length % 400;
		System.out.println("Lastsize :"+lastsize);
		if (lastsize > 0)
			count++;
		System.out.println("Count: "+count);
		String[] toArr = new String[400];
		try {
			for (int i = 1; i <= count; i++) {
				if (i == count) {
					if (count == 1) {
						toArr = (to.toString().split(",", lastsize));
						/*for(String x : toArr)
							System.out.println("First if's if: "+x);*/
					} else {
						toArr = toArr[toArr.length - 1].split(",", lastsize);
						/*for(String x : toArr)
							System.out.println("First if's Else: "+x);*/
					}
				} else if (i == 1) {
					toArr = (to.toString().split(",", 401));
					flag = true;
					/*for(String x : toArr)
						System.out.println("Else if: "+x);*/
				} else {
					toArr = toArr[toArr.length - 1].split(",", 401);
					flag = true;
					//System.out.println("To array length - 1 = "+(toArr.length - 1));
					/*for(String x : toArr)
						System.out.println("Else: "+x);*/
				}

				/*if(flag)
				{
					if(!sendMail(Arrays.copyOf(ArrayUtils.remove(toArr, toArr.length-1), (ArrayUtils.remove(toArr, toArr.length-1)).length, String[].class)))
					{
						System.out.println("Success");
					}
					flag = false;
				}
				else
				{
					if(!sendMail(toArr))
					{
						System.out.println("Success");
					}
				}*/
				if(flag)
				{
					if(!sendMail(Arrays.copyOf(toArr, toArr.length-1)))
					{
						System.out.println("Success");
					}
					flag = false;
				}
				else
				{
					if(!sendMail(toArr))
					{
						System.out.println("Success");
					}
				}	
				/*System.out
						.println("splitEmailsAndSendMail -- Address setting in for loop -- iteration :"
								+ i);*/

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 	
	public static void splitEmailsListCustom(String to){
		
	}
	
	public static void splitEmailsList(List<String> to, int splitSize)
	{
		Long count = (long) (to.size()/splitSize);
		int lastSize = to.size()%splitSize;
		if(lastSize > 0)
			count++;
		System.out.println("Count: "+count);
		System.out.println("Last size: "+lastSize);
		String[] toArr = new String[splitSize];
		try {
			for(int i = 1; i <= count; i++)
			{
				if(i == count)
				{
					toArr = to.subList((i-1)*splitSize, to.size()).toArray(new String[(to.subList((i-1)*splitSize, to.size())).size()]);
					//System.out.println("IF: "+to.subList((i-1)*splitSize, to.size()));
				}
				else
				{
					toArr = to.subList((i-1)*splitSize, ((i-1)*splitSize)+splitSize).toArray(new String[(to.subList((i-1)*splitSize, ((i-1)*splitSize)+splitSize)).size()]);
					//System.out.println("Else: "+to.subList((i-1)*splitSize, ((i-1)*splitSize)+splitSize));
				}
				
				if(!sendMail(toArr))
				{
					/*System.out.println("---------------Success---------------");*/
				}

			}
		} catch (Exception e) {
			
		}
	}
	
	public static boolean sendMail(String[] to)
	{
		/*for(String x : to)
			System.out.println("To email ids: "+x);*/	
		/*System.out.println("First index: "+to[0]);
		System.out.println("Last index: "+to[to.length-1]);*/
		return false;
	}
	
	
	/*private void splitEmailsAndSendMail(MimeMessage mimeMessage,String from,String to,String subject,String message,byte[] attachmentByteArr,String localPath,String fileName){
		logger.log(Level.INFO, "splitEmailsAndSendMail start");
		logger.log(Level.INFO, "Total no.of mails:"+to.split(",").length);
		long count =  to.split(",").length/400;
		int lastsize = to.split(",").length%400;
		if(lastsize > 0)
			count++;
		String[] toArr = new String[400];
		String[] finalToArr = new String[400];
		try{
			for(int i=1;i<=count;i++){
				if(i == count){
					if(count == 1){
						finalToArr = (to.toString().split(",",lastsize));
						toArr = (to.toString().split(",",lastsize));
					}else{
						finalToArr = toArr[toArr.length-1].split(",",lastsize);
						toArr = toArr[toArr.length-1].split(",",lastsize);
					}
				}else if(i == 1){
					toArr = (to.toString().split(",",401));
					copyToFinalArr(toArr,finalToArr);
				}else{
					toArr = toArr[toArr.length-1].split(",",401);
					copyToFinalArr(toArr,finalToArr);
				}
				
				logger.log(Level.INFO, "splitEmailsAndSendMail -- Address setting start for -- iteration :"+i);
				
				if(!sendMail(mimeMessage,from,finalToArr,subject,message,attachmentByteArr,localPath,fileName))
					throw new Exception("splitEmailsAndSendMail -- Exception Occured While Sending Mail");
				
				logger.log(Level.INFO, "splitEmailsAndSendMail -- Address setting end for -- iteration :"+i);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(localPath != null){
			try{
				File file = new File(localPath+fileName);
				file.delete();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.log(Level.INFO, "splitEmailsAndSendMail end");
	}*/
	
}
