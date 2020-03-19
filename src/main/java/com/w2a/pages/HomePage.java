package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class HomePage extends Page {
	
	
	
	public void goToSupport() {
		driver.findElement(By.cssSelector(".zh-support")).click();
	}
	
	public LoginPage goToLogin() {
		click("loginLink_CSS");
		return new LoginPage();
	}
	
	public void goToSignup() {
		driver.findElement(By.cssSelector(".zh-signup")).click();;
	}


}
