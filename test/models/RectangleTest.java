package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    void areaTest() {
        Rectangle rectangle = new Rectangle(4, 6);
        assertEquals(24, rectangle.area());
    }

    @Test
    void zeroLengthAreaTest() {
        Rectangle rectangle = new Rectangle(0, 3);
        assertEquals(0, rectangle.area());
    }

    @Test
    void perimeterTest() {
        Rectangle rectangle = new Rectangle(5, 5);
        assertEquals(20, rectangle.perimeter());
    }

    @Test
    void zeroLengthPerimeterTest() {
        Rectangle rectangle = new Rectangle(0, 5);
        assertEquals(10, rectangle.perimeter());
    }
}