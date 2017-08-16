package model.util.test;

import model.entity.Square;
import model.util.annotation.Test;

public class SquareTest {

    private Square square;

    public SquareTest() {
	square = new Square(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSide() {
	square.setSide(-1);
    }
}
