// defined shape interface 
interface Shape {
   double calculateArea();
}
// defined class based on shapes
class Circle implements  Shape {
    double radius;
    // constructor
    Circle(double radius){
        this.radius = radius;
    }
    // method 
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
    // method overloading
    public double calculateArea() {
        return side * side;
    }
}

public class Shapecalc {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Square(4);

        System.out.println("Area of Circle = " + s1.calculateArea());
        System.out.println("Area of Square = " + s2.calculateArea());
    }
}
