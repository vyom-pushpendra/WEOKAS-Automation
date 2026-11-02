package vYomUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jsUtility {

    WebDriver driver;
    JavascriptExecutor js;

    public jsUtility(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // JS Click
    public void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // Scroll To Element
    public void scrollToElement(WebElement element) {
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                element);
    }

    // Highlight Element
    public void highlightElement(WebElement element) {
        js.executeScript(
                "arguments[0].style.border='3px solid red';",
                element);
    }

    // Scroll Notification Panel
    public void scrollNotificationSlow(WebElement panel) {

        for(int i = 0; i < 10; i++) {

            js.executeScript(
                "arguments[0].scrollTop = arguments[0].scrollTop + 50;",
                panel);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}