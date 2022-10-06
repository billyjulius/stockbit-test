package com.github.billyjulius.definitions;

import com.github.billyjulius.steps.BookStep;
import com.github.billyjulius.steps.SelectMenuStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {

    @Steps
    BookStep bookStep;

    @Steps
    SelectMenuStep selectMenuStep;

    @Given("User go to {string}")
    public void userGoToPage(String url) {
        if(url.contains("books")) {
            bookStep.goToBooksPage(url);
        } else {
            selectMenuStep.gotToSelectMenuPage(url);
        }

    }

    @When("User in {string} page")
    public void userInPage(String page) {
    }

    @And("User choose select value \"Another root option\"")
    public void userChooseSelectValue() {
        selectMenuStep.selectGroupOption();
    }

    @And("User choose select one {string}")
    public void userChooseSelectOne(String value) {
        selectMenuStep.selectOneOption();
    }

    @And("User choose old style select menu {string}")
    public void userChooseOldStyleSelectMenu(String value) {
        selectMenuStep.oldSelectOption(value);
    }

    @And("User choose multi select drop down {string}")
    public void userChooseMultiSelectDropDown(String value) {
         selectMenuStep.multipleSelectOption();
    }

    @Then("^User success input all select menu$")
    public void userSuccessInputAllSelectMenu() {
    }

    @And("User search book {string}")
    public void userSearchBook(String book) {
        bookStep.searchBook(book);
    }

    @Then("User see {string}")
    public void userSee(String message) {
        if(message.contains("No rows found")) {
            bookStep.checkSearchMessage(message);
        } else {
            bookStep.checkBookDetail();
        }

    }

    @And("User click book {string}")
    public void userClickBook(String title) {
        bookStep.clickBookDetail(title);
    }
}
