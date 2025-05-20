package compare;

import java.util.HashMap;
import java.util.Objects;

public class Measurement {
    private final double value;
    private final Unit unit;
    private final double standard;

    private Measurement(double standard, double value, Unit unit) {
        this.value = value;
        this.unit = unit;

        this.standard = standard;
    }

    public static Measurement create(double value, Unit unit, HashMap<Unit, Double> stdUnitMultiplierMap) throws UnitMismatchException {
        Double factor = stdUnitMultiplierMap.get(unit);
        if(factor == null) throw new UnitMismatchException(unit);
        return new Measurement(value * factor, value, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement volume = (Measurement) o;
        return Double.compare(Math.round(standard), Math.round(volume.standard)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(standard);
    }

    public Measurement add(Measurement measurement, HashMap<Unit, Double> stdUnitMultiplierMap,Unit expectedUnit) throws UnitMismatchException {
        Double factor = stdUnitMultiplierMap.get(measurement.unit);
        if(factor == null) throw new UnitMismatchException(measurement.unit);

        double sumOfStandard = this.standard + measurement.standard;
        double sumInExpUnits = sumOfStandard / stdUnitMultiplierMap.get(expectedUnit);

        return create(sumInExpUnits, expectedUnit, stdUnitMultiplierMap);
    }
}
