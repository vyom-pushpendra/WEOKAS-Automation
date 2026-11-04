package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	By logout  =  By.xpath("//*[normalize-space()='Log Out']");
	
	By canelLogout = By.xpath("//button[normalize-space()='Cancel']");

	// Actions

	public void clickNotificationIcon() {

		wait.waitForClickable(notificationIcon).click();
	}

	public void clickProfileIcon() {

		wait.waitForClickable(profileIcon).click();
		
		wait.waitForClickable(logout).click();
		
		wait.waitForClickable(canelLogout);
	}

	public void clickMarkAllAsReadIfAvailable() {

		try {

			if (driver.findElement(markAllAsRead).isDisplayed()) {

				driver.findElement(markAllAsRead).click();
				System.out.println("Clicked on Mark all as read");

			}

		} catch (Exception e) {

			System.out.println("No mark all as read available");

		}
	}

	public void enterSearchText(String text) {

		wait.waitForVisibility(searchBar).sendKeys(text);

	}

	public void enterInvalidProject(String projetName) {

		driver.findElement(searchBar).clear();

		wait.waitForVisibility(searchBar).sendKeys(projetName);

	}

}