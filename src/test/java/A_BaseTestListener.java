import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import helpers.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class A_BaseTestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult TestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult TestResult) {
    }

    @Override
    public void onTestFailure(ITestResult TestResult) {
//        WebDriver driver = Driver.currentDriver();
//        if (driver != null)
//            takeScreenshot(driver);
        try {
            takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult TestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {

    }

    @Override
    public void onStart(ITestContext TestContext) {

    }

    @Override
    public void onFinish(ITestContext TestContext) {

    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] takeScreenshot() throws IOException, IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

//    @Attachment(value = "Page screenshot", type = "image/png")
//    protected byte[] takeScreenshot(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

}
