import figures.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Square_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Square validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);

        point.add(0);
        point.add(1);

        Square square = new Square(point);

        boolean check = square.check();
        then(check).isEqualTo(true);

        point.clear();

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(1);

        square = new Square(point);

        check = square.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Square invalidity")
    public void checkInvalidity() {
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);

        point.add(2);
        point.add(1);

        point.add(2);
        point.add(0);

        Square square = new Square(point);

        boolean check = square.check();
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
        point.add(1);

        point.add(2);
        point.add(2);
        point.add(0);

        square = new Square(point);

        check = square.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Square perimeter calculation")
    public void checkPerimeterCalculation() {
        point.add(0);
        point.add(0);

        point.add(5);
        point.add(0);

        point.add(5);
        point.add(5);

        point.add(0);
        point.add(5);

        Square square = new Square(point);

        square.perimeter();
        then(square.getPerimeter()).isEqualTo(20.00);

        point.clear();

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(1);

        square = new Square(point);

        square.perimeter();
        then(square.getPerimeter()).isEqualTo(8.00);
    }

    @Test
    @DisplayName("Check Square area calculation")
    public void checkAreaCalculation() {

        point.add(0);
        point.add(0);

        point.add(5);
        point.add(0);

        point.add(5);
        point.add(5);

        point.add(0);
        point.add(5);

        Square square = new Square(point);

        square.area();
        then(square.getArea()).isEqualTo(25.00);

        point.clear();

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(3);

        point.add(3);
        point.add(1);
        point.add(1);

        square = new Square(point);

        square.area();
        then(square.getArea()).isEqualTo(4.00);
    }
}
