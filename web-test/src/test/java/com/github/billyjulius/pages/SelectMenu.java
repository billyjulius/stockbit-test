package com.github.billyjulius.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectMenu extends PageObject {
    @FindBy(xpath = "//div[@id='withOptGroup']")
    WebElementFacade selectGroup;

    @FindBy(xpath = "//div[@id='react-select-2-option-3']")
    WebElementFacade groupOption;

    public void selectGroupInput() {
        selectGroup.click();
        withAction().moveToElement(groupOption).perform();
        groupOption.waitUntilVisible();
        groupOption.click();
    }

    @FindBy(xpath = "//div[@id='selectOne']")
    WebElementFacade selectOne;

    @FindBy(xpath = "//div[@id='react-select-3-option-0-5']")
    WebElementFacade selectOneOtherOption;

    public void selectOneInput() {
        selectOne.waitUntilVisible();
        withAction().moveToElement(selectOne).perform();
        selectOne.click();

        selectOneOtherOption.waitUntilVisible();
        withAction().moveToElement(selectOneOtherOption).perform();
        selectOneOtherOption.click();
    }

    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElementFacade selectOldMenu;

    public void selectOldInput(String value) {
        Select se = new Select(selectOldMenu);
        se.selectByVisibleText(value);
    }

    @FindBy(xpath = "//div[text()='Select...']")
    WebElementFacade multiSelect;

    public void multiSelectInput() {
        withAction().moveToElement(multiSelect).perform();
        multiSelect.click();
        withAction().moveToElement(getDriver().findElement(By.xpath("//div[id='react-select-4-option-0']"))).perform();
        withAction().moveToElement(getDriver().findElement(By.xpath("//div[id='react-select-4-option-1']"))).perform();
        withAction().moveToElement(getDriver().findElement(By.xpath("//div[id='react-select-4-option-2']"))).perform();
        withAction().moveToElement(getDriver().findElement(By.xpath("//div[id='react-select-4-option-3']"))).perform();
    }
}
