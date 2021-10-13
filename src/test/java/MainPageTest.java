import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Owner("Anton Maiko")
public class MainPageTest extends A_BaseTest {
    public static final String SEARCH_TARGET = "Careers at NASA";
    public static final String SEARCH_INPUT = "Careers";

    public static final String DROPDOWN_NAME = "NASA Audiences";


    @Test
    @Feature("login")
    @Description("trying to describe a test")
    @Severity(SeverityLevel.CRITICAL)
    public void canGetMoreStoriesTest() {
        app.mainPage.open();
        Assert.assertTrue(app.mainPage.canGetMoreStories());
    }

    @Test
    public void canGetValidSearchResultTest() {
        app.mainPage.open();
        String searchOutput = app.mainPage.searchFor(SEARCH_INPUT).getRecommendedText();
        Assert.assertEquals(searchOutput.toLowerCase(), SEARCH_TARGET.toLowerCase());
    }

    @Test
    public void canSeeDropdownList() throws IOException, CsvValidationException {
        app.mainPage.open();
        List<String> dropdownList = app.mainPage.getDropdownList(DROPDOWN_NAME);
        String[] desiredList = new CSVReader(
                new FileReader("src/test/resources/dropdownList.csv")).readNext();

        for (int i = 0; i < 3; i++) {
            softAssert.assertEquals(dropdownList.get(i), desiredList[i]);
        }

        softAssert.assertAll();
    }
}
