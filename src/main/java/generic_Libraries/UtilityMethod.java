package generic_Libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityMethod {
	
	public static String getProperty(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commanData.properties");
		
		Properties p=new Properties();
		p.load(fis);
		
		String property=p.getProperty(key);
		return property;
	}

}
