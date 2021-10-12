import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Owner("in7hesky")
public class ExampleTest extends A_BaseTest
{
    @Test
    @Feature("login")
    @Description("trying to describe a test")
    @Severity(SeverityLevel.CRITICAL)
    public void loginViaEmail() {
        app.loginPage.open();
        app.loginPage.login("tomsmith", "SuperSecretPassword!");

        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");

        softAssert.assertEquals(2,2);
        softAssert.assertAll();
    }
}
