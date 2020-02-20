package io;

import domain.Pizza;
import domain.PizzaOrder;
import domain.ProblemStatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public ProblemStatement readProblem(String fileName) {
        Path path = Paths.get(fileName);
        Path absolutePath = path.toAbsolutePath();

        try {
            List<String> lines = Files.readAllLines(absolutePath);
            String[] p = lines.get(0).split(" ");

            PizzaOrder order = new PizzaOrder(Integer.valueOf(p[0]), Integer.valueOf(p[1]));

            List<Pizza> pizzaList = new ArrayList<>();

            String[] pizzas = lines.get(1).split(" ");

            for(String pizza : pizzas) {
                pizzaList.add(new Pizza(Integer.valueOf(pizza)));
            }

            return new ProblemStatement(order, pizzaList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
