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
        lengthStdMap.put(Unit.MILLIMETRE, 0.001);
        lengthStdMap.put(Unit.INCH, 0.025);
        lengthStdMap.put(Unit.FOOT, 0.3);
    }

    @Test
    void compareFtoCTest() throws UnitMismatchException {
        Measurement lengthInFt = Measurement.create(1, Unit.FOOT, lengthStdMap);
        Measurement lengthInInches = Measurement.create(12, Unit.INCH, lengthStdMap);

        assertEquals(lengthInFt, lengthInInches);
    }

    @Test
    void compareIToCTest() throws UnitMismatchException {
        Measurement lengthInInch = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInCm = Measurement.create(5, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(lengthInInch, lengthInCm);
    }

    @Test
    void compareCToMTest() throws UnitMismatchException {
        Measurement lengthInM = Measurement.create(1, Unit.METRE, lengthStdMap);
        Measurement lengthInCm = Measurement.create(100, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(lengthInM, lengthInCm);
    }

    @Test
    void compareCToMMTest() throws UnitMismatchException {
        Measurement lengthInMM = Measurement.create(10, Unit.MILLIMETRE, lengthStdMap);
        Measurement lengthInCm = Measurement.create(1, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(lengthInMM, lengthInCm);
    }

    @Test
    void compareGToLTest() throws UnitMismatchException {
        Measurement volInLit = Measurement.create(3.785, Unit.LITER, volumeStdMap);
        Measurement volInGal = Measurement.create(1, Unit.GALLON, volumeStdMap);
        assertEquals(volInGal, volInLit);
    }

    @Test
    void addTest() throws UnitMismatchException {
        Measurement lengthInInchesA = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInInchesB = Measurement.create(3, Unit.INCH, lengthStdMap);

        assertEquals(Measurement.create(5, Unit.INCH, lengthStdMap), lengthInInchesA.add(lengthInInchesB, lengthStdMap, Unit.INCH));
    }

    @Test
    void addDifferentLengthUnits() throws UnitMismatchException {
        Measurement lengthInInches = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInCm = Measurement.create(2.5, Unit.CENTIMETRE, lengthStdMap);

        assertEquals(Measurement.create(3, Unit.INCH, lengthStdMap), lengthInInches.add(lengthInCm, lengthStdMap, Unit.INCH));
    }

    @Test
    void addDifferentVolumeUnits() throws UnitMismatchException {
        Measurement volumeInLiters = Measurement.create(1, Unit.LITER, volumeStdMap);
        Measurement volumeInGals = Measurement.create(1, Unit.GALLON, volumeStdMap);

        assertEquals(Measurement.create(4.78, Unit.LITER, volumeStdMap), volumeInLiters.add(volumeInGals, volumeStdMap, Unit.LITER));
    }

    @Test
    void createError() throws UnitMismatchException {
        Measurement lengthInInches = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement lengthInCm = Measurement.create(2.5, Unit.CENTIMETRE, lengthStdMap);

        assertThrows(UnitMismatchException.class, () -> {
            Measurement.create(3, Unit.GALLON, lengthStdMap);
        });
    }

    @Test
    void addError() throws UnitMismatchException {
        Measurement lengthInInches = Measurement.create(2, Unit.INCH, lengthStdMap);
        Measurement volumeInGallon = Measurement.create(2.5, Unit.GALLON, volumeStdMap);

        assertThrows(UnitMismatchException.class, () -> {
            lengthInInches.add(volumeInGallon,lengthStdMap,Unit.INCH);
        });
    }

    @Test
    void literToMeterTest() throws UnitMismatchException {
        Measurement lengthInMetre = Measurement.create(2, Unit.METRE, lengthStdMap);
        Measurement volumeInLiter = Measurement.create(2, Unit.LITER, volumeStdMap);

        assertThrows(UnitMismatchException.class, () -> {
            lengthInMetre.add(volumeInLiter,lengthStdMap,Unit.METRE);
        });
    }
}