package figures;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Cylinder extends Figure {
    private final double pointSize;
    private double radius;
    private double hypotenuse;
    private double height;
    private double area;

    public Cylinder (ArrayList<Integer> point) {
        ArrayList<Integer> bottomCenterPoint = new ArrayList<>();
        ArrayList<Integer> topCenterPoint = new ArrayList<>();
        ArrayList<Integer> randomPoint = new ArrayList<>();

        this.pointSize = point.size();
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            for (int i = 0; i < this.pointSize; i++) {
                if (i < this.pointSize / THREE_POINTS) {
                    bottomCenterPoint.add(point.get(i));
                } else if (i < TWO_POINTS * this.pointSize / THREE_POINTS) {
                    topCenterPoint.add(point.get(i));
                } else {
                    randomPoint.add(point.get(i));
                }
            }

            double radius1 = getLength(bottomCenterPoint, randomPoint);
            double radius2 = getLength(topCenterPoint, randomPoint);

            this.radius = Math.min(radius1, radius2);
            this.hypotenuse = Math.max(radius1, radius2);
            this.height = getLength(bottomCenterPoint, topCenterPoint);
        }
    }

    @Override
    public boolean check() {
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {

            hypotenuse = Math.round(hypotenuse * 100.0) / 100.0;
            double result = Math.round(Math.sqrt(Math.pow(radius, DEGREE) + Math.pow(height, DEGREE)) * 100.0) / 100.0;

            if (hypotenuse == result) {
                System.out.println("The figure is valid");
                return true;
            } else {
                System.out.println("The figure is invalid");
                return false;
            }
        } else {
            System.out.println("The figure is invalid");
            return false;
        }
    }

    public double getLength(ArrayList<Integer> point1, ArrayList<Integer> point2) {
        double length = 0;
        for (int i = 0; i < THREE_POINTS; i++) {
            length = length + Math.pow(point1.get(i) - point2.get(i), DEGREE);
        }
        return Math.sqrt(length);
    }

    @Override
    public void area() {
        final int areaConst = 2;
        double area = areaConst * PI * this.radius * this.height + areaConst * PI * Math.pow(this.radius, DEGREE);

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
