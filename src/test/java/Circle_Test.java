import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import figures.Circle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Circle_Test {
    private ArrayList<Integer> point = new ArrayList<>();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("Check Circle validity")
    public void checkCircleValidity() {
        point.add(0);
        point.add(0);
        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        boolean check = circle.check();
        then(check).isEqualTo(true);

        point.clear();
        point.add(10);
        point.add(10);
        point.add(100);
        point.add(100);

        circle = new Circle(point);

        check = circle.check();
        then(check).isEqualTo(true);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("Check Circle perimeter calculation")
    public void checkTwoDimensionalPerimeter() {
        point.add(0);
        point.add(0);
        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        circle.perimeter();

        assertEquals("6,28", output.toString().trim());
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

        assertEquals("6,28", output.toString().trim());
    }

    @Test
    @DisplayName("Check Circle area calculation")
    public void checkTwoDimensionalArea() {
        point.add(0);
        point.add(0);
        point.add(1);
        point.add(0);

        Circle circle = new Circle(point);

        circle.area();

        assertEquals("3,14", output.toString().trim());
    }

    @Test
    @DisplayName("Check Circle area calculation")
    public void checkThreeDimensionalArea() {

        point.clear();
        point.add(0);
        point.add(0);
        point.add(0);
        point.add(1);
        point.add(0);
        point.add(0);

        Circle circle = new Circle(point);

        circle.area();

        assertEquals("3,14", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
