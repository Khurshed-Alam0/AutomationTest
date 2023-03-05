package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageViewCart extends BasePage {

    private WebDriver driver;

    public PageViewCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement btnProceedToCheckout;

    @FindBy(xpath = "//a[contains(., 'Register / Login')]")
    private WebElement btnRegisterLogin;

    @FindBy(xpath = "//h2[contains(text(), 'Address Details')]")
    private WebElement addressDetailsHaader;

    @FindBy(xpath = "//h2[contains(text(), 'Review Your Order')]")
    private WebElement verifyYourOrderHeader;

    @FindBy(css = "textarea[name = 'message']")
    private WebElement commentBox;

    @FindBy(xpath = "//a[text() = 'Place Order']")
    private WebElement btnPlaceOrder;

    public boolean isViewCartPageVisible() {

        return btnProceedToCheckout.isDisplayed();

    }

    public void clickProceedToCheckOut() {
        btnProceedToCheckout.click();
    }

    public PageRegisterLogin clickRegisterLoginBtn() {
        btnRegisterLogin.click();
        return PageFactory.initElements(driver, PageRegisterLogin.class);
    }

    public boolean isAddressDetailsHeaderDisplayed() {
        return addressDetailsHaader.isDisplayed();
    }

    public boolean isVerifyYourOrderHeaderDisplayed() {
        return verifyYourOrderHeader.isDisplayed();
    }

    public void writeComment(String comment) {
        commentBox.sendKeys(comment);
    }

    public PagePayment placeOrder() {
        btnPlaceOrder.click();
        return PageFactory.initElements(driver, PagePayment.class);
    }




}
