package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author aniket
 */
public class FileUtility {
	/**
	 * This method is used to read data from property file
	 * by taking key from the caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
public String getDataFromProperty(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);//Here we are letting the user to decide ,which data he wants to fetch
}
}
