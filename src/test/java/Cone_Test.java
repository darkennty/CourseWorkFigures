import figures.Cone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cone_Test {
    private ArrayList<Integer> point = new ArrayList<>();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("Check Cone validity")
    public void checkConeValidity() {
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

        point.clear();
        point.add(1);
        point.add(1);
        point.add(1);
        point.add(1);
        point.add(1);
        point.add(0);
        point.add(1);
        point.add(1);
        point.add(2);

        cone = new Cone(point);

        check = cone.check();
        then(check).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
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

        assertEquals("The figure has no perimeter", output.toString().trim());
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

        assertEquals("10,17", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
