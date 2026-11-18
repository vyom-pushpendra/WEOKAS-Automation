package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import vYomUtilities.waitUtility;

public class EditSystemIntegratorPage {

    WebDriver driver;
    waitUtility wait;

    public EditSystemIntegratorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new waitUtility(driver);
    }

    private By systemIntegratorMenu =
            By.xpath("//button[.//p[contains(normalize-space(),'System Integrators')]]");

    private By nameField =
            By.xpath("//input[@placeholder='Enter your full name']");

    private By companyField =
            By.xpath("//input[@placeholder='Enter your company name']");

    private By emailField =
            By.xpath("//input[@placeholder='Please enter a valid email address.']");

    private By contactField =
            By.xpath("//input[@placeholder='00000 00000']");

    private By gstField =
            By.xpath("//input[@placeholder='Enter your GST/VAT number']");

    private By updateButton =
            By.xpath("//button[contains(.,'Update')]");

    public void clickSystemIntegratorMenu() {

        wait.waitForClickable(systemIntegratorMenu).click();
        wait.waitForSeconds(2);
    }

    public void updateName(String name) {

        wait.waitForVisibility(nameField).clear();
        wait.waitForSeconds(1);

        wait.waitForVisibility(nameField).sendKeys(name);
        wait.waitForSeconds(2);
    }

    public void updateCompany(String company) {

        wait.waitForVisibility(companyField).clear();
        wait.waitForSeconds(1);

        wait.waitForVisibility(companyField).sendKeys(company);
        wait.waitForSeconds(2);
    }

    public void updateEmail(String email) {

        wait.waitForVisibility(emailField).clear();
        wait.waitForSeconds(1);

        wait.waitForVisibility(emailField).sendKeys(email);
        wait.waitForSeconds(2);
    }

    public void updateContact(String contact) {

        wait.waitForVisibility(contactField).clear();
        wait.waitForSeconds(1);

        wait.waitForVisibility(contactField).sendKeys(contact);
        wait.waitForSeconds(2);
    }

    public void updateGST(String gst) {

        wait.waitForVisibility(gstField).clear();
        wait.waitForSeconds(1);

        wait.waitForVisibility(gstField).sendKeys(gst);
        wait.waitForSeconds(2);
    }

    public void clickUpdate() {

        wait.waitForClickable(updateButton).click();
        wait.waitForSeconds(3);
    }
}