package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.LoginPage;

public class TS02_LoginFunctionalityTest extends BaseClass{
	@Test(priority = 1)
	public void verifyLoginWithValidData() {

		driver.get(url);
		LoginPage loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		String actualurl=driver.getTitle();
		String expectedurl="nopCommerce demo store. Login";
		Assert.assertEquals(actualurl, expectedurl, "URL is mistmatch");
		loginpg.enterEmailAddress("suraj12345@gmail.com");
		loginpg.enterPassword("suraj12345");
		loginpg.clickOnLoginButton1();
		String actualmsg=loginpg.getWelcomeMsg();
		String expectedmsg="Welcome to our store";
		Assert.assertEquals(actualmsg, expectedmsg , "Welcome msg mistmatch");
		loginpg.clickOnLogoutButton();
		
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidData() {

		//driver.get(url);
		LoginPage loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		loginpg.enterEmailAddress("xyz123g@gmail.com");
		loginpg.enterPassword("xyz123");
		loginpg.clickOnLoginButton1();
		String actualmsg=loginpg.getWarningMsg();
		String expectedmsg="No customer account found";
		Assert.assertEquals(actualmsg, expectedmsg , "Welcome msg mistmatch");
		
		
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidDataWithValidEmailOnly() {

		//driver.get(url);
		LoginPage loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		loginpg.enterEmailAddress("suraj111g@gmail.com");
		loginpg.enterPassword("xyz1234");
		loginpg.clickOnLoginButton1();
		String actualmsg=loginpg.getWarningMsg();
		String expectedmsg="No customer account found";
		Assert.assertEquals(actualmsg, expectedmsg , "Welcome msg mistmatch");
		
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidDataWithValidPasswordOnly() {

		//driver.get(url);
		LoginPage loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		loginpg.enterEmailAddress("xyz123456@gmail.com");
		loginpg.enterPassword("suraj123");
		loginpg.clickOnLoginButton1();
		String actualmsg=loginpg.getWarningMsg();
		String expectedmsg="No customer account found";
		Assert.assertEquals(actualmsg, expectedmsg , "Welcome msg mistmatch");
		
	}
	@Test(priority = 5)
	public void verifyLoginWithBlankDataInEmailField() {

		//driver.get(url);
		LoginPage loginpg = new LoginPage(driver);
		loginpg.clickOnLoginButton();
		loginpg.enterEmailAddress("");
		loginpg.enterPassword("");
		loginpg.clickOnLoginButton1();
		
	}
}
