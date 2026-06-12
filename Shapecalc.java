// Common Interface for all shapes
interface Shape {
    double calculateArea();
}

// 1. Circle Class
class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// 2. Square Class
class Square implements Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

// 3. Rectangle Class
class Rectangle implements Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// 4. Triangle Class (Using Base and Height)
class Triangle implements Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main Class to Evaluate
public class Shapecalc {
    public static void main(String[] args) {
        
        // Array creating and inserting all geometric shapes
        Shape[] shapes = {
            new Circle(5),          // Radius = 5
            new Square(4),          // Side = 4
            new Rectangle(6, 4),    // Length = 6, Width = 4
            new Triangle(5, 8)      // Base = 5, Height = 8
        };

        double totalArea = 0;

        System.out.println("          SHAPE AREA EVALUATION              ");

        // Enhanced for-each loop to evaluate all shapes
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            totalArea += area;

            // %.2f use kiya hai taaki decimal ke baad sirf 2 digits print ho (clean output)
            System.out.printf("Shape: %-10s | Evaluated Area: %.2f\n", 
                    shape.getClass().getSimpleName(), area);
        }

        System.out.printf("Total Combined Area of All Shapes = %.2f\n", totalArea);
    }
}
