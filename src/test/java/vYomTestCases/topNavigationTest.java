package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.topNavigationPage;
import vYomUtilities.emailOtpReader;
import vYomPages.topNavigationPage;

public class topNavigationTest extends BaseClass {

	@Test(priority = 1)

	public void login() throws Exception {

		loginPage loginPage = new loginPage(driver);

		// Enter Email
		loginPage.enterEmail(config.getEmail());

		// Accept Terms & Conditions
		loginPage.clickTerms();

		// Click Login Button
		loginPage.clickLogin();

		// Wait for OTP Mail
		Thread.sleep(10000);

		// Read OTP from Gmail
		String otp = emailOtpReader.getOTP();

		System.out.println("OTP = " + otp);

		// Enter OTP
		loginPage.enterOTP(otp);

		Thread.sleep(15000);

		// Click Verify
		loginPage.clickVerify();

		Thread.sleep(15000);

		// User Verify
		System.out.println("Login Successful");

	}

	@Test(priority = 2)
	public void verifyTopNavigationBarFunctionality() throws InterruptedException {

		topNavigationPage topNavigationBarPage = new topNavigationPage(driver);

		// Notification Icon
		topNavigationBarPage.clickNotificationIcon();
		
		Thread.sleep(1000);
		
		topNavigationBarPage.clickMarkAllAsReadIfAvailable();
		
		Thread.sleep(1000);
		// Profile Icon

		topNavigationBarPage.clickProfileIcon();
		
		Thread.sleep(1000);
		// Search
		topNavigationBarPage.enterSearchText("Test");
		
		Thread.sleep(1000);
		
		topNavigationBarPage.enterInvalidProject("Neha");
		
		Thread.sleep(1000);
		
		

	}
}