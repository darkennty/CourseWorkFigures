package figures;

import java.util.ArrayList;

import static consts.Consts.*;

public class Triangle extends Figure {

    private final ArrayList<Integer> pointA = new ArrayList<>();
    private final ArrayList<Integer> pointB = new ArrayList<>();
    private final ArrayList<Integer> pointC = new ArrayList<>();
    private final ArrayList<Integer> xRadix = new ArrayList<>();
    private final ArrayList<Integer> yRadix = new ArrayList<>();
    private double side1;
    private double side2;
    private double side3;
    private double perimeter;
    private double area;
    private final boolean twoDimension;
    private final boolean threeDimension;

    public Triangle(ArrayList<Integer> point) {
        int pointSize = point.size();
        this.threeDimension = pointSize == THREE_DIMENSIONAL_THREE_POINTS;
        this.twoDimension = pointSize == TWO_DIMENSIONAL_THREE_POINTS;

        if (this.twoDimension) {
            for (int i = 0; i < pointSize; i++) {
                if (i % MULTIPLE_OF_TWO == 0) {
                    this.xRadix.add(point.get(i));
                } else {
                    this.yRadix.add(point.get(i));
                }

                if (i < pointSize / THREE_POINTS) {
                    this.pointA.add(point.get(i));
                } else if (i < TWO_POINTS * pointSize / THREE_POINTS) {
                    this.pointB.add(point.get(i));
                } else {
                    this.pointC.add(point.get(i));
                }
            }

            this.side1 = getLength(pointA, pointB);
            this.side2 = getLength(pointB, pointC);
            this.side3 = getLength(pointA, pointC);
        } else if (this.threeDimension) {
            for (int i = 0; i < pointSize; i++) {

                if (i < pointSize / THREE_POINTS) {
                    this.pointA.add(point.get(i));
                } else if (i < TWO_POINTS * pointSize / THREE_POINTS) {
                    this.pointB.add(point.get(i));
                } else {
                    this.pointC.add(point.get(i));
                }
            }

            this.side1 = getLength(pointA, pointB);
            this.side2 = getLength(pointB, pointC);
            this.side3 = getLength(pointA, pointC);
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
        double maxSize1 = Math.max(side1, side2);
        double maxSize2 = Math.max(side2, side3);
        double maxSize = Math.max(maxSize1, maxSize2);
        boolean isRealTriangle = side1 + side2 + side3 - maxSize > maxSize;

        if ((this.threeDimension || this.twoDimension) && side1 > 0 && side2 > 0 && side3 > 0 && isRealTriangle) {
            System.out.println("The figure is valid");
            return true;
        }
        else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    @Override
    public void perimeter() {
        double perimeter = side1 + side2 + side3;
        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = 0;
        final int size = 3;

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
            int x2 = pointC.get(FIRST_RADIX) - pointA.get(FIRST_RADIX);
            int y2 = pointC.get(SECOND_RADIX) - pointA.get(SECOND_RADIX);
            int z2 = pointC.get(THIRD_RADIX) - pointA.get(THIRD_RADIX);

            area = Math.sqrt(Math.pow(y1 * z2 - y2 * z1, DEGREE) + Math.pow(-(x1 * z2 - x2 * z1), DEGREE) + Math.pow(x1 * y2 - x2 * y1, DEGREE));
            area /= AREA_DIVIDER;

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
