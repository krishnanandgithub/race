import org.junit.jupiter.api.Test;
import probability.Probability;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {
    @Test
    void coinTest() throws Exception {
        Probability probability = Probability.create(0.5);
        assert (probability.equals(Probability.create(0.5)));
    }

    @Test
    void invalidProbability() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            Probability.create(1.34);
        }, "Invalid Probability");
    }

    @Test
    void complementTest() throws Exception {
        Probability probability = Probability.create(0.5);
        Probability complement = probability.complement();
        assert (complement.equals(Probability.create(0.5)));
    }

    @Test
    void complementTest2() throws Exception {
        Probability probability = Probability.create(0.75);
        Probability complement = probability.complement();
        assert (complement.equals(Probability.create(0.25)));
    }

    @Test
    void twoCoinsTest() throws Exception {
        Probability actual = Probability.create(0.25);
        assert (actual.equals(Probability.create(0.25)));
    }

    @Test
    void andTest() throws Exception {
        Probability probabilityA = Probability.create(0.5);
        Probability probabilityB = Probability.create(0.5);

        Probability actual = probabilityA.and(probabilityB);
        Probability expected = Probability.create((0.25));
        assertEquals(expected, actual);
    }

    @Test
    void orTest() throws Exception {
        Probability probabilityA = Probability.create(0.5);
        Probability probabilityB = Probability.create(0.5);

        Probability actual = probabilityA.or(probabilityB);
        Probability expected = Probability.create((0.75));
        assertEquals(expected, actual);
    }
}