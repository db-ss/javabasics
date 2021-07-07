package javabasics.module2;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module2Assignment3 {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(14, 7);
        r1.display();
        r2.display();

        Circle c1 = new Circle();
        Circle c2 = new Circle(13.33);
        c1.display();
        c2.display();

        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(50.0, 2.5);
        t1.display();
        t2.display();
    }
}
