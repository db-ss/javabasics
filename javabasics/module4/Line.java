package javabasics.module4;

public class Line {
    private Double x0, x1, y0, y1;
    public static final Double EPISLON = 0.0001;

    public Line(Double x0, Double x1, Double y0, Double y1) {
        super();
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }

    // this slope of a line
    public Double getSlope() throws ArithmeticException {

        if (Math.abs(x1 - x0) < EPISLON)
            throw new ArithmeticException();
        return (y1 - y0) / (x1 - x0);
    }

    // the length of a line
    public Double getDistance() {

        return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
    }

    public Boolean parallelTo(Line other) {
        
        return Math.abs(this.getSlope() - other.getSlope()) < EPISLON;
    }
}
