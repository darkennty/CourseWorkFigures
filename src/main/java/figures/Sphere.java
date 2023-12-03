package figures;

import java.util.ArrayList;

import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_TWO_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Sphere extends Figure {
    private ArrayList<Integer> centerPoint = new ArrayList<>();
    private ArrayList<Integer> randomPoint = new ArrayList<>();

    private double radius;
    private final double pointSize;
    private double area;

    public Sphere(ArrayList<Integer> point) {
        this.pointSize = point.size();

        if (this.pointSize == THREE_DIMENSIONAL_TWO_POINTS) {
            for (int i = 0; i < THREE_POINTS; i++) {
                centerPoint.add(point.get(i));
            }
            for (int i = THREE_POINTS; i < this.pointSize; i++) {
                randomPoint.add(point.get(i));
            }
            this.radius = getRadius();
        }
    }

    public double getRadius() {
        double length = 0;
        for (int i = 0; i < THREE_POINTS; i++) {
            length = length + Math.pow(centerPoint.get(i) - randomPoint.get(i), DEGREE);
        }
        return Math.sqrt(length);
    }

    @Override
    public boolean check() {
        if (pointSize != THREE_DIMENSIONAL_TWO_POINTS || centerPoint.equals(randomPoint)) {
            System.out.println("The figure is invalid");
            return false;
        } else {
            System.out.println("The figure is valid");
            return true;
        }
    }

    @Override
    public void area() {
        final int coefficient = 4;
        double area = coefficient * PI * Math.pow(radius, DEGREE);
        System.out.printf("%.2f\n", area);
        this.area = area;
    }

    public String getPerimeter() {
        return "The figure has no perimeter";
    }

    public double getArea() {
        return Math.round(this.area * 100.0) / 100.0;
    }
}
