package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class CreateAccountTest {

	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void createAccountTest(Hashtable<String, String> data) throws InterruptedException {
     
		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		AccountsPage ap = Page.menu.goToAccounts();

		CreateAccountPage cap = ap.goTocreateAccounts();

		cap.createAccount(data.get("accountName"));
		Assert.fail("Create account failed");

	}

}
