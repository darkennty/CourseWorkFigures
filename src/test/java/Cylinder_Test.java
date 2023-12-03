import figures.Cylinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Cylinder_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Cylinder validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(1);

        Cylinder cylinder = new Cylinder(point);

        boolean check = cylinder.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Cylinder invalidity")
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

        Cylinder cylinder = new Cylinder(point);

        boolean check = cylinder.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Cylinder perimeter calculation")
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

        Cylinder cylinder = new Cylinder(point);

        cylinder.perimeter();

        then(cylinder.getPerimeter()).isEqualTo("The figure has no perimeter");
    }

    @Test
    @DisplayName("Check Cylinder area calculation")
    public void checkArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(1);

        Cylinder cylinder = new Cylinder(point);

        cylinder.area();

        then(cylinder.getArea()).isEqualTo(21.45);
    }
}