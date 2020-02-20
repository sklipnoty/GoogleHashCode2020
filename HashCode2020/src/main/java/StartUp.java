package main.java;

import main.java.domain.*;
import main.java.io.InputReader;
import main.java.io.OutputWriter;

import java.util.ArrayList;

public class StartUp {
    public static void main(String args[]) {
        InputReader inputReader = new InputReader();

        //ProblemStatement problemStatement = inputReader.readProblemStatement();
        //ProblemStatement problemStatement = inputReader.readProblemStatement();

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("input/a_example.txt");
        inputs.add("input/b_read_on.txt");
        inputs.add("input/c_incunabula.txt");
        inputs.add("input/d_tough_choices.txt");
        inputs.add("input/e_so_many_books.txt");
        inputs.add("input/f_libraries_of_the_world.txt");

        for(String input : inputs) {
            System.out.println("Solving " + input);


            int maxScore = 0;

            for(int i = 0; i < 1000; i++) {
                ProblemStatement problemStatement = inputReader.readProblemStatement(input);

                Solver solver = new Solver(problemStatement);
                Solution sol = solver.solve();

                int score = 0;

                for(Library library : sol.libraries) {
                    for(Book book : library.getBooksToScan()) {
                        score += book.getScore();
                    }
                }

                if(score > maxScore) {
                    OutputWriter outputWriter = new OutputWriter();
                    String[] output = input.split("/");
                    outputWriter.writeOutput(output[1], sol);
                    maxScore = score;
                }
            }

            System.out.println(maxScore);
        }
    }
}
