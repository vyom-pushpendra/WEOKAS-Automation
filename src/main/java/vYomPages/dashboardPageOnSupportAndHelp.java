package vYomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class dashboardPageOnSupportAndHelp {

    WebDriver driver;

    public dashboardPageOnSupportAndHelp(WebDriver driver) {
        this.driver = driver;
    }

    // Sticky Logo Locator
    By stickyLogo = By.xpath("//img[@alt='WE.OKAS']");

    // Verify Support or Help Menu
    public boolean isMenuDisplayed(String menuName) {
        return driver.findElement(
                By.xpath("//*[contains(text(),'" + menuName + "')]"))
                .isDisplayed();
    }

    // Get Menu Position
    public int getMenuPosition(String menuName) {
        return driver.findElement(
                By.xpath("//*[contains(text(),'" + menuName + "')]"))
                .getLocation()
                .getY();
    }

    // Verify Help is below Support
    public boolean isHelpBelowSupport() {

        int supportPosition = getMenuPosition("Support");
        int helpPosition = getMenuPosition("Help");

        return helpPosition > supportPosition;
    }

    // Verify Sticky Logo
    public boolean isLogoDisplayed() {
        return driver.findElement(stickyLogo).isDisplayed();
    }

    // Get Logo Name
    public String getLogoName() {
        return driver.findElement(stickyLogo).getAttribute("alt");
    }

    // Smooth Scroll Page
    public void scrollPage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("Scrolling page...");

        for (int i = 1; i <= 20; i++) {
            js.executeScript("window.scrollBy(0,50)");
            Thread.sleep(300);
        }

        System.out.println("Scrolling completed.");
    }

    // Verify Logo After Scroll
    public boolean isLogoDisplayedAfterScroll() {
        return driver.findElement(stickyLogo).isDisplayed();
    }

    // Get Current Scroll Position
    public int getScrollPosition() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return ((Long) js.executeScript(
                "return window.pageYOffset;"))
                .intValue();
    }
}