package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.verifyProjectListingPage;
import vYomUtilities.emailOtpReader;

public class VerifyProjectListingTest extends BaseClass {

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage loginPage = new loginPage(driver);

		loginPage.enterEmail(config.getEmail());
		loginPage.clickTerms();
		loginPage.clickLogin();

		Thread.sleep(10000);

		String otp = emailOtpReader.getOTP();

		System.out.println("OTP = " + otp);

		loginPage.enterOTP(otp);

		Thread.sleep(15000);

		loginPage.clickVerify();

		Thread.sleep(15000);

		System.out.println("Login Successful");
	}

	@Test(priority = 2)
	public void verifyProjectList() {

		verifyProjectListingPage page = new verifyProjectListingPage(driver);

		page.clickOnProjectOnHomePage();

		page.printProjectDetails();

		System.out.println("Project List Verified Successfully");
	}

	@Test(priority = 3)
	public void verifyValidProjectSearch() {

		verifyProjectListingPage page = new verifyProjectListingPage(driver);

		page.searchProject("Testing user");

		Assert.assertTrue(page.isProjectDisplayed("Testing user"));

		System.out.println("Valid Project Search Verified");
	}

	@Test(priority = 4)
	public void verifyInvalidProjectSearch() {

		verifyProjectListingPage page = new verifyProjectListingPage(driver);

		page.clickOnProjectOnHomePage();

		page.searchInvalidProject("New Project");

		System.out.println("Invalid Project Search Verified");
	}

	@Test(priority = 5)
	public void verifyFilters() {

		verifyProjectListingPage page = new verifyProjectListingPage(driver);

		page.verifyFilters();

		System.out.println("Filters Verified Successfully");

	}
}