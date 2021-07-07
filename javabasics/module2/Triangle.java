package javabasics.module2;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Triangle implements Shape {

    private final double BASE_DEFAULT = 6.5;
    private final double HEIGHT_DEFAULT = 10.0;
    private double baseDimension;
    private double heightDimension;

    public Triangle() {
        this.baseDimension = BASE_DEFAULT;
        this.heightDimension = HEIGHT_DEFAULT;
    }
    public Triangle(double baseDimension, double heightDimension) {
        this.baseDimension = baseDimension;
        this.heightDimension = heightDimension;
    }
    public Triangle(int baseDimension, int heightDimension) {
        this.baseDimension = (double) baseDimension;
        this.heightDimension = (double) heightDimension;
    }

    public Double calculateArea() {
        return 0.5 * this.baseDimension * this.heightDimension;
    }

    public void display() {
        System.out.println("The area of a triangle is 0.5 x base x height");
        System.out.println("  0.5 x " + this.baseDimension + " x " + 
                           this.heightDimension + " = " + this.calculateArea());
    }
}