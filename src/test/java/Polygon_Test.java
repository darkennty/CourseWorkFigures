import figures.Polygon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Polygon_Test {

    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Polygon validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(2);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(2);
        point.add(0);

        point.add(0);
        point.add(2);
        point.add(0);

        Polygon polygon = new Polygon(point);

        boolean check = polygon.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Polygon validity")
    public void checkAnotherValidity() {

        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);

        point.add(1);
        point.add(1);

        point.add(1);
        point.add(0);

        Polygon polygon = new Polygon(point);

        boolean check = polygon.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Polygon invalidity")
    public void checkInvalidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(2);
        point.add(2);
        point.add(2);

        point.add(3);
        point.add(3);
        point.add(3);

        Polygon polygon = new Polygon(point);

        boolean check = polygon.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Polygon perimeter calculation")
    public void checkPerimeterCalculation() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(2);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(2);
        point.add(0);

        point.add(0);
        point.add(2);
        point.add(0);

        Polygon polygon = new Polygon(point);

        polygon.perimeter();
        then(polygon.getPerimeter()).isEqualTo(6.83);
    }

    @Test
    @DisplayName("Check Polygon area calculation")
    public void checkAreaCalculation() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(2);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(2);
        point.add(0);

        point.add(0);
        point.add(2);
        point.add(0);

        Polygon polygon = new Polygon(point);

        polygon.area();
        then(polygon.getArea()).isEqualTo(3.00);
    }
}
