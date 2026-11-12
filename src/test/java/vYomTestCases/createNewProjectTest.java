package vYomTestCases;

import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.createNewProjectPage;
import vYomPages.loginPage;
import org.testng.Assert;
import vYomUtilities.emailOtpReader;

public class createNewProjectTest extends BaseClass {

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
	public void verifyAddNewProjectButton() throws InterruptedException {

		createNewProjectPage createProject = new createNewProjectPage(driver);

		// Click on Add New Project
		createProject.addNewProjectWithValidInputs();

		System.out.println("Add New Project button clicked successfully");

		// createProject.fillValidDetails();

		String projectName = createProject.fillValidDetails();
		createProject.email();
		createProject.selectMember();
		createProject.saveProject();

		// Verify success popup
		boolean status1 = createProject.verifySuccessMessage();
		
		createProject.clickOnProject();

		// Verify Created Project

		boolean status = createProject.verifyCreatedProject(projectName);

		System.out.println("Project Search Status: " + status);

		Assert.assertTrue(status, "Created project not found!");

	}

}
