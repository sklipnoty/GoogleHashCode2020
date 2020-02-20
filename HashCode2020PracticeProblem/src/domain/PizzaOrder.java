package domain;

public class PizzaOrder {
    private Integer maximumNumberOfSlices;
    private Integer maximumNumberOfPizzas;

    public PizzaOrder(Integer maximumNumberOfSlices, Integer maximumNumberOfPizzas) {
        this.maximumNumberOfSlices = maximumNumberOfSlices;
        this.maximumNumberOfPizzas = maximumNumberOfPizzas;
    }

    public Integer getMaximumNumberOfSlices() {
        return maximumNumberOfSlices;
    }

    public void setMaximumNumberOfSlices(Integer maximumNumberOfSlices) {
        this.maximumNumberOfSlices = maximumNumberOfSlices;
    }

    public Integer getMaximumNumberOfPizzas() {
        return maximumNumberOfPizzas;
    }

    public void setMaximumNumberOfPizzas(Integer maximumNumberOfPizzas) {
        this.maximumNumberOfPizzas = maximumNumberOfPizzas;
    }
}
