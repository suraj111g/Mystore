package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.pageobject.RegisterPage;

@Test
public class TS01_RegistrationFunctionalityTest extends BaseClass {

	@Test(priority = 0)
	public void verifyUserRegistration() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.selgender();
		page.enterFirstname("abc");
		page.enterLastname("abc");
		page.enterEmail(generateRandomEmailid()+"@gmail.com");
		page.selectDay();
		page.selectMonth();
		page.selectYear();
		page.enterPwd("123456ayi");
		page.enterConfirmpwd("123456ayi");
		page.selectRegisterButton();
		//String actualmsg = page.verificationMessage();
		//String expectedmsg = "Your registration completed";
		//assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}

	@Test(priority = 1)
	public void verifyFirstnameWithBlankData() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.enterFirstname1();
		String actualmsg = page.errorMsg();
		String expectedmsg = "First name is required.";
		Assert.assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}

	@Test(priority = 2)
	public void verifylastnameWithBlankData() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.enterlastname1();
		String actualmsg = page.errorMsg1();
		String expectedmsg = "Last name is required.";
		Assert.assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}
	
	@Test(priority = 3)
	public void verifyEmailWithBlankData() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.enterOnEmailfield();
		String actualmsg = page.errorMsg2();
		String expectedmsg = "Email is required.";
		Assert.assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}
	
	@Test(priority = 4)
	public void verifyPasswordWithBlankData() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.enterOnPasswordfield();
		String actualmsg = page.errorMsg3();
		String expectedmsg = "Password is required.";
		Assert.assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}
	
	@Test(priority = 5)
	public void verifyConfirmPasswordWithBlankData() {

		driver.get(url);
		RegisterPage page = new RegisterPage(driver);
		page.clickOnloginButton();
		page.clickOnRegisterButton();
		page.enterOnConfirmPasswordfield();
		String actualmsg = page.errorMsg4();
		String expectedmsg = "Password is required.";
		Assert.assertEquals(actualmsg, expectedmsg, "Result mistmatch");

	}
}
