package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.dashboardPageOnSupportAndHelp;
import vYomPages.loginPage;
import vYomUtilities.emailOtpReader;

public class dashboardPageOnSupportAndHelpTest extends BaseClass {

	@Test
	public void verifySupportAndHelpMenu() throws Exception {

//        
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

	////////////////	// Dashboard Page Object/////////////////////////
		dashboardPageOnSupportAndHelp dashboard = new dashboardPageOnSupportAndHelp(driver);

		// Verify Logo Before Scroll
		Assert.assertTrue(dashboard.isLogoDisplayed(), "Sticky Logo is not displayed");

		System.out.println("Logo Name : " + dashboard.getLogoName());

		System.out.println("Sticky Logo verified successfully");

		// Scroll Page
		dashboard.scrollPage();
		Thread.sleep(2000);

		// Verify Logo After Scroll
		Assert.assertTrue(dashboard.isLogoDisplayed(), "Sticky Logo disappeared after scrolling");

		System.out.println("Logo After Scroll : " + dashboard.getLogoName());

		System.out.println("Sticky Logo is visible after scrolling");

		// Verify Support Menu
		Assert.assertTrue(dashboard.isMenuDisplayed("Support"), "Support menu is not displayed");

		System.out.println("Support menu verified successfully");

		// Verify Help Menu
		Assert.assertTrue(dashboard.isMenuDisplayed("Help"), "Help menu is not displayed");

		System.out.println("Help menu verified successfully");

		// Verify Help is below Support
		Assert.assertTrue(dashboard.isHelpBelowSupport(), "Help should be displayed below Support");

		System.out.println("Help is displayed below Support");

		System.out.println("Sticky Logo, Support and Help menus verified successfully");
	}
}