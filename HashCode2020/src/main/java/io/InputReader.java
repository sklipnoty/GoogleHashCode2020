package main.java.io;

import main.java.domain.Book;
import main.java.domain.Library;
import main.java.domain.ProblemStatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public InputReader() {}

    public ProblemStatement readProblemStatement(String fileName) {
        Path path = Paths.get(fileName);
        Path absolutePath = path.toAbsolutePath();
        ProblemStatement problemStatement = new ProblemStatement();

        try {
            List<String> lines = Files.readAllLines(absolutePath);

            String[] firstLine = lines.get(0).split(" ");
            int numberOfBooks = Integer.valueOf(firstLine[0]);
            int numberOfLibraries = Integer.valueOf(firstLine[1]);
            int daysForScanning = Integer.valueOf(firstLine[2]);

            problemStatement.setTotalNumberOfBooks(numberOfBooks);
            problemStatement.setTotalNumberOfScanningDays(daysForScanning);
            problemStatement.setTotalNumberOfLibraries(numberOfLibraries);

            String[] secondLine = lines.get(1).split(" ");
            List<Library> libraries = new ArrayList<>();

            for(int i = 2;i < lines.size(); i=i+2) {
                String[] firstLibLine = lines.get(i).split(" ");
                String[] secondLibLine = lines.get(i+1).split(" ");

                Library library = new Library();
                library.setNumberOfBooksToShip(Integer.valueOf(firstLibLine[2]));
                library.setSignUpDuration(Integer.valueOf(firstLibLine[1]));
                Integer numberOfBooksInLib = Integer.valueOf(firstLibLine[0]);
                List<Book> books = new ArrayList<>();

                for(int j = 0; j < numberOfBooksInLib; j++) {
                    Book book = new Book();
                    book.setBookId(Integer.valueOf(secondLibLine[j]));
                    book.setScore(Integer.valueOf(secondLine[Integer.valueOf(secondLibLine[j])]));
                    books.add(book);
                }

                library.setBookList(books);
                libraries.add(library);
            }

            problemStatement.setLibraryList(libraries);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return problemStatement;

    }
}
