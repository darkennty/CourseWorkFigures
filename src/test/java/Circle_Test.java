import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import figures.Circle;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Circle_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Circle validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        boolean check = circle.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Circle validity")
    public void checkAnotherValidity() {

        point.add(10);
        point.add(10);

        point.add(100);
        point.add(100);

        Circle circle = new Circle(point);

        boolean check = circle.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check two-dimensional Circle perimeter calculation")
    public void checkTwoDimensionalPerimeter() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        circle.perimeter();

        then(circle.getPerimeter()).isEqualTo(6.28);
    }

    @Test
    @DisplayName("Check three-dimensional Circle perimeter calculation")
    public void checkThreeDimensionalPerimeter() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        Circle circle = new Circle(point);

        circle.perimeter();

        then(circle.getPerimeter()).isEqualTo(6.28);
    }

    @Test
    @DisplayName("Check two-dimensional Circle area calculation")
    public void checkTwoDimensionalArea() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        circle.area();

        then(circle.getArea()).isEqualTo(3.14);
    }

    @Test
    @DisplayName("Check three-dimensional Circle area calculation")
    public void checkThreeDimensionalArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        Circle circle = new Circle(point);

        circle.area();

        then(circle.getArea()).isEqualTo(3.14);
    }
}
