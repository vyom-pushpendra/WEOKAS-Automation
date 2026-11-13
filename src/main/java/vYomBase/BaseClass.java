package vYomBase;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import vYomUtilities.extentManager;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import vYomUtilities.readConfig;

public class BaseClass {

	///// remove this line
	///// public WebDriver driver;
	public static WebDriver driver;

	//// use only protected
	protected readConfig config;

	@BeforeClass
	public void setup() throws IOException {

		config = new readConfig();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(config.getUrl());
	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}}
