package model.entity;

public class EquilateralTriangle {

    protected int side;

    public EquilateralTriangle(int side) {
	setSide(side);
    }

    public int getPerimeter() {
	return side * 3;
    }

    public int getSide() {
	return side;
    }

    public void setSide(int side) {
	if (side <= 0) {
	    throw new IllegalArgumentException();
	}
	this.side = side;
    }

    @Override
    public String toString() {
	return "EquilateralTriangle [side=" + side + "]";
    }
}
