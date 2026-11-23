
package vYomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import vYomUtilities.waitUtility;

public class rolesAndPermissionsPage {

	WebDriver driver;
	waitUtility wait;

	public rolesAndPermissionsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);
	}

	// ================= LOCATORS =================

	By roleAndPermissions = By.xpath("//p[contains(text(),'Roles &')]");
	By roleAndPermissionsPage = By.xpath("//h1[text()='Roles and Permission']");

	By addNewRole = By.xpath("//button[text()='Add New Role']");
	By editRoleAndPermissionsPage = By.xpath("//h2[text()='Add Role and Permission']");

	By roleNameErrorMsg = By.xpath("//p[text()='Role name is required']");
	By permissionsErrorMsg = By.xpath("//p[text()='Select at least one permission']");

	By cancel = By.xpath("//button[text()='Cancel']");
	By saveRole = By.xpath("//button[normalize-space()='Save Role']");

	By roleName = By.xpath("//input[@placeholder='Administrator']");

	By projects = By.xpath(
			"//button[@role='radio'][.//span[normalize-space()='All Projects' or normalize-space()='Own Projects']]");

	By successToast = By.xpath("//*[contains(text(),'Role created successfully')]");
	By searchField = By.xpath("//input[@placeholder='Search roles']");

	By threedot = By.xpath(
			"//button[@class='flex items-center justify-center rounded-[4px] size-[32px] hover:bg-[#f4f7fb] transition-colors']//*[name()='svg']");

	By editRole = By.xpath("//p[contains(.,'Edit')]");
	By editRoleNameField = By.xpath("//input[@placeholder='Administrator']");
	By updateRole = By.xpath("//button[normalize-space()='Update Role']");

	By roleUpdatedToast = By.xpath("//*[normalize-space()='Role updated successfully']");

	By deleteRole = By.xpath("//p[contains(.,'Delete')]");
	By conformDelete = By.xpath("//button[contains(.,'Delete')]");
	By roleDeletedToast = By.xpath("//*[normalize-space()='Role deleted successfully']");

	// ================= NAVIGATION METHODS =================

	public void roleAndPermissionsListingVerifyPage() {

		wait.waitForClickable(roleAndPermissions).click();

		String heading = wait.waitForVisibility(roleAndPermissionsPage).getText();

		System.out.println("Page Heading: " + heading);
	}

	public void clickOnAddNewRoleAndVerifyPage() {

		wait.waitForClickable(addNewRole).click();

		String heading = wait.waitForVisibility(editRoleAndPermissionsPage).getText();

		System.out.println("Add Role Page: " + heading);

	}

	// ================= Create Role =================

	public void verifyMandatoryErrorMessages() throws InterruptedException {
		
		Thread.sleep(2000);

		wait.waitForClickable(saveRole).click();

		String roleError = wait.waitForVisibility(roleNameErrorMsg).getText();
		String permissionError = wait.waitForVisibility(permissionsErrorMsg).getText();

		System.out.println("role errormsg"+" "+roleError);
		System.out.println("permissionError"+" "+permissionError);
		
		
	}

	public void clickOnCancelAndAddRole() throws InterruptedException {
		
		Thread.sleep(2000);
		
		wait.waitForClickable(cancel).click();
		wait.waitForClickable(addNewRole).click();
	}

	public void enterRoleName(String name) {

		WebElement field = wait.waitForVisibility(roleName);

		field.clear();
		field.sendKeys(name);

		System.out.println("Role Name Entered: " + name);
	}

	public void selectPermission() {

		List<WebElement> options = driver.findElements(projects);

		if (options.size() >= 2) {

			String firstStatus = options.get(0).getAttribute("aria-checked");

			WebElement selectedOption;

			if ("true".equals(firstStatus)) {
				selectedOption = options.get(1);
			} else {
				selectedOption = options.get(0);
			}

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
					selectedOption);

			selectedOption.click();

			System.out.println("Project Permission Selected");
		}

		wait.waitForClickable(saveRole).click();
	}

	public boolean verifySuccessMessage() throws InterruptedException {
		
	

		String toast = wait.waitForVisibility(successToast).getText();

		System.out.println("Create Toast Message: " + toast);

		return toast.contains("Role created successfully");
	}

	public void searchRoleName(String oldRoleName) {

		WebElement search = wait.waitForVisibility(searchField);

		search.clear();
		search.sendKeys(oldRoleName);

		System.out.println("Searching Role: " + oldRoleName);
	}

	// ================= UPDATE ROLE METHODS =================

	public void edit(String newRoleName) {

		wait.waitForClickable(threedot).click();

		wait.waitForClickable(editRole).click();

		WebElement field = wait.waitForVisibility(editRoleNameField);

		field.clear();
		field.sendKeys(newRoleName);

		System.out.println("New Role Name Entered: " + newRoleName);
	}

	public void clickUpdateRole() throws InterruptedException {

		wait.waitForClickable(updateRole).click();

		System.out.println("Update Role Button Clicked");
		
	
	}

	public String verifyRoleUpdatedToast() throws InterruptedException {

		String toast = wait.waitForVisibility(roleUpdatedToast).getText();
		
		

		System.out.println("Update Toast Message: " + toast);

		return toast.trim();
	}

	// ================= DELETE ROLE METHODS =================

	public void searchUpdatedRoleNameAndDelete(String newRoleName) {

		WebElement search = wait.waitForVisibility(searchField);

		search.clear();
		search.sendKeys(newRoleName);

		System.out.println("Searching Updated Role Name: " + newRoleName);

		wait.waitForClickable(threedot).click();

		wait.waitForClickable(deleteRole).click();

		wait.waitForClickable(conformDelete).click();

		System.out.println("Delete Confirmed");
	}

	public String verifyRoleDeletedToastmsg() throws InterruptedException {

		String toast = wait.waitForVisibility(roleDeletedToast).getText();
			
		System.out.println("Delete Toast Message: " + toast);

		return toast.trim();
	}

	// ================= REFRESH METHOD =================

	public void refreshPage() {

		driver.navigate().refresh();

		System.out.println("Page Refreshed");
	}
}
