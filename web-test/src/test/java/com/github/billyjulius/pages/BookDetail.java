package com.github.billyjulius.pages;

import com.github.billyjulius.helper.Book;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class BookDetail extends PageObject {
    @FindBy(xpath = "//div[@id='title-wrapper']//label[@id='userName-value']")
    WebElementFacade titleLabel;

    @FindBy(xpath = "//div[@id='author-wrapper']//label[@id='userName-value']")
    WebElementFacade authorLabel;

    @FindBy(xpath = "//div[@id='publisher-wrapper']//label[@id='userName-value']")
    WebElementFacade publisherLabel;

    public void checkBook(Book book) {
        Assert.assertEquals(book.getTitle(), titleLabel.getText());
        Assert.assertEquals(book.getAuthor(), authorLabel.getText());
        Assert.assertEquals(book.getPublisher(), publisherLabel.getText());
    }
}
