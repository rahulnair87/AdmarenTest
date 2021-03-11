package com.admaren.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.admaren.qa.utils.Constants;
import com.admaren.qa.utils.GeneralUtils;


public class BaseTest {
	
	public static Properties prop;
	public static WebDriver driver;
	public static String testCaseName;
	
	public BaseTest(){
		
		try {
			File file = new File(System.getProperty("user.dir")+"/src/main/java/com/admaren/qa/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			GeneralUtils.printExceptionMessage(e);
		}
	}
	
	public void initialize(){
		
		String browser = prop.getProperty("browser").trim();
		switch(browser){
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
			
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Browser selection is not valid. Exit test");
			System.exit(0);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constants.ImplicitWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.PageLoadTimeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
