package pages;

import com.thedeanda.lorem.LoremIpsum;
import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePayment extends BasePage {

    private WebDriver driver;

    public PagePayment(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "input[name = 'name_on_card']")
    private WebElement nameOnCard;

    @FindBy(css = "input[name = 'card_number']")
    private WebElement cardNumber;

    @FindBy(css = "input[name = 'cvc']")
    private WebElement cvc;

    @FindBy(css = "input[name = 'expiry_month']")
    private WebElement expiryMonth;

    @FindBy(css = "input[name = 'expiry_year']")
    private WebElement expiryYear;

    @FindBy(css = "#submit")
    private WebElement btnPayAndConfirmOrder;

    public PagePaymentDone enterPaymentDetails() {

        nameOnCard.click();
        nameOnCard.sendKeys(LoremIpsum.getInstance().getName());

        cardNumber.sendKeys("12345");

        cvc.sendKeys("123");

        expiryMonth.sendKeys("02");

        expiryYear.sendKeys("2028");

        btnPayAndConfirmOrder.click();

        return PageFactory.initElements(driver, PagePaymentDone.class);
    }

}
