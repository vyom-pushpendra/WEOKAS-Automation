
package vYomPages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import vYomUtilities.waitUtility;

public class projectListingPage {

	WebDriver driver;
	waitUtility wait;

	By search = By.xpath("//input[@placeholder='Search projects, members...']");
	By clcokOnFilters = By.xpath("//span[normalize-space()='Filters']");
	By search1 = By.xpath("//input[@placeholder='Search project']");

	public projectListingPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new waitUtility(driver);
	}

	public void click_projects_menu() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement projects = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[.//p[normalize-space()='Projects']]")));

		projects.click();

	}

	public void get_project() {

		List<WebElement> projectList = driver.findElements(By.xpath(
				"//p[@class=\"font-['Inter:Semi_Bold',sans-serif] font-semibold text-[#0a1e3f] text-[14px] truncate\"]"));

		// Total project count
		System.out.println("Total Projects: " + projectList.size());

		// First 6 project names
		System.out.println("First 6 Projects:");

		for (int i = 0; i < Math.min(6, projectList.size()); i++) {

			String name = projectList.get(i).getAttribute("textContent").trim();

			System.out.println((i + 1) + ". " + name);
		}
	}

	public void serchAndVerify() throws InterruptedException {

		List<WebElement> projectList = driver.findElements(By.xpath(
				"//p[@class=\"font-['Inter:Semi_Bold',sans-serif] font-semibold text-[#0a1e3f] text-[14px] truncate\"]"));

		System.out.println("Total Projects: " + projectList.size());

		for (int i = 0; i < Math.min(6, projectList.size()); i++) {

			String projectName = projectList.get(i).getAttribute("textContent").trim();

			wait.waitForClickable(search).clear();

			wait.waitForClickable(search).sendKeys(projectName);

			System.out.println("Searching: " + projectName);

			Thread.sleep(500);
		}

		wait.waitForClickable(search).clear();

	}

	public void clcikOnFilters() throws InterruptedException {

		wait.waitForClickable(clcokOnFilters).click();
		
		
		

	}
	
	
	

}
