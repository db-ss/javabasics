package javabasics.module2;

import static java.lang.Math.PI;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Circle implements Shape {

    private final double RADIUS_DEFAULT = 5.0;
    private double radius;

    public Circle() {
        this.radius = RADIUS_DEFAULT;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(int radius) {
        this.radius = (double) radius;
    }

    public Double calculateCircumference() {
        return 2 * PI * this.radius;
    }

    public Double calculateArea() {
        return PI * this.radius * this.radius;
    }

    public void display() {
        System.out.println("The area of a circle is 2 x \u03c0 x r\u00b2");
        System.out.println("  2 x \u03c0 x " + this.radius + 
                           "\u00b2 = " + this.calculateArea());
    }
}