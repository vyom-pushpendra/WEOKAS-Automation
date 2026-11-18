package vYomTestCases;

import org.testng.annotations.Test;

import vYomBase.BaseClass;
import vYomPages.*;

public class EditSystemIntegratorTest extends BaseClass {

    @Test
    public void verifyEditSystemIntegrator() {

        EditSystemIntegratorPage si =
                new EditSystemIntegratorPage(driver);

        si.clickSystemIntegratorMenu();

        si.updateName("Automation User");

        si.updateCompany("Automation Company");

        si.updateEmail("automation@gmail.com");

        si.updateContact("9876543210");

        si.updateGST("GST123456");

        si.clickUpdate();
    }
}
