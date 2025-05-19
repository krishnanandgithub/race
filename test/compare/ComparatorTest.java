package compare;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    @Test
    void compareFtoCTest() {
        Foot foot = new Foot(1);
        Inch inch = new Inch(12);

        assert (foot.compareLengths(inch));
    }

    @Test
    void compareCToFTest() {
        Foot foot = new Foot(1);
        Inch inch = new Inch(12);

        assert (inch.compareLengths(foot));
    }

    @Test
    void compareIToCTest() {
        Inch inch = new Inch(2);
        Centimeter centimeter = new Centimeter(5);
        assert (inch.compareLengths(centimeter));
    }

    @Test
    void compareCToITest() {
        Inch inch = new Inch(2);
        Centimeter centimeter = new Centimeter(5);

        assert (centimeter.compareLengths(inch));
    }

    @Test
    void compareCToMTest() {
        Millimeter millimeter = new Millimeter(10);
        Centimeter centimeter = new Centimeter(1);

        assert (centimeter.compareLengths(millimeter));
    }

    @Test
    void compareMToCTest() {
        Millimeter millimeter = new Millimeter(10);
        Centimeter centimeter = new Centimeter(1);

        assert (millimeter.compareLengths(centimeter));
    }
}