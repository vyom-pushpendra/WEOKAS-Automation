package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verifyLeftNavigationMenusPage {

	WebDriver driver;

	public verifyLeftNavigationMenusPage(WebDriver driver) {
		this.driver = driver;
	}

//	public boolean isMenuDisplayed(String menuName) {
//
//		return driver.findElement(By.xpath("//*[contains(text(),'" + menuName + "')]")).isDisplayed();
//
//	}
//
//	public void clickMenu(String menuName) {
//
//		driver.findElement(By.xpath("//*[contains(text(),'" + menuName + "')]")).click();
//	}
//	
//	
	
	public boolean isMenuDisplayed(String menuName) {

	    return driver.findElement(
	            By.xpath("//p[contains(.,'" + menuName + "')]"))
	            .isDisplayed();
	}

	public void clickMenu(String menuName) {

	    driver.findElement(
	            By.xpath("//p[contains(.,'" + menuName + "')]"))
	            .click();
	}
	
	
	
}