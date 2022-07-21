package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HwAnnotatedStepsTest {

    private final String REPONAME = "allure-framework/allure-gradle";;
    private final Integer ISSUE_NUMBER = 91;

    @DisplayName("Github annotated test")
    @Test
    @Owner("Daniil")
    @Severity(SeverityLevel.MINOR)
    @Feature("Работа поиска на гитхаб")
    @Story("Осуществляется поиск по issue")
    @Description("Чекаем работу степов с аннотациями")
    @Link(name = "GitHub", url = "https://github.com")
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        HwWebSteps steps = new HwWebSteps();

        steps.openMainPageHw();
        steps.takeScreenshot();
        steps.searchForRepositoryHw(REPONAME);
        steps.openRepositoryLinkHw(REPONAME);
        steps.openIssueTabHw();
        steps.shouldSeeIssueWithNumberHw(ISSUE_NUMBER);
        steps.takeScreenshot();
    }
}
