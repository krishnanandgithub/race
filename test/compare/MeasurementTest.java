package compare;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    private final HashMap<Unit, Double> volumeStdMap = new HashMap<>();
    private final HashMap<Unit, Double> lengthStdMap = new HashMap<>();

    {
        volumeStdMap.put(Unit.LITER, 1.0);
        volumeStdMap.put(Unit.GALLON, 3.785);
        lengthStdMap.put(Unit.METRE, 1.0);
        lengthStdMap.put(Unit.CENTIMETRE, 0.01);
        lengthStdMap.put(Unit.INCH, 0.025);
        lengthStdMap.put(Unit.FOOT, 0.3);
    }

    @Test
    void compareFtoCTest() {
        Measurement lengthInFt = Measurement.create(1, Unit.FOOT, lengthStdMap);
        Measurement lengthInInches = Measurement.create(12, Unit.INCH, lengthStdMap);

        assertEquals(lengthInFt,lengthInInches);
    }

    @Test
    void compareIToCTest() {
        Measurement lengthInInch = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInCm = Measurement.create(5, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(lengthInInch,lengthInCm);
    }

    @Test
    void compareCToMTest() {
        Measurement lengthInM = Measurement.create(1, Unit.METRE, lengthStdMap);
        Measurement lengthInCm = Measurement.create(100, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(lengthInM,lengthInCm);
    }

    @Test
    void compareGToLTest() {
        Measurement volInLit = Measurement.create(3.785, Unit.LITER, volumeStdMap);
        Measurement volInGal = Measurement.create(1, Unit.GALLON, volumeStdMap);
        assertEquals(volInGal,volInLit);
    }

    @Test
    void addTest() {
        Measurement lengthInInchesA = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInInchesB = Measurement.create(3, Unit.INCH, lengthStdMap);

        assertEquals(Measurement.create(5,Unit.INCH,lengthStdMap),lengthInInchesA.add(lengthInInchesB, lengthStdMap, Unit.INCH));
    }

    @Test
    void addDifferentUnits(){
        Measurement lengthInInches = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInCm = Measurement.create(2.5, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(Measurement.create(3,Unit.INCH,lengthStdMap),lengthInInches.add(lengthInCm, lengthStdMap, Unit.INCH));
    }
}