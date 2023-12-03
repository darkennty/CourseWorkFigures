package figures;

import java.util.ArrayList;

import static consts.Consts.THREE_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.FOUR_POINTS;
import static consts.Consts.DEGREE;

public class Square extends Figure {

    private final ArrayList<Integer> point1 = new ArrayList<>();
    private final ArrayList<Integer> point2 = new ArrayList<>();
    private final ArrayList<Integer> point3 = new ArrayList<>();
    private final ArrayList<Integer> point4 = new ArrayList<>();
    boolean twoDimension;
    boolean threeDimension;
    private double perimeter;
    private double area;

    public Square(ArrayList<Integer> point) {
        int pointSize = point.size();
        this.threeDimension = pointSize == THREE_DIMENSIONAL_FOUR_POINTS;
        this.twoDimension = pointSize == TWO_DIMENSIONAL_FOUR_POINTS;

        if (threeDimension || twoDimension) {
            for (int i = 0; i < pointSize; i++) {
                if (i < pointSize / FOUR_POINTS) {
                    this.point1.add(point.get(i));
                } else if (i < pointSize / TWO_POINTS) {
                    this.point2.add(point.get(i));
                } else if (i < THREE_POINTS * pointSize / FOUR_POINTS) {
                    this.point3.add(point.get(i));
                } else {
                    this.point4.add(point.get(i));
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
        double side1 = getLength(point1, point2);
        double side2 = getLength(point2, point3);
        double side3 = getLength(point3, point4);
        double side4 = getLength(point4, point1);
        double diag1 = getLength(point1, point3);
        double diag2 = getLength(point4, point2);

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
        double side = getLength(point1, point2);
        final int fourSides = 4;
        double perimeter = side * fourSides;
        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = Math.pow(getLength(point1, point2), DEGREE);
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
