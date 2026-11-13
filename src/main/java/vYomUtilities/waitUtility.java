package vYomUtilities;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class waitUtility {


    private WebDriver driver;
    private WebDriverWait wait;


    public waitUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    // Wait for element visibility
    public WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Wait for element clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }


    // Wait for element invisible
    public boolean waitForInvisibility(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    // Wait for page title
    public boolean waitForTitleContains(String title) {
        return wait.until(
                ExpectedConditions.titleContains(title));
    }


	public WebElement until(ExpectedCondition<WebElement> elementToBeClickable) {
		// TODO Auto-generated method stub
		return null;
	}
}