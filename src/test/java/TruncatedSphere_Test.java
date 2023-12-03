import figures.TruncatedSphere;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphere_Test {
    private ArrayList<Integer> point = new ArrayList<>();

    @Test
    @DisplayName("Check Truncated sphere validity")
    public void checkValidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(10);
        point.add(0);
        point.add(0);

        TruncatedSphere tSphere = new TruncatedSphere(point);

        boolean check = tSphere.check();

        then(check).isEqualTo(true);
    }

    @Test
    @DisplayName("Check Truncated sphere invalidity")
    public void checkInvalidity() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(0);
        point.add(0);
        point.add(-100);

        TruncatedSphere tSphere = new TruncatedSphere(point);

        boolean check = tSphere.check();

        then(check).isEqualTo(false);
    }

    @Test
    @DisplayName("Check Truncated sphere perimeter")
    public void checkPerimeter() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(10);
        point.add(0);
        point.add(0);

        TruncatedSphere tSphere = new TruncatedSphere(point);

        tSphere.perimeter();

        then(tSphere.getPerimeter()).isEqualTo("The figure has no perimeter");
    }

    @Test
    @DisplayName("Check Truncated sphere area")
    public void checkArea() {
        point.add(0);
        point.add(0);
        point.add(0);

        point.add(0);
        point.add(0);
        point.add(10);

        point.add(10);
        point.add(0);
        point.add(0);

        TruncatedSphere tSphere = new TruncatedSphere(point);

        tSphere.area();

        then(tSphere.getArea()).isEqualTo(942.48);
    }
}
