package compare;

public class UnitMismatchException extends Throwable {

    public UnitMismatchException(Unit unit) {
        super(unit + " is not found in the provided Unit Map");
    }
}
