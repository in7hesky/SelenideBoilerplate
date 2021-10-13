package app.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public SelenideElement searchField = $("#ember26");

    public SelenideElement moreStoriesButton = $("#trending");
    public ElementsCollection storiesVisible = $$(byXpath("//div[@id='cards']//*[@class='bg-card-canvas']"));

    public MainPage(String pageUrl) {
        super(pageUrl);
    }



    public boolean canGetMoreStories() {
        moreStoriesButton.scrollIntoView(false);
        int storiesInitialAmount = storiesVisible.size();
        moreStoriesButton.click();
        return storiesVisible.size() > storiesInitialAmount;
    }

    public SearchResultsPage searchFor(String inputText) {
        searchField.click();
        searchField.setValue(inputText).submit();
        return new SearchResultsPage("");
    }

    public List<String> getDropdownList(String dropdownName) {
        SelenideElement targetDropdown = $(byXpath(String.format("//*[contains(text(), '%s')]/parent::a/parent::li",
                dropdownName))).hover();
        return targetDropdown.findAll("li a").texts().subList(1, 4);
    }

}
