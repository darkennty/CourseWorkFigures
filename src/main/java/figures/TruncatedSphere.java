package figures;

import java.util.ArrayList;

import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;
import static consts.Consts.FIRST_RADIX;
import static consts.Consts.SECOND_RADIX;
import static consts.Consts.THIRD_RADIX;

public class TruncatedSphere extends Figure {

    private double radius;
    private double truncatedRadius;
    private double height;
    private double area;
    private final int pointSize;

    public TruncatedSphere(ArrayList<Integer> point) {
        this.pointSize = point.size();
        ArrayList<Integer> centerPoint = new ArrayList<>();
        ArrayList<Integer> randomPoint = new ArrayList<>();
        ArrayList<Integer> randomTruncatedPoint = new ArrayList<>();
        ArrayList<Integer> truncatedCenterPoint = new ArrayList<>();

        if (this.pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            int dot1 = pointSize / THREE_POINTS;
            int dot2 = TWO_POINTS * pointSize / THREE_POINTS;

            for (int i = 0; i < dot1; i++) {
                centerPoint.add(point.get(i));
            }
            for (int i = dot1; i < dot2; i++) {
                randomPoint.add(point.get(i));
            }
            for (int i = dot2; i < pointSize; i++) {
                randomTruncatedPoint.add(point.get(i));
            }

            truncatedCenterPoint.add(centerPoint.get(FIRST_RADIX));
            truncatedCenterPoint.add(centerPoint.get(SECOND_RADIX));
            truncatedCenterPoint.add(randomTruncatedPoint.get(THIRD_RADIX));

            this.radius = getLength(centerPoint, randomPoint);
            this.truncatedRadius = getLength(truncatedCenterPoint, randomTruncatedPoint);
            this.height = Math.abs(centerPoint.get(THIRD_RADIX) - truncatedCenterPoint.get(THIRD_RADIX));
        }
    }

    public double getLength(ArrayList<Integer> centerPoint, ArrayList<Integer> randomPoint) {
        double length = 0;
        for (int i = 0; i < THREE_POINTS; i++) {
            length = length + Math.pow(centerPoint.get(i) - randomPoint.get(i), DEGREE);
        }
        return Math.sqrt(length);
    }

    @Override
    public boolean check() {
        if (this.pointSize == THREE_DIMENSIONAL_THREE_POINTS && this.radius > 0 && height <= radius) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    @Override
    public void area() {
        final int coefficient1 = 4;
        final int coefficient2 = 2;

        double area = coefficient1 * PI * Math.pow(radius, DEGREE) - coefficient2 * PI * radius * (radius - height) + PI * Math.pow(truncatedRadius, DEGREE);

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
