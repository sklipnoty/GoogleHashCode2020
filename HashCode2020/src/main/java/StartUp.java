package main.java;

import main.java.domain.ProblemStatement;
import main.java.domain.Solution;
import main.java.domain.Solver;
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
            ProblemStatement problemStatement = inputReader.readProblemStatement(input);
            Solver solver = new Solver(problemStatement);
            Solution sol = solver.solve();

            OutputWriter outputWriter = new OutputWriter();

            String[] output = input.split("/");

            outputWriter.writeOutput(output[1], sol);
        }
    }
}
