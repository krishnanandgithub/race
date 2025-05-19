package compare;

import java.util.Objects;

public class Centimeter {
    private final double centimeter;

    public Centimeter(double centimeter) {
        this.centimeter = centimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Centimeter that = (Centimeter) o;
        return Double.compare(centimeter, that.centimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(centimeter);
    }

    public boolean compareLengths(Object obj) {
        if (obj instanceof Inch) {
            return obj.equals(new Inch(this.centimeter / 2.5));
        }

        if (obj instanceof Millimeter) {
            return obj.equals(new Millimeter(this.centimeter * 10));
        }

        return false;
    }
}
