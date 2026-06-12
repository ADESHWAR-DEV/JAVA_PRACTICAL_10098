import java.util.ArrayList;
import java.util.Scanner;

// Common Interface
interface Shape {
    double calculateArea();
}

// 1. Circle Class
class Circle implements Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
    @Override public double calculateArea() { return Math.PI * radius * radius; }
}

// 2. Square Class
class Square implements Shape {
    double side;
    Square(double side) { this.side = side; }
    @Override public double calculateArea() { return side * side; }
}

// 3. Rectangle Class
class Rectangle implements Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    @Override public double calculateArea() { return l * w; }
}

// 4. Triangle Class
class Triangle implements Shape {
    double b, h;
    Triangle(double b, double h) { this.b = b; this.h = h; }
    @Override public double calculateArea() { return 0.5 * b * h; }
}

// Main Generic Calculator Class
public class UniversalShapeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.in);
        // ArrayList use kiya taaki user "any number of shapes" add kar sake
        ArrayList<Shape> shapeList = new ArrayList<>();
        
        System.out.println("=== Welcome to Any-Shape Calculator ===");
        
        while (true) {
            System.out.println("\nKaun sa shape add karna chahte hain?");
            System.out.println("1. Circle\n2. Square\n3. Rectangle\n4. Triangle\n5. Bas aur nahi! Evaluation karo.");
            System.out.print("Apna option chuniye (1-5): ");
            
            int choice = scanner.nextInt();
            
            if (choice == 5) {
                break; // Loop se bahar nikalne ke liye
            }
            
            switch (choice) {
                case 1:
                    System.out.print("Circle ka Radius enter karein: ");
                    double r = scanner.nextDouble();
                    shapeList.add(new Circle(r));
                    break;
                case 2:
                    System.out.print("Square ki Side enter karein: ");
                    double s = scanner.nextDouble();
                    shapeList.add(new Square(s));
                    break;
                case 3:
                    System.out.print("Rectangle ki Length aur Width enter karein (space dekar): ");
                    double l = scanner.nextDouble();
                    double w = scanner.nextDouble();
                    shapeList.add(new Rectangle(l, w));
                    break;
                case 4:
                    System.out.print("Triangle ka Base aur Height enter karein (space dekar): ");
                    double b = scanner.nextDouble();
                    double h = scanner.nextDouble();
                    shapeList.add(new Triangle(b, h));
                    break;
                default:
                    System.out.println("Invalid option! Kripya 1 se 5 ke beech chunein.");
            }
        }
        
        // --- FINAL EVALUATION ---
        System.out.println("          FINAL SHAPE EVALUATION              ");
        
        double totalArea = 0;
        int count = 1;
        
        for (Shape shape : shapeList) {
            double area = shape.calculateArea();
            totalArea += area;
            System.out.printf("%d. Shape: %-10s | Calculated Area: %.2f\n", 
                    count++, shape.getClass().getSimpleName(), area);
        }

        System.out.printf("Total Area of All Entered Shapes = %.2f\n", totalArea);
        
        scanner.close();
    }
}
