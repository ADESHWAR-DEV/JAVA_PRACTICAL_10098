import java.util.Scanner;

// --- INHERITANCE & ENCAPSULATION ---
// Base class providing common properties and methods
abstract class Shape {
    private String name; // Encapsulated field

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to enforce implementation in subclasses
    public abstract double calculateArea();

    @Override
    public String toString() {
        return name;
    }
}

// --- INHERITANCE SUBCLASSES ---
// 1. Circle Class
class Circle extends Shape {
    private double radius; // Encapsulated

    public Circle(double radius) {
        super("Circle");
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// 2. Square Class
class Square extends Shape {
    private double side; // Encapsulated

    public Square(double side) {
        super("Square");
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive.");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// 3. Rectangle Class
class Rectangle extends Shape {
    private double length;
    private double width; // Encapsulated

    public Rectangle(double length, double width) {
        super("Rectangle");
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// 4. Triangle Class
class Triangle extends Shape {
    private double base;
    private double height; // Encapsulated

    public Triangle(double base, double height) {
        super("Triangle");
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and Height must be positive.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// --- MAIN CLASS ---
public class Shapecalc {
    // ARRAY CONCEPT: Fixed-size array instead of ArrayList
    private static final int MAX_SHAPES = 100;
    private static Shape[] shapeArray = new Shape[MAX_SHAPES];
    private static int shapeCount = 0; // Tracks current number of shapes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Enhanced Shape Calculator (OOP & Error Handling) ===");

        while (running) {
            try {
                System.out.println("\nSelect an option:");
                System.out.println("1. Add Circle");
                System.out.println("2. Add Square");
                System.out.println("3. Add Rectangle");
                System.out.println("4. Add Triangle");
                System.out.println("5. Calculate & Display Results");
                System.out.println("6. Exit");
                System.out.print("Enter choice (1-6): ");

                // ERROR HANDLING: Check if input is an integer
                if (!scanner.hasNextInt()) {
                    String invalidInput = scanner.next(); // Consume invalid input
                    throw new NumberFormatException("Invalid input '" + invalidInput + "'. Please enter a number.");
                }

                int choice = scanner.nextInt();

                // Check array bounds before adding
                if (shapeCount >= MAX_SHAPES && choice >= 1 && choice <= 4) {
                    System.out.println("Error: Maximum shape limit reached!");
                    continue;
                }

                switch (choice) {
                    case 1:
                        shapeArray[shapeCount++] = createCircle(scanner);
                        break;
                    case 2:
                        shapeArray[shapeCount++] = createSquare(scanner);
                        break;
                    case 3:
                        shapeArray[shapeCount++] = createRectangle(scanner);
                        break;
                    case 4:
                        shapeArray[shapeCount++] = createTriangle(scanner);
                        break;
                    case 5:
                        displayResults();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option! Please choose 1-6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Value Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Helper methods to handle input and creation with error handling
    private static Circle createCircle(Scanner scanner) {
        System.out.print("Enter radius: ");
        double r = getPositiveDouble(scanner);
        return new Circle(r);
    }

    private static Square createSquare(Scanner scanner) {
        System.out.print("Enter side length: ");
        double s = getPositiveDouble(scanner);
        return new Square(s);
    }

    private static Rectangle createRectangle(Scanner scanner) {
        System.out.print("Enter length: ");
        double l = getPositiveDouble(scanner);
        System.out.print("Enter width: ");
        double w = getPositiveDouble(scanner);
        return new Rectangle(l, w);
    }

    private static Triangle createTriangle(Scanner scanner) {
        System.out.print("Enter base: ");
        double b = getPositiveDouble(scanner);
        System.out.print("Enter height: ");
        double h = getPositiveDouble(scanner);
        return new Triangle(b, h);
    }

    // Helper to safely get positive double with retry logic
    private static double getPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                if (!scanner.hasNextDouble()) {
                    String invalid = scanner.next();
                    System.out.print("Invalid number '" + invalid + "'. Try again: ");
                    continue;
                }
                double val = scanner.nextDouble();
                if (val <= 0) {
                    System.out.print("Value must be positive. Try again: ");
                    continue;
                }
                return val;
            } catch (Exception e) {
                System.out.print("Error reading input. Try again: ");
                scanner.nextLine(); // Clear buffer
            }
        }
    }

    // Display all shapes and total area
    private static void displayResults() {
        if (shapeCount == 0) {
            System.out.println("No shapes entered yet.");
            return;
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println("          FINAL SHAPE EVALUATION              ");
        System.out.println("=".repeat(40));

        double totalArea = 0;
        for (int i = 0; i < shapeCount; i++) {
            Shape shape = shapeArray[i];
            double area = shape.calculateArea();
            totalArea += area;
            System.out.printf("%d. Shape: %-10s | Area: %.2f\n", i + 1, shape.getName(), area);
        }

        System.out.printf("\nTotal Area of All Shapes = %.2f\n", totalArea);
        System.out.println("=".repeat(40));
    }
}
