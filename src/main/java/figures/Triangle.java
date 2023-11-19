package figures;

import java.util.ArrayList;

import static consts.Consts.AREA_DIVIDER;
import static consts.Consts.MULTIPLE_OF_TWO;
import static consts.Consts.TWO_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.FIRST_RADIX;
import static consts.Consts.SECOND_RADIX;
import static consts.Consts.THIRD_RADIX;

public class Triangle extends Figure {

    private final ArrayList<Integer> point1 = new ArrayList<>();
    private final ArrayList<Integer> point2 = new ArrayList<>();
    private final ArrayList<Integer> point3 = new ArrayList<>();
    private final ArrayList<Integer> xRadix = new ArrayList<>();
    private final ArrayList<Integer> yRadix = new ArrayList<>();
    private double side1;
    private double side2;
    private double side3;
    boolean twoDimension;
    boolean threeDimension;

    public Triangle(ArrayList<Integer> point) {
        int pointSize = point.size();
        this.threeDimension = pointSize == THREE_DIMENSIONAL_THREE_POINTS;
        this.twoDimension = pointSize == TWO_DIMENSIONAL_THREE_POINTS;

        if (this.threeDimension || this.twoDimension) {
            for (int i = 0; i < pointSize; i++) {
                if (i % MULTIPLE_OF_TWO == 0) {
                    this.xRadix.add(point.get(i));
                } else {
                    this.yRadix.add(point.get(i));
                }

                if (i < pointSize / THREE_POINTS) {
                    this.point1.add(point.get(i));
                } else if (i < TWO_POINTS * pointSize / THREE_POINTS) {
                    this.point2.add(point.get(i));
                } else {
                    this.point3.add(point.get(i));
                }
            }

            this.side1 = getLength(point1, point2);
            this.side2 = getLength(point2, point3);
            this.side3 = getLength(point1, point3);
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
        if ((this.threeDimension || this.twoDimension) && side1 > 0 && side2 > 0 && side3 > 0) {
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
        System.out.printf("%.2f\n", side1 + side2 + side3);
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
            System.out.printf("%.2f\n", Math.abs(area));
        } else {
            int x1 = point2.get(FIRST_RADIX) - point1.get(FIRST_RADIX);
            int y1 = point2.get(SECOND_RADIX) - point1.get(SECOND_RADIX);
        int z1 = point2.get(THIRD_RADIX) - point1.get(THIRD_RADIX);
            int x2 = point3.get(FIRST_RADIX) - point1.get(FIRST_RADIX);
            int y2 = point3.get(SECOND_RADIX) - point1.get(SECOND_RADIX);
            int z2 = point3.get(THIRD_RADIX) - point1.get(THIRD_RADIX);

            area = Math.sqrt(Math.pow(y1 * z2 - y2 * z1, DEGREE) + Math.pow(-(x1 * z2 - x2 * z1), DEGREE) + Math.pow(x1 * y2 - x2 * y1, DEGREE));
            System.out.printf("%.2f\n", area / AREA_DIVIDER);
        }
    }
}
