package gmail.utils;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	private final static Logger LOGGER = Logger.getLogger(Browser.class);

    public static WebDriver driver;
    private static String driverPath = "src\\main\\resources\\drivers\\";
    private static String chromeDriverPath = driverPath + "chromedriver_win_x32_2_17.exe";

    
    public static WebDriver getInstance() {
		if(null == driver){
			driver = new ChromeDriver();
		}
    	return driver;
	}

    public static void closeDriver(){
    	driver.quit();
    	driver = null;
    }
    
    
    public static WebDriver initChromeBrowser() {
       	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
       	driver = Browser.getInstance();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		LOGGER.info("Browser started");
      return driver;
    }
    
    
  
}