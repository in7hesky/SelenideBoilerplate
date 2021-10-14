package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage extends BasePage{
    public SelenideElement recommendedResult = $("#best-bet-1 h4");

    public SearchResultsPage(String pageUrl) {
        super(pageUrl);
        recommendedResult.shouldBe(visible);
    }

    public String getRecommendedText() {
        System.out.println(Driver.currentDriver().getCurrentUrl());
        return recommendedResult.text();
    }


}
