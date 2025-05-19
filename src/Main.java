import models.Rectangle;
import models.Square;
import probability.Probability;

public class Main {
    public static void main(String[] args) {
//        shapes();
        new Probability(1, 2);

    }

    private static void shapes() {
        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println(rectangle.area());
        Square square = new Square(6);
        System.out.println(square.area());
    }
}
