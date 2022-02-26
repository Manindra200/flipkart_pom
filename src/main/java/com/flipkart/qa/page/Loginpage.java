package com.flipkart.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.Testbase;

public class Loginpage extends Testbase{
//page factory - OR
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")	
	WebElement loginPage_username;
	@FindBy(xpath="//input[@type='password']")
	WebElement loginPage_password;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginPage_button;
	
	
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  String validateLoginPagetitle() {
		return driver.getTitle();
	}
	
	public void login(String username,String password) {
		loginPage_username.sendKeys(username);
		loginPage_password.sendKeys(password);
		loginPage_button.click();
		
		//return Homepage();
	}

	
}
