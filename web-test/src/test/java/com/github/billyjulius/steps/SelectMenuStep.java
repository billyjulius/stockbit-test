package com.github.billyjulius.steps;

import com.github.billyjulius.pages.SelectMenu;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SelectMenuStep {

    @Page
    SelectMenu selectMenuPage;

    @Step
    public void gotToSelectMenuPage(String url) {
        selectMenuPage.setDefaultBaseUrl(url);
        selectMenuPage.open();
    }

    @Step
    public void selectGroupOption() {
        selectMenuPage.selectGroupInput();
    }

    @Step
    public void selectOneOption() {
        selectMenuPage.selectOneInput();
    }

    @Step
    public void oldSelectOption(String value) {
        selectMenuPage.selectOldInput(value);
    }

    @Step
    public void multipleSelectOption() {
        selectMenuPage.multiSelectInput();
    }
}
