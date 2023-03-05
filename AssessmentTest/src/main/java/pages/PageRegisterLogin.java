package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRegisterLogin extends BasePage {

    private WebDriver driver;

    public PageRegisterLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//input[@name = 'email' and @data-qa = 'signup-email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//button[contains(text(), 'Signup')]")
    private WebElement btnSignUp;


    public PageSignup register(String name, String email) {

        nameTextField.click();
        nameTextField.sendKeys(name);

        emailTextField.click();
        emailTextField.sendKeys(email);

        btnSignUp.click();

        return PageFactory.initElements(driver, PageSignup.class);
    }



}
