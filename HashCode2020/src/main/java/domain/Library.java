package main.java.domain;

import java.util.List;

public class Library {
    private List<Book> bookList;
    private Integer signUpDuration;
    private Integer numberOfBooksToShip;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Integer getSignUpDuration() {
        return signUpDuration;
    }

    public void setSignUpDuration(Integer signUpDuration) {
        this.signUpDuration = signUpDuration;
    }

    public Integer getNumberOfBooksToShip() {
        return numberOfBooksToShip;
    }

    public void setNumberOfBooksToShip(Integer numberOfBooksToShip) {
        this.numberOfBooksToShip = numberOfBooksToShip;
    }
}
