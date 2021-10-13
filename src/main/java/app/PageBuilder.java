package app;

import app.pages.ArticlePage;
import app.pages.MainPage;
import app.pages.TopicsPage;

public class PageBuilder {

    public static MainPage buildMainPage() {
        return new MainPage("/");
    }

    public static TopicsPage buildTopicsPage() {
        return new TopicsPage("/topics");
    }

    public static ArticlePage buildArticlePage() {
        return new ArticlePage("/centers/kennedy/launchingrockets/viewing.html");
    }
}
