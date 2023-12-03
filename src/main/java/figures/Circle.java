package figures;

import java.util.ArrayList;

import static consts.Consts.TWO_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_TWO_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Circle extends Figure {
    private double radius;
    private final double pointSize;
    private double perimeter;
    private double area;

    public Circle(ArrayList<Integer> point) {
        this.pointSize = point.size();
        ArrayList<Integer> centerPoint = new ArrayList<>();
        ArrayList<Integer> randomPoint = new ArrayList<>();

        if (pointSize == THREE_DIMENSIONAL_TWO_POINTS || pointSize == TWO_DIMENSIONAL_TWO_POINTS) {
            for (int i = 0; i < ((int) this.pointSize / TWO_POINTS); i++) {
                centerPoint.add(point.get(i));
            }
            for (int i = ((int) this.pointSize / TWO_POINTS); i < this.pointSize; i++) {
                randomPoint.add(point.get(i));
            }
            this.radius = getRadius(centerPoint, randomPoint);
        }
    }

    @Override
    public boolean check() {
        if ((pointSize == TWO_DIMENSIONAL_TWO_POINTS || pointSize == THREE_DIMENSIONAL_TWO_POINTS) && this.radius > 0) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    public double getRadius(ArrayList<Integer> centerPoint, ArrayList<Integer> randomPoint) {
        double length = 0;
        if (pointSize == TWO_DIMENSIONAL_TWO_POINTS) {
            for (int i = 0; i < TWO_POINTS; i++) {
                length = length + Math.pow(centerPoint.get(i) - randomPoint.get(i), DEGREE);
            }
        } else if (pointSize == THREE_DIMENSIONAL_TWO_POINTS) {
            for (int i = 0; i < THREE_POINTS; i++) {
                length = length + Math.pow(centerPoint.get(i) - randomPoint.get(i), DEGREE);
            }
        }
        return Math.sqrt(length);
    }
    @Override
    public void perimeter() {
        final int formulaCoefficient = 2;
        double perimeter = formulaCoefficient * PI * radius;
        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = PI * Math.pow(radius, DEGREE);
        System.out.printf("%.2f\n", area);
        this.area = area;
    }

    public double getPerimeter() {
        return Math.round(this.perimeter * 100.0) / 100.0;
    }

    public double getArea() {
        return Math.round(this.area * 100.0) / 100.0;
    }
}
