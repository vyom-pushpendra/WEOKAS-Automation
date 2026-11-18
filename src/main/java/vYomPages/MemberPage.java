
package vYomPages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import vYomUtilities.waitUtility;

public class MemberPage {

	WebDriver driver;
	waitUtility wait;

	// Constructor
	public MemberPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new waitUtility(driver);
	}

	// ========== LOCATORS ==========

	By memberMenu = By.xpath("//button[.//p[normalize-space()='Members']]");

	By addMemberButton = By.xpath("//p[normalize-space()='Add New Member']");

	By fullName = By.xpath("//input[@placeholder='Enter Full Name']");

	By updateMember = By.xpath(
			"//p[@class=\"font-['Inter:Semi_Bold',sans-serif] font-semibold text-[15px] text-white tracking-[0.15px]\"]");

	// By companyName =
	// By.xpath("//input[@placeholder='Company Name']");

	By email = By.xpath("//input[@placeholder='eg. abc@xyz.com']");

	By phone = By.xpath("//input[@placeholder='00000 00000']");

	By dob = By.xpath("//input[@type='text' and @readonly and contains(@class,'cursor-pointer')]");

	By bloodGroup = By.xpath("//p[normalize-space()='BLOOD GROUP']/following-sibling::div//select");

	By role = By.xpath("//select[contains(@name,'role')]");

	By saveButton = By.xpath("//p[text()=\"Save Member\"]");

	By successMessage = By.xpath("//*[contains(translate(text(),'SUCCESS','success'),'success')]");

	By searchField = By.xpath("//input[@placeholder='Search members']");

	// Edit form locators - verify with actual HTML
	By address = By.xpath("//input[@placeholder='Address']");

	// Three dots / Edit / Delete locators
	// These are temporary and must be verified with actual HTML.
	By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");

	By updateMemberTostMsg = By.xpath("//div[contains(text(),'Member updated successfully')]");

	By userDelete = By.xpath("//button[contains(.,'Delete')]");

	// ========== OPEN MEMBER PAGE ==========

	public void openMemberPage() {
		wait.waitForClickable(memberMenu).click();
	}

	// ========== ADD MEMBER ==========

	public void clickAddMember() {
		wait.waitForClickable(addMemberButton).click();
	}

	// ========== ENTER NAME ==========

	public void enterFullName(String name) {
		WebElement element = wait.waitForVisibility(fullName);
		element.clear();
		element.sendKeys(name);
	}

	// ========== ENTER EMAIL ==========

	public void enterEmail(String emailId) {
		WebElement element = wait.waitForVisibility(email);
		element.clear();
		element.sendKeys(emailId);
	}

	// ========== ENTER PHONE ==========

	public void enterPhone(String mobile) {
		WebElement element = wait.waitForVisibility(phone);
		element.clear();
		element.sendKeys(mobile);
	}

	// ========== ENTER DOB ==========

	public void enterDOB(String date) {

		WebElement element = wait.waitForClickable(dob);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}

		LocalDate dobDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		WebElement monthDropdown = driver
				.findElement(By.xpath("//select[contains(@class,'react-datepicker__month-select')]"));

		new Select(monthDropdown).selectByValue(String.valueOf(dobDate.getMonthValue() - 1));

		WebElement yearDropdown = driver
				.findElement(By.xpath("//select[contains(@class,'react-datepicker__year-select')]"));

		new Select(yearDropdown).selectByValue(String.valueOf(dobDate.getYear()));

		String day = String.valueOf(dobDate.getDayOfMonth());

		WebElement dayElement = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day')"
				+ " and not(contains(@class,'react-datepicker__day--outside-month'))" + " and normalize-space()='" + day
				+ "']"));

		dayElement.click();
	}

	// ========== SELECT BLOOD GROUP ==========

	public void selectBloodGroup(String bloodGroup) {

		WebElement element = wait
				.waitForClickable(By.xpath("//p[normalize-space()='BLOOD GROUP']/following-sibling::div//select"));

		Select select = new Select(element);

		select.selectByVisibleText(bloodGroup);
	}

	// ========== SELECT ROLE ==========

	public void selectRole(String role) {

		System.out.println("Role received: " + role);

		WebElement element = wait
				.waitForClickable(By.xpath("//p[contains(normalize-space(),'ROLE')]/following-sibling::div//select"));

		Select select = new Select(element);

		select.selectByVisibleText(role);

		System.out.println("Role selected in dropdown: " + select.getFirstSelectedOption().getText());
	}

	// ========== SAVE MEMBER ==========

	public void clickSave() {

		By saveButton = By.xpath("//button[.//p[normalize-space()='Save Member']]");

		WebElement element = wait.waitForVisibility(saveButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

		System.out.println("Button displayed: " + element.isDisplayed());
		System.out.println("Button enabled: " + element.isEnabled());
		System.out.println("Disabled attribute: " + element.getAttribute("disabled"));

		System.out.println("Button HTML: " + element.getAttribute("outerHTML"));

		if (element.isEnabled()) {
			element.click();
			System.out.println("Click command executed");
		} else {
			System.out.println("Save button is disabled!");
		}
	}

	// ========== CREATE MEMBER ==========

	public void createMember(String name, String company, String emailId, String mobile, String date, String blood,
			String roleValue) {

		enterFullName(name);

		enterEmail(emailId);
		enterPhone(mobile);
		enterDOB(date);
		selectBloodGroup("O+");
		selectRole(roleValue);
	}

	// ========== VERIFY SUCCESS MESSAGE ==========

	public boolean verifySuccessMessage() {

		By toastMessage = By.xpath("//div[contains(text(),'Member created successfully')]");

		try {

			WebElement message = wait.waitForVisibility(toastMessage);

			String actualMessage = message.getText().trim();

			System.out.println("Toast Message: " + actualMessage);

			return actualMessage.equals("Member created successfully");

		} catch (TimeoutException e) {

			System.out.println("Toast Message Not Found!");
			return false;
		}
		
		

	}

	// ========== SEARCH MEMBER ==========

	public void searchMember(String name) throws InterruptedException {

		Thread.sleep(1000);

		WebElement search = wait.waitForVisibility(searchField);
		search.clear();
		search.sendKeys(name);

		System.out.println("Searching Member: " + name);

	}

	// ========== CLICK THREE DOTS ==========

	public void clickThreeDots(String name) {
		By threeDots = By.xpath("//button[@aria-label='Member actions']//*[name()='svg']");

		wait.waitForClickable(threeDots);

		wait.waitForClickable(threeDots).click();

	}

	// ========== CLICK EDIT ==========
	// Menu ka exact HTML milne par locator confirm hoga.

	public void clickEdit() {
		By editButton = By.xpath("//button[normalize-space()='Edit']");

		wait.waitForClickable(editButton);
		wait.waitForClickable(editButton).click();
	}

	// ========== UPDATE MEMBER ==========

	public void updateMember(String updatedName, String updateEmail, String updatedMobile) {

		WebElement nameElement = wait.waitForVisibility(fullName);
		nameElement.clear();
		nameElement.sendKeys(updatedName);

		WebElement mobileElement = wait.waitForVisibility(phone);
		mobileElement.clear();
		mobileElement.sendKeys(updatedMobile);

		// WebElement addressElement = wait.waitForVisibility(address);
		// addressElement.clear();
		// addressElement.sendKeys(updatedAddress);

		WebElement emailElement = wait.waitForVisibility(email);
		emailElement.clear();
		emailElement.sendKeys(updateEmail);

	}

	public void updateMember() throws InterruptedException {

		wait.waitForClickable(updateMember).click();

		Thread.sleep(2000);

	}

	public void verifyUpdateMember() {

		WebElement message = wait.waitForVisibility(updateMemberTostMsg);

		String memberUpdateMessage = message.getText().trim();

		System.out.println("Toast Message: " + memberUpdateMessage);
	}

	// ========== DELETE MEMBER ==========

	public void deleteMember(String name) throws InterruptedException {
		
		
		clickThreeDots(name);

		wait.waitForVisibility(userDelete);

		wait.waitForClickable(userDelete).click();

		Thread.sleep(2000);

		wait.waitForClickable(userDelete).click();

		
	}

	// ========== VERIFY MEMBER DELETED ==========
	
	public boolean verifyDeleteSuccessMessage(String name) {
		
		
		System.out.println("=====================Delete Member==================");
		
		System.out.println("Delete Member Successfully"+"  :  "+name);
		
		
	    try {
	        WebElement toast = wait.waitForVisibility(
	            By.xpath("//div[contains(text(),'" + name + " deleted')]")
	        );

	        System.out.println("Delete Toast: " + toast.getText());
	        return toast.isDisplayed();

	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	
}
