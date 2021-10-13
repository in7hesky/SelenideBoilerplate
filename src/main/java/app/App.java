package app;

import app.pages.ArticlePage;
import app.pages.MainPage;
import app.pages.TopicsPage;

public class App {

    public MainPage mainPage;
    public TopicsPage topicsPage;
    public ArticlePage articlePage;

    public App() {
        mainPage = PageBuilder.buildMainPage();
        topicsPage = PageBuilder.buildTopicsPage();
        articlePage = PageBuilder.buildArticlePage();
    }
}
