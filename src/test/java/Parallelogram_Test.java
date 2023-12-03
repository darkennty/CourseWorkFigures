import figures.Parallelogram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
public class Parallelogram_Test {
    private final ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Parallelogram validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        boolean check = parallelogram.check();
        then(check).isEqualTo(true);

        point.clear();

        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);

        point.add(1);
        point.add(1);

        point.add(1);
        point.add(0);

        parallelogram = new Parallelogram(point);

        check = parallelogram.check();
        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Parallelogram invalidity")
    public void checkInvalidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        boolean check = parallelogram.check();
        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Parallelogram perimeter calculation")
    public void checkPerimeter() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        parallelogram.perimeter();

        then(parallelogram.getPerimeter()).isEqualTo(4.00);
    }

    @Test
    @DisplayName("Check Parallelogram perimeter calculation")
    public void checkAnotherPerimeter() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(2);
        point.add(2);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        parallelogram.perimeter();

        then(parallelogram.getPerimeter()).isEqualTo(6.29);
    }

    @Test
    @DisplayName("Check Parallelogram area calculation")
    public void checkArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(0);

        point.add(1);
        point.add(0);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        parallelogram.area();

        then(parallelogram.getArea()).isEqualTo(1.00);
    }

    @Test
    @DisplayName("Check Parallelogram area calculation")
    public void checkAnotherArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(1);
        point.add(1);
        point.add(1);

        point.add(2);
        point.add(2);
        point.add(1);

        point.add(1);
        point.add(1);
        point.add(0);

        Parallelogram parallelogram = new Parallelogram(point);

        parallelogram.area();

        then(parallelogram.getArea()).isEqualTo(1.41);
    }
}