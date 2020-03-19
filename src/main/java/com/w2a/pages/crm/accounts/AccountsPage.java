package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class AccountsPage extends Page{
	
	public CreateAccountPage goTocreateAccounts() {
		
		driver.findElement(By.cssSelector("button[data-zcqa='cv_createbtn']")).click();
		return new CreateAccountPage();
		
	}
	
	public void goToImportAccounts() {
		
	}

}
