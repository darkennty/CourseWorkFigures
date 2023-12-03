import figures.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Rectangle_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Rectangle validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        point.add(1);
        point.add(10);

        point.add(0);
        point.add(10);

        Rectangle rectangle = new Rectangle(point);

        boolean check = rectangle.check();
        then(check).isEqualTo(true);

        point.clear();

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(0);

        rectangle = new Rectangle(point);

        check = rectangle.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Rectangle invalidity")
    public void checkInvalidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);

        point.add(2);
        point.add(1);

        point.add(2);
        point.add(0);

        Rectangle rectangle = new Rectangle(point);

        boolean check = rectangle.check();
        then(check).isEqualTo(false);

        point.clear();

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

        rectangle = new Rectangle(point);

        check = rectangle.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Rectangle perimeter calculation")
    public void checkPerimeterCalculation() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        point.add(1);
        point.add(10);

        point.add(0);
        point.add(10);

        Rectangle rectangle = new Rectangle(point);

        rectangle.perimeter();
        then(rectangle.getPerimeter()).isEqualTo(22.00);

        point.clear();

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(0);

        rectangle = new Rectangle(point);

        rectangle.perimeter();
        then(rectangle.getPerimeter()).isEqualTo(34.14);
    }

    @Test
    @DisplayName("Check Rectangle area calculation")
    public void checkAreaCalculation() {

        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        point.add(1);
        point.add(10);

        point.add(0);
        point.add(10);

        Rectangle rectangle = new Rectangle(point);

        rectangle.area();
        then(rectangle.getArea()).isEqualTo(10.00);

        point.clear();

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(10);

        point.add(5);
        point.add(5);
        point.add(0);

        rectangle = new Rectangle(point);

        rectangle.area();
        then(rectangle.getArea()).isEqualTo(70.71);
    }
}
