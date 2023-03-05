package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePaymentDone extends BasePage {

    private WebDriver driver;

    public PagePaymentDone(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h2[@data-qa='order-placed']/following-sibling::p")
    private WebElement orderConfirmationText;

    public String getOrderConfirmationMessage() {
        return orderConfirmationText.getText();
    }



}
