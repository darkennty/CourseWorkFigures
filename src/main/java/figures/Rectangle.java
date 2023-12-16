package figures;

import java.util.ArrayList;

import static consts.Consts.AREA_DIVIDER;
import static consts.Consts.THREE_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_FOUR_POINTS;
import static consts.Consts.MULTIPLE_OF_TWO;
import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.FOUR_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.FIRST_RADIX;
import static consts.Consts.SECOND_RADIX;
import static consts.Consts.THIRD_RADIX;

public class Rectangle extends Figure {

    private final ArrayList<Integer> pointA = new ArrayList<>();
    private final ArrayList<Integer> pointB = new ArrayList<>();
    private final ArrayList<Integer> pointC = new ArrayList<>();
    private final ArrayList<Integer> pointD = new ArrayList<>();
    private final ArrayList<Integer> xRadix = new ArrayList<>();
    private final ArrayList<Integer> yRadix = new ArrayList<>();
    private final boolean twoDimension;
    private final boolean threeDimension;
    private double perimeter;
    private double area;

    public Rectangle(ArrayList<Integer> point) {
        int pointSize = point.size();
        this.threeDimension = pointSize == THREE_DIMENSIONAL_FOUR_POINTS;
        this.twoDimension = pointSize == TWO_DIMENSIONAL_FOUR_POINTS;

        if (this.threeDimension || this.twoDimension) {
            for (int i = 0; i < pointSize; i++) {
                if (i % MULTIPLE_OF_TWO == 0) {
                    this.xRadix.add(point.get(i));
                } else {
                    this.yRadix.add(point.get(i));
                }

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
        if (this.threeDimension) {
            for (int i = 0; i < THREE_POINTS; i++) {
                length = length + Math.pow(point1.get(i) - point2.get(i), DEGREE);
            }
        } else if (this.twoDimension) {
            for (int i = 0; i < TWO_POINTS; i++) {
                length = length + Math.pow(point1.get(i) - point2.get(i), DEGREE);
            }
        }
        return Math.sqrt(length);
    }

    @Override
    public boolean check() {
        double side1 = getLength(pointA, pointB);
        double side2 = getLength(pointB, pointC);
        double side3 = getLength(pointC, pointD);
        double side4 = getLength(pointD, pointA);
        double diag1 = getLength(pointA, pointC);
        double diag2 = getLength(pointD, pointB);

        if ((this.twoDimension || this.threeDimension) && diag1 == diag2 && side1 == side3 && side4 == side2) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    @Override
    public void perimeter() {
        double perimeter = getLength(pointA, pointB) + getLength(pointB, pointC) + getLength(pointC, pointD) + getLength(pointD, pointA);
        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = 0;
        final int size = 4;

        if (this.twoDimension) {
            for (int i = 0; i < size; ++i) {
                int j = (i + 1) % size;
                int x1 = xRadix.get(i);
                int y1 = yRadix.get(i);
                int x2 = xRadix.get(j);
                int y2 = yRadix.get(j);
                area += (double) (x1 * y2 - x2 * y1) / AREA_DIVIDER;
            }

            area = Math.abs(area);

            System.out.printf("%.2f\n", area);
        } else {
            int x1 = pointB.get(FIRST_RADIX) - pointA.get(FIRST_RADIX);
            int y1 = pointB.get(SECOND_RADIX) - pointA.get(SECOND_RADIX);
            int z1 = pointB.get(THIRD_RADIX) - pointA.get(THIRD_RADIX);
            int x2 = pointD.get(FIRST_RADIX) - pointA.get(FIRST_RADIX);
            int y2 = pointD.get(SECOND_RADIX) - pointA.get(SECOND_RADIX);
            int z2 = pointD.get(THIRD_RADIX) - pointA.get(THIRD_RADIX);

            area = Math.sqrt(Math.pow(y1 * z2 - y2 * z1, DEGREE) + Math.pow(-(x1 * z2 - x2 * z1), DEGREE) + Math.pow(x1 * y2 - x2 * y1, DEGREE));
            System.out.printf("%.2f\n", area);
        }
        this.area = area;
    }
    public double getPerimeter() {
        return Math.round(this.perimeter * 100.0) / 100.0;
    }

    public double getArea() {
        return Math.round(this.area * 100.0) / 100.0;
    }
}
