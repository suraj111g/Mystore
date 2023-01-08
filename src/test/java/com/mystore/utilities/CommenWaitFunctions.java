package com.mystore.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.mystore.testcases.BaseClass;

public class CommenWaitFunctions extends BaseClass{
	   // Waiting 30 seconds for an element to be present on the page, checking
	   // for its presence once every 5 seconds.
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5))
	       .ignoring(NoSuchElementException.class);

	   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       WebElement linkelement =driver.findElement(By.xpath("//div[@class='topic-block-title']//h2[text()='Welcome to our store']"));
	       linkelement.getText();
		   return linkelement;

	     }
	   });


}
