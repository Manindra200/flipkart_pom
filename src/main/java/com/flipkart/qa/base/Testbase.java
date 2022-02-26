package com.flipkart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.qa.util.Testutil;

public class Testbase {
	public	static WebDriver driver;
	public	static Properties prop;

	public Testbase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Testing_Engineer\\flipkart_pom\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {


		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Testing_Engineer\\flipkart_pom\\TestData\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
