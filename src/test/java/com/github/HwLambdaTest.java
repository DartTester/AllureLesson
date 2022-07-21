package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.TestBase;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class HwLambdaTest extends TestBase {
    private final String REPONAME = "allure-framework/allure-gradle";
    private final Integer ISSUE_NUMBER = 90;

    @DisplayName("Github lambda test")
    @Test
    @Owner("Daniil")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Работа поиска на гитхаб")
    @Story("Осуществляется поиск по issue")
    @Description("Чекаем работу лямбда степов")
    @Link(name = "GitHub", url = "https://github.com")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий по имени " + REPONAME, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPONAME);
            $(".header-search-input").submit();
        });
        step("В результатах поиска переходим по ссылке репозитория " + REPONAME, () -> {
            $(linkText("allure-framework/allure-gradle")).click();
        });
        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue c номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
