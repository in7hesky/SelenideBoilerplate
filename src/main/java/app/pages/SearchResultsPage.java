package app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage extends BasePage{
    public SelenideElement recommendedResult = $("#best-bet-1 h4");

    public SearchResultsPage(String pageUrl) {
        super(pageUrl);
    }

    public String getRecommendedText(){
        return recommendedResult.text();
    }


}
