package domain;

public class Pizza {
    private Integer numberOfSlices;

    public Pizza(Integer numberOfSlices) {
        this.numberOfSlices = numberOfSlices;
    }

    public Integer getNumberOfSlices() {
        return numberOfSlices;
    }

    public void setNumberOfSlices(Integer numberOfSlices) {
        this.numberOfSlices = numberOfSlices;
    }
}
