package vYomTestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import vYomPages.loginPage;
import vYomUtilities.readConfig;
import vYomUtilities.emailOtpReader;
import vYomBase.BaseClass;


public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() throws Exception {

        // Config File Read
        readConfig config = new readConfig();

        // Page Object Create
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
        
        //User Verify
        System.out.println("Login Successful");
    }
}