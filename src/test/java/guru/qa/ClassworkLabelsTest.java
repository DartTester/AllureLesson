package guru.qa;

import io.qameta.allure.Allure;
        import io.qameta.allure.Description;
        import io.qameta.allure.Feature;
        import io.qameta.allure.Link;
        import io.qameta.allure.Owner;
        import io.qameta.allure.Severity;
        import io.qameta.allure.SeverityLevel;
        import io.qameta.allure.Story;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;

public class ClassworkLabelsTest {

    @Test
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Работа с лейбочками")
    @Story("Над тестом можно проставить статические лейбочки")
    @DisplayName("Самый прекрасный тест")
    @Description("Этот тест проверяет очень важную функцоинальность...")
    @Link(name = "GitHub", url = "https://github.com")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Работа с лейбочками");
        Allure.story("Внутри теста можно выставлять динамические лейбочки");
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("Не самый прекрасный тест"));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("Этот тест проверяет очень " +
                "важную функцоинальность..."));
        Allure.link("GitHub", "https://guthub.com");
    }

    @Test
    public void testParameters() {
        Allure.parameter("Город", "Москва");
        Allure.parameter("Область", "Московская");
    }

}