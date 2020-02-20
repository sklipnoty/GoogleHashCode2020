package main.java.domain;

import java.util.Objects;

public class Book {
    private Integer bookId;
    private Integer score;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) &&
                Objects.equals(score, book.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
