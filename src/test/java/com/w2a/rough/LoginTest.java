package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        HomePage hp = new HomePage();
        LoginPage lp = hp.goToLogin();
       
        ZohoAppPage zp = lp.doLogin("ashwin.karkera28@gmail.com", "sujatha@123");
         
        zp.goToCRM();
        AccountsPage ap = Page.menu.goToAccounts();
    
        CreateAccountPage cap = ap.goTocreateAccounts();
       
        cap.createAccount("Raman");
        
	}

}
