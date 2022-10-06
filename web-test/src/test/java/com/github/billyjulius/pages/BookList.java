package com.github.billyjulius.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.github.billyjulius.helper.Book;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookList extends PageObject {
    @FindBy(xpath = "//input[@id='searchBox']")
    WebElementFacade seachBox;

    public void searchBook(String book) {
        seachBox.sendKeys(book);
    }

    @FindBy(xpath = "//div[@class='rt-noData']")
    WebElementFacade tableMessage;

    public void checkMessage(String message) {
        tableMessage.waitUntilVisible();
        Assert.assertEquals(message, tableMessage.getText());
    }

    @FindBy(xpath = "//div[@role='rowgroup']")
    WebElementFacade bookList;

    public Book getBookDetail(String bookTitle) {
        Book book = new Book();

        WebElement titleElement = bookList.findElement(By.xpath("//div[@class='rt-td'][2]"));
        WebElement authorElement = bookList.findElement(By.xpath("//div[@class='rt-td'][3]"));
        WebElement publisherElement = bookList.findElement(By.xpath("//div[@class='rt-td'][4]"));
        if(titleElement.getText().equals(bookTitle)) {
            book.setTitle(titleElement.getText());
            book.setAuthor(authorElement.getText());
            book.setPublisher(publisherElement.getText());
        } else {
            throw new ElementNotFoundException(titleElement.getTagName(), "text", bookTitle);
        }

        return book;
    }

    public void clikBook(String bookTitle) {
        getDriver().findElement(By.xpath("//a[text()='"+bookTitle+"']")).click();
    }
}
