package vYomTestCases;

import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.projectListingPage;

import org.testng.Assert;
import vYomUtilities.emailOtpReader;

public class projectListingPageTest extends BaseClass {

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

	public void project_list() throws InterruptedException {

		projectListingPage project = new projectListingPage(driver);

		project.click_projects_menu();

		project.get_project();
		
		project.serchAndVerify();
		
		project.clcikOnFilters();
		
	

	}

}
