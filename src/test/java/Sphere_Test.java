import figures.Sphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class Sphere_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Sphere validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(1);

        Sphere sphere = new Sphere(point);

        boolean check = sphere.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Sphere invalidity")
    public void checkInvalidity() {

        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(0);

        Sphere sphere = new Sphere(point);

        boolean check = sphere.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Sphere perimeter calculation")
    public void checkPerimeter() {
        point.add(9);
        point.add(8);
        point.add(7);

        point.add(3);
        point.add(3);
        point.add(3);

        Sphere sphere = new Sphere(point);

        sphere.perimeter();

        then(sphere.getPerimeter()).isEqualTo("The figure has no perimeter");
    }

    @Test
    @DisplayName("Check Sphere area calculation")
    public void checkArea() {
        point.add(5);
        point.add(4);
        point.add(3);

        point.add(3);
        point.add(3);
        point.add(3);

        Sphere sphere = new Sphere(point);

        sphere.area();

        then(sphere.getArea()).isEqualTo(62.83);
    }
}
