package main.java.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Solver {
    private ProblemStatement problemStatement;

    public Solver(ProblemStatement problemStatement) {
        this.problemStatement = problemStatement;
    }

    public Solution solve() {
        Solution solution = new Solution();

        Integer currentNumberOfDays = 0;
        LinkedHashMap<Library, Integer> sortedByHighestValueBooks = determineHighYieldLibraries();
        Set<Book> alreadyScanned = new HashSet<>();

        for(Library library : sortedByHighestValueBooks.keySet()) {

            if(currentNumberOfDays < this.problemStatement.getTotalNumberOfScanningDays() &&  currentNumberOfDays + library.getSignUpDuration() < this.problemStatement.getTotalNumberOfScanningDays() ) {
                currentNumberOfDays += library.getSignUpDuration();
                solution.numberOfLibrariesToSignUp += 1;
                solution.libraries.add(library);

                // determine which books to scan
                library.determineBooksToBeScanned(currentNumberOfDays, this.problemStatement.getTotalNumberOfScanningDays(), alreadyScanned);

                //System.out.println("Already scanned :  " + alreadyScanned.size());
            }
        }

        return solution;
    }

    public LinkedHashMap<Library, Integer> determineHighYieldLibraries() {

        Set<Book> allBooks = new HashSet<>();

        for(Library library : this.problemStatement.getLibraryList()) {
            allBooks.addAll(library.getBookList());
        }

        for(Library library : this.problemStatement.getLibraryList()) {

            allBooks.removeAll(library.getBookList());

            Set<Book> books = new HashSet<>(library.getBookList());
            books.removeAll(allBooks);

            library.setUniqueNessFactor(books.size() / 100);

            allBooks.addAll(library.getBookList());
        }

        for(Library library : this.problemStatement.getLibraryList()) {

            int totalScore = 0;
            int bestScoringBook = 0;
            double averageScore = 0.0;

            for(Book book : library.getBookList()) {
                totalScore += book.getScore();

                if(bestScoringBook < book.getScore()) {
                    bestScoringBook = book.getScore();
                }
            }

            averageScore = totalScore / library.getBookList().size();
         //   System.out.println(" " + averageScore);

            library.setTotalPossibleScore(totalScore);
            library.setHighsterScoringBook(bestScoringBook);
            //library.setHeuristicNumber((Integer) ((totalScore + bestScoringBook * library.getNumberOfBooksToShip() )/ ( library.getUniqueNessFactor() + problemStatement.getTotalNumberOfScanningDays() - library.getSignUpDuration())));

            double h1 = averageScore / library.getSignUpDuration();
            double h2 = totalScore / library.getSignUpDuration();
            double h3 = library.getBookList().size() / library.getSignUpDuration();
            double h4 = library.getUniqueNessFactor() / library.getSignUpDuration();

            Random r = new Random();

            double x1 = 0 + (1 - 0) * r.nextDouble();
            double x2 = 0 + ((1-x1) - 0) * r.nextDouble();
            double x3 = 0 + ((1-x1-x2) - 0) * r.nextDouble();
            double x4 = 1 - x1 - x2 - x3;

          //  System.out.println(x1 + " " + x2 + " " +x3+ " " + x4);

            int allH = (int) (x1 * h1 +x2 * h2 + x3 * h3 + x4* h4);

            library.setHeuristicNumber(allH);
        }

        Map<Library,Integer> mapping = this.problemStatement.getLibraryList().stream().collect(Collectors.toMap(x->x, x->x.getHeuristicNumber()));

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<Library, Integer> reverseSortedMap = new LinkedHashMap<>();

        mapping.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return reverseSortedMap;
    }

}
