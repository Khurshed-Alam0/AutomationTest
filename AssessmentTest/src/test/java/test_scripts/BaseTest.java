package test_scripts;

import initialization.Initialization;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Initialization {

    /*@BeforeSuite
    public void setUp() {

        if (_driver == null) {
            init();
        }
    }*/

    @AfterMethod
    public void tearDown() {
        _driver.quit();
    }
}
