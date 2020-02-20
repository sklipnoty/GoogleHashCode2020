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

    private Integer heuristicNumber;
    private Integer uniqueNessFactor;

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

    public Integer getHeuristicNumber() {
        return heuristicNumber;
    }

    public void setHeuristicNumber(Integer heuristicNumber) {
        this.heuristicNumber = heuristicNumber;
    }

    public Integer getUniqueNessFactor() {
        return uniqueNessFactor;
    }

    public void setUniqueNessFactor(Integer uniqueNessFactor) {
        this.uniqueNessFactor = uniqueNessFactor;
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

    public void determineBooksToBeScanned(Integer currentNumberOfDays, Integer maxNumberOfDays, Set<Book> alreadyScanned) {
        Map<Book,Integer> mapping = this.bookList.stream().collect(Collectors.toMap(x->x, x->x.getScore()));

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<Book, Integer> reverseSortedMap = new LinkedHashMap<>();

        mapping.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));


        List<Book> aList = new ArrayList<Book>(reverseSortedMap.keySet());
        int currentBookIndex = 0;

        if(alreadyScanned.size() > 0) {
            aList.removeAll(alreadyScanned);
        }

        Float totalNumberOfDaysLeftOver = Float.valueOf(maxNumberOfDays - currentNumberOfDays);

        if(this.getNumberOfBooksToShip() > totalNumberOfDaysLeftOver) {
            totalNumberOfDaysLeftOver = Float.valueOf(this.getNumberOfBooksToShip());
        } else {
            totalNumberOfDaysLeftOver *= this.getNumberOfBooksToShip();
        }

        float maxIndex = Math.min(totalNumberOfDaysLeftOver, aList.size());

        if(maxIndex != 0) {
            this.booksToScan.addAll(aList.subList(0, (int) maxIndex));
        } else {
            this.booksToScan.add(this.bookList.get(0));
        }


      //  System.out.println("Library " + getId() + " " + this.booksToScan.size());
        alreadyScanned.addAll(aList.subList(0, (int) maxIndex));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(id, library.id) &&
                Objects.equals(bookList, library.bookList) &&
                Objects.equals(signUpDuration, library.signUpDuration) &&
                Objects.equals(numberOfBooksToShip, library.numberOfBooksToShip) &&
                Objects.equals(totalPossibleScore, library.totalPossibleScore) &&
                Objects.equals(highsterScoringBook, library.highsterScoringBook) &&
                Objects.equals(heuristicNumber, library.heuristicNumber) &&
                Objects.equals(uniqueNessFactor, library.uniqueNessFactor) &&
                Objects.equals(booksToScan, library.booksToScan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
