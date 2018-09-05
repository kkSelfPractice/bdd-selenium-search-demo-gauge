package com.thoughtworks.gauge.maven;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.maven.utils.BaseDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepImplementation {

    WebDriver driver = BaseDriverClass.getDriver();
    //Todo declare all web elements commonly to avoid possible redundancy

    @Step("Navigate to <https://www.google.co.in> site")
    public void navigateTo(String url){
        driver.get(url);
        BaseDriverClass.waitUntilPageLoad();
    }

    @Step("Enter query <query> in the search box")
    public void enterQuery(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        BaseDriverClass.fluentlyWaitUntilElementIsVisible(searchBox);
        searchBox.sendKeys(query);
    }

    @Step("Verify suggestion is displayed")
    public void enterQuery() {
        WebElement suggestionList = driver.findElement(By.className("gstl_0"));
        BaseDriverClass.fluentlyWaitUntilElementIsVisible(suggestionList);
        assertTrue(suggestionList.isDisplayed());
    }

    @Step("Click on find button")
    public void clickFind() {
        WebElement searchButton = driver.findElement(By.name("btnG"));
        searchButton.submit();
        BaseDriverClass.waitUntilPageLoad();
    }

    @Step("Verify Dictionary is shown with <word> as result")
    public void verifySearchResult(String resultString) {
        WebElement result = driver.findElement(By.className("dDoNo"));
        BaseDriverClass.fluentlyWaitUntilElementIsVisible(result);
        assertEquals(resultString, result.getText());
    }
}
