package figures;

import java.util.ArrayList;

import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_TWO_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Sphere extends Figure {

    private double radius;
    private final double pointSize;

    public Sphere(ArrayList<Integer> point) {
        this.pointSize = point.size();
        ArrayList<Integer> centerPoint = new ArrayList<>();
        ArrayList<Integer> randomPoint = new ArrayList<>();

        if (this.pointSize == THREE_DIMENSIONAL_TWO_POINTS) {
            for (int i = 0; i < THREE_POINTS; i++) {
                centerPoint.add(point.get(i));
            }
            for (int i = THREE_POINTS; i < this.pointSize; i++) {
                randomPoint.add(point.get(i));
            }
            this.radius = getRadius(centerPoint, randomPoint);
        }
    }

    public double getRadius(ArrayList<Integer> centerPoint, ArrayList<Integer> randomPoint) {
        double length = 0;
        for (int i = 0; i < THREE_POINTS; i++) {
            length = length + Math.pow(centerPoint.get(i) - randomPoint.get(i), DEGREE);
        }
        return Math.sqrt(length);
    }

    @Override
    public boolean check() {
        if (pointSize != THREE_DIMENSIONAL_TWO_POINTS && this.radius <= 0) {
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
        System.out.printf("%.2f\n", coefficient * PI * Math.pow(radius, DEGREE));
    }
}
