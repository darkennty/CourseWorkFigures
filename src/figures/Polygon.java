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
    boolean twoDimension;
    boolean threeDimension;

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
        boolean flag = false;
        if (this.threeDimension) {
            int size = pointSize / 3;
            double determinant = 0;
            for (int i = 0; i < size; i++) {
                int j = (i + SECOND_RADIX) % size;
                int k = (i + THIRD_RADIX) % size;

                if (i % MULTIPLE_OF_TWO == 0) {
                    determinant = determinant + xRadix.get(i) * (yRadix.get(j) * zRadix.get(k) - yRadix.get(k) * zRadix.get(j));
                } else {
                    determinant = determinant - xRadix.get(i) * (yRadix.get(j) * zRadix.get(k) - yRadix.get(k) * zRadix.get(j));
                }
            }
            if (determinant == 0) {
                flag = true;
            }
        } else if (this.twoDimension) {
            flag = true;
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

                area = Math.sqrt(Math.pow(y1 * z2 - y2 * z1, DEGREE) + Math.pow(-(x1 * z2 - x2 * z1), DEGREE) + Math.pow(x1 * y2 - x2 * y1, DEGREE));
            }
            System.out.printf("%.2f\n", area);
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
            System.out.printf("%.2f\n", Math.abs(area));
        }
    }
}
