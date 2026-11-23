
package vYomTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.loginPage;
import vYomPages.rolesAndPermissionsPage;
import vYomUtilities.RandomDataUtility;
import vYomUtilities.emailOtpReader;
import vYomUtilities.readConfig;

public class rolesAndPermissionsTest {

    public class LoginTest extends BaseClass {

        // ================= LOGIN =================

        @Test(priority = 1)
        public void verifyLogin() throws Exception {

            readConfig config = new readConfig();

            loginPage login = new loginPage(driver);

            login.enterEmail(config.getEmail());

            login.clickTerms();

            login.clickLogin();

            Thread.sleep(10000);

            String otp = emailOtpReader.getOTP();

            login.enterOTP(otp);

            Thread.sleep(15000);

            login.clickVerify();

            Thread.sleep(15000);

            System.out.println("Login Successful");
            
            
        }

      
        
        

        // ================= CREATE ROLE =================

        @Test(priority = 2)
        public void createUpdateAndDeleteRoleTest() throws InterruptedException {

            rolesAndPermissionsPage roles =
                    new rolesAndPermissionsPage(driver);

            // Open Roles and Permissions
            roles.roleAndPermissionsListingVerifyPage();

            // Click Add New Role
            roles.clickOnAddNewRoleAndVerifyPage();

            // Generate Old Role Name
            String oldRoleName =
                    RandomDataUtility.getRandomRoleName();

            System.out.println("Old Role Name: " + oldRoleName);

         // ================= Search Role And Permissions =================
            roles.enterRoleName(oldRoleName);

            // Select Permission and Save
            roles.selectPermission();

            Assert.assertTrue(
                    roles.verifySuccessMessage(),
                    "Role Creation Failed"
            );


            // ================= UPDATE ROLE =================

            // Search Old Role Name
            roles.searchRoleName(oldRoleName);

            // Generate New Role Name Only Once
            String newRoleName =
                    RandomDataUtility.getRandomRoleName();

            System.out.println("New Role Name: " + newRoleName);

            // Edit Role Name
            roles.edit(newRoleName);

            // Update Role
            roles.clickUpdateRole();

            // Verify Update Toast
            Assert.assertEquals(
                    roles.verifyRoleUpdatedToast(),
                    "Role updated successfully"
            );


            // ================= DELETE ROLE =================

            // Search Same Updated Role Name
            roles.searchUpdatedRoleNameAndDelete(newRoleName);

            // Verify Delete Toast
            Assert.assertEquals(
                    roles.verifyRoleDeletedToastmsg(),
                    "Role deleted successfully"
            );

            System.out.println("Create, Update and Delete Test Passed");
        }
    }
}
