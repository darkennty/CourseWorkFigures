import figures.Circle;
import figures.Cone;
import figures.Cylinder;
import figures.Figure;
import figures.Parallelogram;
import figures.Polygon;
import figures.Rectangle;
import figures.Sphere;
import figures.Square;
import figures.Triangle;
import figures.Truncated_sphere;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();

        while (!command.equals("END")) {
            ArrayList<Integer> point = new ArrayList<>();

            switch (command) {
                case "CIRCLE" -> {
                    addRadix(scanner, point);
                    Circle circle = new Circle(point);
                    if (circle.check()) {
                        circle.perimeter();
                        circle.area();
                    }
                }
                case "CONE" -> {
                    addRadix(scanner, point);
                    Cone cone = new Cone(point);
                    if (cone.check()) {
                        cone.perimeter();
                        cone.area();
                    }
                }
                case "CYLINDER" -> {
                    addRadix(scanner, point);
                    Cylinder cylinder = new Cylinder(point);
                    if (cylinder.check()) {
                        cylinder.perimeter();
                        cylinder.area();
                    }
                }
                case "FIGURE" -> {
                    Figure figure = new Figure();
                    figure.check();
                    figure.perimeter();
                    figure.area();
                }
                case "PARALLELOGRAM" -> {
                    addRadix(scanner, point);
                    Parallelogram parallelogram = new Parallelogram(point);
                    if (parallelogram.check()) {
                        parallelogram.perimeter();
                        parallelogram.area();
                    }
                }
                case "POLYGON" -> {
                    addRadix(scanner, point);
                    Polygon polygon = new Polygon(point);
                    if (polygon.check()) {
                        polygon.perimeter();
                        polygon.area();
                    }
                }
                case "RECTANGLE" -> {
                    addRadix(scanner, point);
                    Rectangle rectangle = new Rectangle(point);
                    if (rectangle.check()) {
                        rectangle.perimeter();
                        rectangle.area();
                    }
                }
                case "SPHERE" -> {
                    addRadix(scanner, point);
                    Sphere sphere = new Sphere(point);
                    if (sphere.check()) {
                        sphere.perimeter();
                        sphere.area();
                    }
                }
                case "SQUARE" -> {
                    addRadix(scanner, point);
                    Square square = new Square(point);
                    if (square.check()) {
                        square.perimeter();
                        square.area();
                    }
                }
                case "TRIANGLE" -> {
                    addRadix(scanner, point);
                    Triangle triangle = new Triangle(point);
                    if (triangle.check()) {
                        triangle.perimeter();
                        triangle.area();
                    }
                }
                case "TRUNCATED_SPHERE" -> {
                    addRadix(scanner, point);
                    Truncated_sphere truncated = new Truncated_sphere(point);
                    if (truncated.check()) {
                        truncated.perimeter();
                        truncated.area();
                    }
                }
                default ->
                    System.out.println("Please, retype");
            }

            command = scanner.next();
        }
    }

    public static void addRadix(Scanner scanner, ArrayList<Integer> point) {
        String line = scanner.next();

        while (!line.equals("STOP_INPUT")) {
            Pattern p = Pattern.compile("(-)?\\d+");
            Matcher m = p.matcher(line);

            if (m.matches()) {
                point.add(Integer.parseInt(line));
            } else {
                System.out.println("Please, retype");
            }

            line = scanner.next();
        }
    }
}