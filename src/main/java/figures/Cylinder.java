package figures;

import java.util.ArrayList;

import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Cylinder extends Figure {

    private final ArrayList<Integer> bottomCenterPoint = new ArrayList<>();
    private final ArrayList<Integer> topCenterPoint = new ArrayList<>();
    private final ArrayList<Integer> randomPoint = new ArrayList<>();

    private final double pointSize;
    private double radius;
    private double height;

    public Cylinder (ArrayList<Integer> point) {
        this.pointSize = point.size();
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            for (int i = 0; i < this.pointSize; i++) {
                if (i < this.pointSize / THREE_POINTS) {
                    this.bottomCenterPoint.add(point.get(i));
                } else if (i < TWO_POINTS * this.pointSize / THREE_POINTS) {
                    this.topCenterPoint.add(point.get(i));
                } else {
                    this.randomPoint.add(point.get(i));
                }
            }
        }
    }

    @Override
    public boolean check() {
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            double radius1 = getLength(bottomCenterPoint, randomPoint);
            double radius2 = getLength(topCenterPoint, randomPoint);

            this.radius = Math.min(radius1, radius2);
            double hypotenuse = Math.max(radius1, radius2);
            this.height = getLength(bottomCenterPoint, topCenterPoint);

            if (hypotenuse == Math.sqrt(Math.pow(radius, DEGREE) + Math.pow(height, DEGREE))) {
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
    }
}
