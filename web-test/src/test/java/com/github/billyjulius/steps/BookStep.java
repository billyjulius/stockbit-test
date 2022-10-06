package com.github.billyjulius.steps;

import com.github.billyjulius.helper.Book;
import com.github.billyjulius.pages.BookDetail;
import com.github.billyjulius.pages.BookList;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class BookStep {

    @Page
    BookList bookListPage;

    @Page
    BookDetail bookDetailPage;

    @Step
    public void goToBooksPage(String url) {
        bookListPage.setDefaultBaseUrl(url);
        bookListPage.open();
    }

    @Step
    public void searchBook(String title) {
        bookListPage.searchBook(title);
    }

    @Step
    public void checkSearchMessage(String message) {
        bookListPage.checkMessage(message);
    }

    @Step
    public void clickBookDetail(String title) {
        Book book = bookListPage.getBookDetail(title);
        Serenity.setSessionVariable("book").to(book);

        bookListPage.clikBook(title);
    }

    @Step
    public void checkBookDetail() {
        Book book = Serenity.sessionVariableCalled("book");
        bookDetailPage.checkBook(book);
    }
}
