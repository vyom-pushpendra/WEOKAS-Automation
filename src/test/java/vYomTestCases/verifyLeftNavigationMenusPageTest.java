package vYomTestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.verifyLeftNavigationMenusPage;
import vYomPages.loginPage;
import vYomUtilities.emailOtpReader;

public class verifyLeftNavigationMenusPageTest extends BaseClass {

    @Test
    public void verifyLeftNavigationMenus() throws Exception {

        // Login

//        loginPage loginpage = new loginPage(driver);
//
//        loginpage.enterEmail(config.getEmail());
//
//        Thread.sleep(3000);
//
//        loginpage.clickTerms();
//
//        Thread.sleep(2000);
//
//        loginpage.clickLogin();
//
//        String otp = emailOtpReader.getOTP();
//
//        System.out.println("OTP Found : " + otp);
//
//        loginpage.enterOTP(otp);
//
//        Thread.sleep(2000);
//
//        loginpage.clickVerify();
//
//        Thread.sleep(5000);

        // Dashboard Page
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

        verifyLeftNavigationMenusPage dashboard = new verifyLeftNavigationMenusPage(driver);
        String[] expectedMenus = {
                "Home",
                "Projects",
                "Members",
                "Roles",
                "Support",
                "Help"
        };
       

        for (String menu : expectedMenus) {

            // Verify Menu

            Assert.assertTrue(
                    dashboard.isMenuDisplayed(menu),
                    menu + " menu is not displayed");

            System.out.println("Verified Menu : " + menu);
          

            // Click Menu

            dashboard.clickMenu(menu);

            System.out.println("Clicked Menu : " + menu);

            // Action visibly show ho

            Thread.sleep(3000);
        }

        System.out.println(
                "All Left Navigation Menus Verified Successfully");
    }
}