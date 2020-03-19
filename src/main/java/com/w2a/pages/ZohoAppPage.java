package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;

public class ZohoAppPage extends Page {

	public CRMHomePage goToCRM() {
		click("CRMLink_CSS");

		return new CRMHomePage();

	}

}
