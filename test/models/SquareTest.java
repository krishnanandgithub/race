package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    @Test
    void areaTest() {
        Square square = new Square(6);
        assertEquals(36, square.area());
    }

    @Test
    void zeroSideTest() {
        Square square = new Square(0);
        assertEquals(0, square.area());
    }
}