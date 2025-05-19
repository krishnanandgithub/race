package probability;

public class Probability {
    private final double favourableOutcomes;
    private final double totalOutcomes;

    public Probability(int favourableOutcomes, int totalOutcomes) {
        this.favourableOutcomes = favourableOutcomes;
        this.totalOutcomes = totalOutcomes;
    }


    public double getProbability() {
        return favourableOutcomes / totalOutcomes;
    }
}
