package compare;

import java.util.Objects;

public class Millimeter {
    private final double millimeter;

    public Millimeter(double millimeter) {
        this.millimeter = millimeter;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Millimeter that = (Millimeter) o;
        return Double.compare(millimeter, that.millimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(millimeter);
    }

    public boolean compareLengths(Object obj) {
        if (obj instanceof Centimeter) {
            return obj.equals(new Centimeter(this.millimeter / 10));
        }

        return false;
    }
}
