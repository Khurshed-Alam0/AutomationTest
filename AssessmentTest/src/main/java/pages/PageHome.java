package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageHome extends BasePage {

    private WebDriver driver;

    public PageHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Features Items')]")
    private WebElement featuredItemsHeader;

    @FindBy(css = ".single-products .productinfo img")
    private List<WebElement> productImages;

    @FindBy(xpath = "//p[contains(text(), '%s')]//following-sibling::a")
    private WebElement btnAddToCart;

    private WebElement productImg(String product) {
        return driver.findElement(By.xpath("//div[contains(@class, 'features_items')]//../p[contains(text(), '"+product+"')]//preceding-sibling::img"));
    }

    private WebElement btnAddToCart(String product) {
        //return driver.findElement(By.xpath("//div[contains(@class, 'features_items')]//../p[contains(text(), 'Blue Top')]//preceding-sibling::img"));
        return driver.findElement(By.xpath("//div[contains(@class, 'features_items')]//../div[contains(@class,'product-overlay')]//../p[contains(text(), 'Blue Top')]//following-sibling::a"));
    }

    @FindBy(xpath = "//button[contains(text(), 'Continue Shopping')]")
    private WebElement btnContinueShopping;

    @FindBy(xpath = "//li//a[contains(text(), 'Cart')]")
    private WebElement btnViewCart;

    @FindBy(xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement btnProceedToCheckout;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]/b")
    private WebElement loggedInAsUser;


    private WebElement featuredItemsHeader() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Features Items')]"));
    }
    public boolean isHomePageVisible() {
        return featuredItemsHeader.isDisplayed();
    }

    public void addProductToCard(String productName) {

        scrollIntoView(driver, productImages.get(0));

        hoverOverElement(driver, productImg(productName));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        btnAddToCart(productName).click();

        jsClick(driver, btnAddToCart(productName));

        clickByActions(driver, btnAddToCart(productName));

        waitUntilElementVisible(driver, btnContinueShopping);

        btnContinueShopping.click();

    }

    public PageViewCart viewCart() {
        btnViewCart.click();
        return PageFactory.initElements(driver, PageViewCart.class);
    }

    public String getLoggedInAsUser() {

        waitUntilElementVisible(driver, loggedInAsUser);

        return loggedInAsUser.getText();
    }


}
