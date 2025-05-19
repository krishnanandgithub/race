package probability;

import java.util.Objects;

public class Probability {
    private final double value;

    private Probability(double value) {
        this.value = value;
    }

    public static Probability create(double value) throws Exception {
        if (value < 0 || value > 1) {
            throw new IllegalArgumentException("Invalid Probability");
        }

        return new Probability(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public Probability complement() throws Exception {
        return  Probability.create(1 - this.value);
    }

    public Probability and(Probability probabilityB) {
        return new Probability(this.value * probabilityB.value);
    }

    public Probability or(Probability probabilityB) throws Exception {
        Probability complementB = probabilityB.complement();
        Probability complementA = this.complement();

        return (complementA.and(complementB)).complement();
    }
}
