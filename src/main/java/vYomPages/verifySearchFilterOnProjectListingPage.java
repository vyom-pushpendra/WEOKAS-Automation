package vYomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vYomUtilities.waitUtility;

public class verifySearchFilterOnProjectListingPage {

	WebDriver driver;
	waitUtility wait;

	public verifySearchFilterOnProjectListingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);

	}

	// Locators

	By searchBox = By.xpath("//input[@placeholder='Search project']");

	By projectButton = By.xpath("//button[.//p[text()='Projects']]");

	By projectList = By.xpath("//tbody/tr");

	By filterButton = By.xpath("//button[contains(.,'Filters')]");

	By assignedSI = By.xpath("//*[text()='Assigned SI']");
	By assignedMember = By.xpath("//*[text()='Assigned Member']");
	By projectInformation = By.xpath("//*[text()='Project Information']");

	By applyFiltersButton = By.xpath("//button[contains(.,'Apply Filters')]");
	By cancelButton = By.xpath("//button[contains(.,'Cancel')]");
	By clearAllButton = By.xpath("//*[contains(text(),'Clear All')]");

	public void clickOnProjectOnHomePage() {

		wait.waitForClickable(projectButton).click();

	}

	public void printProjectDetails() {

		List<WebElement> rows = driver.findElements(projectList);

		System.out.println("Total Projects : " + rows.size());

		for (WebElement row : rows) {

			String projectName = row.findElement(By.xpath("./td[1]")).getText().split("\n")[0];

			String ownerName = row.findElement(By.xpath("./td[2]")).getText();

			String managerName = row.findElement(By.xpath("./td[4]")).getText();

			System.out.println("Project Name : " + projectName);
			System.out.println("Owner Name : " + ownerName);
			System.out.println("Manager Name : " + managerName);
			System.out.println("================================");
		}

	}

	public void searchProject(String projectName) {

		WebElement search = wait.waitForVisibility(searchBox);

		search.clear();
		search.sendKeys(projectName);
	}

	public boolean isProjectDisplayed(String expectedProject) {

		List<WebElement> rows = driver.findElements(projectList);

		for (WebElement row : rows) {

			String actualProject = row.findElement(By.xpath("./td[1]")).getText().split("\n")[0].trim();

			if (actualProject.equalsIgnoreCase(expectedProject)) {

				System.out.println("Project Found : " + actualProject);
				return true;
			}
		}

		System.out.println("Project  Found : " + expectedProject);
		return false;
	}

	public void searchAndPrintProject(String projectName) {

		searchProject(projectName);

		List<WebElement> rows = driver.findElements(projectList);

		if (rows.size() > 0) {

			WebElement row = rows.get(0);

			String project = row.findElement(By.xpath("./td[1]")).getText().split("\n")[0];

			String owner = row.findElement(By.xpath("./td[2]")).getText();

			String manager = row.findElement(By.xpath("./td[4]")).getText();

			System.out.println("Project Name : " + project);
			System.out.println("Owner Name : " + owner);
			System.out.println("Manager Name : " + manager);
		} else {

			System.out.println("Project Not Found : " + projectName);
		}
	}

	public void searchInvalidProject(String projectName) {

		searchProject(projectName);

		List<WebElement> rows = driver.findElements(projectList);

		if (rows.isEmpty()) {

			System.out.println("Project Not Found : " + projectName);

		} else {

			System.out.println("Unexpected Project Found");
		}
	}

	public void verifyFilters() {

		wait.waitForClickable(filterButton).click();

		System.out.println("Assigned SI Displayed : " + driver.findElement(assignedSI).isDisplayed());

		System.out.println("Assigned Member Displayed : " + driver.findElement(assignedMember).isDisplayed());

		System.out.println("Project Information Displayed : " + driver.findElement(projectInformation).isDisplayed());

		System.out.println("Apply Filters Button Displayed : " + driver.findElement(applyFiltersButton).isDisplayed());

		System.out.println("Cancel Button Displayed : " + driver.findElement(cancelButton).isDisplayed());

		System.out.println("Clear All Displayed : " + driver.findElement(clearAllButton).isDisplayed());
	}
}
