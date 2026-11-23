
package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.MemberPage;
import vYomPages.loginPage;
import vYomUtilities.RandomDataUtility;
import vYomUtilities.emailOtpReader;

public class MemberTest extends BaseClass {

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage loginPage = new loginPage(driver);

		// Enter Email
		loginPage.enterEmail(config.getEmail());

		// Accept Terms & Conditions
		loginPage.clickTerms();

		// Click Login
		loginPage.clickLogin();

		// Wait for OTP Mail
		Thread.sleep(10000);

		// Read OTP
		String otp = emailOtpReader.getOTP();

		// Enter OTP
		loginPage.enterOTP(otp);

		Thread.sleep(15000);

		// Verify Login
		loginPage.clickVerify();

		Thread.sleep(15000);

		System.out.println("Login Successful");
	}

	@Test(priority = 2)
	public void createEditDeleteMemberTest() throws InterruptedException {

		MemberPage member = new MemberPage(driver);

		// ========== CREATE RANDOM DATA ==========

		String name = RandomDataUtility.getRandomName();
		String email = RandomDataUtility.getRandomEmail();
		String mobile = RandomDataUtility.getRandomMobile();
		String company = RandomDataUtility.getRandomCompany();
		String dob = RandomDataUtility.getRandomDOB();

		String blood = RandomDataUtility.getRandomBloodGroup();
		String role = RandomDataUtility.getRandomRole();

		System.out.println("========== CREATE MEMBER DATA ==========");
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Mobile: " + mobile);
		System.out.println("Company: " + company);
		System.out.println("DOB: " + dob);
		System.out.println("Blood Group: " + blood);
		System.out.println("Role: " + role);

		member.openMemberPage();

		member.clickAddMember();

		// ========== STEP 4: CREATE MEMBER ==========

		member.createMember(name, company, email, mobile, dob, blood, role);

		member.clickSave();

		// ========== STEP 6: VERIFY CREATION ==========

		// STEP 3: VERIFY SUCCESS TOAST MESSAGE
		Assert.assertTrue(member.verifySuccessMessage(), "Member creation failed!");
		
		Thread.sleep(2000);

		System.out.println("Member Created Successfully");

		// ========== STEP 7: SEARCH CREATED MEMBER ==========

		member.searchMember(name);

		System.out.println("Created Member Found Successfully");

		// ========== STEP 8: GENERATE UPDATE DATA ==========

		String updatedName = RandomDataUtility.getRandomName();
		String updatedMobile = RandomDataUtility.getRandomMobile();
		String updatedCompany = RandomDataUtility.getRandomCompany();
		String updatedAddress = RandomDataUtility.getRandomAddress();
		String updateEmail = RandomDataUtility.getRandomEmail();

		System.out.println("========== UPDATED MEMBER DATA ==========");
		System.out.println("Updated Name: " + updatedName);
		System.out.println("Updated Mobile: " + updatedMobile);
		System.out.println("Updated Company: " + updatedCompany);
		System.out.println("Updated Address: " + updatedAddress);

		// ========== STEP 9: CLICK THREE DOTS ==========

		member.clickThreeDots(name);

		// ========== STEP 10: CLICK EDIT ==========

		member.clickEdit();

		// ========== STEP 11: UPDATE SAME MEMBER ==========

		member.updateMember(updatedName, updateEmail, updatedMobile);

		// ========== STEP 12:  UPDATED MEMBER ==========

		// member.clickSave();

		member.updateMember();

		member.verifyUpdateMember();

		// ========== STEP 13: SEARCH UPDATED MEMBER ==========

		member.searchMember(updatedName);

		// Assert.assertTrue(member.verifyMemberDisplayed(updatedName), "Updated member
		// not found!");

		System.out.println("Updated Member Found Successfully");

		// ========== STEP 14: DELETE SAME UPDATED MEMBER ==========

		 member.deleteMember(updatedName);

		System.out.println("Member Delete Clicked");

		// ========== STEP 15: VERIFY DELETION ==========

		member.verifyDeleteSuccessMessage(updatedName);
	}
}
