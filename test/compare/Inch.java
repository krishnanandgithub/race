package compare;

import java.util.Objects;

public class Inch {
    private final double inch;

    public Inch(double inch) {
        this.inch = inch;
    }

    public boolean compareLengths(Object obj) {
        if (obj instanceof Foot) {
            return obj.equals(new Foot(this.inch / 12));
        }

        if (obj instanceof Centimeter) {
            return obj.equals(new Centimeter(this.inch * 2.5));
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inch inch1 = (Inch) o;
        return Double.compare(inch, inch1.inch) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(inch);
    }
}
