package main.java.io;

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
                String line = library.getId() +
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
