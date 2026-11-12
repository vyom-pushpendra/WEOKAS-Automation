package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import vYomUtilities.waitUtility;

public class createNewProjectPage {

	WebDriver driver;
	waitUtility wait;

	// Locators
	By searchProject = By.xpath("//input[@placeholder='Search projects, members...']");

	By addNewProject = By.xpath("//button[normalize-space()='Add New Project']");

	By addprojectName = By.xpath("//input[@placeholder='Enter project name']");

	By email = By.xpath("//input[@placeholder='Enter address']");

	By assigendMember = By.xpath("//select[contains(.,'Select member')]");

	By saveProject = By.xpath("//button[contains(.,'Save Project')]");

	By successMessage = By.xpath("//*[contains(text(),'Project created successfully')]");

	By project = By.xpath("//button[2]//div[1]//span[2]//span[1]");

	public createNewProjectPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new waitUtility(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public void addNewProjectWithValidInputs() throws InterruptedException {

		wait.waitForClickable(addNewProject);
		driver.findElement(addNewProject).click();
		Thread.sleep(200);

	}

	static int count = 1;

	public String fillValidDetails() {

		String projectName = "Automation" + System.currentTimeMillis();

		wait.waitForVisibility(addprojectName);
		driver.findElement(addprojectName).clear();
		driver.findElement(addprojectName).sendKeys(projectName);

		return projectName;

	}

	public void email() {

		String username = "Automation" + System.currentTimeMillis();
		String emailId = username + "@gmail.com";

		wait.waitForClickable(email).click();
		driver.findElement(email).sendKeys(emailId);

	}

	public void selectMember() throws InterruptedException {

		wait.waitForClickable(assigendMember).click();

		WebElement element = driver.findElement(assigendMember);

		Select select = new Select(element);
		select.selectByVisibleText("Pushpendra");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void saveProject() throws InterruptedException {

		wait.waitForClickable(saveProject).click();
		Thread.sleep(2000);

	}

	public boolean verifySuccessMessage() {

		wait.waitForVisibility(successMessage);

		String msg = driver.findElement(successMessage).getText();

		System.out.println("message" + " = " + msg);

		return driver.findElement(successMessage).isDisplayed();

	}

	public void clickOnProject() {

		wait.waitForClickable(project).click();

	}

	public boolean verifyCreatedProject(String projectName) {

		wait.waitForVisibility(searchProject);

		driver.findElement(searchProject).clear();
		driver.findElement(searchProject).sendKeys(projectName);

		By createdProject = By.xpath("//*[contains(text(),'" + projectName + "')]");

		wait.waitForVisibility(createdProject);

		return driver.findElement(createdProject).isDisplayed();
		
		
		
	}

}
