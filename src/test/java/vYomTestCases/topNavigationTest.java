package vYomTestCases;

import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.topNavigationPage;
import vYomUtilities.emailOtpReader;

public class topNavigationTest extends BaseClass {

	@Test
	public void verifyTopNavigationBar() throws Exception {

		// Login
		loginPage loginPage = new loginPage(driver);

		loginPage.enterEmail(config.getEmail());

		loginPage.clickTerms();

		loginPage.clickLogin();

		Thread.sleep(10000);

		// Read OTP from Gmail
		String otp = emailOtpReader.getOTP();

		System.out.println("OTP = " + otp);

		loginPage.enterOTP(otp);

		Thread.sleep(15000);

		loginPage.clickVerify();

		Thread.sleep(15000);

		System.out.println("Login Successful");
///////////////////////////////////////////////////////////////////////////////////
		topNavigationPage nav = new topNavigationPage(driver);

		nav.clickNotification();
		
		System.out.println("Scroll");
		

	}
}