// defined shape interface 
interface Shape {
   double calculateArea();
}

// defined class based on shapes
class Circle implements Shape {
    double radius;
    
    // constructor
    Circle(double radius){
        this.radius = radius;
    }
    
    // method overriding
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    double side;
    
    // constructor
    Square(double side){
        this.side = side;
    }
    
    // method overriding
    public double calculateArea() {
        return side * side;
    }
}

public class Shapecalc {
    public static void main(String[] args) {
        
        // 1. Shape objects ka ek Array banaya
        Shape[] shapes = new Shape[4];
        
        // 2. Array mein different shapes store kiye (Polymorphism)
        shapes[0] = new Circle(5);
        shapes[1] = new Square(4);
        shapes[2] = new Circle(3);
        shapes[3] = new Square(6);

        // 3. Array ko evaluate karne ke liye loop chalaya aur total area calculate kiya
        double totalArea = 0;
        
        System.out.println("--- Individual Shapes Evaluation ---");
        for (int i = 0; i < shapes.length; i++) {
            double area = shapes[i].calculateArea();
            totalArea += area; // Total area add karne ke liye
            
            // shapes[i].getClass().getSimpleName() se class ka naam (Circle/Square) pata chalega
            System.out.println("Shape " + (i + 1) + " (" + shapes[i].getClass().getSimpleName() + ") Area = " + area);
        }
        
        System.out.println("------------------------------------");
        System.out.println("Total Area of all shapes = " + totalArea);
    }
}
