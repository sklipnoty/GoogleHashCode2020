package main.java.domain;

import java.util.List;

public class ProblemStatement {

    private Integer totalNumberOfBooks;
    private Integer totalNumberOfLibraries;
    private Integer totalNumberOfScanningDays;

    private List<Library> libraryList;

    public Integer getTotalNumberOfBooks() {
        return totalNumberOfBooks;
    }

    public void setTotalNumberOfBooks(Integer totalNumberOfBooks) {
        this.totalNumberOfBooks = totalNumberOfBooks;
    }

    public Integer getTotalNumberOfLibraries() {
        return totalNumberOfLibraries;
    }

    public void setTotalNumberOfLibraries(Integer totalNumberOfLibraries) {
        this.totalNumberOfLibraries = totalNumberOfLibraries;
    }

    public Integer getTotalNumberOfScanningDays() {
        return totalNumberOfScanningDays;
    }

    public void setTotalNumberOfScanningDays(Integer totalNumberOfScanningDays) {
        this.totalNumberOfScanningDays = totalNumberOfScanningDays;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    @Override
    public String toString() {
        return "ProblemStatement{" +
                "totalNumberOfBooks=" + totalNumberOfBooks +
                ", totalNumberOfLibraries=" + totalNumberOfLibraries +
                ", totalNumberOfScanningDays=" + totalNumberOfScanningDays +
                ", libraryList=" + libraryList +
                '}';
    }
}
