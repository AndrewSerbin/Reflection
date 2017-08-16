package model.entity;

public class Square extends EquilateralTriangle {

    public Square(int side) {
	super(side);
    }

    @Override
    public int getPerimeter() {
	return side * 4;
    }

    @Override
    public String toString() {
	return "Square []" + super.toString();
    }
}
