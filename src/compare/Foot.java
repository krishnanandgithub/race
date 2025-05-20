package compare;

import java.util.Objects;

public class Foot {
    private final double foot;

    public Foot(double foot) {
        this.foot = foot;
    }


    public boolean compareLengths(Object obj) {
        if (obj instanceof Inch) {
            return obj.equals(new Inch(this.foot * 12));
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Foot foot1 = (Foot) o;
        return Double.compare(foot, foot1.foot) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(foot);
    }
}
