package javabasics.module4;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class LineTest {

    @Test (expected = java.lang.ArithmeticException.class)
    public void testGetSlopeException() {

        Line lin = new Line(0.0, 0.0, 0.0, 0.0);
        lin.getSlope();

    }

    @Test
    public void testGetSlope() {
        assertEquals((Double) 1.0, new Line(0.0, 1.0, 0.0, 1.0).getSlope());
        assertEquals((Double) (-1.0), new Line(0.0, 1.0, 0.0, -1.0).getSlope());
    }

    @Test
    public void testParallelTo() {
        Line lin1 = new Line(0.0, 1.0, 0.0, 1.0);
        Line lin2 = new Line(0.0, 1.0, 1.0, 2.0);
        Assert.assertTrue(lin1.parallelTo(lin2));
    }

    @Test
    public void testGetDistance() {

        Line lin = new Line(0.0, 5.0, 0.0, 10.0);
        // using EPSILON again for comparing doubles
        Assert.assertTrue(Math.abs((Double) 11.18033 - lin.getDistance()) < Line.EPISLON);
    }
}
