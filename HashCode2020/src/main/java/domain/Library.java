package main.java.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private Integer id;
    private List<Book> bookList;
    private Integer signUpDuration;
    private Integer numberOfBooksToShip;

    private Integer totalPossibleScore;
    private Integer highsterScoringBook;

    private List<Book> booksToScan;

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

    public Integer getTotalPossibleScore() {
        return totalPossibleScore;
    }

    public void setTotalPossibleScore(Integer totalPossibleScore) {
        this.totalPossibleScore = totalPossibleScore;
    }

    public Integer getHighsterScoringBook() {
        return highsterScoringBook;
    }

    public void setHighsterScoringBook(Integer highsterScoringBook) {
        this.highsterScoringBook = highsterScoringBook;
    }

    public List<Book> getBooksToScan() {
        return booksToScan;
    }

    public void setBooksToScan(List<Book> booksToScan) {
        this.booksToScan = booksToScan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", signUpDuration=" + signUpDuration +
                ", numberOfBooksToShip=" + numberOfBooksToShip +
                ", totalPossibleScore=" + totalPossibleScore +
                ", highsterScoringBook=" + highsterScoringBook +
                '}';
    }

    public void determineBooksToBeScanned(Integer currentNumberOfDays, Integer maxNumberOfDays) {
        Map<Book,Integer> mapping = this.bookList.stream().collect(Collectors.toMap(x->x, x->x.getScore()));

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<Book, Integer> reverseSortedMap = new LinkedHashMap<>();

        mapping.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        while(currentNumberOfDays < maxNumberOfDays) {
            for(int i = 0; i < this.getNumberOfBooksToShip(); i++) {
                //reverseSortedMap.keySet()
            }
        }
    }
}
