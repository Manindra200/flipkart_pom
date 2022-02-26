package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.Testbase;
import com.flipkart.qa.page.Loginpage;

public class HomePage extends Testbase {
	Loginpage  loginpage; 
	
	
@BeforeMethod
public void setUp() {
	initialization();
	loginpage = new Loginpage(driver);
}

@SuppressWarnings("deprecation")
@Test
public void loginPageTest() {
	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	String expectedTitle = loginpage.validateLoginPagetitle();
	String actualTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	Assert.assertEquals(expectedTitle, actualTitle);
}


@AfterMethod
public void teardown() {
	driver.quit();
}
}
