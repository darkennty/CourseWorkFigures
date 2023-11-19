package figures;

import java.util.ArrayList;

import static consts.Consts.TWO_POINTS;
import static consts.Consts.THREE_POINTS;
import static consts.Consts.THREE_DIMENSIONAL_THREE_POINTS;
import static consts.Consts.DEGREE;
import static consts.Consts.PI;

public class Cone extends Figure {

    private final ArrayList<Integer> centerPoint = new ArrayList<>();
    private final ArrayList<Integer> randomPoint = new ArrayList<>();
    private final ArrayList<Integer> topPoint = new ArrayList<>();

    private final double pointSize;

    public Cone (ArrayList<Integer> point) {
        this.pointSize = point.size();
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            for (int i = 0; i < this.pointSize; i++) {
                if (i < THREE_POINTS) {
                    this.centerPoint.add(point.get(i));
                } else if (i < TWO_POINTS * this.pointSize / THREE_POINTS) {
                    this.randomPoint.add(point.get(i));
                } else {
                    this.topPoint.add(point.get(i));
                }
            }
        }

    }

    @Override
    public boolean check() {
        if (pointSize == THREE_DIMENSIONAL_THREE_POINTS) {
            double osnovaniye = getLength(centerPoint, randomPoint);
            double height = getLength(centerPoint, topPoint);
            double hypotenuse = getLength(randomPoint, topPoint);
            if (hypotenuse == Math.sqrt(Math.pow(osnovaniye, DEGREE) + Math.pow(height, DEGREE))) {
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
        double radius = getLength(centerPoint, randomPoint);
        double generatrix = getLength(randomPoint, topPoint);
        double area = PI * radius * generatrix + PI * Math.pow(radius, DEGREE);
        System.out.printf("%.2f\n", area);
    }
}
