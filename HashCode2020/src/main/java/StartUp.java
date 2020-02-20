package main.java;

import main.java.domain.ProblemStatement;
import main.java.domain.Solver;
import main.java.io.InputReader;

public class StartUp {
    public static void main(String args[]) {
        InputReader inputReader = new InputReader();

        //ProblemStatement problemStatement = inputReader.readProblemStatement("input/a_example.txt");
        //ProblemStatement problemStatement = inputReader.readProblemStatement("input/b_read_on.txt");

        ProblemStatement problemStatement = inputReader.readProblemStatement("input/c_incunabula.txt");
        Solver solver = new Solver(problemStatement);
        solver.solve();

        System.out.println(problemStatement);
    }
}
