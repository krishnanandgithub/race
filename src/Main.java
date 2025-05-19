import models.Rectangle;
import models.Square;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println(rectangle.area());
        Square square = new Square(6);
        System.out.println(square.area());
    }
}
