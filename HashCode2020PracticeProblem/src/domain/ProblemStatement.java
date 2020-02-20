package domain;

import java.util.List;

public class ProblemStatement {

    private PizzaOrder pizzaOrder;
    private List<Pizza> pizzaList;

    public ProblemStatement(PizzaOrder pizzaOrder, List<Pizza> pizzaList) {
        this.pizzaOrder = pizzaOrder;
        this.pizzaList = pizzaList;
    }

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
