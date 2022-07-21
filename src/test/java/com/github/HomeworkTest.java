package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.TestBase;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class HomeworkTest extends TestBase {

    @DisplayName("Homework github test")
    @Test
    public void githubIssueTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").setValue("allure-framework/allure-gradle").pressEnter();
        $(linkText("allure-framework/allure-gradle")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#921")).should(Condition.exist);
    }

}
