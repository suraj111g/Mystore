package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='header-links']//li//a[text()='Log in']")
	WebElement loginbtn;

	@FindBy(xpath = "//div[@class='form-fields']//div[1]//input[@class='email']")
	WebElement emailfield;

	@FindBy(xpath = "//div[@class='form-fields']//div[2]//input[@class='password']")
	WebElement pwdfield;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginbtn1;

	@FindBy(xpath = "//div[@class='topic-block-title']//h2[text()='Welcome to our store']")
	WebElement welcomemsg;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutbtn;

	public void clickOnLoginButton() {
		loginbtn.click();
	}

	public void enterEmailAddress(String emailid) {
		emailfield.sendKeys(emailid);
	}

	public void enterPassword(String pwd) {
		pwdfield.sendKeys(pwd);
	}

	public void clickOnLoginButton1() {
		loginbtn1.click();
	}

	public String getWelcomeMsg() {
		WebDriverWait wait=new WebDriverWait(ldriver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(welcomemsg));
		return element.getText();

	}
	
	public void clickOnLogoutButton() {
		logoutbtn.click();
	}
////////TC warning message for invalid details from user//////
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//child::ul//li[text()='No customer account found']")
	WebElement warningmsg;
	
	public String getWarningMsg() {
		return warningmsg.getText();

	}

}
