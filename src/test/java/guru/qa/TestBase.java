package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAllBase() {
        Configuration.holdBrowserOpen = true;
//        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }


//    @AfterEach
//    void afterEach() {
//        Selenide.closeWindow();
//    }
}
