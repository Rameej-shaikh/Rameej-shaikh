package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
public static String getValeForKey(String key) throws  Throwable
{
	Properties config = new Properties();
	config.load(new FileInputStream("./PropertyFiles/Envirornment.properties"));
	return config.getProperty(key);
	
}

}
