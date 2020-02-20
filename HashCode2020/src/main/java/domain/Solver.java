package main.java.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solver {
    private ProblemStatement problemStatement;

    public Solver(ProblemStatement problemStatement) {
        this.problemStatement = problemStatement;
    }

    public void solve() {
        Solution solution = new Solution();

        Integer currentNumberOfDays = 0;
        LinkedHashMap<Library, Integer> sortedByHighestValueBooks = determineHighYieldLibraries();

        for(Library library : sortedByHighestValueBooks.keySet()) {

            if(currentNumberOfDays < this.problemStatement.getTotalNumberOfScanningDays()) {
                currentNumberOfDays += library.getSignUpDuration();
                solution.numberOfLibrariesToSignUp += 1;
                solution.libraries.add(library);

                // determine which books to scan
                library.determineBooksToBeScanned(currentNumberOfDays, this.problemStatement.getTotalNumberOfScanningDays());
            }
        }
    }

    public LinkedHashMap<Library, Integer> determineHighYieldLibraries() {
        for(Library library : this.problemStatement.getLibraryList()) {

            int totalScore = 0;
            int bestScoringBook = 0;

            for(Book book : library.getBookList()) {
                totalScore += book.getScore();

                if(bestScoringBook < book.getScore()) {
                    bestScoringBook = book.getScore();
                }
            }

            library.setTotalPossibleScore(totalScore);
            library.setHighsterScoringBook(bestScoringBook);
        }


        Map<Library,Integer> mapping = this.problemStatement.getLibraryList().stream().collect(Collectors.toMap(x->x, x->x.getTotalPossibleScore()));

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<Library, Integer> reverseSortedMap = new LinkedHashMap<>();

        mapping.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return reverseSortedMap;
    }

}
