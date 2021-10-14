import app.App;
import helpers.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

class A_BaseTest {

    protected App app;
    protected SoftAssert softAssert;
    protected Logger logger;

    @BeforeClass
    public void setUp() {

        //WebDriverManager..setup();

        app = new App();
        softAssert = new SoftAssert();

        logger = LogManager.getLogger("");
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

//    @BeforeTest
//    public void initiateDriver() {
//        driver = new ChromeDriver();
//    }


//    @AfterMethod
//    public void clearCookies() {
//        Driver.clearCookies();
//    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
