package initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialization {

    public static WebDriver _driver;

    public WebDriver init() {

        _driver = new ChromeDriver();

        _driver.navigate().to("https://automationexercise.com/");

        _driver.manage().window().maximize();

        return _driver;
    }

    public static WebDriver getDriver() {
        return _driver;
    }




}
