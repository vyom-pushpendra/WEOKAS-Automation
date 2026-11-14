package vYomPages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import vYomUtilities.waitUtility;

public class verifyEditProjectPage {

	WebDriver driver;
	waitUtility wait;

	public verifyEditProjectPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);
	}

	By serachProject = By.xpath("//input[@placeholder='Search project']");

	By edit = By.xpath("//p[normalize-space()='Edit']");

	By address = By.xpath("//input[@placeholder='Enter address']");

	By email = By.xpath("//input[@placeholder='Enter address']");

	By name = By.xpath("//input[@placeholder='Enter name']");
	
	By landmark = By.xpath("//input[@placeholder='Enter landmark']");
	
	By saveProject = By.xpath("//button[text()=\"Update Project\"]");

	// By threeDots = By
	// .xpath("//button[@class='flex items-center justify-center rounded-[4px]
	// size-[32px]']//*[name()='svg']");

	By threeDots = By.xpath(
			"//*[normalize-space()='Testing user']" + "/ancestor::div[.//button[contains(@class,'size-[32px]')]][1]"
					+ "//button[contains(@class,'size-[32px]')]");

	public void editProject() throws InterruptedException {

		String projectName = "Testing User";

		wait.waitForVisibility(serachProject).click();

		wait.waitForClickable(serachProject).clear();

		driver.findElement(serachProject).sendKeys(projectName);

	}

	public void clickOnThreeDots() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		for (int i = 0; i < 3; i++) {
			try {

				WebElement button = wait
						.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(threeDots)));

				button.click();
				System.out.println("Three Dots Clicked Successfully");
				return;

			} catch (StaleElementReferenceException e) {
				System.out.println("Element stale, retrying...");
			}
		}

		throw new RuntimeException("Unable to click Three Dots button");
	}

	public void clickOnEditButton() {

		wait.waitForVisibility(edit);
		wait.waitForClickable(edit).click();

	}


public void updateProjectDetails() {

    Random random = new Random();

    // Random Cities
    String[] cities = {
        "Delhi", "Mumbai", "Noida",
        "Gurugram", "Jaipur", "Lucknow"
    };

    // Random Landmarks
    String[] landmarks = {
        "City Mall", "Central Park",
        "Bus Stand", "Railway Station",
        "City Hospital", "Shiv Temple"
    };

    // Generate Random Test Data
    String addressValue =
        cities[random.nextInt(cities.length)];

    String landmarkValue =
        landmarks[random.nextInt(landmarks.length)];

    String nameValue = "Automation";

    String emailValue = "Automation"
        + System.currentTimeMillis()
        + "@gmail.com";

    // Enter Address
    WebElement addressField = wait.waitForClickable(address);
    addressField.clear();
    addressField.sendKeys(addressValue);

    // Enter Landmark
    WebElement landmarkField = wait.waitForClickable(landmark);
    landmarkField.clear();
    landmarkField.sendKeys(landmarkValue);

    // Enter Owner Name
    WebElement nameField = wait.waitForClickable(name);
    nameField.clear();
    nameField.sendKeys(nameValue);

    // Enter Owner Email
    WebElement emailField = wait.waitForClickable(email);
    emailField.clear();
    emailField.sendKeys(emailValue);

    // Click Save Project
    
    wait.waitForVisibility(saveProject);
    
    wait.waitForClickable(saveProject).click();
    

    System.out.println("Address: " + addressValue);
    System.out.println("Landmark: " + landmarkValue);
    System.out.println("Owner Name: " + nameValue);
    System.out.println("Owner Email: " + emailValue);

    System.out.println("Project Updated Successfully");
}


}
