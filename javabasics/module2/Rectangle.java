package javabasics.module2;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Rectangle implements Shape {

    private final double X_DIM_DEFAULT = 20.0;
    private final double Y_DIM_DEFAULT = 40.0;
    private double xDimension;
    private double yDimension;

    public Rectangle() {
        this.xDimension = X_DIM_DEFAULT;
        this.yDimension = Y_DIM_DEFAULT;
    }
    public Rectangle(int xDimension, int yDimension) {
        this.xDimension = (double) xDimension;
        this.yDimension = (double) yDimension;
    }
    public Rectangle(double xDimension, double yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    public Double calculateArea() {
        return this.xDimension * this.yDimension;
    }
    public void display() {
        System.out.println("The area of a rectangle is height x width");
        System.out.println("  " + this.xDimension + " x " + this.yDimension + " = " + this.calculateArea());
    }
}