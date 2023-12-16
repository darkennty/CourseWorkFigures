package figures;

import java.util.ArrayList;

import static consts.Consts.AREA_DIVIDER;
import static consts.Consts.MULTIPLE_OF_TWO;
import static consts.Consts.MULTIPLE_OF_THREE;
import static consts.Consts.TWO_POINTS;
import static consts.Consts.TWO_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.FIRST_RADIX;
import static consts.Consts.SECOND_RADIX;
import static consts.Consts.THIRD_RADIX;

public class Polygon extends Figure {

    private final ArrayList<Integer> xRadix = new ArrayList<>();
    private final ArrayList<Integer> yRadix = new ArrayList<>();
    private final ArrayList<Integer> zRadix = new ArrayList<>();
    private final int pointSize;
    private final boolean twoDimension;
    private final boolean threeDimension;
    private double perimeter;
    private double area;

    public Polygon(ArrayList<Integer> point) {
        this.pointSize = point.size();
        this.threeDimension = pointSize % MULTIPLE_OF_THREE == 0 && pointSize >= THREE_DIMENSIONAL_THREE_POINTS;
        this.twoDimension = pointSize % MULTIPLE_OF_TWO == 0 && pointSize >= TWO_DIMENSIONAL_THREE_POINTS;

        if (this.threeDimension) {
            for (int i = 0; i < pointSize; i = i + THREE_POINTS) {
                this.xRadix.add(point.get(i));
                this.yRadix.add(point.get(i + SECOND_RADIX));
                this.zRadix.add(point.get(i + THIRD_RADIX));
            }
        } else if (this.twoDimension) {
            for (int i = 0; i < pointSize; i = i + TWO_POINTS) {
                this.xRadix.add(point.get(i));
                this.yRadix.add(point.get(i + SECOND_RADIX));
            }
        }
    }

    @Override
    public boolean check() {
        boolean flag = true;

        if (this.threeDimension) {

            int size = pointSize / THREE_POINTS;

            for (int i = 0; i < size; i++) {
                int j = (i + SECOND_RADIX) % size;
                int k = (i + THIRD_RADIX) % size;
                int[] vector1 = new int[3];
                int[] vector2 = new int[3];

                vector1[FIRST_RADIX] = xRadix.get(j) - xRadix.get(i);
                vector1[SECOND_RADIX] = yRadix.get(j) - yRadix.get(i);
                vector1[THIRD_RADIX] = zRadix.get(j) - zRadix.get(i);

                vector2[FIRST_RADIX] = xRadix.get(k) - xRadix.get(j);
                vector2[SECOND_RADIX] = yRadix.get(k) - yRadix.get(j);
                vector2[THIRD_RADIX] = zRadix.get(k) - zRadix.get(j);

                double firstPartOfDeterminant = vector1[SECOND_RADIX] * vector2[THIRD_RADIX] - vector2[SECOND_RADIX] * vector1[THIRD_RADIX];
                double secondPartOfDeterminant = vector1[FIRST_RADIX] * vector2[THIRD_RADIX] - vector2[FIRST_RADIX] * vector1[THIRD_RADIX];
                double thirdPartOfDeterminant = vector1[FIRST_RADIX] * vector2[SECOND_RADIX] - vector2[FIRST_RADIX] * vector1[SECOND_RADIX];

                if (firstPartOfDeterminant - secondPartOfDeterminant + thirdPartOfDeterminant == 0) {
                    flag = false;
                    break;
                }
            }
        } else if (this.twoDimension) {

            int size = pointSize / TWO_POINTS;

            for (int i = 0; i < size; i++) {
                int j = (i + SECOND_RADIX) % size;
                int k = (i + THIRD_RADIX) % size;
                int[] vector1 = new int[2];
                int[] vector2 = new int[2];

                vector1[FIRST_RADIX] = xRadix.get(j) - xRadix.get(i);
                vector1[SECOND_RADIX] = yRadix.get(j) - yRadix.get(i);

                vector2[FIRST_RADIX] = xRadix.get(k) - xRadix.get(j);
                vector2[SECOND_RADIX] = yRadix.get(k) - yRadix.get(j);

                double determinant = vector1[FIRST_RADIX] * vector2[SECOND_RADIX] - vector2[FIRST_RADIX] * vector1[SECOND_RADIX];

                if (determinant == 0) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }

        if (flag) {
            System.out.println("The figure is valid");
        } else {
            System.out.println("The figure is invalid");
        }

        return flag;
    }

    @Override
    public void perimeter() {
        double perimeter = 0;
        if (this.threeDimension) {
            int size = pointSize / 3;
            for (int i = 0; i < size; i++) {
                int j = (i + 1) % size;
                perimeter = perimeter + Math.sqrt(Math.pow(xRadix.get(j) - xRadix.get(i), DEGREE) + Math.pow(yRadix.get(j) - yRadix.get(i), DEGREE) + Math.pow(zRadix.get(j) - zRadix.get(i), DEGREE));
            }
        } else {
            int size = pointSize / 2;
            for (int i = 0; i < size; i++) {
                int j = (i + 1) % size;
                perimeter = perimeter + Math.sqrt(Math.pow(xRadix.get(j) - xRadix.get(i), DEGREE) + Math.pow(yRadix.get(j) - yRadix.get(i), DEGREE));
            }
        }

        System.out.printf("%.2f\n", perimeter);
        this.perimeter = perimeter;
    }

    @Override
    public void area() {
        double area = 0;
        if (this.threeDimension) {
            int size = pointSize / THREE_POINTS;

            for (int i = 1; i < size - 1; i++) {
                int j = i + 1;
                int x1 = xRadix.get(i) - xRadix.get(FIRST_RADIX);
                int y1 = yRadix.get(i) - yRadix.get(FIRST_RADIX);
                int z1 = zRadix.get(i) - zRadix.get(FIRST_RADIX);
                int x2 = xRadix.get(j) - xRadix.get(FIRST_RADIX);
                int y2 = yRadix.get(j) - yRadix.get(FIRST_RADIX);
                int z2 = zRadix.get(j) - zRadix.get(FIRST_RADIX);

                area += Math.sqrt(Math.pow(y1 * z2 - y2 * z1, DEGREE) + Math.pow(-(x1 * z2 - x2 * z1), DEGREE) + Math.pow(x1 * y2 - x2 * y1, DEGREE));
            }

            area /= AREA_DIVIDER;
        } else {
            int size = pointSize / TWO_POINTS;

            for (int i = 0; i < size; ++i) {
                int j = (i + 1) % size;
                int x1 = xRadix.get(i);
                int y1 = yRadix.get(i);
                int x2 = xRadix.get(j);
                int y2 = yRadix.get(j);
                area += (double) (x1 * y2 - x2 * y1) / AREA_DIVIDER;
            }
        }

        area = Math.abs(area);

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
