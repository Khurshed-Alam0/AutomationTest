package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccountCreated extends BasePage {

    private WebDriver driver;

    public PageAccountCreated(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2/b[contains(text(), 'Account Created')]")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement btnContinue;

    public PageHome clickContinue() {
        btnContinue.click();
        return PageFactory.initElements(driver, PageHome.class);
    }

}
