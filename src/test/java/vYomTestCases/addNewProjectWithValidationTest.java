package vYomTestCases;

import org.testng.annotations.Test;

import vYomPages.loginPage;
import vYomUtilities.emailOtpReader;
import vYomPages.createNewProjectPage;
import vYomBase.BaseClass;

public class addNewProjectWithValidationTest extends BaseClass {

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
	public void addNewProject() throws InterruptedException {

		createNewProjectPage createProject = new createNewProjectPage(driver);

		createProject.addNewProjectWithValidInputs();

		createProject.clickCrossIcon();

		createProject.addNewProjectWithValidInputs();
		System.out.println("Opening Add Project form again");

	}

	@Test(priority = 3)
	public void saveProject() throws InterruptedException {

		createNewProjectPage createProject = new createNewProjectPage(driver);

		createProject.saveProject();

	}

	@Test(priority = 4)
	public void verifyAddNewProjectMandatoryFieldValidation() {

		createNewProjectPage createProject = new createNewProjectPage(driver);

		createProject.addNewProjectWithValidation();

	}

}
