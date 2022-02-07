package com.vtiger.comcast.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 *  this class contains java specific generic libraries  
 * @author Shravan
 *
 */

public class JavaUtility {
	/**
	 *   its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return intData
	 */

	public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
	}
	
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	public String getSystemDate() {
		Date dateObj = new Date();
		int date = dateObj.getDate();
		int month = dateObj.getMonth() + 1;
		String year = dateObj.toString().split(" ")[5];

		String formate = year + "-" + month + "-" + date;
		
		return formate;
		
	}
	public String getDateAndTime() {
		Date dateObj = new Date();
		String dateFormat = dateObj.toString().replace(":", "_").replace(" ", "_");
		return dateFormat;
	}

}
