import org.junit.jupiter.api.Test;
import probability.Probability;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
    @Test
    void coinProbabilityTest() {
        Probability tailProbs = new Probability(1, 2);
        assertEquals(0.5, tailProbs.getProbability());
    }

    @Test
    void complementProbabilityTest() {
        Probability tailProbs = new Probability(1, 2);
        assertEquals(0.5, tailProbs.getComplementProbability());
    }
}