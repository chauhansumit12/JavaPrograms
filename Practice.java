import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice {

	public static  WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		  Properties prop = new Properties();
		    InputStream input = null;

		    try {

		        input = new FileInputStream("config.properties");

		        // load a properties file
		        prop.load(input);

		        // get the property value and print it out
		        
		        System.out.println(prop.getProperty("German"));
		       //String chineseLocale=prop.getProperty("Chinese");

		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (input != null) {
		            try {
		                input.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		
		
	initializeSelenium(prop.getProperty("German"));
	driver.get("https://www.google.com/");
	
	
	
	
	}


	public static WebDriver getDriver(String locale){   
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sc16569\\eclipse-workspace\\drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--lang=" + locale);
	    return new ChromeDriver(options);
	}

	public static void initializeSelenium(String langlocale) throws Exception{
	  
		driver = getDriver(langlocale); // two letters to represent the locale, or two letters + country
	}




}
