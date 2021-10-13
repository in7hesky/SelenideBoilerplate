package app;

import app.pages.MainPage;
import app.pages.TopicsPage;

public class App {

    public MainPage mainPage;
    public TopicsPage topicsPage;

    public App() {
        mainPage = PageBuilder.buildMainPage();
        topicsPage = PageBuilder.buildTopicsPage();
    }
}
