package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Shravan
 *
 */


public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */

	public String getPropertyFromKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstant.propertiesPath);
		
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}
	

}
