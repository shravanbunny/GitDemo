package commongenericdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {
	
	public String getDataFromProperty(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("E:\\OCSE5\\DataStorage\\CommonData.properties");
		
		Properties pobj= new Properties();
		
		pobj.load(fis);
		
		return pobj.getProperty(key);
		
	}

	
}
