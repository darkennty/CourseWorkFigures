import figures.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Triangle_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Triangle validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);

        Triangle triangle = new Triangle(point);

        boolean check = triangle.check();
        then(check).isEqualTo(true);

        point.clear();

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(10);
        point.add(10);
        point.add(10);

        point.add(1);
        point.add(1);
        point.add(10);

        triangle = new Triangle(point);

        check = triangle.check();

        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Triangle invalidity")
    public void checkInvalidity() {

        point.add(-1);
        point.add(-1);

        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);

        Triangle triangle = new Triangle(point);

        boolean check = triangle.check();
        then(check).isEqualTo(false);

        point.clear();

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(2);
        point.add(2);
        point.add(2);

        point.add(3);
        point.add(3);
        point.add(3);

        triangle = new Triangle(point);

        check = triangle.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Triangle perimeter calculation")
    public void checkPerimeterCalculation() {
        point.add(0);
        point.add(0);

        point.add(5);
        point.add(10);

        point.add(10);
        point.add(0);

        Triangle triangle = new Triangle(point);

        triangle.perimeter();
        then(triangle.getPerimeter()).isEqualTo(32.36);

        point.clear();

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(5);

        triangle = new Triangle(point);

        triangle.perimeter();
        then(triangle.getPerimeter()).isEqualTo(11.10);
    }

    @Test
    @DisplayName("Check Triangle area calculation")
    public void checkAreaCalculation() {

        point.add(0);
        point.add(0);

        point.add(5);
        point.add(10);

        point.add(10);
        point.add(0);

        Triangle triangle = new Triangle(point);

        triangle.area();
        then(triangle.getArea()).isEqualTo(50.00);

        point.clear();

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(5);

        triangle = new Triangle(point);

        triangle.area();
        then(triangle.getArea()).isEqualTo(2.50);
    }
}
