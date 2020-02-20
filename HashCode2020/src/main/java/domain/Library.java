package main.java.domain;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Integer id;
    private List<Book> bookList;
    private Integer signUpDuration;
    private Integer numberOfBooksToShip;

    private Integer totalPossibleScore;
    private Integer highsterScoringBook;

    private List<Book> booksToScan = new ArrayList<>();

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

        List<Book> aList = new ArrayList<Book>(reverseSortedMap.keySet());
        int currentBookIndex = 0;

        Float totalNumberOfDaysLeftOver = Float.valueOf(maxNumberOfDays - currentNumberOfDays);

        if(this.getNumberOfBooksToShip() > totalNumberOfDaysLeftOver) {
            totalNumberOfDaysLeftOver = Float.valueOf(this.getNumberOfBooksToShip());
        } else {
            totalNumberOfDaysLeftOver *= this.getNumberOfBooksToShip();
        }

        float maxIndex = Math.min(totalNumberOfDaysLeftOver, this.bookList.size());

        this.booksToScan.addAll(aList.subList(0, (int) maxIndex));
        System.out.println("Library " + getId() + " " + this.booksToScan.size());
    }
}
