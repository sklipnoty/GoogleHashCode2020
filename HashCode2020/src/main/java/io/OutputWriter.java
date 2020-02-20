package main.java.io;

import main.java.domain.Book;
import main.java.domain.Library;
import main.java.domain.Solution;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {
    public OutputWriter(){}

    public void writeOutput(String fileName, Solution solution) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(solution.numberOfLibrariesToSignUp);
            printWriter.flush();

            for(Library library : solution.libraries) {
                String line = library.getId() + " " + library.getBooksToScan().size();
                printWriter.print("\n" + line);
                printWriter.flush();

                StringBuilder books = new StringBuilder();

                for(Book book : library.getBooksToScan()) {
                    books.append(book.getBookId() + " ");
                }

                printWriter.print("\n" + books.toString());
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
