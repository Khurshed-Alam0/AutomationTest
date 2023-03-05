package pages;

import common.BasePage;
import model.AccountDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageSignup extends BasePage {

    private WebDriver driver;

    public PageSignup(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type = 'radio'][@id = 'id_gender1']")
    private WebElement btnRadioMr;

    @FindBy(xpath = "//input[@type = 'radio'][@id = 'id_gender2']")
    private WebElement btnRadioMrs;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#days")
    private WebElement dayDropDown;

    @FindBy(css = "#months")
    private WebElement monthDropDown;

    @FindBy(css = "#years")
    private WebElement yearDropDown;

    @FindBy(css = "#first_name")
    private WebElement firstName;

    @FindBy(css = "#last_name")
    private WebElement lastName;

    @FindBy(css = "#address1")
    private WebElement address;

    @FindBy(css = "#country")
    private WebElement country;

    @FindBy(css = "#state")
    private WebElement state;

    @FindBy(css = "#city")
    private WebElement city;

    @FindBy(css = "#zipcode")
    private WebElement zipcode;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[contains(text(), 'Create Account')]")
    private WebElement btnCreateAccount;

    public PageAccountCreated fillUpSignupDetails(AccountDetails accountDetails) {

        btnRadioMr.click();

        password.click();
        password.sendKeys(accountDetails.getPassword());

        Select select = new Select(dayDropDown);
        select.selectByVisibleText(accountDetails.getDayOfDob());

        Select selectDay = new Select(dayDropDown);
        selectDay.selectByVisibleText(accountDetails.getDayOfDob());

        Select selectMonth = new Select(monthDropDown);
        selectMonth.selectByVisibleText(accountDetails.getMonthOfDob());

        Select selectYear = new Select(yearDropDown);
        selectYear.selectByVisibleText(accountDetails.getYearOfDob());

        firstName.sendKeys(accountDetails.getFirstName());

        lastName.sendKeys(accountDetails.getLastName());

        address.sendKeys(accountDetails.getAddress());

        country.sendKeys(accountDetails.getCountry());

        state.sendKeys(accountDetails.getState());

        city.sendKeys(accountDetails.getCity());

        zipcode.sendKeys(accountDetails.getZipcode());

        mobileNumber.sendKeys(accountDetails.getMobileNumber());

        btnCreateAccount.click();

        return PageFactory.initElements(driver, PageAccountCreated.class);

    }

}
