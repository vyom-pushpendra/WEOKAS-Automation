package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import vYomBase.BaseClass;
import vYomUtilities.waitUtility;

public class loginPage extends BaseClass {

	WebDriver driver;
	waitUtility wait;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);

	}


	By emailTextbox = By.id("login-email");
	By termsButton = By.xpath("//button[2]//p[1]");
	By loginButton = By.xpath("//span[text()='Log in']");
	// By otpField = By.xpath("//input");
	By otpField = By.xpath("//input[@inputmode='numeric']");

	By verifyButton = By.xpath("//span[text()='Verify']");

	By userLogin = By.xpath("//p[text()='P']");

	By logOut = By.xpath("//button[normalize-space()='Log Out']");

	By confirm = By.xpath("//button[text()=\"Log Out\"]");

	By logoutSuccessfully = By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-right']");

	public void enterEmail(String email) {

		driver.findElement(emailTextbox).clear();
		driver.findElement(emailTextbox).sendKeys(email);
	
	
		
	}

	public void clickTerms() {
		driver.findElement(termsButton).click();

	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void enterOTP(String otp) {
		driver.findElement(otpField).sendKeys(otp);

	}

	public void clickVerify() throws InterruptedException {

		driver.findElement(verifyButton).click();

		
    System.out.println(" Login successful");
    System.out.println("Successfully navigate on Home page");
    
 // Get actual page title
    String actualTitle = driver.getTitle();

    
        // Expected home page title
    String expectedTitle = "Signature";

    // Verify title
    Assert.assertEquals(actualTitle, expectedTitle,
            "Home Page title is not matching!");
    
    
    System.out.println("Welcome to the Home Page "+">>>>>>>>>>>>>>>>>>>>"+ expectedTitle +"<<<<<<<<<<<<<<<<<<<<<");
	

	}

}
