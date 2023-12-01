import figures.Cylinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cylinder_Test {
    private ArrayList<Integer> point = new ArrayList<>();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("Check Cylinder validity")
    public void checkCylinderValidity() {
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

        cylinder = new Cylinder(point);

        check = cylinder.check();
        then(check).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
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

        assertEquals("The figure has no perimeter", output.toString().trim());
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

        assertEquals("21,45", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}