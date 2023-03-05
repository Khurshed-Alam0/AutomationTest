package test_scripts;

import com.thedeanda.lorem.LoremIpsum;
import model.AccountDetails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductBuyFlowTest extends BaseTest {

    private PageHome pageHome;

    private PageViewCart pageViewCart;

    private PagePayment pagePayment;

    private PagePaymentDone pagePaymentDone;

    private PageRegisterLogin pageRegisterLogin;

    private PageSignup pageSignup;

    private PageAccountCreated pageAccountCreated;

    @Test
    public void userShouldBeAbleToBuyProduct() throws InterruptedException {

        assertThat(pageHome.isHomePageVisible()).isTrue();

        pageHome.addProductToCard("Blue Top");

        pageViewCart = pageHome.viewCart();

        assertThat(pageViewCart.isViewCartPageVisible()).isTrue();

        pageViewCart.clickProceedToCheckOut();

        pageRegisterLogin = pageViewCart.clickRegisterLoginBtn();

        AccountDetails accountDetails = getRandomAccountDetails();

        pageSignup = pageRegisterLogin.register(accountDetails.getName(), accountDetails.getEmail());

        pageAccountCreated = pageSignup.fillUpSignupDetails(accountDetails);

        pageHome = pageAccountCreated.clickContinue();

        Thread.sleep(5000);

        assertThat(pageHome.getLoggedInAsUser()).isEqualTo(accountDetails.getName());

        pageViewCart = pageHome.viewCart();

        pageViewCart.clickProceedToCheckOut();

        assertThat(pageViewCart.isAddressDetailsHeaderDisplayed()).isTrue();

        assertThat(pageViewCart.isVerifyYourOrderHeaderDisplayed()).isTrue();

        pageViewCart.writeComment("Test description");

        PagePayment pagePayment = pageViewCart.placeOrder();

        pagePaymentDone = pagePayment.enterPaymentDetails();

        assertThat(pagePaymentDone.getOrderConfirmationMessage()).isEqualTo("Congratulations! Your order has been confirmed!");

    }

    private AccountDetails getRandomAccountDetails() {

        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setName("Khurshed Alam");

        accountDetails.setEmail(LoremIpsum.getInstance().getEmail());

        accountDetails.setFirstName("Khurshed");

        accountDetails.setLastName("Alam");

        accountDetails.setAddress("Gobindhapur");

        accountDetails.setCountry("Canada");

        accountDetails.setState("narayanganj");

        accountDetails.setCity("Sonargaon");

        accountDetails.setZipcode("1440");

        accountDetails.setMobileNumber("01914824548");

        accountDetails.setPassword("123456");

        accountDetails.setDayOfDob("5");

        accountDetails.setMonthOfDob("June");

        accountDetails.setYearOfDob("1991");

        return  accountDetails;
    }

    @BeforeMethod
    public void setUp() {
        _driver = init();
        pageHome = new PageHome(_driver);
        //pageViewCart = new PageViewCart(_driver);
    }
}
