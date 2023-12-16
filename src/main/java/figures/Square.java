package figures;

import java.util.ArrayList;

import static consts.Consts.THREE_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.FOUR_POINTS;
import static consts.Consts.DEGREE;

public class Square extends Figure {

    private final ArrayList<Integer> pointA = new ArrayList<>();
    private final ArrayList<Integer> pointB = new ArrayList<>();
    private final ArrayList<Integer> pointC = new ArrayList<>();
    private final ArrayList<Integer> pointD = new ArrayList<>();
    private final boolean twoDimension;
    private final boolean threeDimension;
    private double perimeter;
    private double area;

    public Square(ArrayList<Integer> point) {
        int pointSize = point.size();
        this.threeDimension = pointSize == THREE_DIMENSIONAL_FOUR_POINTS;
        this.twoDimension = pointSize == TWO_DIMENSIONAL_FOUR_POINTS;

        if (threeDimension || twoDimension) {
            for (int i = 0; i < pointSize; i++) {
                if (i < pointSize / FOUR_POINTS) {
                    this.pointA.add(point.get(i));
                } else if (i < pointSize / TWO_POINTS) {
                    this.pointB.add(point.get(i));
                } else if (i < THREE_POINTS * pointSize / FOUR_POINTS) {
                    this.pointC.add(point.get(i));
                } else {
                    this.pointD.add(point.get(i));
                }
            }
        }
    }

    public double getLength(ArrayList<Integer> point1, ArrayList<Integer> point2) {
        double length = 0;

        if (threeDimension) {
            for (int i = 0; i < THREE_POINTS; i++) {
                length = length + Math.pow(point1.get(i) - point2.get(i), DEGREE);
            }
        } else if (twoDimension) {
            for (int i = 0; i < TWO_POINTS; i++) {
                length = length + Math.pow(point1.get(i) - point2.get(i), DEGREE);
            }
        }

        length = Math.sqrt(length);

        return length;
    }

    @Override
    public boolean check() {
        double side1 = getLength(pointA, pointB);
        double side2 = getLength(pointB, pointC);
        double side3 = getLength(pointC, pointD);
        double side4 = getLength(pointD, pointA);
        double diag1 = getLength(pointA, pointC);
        double diag2 = getLength(pointD, pointB);

        if ((twoDimension || threeDimension) && diag1 == diag2 && side1 == side3 && side4 == side2 && side1 == side2) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    @Override
    public void perimeter() {
        double side = getLength(pointA, pointB);
        final int fourSides = 4;
        double perimeter = side * fourSides;
        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = Math.pow(getLength(pointA, pointB), DEGREE);
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
