package app.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public SelenideElement searchField = $(".full.ember-text-field");

    public SelenideElement moreStoriesButton = $("#trending");
    public ElementsCollection storiesVisible = $$(byXpath("//div[@id='cards']//*[@class='bg-card-canvas']"));

    public MainPage(String pageUrl) {
        super(pageUrl);
    }



    public boolean canGetMoreStories() {
        moreStoriesButton.should(exist).scrollIntoView(false).shouldBe(visible);
        int storiesInitialAmount = storiesVisible.size();
        moreStoriesButton.shouldBe(visible).click();
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(storiesVisible.size() + " " + storiesInitialAmount);
        return storiesVisible.size() > storiesInitialAmount;

        //storiesVisible.shouldBe(CollectionCondition.sizeGreaterThan(storiesInitialAmount));
    }

    public SearchResultsPage searchFor(String inputText) {
        searchField.shouldBe(visible);
        searchField.setValue(inputText).submit();
        return new SearchResultsPage("");
    }

    public List<String> getDropdownList(String dropdownName) {
        SelenideElement targetDropdown = $(byXpath(String.format("//*[contains(text(), '%s')]/parent::a/parent::li",
                dropdownName))).hover();
        return targetDropdown.findAll("li a").texts().subList(1, 4);
    }

}
