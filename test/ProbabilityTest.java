import org.junit.jupiter.api.Test;
import probability.Probability;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
    @Test
    void coinTest() {
        Probability tailProbs = new Probability(1, 2);
        assertEquals(0.5, tailProbs.getProbability());
    }
}