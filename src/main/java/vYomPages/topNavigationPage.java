package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import vYomUtilities.waitUtility;

public class topNavigationPage {

	WebDriver driver;
	waitUtility wait;

	public topNavigationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);

	}

	// Locators
	By notificationIcon = By.xpath("(//button[contains(@class,'size-[40px]')])[1]");

	By profileIcon = By.xpath("//p[normalize-space()='P']");

	By searchBar = By.xpath("//input[@placeholder='Search projects, members...']");

	By notificationScroll = By.xpath("//p[text()=\"fifth was added to Vyom system.\"]");

	By markAllAsRead = By.xpath("//button[text()=\"Mark all as read\"]");

	By logout = By.xpath("//*[normalize-space()='Log Out']");

	By canelLogout = By.xpath("//button[normalize-space()='Cancel']");

	By popupText = By.xpath("//p[text() =\"Are you sure you want to log out?\"]");

	By cancel = By.xpath("//button[text()=\"Cancel\"]");

	// Actions

	public void clickNotificationIcon() throws InterruptedException {

		// Open Notification Panel

		wait.waitForClickable(notificationIcon).click();

		Thread.sleep(1000);

		try {
			if (driver.findElement(markAllAsRead).isDisplayed()) {

				Thread.sleep(1000);

				driver.findElement(markAllAsRead).click();

				Thread.sleep(1000);
				System.out.println("Clicked on Mark all as read");
			}

		} catch (Exception e) {

			System.out.println("No mark all as read available");
		}

		// Close Notification Panel

		wait.waitForClickable(notificationIcon).click();
	}

	public void verfyEnterSearchText(String text,String projetName) throws InterruptedException {

		Thread.sleep(1000);

		wait.waitForVisibility(searchBar).sendKeys(text);

		driver.findElement(searchBar).clear();

		wait.waitForVisibility(searchBar).sendKeys(projetName);

		System.out.println("No project name :: " + projetName);

	}

	public void printLogoutPopupTextAndCancel() throws InterruptedException {

		Thread.sleep(2000);

		wait.waitForClickable(profileIcon).click();

		wait.waitForClickable(logout).click();

		String actualText = wait.waitForVisibility(popupText).getText();

		String expectedText = "Are you sure you want to log out?";

		System.out.println("Actual Text: " + actualText);
		System.out.println("Expected Text: " + expectedText);

		Assert.assertEquals(actualText, expectedText);

		Thread.sleep(2000);
	}

}