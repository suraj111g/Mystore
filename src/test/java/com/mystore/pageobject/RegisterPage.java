package com.mystore.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver ldriver;

	public RegisterPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	//// Test case 01-Verify Registration of User ////
	
	@FindBy(xpath = "//div[@class='header-links']//li//a[text()='Log in']")
	WebElement loginbtn;

	@FindBy(xpath = "//div[@class='buttons']//child::button[@type='button']")
	WebElement button;

	@FindBy(id = "gender-male")
	WebElement selgender;

	@FindBy(name = "FirstName")
	WebElement enterfisrtname;

	@FindBy(name = "LastName")
	WebElement enterlastname;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']//following::option[@value='21']")
	WebElement selday;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']//following::option[contains(text(),'Februar')]")
	WebElement selmonth;

	@FindBy(xpath = "//select[@name='DateOfBirthYear']//following::option[@value='1989']")
	WebElement selyear;

	@FindBy(id = "Email")
	WebElement enteremail;

	@FindBy(id = "Password")
	WebElement enterPassword;

	@FindBy(id = "ConfirmPassword")
	WebElement enterconfirmpwd;

	@FindBy(xpath = "//button[@name='register-button']")
	WebElement selbutton;

	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
	WebElement result;
	
	public void clickOnloginButton() {
		loginbtn.click();
	}

	public void clickOnRegisterButton() {
		button.click();
	}

	public void selgender() {
		selgender.click();
	}

	public void enterFirstname(String fisname) {
		enterfisrtname.sendKeys(fisname);
	}

	public void enterLastname(String lasname) {
		enterlastname.sendKeys(lasname);
	}

	public void selectDay() {
		selday.click();
	}

	public void selectMonth() {
		selmonth.click();
	}

	public void selectYear() {
		selyear.click();
	}

	public void enterEmail(String mail) {
		enteremail.sendKeys(mail);
	}

	public void enterPwd(String pwd) {
		enterPassword.sendKeys(pwd);
	}

	public void enterConfirmpwd(String confpwd) {
		enterconfirmpwd.sendKeys(confpwd);
	}

	public void selectRegisterButton() {
		selbutton.click();
	}

	public String verificationMessage() {
		return result.getText();
	}

//// Test case 02- verify firstname field without blank details ////

	@FindBy(xpath = "//div[@class='inputs']/span[2]/span[contains(text(),'First name is required')]")
	WebElement errormsg;

	public void enterFirstname1() {
		enterfisrtname.sendKeys(Keys.ENTER);
	}

	public String errorMsg() {
		return errormsg.getText();
	}

	//// Test case 03- verify lastname field without blank details ////

	@FindBy(xpath = "//div[@class='inputs']/span[2]/span[contains(text(),'Last name is required')]")
	WebElement errormsg1;

	public void enterlastname1() {
		enterlastname.sendKeys(Keys.ENTER);
	}

	public String errorMsg1() {
		return errormsg1.getText();
	}
	
////Test case 04- verify email field without blank details ////

	@FindBy(xpath = "//div[@class='inputs']/span[2]/span[contains(text(),'Email is required.')]")
	WebElement errormsg2;

	public void enterOnEmailfield() {
		enteremail.sendKeys(Keys.ENTER);
	}

	public String errorMsg2() {
		return errormsg2.getText();
	}
	
////Test case 05- verify password field without blank details ////

	@FindBy(xpath = "//div[@class='inputs']/span[2]/span[contains(text(),'Password is required.')]")
	WebElement errormsg3;

	public void enterOnPasswordfield() {
		enterPassword.sendKeys(Keys.ENTER);
	}

	public String errorMsg3() {
		return errormsg3.getText();
	}
	
////Test case 05- verify confirm password field without blank details ////

	@FindBy(xpath = "//div[@class=\"fieldset\"]//div[@class='form-fields']//div[@class=\"inputs\"]//span[@id='ConfirmPassword-error']")
	WebElement errormsg4;

	public void enterOnConfirmPasswordfield() {
		enterconfirmpwd.sendKeys(Keys.ENTER);
	}

	public String errorMsg4() {
		return errormsg4.getText();
	}
}