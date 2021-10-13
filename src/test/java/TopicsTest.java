import org.testng.annotations.Test;

public class TopicsTest extends A_BaseTest {

    @Test
    public void openTopicsPage() throws InterruptedException {
        app.topicsPage.open();
    }
}
