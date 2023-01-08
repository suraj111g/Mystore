package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static // create object of readconfig
	ReadConfig readconfig = new ReadConfig();
	static // store value in string url and browser
	String url = readconfig.GetUrl();
	String browser = readconfig.GetBrowser();

	// create static driver variable
	public static WebDriver driver;

	// create logger variable
	public static Logger logger;

	// for screenshot folder

	public static String screenshotfolder;

	// setup of driver for launching browser
	@BeforeClass()
	public void setup() {

		String browser = "chrome";
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;

		}
		// apply maximize and wait for all webelements
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// initilized the logger
		logger = LogManager.getLogger(BaseClass.class);
		
		driver.get(url);
		logger.info("url is open succesfully");
	}
	/*
	 * @AfterTest public void Screenshot(ITestResult result) throws IOException {
	 * if(result.getStatus()==ITestResult.FAILURE) {
	 * CaptureScreenshots(result.getMethod().getMethodName()+".jpg"); } }
	 */

	public void CaptureScreenshots(String filepath) {

		if (screenshotfolder == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			screenshotfolder = myDateObj.format(myFormatObj);
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshots/" + screenshotfolder + "/" + filepath);
		try {
			FileUtils.copyFile(sourcefile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot save succesfully");
	}

	
	public String generateRandomEmailid() {
		return RandomStringUtils.randomAlphanumeric(7);
	}

	// close the browser method
	// @AfterClass
	/*
	 * public void teardown() {
	 * 
	 * driver.close(); driver.quit();
	 */
	// }

}
