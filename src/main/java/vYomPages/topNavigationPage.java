package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vYomUtilities.jsUtility;
import vYomUtilities.waitUtility;

public class topNavigationPage {

	WebDriver driver;
	waitUtility wait;
	jsUtility jsUtil;

	public topNavigationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);
		this.jsUtil = new jsUtility(driver);
	}

	By notificationIcon = By.xpath("(//button[contains(@class,'justify-center')])[1]");
	By notificationPanel = By.xpath("//div[@class='max-h-[380px] overflow-y-auto']");

	public void clickNotification() throws Exception {

		WebElement notification = wait.waitForClickable(notificationIcon);

		// Highlight element
		jsUtil.highlightElement(notification);

		Thread.sleep(1000);

		// JS Click
		jsUtil.clickElement(notification);

		System.out.println("Notification Clicked");
	}

	public void scrollNotificationPanel() {

		WebElement panel = wait.waitForVisibility(notificationPanel);

		jsUtil.scrollNotificationSlow(panel);

		System.out.println("Notification Panel Scrolled");
	}
}

