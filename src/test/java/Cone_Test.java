import figures.Cone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Cone_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Cone validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(1);

        Cone cone = new Cone(point);

        boolean check = cone.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Cone invalidity")
    public void checkInvalidity() {
        point.add(1);
        point.add(1);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(2);

        Cone cone = new Cone(point);

        boolean check = cone.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Cone perimeter calculation")
    public void checkPerimeter() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(2);

        Cone cone = new Cone(point);

        cone.perimeter();

        then(cone.getPerimeter()).isEqualTo("The figure has no perimeter");
    }

    @Test
    @DisplayName("Check Cone area calculation")
    public void checkArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(2);

        Cone cone = new Cone(point);

        cone.area();

        then(cone.getArea()).isEqualTo(10.17);
    }
}
