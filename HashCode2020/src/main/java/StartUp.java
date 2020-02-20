package main.java;

import main.java.domain.ProblemStatement;
import main.java.io.InputReader;

public class StartUp {
    public static void main(String args[]) {
        InputReader inputReader = new InputReader();
        ProblemStatement problemStatement = inputReader.readProblemStatement("input/a_example.txt");

        System.out.println(problemStatement);
    }
}
