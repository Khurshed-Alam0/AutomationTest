package common;

import com.beust.ah.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void hoverOverElement(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .perform();
    }

    public void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }

    public void clickByActions(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .click()
                .build()
                .perform();
    }

    public void waitUntilElementVisible(WebDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
