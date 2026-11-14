package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.verifySearchFilterOnProjectListingPage;
import vYomUtilities.emailOtpReader;

public class verifySearchFileterOnProjectListingTest extends BaseClass {

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

		verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);

		page.clickOnProjectOnHomePage();

		page.printProjectDetails();

		System.out.println("Project List Verified Successfully");
	}

//	@Test(priority = 3)
//	public void verifyValidProjectSearch() {
//
//		verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);
//
//		page.searchProject("Testing user");
//
//		Assert.assertTrue(page.isProjectDisplayed("Testing user"));
//
//		System.out.println("Valid Project Search Verified");
//	}
	
	
	@Test(priority = 3)
	public void verifyValidProjectSearch() {

	    verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);

	    page.clickOnProjectOnHomePage();

	    page.searchProject("Testing user");

	    Assert.assertTrue(
	        page.isProjectDisplayed("Testing user"),
	        "Valid project should be displayed"
	    );

	    System.out.println("Valid Project Search Verified");
	}

//	@Test(priority = 4)
//	public void verifyInvalidProjectSearch() {
//
//		verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);
//
//		page.clickOnProjectOnHomePage();
//
//		page.searchInvalidProject("New Project");
//
//		System.out.println("Invalid Project Search Verified");
	//}
	
	@Test(priority = 4)
	public void verifyInvalidProjectSearch() {

	    verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);

	    page.clickOnProjectOnHomePage();

	    page.searchProject("New Project");

	    Assert.assertFalse(
	        page.isProjectDisplayed("New Project"),
	        "Invalid project should not be displayed"
	    );

	    System.out.println("Invalid Project Search Verified");
	}
	

	@Test(priority = 5)
	public void verifyFilters() {

		verifySearchFilterOnProjectListingPage page = new verifySearchFilterOnProjectListingPage(driver);

		page.verifyFilters();

		System.out.println("Filters Verified Successfully");

	}
}